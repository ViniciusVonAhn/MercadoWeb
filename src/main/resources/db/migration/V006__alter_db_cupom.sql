alter table cupom
	add constraint FK41yj9sxldtawhrnjac63eiwnx 
	foreign key (empresa_id) 
	references empresa (id);
alter table cupom
	add constraint FKipfjhgql6loiamrfw372cmdje
	foreign key (produto_id)
	references produto (produto_id);