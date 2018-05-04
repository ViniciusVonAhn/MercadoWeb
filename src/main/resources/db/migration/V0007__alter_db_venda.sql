alter table venda add 
	constraint FK686xsfk3943wqp1p04qfqjf5y
	foreign key (cupom_id, produto_id)
	references cupom (cupom_id, produto_id);
alter table venda add 
    constraint FKfboo2vuru86trmyue6ldnomno 
    foreign key (empresa_id) 
    references empresa (id);