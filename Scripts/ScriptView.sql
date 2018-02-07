create or replace view vtratamento as select A.nome as 'animal', F.Nome as  'veterinário', C.dat_consulta as 'data da consulta', 
D.descricao as 'doença', M.nome as 'medicamento', P.posologia as 'posologia', T.data_inicio as 'inicio do tratamento', 
T.data_fim as 'fim do tratamento' from animal A join 
consulta C on A.id = C.id_animal join funcionario F on C.id_veterinario = F.CPF join tratamento T on C.id_consulta = T.id_consulta
join prescricao P on T.id_tratamento = P.id_tratamento join Medicamento M on P.id_medicamento = M.id_medicamento join trata TR on
TR.id_medicamento = M.id_medicamento join doenca D on D.id_doenca = TR.id_doenca;


create or replace view vpedido_servico as select P.id as 'pedido', P.dt_pedido as 'data de abertura', P.status_pedido as 'status do pedido', 
P.dt_execucao as 'data de execução', P.vl_total as 'valor total', S.descr as 'serviço', 
I.status_item as 'status do item', I.vl_unitario as 'valor unitário', I.dt_realizacao as 'data de realização',
E.CNPJ as 'empresa terceira', F.idFatura as 'fatura', F.valor as 'valor da fatura' from
pedido_servico P join item_servico I on P.id = I.idPed join servico S on I.idServ = S.id join presta PR on PR.idServ = S.id join
empresa_terceira E on PR.CNPJEmprTerc = E.CNPJ join fatura F on P.id = F.id_ped_serv;