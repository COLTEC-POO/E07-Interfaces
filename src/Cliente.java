import java.util.Date;

public abstract class Cliente {

    //atributos
    private static Integer qtdClientes = 0;

    private String nome;    
    private String endereco;
    private Date data;

    /**
     * @param nome
     * @param endereco
     * @param data
     */
    /*public Cliente(String nome, String cpf, String endereco, Integer idade, String sexo){
        try{
            validaNome(nome);
            validaEndereco(endereco);
            setData();
            qtdClientes++;
        }catch (Exception e) {
            System.out.println("Dados invalidos!");
        }
    }*/

    public Cliente(Boolean valida){
        qtdClientes++;
    }

    public Cliente(){

    }

    //Getters
    public String getNome(){
        return this.nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public Date getData(){
        return this.data;
    }
    //FIM Getters

    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public void setData(){
        this.data = new Date();
    }
    //FIM Setters

    //Validadores de dados
    public void validaNome(String nome){
        setNome(nome);
    }

    public void validaEndereco(String endereco){
        setEndereco(endereco);
    }
    //FIM Validadores



    //Funções

    public abstract void mostraCliente();

    public abstract boolean autenticar(String chave);

    //FIM Funções
}


