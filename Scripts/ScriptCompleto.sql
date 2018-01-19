DROP SCHEMA zoologico;
Create schema Zoologico;
use Zoologico;

create table if not exists Zoologico(
	idZoo int auto_increment, 
    cnpj varchar(14) not null unique, 
    nome varchar(30), 
    razao_social varchar(30), 
    hr_inic_func time, 
    hr_fim time,
	primary key(idZoo)
);

create table if not exists Fones(
	idZoo int Not null, 
    numero varchar(13),
    primary key(idZoo, numero),
	Foreign key(idZoo) references Zoologico(idZoo)
);

create table if not exists Docs(
	idZoo int NOT NULL,
    idDocs int auto_increment,
    docs blob,
	primary key(idDocs),
	foreign key(idZoo) references Zoologico(idZoo) on delete cascade
);

create table if not exists Licenca(
	id_licenca int auto_increment, 
    descr varchar(100), 
    data_de_expiracao date, 
    idZoo int not null,
	primary key(id_licenca),
	foreign key(idZoo) references Zoologico(idZoo) 
);

create table if not exists Jornada_De_Trabalho(
	id int auto_increment, 
    trabalha_sabado boolean, 
    descr varchar(100),
	primary key(id)
);

create table if not exists Dia(
	seq int auto_increment, 
    descr varchar(50),
	primary key(seq)
);

create table if not exists Turno(
	cod int auto_increment, 
    descricao varchar(50), 
    hr_inicio time, 
    hr_fim time,
	primary key(cod)
);

create table if not exists tem(
	cod int, 
    seq int, 
    id int,
    primary key(cod, seq, id),
    foreign key(id) references  Jornada_De_Trabalho(id) on delete cascade on update cascade,
    foreign key(seq) references Dia(seq) on delete cascade on update cascade,
    foreign key(cod) references Turno(cod) on delete cascade on update cascade
);

-- parei aqui
create table if not exists Funcionario(
	CPF varchar(11) not null, 
	Nome varchar(30), 
    especializacao varchar(30), 
    fone_1 varchar(13), 
    fone_2 varchar(13), 
    data_de_contratacao date, 
    salario double, 
    ender varchar(50), 
    jornada_trabalho int, 
    idZoo int not null,
	primary key(CPF),
	foreign key(jornada_trabalho) references Jornada_De_Trabalho(id) on update cascade on delete set null,
	foreign key(idZoo) references Zoologico(idZoo) on delete cascade
);

create table if not exists Curso(
	id int auto_increment, 
	descr varchar(50), 
    carga_hor int, 
    tipo varchar(30),
    primary key(id)
);

create table if not exists Faz(
	id int, 
    CPF varchar(11), 
    dt_inicio date,
	primary key(id, CPF),
	foreign key(id) references Curso(id) on delete cascade on update cascade,
	foreign key(CPF) references Funcionario(CPF) on delete cascade
);

create table if not exists Administrador(
	cpf varchar(11),
    senha_de_acesso varchar(100),
    idZoo int,
    login varchar(100),
	primary key(CPF),
	foreign key(idZoo) references Zoologico(idZoo) on delete cascade on update set null,
    foreign key(CPF) references Funcionario(cpf)
);

create table if not exists FUNC_Tratador(
	cpf varchar(11) not null, 
	situacao varchar(15), 
	primary key(cpf),
    foreign key(cpf) references Funcionario(cpf) on delete cascade
);

create table if not exists FUNC_Secretario(
	CPF varchar(11),
	primary key(CPF),
    foreign key(CPF) references Funcionario(CPF) on delete cascade
);

create table if not exists Bilheteria(
	idBilheteria int auto_increment,
	total_inteira double(8,2),
    total_meia double(8,2),
    total_cortesia double(8,2),
    status_bilheteria boolean,
    data_bilheteria date,
    renda_do_dia double(8,2),
    hr_abertura time,
    duracao double(8,2),
    hr_fecha time,
    idZoo int not null,
	primary key(idBilheteria),
	foreign key(idZoo) references Zoologico(idZoo) on delete cascade
);

