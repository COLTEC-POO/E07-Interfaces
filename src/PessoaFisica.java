public class PessoaFisica extends Cliente{

    String cpf;
    int idade;
    char sexo;

    //-----------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------//
    public String toString(){
        return String.format("Dono da conta: %s \nCPF: %s \nIdade: %d \nSexo: %s \nEndereço: %s \n", this.nome, this.cpf, this.idade, this.sexo, this.endereco);
    }

    public boolean equals(Object obj){
        PessoaFisica that = (PessoaFisica) obj;

        return (this.cpf.equals(that.cpf));
    }
    //-----------------------------------------------------------------------------------------------------//
    public boolean autenticar(String chave){
        if(chave.equals(this.cpf)){
            return true;
        }else{
            return false;
        }

    }
    //-----------------------------------------------------------------------------------------------------//
}
