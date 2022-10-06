import java.util.Date;

public abstract class Cliente {
    private String nome;
    private String end;

    private Date data;

    protected String tipo;

    public Cliente() {
        this.nome = "";
        this.end = "";
        this.data = new Date();
    }

    //Get
    public Date getDate() {
        return data;
    }
    public String getNome() {
        return nome;
    }

    public String getEnd() {
        return end;
    }

    public String getTipo() {
        return tipo;
    }

    //Set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnd(String end) {
        this.end = end;
    }


    //Autenticar (string)
    public abstract boolean autenticar(String str);



    //IMPRIMIR
    public String toString(){
        return "Cliente Inválido.";
    }


}