import java.util.Scanner;
public abstract class Conta implements ITaxas{
    Scanner entrada = new Scanner(System.in);
    public static int contadorNumContas = 0;

    ///atributos

    private Cliente titular;
    private int numConta;

    private double minLimite;
    private double maxLimite;

    public double getMinLimite() {
        return minLimite;
    }

    public void setMinLimite(double minLimite) {
        this.minLimite = minLimite;
    }

    public double getMaxLimite() {
        return maxLimite;
    }

    public void setMaxLimite(double maxLimite) {
        this.maxLimite = maxLimite;
    }

    private double saldo;
    private double limite;
    private Operacao[] operacoes = new Operacao[1000];
    public int nOperacoes = 0;



    public Conta(int numConta, Cliente titular){
        this.numConta = numConta;
        this.saldo = 0;
        this.titular = titular;

        Conta.contadorNumContas ++;

    }

    ///ações
    /// TIPO NOMEMETODO(TIPO NOME, TIPO NOME, .....){
    /// } corpo do método

    void imprimir(){
        System.out.println("************************");
        System.out.println("\n\nNúmero da conta: " + numConta);
        System.out.println("Titular: " + this.titular.getNome());
        System.out.println("Endereço: " + this.titular.getEndereco());
        System.out.println("Saldo: " + this.saldo);
        System.out.println("************************");

    }
    public boolean sacar(double valor){
        if(valor > this.saldo || valor < 0){
            return false;
        } else {
            this.saldo -= valor;
            if(this.nOperacoes < 1000) {
                this.operacoes[this.nOperacoes] = new OperacaoSaque(valor);
                this.nOperacoes++;
            }
            return true;
        }
    }

    public boolean depositar(double valor) {
        if(valor < 0){
            return  false;
        }else{
            this.saldo += valor;
            if(this.nOperacoes < 1000) {
                this.operacoes[this.nOperacoes] = new OperacaoDeposito(valor);
                this.nOperacoes++;
            }
        }

        return  true;
    }

    public boolean transferir(Conta destino, double valor){

        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        } else {
            return  false;
        }
    }

    public void extrato() {
        int i;
        System.out.println("\t\tExtrato");
        for (i = 0; i < nOperacoes; i++) {
            System.out.println(this.operacoes[i].getData()+"\t"+this.operacoes[i].getTipo()+"\t"+this.operacoes[i].getValor());
        }
    }

    public String toString(){
        return titular.toString() + "Dados do titular\t: " + "Número da conta: " + this.getNumConta() +"\nLimite: " +this.getLimite()
                + "\nSaldo: " +this.getSaldo() +"\nOperações realizadas: " +this.nOperacoes;
    }


    public boolean equals(Object obj){
        if(obj instanceof Conta){
            Conta conta = (Conta) obj;
            if(this.numConta == conta.numConta);
            return true;
        }else{
            return false;
        }
    }
    public void imprimirTaxas(){

        System.out.println("\tTaxas da conta de número " +this.getNumConta());
        System.out.println("Taxas: " + this.calculaTaxas() + "\n");
        System.out.println("Operações");
        double totalTaxas = this.calculaTaxas();
        for (Operacao operacao : this.operacoes) {
            if (operacao == null) {
                break;
            }
            double taxaOperacao = operacao.calculaTaxas();
            if(operacao.calculaTaxas() > 0) {
                if (operacao.getTipo() == 's') {
                    System.out.println("Saque: " + operacao.calculaTaxas());
                } else {
                    System.out.println("Depósito: " + operacao.calculaTaxas());
                }
            }
            totalTaxas += taxaOperacao;
        }
        System.out.printf("\nTotal: " + totalTaxas);
    }
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public double getLimite(){
        return limite;
    }

    public abstract boolean setLimite(double valor);


    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
}