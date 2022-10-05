import java.util.Date;

public abstract class Cliente {
    // Atributos
    private String nome;
    private Date data;
    private String endereco;

    public Cliente() {

    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Metodos

    public void imprimirDadosCliente() {
        System.out.println("Cliente invalido! ");
    }

    public abstract boolean autentica(String chave);
}