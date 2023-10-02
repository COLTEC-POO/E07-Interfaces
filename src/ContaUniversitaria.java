public abstract class ContaUniversitaria extends Conta  {
    public ContaUniversitaria(Cliente dono, String numeroConta, double saldoConta, double limiteConta) {
        super(String.valueOf(dono), numeroConta, saldoConta, limiteConta);
    }

    public void setLimite(double limiteConta) {

        if (limiteConta > 500) {
            System.out.println("Erro! Limite mínimo: R$500,00");
        } else if (limiteConta < 0) {
            System.out.println("Erro! Limite mínimo: R$ 0,00");
        } else {
            this.limiteConta = limiteConta;
        }
    }

    public double calculaTaxas() {
        return 0;
    }
}