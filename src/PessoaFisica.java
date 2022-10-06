public class PessoaFisica extends Cliente{
    
    private String cpf;
    private Integer idade;
    private String sexo;

    public PessoaFisica(){
        
    }
    
    /**
     * @param cpf
     * @param idade
     * @param sexo
     */

    public PessoaFisica(String nome, String endereco, String cpf, Integer idade, String sexo){
        try{
            validaCPF(cpf);
            validaIdade(idade);
            validaSexo(sexo);
            validaNome(nome);
            validaEndereco(endereco);
            setData();
            new PessoaFisica();
        }catch (Exception e) {
            System.out.println("Dados invalidos!");
        }
    }

    public String getCPF(){
        return this.cpf;
    }

    public String getDocumento(){
        return this.cpf;
    }

    public Integer getIdade(){
        return this.idade;
    }

    public String getSexo(){
        return this.sexo;
    }

    public void setCPF(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    private void validaCPF(String cpf){
        setCPF(cpf);
    }

    private Boolean validaIdade(Integer idade){
        if (idade >= 0 && idade < 100){
            setIdade(idade);
            return true;
        }
        return false;
    }

    private void validaSexo(String sexo){
        if (sexo == "M" || sexo == "F")
            setSexo(sexo);
    }

    public void mostraCliente(){
        System.out.println("Nome " + this.getNome() + " CPF: " + this.cpf);
        System.out.println("Endereço " + this.getEndereco());
        System.out.println("Idade: " + this.idade + " Sexo: " + this.sexo);
        System.out.println("Data de Cadastro: " + this.getData());
    }

    public boolean autenticar(String chave){
        if (chave != this.cpf)
            return false;
        return true;
    }
}
