<%-- 
    Document   : resultadoCadastro
    Created on : Jul 22, 2016, 3:52:24 PM
    Author     : midiacom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Cadastro</title>
    </head>
    <body>
        <%
            Boolean statusCadastro = (Boolean) request.getAttribute("status");
        %>
        <h1><% if (statusCadastro) {%>
            Usuário Cadastrado com Sucesso.
            <% } else {%> 
            Email já cadastrado
            <% }%>
        </h1>
        <a href="index.html">Página Inicial</a>
    </body>
</html>
