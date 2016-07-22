<%-- 
    Document   : loginUsuario
    Created on : 21/07/2016, 19:49:08
    Author     : wilker
--%>

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
            Usuario usuario = (Usuario) request.getAttribute("usuario");
            usuario.getNome();

            List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
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
            <c:forEach items="${eventos}" var="evento">
            <tr>
                <td><c:out value="${evento.getDescricao()}" /></td>
                <td><c:out value="${evento.getData()}" /></td>
                <td><c:out value="${evento.getLocal().getNome()}" /></td>
                <td><c:out value="${evento.getCategoria().getNome()}" /></td>
                <td><a href="evento.jsp?id=${evento.getId()}">Infos</a></td>
            </tr>
            </c:forEach>
        </table>
        </div>
        
        <div id="meusEventos">
            
        </div>
    </body>
</html>
