use zoologico;
insert into Zoologico (idZoo,cnpj,nome,razao_social, hr_inic_func, hr_fim) VALUES (1, '12345678910', 'Zootropia', 'sociável', '08:00:00', '20:00:00');

insert into fones(idZoo, numero) VALUES (1, '81-3255-9988'), (1, '81-3433-9988'), (1,'81-33333-8888');    

insert into docs (idZoo, idDocs, docs) values (1,1, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste.txt")),
											  (1,2, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste1.txt")),
                                              (1,3, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste2.txt")),
                                              (1,4, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste3.txt")),
                                              (1,5, load_file("C:/Users/Pedro/Desktop/scripts/docs/teste4.txt"));
    
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
                  ("02123521356", '2018-01-16T15:25:00','2018-01-16T120:25:00', false),
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

replace INTO `animal` (`id`,`nome`,`vivo`,`dt_nasc`,`dt_falecimento`,`idade`,`nome_vulgar`,`obs`,`id_zoo`,`id_jaula`,`ordem`,`genero`,`especie`) VALUES (1,'Cachorro',1,'2015-02-03',NULL,3,'Júnior',NULL,1,2,6,8,9),(2,'Lobo',0,'2000-07-01','2017-06-05',6,'Nino',NULL,1,0,6,8,10),(3,'Gato',1,'2006-09-04',NULL,9,'Tica',NULL,1,3,6,9,11),(4,'Aranha Armadeira',1,NULL,NULL,NULL,'Ariana','Data de nascimento indefinida',1,4,7,10,NULL),(5,'Escorpião Marrom',0,'2016-10-14','2017-02-17',0,'Enzo',NULL,1,5,8,11,12),(6,'Tubarão Branco',1,'1997-08-17',NULL,20,'Bibito','Cuidados especiais',1,8,9,12,13),(7,'Leão',1,'2018-01-04',NULL,0,'João','Recém-nascido',1,1,6,7,7);

INSERT INTO `consulta` (`id_consulta`,`dat_consulta`,`obs`,`id_veterinario`,`id_animal`) VALUES (1,'2011-03-20 15:00:00','Tudo ok!','01439264834',1),(2,'2011-05-21 15:17:00','Tudo ok!','02244715739',2),(3,'2011-07-22 15:22:30','Tudo ok!','01439264834',1),(4,'2011-09-22 14:29:03','Tudo ok!','02244715739',2),(5,'2011-11-23 17:03:00','Tudo ok!','52135800926',3),(6,'2012-01-24 22:04:03','Tudo ok!','43221775479',4),(7,'2012-03-26 09:13:04','Tudo ok!','43221775479',5),(8,'2012-05-27 10:05:08','Tudo ok!','01439264834',6),(9,'2012-07-28 08:49:05','Tudo ok!','02244715739',7),(10,'2012-09-28 20:09:37','Tudo ok!','52135800926',8);
                     
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
                      
insert into diagnostico (id_consulta,id_doenca, descri) VALUES
						(1,4,null),
                        (2,3,null),
                        (3,2,null),
                        (4,1, null),
                        (5,5, null);

INSERT INTO `pedido_servico` (`id`,`status_pedido`,`dt_execucao`,`vl_total`,`dt_pedido`,`idZoo`) VALUES (1,0,NULL,100.00,'2018-01-15',1),(2,1,'2017-07-15',51.30,'2017-07-09',1),(3,0,NULL,98.28,'2018-01-14',1),(4,1,'2017-06-08',207.89,'2017-05-04',1),(5,0,NULL,402.01,'2018-01-02',1),(6,0,NULL,591.09,'2018-01-04',1),(7,1,'2018-01-07',765.50,'2018-01-05',1),(8,1,'2016-06-08',1070.35,'2016-06-08',1),(9,0,NULL,930.08,'2018-01-06',1),(10,0,NULL,479.90,'2018-01-07',1);



