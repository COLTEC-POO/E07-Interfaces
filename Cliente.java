import java.util.Date;

public abstract class Cliente implements ITaxas{

    private String nome;
    private String endereco;
    private Date data;

    Cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        data = new Date();
    }

    public abstract boolean autenticar(String chave);
    public abstract double calculaTaxas();
    public abstract void imprimirExtratoTaxas();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toString(){
        String clienteStr = "Cliente inválido";

        return clienteStr;
    }


}