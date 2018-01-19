use zoologico;
insert into Zoologico (idZoo,cnpj,nome,razao_social, hr_inic_func, hr_fim) VALUES (1, '12345678910123', 'Zootropia', 'sociável', '08:00:00', '20:00:00');

insert into fones(idZoo, numero) VALUES (1, '81-3255-9988'), (1, '81-3433-9988'), (1,'81-3333-8888');    

#insert into docs (idZoo, idDocs, docs) values (1,1, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste.txt")),
#											  (1,2, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste1.txt")),
#                                              (1,3, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste2.txt")),
#                                              (1,4, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste3.txt")),
#                                              (1,5, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste4.txt"));
    
insert into licenca (id_licenca, descr, data_de_expiracao, idZoo) VALUES (1,'licença dos bombeiros', '2015-04-12', 1),
                                                                         (2,'licença dos macacos albinos', '2011-02-12', 1),
                                                                         (3,'licença do parque dos animais silvestres', '2014-03-12', 1),
                                                                         (4,'licença da praça de alimentação', '2016-05-14', 1),
                                                                         (5,'licença dos tubarões', '2017-07-12', 1),
                                                                         (6,'licença teste1', '2016-06-19', 1),
                                                                         (7,'licença teste2', '2012-08-19', 1);

insert into Jornada_De_Trabalho (id, trabalha_sabado, descr) VALUES (1, true, 'Limpeza'),(2, true, 'blabla'), (3, false, 'teste'), (4, true, 'blablabla'),
                                                                    (5, false, 'okok'),  (6, false, 'amor'), (7, true, 'odio');

insert into Dia VALUES (1,'descricaoTeste' ), (2, 'descricaoTeste'), (3,'descricaoTeste' ), (4,'descricaoTeste' ), (5, 'descricaoTeste'), (6, 'descricaoTeste'), (7, 'descricaoTeste'); 

insert into Turno VALUES (1,'descricaoTeste', '06:00:00', '22:00:00'), (2,'descricaoTeste','10:00:00', '19:00:00' ), (3,'descricaoTeste', '08:00:00', '20:00:00' ), (4,'descricaoTeste', '08:00:00', '12:00:00' ), (5,'descricaoTeste','12:00:00', '20:00:00' ),
						 (6, 'descricaoTeste','16:00:00', '20:00:00'), (7,'descricaoTeste','18:00:00', '20:00:00' ), (8,'descricaoTeste','20:00:00', '23:00:00' ), (9,'descricaoTeste', '10:00:00', '14:00:00'), (10,'descricaoTeste', '00:00:00', '06:00:00' );

insert into Tem (cod, seq, id) VALUES (1,1,1), (1,2,1), (2,2,4), (5,6,7), (2,5,6);

insert into Funcionario (cpf, nome, especializacao, fone_1, fone_2, data_de_contratacao, salario, ender, jornada_trabalho, idZoo) VALUES
 ('00011122233', 'Joao Feijao', 'Tratador', '8199764453', '81993673657', '1990-01-04', 990, 'Rua dos poderes, N122', 7, 1), 
 ('01201234578', 'Maria Faria', 'Tratador', '8199764400', '81997323657', '1995-11-05', 1200, 'Rua das vielas, N552', 7, 1),
 ('02335553324', 'Pedro Ferrero', 'Tratador', '81992362153', '81993973587', '2001-11-25', 790, 'Rua dos moradores, N129', 7, 1), 
 ('02123521356', 'Carlos Baratos', 'Tratador', '81973691537', '81916382648', '1998-06-14', 990, 'Rua dos povoados, N5542', 7, 1),
 ('01134566299', 'Bonifacio Alado', 'Tratador', '81963715380', '81977531947', '2008-07-29', 990, 'Rua dos poderes, N12', 7, 1),
 ('43221775479', 'Eduardo Do Mato', 'Veterinário',  '81981264690', '81967916358', '2004-01-25', 3500, 'Rua do rei do gado, N32', 7, 1),
 ('02244715739', 'Janaína Vacina', 'Veterinário', '81971439462', '81922956158', '2013-03-15', 4150, 'Rua das Rimas, N424', 7, 1), 
 ('01439264834', 'Fernando Do Campo', 'Veterinário', '81991284569', '8196545529', '2009-09-24', 4000, 'Rua das felicidades, N72', 7, 1),
 ('52135800926', 'Afonso Alonso', 'Veterinário', '81997310353', '81991234212', '1999-08-16', 3970, 'Rua das Avenidas, N152', 7, 1),
 ('00776353689', 'Alan Maçã', 'Secretário', '81997644453', '81993973257', '1997-03-02', 3480, 'Rua dos santos, N1', 7, 1), 
 ('20953275944', 'Paulo Arado', 'Secretário', '81977653327', '81923689943','1998-11-14', 2300, 'Rua dos loucos, N2', 7, 1),
 ('09953268944', 'Valeska Reyness', 'Tratador', '81324232422', '81899767872','1993-12-11', 3000, 'Rua dos pirados, N2', 7, 1),
 ('04554245944', 'João ricardo', 'Administrador', '81977555527', '819234349943','2000-01-04', 2500, 'Rua paraíso, aq2', 7, 1);

