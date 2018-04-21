CREATE TABLE produto (
	id INTEGER NOT NULL auto_increment,
	codigo_de_barra VARCHAR(255),
	estoque DOUBLE PRECISION NOT NULL, 
	nome VARCHAR(255) NOT NULL, 
	valor_un DOUBLE PRECISION NOT NULL, 
	PRIMARY KEY (id)) 
	engine=InnoDB DEFAULT CHARSET=utf8;