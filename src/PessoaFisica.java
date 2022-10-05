import java.util.Date;
public class PessoaFisica extends Cliente{

    //atributos
    private String cpf;
    private int idade;
    private char sexo;

    //Constructor
    public PessoaFisica(String nome, String endereco, String cpf, int idade, char sexo) {

        setNome(nome);
        setEndereco(endereco);
        this.cpf = cpf;
        this.sexo = sexo;
        this.idade = idade;
        setData(new Date());

    }

    //Getters and Setters
    public String getcpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setidade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //metodos

    public String toString() {

        String pessoaFisicaStr = ("\nNome: " + this.getNome() +
                "\nEndereco: " + this.getEndereco() +
                "\nCPF: " + this.getcpf() +
                "\nIdade: " + this.getIdade() +
                "\nSexo: " + this.getSexo() +
                "\nData: " + this.getData());

        return pessoaFisicaStr;
    }

    public boolean equals(Object obj) {
        if(obj instanceof PessoaFisica) {
            PessoaFisica objPessoaFisica = (PessoaFisica) obj;

            if(this.cpf.equals(objPessoaFisica.cpf)){
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }

    @Override
    public boolean autentica(String chave) {
        if(chave.equals(this.cpf))
            return true;
        else
            return false;
    }
}
