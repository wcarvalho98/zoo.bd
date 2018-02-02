-- Functions
delimiter $$
create function oferta (idServico int, prazo date) returns bool
 begin
	declare val1 date;
	select dt_fim into val1 from presta where idServ = idServico;
    if prazo <= val1 then
		return true;
	else
		return false;
	end if;
 end
$$

delimiter $$
create function disponivel_espaco (`id_espaco` int) returns date
 begin
	declare `retorno_reserva` date;
    declare `retorno_validade` date;
	declare `dia_disponivel` date default curdate();
	select dt_validade into `retorno_validade` from reserva where `id_espaco` = reserva.id_espaco;
    select dt_reserva into `retorno_reserva` from reserva where `id_espaco` = reserva.id_espaco;
	if `dia_disponivel` < `retorno_reserva` or `dia_disponivel` > `retorno_validade` then
		return `dia_disponivel`;
	else
		set `dia_disponivel` = adddate(`retorno_validade`, 1);
		return `dia_disponivel`;
	end if;
 end
$$

delimiter $$
create function jaula_livre (idespecie int)
	returns bool
begin
	declare done int default 0;
	declare res int default false;
	declare maximo int;
	declare jaula int;
	declare quant int;
	declare especie int;
	declare ind_cur cursor for select id_jaula, seq from especie_indicada;
	declare continue handler for not found set done = 1;

	open ind_cur;
	repeat
		fetch ind_cur into jaula, especie;
		if especie = idespecie then
			SET maximo = (select populacao_max from jaula where id_jaula = jaula);
			SET quant = (select COUNT(id_jaula) from animal where id_jaula = jaula);
			if quant < maximo then
				SET res = 1;
				SET done = 1;
			end if;
		end if;
	until done
	end repeat;

	close ind_cur;

	return res;
end 
$$

-- procedure
delimiter $$
create procedure gera_fatura(in `valor_fatura` double, in `tp_fatura` varchar(50), in `id_ped_serv` int)
	begin
		INSERT INTO `fatura` (`valor`,`dataDaFatura`, `vl_multa`,`stats`, `tp_fatura`, `id_ped_serv`) VALUES (`valor_fatura`, curdate(), 0, 'Em andamento', `tp_fatura`, `id_ped_serv`);
    end
$$

delimiter $$
create procedure vai_vencer(in N int)
begin
	declare data_futura date;
	set data_futura = DATE_ADD(curdate(), interval N day);
	select * from item_estoque where  data_validade >= curdate() and data_validade <= data_futura; 
end
$$

delimiter $$
	create procedure retorna_idade(in anos int, out b int)
		begin select year(now()) - anos into b;
	end;
$$

delimiter $$
create procedure checkCate (in idS int, in idC int, out retorno bool)
begin 
	declare `val` int;
	select categ into val from sub_categoria where cod = `idS`;
    if (`val` = `idC`) then
		set `retorno` = true;
	else
		set `retorno` = false;
	end if;
end
$$

-- triggers
delimiter $$
create trigger atualiza_estoque after update on `item_estoque`
for each row
begin
	update `produto_ref` set `qtd_total_estoque` = new.qtd, `preco_ult_compra` = new.vl_compra
    where cod = new.cod_prod_ref;
end
$$

delimiter $$
create trigger atualiza_pedido before update on `pedido_servico`
for each row
begin
	if new.dt_execucao <= curdate() then
		set new.status_pedido = 1;
    end if;
end
$$

delimiter $$
create trigger idade_em_anos before insert on `animal`
for each row
begin
	call retorna_idade(year(new.dt_nasc), @idad);
	set new.idade = @idad;
end
$$


delimiter $$
create trigger checkCateSub before insert on `Produto_ref`
for each row
begin
	declare `retorno` bool;
	call checkCate (new.subcat, new.categ, `retorno`);
    if (`retorno` = 0) then
		signal sqlstate '45000' set message_text = 'Subcategoria de produto não pertence a essa Categoria', MYSQL_ERRNO = 1000; 
    end if;
end
$$