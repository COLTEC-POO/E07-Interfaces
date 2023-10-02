public class OperacaoSaque extends Operacao {

    public OperacaoSaque (double valor){
        super('s', valor); // Herda todas as características do método construtor da superclasse.
    }

    // Método que sobrescreve a função toString da class Object e transforma tudo em uma string - Atividade 05

    @Override
    public String toString(){
        String dadosSaque = this.getData() + "\t" + this.getTipo() + "\t" + this.getValor();
        
        return dadosSaque;
    }

    public double calculaTaxas(){
        double tax = 0.05;
        return tax;
    }
}
