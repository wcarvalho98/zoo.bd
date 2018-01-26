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
 end$$
 delimiter ;
