public class ContaPoupanca extends Conta{
  int limiteMax = 1000,limiteMin = 100;
  double taxa=0;

public ContaPoupanca(String nome, int numConta, String cpf, boolean tipo) {
        super(nome, numConta, cpf, tipo);
    }
  public double calculaTaxas(){
    return taxa;
  }
  public void imprimirExtratoTaxas(){
    System.out.println("Taxas"+taxa);
  }
  public boolean setLimite(double valor){
    if(valor >= this.limiteMin && valor <= this.limiteMax){
      return true;
    }
    else{
      return false;
    }
  }
}

