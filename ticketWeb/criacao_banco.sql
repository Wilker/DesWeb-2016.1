create table "USUARIO"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "NOME"  varchar(50)  not null,
    "EMAIL" varchar(100) not null unique,
    "SENHA" varchar(50)  not null
);

create table "CATEGORIA"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "NOME"  varchar(50)  not null
);

create table "LOCAL"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "NOME"  varchar(50)  not null,
    "LOGRADOURO"  varchar(100)  not null,
    "NUMERO"  int  not null,
    "BAIRRO"  varchar(50)  not null,
    "CEP"  int  not null,
    "CIDADE"  varchar(50)  not null
);

create table "EVENTO"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "DESCRICAO"  varchar(50)  not null,
    "DATA" DATE not null,
    "IDLOCAL" int  not null references LOCAL(ID),
    "IDCATEGORIA" int  not null references CATEGORIA(ID),
    "IMAGEMLINK" varchar(200) not null
);

create table "PRODUTO"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "NOME" varchar(50) not null,
    "IDEVENTO" int not null references EVENTO(ID),
    "VALOR" double not null,
    "QUANTIDADE" int not null
);

create table "PEDIDO"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "DATA" DATE not null,
    "IDUSUARIO" int not null references USUARIO(ID)
);

create table "PEDIDOITEM"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "IDPRODUTO" int not null references PRODUTO(ID),
    "QUANTIDADE" int not null,
    "VALORVENDIDO" double not null,
    "IDPEDIDO" int not null references PEDIDO(ID)
);

create table "PAGAMENTO"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "VALORCOBRADO" double not null,
    "CODFATURAMENTO" varchar(32) not null,
    "IDPEDIDO" int not null references PEDIDO(ID)
);