CREATE DATABASE DCC078;

use DCC078;

CREATE TABLE contatos(
	codigo int not null primary key auto_increment, 
    nome varchar(500) not null,
    email varchar(100) not null unique
);

CREATE TABLE produto(
	id int not null primary key auto_increment,
    nome varchar(500) not null unique, 
    estoque int not null default 0
);

CREATE TABLE contatos_observam_produtos(
	contatos_codigo INT NOT NULL, 
    produto_id INT NOT NULL, 
    PRIMARY KEY(contatos_codigo, produto_id), 
    CONSTRAINT FK_contatos_codigo FOREIGN KEY (contatos_codigo) REFERENCES contatos(codigo), 
    CONSTRAINT FK_produto_id FOREIGN KEY (produto_id) REFERENCES produto(id)
);