<%-- 
    Document   : carrinho
    Created on : Jul 22, 2016, 7:50:05 PM
    Author     : midiacom
--%>

<%@page import="java.util.List"%>
<%@page import="model.PedidoItem"%>
<%@page import="model.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
    </head>
    <body>
        <%    Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
            List<PedidoItem> lista = carrinho.getPedidoItens();
        %>
        <h1>Seu Carrinho</h1>

        <table>
            <tr>
                <th>Evento</th>
                <th>Produto</th>
                <th>Data</th>
                <th>Valor</th>
                <th>Quantidade</th>
                <th>Valor Total</th>
            </tr>
            <% for (PedidoItem item : lista) {%>
            <tr>
                <td><%= item.getProduto().getEvento().getDescricao()%></td>
                <td><%= item.getProduto().getNome()%></td>
                <td><%= item.getProduto().getEvento().getData()%></td>
                <td><%= item.getProduto().getValor()%></td>
                <td><%= item.getQuantidade()%></td>
                <td><%= item.getProduto().getValor() * item.getQuantidade()%></td>
            </tr>
            <% }%>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>Valot Total da Compra</td>
                <td><%= carrinho.valorTotalCarrinho()%></td>
            </tr>

        </table>

        <form action="loginUsuario.jsp">
            <input type="submit" value="Continue Compando">
        </form>

        <form action="finalizaCompra.jsp">
            <input type="submit" value="Finalizar Compra">
        </form>


    </body>
</html>
