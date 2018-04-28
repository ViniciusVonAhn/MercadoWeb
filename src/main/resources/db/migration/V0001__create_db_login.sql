CREATE TABLE login (
	id INTEGER NOT NULL auto_increment,
	senha VARCHAR(10) NOT NULL,
	usuario VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;