/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TICKET.PRODUTO")
public class Produto 
{
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "NOME")
    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDEVENTO", nullable = false)
    private Evento evento;
    
    @Column(name = "VALOR")
    private double valor;
    
    @Column(name = "QUANTIDADE")
    private int quantidadeItens;
    
    public Produto(){
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Evento getEvento() {
        return evento;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }
    
    
}
