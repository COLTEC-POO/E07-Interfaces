public class OperacaoSaque extends Operacao {
    public OperacaoSaque(double valor) {
        super('s', valor);
    }

    public String toString(){
        String dadosOperacao = "Data da Operacao: " + this.data + "\n" +
                "Tipo de Operacao: " + this.tipo + "/n" +
                "Valor: " + this.valor;
        return dadosOperacao;
    }

    public double calculaTaxas() {
        return 0.05;
    }
}
