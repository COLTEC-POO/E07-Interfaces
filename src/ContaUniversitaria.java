public class ContaUniversitaria extends Conta implements ITaxas {
    private double limite;

    public ContaUniversitaria(Cliente dono, int numConta) {
        super(dono, numConta);
    }

    public void setLimite(double limite) {
        if(limite<0 || limite>500){
            System.out.println("Não foi possível alterar o limite!Ultrapassou os valores de limite para este tipo de conta!");
        }
        else{
            this.limite=limite;
            System.out.println("Limite alterado!");
        }
    }
    public double calculaTaxas() {
        taxas=0;
        return taxas;
    }
}