/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author leo
 */
public class Pedido 
{
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "DATA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "IDUSUARIO", nullable = false)
    private Usuario usuario;
    
    
}