insert into Curso (id, descr, carga_hor, tipo) VALUES 
 (1, "Biologia", 60, "Biologicas"),
 (2, "Controle de zoonose", 45, "controle"),
 (3, "Botânica", 30, "Botânica"),
 (4, "tratador", 60, "biologicas");
 
 insert into faz (id, cpf, dt_inicio) VALUES
  (1,"52135800926" ,'2013-01-15'),
  (2,"09953268944" ,'2011-04-11'),
  (3,"09953268944" ,'2000-02-24'),
  (4,"52135800926" ,'2009-01-12');

INSERT INTO `administrador` (`cpf`,`senha_de_acesso`,`idZoo`,`login`) VALUES ('04554245944','admin',1,'admin');

insert into func_tratador(cpf, situacao) Values
  ("01134566299", null),
  ("02123521356", null),
  ("02335553324", null),
  ("01201234578", null),
  ("00011122233", null),
  ("09953268944", null);

insert into func_secretario(cpf) Values
  ("20953275944"), ("00776353689");

insert into bilheteria (idBilheteria, total_inteira, total_meia, total_cortesia, status_bilheteria, data_bilheteria, renda_do_dia, hr_abertura, duracao, hr_fecha, idZoo) VALUES
                         (1, 20.0,10.0, 5.0, true, '2009-12-09',null, null, null, null, 1),
                         (2, 12.0,6.0, 5.0, false, '2010-09-01',null, null, null, null, 1),
                         (3, 21.0,10.5, 5.0, true, '2011-03-23',null, null, null, null, 1);
                          
insert into trabalha (idBilheteria, cpf_secretario, data_trab) VALUES 
					 (1, "00776353689", '2011-03-23');
                     
insert into veterinario (CPF, estado, CRMV) VALUES ("52135800926", 'PE', '1073'), ("01439264834", 'PB', '8899'),("02244715739", 'AL', '1234'),("43221775479", 'RJ', '2341');

insert into ponto (cpf, data_hora_inicial, data_hora_fim, faltou) VALUES 
				  ("01134566299", '2018-01-16T10:25:00','2018-01-16T15:25:00',false),
                  ("02123521356", '2018-01-16T15:25:00','2018-01-16T20:25:00', false),
                  ("02335553324", '2018-01-16T11:00:00', '2018-01-16T18:25:00', false);

insert into Jaula (id_Jaula,  stats, tipo, dt_ultima_inspecao, populacao_max, obs, perid_insp_dias, altura, largura, profundidade, idZoo, cpf_tratador) VALUES
				  (1, true, 'Grade', '2018-01-10', 10, null, 7, 13.0, 15, 7,1, "01134566299"),
                  (2, true, 'Vidro', '2018-01-11', 11, null, 7, 10.10, 15,7,1, "01134566299"),
                  (3, true, 'Grade', '2018-01-03', 12, null, 7, 7.98, 14, 7,1, "02123521356"),
                  (4, true, 'Grade', '2018-01-04', 13, null, 7, 8.43, 14, 7,1, "02123521356"),
                  (5, false,'Grade', '2017-01-01', 10, null, 7, 5.87, 13, 6,1, "00011122233"),
                  (6, true,'aquario','2011-01-01', 20,null, 7, 10.2, 16, 5,1, "00011122233");
				
INSERT INTO `ordem` (`id`,`nome`) VALUES (1,'Monotremata'),(2,'Cetacio'),(3,'Cenarta'),(4,'Primata'),(5,'Quiroptara'),(6,'Carnívoro'),(7,'Araneae'),(8,'Scorpiones'),(9,'Lamniformes');
				
