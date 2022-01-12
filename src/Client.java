import java.util.Date;

public abstract class Client {
    protected String name;
    protected String address;
    protected Date creation_date;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
        this.creation_date = new Date();
    }

    void print() {
        System.out.println("Client inválido");
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Date getCreation_date() {
        return this.creation_date;
    }

    abstract boolean autenticar(String chaveString);

}
