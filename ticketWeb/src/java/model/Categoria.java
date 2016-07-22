/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author renan.vieira
 */
@Entity
@Table(name = "TICKET.CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NOME")
    private String nome;

    public Categoria(String nome) {
    }

// <editor-fold desc="Getters" defaultstate="collapsed">
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
// </editor-fold>
