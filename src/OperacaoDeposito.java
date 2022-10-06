public class OperacaoDeposito extends Operacao{

    @Override
    public double calculaTaxas() {
        return 0;
    }
    public OperacaoDeposito(double valor){
        super(valor);
        this.setTipo('d');
    }

    @Override
    public String toString() {
        return "Valor: "+ this.getValor() + "Tipo: " + this.getTipo() + "Data: " + this.getData();
    }


}