public class PessoaFisica extends Cliente{

    private int idade;
    private String cpf;
    private char sexo;
    public PessoaFisica(String nome, String endereco, int idade, String cpf, char sexo){
        super(nome, endereco);
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String toString(){
        String pessoaStr = "Dados do titular:\t" + this.getNome() + "CPF:\n" + this.getCpf() + "Sexo:\n" + this.getSexo() +
                "Idade:\n" + this.getIdade() + "Endereço:\n" + this.getEndereco();
        return pessoaStr;
    }

    public boolean equals(Object obj){
        if(obj instanceof PessoaFisica){
            PessoaFisica objPessoaFisica = (PessoaFisica) obj;
            if(this.cpf.equals(objPessoaFisica.cpf)){
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean autenticar(String chave){
        if(chave.equals(this.cpf)){
            return true;
        } else {
            return false;
        }
    }
}