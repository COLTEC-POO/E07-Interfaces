import java.util.Random;

public abstract class Conta implements ITaxas {
    private Cliente dono;
    private int numConta;
    protected double saldo;
    protected double limite;

    protected String tipo;

    public static int totalContas;

    public Operacao[] operacoes = new Operacao[1000];



    //Metodos
    public Conta(Cliente dono) {
        this.dono = dono;
        totalContas++;
    }

    @Override
    public boolean equals(Object obj) {

        Conta objConta = (Conta) obj;

        if(this.numConta == objConta.numConta) return true;
        return false;

    }

    public void setNumConta(int val){
        this.numConta = val;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Cliente getDono() {
        return this.dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }
    public double getLimite() {
        return limite;
    }

    public abstract void setLimite(double limite);

    public boolean sacar(double valor) {
        if (!(valor > this.saldo) && !(valor < 0.0)) {
            this.operacoes[Operacao.totalOperacoes] = new OperacaoSaque(valor);

            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(double valor) {
        if (valor < 0.0) {
            System.out.println("Impossível depositar esse valor");
            return false;
        } else {
            this.operacoes[Operacao.totalOperacoes] = new OperacaoDeposito(valor);
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
            return true;
        }
    }


    /*
    public boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor) && destino.depositar(valor)) {
            this.operacoes[Operacao.totalOperacoes] = new Operacao(valor);

            System.out.println("Transferência realizada com sucesso!\n");
            return true;
        } else {
            System.out.println("Transferência mal sucedida.");
            return false;
        }
    }
    */

    public void imprimeExtrato(){
        System.out.println("===Extrato conta " + getNumConta() + "===" + "\nDono: " + getDono().getNome());
        for(int i = 0; i < Operacao.totalOperacoes; i++){
            if(this.operacoes[i] != null){
                System.out.println(this.operacoes[i].getData() + " " + this.operacoes[i].getTipo() + "      " + this.operacoes[i].getValor() );
            }
        }
    }

    public void imprimeExtratoTaxas(){

        Operacao atual;
        double total = this.calculaTaxas();

        System.out.println("Extrato de Taxas\t" + this.getNumConta() + "\t" + this.getDono().getNome());
        System.out.println("Imposto sobre tipo de conta: " + this.calculaTaxas());
        System.out.println("\nOperações: ");

        for(int i = 0; i < Operacao.totalOperacoes; i++){
            atual = operacoes[i];
            if(atual.calculaTaxas() == 0) continue;

            System.out.println(atual.getTipo() + ": " + atual.calculaTaxas());
            total += atual.calculaTaxas();
        }

        System.out.println("Total: " + total);
    }



    public String toString() {
        return "=== Conta: " + this.numConta + " ==="
        + "Dono: " + this.dono.getNome()
        + "Limite: " + this.limite +
        this.saldo;
    }

    private void imprimeSaldo() {
        System.out.println("Saldo: " + this.saldo);
    }




}
