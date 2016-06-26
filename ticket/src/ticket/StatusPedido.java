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
public class StatusPedido {
    
    private int statusPedidoId;
    private Date dataHora;
    private Status status;

    public int getStatusPedidoId(){
       return statusPedidoId;
    }
    public void setStatusPedidoId(int v){
       statusPedidoId = v;
    }
    
    public Date getDataHora(){
       return dataHora;
    }
    public void setDataHora(Date v){
       dataHora = v;
    }
    
    public Status getStatus(){
       return status;
    }
    public void setStatus(Status v){
       status = v;
    }
}
