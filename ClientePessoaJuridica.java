public class ClientePessoaJuridica extends Cliente {

    private String cnpj;
    private int numFuncionarios;
    private String setor;

    double taxa=0;
    ClientePessoaJuridica(String nome, String endereco, String cnpj, int numFuncionarios, String setor){
        super(nome, endereco);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }

  public boolean autenticar(String chave){
      if(chave.equals(this.cnpj)){
        return true;
      }
      else{
        return false;
      }
    }
    public double calculaTaxas(){
        taxa += 20;
        return taxa;
    }
    public void imprimirExtratoTaxas(){
        System.out.println("Taxas"+taxa);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String toString() {
        String pessoaJStr = "Nome............: " + this.getNome() +
                "\nCNPJ............: " + this.cnpj + "\nSetor...........: " + this.setor +
                "\nEndereco........: " + this.getEndereco() + "\nNum Funcionarios: " + this.numFuncionarios + "\n";
        return pessoaJStr;
    }

    public boolean equals(Object obj){
        if(obj instanceof ClientePessoaJuridica){
            ClientePessoaJuridica objPj = (ClientePessoaJuridica) obj;
            if(this.cnpj.equals(objPj.cnpj)){
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