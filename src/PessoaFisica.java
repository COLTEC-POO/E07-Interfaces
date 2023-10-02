import java.util.Date;
public class PessoaFisica extends Cliente {
    private String cpf;
    private int idade;
    private char sexo;
    protected Date data;

    PessoaFisica(String nome, String endereco, String cpf, int idade, char sexo) {
            super(nome,endereco);
            this.cpf = cpf;
            this.idade = idade;
            this.sexo = sexo;
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
        public Date getData() {
            return data;
        }

    public String toString() {
        String imprimir =
                "================ Pessoa Física ==================\n" +
                "Nome: " + this.getNome() + "\n" +
                "Endereco: " + this.getEndereco() + "\n" +
                "CPF: " + this.getCpf() +"\n" +
                "Idade: " + this.getIdade() +"\n" +
                "Sexo: " + this.getSexo() ;
        return imprimir;
    }

    public boolean equals(Object outraPF) {
        if(outraPF instanceof PessoaFisica) {
            PessoaFisica outro = (PessoaFisica) outraPF;
            return this.getCpf().equals(((PessoaFisica) outraPF).getCpf());
        } else {
            return false;
        }
    }

    // A autenticacao será comparar se a chave é igual ao cpf da pessoa fisica por meio do método equals
    @Override
    public boolean autenticar(String chave) {
        if(chave.equals(this.cpf)){
            return true;
        }
        else{
            return false;
        }
    }

    public double calculaTaxas() {
        return 10;
    }

}