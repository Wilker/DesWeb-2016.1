<%-- 
    Document   : detalhesPedido
    Created on : Jul 25, 2016, 3:41:02 PM
    Author     : midiacom
--%>

<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes Pedido</title>
        
        <style>
            *, html, body { font-family: Verdana; font-size:15px;  }
            #meusItens { width:400px; height:400px; position:absolute; top:50%; left:50%; margin-top:-200px; margin-left:-200px;}
            label {width:80px; display:block; }
            h1{font-size:24px; }
        </style>
        
    </head>
    <%
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session s = sf.openSession();

        String hql = "select e from Pedido e where e.id = :id";
        Query query = s.createQuery(hql);
        query.setParameter("id", Integer.parseInt(request.getParameter("id")));
        Pedido pedido = (Pedido) query.list().get(0);
        List<PedidoItem> pedidoItens = pedido.getItens();


    %>
    <body>

        <div id="meusItens">
            <h2>Produtos Comprados</h2>
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Tipo</th>
                    <th>Valor</th>
                    <th>Quantidade</th>
                    <th>Valor Total</th>
                </tr>
                <% for (PedidoItem pedItem : pedidoItens) {%>
                <tr>
                    <td><%= pedItem.getProduto().getEvento().getDescricao()%></td>
                    <td><%= pedItem.getProduto().getNome()%></td>
                    <td><%= pedItem.getValorVendido()%></td>
                    <td><%= pedItem.getQuantidade()%></td>
                    <td><%= pedItem.getQuantidade() * pedItem.getValorVendido()%></td>
                </tr>
                <% }%>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Cod Faturamento</td>
                    <td><%= pedido.getPagamento().getCodFaturamento() %></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total do Pedido</td>
                    <td><%= pedido.getPagamento().getValorCobrado()%></td>
                </tr>
            </table>
        </div>
    </body>
</html>
