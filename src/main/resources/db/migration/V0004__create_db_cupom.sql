CREATE TABLE cupom (
	cupom_id INTEGER NOT NULL AUTO_INCREMENT,
	produto_id INTEGER NOT NULL,
	quant_vendida INTEGER NOT NULL,
	valor_produto DECIMAL(9,2) NOT NULL,
	PRIMARY KEY (cupom_id, produto_id)
) engine=InnoDB DEFAULT CHARSET=utf8;
