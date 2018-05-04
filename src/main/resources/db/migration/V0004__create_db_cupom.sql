CREATE TABLE cupom (
	cupom_id INTEGER NOT NULL,
	produto_id INTEGER NOT NULL,
	quant_vendida DECIMAL(9,2) NOT NULL,
	valor_produto DECIMAL(9,2) NOT NULL,
	PRIMARY KEY (cupom_id, produto_id)
) engine=InnoDB DEFAULT CHARSET=utf8;