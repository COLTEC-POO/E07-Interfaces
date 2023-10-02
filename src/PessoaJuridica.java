public class PessoaJuridica extends Cliente {

    private String CNPJ;
    private int numFuncionarios;
    private String setor;

    public PessoaJuridica(String endereco, String nome, String CNPJ, int numFuncionarios, String setor) {
        super(endereco, nome);
        setCNPJ(CNPJ);
        setNumFuncionarios(numFuncionarios);
        setSetor(setor);
    }

    // Getters e Setters

    public String getCNPJ (){
        return CNPJ;
    }

    public void setCNPJ (String CNPJ){
        this.CNPJ = CNPJ;
    }

    public int getNumFuncionarios(){
        return numFuncionarios;
    }

    public void setNumFuncionarios (int numFuncionarios){
        this.numFuncionarios = numFuncionarios;
    }

    public String getSetor(){
        return setor;
    }

    public void setSetor (String setor){
        this.setor = setor;
    }

    // Método que sobrescreve a função toString da class Object e transforma tudo em uma string - Atividade 05

    @Override
    public String toString(){
        String PJ = "Dados do cliente: " + "\n" + 
                    "Data de criação da conta: " + this.getData() + "\n" +
                    "Nome: " + this.getNome() + "\n" +
                    "Endereço: " + this.getEndereco() + "\n" +
                    "CNPJ: " + this.getCNPJ() + "\n" +
                    "Quantidade de funcionários: " + this.getNumFuncionarios() + "\n" +
                    "Setor de atuação : " + this.getSetor();

        return PJ;
    }

    // Método que sobrescreve a função equals da class Object e compara se dois objetos são iguais - Atividade 05

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof PessoaJuridica) {
            PessoaJuridica outraJ = (PessoaJuridica) obj;
            if (this.getCNPJ().equals(outraJ.getCNPJ())){
            return true;
            } else {
            return false;
            }
        } else {
            return false;
        }
    }

    // Método de autenticação de pessoas jurídicas

    public boolean auth(String key){
        if (this.getCNPJ().equals(key)) {
            System.out.println("Autenticação de " + this.getNome() + " realizada com sucesso!");
            return true;
        } else {
            System.out.println("Falha na autenticação!");
            return false;
        }
    }
}
