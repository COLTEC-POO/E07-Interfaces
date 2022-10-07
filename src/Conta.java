public abstract class Conta implements ITaxas {

    private Cliente dono;
    private int numConta;
    private double saldo;
    public double limite;
    public static Operacao[] operacoes = new Operacao[1000];
    public static int contaOperacao = 0;
    double numSaques = 0;
    public static int totalContas;

    public Conta() {
        this.numConta = 0;
        this.saldo = 0;
        this.limite = 0;

        Conta.totalContas++;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public abstract void setLimite(double limite);

    public void depositar(double valor){
        this.saldo = this.saldo + valor;
        operacoes[contaOperacao] = new OperacaoDeposito(valor);
        contaOperacao++;
    }

    public boolean sacar(double valor){

        if (valor <= this.saldo){
            this.saldo = this.saldo - valor;
            operacoes[contaOperacao] = new OperacaoSaque(valor);
            contaOperacao++;
            numSaques++;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean transferir (Conta destino, double valor){
        boolean saqueRealizado = this.sacar(valor);

        if (saqueRealizado){
            destino.depositar(valor);
            return true;

        }else {
            return false;
        }
    }

    public boolean equals(Object obj) {

        Conta contaNum = (Conta) obj;

        if (this.numConta == (contaNum.numConta)){
            return true;
        }
        else
            return false;

    }

    public String toString(){

        return "Dono: " + this.dono.nome+ "\n" + "Número da conta: " + getNumConta() + "\n" +
                "Saldo: " + getSaldo() + "\n" + "Limite: " + getLimite();

    }

    public void imprimirExtratoTaxas(){

        double taxaManutencao = this.calculaTaxas();
        double totalOperacoes = 0;

        System.out.println(" =============== Extrato de Taxas ===============");
        System.out.println("Nome: " + this.dono.nome);
        System.out.println("Manutenção da conta: R$" + taxaManutencao);
        System.out.println("\nOperações");

        for(int i = 0; i < numSaques; i++){
            OperacaoSaque op = (OperacaoSaque) operacoes[i];
            System.out.println("Saque: " + op.calculaTaxas());
            totalOperacoes+= op.calculaTaxas();
        }
        totalOperacoes = totalOperacoes + taxaManutencao;

        System.out.println("\nTotal: R$" + totalOperacoes);
    }
}