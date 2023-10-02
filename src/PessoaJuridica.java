public class PessoaJuridica extends Cliente{
    protected String cnpj;
    protected int numFuncionarios;
    protected String setor;

    public PessoaJuridica(String nome, String endereco, String cnpj, int numFuncionarios, String setor) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }
    public void imprimir() {
        System.out.println("===Pessoa Juridica===");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CNPJ: " + this.cnpj);
        System.out.println("Endereço: " + this.getEndereco());
        System.out.println("Num Funcionarios: " + this.numFuncionarios);
        System.out.println("Setor: " + this.setor);
    }
    public String toString(){
        String pessoaJuridicaStr = "Nome: " + this.getNome() + "\n" +
                "Endereco: " + this.getEndereco() + "\n" +
                "Data de criacao: " + this.getDataCriacao() + "\n" +
                "CNPJ: " + this.cnpj + "\n" +
                "Num. Funcionarios: " + this.numFuncionarios +
                "Setor: " + this.setor;
        return pessoaJuridicaStr;
    }

    public boolean equals(Object outro) {
        if(outro instanceof PessoaJuridica) {
            PessoaJuridica outraPj = (PessoaJuridica) outro;
            return this.getCnpj().equals(outraPj.getCnpj());
        }
        return false;
    }
    public boolean autenticar(String chave){
        if(chave==this.cnpj){
            return true;
        }else {
            return false;
        }
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
}
