/**
 * Operacao.java
 *
 * @author João Eduardo Montandon
 */

import java.util.Date;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
abstract class Operacao {

    /* Data de realização da operação */
    protected Date data;

    /* Tipo da operação */
    protected char tipo;

    /* Valor da operação */
    protected double valor;
    protected static int TOTAL_OPERACOES=0;



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
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        TOTAL_OPERACOES = TOTAL_OPERACOES+1;
    }
    public String toString() {
        return this.getData() + "\t" + this.getTipo() + "\t" + this.getValor();
    }
    public Date getData(){
        return this.data;
    }

    public char getTipo(){
        return this.tipo;
    }
    public void setTipo(char tipo){
        if (tipo=='d'){
            this.tipo='d';
        } else if (tipo=='s') {
            this.tipo='s';
        }
    }

    public double getValor(){
        return this.valor;
    }
    public void setValor(Double valor){
        this.valor = valor;
    }

    public void imprimirExtrato(Operacao operacoes){
        System.out.println(operacoes.getData()+" "+operacoes.getTipo()+" "+operacoes.getValor());
    }




}