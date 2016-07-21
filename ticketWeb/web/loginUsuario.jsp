<%-- 
    Document   : loginUsuario
    Created on : 21/07/2016, 19:49:08
    Author     : wilker
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Bem vindo <% Usuario usuario = (Usuario) request.getAttribute("usuario");
            usuario.getNome();
            %></h1>
    </body>
</html>
