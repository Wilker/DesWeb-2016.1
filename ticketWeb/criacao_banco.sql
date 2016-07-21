create table "USUARIO"
(
    "ID" int not null primary key generated always as identity (start with 1, increment by 1),
    "NOME"  varchar(50)  not null,
    "EMAIL" varchar(100) not null unique,
    "SENHA" varchar(50)  not null
)