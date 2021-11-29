public class ContaCorrente extends Conta implements ITaxas {

    private double limite;

    public ContaCorrente(Cliente dono, int numConta) {
        super(dono, numConta);

    }

    public void setLimite (double limite) {
        if(limite<-100){
            System.out.println("Ultrapassou o limite mínimo para este tipo de conta!");
        }
        else{
            this.limite=limite;
            System.out.println("Limite alterado!");
        }
    }
    //implementacao do mecanismo de tributacao - não está funcionando
    public double calculaTaxas() {
        double taxas = 0;
        if (dono instanceof PessoaFisica) {
            taxas= 10;
        }
        if (dono instanceof PessoaJuridica) {
            taxas=20;
        }
        return taxas;
    }

}
