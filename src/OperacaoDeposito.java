public class OperacaoDeposito extends Operacao {
    
    public OperacaoDeposito(){

    }

    public OperacaoDeposito(Double valor){
        setTipo('d');
        setValor(valor);
        SalvaOperacao();
    }

    public Double calculaTaxas() {
        
        Double taxa = 0.0;

        return taxa;
    }


}
