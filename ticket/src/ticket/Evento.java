/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;

import java.util.Date;

/**
 *
 * @author renan.vieira
 */
public class Evento {
    
    private int eventoid;
    private String descricao;
    private Date data;
    private Local local;
    private Categoria categoria;
    
    public int getEventoId(){
        return eventoid;
    }
    public void setEventoId(int v){
        eventoid = v;
    }
    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String v){
        descricao = v;
    }
    
    public Date getData(){
        return data;
    }
    public void setData(Date v){
        data = v;
    }
    
    public Local getLocal(){
        return local;
    }
    public void setLocal(Local v){
        local = v;
    }
    
    public Categoria getCategoria(){
        return categoria;
    }
    public void setCategoria(Categoria v){
        categoria = v;
    }
    
    
}
