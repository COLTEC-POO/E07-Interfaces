public class ClientePessoaFisica extends Cliente{
    private int idade;
    private String cpf;
    private char sexo;
    double taxa=0;
    ClientePessoaFisica(String nome, String endereco, int idade, String cpf, char sexo){
        super(nome, endereco);
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public boolean autenticar(String chave){
      if(chave.equals(this.cpf)){
        return true;
      }
      else{
        return false;
      }
    }
    public double calculaTaxas(){

        taxa += 10;

        return taxa;
    }
    public void imprimirExtratoTaxas(){
        System.out.println("Taxas"+taxa);
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
        if(obj instanceof ClientePessoaFisica){
            ClientePessoaFisica objPf = (ClientePessoaFisica) obj;
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

}