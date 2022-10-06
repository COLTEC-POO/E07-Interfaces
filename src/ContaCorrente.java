public class ContaCorrente extends Conta implements ITaxas{
    
    public ContaCorrente(Cliente cliente, Boolean tipo, Double saldo_inicial, Double limite, Integer numConta){
        try{
            validaCliente(cliente);
            validaTipo(tipo);
            validaSaldo(saldo_inicial);
            validaLimite(limite);
            validaNumConta(numConta);
            validaQtdOperacoes(0);
            qtdContas++;
        }catch (Exception e) {
            System.out.println("Dados invalidos!");
        }
    }


    public void validaLimite(Double limite){
        if (limite >= -100)
            setLimite(0.0);
    }

    public Double calculaTaxas() {
        Double taxa = 0.0;

        if(this.cliente() instanceof PessoaFisica){
            taxa = 10.0;
        }

        if(this.cliente() instanceof PessoaJuridica){
            taxa = 20.0;
        }

        return taxa;
    }

    

}
