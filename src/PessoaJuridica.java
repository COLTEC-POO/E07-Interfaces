public class PessoaJuridica extends Cliente{

    String cnpj;
    int numFuncionarios;
    String setor;

    // construtor

    public PessoaJuridica() {
        this.cnpj = "00.000.000/0001-00";
        this.numFuncionarios = 0;
        this.setor = "Inválido";
    }

    // impressão dados pessoa jurídica

    public String toString(){

        String pessoaJuridicaStr = "Nome: " + this.nome + "\n" + "CNPJ: " + this.cnpj + "\n" +
                "Endereço: " + this.endereco + "\n" + "Numero de funcionários: " + this.numFuncionarios + "\n" +
                "Setor: " + this.setor + "\n" + "Data criação do cliente: " + this.data;

        return pessoaJuridicaStr;
    }

    public boolean equals(Object obj) {

        PessoaJuridica contaPJ = (PessoaJuridica) obj;

        if (this.cnpj.equals(contaPJ.cnpj)){
            return  true;
        }
        else {
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

    public boolean autenticar(String chave) {
        if(chave.equals(this.cnpj)){
            return true;
        }
        else{
            return false;
        }
    }
}