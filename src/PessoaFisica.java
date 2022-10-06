import java.util.Date;

public class PessoaFisica extends Cliente{
    private String cpf;
    private int idade;
    private char sexo;

    public PessoaFisica(){
        this.tipo = "PF";
        this.setNome("");
        this.setEnd("");
        this.setSexo('x');
    }

    @Override
    public boolean autenticar(String str) {
        return str == this.cpf;
    }

    @Override
    public String toString(){
        String clienteStr ="Cliente: " + this.getNome() + "CPF: " + this.cpf +
                            "Idade: " + this.idade + "\t|\tSexo: " + this.sexo + "Endereço: " +
                            this.getEnd() + "Cliente desde " + this.getDate();
        return clienteStr;
    }

    @Override
    public boolean equals(Object obj) {
        PessoaFisica objPF = (PessoaFisica) obj;
        if(this.getCpf() == objPF.getCpf()) return true;
        return false;
    }

    //Get


    public String getCpf() {
        return this.cpf;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    //Set

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}