INSERT INTO `genero` (`seq`,`nome`,`ordem`) VALUES (1,'Ornithorhynchus',1),(2,'Whippomorpha',2),(3,'Delphinus',2),(4,'Pan',4),(5,'Gorilla',4),(6,'Pongo',4),(7,'Phantera',6),(8,'Canis',6),(9,'Felis',6),(10,'Phoneutria',7),(11,'Tytus',8),(12,'Carcharodon',9);

INSERT INTO `especie` (`seq`,`nome`,`genero`) VALUES (1,'Onitorrinco',1),(2,'Hipopotamo',2),(3,'Golfinho',3),(4,'Chimpanzé',4),(5,'Gorila',5),(6,'Oragotando',6),(7,'Leo',7),(8,'Tigre',7),(9,'Familiaris',8),(10,'Lupus',8),(11,'Catus',9),(12,'Bahiensis',11),(13,'Carcharias',12);

insert into Especie_indicada (id_jaula, seq) VALUES (6,1),(4,2),(6,3), (3,4),(2,5);

INSERT INTO `animal` (`id`,`nome`,`vivo`,`dt_nasc`,`dt_falecimento`,`idade`,`nome_vulgar`,`obs`,`id_zoo`,`id_jaula`,`ordem`,`genero`,`especie`) VALUES (1,'Leão',1,'2018-01-04',NULL,0,'João','Recém-nascido',1,1,6,7,7),(2,'Cachorro',1,'2015-02-03',NULL,3,'Júnior',NULL,1,2,6,8,9),(3,'Lobo',0,'2000-07-01','2017-06-05',6,'Nino',NULL,1,3,6,8,10),(4,'Gato',1,'2006-09-04',NULL,9,'Tica',NULL,1,3,6,9,11),(5,'Aranha Armadeira',1,NULL,NULL,NULL,'Ariana','Data de nascimento indefinida',1,4,7,10,NULL),(6,'Escorpião Marrom',0,'2016-10-14','2017-02-17',0,'Enzo',NULL,1,5,8,11,12),(7,'Tubarão Branco',1,'1997-08-17',NULL,20,'Bibito','Cuidados especiais',1,6,9,12,13);

INSERT INTO `consulta` (`id_consulta`,`dat_consulta`,`obs`,`id_veterinario`,`id_animal`) VALUES (1,'2011-03-20 15:00:00','Tudo ok!','01439264834',1),(2,'2011-05-21 15:17:00','Tudo ok!','02244715739',2),(3,'2011-07-22 15:22:30','Tudo ok!','01439264834',1),(4,'2011-09-22 14:29:03','Tudo ok!','02244715739',2),(5,'2018-01-10 17:03:00','Prescrição de medicamento e início de tratamento.','52135800926',3),(6,'2018-01-11 18:04:34','Prescrição de medicamento e início de tratamento.','43221775479',4),(7,'2018-01-12 20:08:34','Prescrição de medicamento e início de tratamento.','43221775479',5),(8,'2018-01-13 09:43:53','Prescrição de medicamento e início de tratamento.','01439264834',6),(9,'2018-01-14 17:32:15','Prescrição de medicamento e início de tratamento.','02244715739',7),(10,'2018-01-15 00:00:54','Tudo ok!','52135800926',8);
                    
insert into Doenca (id_doenca, descricao) VALUES
					(1, 'Febre Leonina'),
                    (2, 'Vírus Zyspro'),
	                (3, 'OnitorDoença'),
                    (4, 'Ferimento Exposto'),
                    (5, 'Cancer');

insert into Sintoma (id_doenca, descricao) Values
					  (1, 'Cansaço e Fadiga'),
                      (2, 'Hemorragia'),
                      (3, 'Seco');
                      
INSERT INTO `diagnostico` (`id_consulta`,`id_doenca`,`descri`) VALUES (5,'1','Doença de fácil controle'),(6,'2','Doença de fácil controle'),(7,'3','Necessidade de acompanhamento'),(8,'4','Doença de alta periculosidade'),(9,'5','Doença de fácil controle');

INSERT INTO `pedido_servico` (`id`,`status_pedido`,`dt_execucao`,`vl_total`,`dt_pedido`,`idZoo`) VALUES (1,0,NULL,100.00,'2018-01-15',1),(2,1,'2017-07-15',51.30,'2017-07-09',1),(3,0,NULL,98.28,'2018-01-14',1),(4,1,'2017-06-08',207.89,'2017-05-04',1),(5,0,NULL,402.01,'2018-01-02',1),(6,0,NULL,591.09,'2018-01-04',1),(7,1,'2018-01-07',765.50,'2018-01-05',1),(8,1,'2016-06-08',1070.35,'2016-06-08',1),(9,0,NULL,930.08,'2018-01-06',1),(10,0,NULL,479.90,'2018-01-07',1);

