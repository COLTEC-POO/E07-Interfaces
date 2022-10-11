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

    //----------------------------------------- Atribultos Classe ------------------------------------------------//

    /* Numero de Operações realizadas*/
    private static Integer nOperacoes = 0;


    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;

    //---------------------------------------- Fim Atribultos Classe ---------------------------------------------//

    //------------------------------------------ Metodo Construtor -----------------------------------------------//
    public Operacao(){
    }

    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     * Exemplos de uso:
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     * @param tipo Tipo da operação, podendo ser 'd' ou 's'
     * @param valor Valor da operação
     */
    public Operacao(char tipo, double valor) {
        validarTipo(tipo);
        this.valor = valor;
        data = new Date();
        setnOperacoes();
    }

    //---------------------------------------- Fim Metodo Construtor ---------------------------------------------//


    //--------------------------------------------- Metodos Get --------------------------------------------------//
    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public Integer getnOperacoes(){
        return nOperacoes;
    }


    //-------------------------------------------- Fim Metodos Get -----------------------------------------------//


    //----------------------------------- Metodos Set || Alterações de Valores: ----------------------------------//

    public static void setnOperacoes() {
        Operacao.nOperacoes +=  1;
    }

    public void setTipo(char tipo){
        this.tipo = tipo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //-------------------------------- Fim Metodos Set || Alterações de Valores: ----------------------------------//


    //------------------------------------------ Metodos Validação ------------------------------------------------//
    public void validarTipo(char tipo){
        boolean TIPO_VALIDO;

        TIPO_VALIDO = (tipo == 's' || tipo == 'd');
        if(TIPO_VALIDO){
            setTipo(tipo);
        }else{
            setTipo(' ');
        }
    }

    //---------------------------------------- Fim Metodos Validação ----------------------------------------------//

    //------------------------------------------ Metodos Impressao ------------------------------------------------//

    public String toString(){
        String retorno = "DATA: " + this.getData() +
                " TIPO: "+ ((this.getTipo() == 's')? "SAQUE": "DEPOSITO") +
                " VALOR: " + this.getValor();

        return retorno;
    }

    @Override
    public abstract void imprimirExtratoTaxas();

    public abstract double calcularTaxa();

    //---------------------------------------- Fim Metodos Impressao ---------------------------------------------//
}