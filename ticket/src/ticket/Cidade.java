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
public class Cidade {
    
    private int cidadeid;
    private String nome;
    private UF uf;
    
    public int getCidadeId(){
       return cidadeid;
    }
    public void setCidadeId(int v){
       cidadeid = v;
    }
    
    public String getNome(){
       return nome;
    }
    public void setNome(String v){
       nome = v;
    }
    
    public UF getUF(){
       return uf;
    }
    public void setUF(UF v){
       uf = v;
    }
    
}
