/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exception.InvalidCreditCardOperationException;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author leo
 */
public class APICartao
{
    public static String faturar(double valor, String numeroCC, String codSeguranca) throws InvalidCreditCardOperationException
    {
        return new RandomStringUtils().randomAlphanumeric(32);
    }
}
