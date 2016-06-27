/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.model;

import java.util.List;
import java.util.function.Predicate;
import ticket.activerecord.AbstractRecord;
import ticket.activerecord.DBSimulator;

import ticket.exceptions.QuantidadeIngressosInvalidaException;

/**
 *
 * @author renan.vieira
 */
public class PedidoItem extends AbstractRecord
{

    private static DBSimulator<PedidoItem> db = new DBSimulator<>();

    private int produto; //alterado para guardar a referência do produto
    private int pedido;
    private int quantidade;
    private double valorVendido;
    private double desconto;

    public PedidoItem(Produto produto, Pedido pedido, int quantidade, double desconto) throws QuantidadeIngressosInvalidaException
    {
        super();
        this.produto = produto.getId();
        this.pedido = pedido.getId();
        
        if(quantidade > 4 || quantidade > produto.getQuantidadeItens())
        {
            throw new QuantidadeIngressosInvalidaException();
        }
        else
        {
            this.quantidade = quantidade;
        }
        
        this.valorVendido = produto.getValorProduto();
        this.desconto = desconto;
    }

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public Produto getProduto()
    {
        return Produto.getById(produto);
    }
    
    public Pedido getPedido()
    {
        return Pedido.getById(pedido);
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public double getValorVendido()
    {
        return valorVendido;
    }

    public double getDesconto()
    {
        return desconto;
    }

    public double getValorTotal()
    {
        return this.getValorVendido() - (this.getValorVendido() * this.getDesconto());
    }
    // </editor-fold>

    @Override
    protected DBSimulator getDB()
    {
        return PedidoItem.db;
    }

    public static PedidoItem getById(int id)
    {
        return PedidoItem.db.getById(id);
    }

    public static List<PedidoItem> selectAll()
    {
        return PedidoItem.db.selectAll();
    }

    public static List<PedidoItem> where(Predicate<PedidoItem> clause)
    {
        return PedidoItem.db.where(clause);
    }
}
