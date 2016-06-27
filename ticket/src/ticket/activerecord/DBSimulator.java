/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.activerecord;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Leo
 */
public class DBSimulator<T extends AbstractRecord>
{
    private int     id;
    private List<T> records;
    
    public DBSimulator()
    {
        this.id = 1;
        this.records = new ArrayList<>();
    }
    
    public T getById(int id)
    {
        return this.records.stream().filter(elem -> elem.getId() == id).findFirst().get();
    }
    
    public List<T> where(Predicate<T> clause)
    {
        return this.records.stream().filter(clause).collect(Collectors.<T>toList());
    }
    
    public void insert(T toInsert)
    {
        toInsert.setId(this.id);
        this.records.add(toInsert);
        this.id = this.id + 1;
    }
    
    public void update(T toUpdate)
    {
        //Como o sistema roda em memória o sistema se mantém atualizado
        //sem a necessidade de atualizar a base de dados
    }
    
    public void delete(T toDelete)
    {
        this.records.remove(toDelete);
    }
    
    public List<T> selectAll()
    {
        return this.records;
    }
}
