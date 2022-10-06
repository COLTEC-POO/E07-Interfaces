public class PessoaJuridica extends Cliente{
    private String cnpj;
    private int numFuncionarios;
    private String setor;

    @Override
    public boolean autenticar(String str) {
        return this.cnpj == str;
    }

    @Override
    public String toString() {
        return "Cliente: " + this.getNome() + '\n'
        + "CNPJ: " + this.cnpj + '\n'
        + "Setor: " + this.setor +"\t|\tN° de Funcionarios: " + this.numFuncionarios + '\n'
        + "Localização: " + this.getEnd() + '\n'
        + "Cliente desde " + this.getDate();
    }

    public PessoaJuridica(){
        super();
        this.tipo = "PJ";
    }

    @Override
    public boolean equals(Object obj) {
        PessoaJuridica objPJ = (PessoaJuridica) obj;
        if(this.getCnpj() == objPJ.getCnpj()) return true;
        return false;
    }

    //Set

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNumFunc(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }


    public void setSetor(String setor) {
        this.setor = setor;
    }

    //Get

    public String getCnpj() {
        return cnpj;
    }
}