create table if not exists Trabalha (
	idBilheteria int auto_increment,
    cpf_secretario varchar(11),
    data_trab date,
	primary key(idBilheteria, cpf_secretario, data_trab),
	foreign key(idBilheteria) references Bilheteria(idBilheteria) on delete cascade,
	foreign key(cpf_secretario) references FUNC_Secretario(CPF) on delete cascade
    
);

create table if not exists Veterinario(
	CPF varchar(11),
    estado varchar(2) not null,
	CRMV varchar(4) not null, 
    primary key(CPF),
    foreign key(CPF) references Funcionario(CPF) on delete cascade
);

create table if not exists Ponto(
	CPF varchar(11) not null, 
	Data_hora_inicial date, 
	data_hora_fim date, 
	faltou boolean,
	primary key(CPF, Data_hora_inicial),
	foreign key(CPF) references Funcionario(CPF) on delete cascade
);

create table if not exists Jaula(
	id_jaula int auto_increment, 
    stats boolean, 
    tipo varchar(20), 
    dt_ultima_inspecao date, 
    populacao_max int, 
    obs varchar(50), 
    perid_insp_dias int, 
    altura double, 
    largura double, 
    profundidade double, 
    idZoo int, 
    cpf_tratador varchar(11),
	primary key(id_jaula),
	foreign key(idZoo) references Zoologico(idZoo) on delete cascade,
	foreign key(cpf_tratador) references FUNC_tratador(cpf) on update cascade on delete set null
);

create table if not exists Ordem(
	id int auto_increment, 
    nome varchar(50),
	primary key(id)
);

create table if not exists Genero(
	seq int auto_increment, 
	nome varchar(50), 
    ordem int null,
	primary key(seq, nome),
	foreign key(ordem) references Ordem(id)
);

create table if not exists Especie(
	seq int auto_increment, 
    nome varchar(50), 
    genero int,
	primary key(seq),
	foreign key(genero) references Genero(seq)
);

create table if not exists Especie_indicada(
	id_jaula int, 
	seq int,
	primary key(id_jaula, seq),
	foreign key(id_jaula) references Jaula (id_jaula),
	foreign key(seq) references Especie (seq) 
);

create table if not exists Animal(
	id int auto_increment, 
    nome varchar(30), 
    vivo boolean, 
    dt_nasc date, 
    dt_falecimento date null, 
    idade int, 
    nome_vulgar varchar(30), 
    obs varchar(100), 
    id_zoo int not null, 
    id_jaula int not null, 
    ordem int, 
    genero int, 
    especie int,
	Primary Key(id),
	foreign key(id_zoo) references Zoologico(idZoo) on delete cascade,
	foreign key(id_jaula) references Jaula(id_jaula)on update cascade on delete cascade,
	foreign key(ordem) references Ordem(id) on update cascade on delete cascade,
	foreign key(genero) references Genero(seq) on update cascade on delete cascade,
	foreign key(especie) references Especie(seq) on update cascade on delete cascade
);

create table if not exists Consulta(
	id_consulta int auto_increment,
    dat_consulta datetime not null,
	obs varchar(300),
    id_veterinario varchar(11) not null,
    id_animal int not null,
    primary key(id_consulta),
    foreign key(id_veterinario) references Veterinario(CPF),
    foreign key(id_animal) references Animal(id)
);

create table if not exists Doenca(
	id_doenca varchar(4) not null,
    descricao varchar(250) not null,
    primary key(id_doenca)
);

create table if not exists Sintoma(
	id_doenca varchar(4) not null,
    descricao varchar(250) not null,
    primary key(id_doenca),
    foreign key(id_doenca) references Doenca(id_doenca)
);

create table if not exists Diagnostico(
	id_consulta int,
    id_doenca varchar(4),
    descri varchar(300),
    primary key(id_doenca, id_consulta),
    foreign key(id_doenca) references Doenca(id_doenca),
	foreign key(id_consulta) references Consulta(id_consulta)
);

