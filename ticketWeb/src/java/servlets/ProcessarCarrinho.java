/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import exception.QuantidadeIngressosInvalidaException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Pedido;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Leo
 */
public class ProcessarCarrinho extends HttpServlet
{

    private SessionFactory sf;

    @Override
    public void init() throws ServletException
    {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        sf = new Configuration().configure().buildSessionFactory();
    }

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
            throws ServletException, IOException
    {
        HttpSession httpSession = request.getSession();
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        Carrinho carrinho = (Carrinho) httpSession.getAttribute("carrinho");
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        try
        {
            //TODO criar pedido DONE
            //TODO criar pagamento DONE

            //TODO associar pedidoItems com pedido DONE
            //TODO associar pedido com usuario DONE
            //TODO associar pagamento com pedido
            Pedido pedido = new Pedido(new Date(), usuario);
            session.saveOrUpdate(pedido);

            carrinho.setPedido(pedido);
            carrinho.savePedidoItens(session);

            httpSession.setAttribute("carrinho", new Carrinho());

            tx.commit();
            session.close();
        }
        catch (QuantidadeIngressosInvalidaException ex)
        {
            tx.rollback();
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
