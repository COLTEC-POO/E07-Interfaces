import java.util.Objects;
import java.util.Scanner;

public class PessoaJuridica extends Cliente{
    String CNPJ;
    String Setor;
    Integer numFuncionarios;

    //------------------------------------------ Metodo Construtor -----------------------------------------------//

    PessoaJuridica(){
        super();

        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe seu CNPJ: ");
        this.setCNPJ(entrada.nextLine());

        System.out.println("Informe seu setor: ");
        this.setSetor(entrada.nextLine());

        receberNumFuncionariosValidada();
    }

    //---------------------------------------- Fim Metodo Construtor ---------------------------------------------//

    //--------------------------------------------- Metodos Get --------------------------------------------------//

    public String getCNPJ() {
        return CNPJ;
    }

    public String getSetor() {
        return Setor;
    }

    public Integer getNumFuncionarios() {
        return numFuncionarios;
    }

    //-------------------------------------------- Fim Metodos Get -----------------------------------------------//


    //--------------------------------------------- Metodos Set --------------------------------------------------//

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setSetor(String setor) {
        Setor = setor;
    }

    public void setNumFuncionarios(Integer numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    //-------------------------------------------- Fim Metodos Set -----------------------------------------------//


    //------------------------------------ Metodos Receber Dados Validos -----------------------------------------//

    public void receberNumFuncionariosValidada(){
        Scanner entrada = new Scanner(System.in);
        boolean ERRO;

        do {
            System.out.println("Informe o numero de funcionarios: ");
            this.setNumFuncionarios(entrada.nextInt());
            ERRO = (this.getNumFuncionarios() < 0);
            if(ERRO) System.out.println("Numero De Funcionarios Invalido");
            entrada.nextLine();
        }while (ERRO);
    }

    //---------------------------------- Fim Metodos Receber Dados Validos ---------------------------------------//

    //------------------------------------------ Redefinição Objects ---------------------------------------------//

    public String toString(){
        String text = "DADOS CLIENTE: " + "\nNOME: " + getNome() + "\nSETOR: " + getSetor() +
                "\nCNPJ: " + this.getCNPJ() + "\nENDERECO: " + this.getEndereco() +
                "\nCLIENTE DESDE: " + this.getData();
        return text;
    }

    public boolean equals(Object obj) {
        boolean NOT_ERRO, retorno = false;
        PessoaJuridica contaComparada = (PessoaJuridica) obj;

        NOT_ERRO = (contaComparada != null);

        if(NOT_ERRO){
            retorno = (Objects.equals(this.getCNPJ(), contaComparada.getCNPJ()));
        }

        return retorno;
    }

    //---------------------------------------- Fim Redefinição Objects -------------------------------------------//

    //------------------------------------------- Metodos Autenticação -------------------------------------------//

    public boolean autenticar(String chave){
        Boolean retorno = true;

        if(!Objects.equals(chave, this.getCNPJ())) retorno = false;

        return retorno;
    }

    //----------------------------------------- Fim Metodos Autenticação -----------------------------------------//

}
