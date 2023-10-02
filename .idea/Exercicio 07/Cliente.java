import java.util.Date;

public abstract class Cliente {

    Date data;
    String nome;
    String endereco;

    public Cliente(String nome, String endereco){

        this.nome = nome;
        this.endereco = endereco;
        data = new Date();
    }

    public Cliente() {

        this.endereco = "<INVALIDO>";
        this.nome = "<INVALIDO>";
    }

    // ASSINATURA DO METODO AUTENTICAR
    public abstract boolean autenticar(String chave);

}
