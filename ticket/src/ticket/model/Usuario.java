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
public class Usuario extends AbstractRecord 
{
    private static DBSimulator<Usuario> db = new DBSimulator<>();

    private String nome;
    private String email;
    private String senha;
    
    public Usuario(String nome, String email, String senha)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // <editor-fold desc="Getters e Setters" defaultstate="collapsed">
    public String getNome() 
    {
        return nome;
    }
    
    public String getEmail() 
    {
        return email;
    }
    
    public String getSenha() 
    {
        return senha;
    }
    
    public List<Pedido> getPedidos()
    {
        return Pedido.where(pedido -> pedido.getUsuario().equals(this));
    }
    // </editor-fold>

    @Override
    protected DBSimulator getDB() 
    {
        return Usuario.db;
    }

    public static Usuario getById(int id) 
    {
        return Usuario.db.getById(id);
    }

    public static List<Usuario> selectAll() 
    {
        return Usuario.db.selectAll();
    }

    public static List<Usuario> where(Predicate<Usuario> clause) 
    {
        return Usuario.db.where(clause);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s"
                + "Nome: %s\n"
                + "Email: %s\n"
                + "Senha: %s\n", super.toString(), this.getNome(), this.getEmail(),
                this.getSenha());
    }
}