INSERT INTO `fatura` (`idFatura`,`valor`,`dataDaFatura`,`dt_paga`,`vl_multa`,`stats`,`tp_fatura`,`id_ped_serv`) VALUES (1,100,'2018-01-15','2018-01-16',0,'Em andamento','Boleto',1),(2,51.3,'2017-07-09','2017-07-10',0,'A caminho','Boleto',2),(3,98.28,'2018-01-14','2018-01-14',0,'Em andamento','Crédito',3),(4,207.89,'2017-05-04','2017-05-06',0,'Entregue','Boleto',4),(5,402.01,'2018-01-02','2018-01-10',0,'Em andamento','Débito automático',5),(6,591.09,'2018-01-04','2018-01-10',0,'Em andamento','Débito automático',6),(7,765.5,'2018-01-05','2018-01-06',0,'A caminho','Boleto',7),(8,1070.35,'2016-06-08','2016-06-08',0,'A caminho','Crédito',8),(9,930.08,'2018-01-06','2018-01-11',0,'Entregue','Boleto',9),(10,479.9,'2018-01-07','2018-01-09',0,'Entregue','Crédito',10);

INSERT INTO `categoria` (`cod`,`descr`) VALUES (1,'Limpeza'),(2,'Alimento'),(3,'Medicament'),(4,'Diversos');

INSERT INTO `sub_categoria` (`cod`,`descr`,`categ`) VALUES (1,'Sabão',1),(2,'Detergente',1),(3,'Alvejante',1),(4,'Ração',2),(5,'Vegetal',2),(6,'Carne',2),(7,'Remédio',3),(8,'Esparadrapo',3),(9,'Agulha',3),(10,'Mecânico',4),(11,'Brita',4);

INSERT INTO `fornecedor` (`cod`,`Nome`,`cnpj`,`telefone_1`,`telefone_2`,`ativo`) VALUES (1,'João','55135124034952','8130302341','8130554328',1),(2,'Maria','55284965289134','8130312049','8131259446',1),(3,'José','55434806543316','8130321757','8131964564',1),(4,'Bruno','55584647797498','8130331465','8132669682',1),(5,'Ricardo','55734489051680','8130341173','8133374800',0),(6,'Joaquim','55884330305862','8130350881','8134079918',0),(7,'Jorge','56034171560044','8130360589','8134785036',0);

INSERT INTO `produto_ref` (`cod`,`descr`,`freq_pedido`,`cod_barra`,`qtd_estoque`,`preco_ult_compra`,`qtd_total_estoque`,`qtd_min`,`subcat`,`categ`,`fornecedor`) VALUES (1,'Limpa jaula',5,'9382746520',15,150,20,10,2,1,1),(2,'Ração para cães',5,'9592837121',50,590,55,5,4,2,2),(3,'Carne para leão',4,'9802927722',40,510,49,5,6,2,2),(4,'Remédios para animais',6,'1001301832',90,489,102,10,7,3,4),(5,'Equipamentos de manutenção',3,'1022310892',30,302,80,10,10,4,5);

INSERT INTO `instituicao` (`cnpj`,`nome_contato`,`email`,`telefone_1`,`telefone_2`,`razao_social`,`tipo_instituicao`) VALUES ('00112233445566','Figueira','figueira_racoes@gmail.com','8130204551',NULL,'FigRaç',NULL),('11223344556677','Joaquim','joaquim.silveira@hotmail.com','8231214040','82993123412','JJVet',NULL);

INSERT INTO `espacos_reservavel` (`id_espaco`,`dimensao_area`,`capacidade`,`tipo`,`nome`,`idZoo`) VALUES (1,700,15,'Área comum','Espaço vivência',1),(2,500,13,'Área externa','Parque infantil',1),(3,150.84,8,'Área interna','Restaurante',1),(4,900.5,23,'Área comum','Espaço recreativo',1),(5,49.31,7,'Área interna','Jaula interativa',1);

