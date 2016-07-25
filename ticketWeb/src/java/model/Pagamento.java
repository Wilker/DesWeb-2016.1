/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento
{

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "VALORCOBRADO")
    private double valorCobrado;

    @Column(name = "CODFATURAMENTO")
    private String codFaturamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPEDIDO", nullable = false)
    private Pedido pedido;

    public Pagamento()
    {
    }

    public Pagamento(double valorCobrado, Pedido pedido)
    {
        this.valorCobrado = valorCobrado;
        this.pedido = pedido;
    }

    public int getId()
    {
        return id;
    }

    public double getValorCobrado()
    {
        return valorCobrado;
    }

    public String getCodFaturamento()
    {
        return codFaturamento;
    }

    public void setCodFaturamento(String codFaturamento)
    {
        this.codFaturamento = codFaturamento;
    }

    public Pedido getPedido()
    {
        return pedido;
    }
    
    
}
