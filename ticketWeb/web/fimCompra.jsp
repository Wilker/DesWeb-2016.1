<%-- 
    Document   : fimCompra
    Created on : Jul 26, 2016, 5:18:27 PM
    Author     : midiacom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra Finalizada</title>
        
        <style>
            *, html, body { font-family: Verdana; font-size:15px;  }
            #fimCompra { width:500px; height:400px; position:absolute; top:50%; left:50%; margin-top:-200px; margin-left:-200px;}
            label {width:80px; display:block; }
            h1{font-size:24px;}
        </style>
        
    </head>
    
    <body>
        <div id="fimCompra">
            <h2>Compra finalizada com sucesso. <br><h2>

            <h1>Anote o número do seu pedido <br>
                Pedido Número: 
            <%= request.getSession().getAttribute("nmrPedido")%> </h1>

            <form action="loginUsuario.jsp">
            <input type="submit" value="Página Inicial">
        </div>
    </body>
</html>