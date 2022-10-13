import java.util.Date;
import java.util.Scanner;
public class PessoaJuridica extends Cliente {

    public String CNPJ;
    public int numFuncionarios;
    public String setor;

    public String getCNPJ(){
        return this.CNPJ;
    }
    
    public int getnumFuncionarios(){
        return this.numFuncionarios;
    }
    public String getsetor(){
        return this.setor;
    }

    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
    public void setnumFuncionarios(int numFuncionarios){
        this.numFuncionarios = numFuncionarios;
    }
    public void setsetor(String setor){
        this.setor = setor;
    }

    PessoaJuridica(){
        super();

        setNome(getNome());
        setEndereco(getEndereco());
        setData (new Date());

        Scanner entrada = new Scanner(System.in);

        System.out.println("CNPJ: ");
        this.setCNPJ(entrada.nextLine());

        System.out.println("Numero de Funcionarios: ");
        this.setnumFuncionarios(entrada.nextInt());

        System.out.println("Setor: ");
        this.setsetor(entrada.nextLine());

        entrada.close();

    }

    public String toString() {
        String dadosPessoaJuridica = "Nome: " + this.getNome() + "\n" +
                                     "Setor: " + this.setor +"\n" +
                                     "CNPJ: " + this.CNPJ + "\n" +
                                     "Endereço: " + this.getEndereco() + "\n" +
                                     "Data de Abertura: " + this.getData();
                             
            return dadosPessoaJuridica;
    }

    public boolean equals(Object objeto) {
            PessoaJuridica ComparaCNPJ = (PessoaJuridica) objeto;

            if(this.CNPJ.equals(ComparaCNPJ.CNPJ)){
                return true;
            } else{
                return false;
            }
    }

    @Override
    public boolean autenticar(String chaveid) {
        if(chaveid.equals(this.CNPJ))
            return true;
        else
            return false;
    
    }
}

