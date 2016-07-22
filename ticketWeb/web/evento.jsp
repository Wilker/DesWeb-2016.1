<%-- 
    Document   : evento
    Created on : Jul 21, 2016, 11:49:30 PM
    Author     : leo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page import="model.Local"%>
<%@page import="model.Evento"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    AnnotationConfiguration conf = new AnnotationConfiguration();
    conf.configure();
    SessionFactory sf = conf.buildSessionFactory();
    Session s = sf.openSession();
    
    String hql = "select e from Evento e where e.id = :id";
    Query query = s.createQuery(hql);
    query.setParameter("id", Integer.parseInt(request.getParameter("id")));
    Evento evento = (Evento) query.list().get(0);
    Local local = evento.getLocal();
    List<Produto> produtos = evento.getProdutos();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= evento.getDescricao() %></title>
    </head>
    <body>
        <h1><%= evento.getDescricao() %></h1>
        <p>Data: <%= evento.getData() %></p>
        <p>Local: <%= local.getNome() %></p>
        <p>Logradouro: <%= local.getLogradouro() %> <%= local.getNumero() %>,
            <%= local.getBairro() %> - <%= local.getCidade() %></p>
        <p>Categoria: <%= evento.getCategoria().getNome() %></p>
        
        <div id="produtos">
        <table>
            <tr>
                <th>Nome</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>

            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><c:out value="${produto.getNome()}" /></td>
                    <td><c:out value="${produto.getValor()}" /></td>
                    <td><c:out value="${produto.getQuantidade()}" /></td>
                </tr>
            </c:forEach>

        </table>
        </div>
    
    </body>
</html>
