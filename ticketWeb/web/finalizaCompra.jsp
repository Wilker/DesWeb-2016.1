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

        <style>
            *, html, body { font-family: Verdana; font-size:15px;  }
            label {width:160px; display:block; margin-top:10px; }
            h1{font-size:24px; }
            #container{width:600px; height:600px; position:absolute; top:40%; left:50%; margin-top:-300px; margin-left:-300px;}
            table { border-collapse: collapse; width:100%;}
            table, th, td { border: 1px solid black; padding:8px; text-aling:center;}
        </style>

    </head>
    <%
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
        List<PedidoItem> lista = carrinho.getPedidoItens();
    %>
    <body>
        <div id="container">
            <h1>Insira o número do seu Cartão de Crédito</h1>
            <p> Valor total da Compra <%= carrinho.valorTotalCarrinho()%> </p>
            <form action="ProcessarCarrinho" method="post">
                Nome:<input type="text" name="nome"required> <br>
                Número:<input type="text" name="numeroCC" pattern="[0-9]{13,16}"required> <br>
                Mês de Vencimento:<input type="text" name="mesValidade" pattern="[0-9]{2,2}" required>  <br>
                Ano de Vencimento:<input type="text" name="anoValidade" pattern="[0-9]{4,4}"required>  <br>
                Código de Segurnaça:<input type="text" name="cvc" pattern="[0-9]{3,3}"required> <br>   
                <input type ="submit" value="Pagar">
            </form>
        </div>
    </body>
</html>
