CREATE TABLE produto (
	id serial NOT NULL,
	descricao varchar(200) NULL,
	valor_compra float4 NULL,
	valor_venda float4 NULL,
	quantidade int NULL,
	tipo_id int NULL,
	CONSTRAINT produto_pk PRIMARY KEY (id),
	CONSTRAINT produto_tipo_fk FOREIGN KEY (tipo_id) REFERENCES public.tipo(id)
);