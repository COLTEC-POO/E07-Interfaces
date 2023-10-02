
public class Main {

    public static void main (String[] args) {

    // Criação de contas e clientes de tipos variados

    Cliente vicenteF = new PessoaFisica("Rua Física", "Vicente do Carmo", "777.777.777-69", 25, 'M');
        
    Cliente vicenteJ = new PessoaJuridica("Rua Jurídica", "Empresa do Vicente", "88.888.888/0001-88", 3, "Entretenimento");

    Conta universitaria = new ContaUniversitaria(77777, vicenteF, 100, 499);

    Conta correnteF = new ContaCorrente(88888, vicenteF, 100, 100);

    Conta correnteJ = new ContaCorrente(88888, vicenteJ, 100, 100);

    Conta poupança = new ContaPoupanca(99999, vicenteF, 100, 999);

    // Operações para testar se a imprimeExtratoTaxas() funciona

    correnteF.depositar(2000);
    correnteF.sacar(500);
    correnteF.depositar(3000);
    correnteF.sacar(15);
    correnteF.sacar(15);
    correnteF.sacar(15);
    
    correnteF.imprimeExtratoTaxas();

    poupança.depositar(1000);
    poupança.depositar(2000);
    poupança.sacar(500);
    poupança.sacar(10);
    poupança.sacar(15);
    poupança.sacar(10000); // Teste para ver se a função imprimeExtratoTaxas não imprime valores inválidos
    
    poupança.imprimeExtratoTaxas();

    correnteJ.depositar(1000);
    correnteJ.depositar(2000);
    correnteJ.sacar(500);
    correnteJ.depositar(3000);
    correnteJ.sacar(10);
    correnteJ.sacar(15);
    
    correnteJ.imprimeExtratoTaxas();

    universitaria.depositar(1000);
    universitaria.depositar(2000);
    universitaria.sacar(500);
    universitaria.depositar(3000);
    universitaria.sacar(10);
    universitaria.sacar(15);
    universitaria.sacar(50);
    universitaria.sacar(50);
    universitaria.sacar(50);
    
    universitaria.imprimeExtratoTaxas();

  }
}