/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.exceptions;

/**
 *
 * @author Leo
 */
public class QuantidadeIngressosInvalidaException extends Exception
{

    /**
     * Creates a new instance of <code>CambistaException</code> without detail
     * message.
     */
    public QuantidadeIngressosInvalidaException()
    {
    }

    /**
     * Constructs an instance of <code>CambistaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public QuantidadeIngressosInvalidaException(String msg)
    {
        super(msg);
    }
}
