public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
        validateLimite(limite);
    }

    private void validateLimite(double limite) {
        if (limite < -100) {
            throw new IllegalArgumentException("Valor de limite não permitido para conta corrente!\n");
        }
    }

    public void setLimite(double limite) {
        validateLimite(limite);
        this.limite = limite;
    }

    public double calculaTaxas(){

        double tax = 0.0;
        
        if (this.dono instanceof PessoaFisica){
            tax = 10.0;
        }

        if (this.dono instanceof PessoaJuridica){
            tax = 20.0;
        }
        return tax;
    }
}