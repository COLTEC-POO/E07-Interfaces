public class OperacaoDeposito extends Operacao{
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
    public OperacaoDeposito(char tipo, double valor) {
        super(tipo, valor);
    }

    public double calculaTaxas() {
        double taxa = 0;

        return taxa;
    }
}