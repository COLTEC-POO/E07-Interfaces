public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente dono) {
        super(dono);
        this.tipo = "CC";
    }

    @Override
    public void setLimite(double limite) {
        if(limite < -100)
            System.out.println("Limite mínimo ultrapassado");
        else{
            this.limite = limite;
        }
    }

    @Override
    public double calculaTaxas() {
        if(this.getDono() instanceof PessoaFisica){
            return 10;
        }else if(this.getDono() instanceof  PessoaJuridica){
            return 20;
        }
        return 0;
    }
}
