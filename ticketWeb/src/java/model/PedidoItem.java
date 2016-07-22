/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author leo
 */
public class PedidoItem 
{
//    @Id
//    @GeneratedValue
//    @Column(name = "ID")
    private int id;
    
    private Produto produto;
    
    private int quantidade;
    
    private double valorVendido;
    
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

    public double getValorVendido() {
        return valorVendido;
    }
    
    
}
