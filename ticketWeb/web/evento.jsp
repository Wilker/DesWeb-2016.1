<%-- 
    Document   : evento
    Created on : Jul 21, 2016, 11:49:30 PM
    Author     : leo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
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

    HttpSession httpSession = request.getSession();
    Usuario usuario = (Usuario) httpSession.getAttribute("usuario");

    List<Pedido> pedidosAnteriores = usuario.getPedidos(); //vai no banco e lista todos os pedidos anteriores

    List<PedidoItem> anteriores = new ArrayList<PedidoItem>();

    for (int i = 0; i < pedidosAnteriores.size(); i++) {

        //aqui tnho lista com todos os pedidos itens anteriores
        List<PedidoItem> produtosAnteriores = pedidosAnteriores.get(i).getItens();

        for (PedidoItem pedItem : produtosAnteriores) {
            if (pedItem.getProduto().getEvento().equals(evento)) {
                anteriores.add(pedItem);
            }//neste ponto já tenho tods os pedidos itens anteriores deste evento. 
        }
    }

//calcular agora o ingresso máximo para cada tipo de ingresso
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= evento.getDescricao()%></title>

        <style>
            *, html, body { font-family: Verdana; font-size:15px;  }
            label {width:80px; display:block; }
            h1{font-size:24px; }
            #container{width:600px; height:600px; position:absolute; top:40%; left:50%; margin-top:-300px; margin-left:-300px;}
            table { border-collapse: collapse; width:100%;}
            table, th, td { border: 1px solid black; padding:8px; text-aling:center;}

        </style>

    </head>
    <body>
        <div id="container">
            <h1><%= evento.getDescricao()%></h1>

            <img src="<%= evento.getImagemLink()%>">

            <p>Data: <%= evento.getData()%></p>
            <p>Local: <%= local.getNome()%></p>
            <p>Logradouro: <%= local.getLogradouro()%> <%= local.getNumero()%>,
                <%= local.getBairro()%> - <%= local.getCidade()%></p>
            <p>Categoria: <%= evento.getCategoria().getNome()%></p>

            <div id="produtosAssociados">
                <table>
                    <tr>
                        <th>Nome</th>
                        <th>Valor</th>
                        <th>Ingressos disponiveis</th>
                        <th>Quantidade</th>
                        <th>Adicionar Carrinho</th>
                    </tr>

                    <% for (Produto produto : produtos) {%>
                    <tr>
                        <td><%= produto.getNome()%></td>
                        <td><%= produto.getValor()%></td>
                        <td><%= produto.getQuantidadeItens()%></td>

                    <form action="AdicionarCarrinho" method="post">
                        <input type="hidden" name="idProduto" value="<%= produto.getId()%>" />
                        <td>
                            <select name="quantidade">
                                <%
                                    int totalAnterior = 0;
                                    for (int i = 0; i < anteriores.size(); i++) {
                                        if (anteriores.get(i).getProduto().getEvento().equals(evento)) {
                                            totalAnterior += anteriores.get(i).getQuantidade();
                                        }
                                    }
                                    int maxIngressos = 0;
                                    if (totalAnterior < 4) {
                                        if (totalAnterior == 0) {
                                            maxIngressos = (produto.getQuantidadeItens() < 4) ? produto.getQuantidadeItens() : 4;
                                        } else {
                                            maxIngressos = (produto.getQuantidadeItens() < 4) ? produto.getQuantidadeItens() : 4 - totalAnterior;
                                        }
                                    }
                                    for (int i = 0; i <= maxIngressos; i++) {%>

                                <option value="<%= i%>"><%= i%></option>

                                <% } %>
                            </select>
                        </td>

                        <td><input type="submit" value="Adicionar ao Carrinho"></td>
                    </form>

                    </tr>
                    <% }%>

                </table>
            </div>
        </div>
    </body>
</html>
