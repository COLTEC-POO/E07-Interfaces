public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, double saldo, Cliente dono, double limite) {

        super(numero, saldo, limite, dono);

    }
    // Sem limite máximo e no máximo -100 reais de limite mínimo.
    public void setLimite(double limite){
        if (limite>=-100) {
            this.limite = limite;
            System.out.println("Limite da Conta Corrente permitido!");
        }else {
            this.limite=0;
            System.out.println("Limite da Conta Corrente negado!");
        }
    }
}
