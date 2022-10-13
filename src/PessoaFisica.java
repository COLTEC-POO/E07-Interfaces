import java.util.Date;
import java.util.Scanner;
public class PessoaFisica  extends Cliente{

    public String CPF;
    public int Idade;
    public char Sexo;

    public String getCPF(){
        return this.CPF;
    }

    public int getidade(){
        return this.Idade;
    }
    public char getSexo(){
        return this.Sexo;
    }

    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public void setIdade(int Idade){
        this.Idade = Idade;
    }
    public void setSexo(char Sexo){
        this.Sexo = Sexo;
    }

    PessoaFisica(){
        super();

        setNome(getNome());
        setEndereco(getEndereco());
        setData (new Date());

        Scanner entrada = new Scanner(System.in);

        System.out.println("CPF: ");
        this.setCPF(entrada.nextLine());

        System.out.println("Idade: ");
        this.setIdade(entrada.nextInt());

        System.out.println("Sexo: ");
        this.setSexo(entrada.next().charAt(Sexo));

        entrada.close();

    }

    public String toString() {
        String dadosPessoaFisica = "Nome: " + this.getNome() + "\n" +
                                   "CPF: " + this.CPF + "\n" +
                                   "Endereço: " + this.getEndereco() + "\n" +
                                   "Data de Abertura: " + this.getData();
                             
            return dadosPessoaFisica;
    }

    public boolean equals(Object objeto) {
            PessoaFisica ComparaCPF = (PessoaFisica) objeto;

            if(this.CPF.equals(ComparaCPF.CPF)){
                return true;
            } else{
                return false;
            }
    }
    
    @Override
    public boolean autenticar(String chaveid) {
        if(chaveid.equals(this.CPF))
            return true;
        else
            return false;
    
    }
}

