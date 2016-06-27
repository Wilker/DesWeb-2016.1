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
public class Local extends AbstractRecord
{
    private static DBSimulator<Local> db = new DBSimulator<>();
    
    private String nome;
    private String logradouro;
    private String numero;
    private String bairro;
    private String refencia;
    private String complemento;
    private String cep;
    private String cidade;
    
    public Local(String nome)
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
    protected DBSimulator getDB()
    {
        return Local.db;
    }
    
    public static Local getById(int id)
    {
        return Local.db.getById(id);
    }

    public static List<Local> selectAll()
    {
        return Local.db.selectAll();
    }

    public static List<Local> where(Predicate<Local> clause)
    {
        return Local.db.where(clause);
    }
}
