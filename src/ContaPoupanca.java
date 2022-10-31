public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numConta, double maxLimite, Cliente titular) {
        super(numConta, titular);
        this.setLimite(maxLimite);
    }

    public boolean setLimite(double minLimite){
        if(this.getMinLimite()>= 100 && this.getMaxLimite() <=1000){
            return true;
        }else{
            return false;
        }
    }

    public double calculaTaxas(){
        double taxa = 0;

        return taxa;
    }

}
