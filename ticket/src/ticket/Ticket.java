/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;

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
        Produto p1 = new Produto("Bruce Springsteen", "Ingressos Bruce Springsteen", null);
        p1.save();
        Produto p2 = new Produto("Bob Marley", "Ingressos Bob Marley", null);
        p2.save();
        Produto p3 = new Produto("Phil Collins", "Ingressos Phil Collins", null);
        p3.save();
        
        List<Produto> p = Produto.selectAll();
        Produto pp = Produto.getById(2);
        List<Produto> ppp = Produto.where( var -> var.getTitulo().equalsIgnoreCase("Phil Collins") || var.getId() == 3 );
        p2.delete();
    }
    
}
