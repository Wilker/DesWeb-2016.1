/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author wilker
 */
public class LoginUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure();
        conf.addAnnotatedClass(Usuario.class);
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        String email = request.getParameter("login");

        String hql = "FROM Usuario U WHERE U.email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List results = query.list();
        Usuario usuario = null;

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginUsuario.jsp");

        if (results == null || results.size() < 1) {
            dispatcher = getServletContext().getRequestDispatcher("/index.html");
            dispatcher.forward(request, response);
        } else {
            usuario = (Usuario) results.get(0);
        }

        String eventosQueryString = "select e from Evento e";
        Query eventosQuery = session.createQuery(eventosQueryString);
        List eventosResult = eventosQuery.list();

        if (validarLogin(usuario, request.getParameter("passwd"))) {
            request.setAttribute("usuario", usuario);
            request.setAttribute("eventos", eventosResult);
            dispatcher.forward(request, response);
        } else { //  TODO Escrever mensagem de erro.
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet LoginUsuario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet LoginUsuario at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    boolean validarLogin(Usuario usuario, String senha) {
        return usuario.getSenha().equals(senha);
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
