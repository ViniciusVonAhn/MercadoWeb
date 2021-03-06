CREATE TABLE venda (
	id INTEGER NOT NULL auto_increment,
	data DATE,
	time TIME,
	cpf VARCHAR(14),
	valor_recebido DECIMAL(9,2) NOT NULL,
	valor_total DECIMAL(9,2) NOT NULL,
	valor_troco DECIMAL(9,2) NOT NULL,
	cupom_id INTEGER,
	produto_id INTEGER,
	empresa_id INTEGER,
	PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;