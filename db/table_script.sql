create table "APP".UTILIZADOR
(
	ID_UTILIZADOR INTEGER not null primary key generated always as identity (start with 1, increment by 1),
	NOME VARCHAR(50) not null,
	EMAIL VARCHAR(50) not null unique,
	PASSWORD VARCHAR(50) not null
);

create table "APP".MOBILIARIOCLINICO
(
	ID_PRODUTO INTEGER not null primary key generated always as identity (start with 1, increment by 1),
	NOME VARCHAR(50) not null,
	DESCRICAO VARCHAR(100),
	QUANTIDADE_TOTAL INTEGER default 0 not null,
	QUANTIDADE_DISPONIVEL INTEGER default 0 not null
);

create table "APP".RESERVA
(
	ID_RESERVA INTEGER not null primary key generated always as identity (start with 1, increment by 1),
	DATA_RESERVA TIMESTAMP not null,
	QUANTIDADE_RESERVADA INTEGER default 1 not null,
	ID_UTILIZADOR INTEGER not null,
	ID_PRODUTO INTEGER not null
);

create table "APP".REQUISICAO
(
	ID_REQUISICAO INTEGER not null primary key generated always as identity (start with 1, increment by 1),
	DATA_REQUISICAO TIMESTAMP not null,
	QUANTIDADE_REQUISITADA INTEGER default 1 not null,
	ID_UTILIZADOR INTEGER not null,
	ID_PRODUTO INTEGER not null
);

ALTER TABLE Reserva ADD FOREIGN KEY (id_utilizador) REFERENCES Utilizador;
ALTER TABLE Reserva ADD FOREIGN KEY (id_produto) REFERENCES MobiliarioClinico;
ALTER TABLE Requisicao ADD FOREIGN KEY (id_utilizador) REFERENCES Utilizador;
ALTER TABLE Requisicao ADD FOREIGN KEY (id_produto) REFERENCES MobiliarioClinico;
