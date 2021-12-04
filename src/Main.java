import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);

        double media;
        byte Menu;

        PessoaFisica TaldoSidoka;
        TaldoSidoka = new PessoaFisica ();

        PessoaJuridica PastelãoChina;
        PastelãoChina = new PessoaJuridica ();

        Conta  contas0;
        contas0 = new ContaCorrente ();

        Conta contas1;
        contas1 = new ContaPoupanca ();

        contas0.setMemoryCliente(TaldoSidoka);
        contas0.setMemoryId(1);
        contas0.setLimite(500);

        TaldoSidoka.idade = 20;
        TaldoSidoka.cpf = "164-192-554-888-54";
        TaldoSidoka.endereco = "Rua: Sinuka - Numero: 915 - Bairro: Diamantina";
        TaldoSidoka.sexo = 'M';
        TaldoSidoka.nome = "Taldo Sidoka";

        contas1.setMemoryCliente(PastelãoChina);
        contas1.setMemoryId(2);
        contas1.setLimite(1000);

        PastelãoChina.cnpj = "154-326-644-658-54";
        PastelãoChina.endereco ="Rua: Paraná - Numero: 125 - Bairro: Diamantina";
        PastelãoChina.numFuncionarios = 20;
        PastelãoChina.setor = "Pastelaria";
        PastelãoChina.nome = "Pastelão do China";

        //-----------------------------------------------------------------------------------------------------//
        do {
            System.out.println();
            System.out.println("------------------");
            System.out.println("- Banco Intactoz -");
            System.out.println("------------------");
            System.out.println("1- Dados Clientes");
            System.out.println("2- Deposito");
            System.out.println("3- Saque");
            System.out.println("4- Transferência");
            System.out.println("5- Media");
            System.out.println("6- Extrato");
            System.out.println("7- Exit");
            System.out.println("------------------");
            System.out.print("Digite a opção desejada: ");
            Menu = input.nextByte();
            System.out.println();

            switch (Menu) {
                case 0:
                    break;
                case 1: {
                    System.out.println("----------Banco Intactoz---------");
                    System.out.println(contas0);
                    System.out.println("----------------------------------");
                    System.out.println(contas1);
                    System.out.println("----------------------------------");

                    break;
                }
                case 2: {
                    //Função para depositar dinheiro na conta dos clientes
                    contas0.depositar(100.00);
                    contas1.depositar(100.00);

                    //Imprimindo os novos saldos apos deposito
                    System.out.println("----------Banco Intactoz---------");
                    System.out.println("Deposito realizado com Sucesso!");
                    System.out.println("          ------------          ");
                    System.out.println("Dados Atualizados apos deposito:");
                    System.out.println("----------------------------------");
                    System.out.println("Novo Saldo "+TaldoSidoka.nome+":"+contas0.getMemorySaldo());
                    System.out.println("Novo Saldo "+PastelãoChina.nome+":"+contas1.getMemorySaldo());
                    System.out.println("----------------------------------");
                    break;
                }
                case 3: {
                    //Função para sacar dinheiro na conta dos clientes
                    contas0.sacar(50.00);
                    contas1.sacar(50.00);;

                    //Imprimindo dados apos saque
                    System.out.println("----------Banco Intactoz---------");
                    System.out.println("Saque realizado com Sucesso!");
                    System.out.println("          ------------          ");
                    System.out.println("Dados Atualizados apos saque:");
                    System.out.println("----------------------------------");
                    System.out.println("Novo Saldo "+TaldoSidoka.nome+":"+contas0.getMemorySaldo());
                    System.out.println("Novo Saldo "+PastelãoChina.nome+":"+contas1.getMemorySaldo());
                    System.out.println("----------------------------------");
                    break;
                }
                case 4: {
                    //Função para transferir dinheiro entre os clientes
                    contas0.transferir(contas1,50000.00);

                    //Imprimindo os dados apos transferir
                    System.out.println("----------Banco Intactoz---------");
                    System.out.println("Transferência realizado com Sucesso!");
                    System.out.println("          ------------          ");
                    System.out.println("Dados Atualizados apos transferência:");
                    System.out.println("----------------------------------");
                    System.out.println("Novo Saldo "+TaldoSidoka.nome+":"+contas0.getMemorySaldo());
                    System.out.println("Novo Saldo "+PastelãoChina.nome+":"+contas1.getMemorySaldo());
                    System.out.println("----------------------------------");

                    break;
                }
                case 5: {
                    media = Operacao.totalOperacoes / Conta.totalContas;
                    System.out.println("---------------------------Banco Intactoz-----------------------------");
                    System.out.println("Media do numero de operações em relação ao numero de contas: " + media);
                    System.out.println("----------------------------------------------------------------------");
                    break;
                }
                case 6:{
                    System.out.println("----------Banco Intactoz---------");
                    contas0.imprimirExtrato();
                    System.out.println("----------------------------------");
                    contas1.imprimirExtrato();

                    break;
                }
                case 7: {
                    System.out.println("Saindo do Banco Intactoz...");
                    System.exit(0);
                }
                default: {
                    System.out.println("Error: Você escolheu uma opção invalida...");
                }
            }
        } while (Menu != 7);

//-----------------------------------------------------------------------------------------------------//

    }
}