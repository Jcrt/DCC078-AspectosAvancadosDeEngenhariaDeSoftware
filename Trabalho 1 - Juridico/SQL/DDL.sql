CREATE TABLE pessoa
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tipoDocumento VARCHAR(100),
    numeroDocumento VARCHAR(100),
    email VARCHAR(200),
    tipo INT NOT NULL
);

CREATE TABLE processo
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    numeroProcesso VARCHAR(50),
    status INT,
    dataCadastro DATETIME,
    dataBaixa DATETIME,
    dataEncerramento DATETIME
);

ALTER TABLE processo ADD advogado INT NULL;
ALTER TABLE processo
ADD CONSTRAINT processo_pessoa_id_fk
FOREIGN KEY (advogado) REFERENCES pessoa (id);


CREATE TABLE andamento
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    idProcesso INT,
    descricao VARCHAR(200),
    data DATETIME,
    CONSTRAINT andamento_processo_id_fk FOREIGN KEY (idProcesso) REFERENCES processo (id)
);


create table envolvidoNotificacaoProcesso
(
	processo_id int null,
	pessoa_id int null,
	mensagem varchar(200) null,
	data datetime null,
	constraint envolvidoNotificacaoProcesso_ pessoa_id_fk
		foreign key (pessoa_id) references ` pessoa` (id)
)
;

create index `envolvidoNotificacaoProcesso_ pessoa_id_fk`
	on envolvidoNotificacaoProcesso (pessoa_id)
;




