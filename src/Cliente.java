import java.util.Date;
import java.util.Scanner;
public abstract class Cliente {
    private String Endereco;
    private String Nome;
    private Date Data;


    public String getEndereco() {  
        return this.Endereco;
    }
    public String getNome() { 
        return this.Nome;
    }
    public Date getData() {  
        return this.Data;
    }

    public void setEndereco(String Endereco){
        this.Endereco=Endereco;
    }
    public void setNome(String Nome){
        this.Nome = Nome;
    }
    public void setData(Date Data){
        this.Data = new Date();
    }
    public void imprimirDados(){


    }

    public Cliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Nome: ");
        this.setNome(entrada.nextLine());

        System.out.println("Endereço: ");
        this.setEndereco(entrada.nextLine());

        System.out.println("Data de Abertura: ");
        this.setData(new Date());

        entrada.close();

    }

    public abstract boolean autenticar( String chaveid);
    
  
    
}

