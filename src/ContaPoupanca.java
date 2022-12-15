public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numConta, double maxLimite, Cliente nome) {
        super(numConta, nome);
        this.setLimite(maxLimite);
    }
    public boolean setLimite(double minLimite){
        if(this.getMinLimite()>= 100 && this.getMaxLimite() <=1000){
            return true;
        }else{
            return false;
        }
    }
    public double calculaTaxa(){
        double taxa = 0;

        return taxa;
    }
}
