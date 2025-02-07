CREATE TABLE usuario (
	id int4 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"password" varchar(255) NULL,
	"role" varchar(255) NULL,
	CONSTRAINT uk5171l57faosmj8myawaucatdw UNIQUE (email),
	CONSTRAINT usuario_pkey PRIMARY KEY (id),
	CONSTRAINT usuario_role_check CHECK (((role)::text = ANY ((ARRAY['USER'::character varying, 'ADMIN'::character varying])::text[])))
);
