public class Main {
    public static void main(String[] args){

        Cliente clienteF = new PessoaFisica("Gabriella Aguiar", "Rua Alta, bairro Baixo", 19, "123.456.789-00", 'F');
        Cliente clienteJ = new PessoaJuridica("Empresa T.I", "Rua da Bahia, Centro", "12.345.678/0001-00", 50, "T.I");
        Conta contaA = new ContaCorrente(1234, 3500, 100, clienteF);
        Conta contaB = new ContaPoupanca(9876, 1000000, clienteJ);


        if(clienteF.autenticar("123.456.789-00")){
            System.out.println("Usuário autenticado");
        }else{
            System.out.println("Usuário não autenticado");
        }

        if(clienteJ.autenticar("12.345.678/0001-00")){
            System.out.println("\n\nUsuário autenticado");
        }else{
            System.out.println("Usuário não autenticado");
        }

        System.out.println("Número de contas criadas = " + Conta.iNumContas + "\n");


        contaA.depositar(2000);
        contaB.depositar(5000);
        contaA.sacar(500);
        contaB.sacar(1000);
        contaA.extrato();
        System.out.println("");
        contaB.imprimirExtratoTaxas();
        System.out.println("");
        contaB.extrato();
        System.out.println("");
        contaB.imprimirExtratoTaxas();
        System.out.println("");
        System.out.println("Número de operações = " + Operacao.totalOperacoes);
    }
}