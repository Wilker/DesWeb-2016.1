/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import exception.InvalidCreditCardOperationException;
import exception.QuantidadeIngressosInvalidaException;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.*;
import org.hibernate.*;
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
        
        String numeroCC = request.getParameter("numeroCC");
        String cvc = request.getParameter("cvc");
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        try
        {
            //TODO criar pedido DONE
            //TODO criar pagamento DONE

            //TODO associar pedidoItems com pedido DONE
            //TODO associar pedido com usuario DONE
            //TODO associar pagamento com pedido DONE
            Pedido pedido = new Pedido(new Date(), usuario);
            session.saveOrUpdate(pedido);
            
            Pagamento pagamento = new Pagamento(carrinho.valorTotalCarrinho(), pedido);
            String codFaturamento = APICartao.faturar(pagamento.getValorCobrado(),
                                                      numeroCC, cvc);
            pagamento.setCodFaturamento(codFaturamento);
            session.saveOrUpdate(pagamento);
            
            carrinho.setPedido(pedido);
            carrinho.savePedidoItens(session);
            
            httpSession.setAttribute("carrinho", new Carrinho());

            tx.commit();
        }
        catch(InvalidCreditCardOperationException ex)
        {
            //nunca entra aqui pois o cartao eh sempre valido
        }
        catch (QuantidadeIngressosInvalidaException ex)
        {
            tx.rollback();
        }
        finally
        {
            session.close();
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