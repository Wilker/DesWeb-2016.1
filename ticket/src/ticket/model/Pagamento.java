/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket.model;

import ticket.apicartao.APICartaoDeCredito;
import java.util.List;
import java.util.function.Predicate;
import ticket.activerecord.AbstractRecord;
import ticket.activerecord.DBSimulator;

/**
 *
 * @author renan.vieira
 */
public class Pagamento extends AbstractRecord
{
    private static DBSimulator<Pagamento> db = new DBSimulator<>();
    
    private int    pedido;
    private double valorCobrado;
    private String codFaturamento;
    
    public Pagamento(Pedido pedido)
    {
        this.pedido = pedido.getId();
        this.valorCobrado = pedido.getValorTotal();
        this.codFaturamento = null;
    }
    
    // <editor-fold desc="Getters" defaultstate="collapsed">
    public Pedido getPedido()
    {
        return Pedido.getById(pedido);
    }

    public double getValorCobrado()
    {
        return valorCobrado;
    }

    public String getCodFaturamento()    
    {
        return codFaturamento;
    }
    // </editor-fold>
    
    public boolean Faturar(APICartaoDeCredito ccProvider, String nome, String numeroCC, String validade, String codSegurança)
    {
        APICartaoDeCredito.Resultado resultado = ccProvider.faturar(nome, numeroCC, validade, codSegurança, this.valorCobrado);
        
        if(resultado.getResultado() == APICartaoDeCredito.CodResultado.SUCESSO)
        {
            this.codFaturamento = resultado.getCodFaturamento();
            this.save();
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isFaturado()
    {
        return this.codFaturamento != null;
    }

    @Override
    protected DBSimulator getDB()
    {
        return Pagamento.db;
    }
    
    public static Pagamento getById(int id) 
    {
        return Pagamento.db.getById(id);
    }

    public static List<Pagamento> selectAll() 
    {
        return Pagamento.db.selectAll();
    }

    public static List<Pagamento> where(Predicate<Pagamento> clause) 
    {
        return Pagamento.db.where(clause);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s"
                + "Pedido -> \n{\n%s}\n"
                + "Código de Faturamento: %s\n", super.toString(), this.getPedido(), this.getCodFaturamento());
    }
}
