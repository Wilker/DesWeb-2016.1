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
public class EstatusPedido {
    
    private int estatuspedidoid;
    private Date datahora;
    private Estatus estatus;

    public int getEstatusPedidoId(){
       return estatuspedidoid;
    }
    public void setEstatusPedidoId(int v){
       estatuspedidoid = v;
    }
    
    public Date getDataHora(){
       return datahora;
    }
    public void setDataHora(Date v){
       datahora = v;
    }
    
    public Estatus getEstatus(){
       return estatus;
    }
    public void setEstatus(Estatus v){
       estatus = v;
    }
}
