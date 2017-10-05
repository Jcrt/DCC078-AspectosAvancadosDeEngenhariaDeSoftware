CREATE TABLE pessoa
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tipoDocumento VARCHAR(100),
    numeroDocumento VARCHAR(100),
    email VARCHAR(200),
    tipo INT NOT NULL
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


