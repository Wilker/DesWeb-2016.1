/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;

/**
 *
 * @author renan.vieira
 */
public class Usuario {
    
    private int usuarioid;
    private String nome;
    private String login;
    private String senha;
    private String email;
    
    public int getUsuarioId(){
       return usuarioid;
    }
    
    public void setUsuarioId(int v){
       usuarioid = v;
    }
    
    public String getNome(){
       return nome;
    }
    
    public void setNome(String v){
       nome = v;
    }
    
    public String getLogin(){
       return login;
    }
    
    public void setLogin(String v){
       login = v;
    }
    
    public String getSenha(){
       return senha;
    }
    
    public void setSenha(String v){
       senha = v;
    }
    
    public String getEmail(){
       return email;
    }
    
    public void setEmail(String v){
       email = v;
    }
    
    
}
