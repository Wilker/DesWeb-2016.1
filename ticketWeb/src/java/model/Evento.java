/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

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
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evento")
    private List<Produto> produtos;

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
    
    public List<Produto> getProdutos() {
        return produtos;
    }
//</editor-fold>
}