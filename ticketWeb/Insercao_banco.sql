INSERT INTO TICKET.USUARIO (NOME, EMAIL, SENHA) 
	VALUES ('Wilker', 'Wilker.rj@gmail.com', '123456');

INSERT INTO TICKET.USUARIO (NOME, EMAIL, SENHA) 
	VALUES ('Leonardo', 'leovaladares@outlook.com', '1234');

INSERT INTO TICKET."LOCAL" (NOME, LOGRADOURO, NUMERO, BAIRRO, CEP, CIDADE) 
	VALUES ('Vivo Rio', 'Rua Sei lá', 666, 'Fragmengo', '12345-678', 'Rio de Janeiro');

INSERT INTO TICKET."LOCAL" (NOME, LOGRADOURO, NUMERO, BAIRRO, CEP, CIDADE) 
	VALUES ('Morumbi', 'Praça Roberto Gomes Pedrosa', 1, 'Morumbi', '05653-070', 'São Paulo');

INSERT INTO TICKET.CATEGORIA (NOME) 
	VALUES ('Show');

INSERT INTO TICKET.EVENTO (DESCRICAO, "DATA", IDLOCAL, IDCATEGORIA, IMAGEMLINK) 
	VALUES ('Massacration', '2016-07-23', 1, 1, 'http://f.i.uol.com.br/guia/passeios/images/11193537.jpeg');
INSERT INTO TICKET.EVENTO (DESCRICAO, "DATA", IDLOCAL, IDCATEGORIA, IMAGEMLINK) 
	VALUES ('Black Sabbath', '2016-12-2', 2, 1, 'http://i.dailymail.co.uk/i/pix/2013/01/27/article-2268967-17303D51000005DC-467_640x442.jpg');

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista Comum', 1, 100.0, 10);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista Premium', 1, 150.0, 4);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista', 2, 200.0, 10);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Arquibancada', 2, 100.0, 20);

INSERT INTO TICKET."LOCAL" (NOME, LOGRADOURO, NUMERO, BAIRRO, CEP, CIDADE) 
	VALUES ('Praça do Pq União', 'Av. Brasil', 2000, 'Maré', '21044020', 'Rio de Janeiro');

INSERT INTO TICKET."LOCAL" (NOME, LOGRADOURO, NUMERO, BAIRRO, CEP, CIDADE) 
	VALUES ('Apoteose', 'Av. Presidente Vargas', 123, 'Centro', '21212121', 'Rio de Janeiro');

INSERT INTO TICKET.EVENTO (DESCRICAO, "DATA", IDLOCAL, IDCATEGORIA, IMAGEMLINK) 
	VALUES ('Judas Priest', '2016-07-30', 3, 1, 'http://www.judaspriest.com/images/2014/Judas-Priest-Logo-Black-800x462.jpg');

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Pista', 3, 200.0, 2);

INSERT INTO TICKET.PRODUTO (NOME, IDEVENTO, VALOR, QUANTIDADE) 
	VALUES ('Arquibancada', 3, 75.0, 25);
