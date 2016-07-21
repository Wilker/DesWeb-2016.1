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
 * @author leo
 */
@Entity
@Table(name = "TICKET.USUARIO")
public class Usuario
{
    
    @Id @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "SENHA")
    private String senha;
    
    public Usuario(String nome, String email, String senha)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}