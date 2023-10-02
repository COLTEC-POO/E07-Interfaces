public class PessoaFisica extends Cliente {

    private String CPF;
    private int idade;
    private char sexo;

    public PessoaFisica (String endereco, String nome, String CPF, int idade, char sexo) {
        super(endereco, nome);
        setCPF(CPF);
        setIdade(idade);
        setSexo(sexo);
    }

    // Getters e Setters

    public String getCPF (){
        return CPF;
    }

    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public char getSexo(){
        return sexo;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    // Método que sobrescreve a função toString da class Object e transforma tudo em uma string - Atividade 05

    @Override
    public String toString(){
        String PF = "Dados do cliente: " + "\n" + 
                    "Data de criação da conta: " + this.getData() + "\n" +
                    "Nome: " + this.getNome() + "\n" +
                    "Endereço: " + this.getEndereco() + "\n" +
                    "CPF: " + this.getCPF() + "\n" +
                    "Idade: " + this.getIdade() + "\n" +
                    "Sexo: " + this.getSexo();

        return PF;
    }

    // Método que sobrescreve a função equals da class Object e compara se dois objetos são iguais - Atividade 05

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof PessoaFisica) {
            PessoaFisica outraF = (PessoaFisica) obj;
            if (this.getCPF().equals(outraF.getCPF())){
            return true;
            } else {
            return false;
            }
        } else {
            return false;
        }
    }

    // Método de autenticação de pessoas físicas

    public boolean auth(String key){
        if (this.getCPF().equals(key)) {
            System.out.println("Autenticação de " + this.getNome() + " realizada com sucesso!");
            return true;
        } else {
            System.out.println("Falha na autenticação!");
            return false;
        }
    }
}