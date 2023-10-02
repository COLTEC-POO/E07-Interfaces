public class PessoaFisica extends Cliente{
    protected String cpf;
    protected int idade;
    protected char sexo;

    public PessoaFisica (String nome, String endereco, String cpf, int idade, char sexo){
        super(nome, endereco);
        this.cpf=cpf;
        this.idade = idade;
        this.sexo = sexo;
    }
    public void imprimir() {
        System.out.println("===Pessoa Fisica===");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CNPJ: " + this.cpf);
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Idade: " + this.idade);
    }
    public String toString(){
        String pessoaFisicaStr = "Nome: " + this.getNome() + "\n" +
                "Endereco: " + this.getEndereco() + "\n" +
                "Data de criacao: " + this.getDataCriacao() + "\n" +
                "CPF: " + this.cpf + "\n" +
                "Idade: " + this.idade +
                "Sexo: " + this.sexo;
        return pessoaFisicaStr;
    }
    public boolean equals(Object outro) {
        if (outro instanceof PessoaFisica) {
            PessoaFisica outraPf = (PessoaFisica) outro;
            return this.getCpf().equals(outraPf.getCpf());
        }
        return false;
    }
    public boolean autenticar(String chave){
        if(chave==this.cpf){
            return true;
        }else {
            return false;
        }
    }
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
}
