/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

/**
 *
 * @author Leo
 */
public abstract class AbstractRecord
{
    private int id;
    
    AbstractRecord()
    {
        this.id = -1;
    }
    
    public final int getId()
    {
        return this.id;
    }
    
    final void setId(final int id)
    {
        this.id = id;
    }
    
    abstract DBSimulator getDB();
    
    public final void save()
    {
        if(this.getId() == -1)
            this.getDB().insert(this);
        else
            this.getDB().update(this);
    }
    
    public final void delete()
    {
        this.getDB().delete(this);
    }
}