import java.util.Date;

public class OperacaoDeposito extends  Operacao {
    public OperacaoDeposito(double valor){
        super('d', valor);
    }

    public String toString(){
        String retorno = "DATA: " + this.getData() +
                " TIPO: DEPOSITO" +
                " VALOR: " + this.getValor();

        return retorno;
    }

    @Override
    public void imprimirExtratoTaxas() {
        System.out.println("Não Há Taxas!!");
    }

    @Override
    public double calcularTaxa() {
        return 0;
    }
}
