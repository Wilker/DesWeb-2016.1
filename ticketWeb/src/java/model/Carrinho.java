/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leo
 */
public class Carrinho 
{
    List<PedidoItem> pedidoItens;
    
    
    public Carrinho()
    {
        pedidoItens = new ArrayList<>();
    }

    public List<PedidoItem> getPedidoItens() {
        return pedidoItens;
    }
    
    public void addPedidoItem(PedidoItem pi)
    {
        pedidoItens.add(pi);
    }
}
