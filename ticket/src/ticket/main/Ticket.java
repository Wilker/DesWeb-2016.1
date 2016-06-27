/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket.main;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ticket.apicartao.APICartaoDeCredito;
import ticket.exceptions.QuantidadeIngressosInvalidaException;
import ticket.model.*;

/**
 *
 * @author renan.vieira
 */
public class Ticket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        Categoria show = new Categoria("Show");
        show.save();
        System.out.println(show);
        
        Local vivoRio = new Local("Vivo Rio");
        vivoRio.save();
        System.out.println(vivoRio);
        
        Evento showMassacration = new Evento("Show Massacration", new Date(), vivoRio, show);
        showMassacration.save();
        System.out.println(showMassacration);
        
        Produto ingressoMassacrationPistaPremium = new Produto("P. Premium Massacration", "Ingresso pista premium Massacration", showMassacration, 100.0, 10);
        ingressoMassacrationPistaPremium.save();
        Produto ingressoMassacrationPistaComum = new Produto("P. Comum Massacration", "Ingresso pista simples Massacration", showMassacration, 50.0, 100);
        ingressoMassacrationPistaComum.save();
        
        Usuario silva = new Usuario("Silva", "silva@silva", "123");
        silva.save();
        
        Pedido ped = new Pedido(silva, new Date());
        ped.save();
        try
        {
            PedidoItem pi = new PedidoItem(ingressoMassacrationPistaComum, ped, 3, 0);
            pi.save();
        } catch (QuantidadeIngressosInvalidaException ex)
        {
            System.err.println(ex);
        }
        
        //Criando faturamento
        System.out.println(ped);
        {
            System.out.println("\nFATURANDO...\n");
            APICartaoDeCredito apiCC = new APICartaoDeCredito();
            Pagamento pag = new Pagamento(ped);
            pag.Faturar(apiCC, "SILVA SILVA", "12345", "06/66", "666");
        }
        System.out.println(ped);
        
    }
    
}
