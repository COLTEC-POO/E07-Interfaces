import java.util.Date;

public class PessoaFisica extends Cliente {

    protected String cpf;
    protected int idade;
    protected char sexo;


    public String toString(){

        String PessoaFisicaStr =
                "===== Pessoa Fisica =====" +"\n" +
                        "Nome: " + this.nome + "\n" +
                        "Endereco: " + this.endereco + "\n" +
                        "CPF: " + this.cpf + "\n" +
                        "Idade: " + this.idade + "\n" +
                        "Sexo: " + this.sexo + "\n" +
                        "Data de criacao: " + this.data +" \n " +
                        "==========================" + "\n";

        return PessoaFisicaStr;

    }

    public PessoaFisica(String nome, String endereco, String cpf, int idade, char sexo){


        // Atributos da superclasse
        this.nome = nome;
        this.endereco = endereco;
        data = new Date();

        // Atributos da classe
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;

    }

    public PessoaFisica(String nome, String cpf, int idade, char sexo){

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    public PessoaFisica(String cpf, int idade, char sexo){

        this.cpf = "<INVALIDO>";
        this.idade = 0;
        this.sexo = 0;
    }

    public boolean equals(Object outraPF){

        if(outraPF instanceof PessoaFisica){

            PessoaFisica outraPessoaFisica = (PessoaFisica) outraPF;
            return this.getCpf().equals(outraPessoaFisica.getCpf());

        } else{
            return false;
        }
    }

    public boolean autenticar(String chave){

        if(chave.equals(cpf)){
            return true;

        } else{
            return false;
        }

    }

    public String getCpf(){
        return this.cpf;
    }

}
