public class ContaPoupanca extends Conta{
    public ContaPoupanca(int numero, double saldo, Cliente dono, double limite) {

        super(numero, saldo, limite, dono);

    }
    public void setLimite(double limite){
        if (limite>=100 && limite<=1000) {
            this.limite = limite;
            System.out.println("Limite da Conta Corrente permitido!");
        }else {
            this.limite=0;
            System.out.println("Limite da Conta Corrente negado!");
        }
    }
}
