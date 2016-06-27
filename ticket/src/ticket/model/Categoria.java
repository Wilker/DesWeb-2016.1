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
public class Categoria extends AbstractRecord
{
    private static DBSimulator<Categoria> db = new DBSimulator<>();
    
    private String nome;
    
    public Categoria(String nome)
    {
        super();
        this.nome = nome;
    }

    // <editor-fold desc="Getters" defaultstate="collapsed">
    public String getNome()
    {
        return nome;
    }
    // </editor-fold>
    
    @Override
    DBSimulator getDB()
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
}
