public abstract class Conta implements ITaxas {
    // atributos
    private Cliente titular;
    private int numConta;
    private double saldo;
    protected double limiteMin;
    protected double limiteMax;
    private Operacao[] operacoes = new Operacao[Operacao.numMaxOperacoes];
    private int qtdOperacoes;
    private static int contadorNumContas = 0;
    // ações

    public Conta(int numConta, Cliente titular){
        this.numConta = numConta;
        this.saldo = 0;
        this.titular = titular;
        Conta.contadorNumContas++;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(PessoaFisica titular) {
        this.titular = titular;
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

    public double getLimiteMax() {
        return limiteMax;
    }

    public abstract void setLimite(double limite);

    public void imprimirSaldo(){
        System.out.println("==== Conta " +this.numConta + " ====");
        System.out.println("Nome:  "+ this.titular.getNome());
        System.out.println("Saldo: "+ this.saldo+"\n");
    }

    public boolean sacar(double valor){
        if((this.saldo - valor) < limiteMin || valor < 0){
            System.out.println("Saldo insuficiente para sacar o valor de R$" + valor);
            return false;
        } else{
            this.saldo -=valor;
            if(this.qtdOperacoes < Operacao.numMaxOperacoes){
                this.operacoes[this.qtdOperacoes] = new OperacaoSaque(valor);
                this.qtdOperacoes++;
            }
            return true;
        }
    }

    public boolean depositar(double valor){
        if(valor < 0){
            return  false;
        }
        else if((valor + this.saldo) > this.limiteMax){
            System.out.println("Valor de deposito excede o limite da conta");
            return false;
        }
        else{
            this.saldo += valor;
            if(this.qtdOperacoes < Operacao.numMaxOperacoes){
                this.operacoes[this.qtdOperacoes] = new OperacaoDeposito(valor);
                this.qtdOperacoes++;
            }
            return true;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        } else{
            return false;
        }
    }

    public void extrato(){
        System.out.println("Extrato da conta " + this.numConta);
        for (int i = 0; i < this.qtdOperacoes; i++ ){
            System.out.println(this.operacoes[i].getData()+"\t"+this.operacoes[i].getTipo()+"\t"+this.operacoes[i].getValor() );
        }
        System.out.println();
    }

    public void mediaOperacoes(){
        double media;
        media = Operacao.totalOperacoes/Conta.contadorNumContas;
        System.out.println("A média de operações realizadas é "+media + "\n");
    }

    public String toString() {
        String contaStr = "Titular......: " + this.titular.getNome() + "\nNum conta....: " + this.numConta +
                "\nSaldo........: " + this.saldo + "\nLimite.......: " + this.limiteMax + "\nQtd Operações: " + this.qtdOperacoes +
                "\nExtrato......:\n";
        for(Operacao operacao : this.operacoes){
            if (operacao == null) {
                break;
            }
            contaStr += operacao.toString();
        }

        return contaStr;
    }

    public boolean equals(Object obj){
        if(obj instanceof Conta) {
            Conta objConta = (Conta) obj;
            if (this.numConta == objConta.numConta) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    public void imprimirExtratoTaxas(){
        System.out.println("=== Extrato de Taxas ===");
        System.out.println("Manutenção da conta: " + this.calculaTaxas() + "\n");
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
        System.out.printf("\nTotal: %.2f\n", totalTaxas);
    }
}