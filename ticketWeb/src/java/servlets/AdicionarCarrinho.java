/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author leo
 */
public class AdicionarCarrinho extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Carrinho carrinho = (Carrinho) httpSession.getAttribute("carrinho");

        Produto produto = null;
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        try {
            AnnotationConfiguration conf = new AnnotationConfiguration();
            conf.configure();
            SessionFactory sf = conf.buildSessionFactory();
            Session session = sf.openSession();
            produto = (Produto) session.get(model.Produto.class, idProduto);
            session.close();
        } catch (Exception ex) {

        }

        PedidoItem pi = new PedidoItem(produto, quantidade, produto.getValor());

        if (!carrinho.addPedidoItem(pi)) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Limite de 4 ingressos!');");
                out.println("history.go(-1);");
                out.println("</script>");
                
            }
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginUsuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
