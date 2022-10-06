/**
 * Operacao.java
 *
 * @author João Eduardo Montandon
 */

import java.util.Date;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao implements ITaxas {

    public static int totalOperacoes;

    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;


    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     *
     * Exemplos de uso:
     *
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     *
     * @param valor Valor da operação
     */
    public Operacao(double valor) {
        this.valor = valor;
        data = new Date();
        totalOperacoes++;
    }
    //Getters
    public char getTipo() {
        return tipo;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
//Setters

    public void setTipo(char tipo) {
        //Adicionei ao extrato o tipo T de transferência
        if(tipo == 'd' || tipo == 's' || tipo == 't'){
            this.tipo = tipo;
        }
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}