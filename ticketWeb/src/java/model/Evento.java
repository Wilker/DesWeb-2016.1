/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket.model;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
    
    // <editor-fold desc="Getters e Setters" defaultstate="collapsed">
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

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public void setData(Date data)
    {
        this.data = data;
    }

    public void setLocal(Local local)
    {
        this.local = local.getId();
    }

    public void setCategoria(Categoria categoria)
    {
        this.categoria = categoria.getId();
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
    
    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("Evento id", this.getId())
                .append("Evento descrição", this.getDescricao())
                .append("Evento data", this.getData())
                .append("Evento local", this.getLocal())
                .append("Evento categoria", this.getCategoria())
                .build();
    }
}
