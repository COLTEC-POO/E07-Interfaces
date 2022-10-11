public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente tipo, double limite){
        super(tipo);
        definirLimite(limite);
    }

    public void definirLimite(double valor){
        double limite = valor;

        if(valor > 1000) limite = 1000.0;
        else if (valor < 100) limite = 100.0;

        this.setLimite(limite);
    }

    @Override
    public double calcularTaxa() {
        return 0;
    }

}
