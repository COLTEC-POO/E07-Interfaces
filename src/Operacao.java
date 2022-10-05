import java.util.Date;
public abstract class Operacao implements ITaxas {
    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;

    /* Contator de operacoes */

    public static int contaOperacoes;

    private Operacao[] operacoes = new Operacao[1000];

    /* Getters and Setters */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        if (tipo == 's' || tipo == 'd') {
            this.tipo = tipo;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static int getContaOperacoes() {
        return contaOperacoes;
    }

    public static void setContaOperacoes(int contaOperacoes) {
        Operacao.contaOperacoes = contaOperacoes;
    }

    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     * <p>
     * Exemplos de uso:
     * <p>
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     * @param tipo  Tipo da operação, podendo ser 'd' ou 's'
     * @param valor Valor da operação
     */
    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        contaOperacoes++;
    }

    /* Metodos */

    public void imprimirExtrato() {
        for (int i = 0; i < Operacao.contaOperacoes; i++) {
            System.out.println(this.operacoes[i].getData() + " "
                    + this.operacoes[i].getTipo() + " "
                    + this.operacoes[i].getValor());
        }
    }

    public double calculaTaxas() {
        double taxa = 0;
        return taxa;
    }
}
