public class ContaPoupanca extends Conta{

    public void setLimite(int limite) {
        if (limite < 100) {
            System.out.println("Limite inferior ao limite minimo dessa modalidade de conta. Limite minimo = 100 reais.");
        } else if (limite > 1000) {
            System.out.println("Limite superior ao limite maximo dessa modalidade de conta. Limite maximo = 1000 reais.");
        }else{
            this.limite = limite;
        }
    }

    public double calculaTaxas(){
        return 0;
    }
}
