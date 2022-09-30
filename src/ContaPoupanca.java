public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numConta, double limiteMax, Cliente titular) {
        super(numConta, titular);
        this.setLimite(limiteMax);
    }

    public void setLimite(double limiteMax) {
        if(limiteMax > 1000){
            this.limiteMax = 1000;
        }
        else if(limiteMax < 100){
            this.limiteMax = 100;
        }
        else {
            this.limiteMax = limiteMax;
        }
        this.limiteMin = 0;
    }

    public double calculaTaxas(){
        double taxa = 0;

        return taxa;
    }
}
