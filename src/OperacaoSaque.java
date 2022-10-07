public class OperacaoSaque extends Operacao implements ITaxas {

    public OperacaoSaque(double valor) {
        super('s', valor);
    }

    public String toString(){

        return "Data: " + getData() + "\t" + "Tipo: " + getTipo() + "\t" + "Valor: " + getValor();
    }

    public double calculaTaxas() {
        return 0.05;
    }
}