public class PessoaJuridica extends Cliente{
    
    private String cnpj;
    private Integer numFuncionarios;
    private String setor;

    public PessoaJuridica(){
        
    }
    
    /**
     * @param cnpj
     * @param numFuncionarios
     * @param setor
     */
    public PessoaJuridica(String nome, String endereco, String cnpj, Integer numFuncionarios, String setor){
        try{
            validaCNPJ(cnpj);
            validaNumFuncionarios(numFuncionarios);
            validaSetor(setor);
            validaNome(nome);
            validaEndereco(endereco);
            setData();
            new PessoaJuridica();
        }catch (Exception e) {
            System.out.println("Dados invalidos!");
        }
    }


    public String getCNPJ(){
        return this.cnpj;
    }

    public String getDocumento(){
        return this.cnpj;
    }

    public Integer getNumFuncionarios(){
        return this.numFuncionarios;
    }

    public String getSetor(){
        return this.setor;
    }

    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }

    public void setNumFuncionarios(Integer numFuncionarios){
        this.numFuncionarios = numFuncionarios;
    }

    public void setSetor(String setor){
        this.setor = setor;
    }

    private void validaCNPJ(String cnpj){
        setCNPJ(cnpj);
    }

    private Boolean validaNumFuncionarios(Integer numFuncionarios){
        if (numFuncionarios >= 0){
            setNumFuncionarios(numFuncionarios);
            return true;
        }
        return false;
    }

    private void validaSetor(String setor){
        if (setor == "M" || setor == "F")
            setSetor(setor);
    }

    public void mostraCliente(){
        System.out.println("Nome " + this.getNome() + " CNPJ: " + this.cnpj);
        System.out.println("Endereço " + this.getEndereco());
        System.out.println("Qtd Funcionários: " + this.numFuncionarios + " Setor: " + this.setor);
        System.out.println("Data de Cadastro: " + this.getData());
    }

    public boolean autenticar(String chave){
        if (chave != this.cnpj)
            return false;
        return true;
    }
}
