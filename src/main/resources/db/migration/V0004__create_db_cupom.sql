CREATE TABLE cupom (
	cupom_id INTEGER NOT NULL,
	produto_id INTEGER NOT NULL,
	cpf VARCHAR(14),
	data DATE NOT NULL,
	hora TIME NOT NULL,
	nome_produto VARCHAR(50),
	quant_vendida DECIMAL(9,2) NOT NULL,
	valor_produto DECIMAL(9,2) NOT NULL,
	valor_recebido DECIMAL(9,2) NOT NULL,
	valor_troco DECIMAL(9,2) NOT NULL,
	valor_unitario DECIMAL(9,2) NOT NULL,
	empresa_id INTEGER NOT NULL,
	PRIMARY KEY (cupom_id, produto_id)
) engine=InnoDB DEFAULT CHARSET=utf8;