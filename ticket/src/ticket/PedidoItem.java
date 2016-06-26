/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author renan.vieira
 */
public class PedidoItem extends AbstractRecord {

    private static DBSimulator<PedidoItem> db = new DBSimulator<>();

    private int produto; //alterado para guarda a referência do produto
    private int quantidade;
    private long valorvendido;
    private long desconto;

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public int getProduto() {
        return produto;
    }

    public void setProduto(int idProduto) {
        produto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int v) {
        quantidade = v;
    }

    public long getValorVendido() {
        return valorvendido;
    }

    public void setValorVendido(long v) {
        valorvendido = v;
    }

    public long getDesconto() {
        return desconto;
    }

    public void setDesconto(long v) {
        desconto = v;
    }
// </editor-fold>

    @Override
    DBSimulator getDB() {
        return PedidoItem.db;
    }

    public static PedidoItem getById(int id) {
        return PedidoItem.db.getById(id);
    }

    public static List<PedidoItem> selectAll() {
        return PedidoItem.db.selectAll();
    }

    public static List<PedidoItem> where(Predicate<PedidoItem> clause) {
        return PedidoItem.db.where(clause);
    }
    
}
