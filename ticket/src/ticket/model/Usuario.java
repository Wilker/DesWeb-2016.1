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
public class Usuario extends AbstractRecord {

    private static DBSimulator<Usuario> db = new DBSimulator<>();

    private int usuarioId;
    private String nome;
    private String login;
    private String senha;
    private String email;

    // <editor-fold desc="Getters e Setters" defaultstate="collapsed">
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int v) {
        usuarioId = v;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String v) {
        nome = v;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String v) {
        login = v;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String v) {
        senha = v;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String v) {
        email = v;
    }
    // </editor-fold>

    @Override
    DBSimulator getDB() {
        return Usuario.db;
    }

    public static Usuario getById(int id) {
        return Usuario.db.getById(id);
    }

    public static List<Usuario> selectAll() {
        return Usuario.db.selectAll();
    }

    public static List<Usuario> where(Predicate<Usuario> clause) {
        return Usuario.db.where(clause);
    }
}