create database db_ecommerce;

use db_ecommerce;

create table tb_usuario(
	id bigint auto_increment,
    nome_completo varchar(100) not null,
    email varchar(100) not null,
    senha varchar(60) not null,
	localizacao varchar(150) not null,
    avaliacao_usuario int,
    vendedor boolean not null,
    consumidor boolean not null,
    primary key (id)
);

create table tb_categoria(
	id bigint auto_increment,
    produtos_servicos varchar(100) not null,
    ativo boolean not null,
    vegano boolean,
    primary key (id)
);

create table tb_produtos(
	id bigint auto_increment,
    usuario_id bigint,
    categoria_id bigint,
    nome_produto_servico varchar(100) not null,
    preco_produto_servico decimal(8,2) not null,
    quantidade_consumidor int not null,
    estoque_vendedor int,
	localizacao varchar(150) not null,
	descricao_produto_servico varchar(300) not null,
	avaliacao_produto_servico int,
    primary key (id),
    foreign key (usuario_id) references tb_usuario (id),
    foreign key (categoria_id) references tb_categoria (id)
    );