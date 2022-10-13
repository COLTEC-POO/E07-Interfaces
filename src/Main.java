public class Main {
    public static void main(String[] args){

        Conta contacoltec = new ContaCorrente(new PessoaJuridica(), 100000);
        contacoltec.depositar(100000);
        contacoltec.sacar(5000);
        System.out.println(contacoltec.toString());

        Conta minhaConta = new ContaPoupanca(new PessoaFisica(),900);
        minhaConta.depositar(1000);
        minhaConta.sacar(500);
        System.out.println(minhaConta.toString());

        Conta contaaluno = new ContaUniversitaria(new PessoaFisica(), 250);
        contaaluno.depositar(1000);
        contaaluno.sacar(500);
        System.out.println(contaaluno.toString());


        contacoltec.imprimeExtrato();
        contacoltec.ExtratoTaxas();
        minhaConta.imprimeExtrato();
        minhaConta.ExtratoTaxas();
        contaaluno.imprimeExtrato();
        contaaluno.ExtratoTaxas();

    }
}