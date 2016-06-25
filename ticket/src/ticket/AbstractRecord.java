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
    
    public AbstractRecord()
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
    
    public abstract void save();
    public abstract void delete();
}
