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
}
