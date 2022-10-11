public class ContaUniversitaria extends Conta{
    public ContaUniversitaria(Cliente tipo, double limite){
        super(tipo);
        definirLimite(limite);
    }

    public void definirLimite(double valor){
        double limite = valor;

        if(valor > 500) limite = 500.0;
        else if (valor < 0) limite = 0.0;

        this.setLimite(limite);
    }

    @Override
    public double calcularTaxa(){
        return 0;
    }
}
