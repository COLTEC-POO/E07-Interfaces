public class OperacaoSaque extends Operacao {

    public OperacaoSaque(){

    }

    public OperacaoSaque(Double valor){
        setTipo('s');
        setValor(valor);
        SalvaOperacao();
    }

    public Double calculaTaxas() {
        
        Double taxa = 0.05;

        return taxa;
    }


}