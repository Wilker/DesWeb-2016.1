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
 * @author leo
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido 
{
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    
    @Column(name = "DATA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;
    
    @OneToMany(mappedBy = "pedido")
    private List<PedidoItem> itens;

    public Pedido()
    {
    }

    public Pedido(Date data, Usuario usuario)
    {
        this.data = data;
        this.usuario = usuario;
    }

    public int getId()
    {
        return id;
    }

    public Date getData()
    {
        return data;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public List<PedidoItem> getItens()
    {
        return itens;
    }
    
    public void adicionarItem(PedidoItem pi)
    {
        this.itens.add(pi);
    }
    
}
