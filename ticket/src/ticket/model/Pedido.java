/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.model;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import ticket.activerecord.AbstractRecord;
import ticket.activerecord.DBSimulator;

/**
 *
 * @author renan.vieira
 */
public class Pedido extends AbstractRecord
{
    private static DBSimulator<Pedido> db = new DBSimulator<>();
    
    private int  usuario;
    private Date dataHora;
    
    public Pedido(Usuario usuario, Date dataHora)
    {
        this.usuario = usuario.getId();
        this.dataHora = dataHora;
    }
    
    // <editor-fold desc="Getters" defaultstate="collapsed">
    public Usuario getUsuario()
    {
        return Usuario.getById(usuario);
    }
    
    public Date getDataHora()
    {
        return this.dataHora;
    }
    
    public List<PedidoItem> getPedidoItens()
    {
        return PedidoItem.where(pedidoItem -> pedidoItem.getPedido().equals(this));
    }
    
    public double getValorTotal()
    {
        return getPedidoItens().stream().map(PedidoItem::getValorTotal).reduce(0.0, (a, b) -> a + b);
    }
    // </editor-fold>

    @Override
    protected DBSimulator getDB()
    {
        return Pedido.db;
    }
    
    public static Pedido getById(int id) 
    {
        return Pedido.db.getById(id);
    }

    public static List<Pedido> selectAll() 
    {
        return Pedido.db.selectAll();
    }

    public static List<Pedido> where(Predicate<Pedido> clause) 
    {
        return Pedido.db.where(clause);
    }
}
