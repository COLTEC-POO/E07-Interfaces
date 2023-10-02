import java.util.Date;

public class PessoaJuridica extends Cliente{

    String cnpj;
    int numFuncionarios;
    String setor;

    public String toString(){

        String PessoaJuridicaStr =
                "===== Pessoa Juridica =====" +"\n" +
                        "Nome: " + this.nome + "\n" +
                        "Endereco: " + this.endereco + "\n" +
                        "CNPJ: " + this.cnpj + "\n" +
                        "Numero de funcionarios: " + this.numFuncionarios + "\n" +
                        "Setor: " + this.setor + "\n" +
                        "Data de criacao: " + this.data +" \n " +
                        "==========================" + "\n";


        return PessoaJuridicaStr;

    }

    public PessoaJuridica(String nome, String endereco, String cnpj, int numFuncionarios, String setor){

        // Atributos da superclasse
        this.nome = nome;
        this.endereco = endereco;
        data = new Date();

        // Atributos da classe
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;

    }

    public PessoaJuridica(String nome, String cnpj, int numFuncionarios, String setor){

        this.nome = nome;
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;


    }

    public PessoaJuridica( String cnpj, int numFuncionarios, String setor){

        this.cnpj = "<INVALIDO>";
        this.numFuncionarios = 0;
        this.setor = "<INVALIDO>";

    }


    public boolean equals(Object outraPJ){

        if(outraPJ instanceof PessoaJuridica){

            PessoaJuridica outraPessoaJuridica = (PessoaJuridica) outraPJ;
            return this.getCnpj().equals(outraPessoaJuridica.getCnpj());

        } else{
            return false;
        }
    }

    public boolean autenticar(String chave){

        if(chave.equals(cnpj)){

            return true;

        } else{

            return false;
        }



    }

    public String getCnpj(){
        return this.cnpj;
    }
}

