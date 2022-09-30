public class OperacaoDeposito extends Operacao{

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    public String toString(){
        String operacaoDStr = "Tipo.: " + this.getTipo() + "\tValor: " + this.getValor() + "\tData.: " + this.getData() + "\n";

        return operacaoDStr;
    }
    public double calculaTaxas(){
        double taxa = 0;

        return taxa;
    }
}
