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
    private String cep;
    private String cidade;

    public Local(String nome, String logradouro, String numero, String bairro, String cep, String cidade)
    {
        super();
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
    
    // <editor-fold desc="Getters e Setters" defaultstate="collapsed">
    public String getNome()
    {
        return nome;
    }

    public String getLogradouro()
    {
        return logradouro;
    }
    
    public String getNumero()
    {
        return numero;
    }
    
    public String getBairro()
    {
        return bairro;
    }
    
    public String getCep()
    {
        return cep;
    }
    
    public String getCidade()
    {
        return cidade;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setLogradouro(String logradouro)
    {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }
    
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

    public void setCep(String cep)
    {
        this.cep = cep;
    }

    public void setCidade(String cidade)
    {
        this.cidade = cidade;
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
    
    @Override
    public String toString()
    {
        return String.format("%s" //toString da superclasse
                + "Nome: %s\n"
                + "Logradouro: %s\n"
                + "Numero: %s\n"
                + "Bairro: %s\n"
                + "CEP: %s\n"
                + "Cidade: %s\n", super.toString(), this.getNome(), this.getLogradouro(), 
                this.getNumero(), this.getBairro(), this.getCep(), this.getCidade());
    }
}
