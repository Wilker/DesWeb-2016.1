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
    "NOME"  varchar(50)  not null,
    "DATA" DATE not null,
    "IDLOCAL" int  not null references LOCAL(ID),
    "IDCATEGORIA" int  not null references CATEGORIA(ID)
);