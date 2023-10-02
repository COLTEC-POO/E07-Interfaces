public class OperacaoDeposito extends Operacao{
    
    public OperacaoDeposito (double valor){
        super('d', valor); // Herda todas as características do método construtor da superclasse.
    }

    // Método que sobrescreve a função toString da class Object e transforma tudo em uma string - Atividade 05

    @Override
    public String toString(){
        String dadosDeposito = this.getData() + "\t" + this.getTipo() + "\t" + this.getValor();
        
        return dadosDeposito;
    }

    public double calculaTaxas(){
        double tax = 0.0;
        return tax;
    }
}
