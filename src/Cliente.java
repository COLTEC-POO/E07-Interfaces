import java.util.Date;
public abstract class Cliente {
    private String endereco;
    private String nome;
    private Date dataCriacao;

    public Cliente(String nome, String endereco) {
            this.endereco = endereco;
            this.nome = nome;
            this.dataCriacao = new Date();
        }

    public String getEndereco() {
        return endereco;
    }
    public String getNome() {
        return nome;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void imprimir(){
            System.out.println("Cliente Invalido");
        }

        public abstract boolean autenticar (String chave);

    }
