public class OperacaoDeposito extends Operacao {
    public OperacaoDeposito(double valor) {
        super('d', valor);
    }

    public String toString(){
        String dadosOperacao = "Data da Operacao: " + this.data + "\n" +
                "Tipo de Operacao: " + this.tipo + "/n" +
                "Valor: " + this.valor;
        return dadosOperacao;
    }

    public double calculaTaxas() {
        return 0;
    }
}
