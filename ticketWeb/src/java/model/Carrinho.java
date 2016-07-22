/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author leo
 */
public class Carrinho {

    List<PedidoItem> pedidoItens;

    public Carrinho() 
    {
        pedidoItens = new ArrayList<>();
    }

    public List<PedidoItem> getPedidoItens() 
    {
        return pedidoItens;
    }

    public void addPedidoItem(PedidoItem pi) 
    {
        if (pedidoItens.stream().anyMatch(ped -> ped.getProduto().equals(pi.getProduto()))) 
        {
            pedidoItens.stream()
                    .filter(prod -> prod.getProduto().equals(pi.getProduto()))
                    .collect(Collectors.toList()).get(0).adicionarQuantidade(pi.getQuantidade());
        }
        else
        {
            pedidoItens.add(pi);
        }
    }
}
