public class PessoaJuridica extends Cliente {

    private String cnpj;
    private int nFuncionarios;
    private String setor;

    public PessoaJuridica(String nome, String endereco, String cnpj, int nFuncionarios, String setor) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.nFuncionarios = nFuncionarios;
        this.setor = setor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getnFuncionarios() {
        return nFuncionarios;
    }

    public void setnFuncionarios(int nFuncionarios) {
        this.nFuncionarios = nFuncionarios;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        String pessoaJStr = "Dados da pessoa jurídica:\t" + "Nome\n" + this.getNome() + "Endereco\n" + this.getEndereco() +
                "CNPJ" +this.getCnpj() + "Número de funcionários\n" + this.getnFuncionarios() + "Setor\n" + this.getSetor();
        return pessoaJStr;
    }

    public boolean equals(Object obj){
        if(obj instanceof PessoaJuridica){
            PessoaJuridica objPessoaJuridica = (PessoaJuridica) obj;
            if(this.cnpj.equals(objPessoaJuridica.cnpj)){
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public boolean autenticar(String chaveID){
        if(chaveID.equals(this.cnpj)){
            return true;
        } else {
            return false;
        }
    }

}