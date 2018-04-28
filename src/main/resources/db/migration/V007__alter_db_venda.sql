alter table venda
	add constraint FK686xsfk3943wqp1p04qfqjf5y
	foreign key (cupom_id, produto_id)
	references cupom (cupom_id, produto_id);