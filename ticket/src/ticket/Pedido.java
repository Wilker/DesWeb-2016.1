/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author renan.vieira
 */
public class Pedido {
    
    private int pedidoId;
    private Date dataHora;
    private Usuario usuario;
    private List<PedidoItem> lstItem;
    private List<StatusPedido> lstStatus;
    
    public int getPedidoId(){
        return pedidoId;
    }
    public void setPedidoId(int v){
        pedidoId = v;
    }
    
    public Date getDataHora(){
        return dataHora;
    }
    public void setDataHora(Date v){
        dataHora = v;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario v){
        usuario = v;
    }
    
    public List<PedidoItem> getItens(){
        return lstItem;
    }
    
    public void AdicionaItem(PedidoItem v){
        boolean achou = false;
        
        if(lstItem == null){
           lstItem = new ArrayList<>();
        }
        
        /* incrementando a quantidade caso tente inserir o mesmo produto no pedido   */
//        for(PedidoItem i : lstItem){
//            if(i.getProduto().getProdutoId() == v.getPedidoItemId()){
//               i.setQuantidade(i.getQuantidade() + v.getQuantidade());
//               achou =  true;
//            }
//        }
        
        if(!achou){
           lstItem.add(v);
        }
    }
    
    public List<StatusPedido> getStatus(){
        return lstStatus;
    }
    
    public StatusPedido getStatusAtual(){
        if(lstStatus != null){
           return lstStatus.get(lstStatus.size() - 1);
        }else{
          return null;
        }
    }
    
    public void AdicionaStatus(StatusPedido v){
        if(lstStatus == null){
            lstStatus = new ArrayList<>();  
        }
        lstStatus.add(v);
    }
    
    
    
}
