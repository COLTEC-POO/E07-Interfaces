public class OperacaoSaque extends Operacao{

    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     * <p>
     * Exemplos de uso:
     * <p>
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     * @param valor Valor da operação
     */

    public OperacaoSaque(double valor) {
        super(valor);
        this.setTipo('s');

    }
    @Override
    public double calculaTaxas() {
        return 0.05;
    }

    @Override
    public String toString() {
        return "Valor: "+ this.getValor() + "Tipo: " + this.getTipo() + "Data: " + this.getData();
    }
}