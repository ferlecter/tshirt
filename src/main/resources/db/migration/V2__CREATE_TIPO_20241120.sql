CREATE TABLE tipo (
	id serial NOT NULL,
	descricao varchar(100) NULL,
	CONSTRAINT tipo_pk PRIMARY KEY (id)
);


INSERT INTO tipo(descricao) VALUES('Futebol Americano');
INSERT INTO tipo(descricao) VALUES('Basquete');
INSERT INTO tipo(descricao) VALUES('Futebol');
INSERT INTO tipo(descricao) VALUES('Chaveiro');
INSERT INTO tipo(descricao) VALUES('Pulseira');
