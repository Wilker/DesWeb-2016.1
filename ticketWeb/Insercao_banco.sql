INSERT INTO TICKET.USUARIO (NOME, EMAIL, SENHA) 
	VALUES ('Wilker', 'Wilker.rj@gmail.com', '123456');

INSERT INTO TICKET.USUARIO (NOME, EMAIL, SENHA) 
	VALUES ('Leonardo', 'leovaladares@outlook.com', '1234');

INSERT INTO TICKET."LOCAL" (NOME, LOGRADOURO, NUMERO, BAIRRO, CEP, CIDADE) 
	VALUES ('Vivo Rio', 'Rua Sei lá', 666, 'Fragmengo', 2121212121, 'Rio de Janeiro');

INSERT INTO TICKET.CATEGORIA (NOME) 
	VALUES ('Show');

INSERT INTO TICKET.EVENTO (DESCRICAO, "DATA", IDLOCAL, IDCATEGORIA) 
	VALUES ('Massacration', '2016-07-23', 1, 1);

INSERT INTO TICKET.EVENTO (DESCRICAO, "DATA", IDLOCAL, IDCATEGORIA) 
	VALUES ('Black Sabbath', '2016-12-2', 1, 1);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista Comum', 1, 100.0, 10);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista Premium', 1, 150.0, 4);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista', 2, 200.0, 10)

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Arquibancada', 2, 100.0, 20)
