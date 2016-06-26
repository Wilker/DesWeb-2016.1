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
public class Status {
    
    private int statusId;
    private String descricao;

    public int getStatusId(){
       return statusId;
    }
    public void setStatusId(int v){
       statusId = v;
    }
    
    public String getDescricao(){
       return descricao;
    }
    public void setDescricao(String v){
       descricao = v;
    }
    
}
