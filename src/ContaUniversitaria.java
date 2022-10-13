public class ContaUniversitaria extends Conta{

    public ContaUniversitaria(Cliente tipo, double limite) {
        super(tipo);
        limiteConta(limite);
}
    
    public void limiteConta(double limite) {

        if(limite >= 0 || limite<=500)
        System.out.println("Seu limite era: " + this.getlimite() +
                " e agora é: " + limite);
        else
            System.out.println("Limite não alterado");

        this.setlimite(limite);

    }

    @Override
    public double calculaTaxa() {
        return 0.0;
    }
}
