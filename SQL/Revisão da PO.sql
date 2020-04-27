CREATE DATABASE revisao_po;
USE revisao_po;

CREATE TABLE categoria (
 id_categoria INT AUTO_INCREMENT NOT NULL ,
 descricao VARCHAR(20) NOT NULL ,
 CONSTRAINT pk_categoria PRIMARY KEY (id_categoria) );

CREATE TABLE cliente (
 cod_cliente INT NOT NULL ,
 nome VARCHAR(40) NOT NULL ,
 cidade VARCHAR(30) NULL ,
 sexo CHAR(1) NULL ,
 CONSTRAINT pk_cliente PRIMARY KEY (cod_cliente) );

CREATE TABLE fornecedor (
 id_fornecedor INT AUTO_INCREMENT NOT NULL ,
 nome VARCHAR(40) NOT NULL ,
 CONSTRAINT pk_fornecedor PRIMARY KEY (id_fornecedor) );

CREATE TABLE unidade (
 cod_unidade CHAR(2) NOT NULL ,
 descricao VARCHAR(20) NOT NULL ,
 CONSTRAINT pk_unidade PRIMARY KEY (cod_unidade) );

CREATE TABLE produto (
 cod_produto INT NOT NULL ,
 descricao VARCHAR(30) NOT NULL ,
 valor_unit FLOAT NOT NULL ,
 estoque INT NULL ,
 id_categoria INT NULL ,
 cod_unidade CHAR(2) NULL ,
 CONSTRAINT pk_produto PRIMARY KEY (cod_produto) ,
 CONSTRAINT fk_produto_categoria
  FOREIGN KEY (id_categoria )
  REFERENCES categoria (id_categoria ),
 CONSTRAINT fk_produto_unidade
  FOREIGN KEY (cod_unidade )
  REFERENCES unidade (cod_unidade ));

CREATE TABLE produto_fornecedor (
 cod_produto INT NOT NULL ,
 id_fornecedor INT NOT NULL ,
 CONSTRAINT pk_produto_fornecedor PRIMARY KEY (id_fornecedor, cod_produto) ,
 CONSTRAINT fk_produto_fornecedor_fornecedor
  FOREIGN KEY (id_fornecedor )
  REFERENCES fornecedor (id_fornecedor ),
 CONSTRAINT fk_produto_fornecedor_produto
  FOREIGN KEY (cod_produto )
  REFERENCES produto (cod_produto ));

CREATE TABLE vendedor (
 cod_vendedor INT NOT NULL ,
 nome VARCHAR(40) NOT NULL ,
 comissao FLOAT NULL ,
 CONSTRAINT pk_vendedor PRIMARY KEY (cod_vendedor) );

CREATE TABLE venda (
 id_venda INT AUTO_INCREMENT NOT NULL ,
 data DATETIME NOT NULL ,
 cod_vendedor INT NOT NULL ,
 cod_cliente INT NOT NULL ,
 tipo_pagamento CHAR(1) NOT NULL ,
 CONSTRAINT pk_venda PRIMARY KEY (id_venda) ,
 CONSTRAINT fk_venda_cliente
  FOREIGN KEY (cod_cliente )
  REFERENCES cliente (cod_cliente ),
 CONSTRAINT fk_venda_vendedor
  FOREIGN KEY (cod_vendedor )
  REFERENCES vendedor (cod_vendedor ),
 CONSTRAINT ck_venda_tipo_pagamento CHECK (tipo_pagamento in ('V','P'))
);

CREATE TABLE venda_item (
 id_venda INT NOT NULL ,
 cod_produto INT NOT NULL ,
 qtde INT NOT NULL ,
 valor FLOAT NOT NULL ,
 CONSTRAINT pk_venda_item PRIMARY KEY (id_venda, cod_produto) ,
 CONSTRAINT fk_venda_item_produto
  FOREIGN KEY (cod_produto )
  REFERENCES produto (cod_produto ),
 CONSTRAINT fk_venda_item_venda
  FOREIGN KEY (id_venda )
  REFERENCES venda (id_venda ));
  
  INSERT INTO categoria(id_categoria,descricao) VALUES (1,'Analgésico');
