<%-- 
    Document   : loginUsuario
    Created on : 21/07/2016, 19:49:08
    Author     : wilker
--%>

<%@page import="model.Pedido"%>
<%@page import="model.Carrinho"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Usuario"%>
<%@page import="model.Evento"%>
<%@page import="model.Local"%>
<%@page import="model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            usuario.getNome();

            AnnotationConfiguration conf = new AnnotationConfiguration();
            conf.configure();
            SessionFactory sf = conf.buildSessionFactory();
            Session s = sf.openSession();

            String eventosQueryString = "select e from Evento e";
            Query eventosQuery = s.createQuery(eventosQueryString);
            List<Evento> eventos = (List<Evento>) eventosQuery.list();

        %>
        <h1>Bem vindo <%= usuario.getNome()%></h1>

        <div id="todosEventos">
            <h2>Eventos disponiveis</h2>

            <table>
                <tr>
                    <th>Evento</th>
                    <th>Data</th>
                    <th>Local</th>
                    <th>Categoria</th>
                </tr>

                <% for (Evento evento : eventos) {%>
                <tr>

                    <td><%= evento.getDescricao()%></td>
                    <td><%= evento.getData()%></td>
                    <td><%= evento.getLocal().getNome()%></td>
                    <td><%= evento.getCategoria().getNome()%></td>
                    <td><a href="evento.jsp?id=<%= evento.getId()%>">Infos</a></td>
                </tr>
                <% }%>
            </table>
            <form action="carrinho.jsp">
                <input type="submit" value="Vá para o carrinho">
            </form>
        </div>

        <div id="meusPedidos">
            <h2>Pedidos Anteriores</h2>
            <% List<Pedido> lista = usuario.getPedidos();
            %>


            <table>
                <tr>
                    <th>Código Pedido</th>
                    <th>Data</th>
                    <th>Valor Total</th>
                </tr>

                <% for (Pedido l : lista) {%>
                <tr>

                    <td><%= l.getId()%></td>
                    <td><%= l.getData()%></td>
                    <td><%= l.getValorTotal()%></td>
                    <td><a href="detalhesPedido.jsp?id=<%= l.getId()%>">Infos</a></td>
                </tr>
                <% }%>
            </table>
        </div>



    </body>
</html>
