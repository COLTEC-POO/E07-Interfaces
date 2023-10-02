public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(int numero, Cliente dono, double saldo, double limite) {
        super(numero, dono, saldo, limite);
        validateLimite(limite);
    }

    private void validateLimite(double limite) {
        if (limite > 1000 || limite < 100) {
            throw new IllegalArgumentException("Valor de limite não permitido para conta poupança!\n");
        }
    }

    public void setLimite(double limite) {
        validateLimite(limite);
        this.limite = limite;
    }

    public double calculaTaxas(){
        double tax = 0.0;
        return tax;
    }
}
