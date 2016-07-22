/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Wilker
 */
@Entity
@Table(name = "TICKET.EVENTO")
public class Evento {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDLOCAL", nullable = false)
    private Local local;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCATEGORIA", nullable = false)
    private Categoria categoria;

    public Evento() {
    }

//<editor-fold defaultstate="collapsed" desc="Getters">
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public Local getLocal() {
        return local;
    }

    public Categoria getCategoria() {
        return categoria;
    }
//</editor-fold>
}