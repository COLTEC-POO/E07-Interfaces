public class ContaUniversitaria extends Conta{

    public ContaUniversitaria(int numConta, double maxLimite, Cliente nome) {
        super(numConta, nome);
        this.setLimite(maxLimite);
    }

    public boolean setLimite(double maxLimite){
        if(this.getMinLimite()>= 0 && this.getMaxLimite() <=500){
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
