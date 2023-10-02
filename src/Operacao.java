import java.util.Date;
public abstract class Operacao implements ITaxas {
    protected double valor;
    protected Date data;
    protected char tipo;
    private static int totalOperacoes = 0;

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        Operacao.totalOperacoes++;
    }

    public double getValor() {
        return this.valor;
    }
    public Date getData() {
        return this.data;
    }
    public void setData(){
        this.data = new Date();
    }
    public static double getTotalOperacoes() {
        return Operacao.totalOperacoes;
    }
    public char getTipo(){
        return this.tipo;
    }
    public String toString(){
        return this.getData() + "  \t " + this.getTipo() + "  \t " + this.getValor();
    }

}
