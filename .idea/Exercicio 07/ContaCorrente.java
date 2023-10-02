public class ContaCorrente extends Conta implements ITaxas {

    public ContaCorrente(int numero, String senha, double saldo, Cliente dono, double limite) {

        super(numero, senha, saldo, dono, limite);

    }

    public void setLimite(){

        if(this.limite >= -100){
            this.limite = limite;
            System.out.println("Limite da Conta Corrente permitido!");

        } else {
            System.out.println("Erro, limite da Conta Corrente inferior ao permitido.");
        }

    }

    public double calculaTaxas(){

        if(this.getDono() instanceof PessoaFisica){
            double taxa = 10.0;
            return taxa;
        }
        else if(this.getDono() instanceof PessoaJuridica){
            double taxa = 20.0;
            return taxa;
        } else{
            System.out.println("Nao esta relacionada a classes Pessoa Fisica OU Juridica.");
            double taxa = 0.0;
            return taxa;

        }
    }
}
