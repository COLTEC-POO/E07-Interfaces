public class ContaPoupanca extends Conta implements ITaxas{

    public ContaPoupanca(int numero, String senha, double saldo, Cliente dono, double limite) {

        super(numero, senha, saldo, dono, limite);

    }

    public void setLimite(){

        if(limite >= 100 && limite <= 1000){
            this.limite = limite;
            System.out.println("Limite da Conta Poupanca permitido!");

        } else{
            System.out.println("Erro, limite da Conta Poupanca inferior ou superior ao permitido.");
        }

    }

    public double calculaTaxas() {
        double taxa = 0.0;
        return taxa;
    }
}

