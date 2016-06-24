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
public class PedidoItem {
    
    private int pedidoitemid;
    private Produto produto;
    private int quantidade;
    private long valorvendido;
    private long desconto;
    
    public int getPedidoItemId(){
       return pedidoitemid;
    }
    public void setPedidoItemId(int v){
       pedidoitemid = v;
    }
    
    public Produto getProduto(){
       return produto;
    }
    public void setProduto(Produto v){
       produto = v;
    } 
    
    public int getQuantidade(){
       return quantidade;
    }
    public void setQuantidade(int v){
       quantidade = v;
    }
      
    public long getValorVendido(){
       return valorvendido;
    }
    public void setValorVendido(long v){
       valorvendido = v;
    }
    
    public long getDesconto(){
       return desconto;
    }
    public void setDesconto(long v){
       desconto = v;
    }
    
}
