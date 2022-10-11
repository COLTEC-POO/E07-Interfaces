import java.util.Date;
import java.util.Scanner;

public abstract class Cliente{

    //----------------------------------------- Atribultos Classe ------------------------------------------------//
    private String nome;

    private Date data;

    private  String endereco;

    //---------------------------------------- Fim Atribultos Classe ---------------------------------------------//


    //------------------------------------------ Metodo Construtor -----------------------------------------------//
    public Cliente(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nBEM VINDO AO SISTEMA BANCARIO");
        System.out.println("\nVamos Iniciar sua conta!\n");

        System.out.println("Informe seu Nome: ");
        this.setNome(entrada.nextLine());

        System.out.println("Informe seu Endereço: ");
        this.setEndereco(entrada.nextLine());

        this.setData(new Date());
    }

    //---------------------------------------- Fim Metodo Construtor ---------------------------------------------//


    //--------------------------------------------- Metodos Get --------------------------------------------------//

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getData() {
        return data;
    }

    //-------------------------------------------- Fim Metodos Get -----------------------------------------------//


    //----------------------------------- Metodos Set || Alterações de Valores: ----------------------------------//

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setData(Date data) {
        this.data = data;
    }

    //-------------------------------- Fim Metodos Set || Alterações de Valores: ---------------------------------//

    //-------------------------------------------- Metodos Impressao ---------------------------------------------//

    public void imprimir(){
        System.out.println("Cliente Invalido");
    }

    //-------------------------------------------- Metodos Impressao ---------------------------------------------//

    //------------------------------------------- Metodos Autenticação -------------------------------------------//

    public abstract boolean autenticar(String chave);

    //----------------------------------------- Fim Metodos Autenticação -----------------------------------------//

}
