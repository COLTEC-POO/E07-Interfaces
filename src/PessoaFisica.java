import java.util.Objects;
import java.util.Scanner;

public class PessoaFisica extends Cliente{

    String CPF;

    Integer idade;

    char sexo;



    //------------------------------------------ Metodo Construtor -----------------------------------------------//

    PessoaFisica(){
        super();

        Scanner entrada = new Scanner(System.in);

        receberIdadeValidada();

        System.out.println("Informe seu CPF: ");
        this.setCPF(entrada.nextLine());

        receberSexoValidado();
    }

    //---------------------------------------- Fim Metodo Construtor ---------------------------------------------//


    //--------------------------------------------- Metodos Get --------------------------------------------------//

    public Integer getIdade() {
        return idade;
    }

    public String getCPF() {
        return CPF;
    }

    public char getSexo() {
        return sexo;
    }

    //-------------------------------------------- Fim Metodos Get -----------------------------------------------//


    //--------------------------------------------- Metodos Set --------------------------------------------------//
    private void setIdade(Integer idade) {
        this.idade = idade;
    }

    private void setCPF(String CPF) {
        this.CPF = CPF;
    }

    private void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //-------------------------------------------- Fim Metodos Set -----------------------------------------------//

    //------------------------------------ Metodos Receber Dados Validos -----------------------------------------//

    public void receberIdadeValidada(){
        Scanner entrada = new Scanner(System.in);
        boolean ERRO;

        do {
            System.out.println("Informe sua Idade: ");
            this.setIdade(entrada.nextInt());
            ERRO = (this.getIdade() < 0 || this.getIdade() > 130);
            if(ERRO) System.out.println("IDADE INVALIDA");
            entrada.nextLine();
        }while (ERRO);
    }

    public void receberSexoValidado(){
        Scanner entrada = new Scanner(System.in);
        boolean ERRO;

        do{
            System.out.println("Informe o sexo [M/F]: ");
            this.setSexo(entrada.next().charAt(0));
            ERRO = this.getSexo() != 'F' && this.getSexo() != 'M' && this.getSexo() != 'm' && this.getSexo() != 'f';
            if(ERRO) System.out.println("INFORME UM VALOR VALIDO [F/M]!");
            entrada.nextLine();
        }while(ERRO);
    }

    //---------------------------------- Fim Metodos Receber Dados Validos ---------------------------------------//


    //------------------------------------------ Redefinição Objects ---------------------------------------------//

    public String toString(){
        String text = "DADOS CLIENTE: " + "\nNOME: " + getNome() + "\nCPF: " + this.getCPF() +
                "\nENDERECO: " + this.getEndereco() + "\nCLIENTE DESDE: " + this.getData();
        return text;
    }

    public boolean equals(Object obj) {
        boolean NOT_ERRO, retorno = false;
        PessoaFisica contaComparada = (PessoaFisica) obj;

        NOT_ERRO = (contaComparada != null);

        if(NOT_ERRO){
            retorno = (Objects.equals(this.getCPF(), contaComparada.getCPF()));
        }

        return retorno;
    }

    //---------------------------------------- Fim Redefinição Objects -------------------------------------------//

    //------------------------------------------- Metodos Autenticação -------------------------------------------//

    public boolean autenticar(String chave){
        Boolean retorno = true;

        if(!Objects.equals(chave, this.getCPF())) retorno = false;

        return retorno;
    }

    //----------------------------------------- Fim Metodos Autenticação -----------------------------------------//
}
