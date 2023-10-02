public class ContaCorrente extends Conta implements ITaxas {
    double taxa = 0;

    public ContaCorrente(String dono, String numeroConta, double saldoConta, double limiteConta) {
        super(dono, numeroConta, saldoConta, limiteConta);
    }
    public void setLimite(double limiteConta) {
        if(limiteConta < -100){
            System.out.println("Erro! Limite mínimo: R$-100,00");
        }
        else{
            this.limiteConta = limiteConta;
        }
    }

    public double calculaTaxas() {

        if(this.getCliente() instanceof  PessoaFisica ){
            taxa = 10.0;
        }
        if(this.getCliente() instanceof PessoaJuridica){
            taxa = 20.0;
        }

        return taxa;
    }
}