create table if not exists Tratamento(
	id_tratamento int auto_increment,
    em_andamento boolean default false,
    data_inicio date,
    data_fim date,
    resultado boolean default true,
    obs varchar(250),
    id_consulta int,
    primary key(id_tratamento),
    foreign key(id_consulta) references Consulta(id_consulta) on delete set null
);

create table if not exists Medicamento(
	id_medicamento int auto_increment,
    nome varchar(200) not null,
    isAtivo boolean default false,
    descricao_frequencia varchar(200),
    bula blob null,
    primary key(id_medicamento)
);

create table if not exists Prescricao(
	id_medicamento int,
    id_tratamento int,
    posologia varchar(200),
    primary key(id_medicamento, id_tratamento),
    foreign key(id_medicamento) references Medicamento(id_medicamento),
    foreign key(id_tratamento) references Tratamento(id_tratamento)
);

create table if not exists Trata(
	id_medicamento int,
    id_doenca varchar(4),
    primary key(id_medicamento, id_doenca),
    foreign key(id_medicamento) references Medicamento(id_medicamento),
    foreign key(id_doenca) references Doenca(id_doenca)
);
-- animal
create table if not exists Incidente(
	seq int, 
    descr varchar(100),
	Primary Key(seq)
);

create table if not exists pode_ter(
	id_jaula int,
    seq int, 
    data_incidente date, 
    houve_morte boolean,
	primary key(id_jaula, seq),
	foreign key(id_jaula) references Jaula(id_jaula),
	foreign key(seq) references Incidente (seq)
);
-- vermelho
create table if not exists Fornecedor (
	cod int  AUTO_INCREMENT, 
	Nome varchar(30), 
	cnpj varchar(14), 
	telefone_1 varchar(13), 
	telefone_2 varchar(13),
	ativo boolean,
    primary key(cod)
);

create table if not exists Endereco(
	idEnd int auto_increment,
    idForn int,
    bairro varchar(20), 
    rua varchar(50), 
    cep varchar(10), 
    estado varchar(2),
    primary key(idEnd),
    foreign key(idForn) references Fornecedor(cod)
);

create table if not exists Estoque(
	id int primary key auto_increment, 
    idZoo int not null,
    descr varchar(100), 
    localizaçao varchar(100),
    foreign key (idZoo) references Zoologico (idZoo)
); 

create table if not exists Categoria(
	cod int auto_increment, 
    descr varchar(10), 
    primary key(cod)
);

create table if not exists Sub_categoria(
	cod int primary key not null auto_increment, 
    descr varchar(100), 
    categ int null, 
    foreign key(categ) references Categoria(cod)
);

create table if not exists Produto_Ref(
	cod int not null auto_increment, 
	descr varchar(100), 
    freq_pedido int, 
    cod_barra  varchar(10), 
    qtd_estoque int, 
    preco_ult_compra double, 
    qtd_total_estoque int, 
    qtd_min int, 
    subcat  int, 
    categ  int, 
    fornecedor int, 
    primary key(cod), 
    foreign key(subcat) references Sub_categoria(cod),
    foreign key(categ) references Categoria(cod),
    foreign key(fornecedor) references Fornecedor(cod)
);

create table if not exists Item_Estoque(
	cod_prod_ref int not null,
    id int not null, 
    qtd int, 
    data_entrada date, 
    vl_compra double, 
    data_validade date, 
    id_animal int Null,
	primary key (cod_prod_ref, id),
    Foreign Key(id) references Estoque(id),
    Foreign Key(cod_prod_ref) references Produto_Ref(cod),
	foreign key(id_animal) references Animal(id)
);

create table if not exists Servico(
	id int,
    descr varchar(200),
    valor double(8,2),
	primary key(id)
);

