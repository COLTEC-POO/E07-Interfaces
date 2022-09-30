public class PessoaFisica extends Cliente{
    private int idade;
    private String cpf;
    private char sexo;

    PessoaFisica(String nome, String endereco, int idade, String cpf, char sexo){
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

    public String toString() {
        String pessoaFStr = "Nome...........: " + this.getNome() +
                "\nCPF............: " + this.cpf + "\nIdade..........: " + this.idade + "\nSexo...........: " + this.sexo +
                "\nEndereco.......: " + this.getEndereco()+"\n";
        return pessoaFStr;
    }

    public boolean equals(Object obj){
        if(obj instanceof PessoaFisica){
            PessoaFisica objPf = (PessoaFisica) obj;
            if(this.cpf.equals(objPf.cpf)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public  boolean autenticar(String chave){
        if(this.cpf.equals(chave)){
            return true;
        }
        else{
            return false;
        }
    }

}


