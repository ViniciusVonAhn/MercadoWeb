
CREATE TABLE login (
	id INTEGER NOT NULL auto_increment, 
	senha VARCHAR(255) NOT NULL, 
	usuario VARCHAR(255) NOT NULL, 
	PRIMARY KEY (id)) 
	engine=InnoDB DEFAULT CHARSET=utf8;


