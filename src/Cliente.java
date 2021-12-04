import java.util.Date;
public abstract class Cliente {

    //Conteudo classe cliente

    String nome;
    String endereco;
    Date data;

    //-----------------------------------------------------------------------------------------------------//

    Cliente (){
        this.data =  new Date();
    }

    public String toString(){
        return "Cliente invalido.";
    }

    //-----------------------------------------------------------------------------------------------------//
    public abstract boolean autenticar(String chave);{

    }
    //-----------------------------------------------------------------------------------------------------//
}
