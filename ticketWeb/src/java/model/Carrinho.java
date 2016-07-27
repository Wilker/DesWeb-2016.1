/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exception.QuantidadeIngressosInvalidaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.hibernate.Session;

/**
 *
 * @author leo
 */
public class Carrinho
{

    private List<PedidoItem> pedidoItens;

    public Carrinho()
    {
        pedidoItens = new ArrayList<>();
    }

    public List<PedidoItem> getPedidoItens()
    {
        return pedidoItens;
    }

    public boolean addPedidoItem(PedidoItem pi)
    {
        Optional<Integer> quantidadeCarrinho = pedidoItens.stream().map(p -> p.getQuantidade()).reduce(Integer::sum);

        if (quantidadeCarrinho.isPresent() && quantidadeCarrinho.get() + pi.getQuantidade() > 4)
        {
            return false;
        } else if (pedidoItens.stream().anyMatch(ped -> ped.getProduto().equals(pi.getProduto())))
        {
            PedidoItem piAux = pedidoItens.stream()
                    .filter(prod -> prod.getProduto().equals(pi.getProduto()))
                    .collect(Collectors.toList()).get(0);

            piAux.adicionarQuantidade(pi.getQuantidade());
            return true;

        } else
        {
            pedidoItens.add(pi);
            return true;
        }
    }

    public void setPedido(Pedido pedido)
    {
        for (PedidoItem pi : this.pedidoItens)
        {
            pi.setPedido(pedido);
        }
    }

    private void obterItensInventario(Session session, PedidoItem pi) throws QuantidadeIngressosInvalidaException
    {
        Produto pAux = pi.getProduto();
        pAux.retirarInventario(pi.getQuantidade());
        session.update(pAux);
    }

    public void savePedidoItens(Session session) throws QuantidadeIngressosInvalidaException
    {
        for (PedidoItem pi : this.pedidoItens)
        {
            session.save(pi);
            obterItensInventario(session, pi);
        }
    }

    public double valorTotalCarrinho()
    {
        return pedidoItens.stream()
                .map(pi -> pi.getValorVendido() * pi.getQuantidade())
                .reduce(0.0, Double::sum);
    }
}
