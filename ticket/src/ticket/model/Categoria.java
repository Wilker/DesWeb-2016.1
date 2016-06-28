/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket.model;

import java.util.List;
import java.util.function.Predicate;
//import org.apache.commons.lang3.builder.ToStringBuilder;
import ticket.activerecord.AbstractRecord;
import ticket.activerecord.DBSimulator;

/**
 *
 * @author renan.vieira
 */
public class Categoria extends AbstractRecord
{
    private static DBSimulator<Categoria> db = new DBSimulator<>();
    
    private String nome;
    
    public Categoria(String nome)
    {
        super();
        this.nome = nome;
    }

    // <editor-fold desc="Getters e Setters" defaultstate="collapsed">
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    // </editor-fold>
    
    @Override
    protected DBSimulator getDB()
    {
        return Categoria.db;
    }
    
    public static Categoria getById(int id)
    {
        return Categoria.db.getById(id);
    }

    public static List<Categoria> selectAll()
    {
        return Categoria.db.selectAll();
    }

    public static List<Categoria> where(Predicate<Categoria> clause)
    {
        return Categoria.db.where(clause);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s"
                + "Nome: %s\n", super.toString(), this.getNome());
        
        //return new ToStringBuilder(this).reflectionToString(this);
    }
}
