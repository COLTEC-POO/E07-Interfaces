public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente tipo, double limite){
        super(tipo);
        definirLimite(limite);
    }

   public void definirLimite(double valor){
        double limite = valor;

        if(valor < -100) limite = -100.0;

        this.setLimite(limite);
   }

    public double calcularTaxa() {
        double taxa = 0.0;

        if(this.getDadosCliente() instanceof PessoaFisica){
            taxa = 10.00;
        }else if(this.getDadosCliente() instanceof PessoaJuridica){
            taxa = 20.00;
        }

        return taxa;
    }
}
