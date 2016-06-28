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

/**
 *
 * @author renan.vieira
 */
public final class Produto extends AbstractRecord
{
    private static DBSimulator<Produto> db = new DBSimulator<>();
    
    private String titulo;
    private String descricao;
    private int    evento;
    private double valorProduto;
    private int    quantidadeItens;

    public Produto(String titulo, String descricao, Evento evento, double valorProduto, int quantidadeItens)
    {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.evento = evento.getId();
        this.valorProduto = valorProduto;
        this.quantidadeItens = quantidadeItens;
    }

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public String getTitulo()
    {
        return titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public Evento getEvento()
    {
        return Evento.getById(this.evento);
    }

    public double getValorProduto()
    {
        return valorProduto;
    }

    public int getQuantidadeItens()
    {
        return quantidadeItens;
    }
    //</editor-fold>
    
    @Override
    protected DBSimulator<Produto> getDB()
    {
        return Produto.db;
    }
    
    public void take(int x)
    {
        this.quantidadeItens -= x;
    }
    
    public static Produto getById(int id)
    {
        return Produto.db.getById(id);
    }

    public static List<Produto> selectAll()
    {
        return Produto.db.selectAll();
    }

    public static List<Produto> where(Predicate<Produto> clause)
    {
        return Produto.db.where(clause);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s"
                + "Título: %s\n"
                + "Descrição: %s\n"
                + "Evento -> \n{\n%s}\n"
                + "Valor: %f\n"
                + "Quantidade Ingressos: %d\n", super.toString(), this.getTitulo(),
                this.getDescricao(), this.getEvento(), this.getValorProduto(),
                this.getQuantidadeItens());
    }
}