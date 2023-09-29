public class Main {

    public static void main(String[] args) {

        System.out.println("====Sistema Bancario====");

        // Criando um cliente para a conta
        Cliente pF = new Cliente.PessoaFisica("João", "Rua A", "12345678900", 30, 'M');

        // Inicializando uma Conta Corrente
        Conta contaC = new Conta.ContaCorrente(1, "123", 20000, "João", 1000, pF);

        contaC.sacar(300);
        contaC.sacar(200);
        contaC.depositar(3000);
        contaC.imprimirExtrato();
        System.out.println();
        contaC.imprimirExtratoTaxas();

        // Imprimindo os detalhes da Conta Corrente
//        System.out.println(contaC.toString());

    }
}