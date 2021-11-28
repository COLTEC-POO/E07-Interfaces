public class ContaCorrente extends Conta {

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
}
