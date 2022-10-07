public class OperacaoDeposito extends Operacao implements ITaxas{

    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    public String toString(){

        return "Data: " + getData() + "\t" + "Tipo: " + getTipo() + "\t" + "Valor: " + getValor();
    }

    public double calculaTaxas() {
        return 0;
    }
}