INSERT INTO `reserva` (`qtd_pessoas`,`dt_validade`,`horÃ¡rio`,`dt_reserva`,`valor`,`stats`,`hr_inicio_reser`,`hr_final_reser`,`e_cortesia`,`tp_evento`,`CNPJ`,`id_espaco`) VALUES (20,'2018-01-23','16:47:22','2018-01-18',977.82,'A realizar','19:30:00','05:00:00',NULL,'Festa noturna','00112233445566',4),(7,'2018-01-19','09:37:54','2018-01-14',483.38,'Realizado','15:00:00','18:00:00',NULL,'Excursão científica','00112233445566',5),(15,'2018-01-22','15:00:00','2018-01-17',854.21,'Realizado','14:00:00','17:00:00',NULL,'Exposição escolar','11223344556677',1),(10,'2018-01-21','13:12:38','2018-01-16',730.6,'Realizado','09:20:00','12:00:00',NULL,'Festa infantil','11223344556677',2),(8,'2018-01-20','11:25:16','2018-01-15',606.99,'A realizar','19:00:00','22:20:00',NULL,'Confraternização empresarial','11223344556677',3);

INSERT INTO `empresa_terceira` (`CNPJ`,`fone`,`email`) VALUES ('51246524501523','8130348461','deditificacao.vet@hotmail.com'),('54161235214982','8130339456','vet_santos@hotmail.com'),('57075945928441','8130330451','saneamento.94@gmail.com'),('59990656641900','8130321446','giga.limpa@uol.com.br'),('62905367355359','8130312441','oficial_hosp.vet@bol.com.br');

INSERT INTO `endereco` (`idEnd`,`idForn`,`bairro`,`rua`,`cep`,`estado`) VALUES (1,1,'Ibirapuera','Rua das flores','51450-561','Pe'),(2,2,'Silveira','Rua das silveiras','51487-653','Sã'),(3,3,'Cardinal','Rua dos números','51524-745','Ri'),(4,4,'Santos','Rua dos anjos','51561-837','Pe'),(5,5,'Flamengo','Avenida Dom Miguel','51598-929','Ba'),(6,6,'Fluminense','Rua Intrépida','51636-021','Se'),(7,7,'Casa Azul','Avenida João Brito Blue','51673-113','Pe');

INSERT INTO `estoque` (`id`,`idZoo`,`descr`,`localizacao`) VALUES (1,1,'Estoque de ração','Dentro do zoo'),(2,1,'Estoque de carne','Dentro do zoo'),(3,1,'Próximo do fornecedor','Rua dos anjos'),(4,1,'Próximo do fornecedor','Avenida José Pinheiros'),(5,1,'Estoque de medicamento','Dentro do zoo'),(6,1,'Estoque de diversos','Dentro do zoo');

INSERT INTO `incidente` (`seq`,`descr`) VALUES (1,'Infecção alimentícia no restaurante'),(2,'Crianças vomitando após show'),(3,'Show com problemas no equipamento'),(4,'Quebra de equipamento diverso'),(5,'Uso indevido do espaço reservado'),(6,'Invasão de mal caráter');

INSERT INTO `item_estoque` (`cod_prod_ref`,`id`,`qtd`,`data_entrada`,`vl_compra`,`data_validade`,`id_animal`) VALUES (1,3,20,'2017-12-23',219.64,'2019-12-23',4),(2,1,55,'2017-12-20',800.51,'2018-06-20',2),(3,2,49,'2017-12-22',5015.6,'2018-03-22',1),(4,5,102,'2017-12-21',4264.32,'2019-12-21',3),(5,6,80,'2018-01-05',2765.34,'2022-01-05',7);

INSERT INTO `servico` (`id`,`descr`,`valor`) VALUES (1,'Manutenção jaula  - Área 1',100.00),(2,'Manutenção jaula  - Área 2',51.30),(3,'Manutenção jaula  - Área 3',98.28),(4,'Limpeza zoologico - Área 1',207.89),(5,'Limpeza zoologico  - Área 3',402.01),(6,'Transporte de alimento  - Área 2',591.09),(7,'Transporte de alimento  - Área 1',765.50),(8,'Manutenção jaula  - Área 4',1070.35),(9,'Limpeza zoologico  - Área 2',930.08),(10,'Transporte de alimento  - Área 3',479.90);

