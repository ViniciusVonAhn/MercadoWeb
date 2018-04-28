CREATE TABLE venda (
	id INTEGER NOT NULL auto_increment,
	data DATE NOT NULL,
	time TIME NOT NULL,
	valor_total Decimal(9,2) NOT NULL,
	cupom_id INTEGER,
	produto_id INTEGER,
	PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;