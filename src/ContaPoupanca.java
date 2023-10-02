public abstract class ContaPoupanca extends Conta  {

    public ContaPoupanca(Cliente dono, String numeroConta, double saldoConta, double limiteConta) {
        super(String.valueOf(dono), numeroConta, saldoConta, limiteConta);
    }

    public void setLimite(double limiteConta) {
        if(limiteConta<100){
            System.out.println("Erro! Limite mínimo: R$100,00");
        }
        else if(limiteConta>1000){
            System.out.println("Erro! Limite máximo: R$1000,00");
        }
        else{
            this.limiteConta = limiteConta;
        }
    }

    public double calculaTaxas() {
        return 0;
    }

}
