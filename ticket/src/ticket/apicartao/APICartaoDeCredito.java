/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket.apicartao;

/**
 *
 * @author Leo
 */
public class APICartaoDeCredito
{
    public class Resultado
    {
        private CodResultado resultado;
        private String       codFaturamento;
        
        public Resultado(CodResultado resultado, String codFaturamento)
        {
            this.resultado = resultado;
            this.codFaturamento = codFaturamento;
        }

        public CodResultado getResultado()
        {
            return resultado;
        }

        public String getCodFaturamento()
        {
            return codFaturamento;
        }
    }
    
    public enum CodResultado { SUCESSO, SALDO_INSUFICIENTE, DADOS_INVALIDOS }
    
    public Resultado faturar(String numCC, String senha, double valor)
    {
        return new Resultado(CodResultado.SUCESSO, "xyz123");
    }
}
