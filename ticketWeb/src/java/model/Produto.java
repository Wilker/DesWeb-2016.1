/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
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
    
    public boolean retirarInventario(int quantidade)
    {
        if(quantidade > 4 || this.quantidadeItens - quantidade <= 0)
        {
            return false;
        }
        else
        {
            this.quantidadeItens -= quantidade;
            return true;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
