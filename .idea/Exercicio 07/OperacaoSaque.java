public class OperacaoSaque extends Operacao implements ITaxas{

    public OperacaoSaque(double valor) {
        super('s', valor);
    }

    public String toString(){

        String OperacaoSaqueStr =

                "===== Operacao Saque =====" +"\n" +
                        "Data: " + this.getData() + "\n" +
                        "Tipo: " + this.getTipo() + "\n" +
                        "Valor: " + this.getValor() + "\n" +
                        "==========================" + "\n";

        return OperacaoSaqueStr;
    }

    public double calculaTaxas(){
        double taxa = 0.05;
        return taxa;
    }
}

