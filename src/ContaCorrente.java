public class ContaCorrente extends Conta {
    public ContaCorrente(int numConta, double saldo, double minLimite, Cliente titular) {
        super(numConta, titular);
        this.setLimite(minLimite);
    }

    public boolean setLimite(double minLimite){
        if(minLimite>= -100){
            return true;
        }else{
            return false;
        }
    }
    public double calculaTaxas(){
        double taxa = 0;
        if(this.getTitular() instanceof PessoaFisica){
            taxa = 10;
        }
        else if(this.getTitular() instanceof PessoaJuridica){
            taxa = 20;
        }
        return taxa;
    }
}
