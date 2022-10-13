public class OperacaoSaque extends Operacao {

    public OperacaoSaque(double valor){
        settipo('s');

        setvalor(valor);
    }

    public String toString() {
        String dadosOperacao = "Data da Operação: " + this.data + "\n" +
                            "Tipo de Operação: " + this.tipo + "\n" +
                            "Valor: " + this.valor;
                             
            return dadosOperacao;

    }

    @Override
    public double calculaTaxa() {
        return 0.05;
    }

    




    
}