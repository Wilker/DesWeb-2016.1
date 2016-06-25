/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;

import java.util.Date;
import java.util.List;
/**
 *
 * @author renan.vieira
 */
public class Ticket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Categoria show = new Categoria("Show");
        show.save();
        
        Local vivoRio = new Local("Vivo Rio");
        vivoRio.save();
        
        Evento showMassacration = new Evento("Show Massacration", new Date(), vivoRio, show);
        showMassacration.save();
        
        Produto ingressoMassacrationPistaPremium = new Produto("P. Premium Massacration", "Ingresso pista premium Massacration", showMassacration);
        ingressoMassacrationPistaPremium.save();
        Produto ingressoMassacrationPistaComum = new Produto("P. Comum Massacration", "Ingresso pista simples Massacration", showMassacration);
        ingressoMassacrationPistaComum.save();
        
        List<Produto> todosMassacration = Produto.where(p -> p.getEvento().equals(showMassacration));
        
    }
    
}
