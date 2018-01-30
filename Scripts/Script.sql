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
-- procedure
delimiter $$
create procedure gera_fatura(in `valor_fatura` double, in `tp_fatura` varchar(50))
	begin
		INSERT INTO `fatura` (`valor`,`dataDaFatura`, `vl_multa`,`stats`, `tp_fatura`) VALUES (`valor_fatura`, curdate(), 0, 'Em andamento', `tp_fatura`);
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
create trigger atualiza_pedido before update on `pedido_servico`
for each row
begin
	if new.dt_execucao <= curdate() then
		set new.status_pedido = 1;
    end if;
end
$$


delimiter $$
	create procedure retorna_idade(in anos int, out b int)
		begin select year(now()) - anos into b;
	end;
$$

delimiter $$
create trigger idade_em_anos before update on `animal`
for each row
begin
	call retorna_idade(year(new.dt_nasc), @idad);
	set new.idade = @idad;
end
$$




