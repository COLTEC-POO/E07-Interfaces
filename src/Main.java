public class Main {
    public static void main (String [] args) {

        double media;

        ContaUniversitaria minhaConta;
        minhaConta = new ContaUniversitaria ();

        ContaCorrente novaConta;
        novaConta = new ContaCorrente ();

        PessoaFisica brenda;
        brenda = new PessoaFisica ();

        PessoaJuridica novoCliente;
        novoCliente = new PessoaJuridica ();

        minhaConta.setDono(brenda);
        minhaConta.setNumeroDaConta(101);
        minhaConta.setLimite(10000);

        brenda.nome = "Brenda Sales";
        brenda.idade = 24;
        brenda.sexo = 'F';
        brenda.CPF = "000.000.000-00";
        brenda.endereco = "Rua X, bairro Y.";

        novaConta.setDono(novoCliente);
        novaConta.setNumeroDaConta(202);
        novaConta.setLimite(20000);

        novoCliente.nome = "Empresa";
        novoCliente.setor = "TI";
        novoCliente.cnpj = "111.111.111-11";
        novoCliente.numFuncionarios = 150;
        novoCliente.endereco = "Rua Y, bairro X.";

        System.out.println(minhaConta);
        System.out.println ("------------------------------------------");
        System.out.println(novaConta);
        System.out.println ("------------------------------------------");

        minhaConta.depositar(5000);
        System.out.println ("Saldo atual: R$ " + minhaConta.getSaldo());
        minhaConta.sacar(1000);
        System.out.println ("Saldo atual: R$ " + minhaConta.getSaldo());
        minhaConta.transferir(novaConta, 2000);
        System.out.println ("Saldo atual conta de origem: R$ " + minhaConta.getSaldo());
        System.out.println ("Saldo atual conta de destino: R$ " + novaConta.getSaldo());

        System.out.println ("------------------------------------------");
        minhaConta.imprimirExtrato();
        System.out.println ("------------------------------------------");

        media = (float)Operacao.totalOperacoes / (float)Conta.totalDeContas;
        System.out.println("Media do numero de operações em relação ao numero de contas: " + media);

        System.out.println ("\n");

        minhaConta.imprimirExtratoTaxas();

        System.out.println ("\n");

        novaConta.imprimirExtratoTaxas();

    }
}
