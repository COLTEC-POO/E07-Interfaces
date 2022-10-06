public class ContaUniversitaria extends Conta implements ITaxas{


    public ContaUniversitaria(Cliente cliente, Boolean tipo, Double saldo_inicial, Double limite, Integer numConta){
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
        if (limite >= 0 && limite <= 500)
            setLimite(0.0);
    }

    public Double calculaTaxas() {
        
        Double taxa = 0.0;

        return taxa;
    }
}
