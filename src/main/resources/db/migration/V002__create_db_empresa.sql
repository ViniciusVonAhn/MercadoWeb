CREATE TABLE empresa (
	id INTEGER NOT NULL auto_increment,
	cnpj VARCHAR(18) NOT NULL,
	nome varchar(50) NOT NULL,
	PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;