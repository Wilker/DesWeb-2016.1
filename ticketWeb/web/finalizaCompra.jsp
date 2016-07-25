<%-- 
    Document   : finalizaCompra
    Created on : 24/07/2016, 18:03:35
    Author     : wilker
--%>

<%@page import="java.util.List"%>
<%@page import="model.PedidoItem"%>
<%@page import="model.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar a compra</title>
    </head>
    <%    
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
        List<PedidoItem> lista = carrinho.getPedidoItens();
    %>
    <h1>Insira o número do seu Cartão de Crédito</h1>
    <body>
        <p> Valor total da Compra <%= carrinho.valorTotalCarrinho()%>
        <form action="ProcessarCarrinho" method="post">
            Número:<input type="text" name="numero" pattern="[0-9]{13,16}">  
            Código de Segurnaça:<input type="text" name="cvc" pattern="[0-9]{3,3}"> <br>   
            <input type ="submit" value="Pagar">
        </form>
    </body>
</html>
