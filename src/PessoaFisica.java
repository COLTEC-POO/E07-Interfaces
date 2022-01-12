public class PessoaFisica extends Client {
    private String cpf;
    private int age;
    private char sex;

    public PessoaFisica(String name, String cpf, String address, int age, char sex) {
        super(name, address);
        this.cpf = cpf;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public void print() {
        System.out.println("Name: " + this.name + "\tCpf: " + this.cpf + "\tIdade: " + this.age + "\tSexo: " + this.sex
                + "\tEndereço" + this.address);
    }

    @Override
    boolean autenticar(String chave) {
        return chave == this.cpf;
    }
}
