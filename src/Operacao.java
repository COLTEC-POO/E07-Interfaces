/**
 * Operacao.java
 *
 * @author João Eduardo Montandon
 */

import java.util.Date;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao implements ITaxas{

    /**
     * @param data
     * @param tipo
     * @param valor
     */
    /* Data de realização da operação */
    public Date data;

    /* Tipo da operação */
    public char tipo;

    /* Valor da operação */
    public double valor;

    //Getters
    public Date getData(){
        return this.data;
    }

    public char getTipo(){
        return this.tipo;
    }

    public double getValor(){
        return this.valor;
    }
    //FIM Getters

    //Setters
    public void setData(){
        this.data = new Date();
    }

    public void setTipo(char tipo){
        if (tipo == 'd' || tipo == 's')
            this.tipo = tipo;
    }

    public void setValor(double valor){
        this.valor = valor;
    }
    //FIM Setters

    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     *
     * Exemplos de uso:
     *
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     * @param tipo Tipo da operação, podendo ser 'd' ou 's'
     * @param valor Valor da operação
     */
    public Operacao(char tipo, double valor) {
        setTipo(tipo);
        setValor(valor);
        setData();
    }

    public void SalvaOperacao() {
        setTipo(tipo);
        setValor(valor);
        setData();
    }

    public Operacao(){
    }

    public void extrato(){
        if (this.data != null)
            System.out.println("Data: " + this.data + " Operação: " + this.tipo + " Valor: R$ " + this.valor);
    }

    public abstract Double calculaTaxas();

}