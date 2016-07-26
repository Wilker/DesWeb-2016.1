<%-- 
    Document   : filtrarCidade
    Created on : Jul 25, 2016, 9:06:03 PM
    Author     : leo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Evento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        List<Evento> eventos = (List<Evento>) request.getAttribute("eventos");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos em <%= request.getParameter("cidade")%> </title>

        <style>
            *, html, body { font-family: Verdana; font-size:15px;  }
            label {width:160px; display:block; margin-top:10px; }
            h1{font-size:24px; }
            #eventos{width:600px; height:600px; position:absolute; top:40%; left:50%; margin-top:-300px; margin-left:-300px;}
            table { border-collapse: collapse; width:100%;}
            table, th, td { border: 1px solid black; padding:8px; text-aling:center;}
        </style>

    </head>
    <body>

        <div id="titulo" style="center">
            <h1>Eventos em <%= request.getParameter("cidade")%> </h1>
        </div>

        <div id="eventos">
            <table>
                <tr>
                    <th></th>
                    <th>Evento</th>
                    <th>Data</th>
                    <th>Local</th>
                    <th>Categoria</th>
                </tr>

                <% for (Evento evento : eventos) {%>
                <tr>
                    <td><a href="evento.jsp?id=<%= evento.getId()%>"> <img src="<%= evento.getImagemLink()%>" height="100" width="100"></a></td>
                    <td><%= evento.getDescricao()%></td>
                    <td><%= evento.getData()%></td>
                    <td><%= evento.getLocal().getNome()%></td>
                    <td><%= evento.getCategoria().getNome()%></td>
                    <td><a href="evento.jsp?id=<%= evento.getId()%>">Infos</a></td>
                </tr>
                <% }%>
            </table>
        </div>

    </body>
</html>
