public class OperacaoDeposito extends Operacao{
    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    public String toString(){
        String depositoStr = "Tipo: " + this.getTipo() + "\nValor: " + this.getValor() + "\nData.: " + this.getData();

        return depositoStr;
    }
    public double calculaTaxas(){
        double taxa = 0;

        return taxa;
    }
}