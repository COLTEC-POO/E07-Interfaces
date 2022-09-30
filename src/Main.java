import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema Bancário\n");

        Cliente cliente1 = new PessoaFisica("Eduardo", "Belo Horizonte",20, "12345679-01", 'M');
        Cliente cliente2 = new PessoaJuridica("Coltec", "Av Antônio Carlos", "123465789-00", 30, "Educação");
        Conta contaTeste = new ContaCorrente(1202, -100, cliente1);
        Conta contaTeste2 = new ContaCorrente(1204, -100, cliente2);

        contaTeste2.depositar(1000);
        contaTeste2.sacar(100);
        contaTeste2.sacar(87);
        contaTeste2.sacar(213);

        contaTeste2.imprimirExtratoTaxas();
    }
}