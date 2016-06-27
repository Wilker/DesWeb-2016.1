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
public class Evento extends AbstractRecord
{
    private static DBSimulator<Evento> db = new DBSimulator<>();
    
    private String descricao;
    private Date   data;
    private int    local;
    private int    categoria;
            
    public Evento(String descricao, Date data, Local local, Categoria categoria)
    {
        super();
        this.descricao = descricao;
        this.data = data;
        this.local = local.getId();
        this.categoria = categoria.getId();
    }
    
    // <editor-fold desc="Getters" defaultstate="collapsed">
    public String getDescricao()
    {
        return this.descricao;
    }

    public Date getData()
    {
        return this.data;
    }

    public Local getLocal()
    {
        return Local.getById(local);
    }

    public Categoria getCategoria()
    {
        return Categoria.getById(categoria);
    }
    // </editor-fold>

    @Override
    protected DBSimulator getDB()
    {
        return Evento.db;
    }
    
    public static Evento getById(int id)
    {
        return Evento.db.getById(id);
    }

    public static List<Evento> selectAll()
    {
        return Evento.db.selectAll();
    }

    public static List<Evento> where(Predicate<Evento> clause)
    {
        return Evento.db.where(clause);
    }
    
}
