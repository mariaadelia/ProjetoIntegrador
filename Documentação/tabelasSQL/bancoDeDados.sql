create database db_ecommerce;

use db_ecommerce;

create table tb_usuario(
id bigint auto_increment,
nome_completo varchar(100) not null,
email varchar(100) not null,
senha varchar(60) not null,
validar_senha varchar (60) not null, -- validando a senha
vendedor boolean not null, -- talvez coloque default
primary key (id)
);

create table tb_categoria(
id bigint auto_increment,
produtos_servicos varchar(100) not null,
palavras_chave varchar(100),
descricao varchar(1250),
primary key (id)
);

create table tb_produtos(
id bigint auto_increment,
usuario_id bigint,
categoria_id bigint,
nome_produto_servico varchar(100) not null,
preco_produto_servico decimal(8,2) not null,
estoque_vendedor int,
descricao_produto_servico varchar(1250) not null,
like_produto_servico bigint,
dislike_produto_servico bigint,
midias varchar(1250), -- Imagens + videos do produto
primary key (id),
foreign key (usuario_id) references tb_usuario (id),
foreign key (categoria_id) references tb_categoria (id)
);

select * from db_ecommerce.tb_usuario;
select * from db_ecommerce.tb_categoria;
select * from db_ecommerce.tb_produtos;