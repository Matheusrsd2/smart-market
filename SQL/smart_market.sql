create database smart_market;
use smart_market;
CREATE TABLE cliente (
  administrador_cliente tinyint(1) DEFAULT NULL,
  id_cliente int(11) NOT NULL,
  nome_cliente varchar(54) DEFAULT NULL,
  sobrenome_cliente varchar(54) DEFAULT NULL,
  sexo_cliente varchar(54) DEFAULT NULL,
  data_nasc_cliente date DEFAULT NULL,
  logradouro_cliente varchar(54) DEFAULT NULL,
  endereco_cliente varchar(54) DEFAULT NULL,
  numero_residencia_cliente varchar(54) DEFAULT NULL,
  bairro_cliente varchar(54) DEFAULT NULL,
  cidade_cliente varchar(54) DEFAULT NULL,
  estado_cliente varchar(54) DEFAULT NULL,
  cep_cliente varchar(54) DEFAULT NULL,
  celular_cliente varchar(54) DEFAULT NULL,
  email_cliente varchar(54) DEFAULT NULL,
  senha_cliente varchar(21845) DEFAULT NULL,
  confirmarSenha_cliente varchar(21845) DEFAULT NULL
);

INSERT INTO cliente (administrador_cliente, id_cliente, nome_cliente, sobrenome_cliente, sexo_cliente,
data_nasc_cliente, logradouro_cliente, endereco_cliente, numero_residencia_cliente,
bairro_cliente, cidade_cliente, estado_cliente, cep_cliente, celular_cliente, email_cliente, senha_cliente, confirmarSenha_cliente) VALUES
(1, 1, 'Natalia', 'Siva', 'Feminino', '1987-09-12', 'Rua', 'casa', '32', 'Jartim desconhecido', 'Marília', 'SP', '93213-912', '(14) 99865-4865', '3902139213012', '123456', '123456'),
(1, 2, 'Daniel', 'Moya da Silva', 'Masculino', '1998-03-14', 'Rua', '7 setembro', '895', 'Jardim Boa vista', 'Marília', 'SP', '42343-242', '(14) 99865-4865', 'sdmasdas@dmas.com', '123456', '123456'),
(0, 3, 'Harry', 'Potter', 'Masculino', '1980-07-31', 'Rua', 'Dos Alfineiros', '4', 'Privet Drive', 'Londres', 'UK', '42343-242', '(54) 21215-54154', 'harry@bruxos.com', 'EXPECTO PATRONUM', 'EXPECTO PATRONUM'),
(0, 4, 'Lord', 'Voldemort', 'Masculino', '1926-12-31', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'voldemort@bruxos.com', 'avada kedavra', 'avada kedavra'),
(0, 5, 'Hermino', 'Granger', 'Femininoo', '1979-09-19', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Granger@bruxos.com', 'Wingardium Leviosa', 'Wingardium Leviosa'),
(0, 6, 'Ronald', 'Weasley', 'Masculino', '1980-03-01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Weasley@bruxos.com', 'Pigwidgeon', 'Pigwidgeon'),
(0, 7, 'Drago', 'Malfony', 'Masculino', '1980-06-05', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Malfony@bruxos.com', 'Sectumsempra ', 'Sectumsempra '),
(0, 8, 'Ginevra', 'Weasley', 'Feminino', '1981-08-11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Ginevra@bruxos.com', 'TALsiriusseverolunaPotter', 'TALsiriusseverolunaPotter'),
(0, 9, 'Alvo', 'Dumbledore', 'Masculino', '1881-06-11', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Alvo@bruxos.com', 'Kendra Dumbledore', 'Kendra Dumbledore');

CREATE TABLE endereco (
  id int(11) NOT NULL,
  tipo_logradouro varchar(30) DEFAULT NULL,
  logradouro varchar(255) DEFAULT NULL,
  numero varchar(30) DEFAULT NULL,
  bairro varchar(45) DEFAULT NULL,
  cidade varchar(45) DEFAULT NULL,
  estado varchar(45) DEFAULT NULL,
  cliente_id int(11) NOT NULL,
  cep varchar(30) NOT NULL
);

INSERT INTO endereco (id, tipo_logradouro, logradouro, numero, bairro, cidade, estado, cliente_id, cep) VALUES
(1, 'Rua', 'Dos Alfineiros', '4', 'Privet Drive', 'Londres', 'UK', 3, '42343-242'),
(2, 'Rua', '7 setembro', '895', 'Jardim Boa vista', 'Marília', 'SP', 2, '42343-242'),
(3,'Rua', 'casa', '32', 'Jartim desconhecido', 'Marília', 'SP', 1, '93213-912');

CREATE TABLE lista (
  id int(11) NOT NULL,
  nome varchar(255) NOT NULL
);

INSERT INTO lista (id, nome) VALUES
(1, 'Compra de Janeiro'),
(2,'Compra de Fevereiro'),
(3,'Compra de Março'),
(4,'Compra de Abril'),
(5,'Compra de Maio'),
(6,'Compra de Junho'),
(7,'Compra de Julho'),
(8,'Compra de Agosto'),
(9,'Compra de Setembro'),
(10,'Compra de Outubro'),
(11,'Compra de Novembro'),
(12,'Compra de Dezembro');
#delete from lista where id >0;

CREATE TABLE lista_produto (
  id int(11) NOT NULL,
  lista_id int(11) NOT NULL,
  tipo_produto_id int(11) NOT NULL,
  produto_id int(11) NOT NULL
);

INSERT INTO lista_produto (id, lista_id, tipo_produto_id, produto_id) VALUES
(1, 7, 2, 7),
(2, 3, 5, 7),
(3, 6, 4, 7),
(4, 1, 6, 7),
(5, 8, 2, 8),
(6, 7, 2, 8),
(7, 6, 2, 8),
(8, 12, 2, 8),
(9, 2, 2, 8),
(10, 2, 2, 8),
(11, 7, 2, 8),
(12, 1, 6, 9);
#delete from lista_produto where id > 0;

CREATE TABLE produto (
  id int(11) NOT NULL,
  nome varchar(255) NOT NULL,
  preco varchar(10) NOT NULL,
  imagem varchar(255) NOT NULL
);

INSERT INTO produto (id, nome, preco, imagem) VALUES
(1, 'Pipoca Micro-ondas Yoki Mini Bag Manteiga', 'R$ 1,15', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/9/2/923150.jpg'),
(2, 'Cerveja Glacial Lata', 'R$ 1,59', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/3/7/372536.jpg.jpg'),
(3, 'Chocolate Baton ao Leite Garoto', 'R$ 0,99', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/5/3/535010.jpg.jpg'),
(4, 'Chocolate Baton ao Leite Garoto', 'R$ 0,99', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/5/3/535010.jpg.jpg'),
(5, 'Pipoca Micro-ondas Yoki Mini Bag Manteiga', 'R$ 1,15', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/9/2/923150.jpg'),
(6, 'Cerveja Glacial Lata', 'R$ 1,59', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/3/7/372536.jpg.jpg'),
(7, 'Chocolate Baton ao Leite Garoto', 'R$ 0,99', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/5/3/535010.jpg.jpg'),
(8, 'Pipoca Micro-ondas Yoki Mini Bag Manteiga', 'R$ 1,15', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/9/2/923150.jpg'),
(9, 'Cerveja Glacial Lata', 'R$ 1,59', 'https://www.confianca.com.br/media/catalog/product/cache/1/image/160x160/9df78eab33525d08d6e5fb8d27136e95/3/7/372536.jpg.jpg');

CREATE TABLE tipo_produto (
  id int(11) NOT NULL,
  descricao varchar(255) NOT NULL
);

INSERT INTO tipo_produto (id, descricao) VALUES
(1, 'Sorvete'),
(2, 'Leite'),
(3, 'Pão'),
(4, 'Manteiga'),
(5, 'Café'),
(6, 'Cerveja'),
(7, 'Refrigerante'),
(8, 'Trigo'),
(9, 'Detergente'),
(10, 'Chocolate'),
(11, 'Legumes'),
(12, 'Frutas'),
(13, 'Bolacha'),
(14, 'Danone'),
(15, 'Brinquedo'),
(16, 'quiabo');

#1 mostre todos os clientes com dados completos. 
select c.*,e.* from cliente c inner join endereco e on(c.id_cliente = e.cliente_id);

#2 Mostre os clientes de marilia
select c.* from cliente c inner join endereco e on (c.id_cliente = e.cliente_id) where c.cidade_cliente LIKE "Marili%";

#3 Mostre as lista e o que foi comprado
select l.nome,tp.descricao from lista l right join lista_produto ls on (ls.lista_id = l.id)
left join tipo_produto tp on (tp.id = ls.tipo_produto_id);

#4 Mostre quais foram os itens mais vendidos

select sum(ls.produto_id) as QTDE, p.nome from produto p
inner join lista_produto ls 
on (p.id = ls.produto_id)
group by ls.produto_id
order by sum(ls.produto_id) desc;

#5 Quantas listas não tiveram produtos adicionados?

select count(*) as Lista from lista l where l.id
not in (select ls.lista_id from produto p inner join lista_produto ls on (p.id = ls.produto_id));
#inner join cliente cl on (cl.CODIGO_CLIENTE=p.CODIGO_CLIENTE));



