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
public class Local {
    
    private int localid;
    private String descricao;
    private String logradouro;
    private String numero;
    private String bairro;
    private String refencia;
    private String complemento;
    private String cep;
    private Cidade cidade;
    
    public int getLocalId(){
       return localid;
    }
    public void setLocalId(int v){
       localid = v;
    }
    
    public String getDescricao(){
       return descricao;
    }
    public void setDescricao(String v){
       descricao = v;
    }
    
    public String getLogradouro(){
       return logradouro;
    }
    public void setLogradouro(String v){
       logradouro = v;
    }
    
    public String getNumero(){
       return numero;
    }
    public void setNumero(String v){
       numero = v;
    }
    
    public String getBairro(){
       return bairro;
    }
    public void setBairro(String v){
       bairro = v;
    }
    
    public String getRefencia(){
       return refencia;
    }
    public void setRefencia(String v){
       refencia = v;
    }
    
    public String getComplemento(){
       return complemento;
    }
    public void setComplemento(String v){
       complemento = v;
    }
    
    public String getCEP(){
       return cep;
    }
    public void setCEP(String v){
       cep = v;
    }
    
    public Cidade getUF(){
       return cidade;
    }
    public void setUF(Cidade v){
       cidade = v;
    }
    
}
