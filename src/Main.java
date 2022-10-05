public class Main {
    public static void main(String[] args) {

        Cliente pessoa = new PessoaFisica("Josef", "Rua das Gracas",
                                          "123.456.789-12", 21, 'm');
        Conta cc = new ContaCorrente();
        cc.setDono(pessoa);

        cc.depositar(1000);
        cc.depositar(2000);
        cc.sacar(500);
        cc.depositar(3000);
        cc.sacar(10);
        cc.sacar(15);

        cc.imprimirExtratoTaxas();

    }
}