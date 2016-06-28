/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.main;

import java.util.Date;
import ticket.apicartao.APICartaoDeCredito;
import ticket.exceptions.QuantidadeIngressosInvalidaException;
import ticket.model.*;

/**
 *
 * @author renan.vieira
 */
public class Ticket
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Categoria show = new Categoria("Show");
        show.save();
        System.out.println("CATEGORIA----------------------------------------------------\n");
        System.out.println(show);
        System.out.println("FIM CATEGORIA------------------------------------------------\n");

        Local vivoRio = new Local("VivoRio", "Av. Infante Dom Henrique", "85", "Flamengo", "20021-140", "Rio de Janeiro");
        vivoRio.save();
        System.out.println("LOCAL--------------------------------------------------------\n");
        System.out.println(vivoRio);
        System.out.println("FIM LOCAL----------------------------------------------------\n");

        Evento showMassacration = new Evento("Show Massacration", new Date(), vivoRio, show);
        showMassacration.save();
        System.out.println("EVENTO-------------------------------------------------------\n");
        System.out.println(showMassacration);
        System.out.println("FIM EVENTO---------------------------------------------------\n");
        
        
        Produto ingressoMassacrationPistaPremium = new Produto("P. Premium Massacration", 
                "Ingresso pista premium Massacration", showMassacration, 100.0, 10);
        ingressoMassacrationPistaPremium.save();
        
        Produto ingressoMassacrationPistaComum = new Produto("P. Comum Massacration", 
                "Ingresso pista simples Massacration", showMassacration, 50.0, 100);
        ingressoMassacrationPistaComum.save();

        Usuario silva = new Usuario("Silva", "silva@silva", "123");
        silva.save();
        System.out.println("USUÁRIO------------------------------------------------------\n");
        System.out.println(silva);
        System.out.println("FIM USUÁRIO--------------------------------------------------\n");
        
        
        Pedido ped1 = new Pedido(silva, new Date());
        ped1.save();
        
        Pedido ped2 = new Pedido(silva, new Date());
        ped2.save();
        
        Pedido ped3 = new Pedido(silva, new Date());
        ped3.save();
        
        //Adicionando ingressos ao pedido ped1
        try
        {
            System.out.println("PEDIDO 1-------------------------------------------------\n");
            PedidoItem pi = new PedidoItem(ingressoMassacrationPistaComum, ped1, 3, 0.0);
            pi.save();
         //   PedidoItem pi2 = new PedidoItem(ingressoMassacrationPistaComum, ped1, 1, 0.0);
           // pi2.save();
            //PedidoItem pi3 = new PedidoItem(ingressoMassacrationPistaComum, ped1, 1, 0.0);
            //pi3.save();
        } 
        catch (QuantidadeIngressosInvalidaException ex)
        {
            System.err.println(ex);
            System.out.println("Limite de ingressos funcionando");
        }
        finally
        {
            System.out.println(ped1.getPedidoItens());
            System.out.println(ped1);
            System.out.println("FIM PEDIDO 1---------------------------------------------\n");
        }
        
        //Adicionando ingressos ao pedido ped2
        try
        {
            System.out.println("PEDIDO 2-------------------------------------------------\n");
            PedidoItem pi4 = new PedidoItem(ingressoMassacrationPistaPremium, ped2, 2, 0.1);
            pi4.save();
            PedidoItem pi5 = new PedidoItem(ingressoMassacrationPistaPremium, ped2, 70, 0);
            pi5.save();
        } 
        catch (QuantidadeIngressosInvalidaException ex)
        {
            System.err.println(ex);
            System.out.println("Limite de ingressos funcionando");
        }
        finally
        {
            
            System.out.println(ped2);
            System.out.println("FIM PEDIDO 2---------------------------------------------\n");
        }
        
        try
        {
            System.out.println("PEDIDO 3-------------------------------------------------\n");
            PedidoItem pi6 = new PedidoItem(ingressoMassacrationPistaComum, ped3, 2, 0);
            ped3.cancelar();
        }
        catch (QuantidadeIngressosInvalidaException ex)
        {
            System.err.println(ex);
            System.err.println("Não pode acumular mais de 4 ingressos em diversos pedidos");
        }
        finally
        {
            System.out.println("FIM PEDIDO 3---------------------------------------------\n");
        }

        //Criando faturamento
        System.out.println("\nFATURANDO...\n");
        APICartaoDeCredito apiCC = new APICartaoDeCredito();
        
        System.out.println("PAGAMENTO PEDIDO 1---------------------------------------\n");
        Pagamento pag = new Pagamento(ped1);
        pag.Faturar(apiCC, "SILVA SILVA", "12345", "06/66", "666");
        System.out.println(pag);
        System.out.println("FIM PAGAMENTO PEDIDO 1-----------------------------------\n");
    }
}
