public abstract class Conta implements ITaxas {
    // Atributos

    private Cliente dono;
    private int numeroConta;
    private double saldo;
    private double limite;
    private static int totalDeContas;

    private Operacao[] operacoes = new Operacao[1000];

    //Construtor
    public Conta(){
        this.numeroConta = 0;
        this.saldo = 0;
        this.limite = 0;

        Conta.totalDeContas++;
    }

    // ----------------------------------------------
    //Getters and Setters

    public Operacao[] getOperacoes() {
        return operacoes;
    }

    public Cliente getDono() {
        return this.dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public int setNumeroConta(int numero) {
        return this.numeroConta = numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getLimite() {
        return this.limite;
    }


    public int getTotalDeContas() {

        return Conta.totalDeContas;
    }

    // Metodos


    @Override
    public double calculaTaxas() {
        return 0;
    }

    public abstract double setLimite(double limite);

    public String toString() {
        String dadosStr = "Numero da conta: " + this.numeroConta + "\n" +
                "Limite: " + this.limite + "\n" +
                "Saldo: " + this.saldo;

        return dadosStr;
    }

    public void depositar(double valor) {
        if (valor < 0.0) {
            System.out.println("Nao foi possivel depositar esse valor!");
        } else {
            this.operacoes[Operacao.contaOperacoes] = new OperacaoDeposito('d', valor);
            this.saldo = this.saldo + valor;
        }
    }

    public boolean sacar(double valor) {
        if(valor <= this.saldo && (valor > 0.0)) {
            this.operacoes[Operacao.contaOperacoes] = new OperacaoSaque('s', valor);
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void extrato(){

        for(int i = 0; i < Operacao.contaOperacoes; i++) {
            System.out.println(this.operacoes[i].getData() + " "
                    + this.operacoes[i].getTipo() + " "
                    + this.operacoes[i].getValor());
        }
    }

    public boolean equals(Object obj) {

        if(obj instanceof Conta) {
            Conta objNumeroConta = (Conta) obj;

            if(this.numeroConta == objNumeroConta.numeroConta) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public void imprimirExtratoTaxas(){
        System.out.println("=== Extrato de Taxas ===");
        System.out.println("Manutencao da conta: " + this.calculaTaxas());
        System.out.println("Operacoes");

        double maxTaxas = this.calculaTaxas();
        for(Operacao operacao: this.operacoes){
            if(operacao == null) break;

            double taxaOperacao = operacao.calculaTaxas();
            if(operacao.calculaTaxas() > 0) {
                if (operacao.getTipo() == 's') {
                    System.out.println("Saque: " + operacao.calculaTaxas());
                } else {
                    System.out.println("Deposito: " + operacao.calculaTaxas());
                }
            }
            maxTaxas += taxaOperacao;
        }

        System.out.println("");
        System.out.printf("Total: %.2f", maxTaxas);
    }

}
