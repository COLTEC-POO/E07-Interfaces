import java.util.Date;


/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao {

    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;

    /* Valor total das operações */
    private static int totalOperacoes = 0;

    //public void imprimirExtrato(int ProxOperacao, Operacao[] operacoes){

    //for(int i = 0; i < ProxOperacao; i++){

    //Operacao operacao = operacoes[i];
    //System.out.println(operacao.getData() + "\t" + operacao.getTipo() + "\t" + operacao.getValor());
    //}
    //}

    public void imprimirExtrato() {
        System.out.println(data + "\t" + tipo + "\t" + valor);
    }

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();

        // Conta quantas novas operações já foram feitas
        totalOperacoes++;
    }

    // Getters e Setters

    // DATA
    public Date getData(){
        return this.data;
    }


    // TIPO
    public char getTipo(){
        return this.tipo;
    }

    public void setTipo(char tipo){

        if(tipo == 'd' || tipo == 's'){
            this.tipo = tipo;
        }
        else{
            System.out.println("Erro ao fazer a operacao, digite um valor valido.");
        }
    }

    // VALOR
    public double getValor(){
        return this.valor;
    }

    public double setValor(){
        return this.valor;
    }

    // TOTAL DE OPERAÇÕES

    public static int getTotalOperacoes() {
        return totalOperacoes;
    }

}

