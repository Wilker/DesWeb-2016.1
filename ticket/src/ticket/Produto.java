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
public final class Produto extends AbstractRecord
{
    private static DBSimulator<Produto> db = new DBSimulator<>();
    
    private String titulo;
    private String descricao;
    private int    evento;

    public Produto(String titulo, String descricao, Evento evento)
    {
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        //this.evento = evento.getId();
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public int getEvento()
    {
        return Evento.getById(this.evento);
    }

    @Override
    public void save()
    {
        if(this.getId() == -1)
            Produto.db.insert(this);
        else
            Produto.db.update(this);
    }

    @Override
    public void delete()
    {
        Produto.db.delete(this);
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
}