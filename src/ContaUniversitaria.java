public class ContaUniversitaria extends Conta {

    public ContaUniversitaria(int numConta, double limiteMax, Cliente titular) {
        super(numConta, titular);
        this.setLimite(limiteMax);
    }

    public void setLimite(double limiteMax) {
        if(limiteMax > 500){
            this.limiteMax = 500;
        }
        else if(limiteMax < 0){
            this.limiteMax = 0;
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
