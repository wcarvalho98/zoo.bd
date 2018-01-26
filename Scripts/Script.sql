delimiter $$
create definer = `roat`@`localhost` function oferta (idServico int, prazo date) returns bool
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
	declare `retorno` date;
	declare `dia_disponivel` date default curdate();
	select dt_reserva into `retorno` from reserva where `id_espaco` = reserva.id_espaco;
	if `dia_disponivel`!= `retorno` then
		return `dia_disponivel`;
	else 
		while `dia_disponivel` = `retorno` do
			set `dia_disponivel` = adddate(`dia_disponivel`, 1);
		end while;
		return `dia_disponivel`;
	end if;
 end
$$

delimiter $$
create procedure gera_fatura(in `valor_fatura` double, in `tp_fatura` varchar(50))
	begin
		INSERT INTO `fatura` (`valor`,`dataDaFatura`, `vl_multa`,`stats`, `tp_fatura`) VALUES (`valor_fatura`, curdate(), 0, 'Em andamento', `tp_fatura`);
    end
$$

delimiter $$
create trigger atualiza_estoque after update on `item_estoque`
for each row
begin
	update `produto_ref` set `qtd_total_estoque` = new.qtd, `preco_ult_compra` = new.vl_compra
    where cod = new.cod_prod_ref;
end
$$