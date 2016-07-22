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
        <title>JSP Page</title>
    </head>
    <body>
        <%    Carrinho carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
            List<PedidoItem> lista = carrinho.getPedidoItens();
        %>
        <h1>Hello World!</h1>

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
        </table>
    </body>
</html>
