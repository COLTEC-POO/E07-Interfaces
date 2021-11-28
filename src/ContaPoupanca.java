public class ContaPoupanca extends Conta{

    private double limite;

    public ContaPoupanca(Cliente dono, int numConta) {
        super(dono, numConta);
    }

    public void setLimite(double limite) {
        if(limite<100 || limite>1000){
            System.out.println("Não foi possível alterar o limite!Ultrapassou os valores de limite para este tipo de conta!");
        }
        else{
            this.limite=limite;
            System.out.println("Limite alterado!");
        }
    }
}
