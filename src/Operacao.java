import java.util.Date;

public abstract class Operacao {

    double valor;
    Date data;
    char tipo;

    public static int totalOperacoes;

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        if ((tipo == 's') || (tipo == 'd')) {
            this.tipo = tipo;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        data = new Date();
        Operacao.totalOperacoes++;
    }
}