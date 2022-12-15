public class ContaCorrente extends Conta {

    public ContaCorrente(int numConta, double saldo, double minLimite, Cliente nome) {
        super(numConta, nome);
        this.setLimite(minLimite);
    }

    public boolean setLimite(double minLimite){
        if(minLimite>= -100){
            return true;
        }else{
            return false;
        }
    }
    public double calculaTaxa(){
        double taxa = 0;
        if(this.getNome() instanceof PessoaFisica){
            taxa = 10;
        }
        else if(this.getNome() instanceof PessoaJuridica){
            taxa = 20;
        }
        return taxa;
    }


}
