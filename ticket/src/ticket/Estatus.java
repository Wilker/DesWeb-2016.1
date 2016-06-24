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
public class Estatus {
    
    private int estatusid;
    private String descricao;

    public int getEstatusId(){
       return estatusid;
    }
    public void setEstatusId(int v){
       estatusid = v;
    }
    
    public String getDescricao(){
       return descricao;
    }
    public void setDescricao(String v){
       descricao = v;
    }
    
}
