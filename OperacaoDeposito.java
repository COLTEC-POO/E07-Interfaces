public class OperacaoDeposito extends Operacao {

    double taxa=0;

    public String toSting(){
        String produtoDeposito = "Data: "+this.data+"Tipo: "+this.tipo+"Valor: "+this.valor;
        return produtoDeposito;
    }
    public void OperacaoDeposito(){
        setTipo('d');
        setValor(valor);
    }
    public double calculaTaxas(){

        return taxa;
    }
    public void imprimirExtratoTaxas(){
        System.out.println("Taxas: "+taxa);
    }

    public OperacaoDeposito(char tipo, double valor) {
        super(tipo, valor);
    }
}
