<%-- 
    Document   : loginUsuario
    Created on : 21/07/2016, 19:49:08
    Author     : wilker
--%>

<%@page import="org.hibernate.criterion.Projections"%>
<%@page import="org.hibernate.*"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
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
            
            List<Evento> eventos = s.createCriteria(Evento.class).list();
            
            
            Criteria cidadesCriteria = s.createCriteria(Local.class);
            List<String> cidades = (List<String>) cidadesCriteria.setProjection(Projections.distinct(Projections.property("cidade"))).list();
        %>
        <h1>Bem vindo <%= usuario.getNome()%></h1>
        
        <div id="buscas">
            <h2>Buscas</h2>
            
            <form action="FiltrarCidade" method="post">
            <select name="cidade" onchange="this.form.submit();">
                
                <option selected disabled>Selecione uma cidade</option>
                <% for(String cidade : cidades) { %>
                <option value="<%= cidade %>"><%= cidade %></option>
                <% } %>
                
            </select>
            </form>
        </div>

        <div id="todosEventos">
            <h2>Eventos disponiveis</h2>

            <table>
                <tr>
                    <th>Evento</th>
                    <th>Data</th>
                    <th>Local</th>
                    <th>Categoria</th>
                </tr>

                <% for(Evento evento : eventos) { %>
                <tr>
                    <td><img src="<%= evento.getImagemLink() %>" height="100" width="100"></td>
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
            <% 
                List<Pedido> lista = s.createCriteria(Pedido.class).list();
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
