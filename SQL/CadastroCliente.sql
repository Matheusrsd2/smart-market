create database clientescadastrados;
use clientescadastrados;
create table Cliente(
	administrador boolean,
	id_Cliente integer auto_increment not null primary key,
    cpf_Cliente varchar(14) not null,
    nome_Cliente varchar(54),
    sobrenome_Cliente varchar(54),
	sexo_Cliente varchar(54),
	DataNasc date , 
	logradouro_Cliente varchar(54),
	endereço_Cliente varchar(54),
	numeroResidencia_Cliente varchar(54),
	bairro_Cliente varchar(54),
	cidade_Cliente varchar(54),
	estado_Cliente varchar(54),
	cep_Cliente varchar(54),
	celular_Cliente varchar(54),
	email_Cliente varchar(54),
	senha_Cliente varchar(21845),
	confirmarSenha_Cliente varchar(21845)
);

insert into cliente (administrador,	id_Cliente , cpf_Cliente, nome_Cliente, sobrenome_Cliente , sexo_Cliente , DataNasc,
logradouro_Cliente, endereço_Cliente, 	numeroResidencia_Cliente,	bairro_Cliente,	cidade_Cliente,	estado_Cliente,
cep_Cliente,	celular_Cliente,	email_Cliente,	senha_Cliente,	confirmarSenha_Cliente) 
values (true,1,"458.582.848-87","Daniel","Moya da Silva","Masculino","1998-03-14","Rua","Eugênio Pessini","206",
"Jardim Itaipu","Marília","SP","17519-610","(14)9 9775-5215","smartmarketunivem@gmail.com", "123456789","123456789");
insert into cliente (administrador,	id_Cliente , cpf_Cliente, nome_Cliente, sobrenome_Cliente , sexo_Cliente , DataNasc,
logradouro_Cliente, endereço_Cliente, 	numeroResidencia_Cliente,	bairro_Cliente,	cidade_Cliente,	estado_Cliente,
cep_Cliente,	celular_Cliente,	email_Cliente,	senha_Cliente,	confirmarSenha_Cliente) 
values( false,2,"458.582.848-87","Daniel","Moya da Silva","Masculino","1998-03-14","Rua","Eugênio Pessini","206",
"Jardim Itaipu","Marília","SP","17519-610","(14)9 9775-5215","smartmarketunivem@gmail.com", "123456789","123456789");

select * from cliente;

delete from cliente where id_cliente > 0;