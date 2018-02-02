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

delimiter $$

create procedure vai_vencer(in N int)
begin
	declare data_futura date;
	set data_futura = DATE_ADD(curdate(), interval N day);
	select * from item_estoque where  data_validade >= curdate() and data_validade <= data_futura; 
end
$$

delimiter $$
create trigger atualiza_pedido before update on pedido_servico
for each row
begin
	if new.dt_execucao <= curdate() then
		set new.status_pedido = 1;
    end if;
end
$$