public class ContaUniversitaria extends Conta{
    public ContaUniversitaria(int numero, double saldo, Cliente dono, double limite) {

        super(numero, saldo, limite, dono);

    }
    public void setLimite(double limite){
        if (limite>=0 && limite<=1000) {
            this.limite = limite;
            System.out.println("Limite da Conta Corrente permitido!");
        }else {
            this.limite=0;
            System.out.println("Limite da Conta Corrente negado!");
        }
    }
}
