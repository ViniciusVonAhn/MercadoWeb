CREATE TABLE produto (
	id INTEGER NOT NULL auto_increment,
	codigo_de_barra VARCHAR(13),
	estoque INTEGER NOT NULL,
	nome VARCHAR(50) NOT NULL,
	valor_un DECIMAL(9,2) NOT NULL,
	PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;
