public class Main {

    public static void main(String[] args){

        System.out.println("======== Sistema Bancario ========");
        System.out.println("\n");

        Cliente clientePJ = new PessoaJuridica("Empresa XYZ", "Rua B", "24.812.098/9861-51", 3, "Gerente");


        Cliente pessoa = new PessoaFisica("João", "Rua A", "532.136.925-22", 22, 'M');


        Conta cc = new ContaCorrente(2332, "fdfsfr11", 1000, pessoa, 2000);

        //Fazendo operações de saques e depósitos
        cc.depositar(1000);
        cc.depositar(2000);
        cc.sacar(500);
        cc.depositar(3000);
        cc.sacar(10);
        cc.sacar(15);

        cc.imprimirExtratoTaxas();
    }
}
