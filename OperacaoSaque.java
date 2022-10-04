public class OperacaoSaque extends Operacao {
    double taxa=0;
    public String toSting(){
            String produtoSaque = "Data: "+this.data+"Tipo: "+this.tipo+"Valor: "+this.valor;
        return produtoSaque;
    }
    public void OperacaoSaque(){
        setTipo('s');
        setValor(valor);
    }
    public double calculaTaxas(){
        double taxa=0;
        taxa += 0.05;
        return taxa;
    }
    public void imprimirExtratoTaxas(){
        System.out.println("Taxas"+taxa);
    }

    public OperacaoSaque(char tipo, double valor) {
        super(tipo, valor);
    }
}
