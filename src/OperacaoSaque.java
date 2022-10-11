import java.util.Date;

public class OperacaoSaque extends Operacao{
    public OperacaoSaque(double valor){
        super('s', valor);
    }

    public String toString(){
        String retorno = "DATA: " + this.getData() +
                " TIPO: SAQUE" +
                " VALOR: " + this.getValor();

        return retorno;
    }

    @Override
    public void imprimirExtratoTaxas() {
        System.out.println("SAQUE: R$ " + this.calcularTaxa());
    }

    @Override
    public double calcularTaxa() {
        return 0.05;
    }
}
