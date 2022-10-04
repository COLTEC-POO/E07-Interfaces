public class ContaCorrente extends Conta{
  int limitemin = - 100;
  double taxa=0;
  public ContaCorrente(String nome, int numConta, String cpf, boolean tipo) {
        super(nome, numConta, cpf, tipo);
    }

    public double calculaTaxas(){

    return taxa;
    }
  public void imprimirExtratoTaxas(){
    System.out.println("Taxas"+taxa);
  }
  public boolean setLimite(double valor){
    if(valor >= this.limitemin){
      return true;
    }
    else{
      return false;
    }
  }
}