/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PEDIDOITEM")
public class PedidoItem 
{
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPRODUTO", nullable = false)
    private Produto produto;
    
    @Column(name = "QUANTIDADE")
    private int quantidade;
    
    @Column(name = "VALORVENDIDO")
    private double valorVendido;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;
    
    private PedidoItem(){
    }
    
    public PedidoItem(Produto produto, int quantidade, double valorVendido)
    {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorVendido = valorVendido;
    }

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public void adicionarQuantidade(int quantidade)
    {
        this.quantidade += quantidade;
    }

    public double getValorVendido() {
        return valorVendido;
    }

    public Pedido getPedido()
    {
        return pedido;
    }

    public void setPedido(Pedido pedido)
    {
        this.pedido = pedido;
    }
}