INSERT INTO `item_servico` (`idPed`,`idServ`,`qtd`,`vl_unitario`,`status_item`,`dt_realizacao`) VALUES (1,1,1,100.00,0,NULL),(2,2,1,51.30,1,'2017-07-15'),(3,3,1,98.28,0,NULL),(4,4,1,207.89,1,'2017-06-08'),(5,5,1,402.01,0,NULL),(6,6,1,591.09,0,NULL),(7,7,1,765.50,1,'2018-01-07'),(8,8,1,1070.35,1,'2016-06-08'),(9,9,1,930.08,0,NULL),(10,10,1,479.90,0,NULL);

INSERT INTO `medicamento` (`id_medicamento`,`nome`,`isAtivo`,`descricao_frequencia`,`bula`) VALUES (1,'Albesatran',1,'12 em 12 hrs/7 dias',NULL),(2,'Cominutran',0,'8 em 8 hrs/7 dias',NULL),(3,'Centireum',0,'12 em 12 hrs/7 dias',NULL),(4,'Philotiscopo',1,'24 em 24 hrs/10 dias',NULL),(5,'Adenalzina',1,'48 em 48 hrs/16 dias',NULL),(6,'Aceptina',1,'4 em 4 hrs/2 dias',NULL),(7,'Mericutan',0,'Vide a bula',NULL),(8,'Mercivutan',0,'Vide a bula',NULL);

INSERT INTO `nota_fiscal` (`NFE`,`ICMS`,`valor_total`,`vl_total_desconto`,`data_NF`) VALUES (1,26.41,126.41,113.77,'2018-01-16'),(2,20.70,72.00,64.80,'2017-07-10'),(3,48.68,146.96,132.26,'2018-01-14'),(4,134.50,342.39,308.15,'2017-05-06'),(5,64.35,466.36,419.72,'2018-01-10'),(6,86.50,677.59,609.83,'2018-01-10'),(7,76.13,841.63,757.47,'2018-01-06'),(8,65.77,1136.12,1022.51,'2016-06-08'),(9,55.40,985.48,886.94,'2018-01-11'),(10,45.04,524.94,472.45,'2018-01-09');

INSERT INTO `tipo_pagamento` (`cod`,`descr`) VALUES (1,'Crédito'),(2,'Débito'),(3,'À vista'),(4,'À prazo');

INSERT INTO `pagamento` (`cod`,`data_pagamento`,`stats`,`vl_pago`,`tipo_pag`,`idFatura`,`NFE`) VALUES (1,'2018-01-16','Em andamento',113.769,1,1,1),(2,'2017-07-10','A caminho',64.8,1,2,2),(3,'2018-01-14','Em andamento',132.264,1,3,3),(4,'2017-05-06','Entregue',308.151,4,4,4),(5,'2018-01-10','Em andamento',419.724,2,5,5),(6,'2018-01-10','Em andamento',609.8301,2,6,6),(7,'2018-01-06','A caminho',757.4706,3,7,7),(8,'2016-06-08','A caminho',1022.5071,1,8,8),(9,'2018-01-11','Entregue',886.9356,3,9,9),(10,'2018-01-09','Entregue',472.4451,1,10,10);

INSERT INTO `pode_ter` (`id_jaula`,`seq`,`data_incidente`,`houve_morte`) VALUES (1,4,NULL,NULL),(2,4,NULL,NULL),(3,4,NULL,NULL),(4,4,NULL,NULL),(5,4,NULL,NULL),(6,4,NULL,NULL);

INSERT INTO `tratamento` (`id_tratamento`,`em_andamento`,`data_inicio`,`data_fim`,`resultado`,`obs`,`id_consulta`) VALUES (1,0,'2018-01-10','2018-01-12',1,'Tratamento com sucesso',5),(2,1,'2018-01-11','2018-01-18',0,'Reagindo bem ao tratamento',6),(3,1,'2018-01-12','2018-01-19',0,'Pouca reação ao tratamento',7),(4,0,'2018-01-13','2018-01-15',0,'Sem reação ao tratamento',8),(5,0,'2018-01-14','2018-01-16',1,'Tratamento com sucesso',9);

INSERT INTO `prescricao` (`id_medicamento`,`id_tratamento`,`posologia`) VALUES (1,3,'1 g'),(2,2,'30 mg'),(6,1,'50 mg'),(6,4,'130 mg'),(6,5,'550 mg');

INSERT INTO `trata` (`id_medicamento`,`id_doenca`) VALUES (1,'3'),(2,'2'),(3,'2'),(4,'1'),(5,'3'),(6,'1'),(6,'4'),(6,'5'),(7,'4'),(8,'2');



