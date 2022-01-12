import java.util.Date;

public abstract class Operacao {

    public Date data;
    public char tipo;
    public double valor;
    private static int count = 0;

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();

        Operacao.count++;
    }

    public Operacao(char tipo, double valor, Date date) {
        this.tipo = tipo;
        this.valor = valor;
        data = date;

        Operacao.count++;
    }

    void imprimirExtrato() {
        System.out.println("Data: " + data + "\tTipo: " + tipo + "\tValor: " + valor);
    }

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTotalOperacoes() {
        return Operacao.count;
    }

}