import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema bancário");

        Cliente cliente1 = new PessoaFisica("Gabriel", "Bairro Liberdade", 21, "1234567-890", 'M');
        Cliente cliente2 = new PessoaJuridica("Empresa Qualquer", "Bairro Liberdade", "9876543-210", 20, "Industria");
        Conta conta1 = new ContaUniversitaria(100, 500, cliente1);
        Conta conta2 = new ContaCorrente(200, 1000, 1000, cliente2);

        if(cliente1.autenticar("1234567-890")){
            System.out.println("Usuário autenticado");
        }else{
            System.out.println("Usuário não autenticado");
        }

        if(cliente2.autenticar("9876543-210")){
            System.out.println("\n\nUsuário autenticado");
        }else{
            System.out.println("Usuário não autenticado");
        }

        System.out.println("Número de contas criadas = " + Conta.contadorNumContas);


        conta1.depositar(200);
        conta1.sacar(50);
        conta1.extrato();
        conta1.imprimir();
        conta1.imprimirTaxas();

        conta2.depositar(300);
        conta2.sacar(100);
        conta2.extrato();
        conta2.imprimir();
        conta2.imprimirTaxas();
        System.out.println("\nNúmero de operações = " + Operacao.totalOperacoes);



    }
}