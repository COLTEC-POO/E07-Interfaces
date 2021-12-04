public class ContaPoupanca extends Conta{



    public void setLimite(int limite){
        if (limite < 100 || limite>1000) {
            throw new IllegalArgumentException("O limite não pode ser maior que 1000 ou menor que 100!");
        }
    }
    public double calculaTaxas(){
        return 0;
    }
}