INSERT INTO categoria(id_categoria,descricao) VALUES (2,'Antiflamatório');
INSERT INTO categoria(id_categoria,descricao) VALUES (3,'Antidepressivo');
INSERT INTO categoria(id_categoria,descricao) VALUES (4,'Antiácido');
INSERT INTO categoria(id_categoria,descricao) VALUES (5,'Vitaminas');
INSERT INTO categoria(id_categoria,descricao) VALUES (6,'Antibiótico');

INSERT INTO unidade(cod_unidade,descricao) VALUES ('AM','Ampola');
INSERT INTO unidade(cod_unidade,descricao) VALUES ('CX','Caixa');
INSERT INTO unidade(cod_unidade,descricao) VALUES ('UN','Unidade');
INSERT INTO unidade(cod_unidade,descricao) VALUES ('VD','Vidro');

INSERT INTO fornecedor(id_fornecedor,nome) VALUES (1,'PHOELAB');
INSERT INTO fornecedor(id_fornecedor,nome) VALUES (2,'EUROMED');
INSERT INTO fornecedor(id_fornecedor,nome) VALUES (3,'FARMEX');
INSERT INTO fornecedor(id_fornecedor,nome) VALUES (4,'DIVAMED');
INSERT INTO fornecedor(id_fornecedor,nome) VALUES (5,'LIFE LOG');

INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (1,'Dipirona',3.34,18,1,'CX');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (2,'Ibuprofeno',5.86,37,1,'CX');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (3,'Forten',42.01,82,5,'UN');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (9,'Cebion',8.52,82,5,'UN');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (12,'Estomazil',1.63,82,1,'UN');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (32,'DPrev',19.27,82,5,'UN');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (38,'Novalgina',3.02,7,1,'CX');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (72,'Sal de Frutas Eno',1.94,23,1,'UN');
INSERT INTO produto(cod_produto,descricao,valor_unit,estoque,id_categoria,cod_unidade) VALUES (87,'Sandoz',14.08,82,5,'UN');

INSERT INTO produto_fornecedor(cod_produto,id_fornecedor) VALUES (12,2);
INSERT INTO produto_fornecedor(cod_produto,id_fornecedor) VALUES (12,3);
INSERT INTO produto_fornecedor(cod_produto,id_fornecedor) VALUES (12,5);
INSERT INTO produto_fornecedor(cod_produto,id_fornecedor) VALUES (38,1);
INSERT INTO produto_fornecedor(cod_produto,id_fornecedor) VALUES (72,2);
INSERT INTO produto_fornecedor(cod_produto,id_fornecedor) VALUES (72,5);

INSERT INTO cliente(cod_cliente,nome,cidade,sexo) VALUES (100,'José da Silva','Marília','M');
INSERT INTO cliente(cod_cliente,nome,cidade,sexo) VALUES (200,'Ana Flávia Ramos','Marília','F');
INSERT INTO cliente(cod_cliente,nome,cidade,sexo) VALUES (300,'Anderson Cruz','Marília','M');
INSERT INTO cliente(cod_cliente,nome,cidade,sexo) VALUES (400,'Pedro Santiago','Bauru','M');
INSERT INTO cliente(cod_cliente,nome,cidade,sexo) VALUES (500,'Renata Marcondes','Jaú','F');
INSERT INTO cliente(cod_cliente,nome,cidade,sexo) VALUES (600,'João Moreira','Marília','M');

INSERT INTO vendedor(cod_vendedor,nome,comissao) VALUES (10,'Ricardo Santana',8);
INSERT INTO vendedor(cod_vendedor,nome,comissao) VALUES (20,'Sandro Fernandes',12);
INSERT INTO vendedor(cod_vendedor,nome,comissao) VALUES (30,'Bárbara Santos',10);
INSERT INTO vendedor(cod_vendedor,nome,comissao) VALUES (40,'Simone Andrade',11);
INSERT INTO vendedor(cod_vendedor,nome,comissao) VALUES (50,'Jonas de Oliveira',7);
INSERT INTO vendedor(cod_vendedor,nome,comissao) VALUES (60,'Fernando Amorim',12);

insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-10-17',30,400,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-09-17',20,100,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-10-17',30,200,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-11-17',40,400,'P');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-08-17',10,300,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-07-17',30,300,'P');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-10-17',10,500,'P');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-02-17',20,200,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2017-10-17',50,300,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2018-04-08',20,100,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2018-10-12',10,300,'V');
insert into venda (data,cod_vendedor,cod_cliente,tipo_pagamento)
values ('2018-04-08',40,500,'P');

insert into venda_item values (2,12,4,1.80);
insert into venda_item values (1,3,1,40.00);
insert into venda_item values (3,2,2,5.81);
insert into venda_item values (3,9,5,8.50);
insert into venda_item values (4,38,1,3.00);
insert into venda_item values (5,72,1,1.94);
insert into venda_item values (6,32,3,19.00);
insert into venda_item values (6,87,2,14.08);
insert into venda_item values (6,2,2,5.81);
insert into venda_item values (7,9,1,8.50);
insert into venda_item values (7,12,5,1.63);
insert into venda_item values (8,38,2,3.02);
insert into venda_item values (9,3,1,42.00);
insert into venda_item values (9,12,1,1.63);
insert into venda_item values (10,2,4,5.85);
insert into venda_item values (11,1,1,3.34);
insert into venda_item values (11,9,1,8.50);
insert into venda_item values (11,38,2,3.00);
insert into venda_item values (11,87,1,13.00);

#1) Mostrar os produtos e o nome do fornecedor cujo o id do fornecedor é 1.
select f.id_fornecedor,f.nome,p.descricao from fornecedor f 
inner join produto_fornecedor pf on(pf.id_fornecedor = f.id_fornecedor)
inner join produto p on (p.cod_produto=pf.cod_produto) having id_fornecedor = 1;
#2) Mostre os produtos que tiveram mais vendas em quantidade.

select sum(vi.qtde) as QTDE, p.descricao from produto p
inner join venda_item vi 
on (p.cod_produto = vi.cod_produto)
group by vi.cod_produto
order by sum(vi.qtde) desc;

select *from venda_item;

#3) Mostre os vendedores que tiveram vendas em outubro de 2017.
select * from venda;
select * from vendedor;
select v.nome, ven.data from vendedor v
inner join venda ven on (v.cod_vendedor = ven.cod_vendedor) 
having year(ven.data)=2017 and month(ven.data)=10
order by ven.cod_vendedor desc;
#4) Mostre os clientes que não compraram em 2018.
select * from cliente;
select * from venda;
#Pega a tabela cliente e a tabela venda e compara os id que não estão na tabela de venda

select nome from cliente  where cod_cliente 
not in(select ven.data from cliente c 
inner join venda ven on(c.cod_cliente = ven.cod_cliente)
having year(ven.data)=2018 order by c.nome desc);

#5) Mostre o nome dos vendedores e o total de vendas à vista e a prazo desses vendedores.
select * from vendedor;
select * from venda;
select * from produto;
select * from venda_item;
select v.nome,(select sum(i.qtde*p.valor_unit)
from venda ven inner join venda_item i on(ven.id_venda=i.id_venda)
inner join produto p on (i.cod_produto = p.cod_produto)
where ven.tipo_pagamento='P' and v.cod_vendedor=ven.cod_vendedor) as prazo,
(select sum(i.qtde*p.valor_unit)
from venda ven inner join venda_item i on(ven.id_venda=i.id_venda)
inner join produto p on (i.cod_produto = p.cod_produto)
where ven.tipo_pagamento='V' and v.cod_vendedor=ven.cod_vendedor) as Avista
from vendedor v;

#precisa fazer 2 select um para V e outro para P
#6) Mostre o nome dos clientes e o % de vendas à vista e a prazo desses clientes.



