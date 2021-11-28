
import java.util.Date;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao {

    /* Valor da operação */
    private double valor;

    /* Data de realização da operação */
    private Date data;

    private char tipo;

    public Operacao() {
        this.valor = valor;
        this.tipo= 'n';
        data = new Date();
    }

    //metodos getters e setters:
    public Date getData(){
        return this.data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getTipo() {
        return tipo;
    }

    //`void imprimirExtrato()`
    //metodo - extrato
    public static void extrato(Conta conta){
        System.out.println("Extrato: "+ conta.getDono());
        for(int i=0;i<conta.numeroOp;i++){
            System.out.println(conta.operacoes[i].data+" "+conta.operacoes[i].tipo+" "+conta.operacoes[i].valor);
        }
    }

}
