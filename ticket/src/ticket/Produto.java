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
public class Produto {
    
    private int produtoid;
    private String titulo;
    private String descricao;
    private Evento evento;
        
    public int getProdutoId(){
       return produtoid;
    }
    public void setProdutoId(int v){
       produtoid = v;
    }
    
    public String getTitulo(){
       return titulo;
    }
    public void setTitulo(String v){
       titulo = v;
    }
    
    public String getDescricao(){
       return descricao;
    }
    public void setDescricao(String v){
       descricao = v;
    }
    
    public Evento getEvento(){
       return evento;
    }
    public void setEvento(Evento v){
       evento = v;
    }
    
    
    
    
}
