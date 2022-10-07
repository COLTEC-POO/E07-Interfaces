public class PessoaFisica extends Cliente {

    String cpf;
    int idade;
    char sexo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public PessoaFisica() {
        this.cpf = "000.000.000-00";
        this.idade = 0;
        this.sexo = 'm';
    }

    // impressão dados pessoa física

    public String toString() {

        String pessoaFisicaStr = "Nome: " + this.nome + "\n" + "Endereco: " + this.endereco + "\n" +
                "CPF: " + this.cpf + "\n" + "Idade: " + this.idade + "\n" + "Sexo: " + this.sexo + "\n" +
                "Data criação do cliente: " + this.data;

        return pessoaFisicaStr;
    }

    public boolean equals(Object obj) {

        PessoaFisica contaPF = (PessoaFisica) obj;

        if (this.cpf.equals(contaPF.cpf)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean autenticar(String chave) {
        if(chave.equals(this.cpf)) {
            return true;
        }
        else{
            return false;
        }
    }
}