create table if not exists Pedido_Servico(
	id int,
    status_pedido boolean,
    dt_execucao date,
    vl_total double(8,2),
    dt_pedido date,
    idZoo int not null,
	primary key(id),
	foreign key(idZoo) references Zoologico(idZoo)
);

create table if not exists Item_Servico(
	idPed int,
	idServ int,
    qtd int,
    vl_unitario double(8,2),
    status_item boolean,
    dt_realizacao date,
	primary key(idPed, idServ),
	foreign key(idPed) references Pedido_Servico(id),
	foreign key(idServ) references Servico(id)
);

create table if not exists Empresa_Terceira(
	CNPJ varchar(14),
    fone varchar(11),
    email varchar(100),
	primary key(CNPJ)
);

create table if not exists Presta(
	CNPJEmprTerc varchar(14),
    idServ int,
    dt_inicio date,
    dt_fim date,
	primary key(CNPJEmprTerc, idServ),
	foreign key(CNPJEmprTerc) references Empresa_Terceira(CNPJ),
	foreign key(idServ) references Servico(id)
);
-- antes
create table if not exists Espacos_Reservavel(
	id_espaco int auto_increment, 
    dimensao_area double, 
    capacidade int, 
    tipo varchar(50), 
    nome varchar(50), 
    idZoo int not null,
	primary key(id_espaco),
	foreign key(idZoo) references Zoologico(idZoo)
);

create table if not exists Instituicao(
	cnpj varchar(14) not null, 
    nome_contato varchar(30), 
    email varchar(50), 
    telefone_1 varchar(13), 
    telefone_2 varchar(13), 
    razao_social varchar(20), 
    tipo_instituicao varchar(50),
	primary key (cnpj)
);

create table if not exists Reserva(
	qtd_pessoas int, 
    dt_validade date, 
    horário time, 
    dt_reserva date, 
    valor double, 
    stats varchar(50), 
    hr_inicio_reser time, 
    hr_final_reser time, 
    e_cortesia varchar(200), 
    tp_evento varchar(50), 
    CNPJ varchar(14), 
    id_espaco int,
    primary key(CNPJ, id_espaco),
	foreign key(CNPJ) references Instituicao(cnpj),
	foreign key(id_espaco) references Espacos_Reservavel (id_espaco)
);

create table if not exists Fatura(
	idFatura int auto_increment, 
    valor double, 
    dataDaFatura date, 
    dt_paga date, 
    vl_multa double, 
    stats varchar(50), 
    tp_fatura varchar(50), 
    id_ped_serv int,
    primary key(idFatura),
	foreign key(id_ped_serv) references PEDIDO_SERVICO (id)
);

create table if not exists Reservado(
	CNPJ varchar(14), 
    id_espaco int, 
    idFatura int unique,
	primary key(CNPJ, id_espaco),
	foreign key(CNPJ) references Instituicao(cnpj),
	foreign key(id_espaco) references Espacos_Reservavel(id_espaco),
	foreign key(idFatura) references Fatura(idFatura)
);

create table if not exists Tipo_Pagamento(
	cod int auto_increment, 
    descr varchar(100),
	primary key(cod)
);

create table if not exists Nota_Fiscal(
	NFE int auto_increment, 
	ICMS double, 
    valor_total double, 
    vl_total_desconto double, 
    data_NF date,
	primary key(NFE)
);

create table if not exists Pagamento(
	cod int auto_increment, 
	data_pagamento date, 
    stats varchar(50), 
    vl_pago double, 
    tipo_pag int, 
    idFatura int not null unique, 
    NFE int unique,
	primary key(cod),
	foreign key(tipo_pag) references Tipo_Pagamento(cod),
	foreign key(idFatura) references Fatura(idFatura),
	foreign key(NFE) references Nota_Fiscal(NFE)
);

create table if not exists Calendario(
	seq int auto_increment,
    Dia date,
    fim_de_semana bool,
    feriado bool,
    obs varchar(250),
    lembrete_1 varchar(250),
    lembrete_2 varchar(250),
    todo_list varchar(250),
	primary key(seq)
);