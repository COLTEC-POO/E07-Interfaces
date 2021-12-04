public class ContaCorrente extends Conta  {

        public void setLimite(int limite) {
            if (limite < -100) {
                throw new IllegalArgumentException("O limite não pode ser menor que -100!");
            }
        }
    public double calculaTaxas(){
            double taxas = 0;

        if (getMemoryCliente() instanceof PessoaFisica) {
            taxas= 10;
        }
        if (getMemoryCliente() instanceof PessoaJuridica) {
            taxas=20;
        }
        return taxas;
    }


}
