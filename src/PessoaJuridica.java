public class PessoaJuridica extends Cliente {
    protected String cnpj;
    protected int numFuncionarios;
    protected String setor;

    public PessoaJuridica(String nome, String endereco, String cnpj, int numFuncionarios, String setor) {
            super(nome, endereco);
            this.cnpj = cnpj;
            this.numFuncionarios = numFuncionarios;
            this.setor = setor;
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
        String imprimir =
                        "\n================ Pessoa Jurídica ================\n" +
                        "Nome: " + this.getNome() + "\n" +
                        "Endereco: " + this.getEndereco() + "\n" +
                        "CNPJ: " + this.getCnpj() +"\n" +
                        "Num de Funcionarios: " + this.getNumFuncionarios() +"\n" +
                        "Setor: " + this.getSetor() ;
        return imprimir;
    }

    public boolean equals(Object outraPJ) {
        if(outraPJ instanceof PessoaJuridica) {
            PessoaJuridica outro = (PessoaJuridica) outraPJ;
            return this.getCnpj().equals(((PessoaJuridica) outraPJ).getCnpj());
        } else {
            return false;
        }
    }

    // A autenticacao será comparar se a chave é igual ao cpf da Pessoa Jurídica por meio do método equals
    @Override
    public boolean autenticar(String chave) {
        if(chave.equals(this.cnpj)){
            return true;
        }
        else{
            return false;
        }
    }

    public double calculaTaxas() {
        return 20;
    }
}
