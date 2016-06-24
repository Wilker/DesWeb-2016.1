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
    
    private int pedidoid;
    private Date datahora;
    private Usuario usuario;
    private List<PedidoItem> lstiten;
    private List<EstatusPedido> lstestatus;
    
    public int getPedidoId(){
        return pedidoid;
    }
    public void setPedidoId(int v){
        pedidoid = v;
    }
    
    public Date getDataHora(){
        return datahora;
    }
    public void setDataHora(Date v){
        datahora = v;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario v){
        usuario = v;
    }
    
    public List<PedidoItem> getItens(){
        return lstiten;
    }
    
    public void AdicionaItem(PedidoItem v){
        boolean achou = false;
        
        if(lstiten == null){
           lstiten = new ArrayList<>();
        }
        
        /* incrementando a quantidade caso tente inserir o mesmo produto no pedido   */
        for(PedidoItem i : lstiten){
            if(i.getProduto().getProdutoId() == v.getPedidoItemId()){
               i.setQuantidade(i.getQuantidade() + v.getQuantidade());
               achou =  true;
            }
        }
        
        if(!achou){
           lstiten.add(v);
        }
    }
    
    public List<EstatusPedido> getEstatus(){
        return lstestatus;
    }
    
    public EstatusPedido getEstatusAtual(){
        if(lstestatus != null){
           return lstestatus.get(lstestatus.size() - 1);
        }else{
          return null;
        }
    }
    
    public void AdicionaEstatus(EstatusPedido v){
        if(lstestatus == null){
            lstestatus = new ArrayList<>();  
        }
        lstestatus.add(v);
    }
    
    
    
}
