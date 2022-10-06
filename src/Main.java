public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Sistema Bancario.");

        PessoaFisica erick = new PessoaFisica();
        erick.setCpf("14479890661");
        erick.setNome("Erick Etiene");

        Conta contaErick = new ContaCorrente(erick);
        contaErick.setNumConta(333);

        contaErick.depositar(1000);
        contaErick.depositar(2000);
        contaErick.sacar(500);
        contaErick.depositar(3000);
        contaErick.sacar(10);
        contaErick.sacar(15);

        contaErick.imprimeExtratoTaxas();



//        PessoaJuridica jCliente = new PessoaJuridica();
//        Conta jConta = new Conta(jCliente);



    }
}