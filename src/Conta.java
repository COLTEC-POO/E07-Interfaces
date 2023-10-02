public abstract class  Conta implements ITaxas {
    protected Cliente cliente;
    protected String Dono;
    protected String numeroConta;
    protected double saldoConta;
    protected double limiteConta;
    private Operacao[] operacoes;
    public static int totalContas = 0;
    private int qtdOperacoes;
    int numSaques=0;

    public Conta(String dono, String numeroConta, double saldoConta, double limiteConta) {
        this.Dono = String.valueOf(dono);
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
        this.limiteConta = limiteConta;
        this.operacoes = new Operacao[1000];
        this.qtdOperacoes=0;
        totalContas++;
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }
    public String getDono() {
        return Dono;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public double getSaldoConta() {
        return saldoConta;
    }
    public double getLimiteConta() {
        return limiteConta;
    }

    // Método para Depositar
    public boolean depositar(double valor) {
        if (valor >= 0) {
            this.saldoConta += valor;
            this.operacoes[qtdOperacoes++] = new OperacaoDeposito(valor);
            return true;
        }
        else {
            return false;
        }
    }

    // Método para Sacar
    public boolean sacar(double valor) {
        if (valor>=0 && valor <= this.saldoConta && valor <= this.limiteConta) {
            this.saldoConta -= valor;
            this.operacoes[qtdOperacoes++] = new OperacaoSaque(valor);
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        String imprimir =
                "Dono da conta: " + this.getDono() +
                "\nNumero da Conta: " + this.getNumeroConta() +
                        "\nSaldo atual: " + this.getSaldoConta() +
                        "\nLimite: " + this.getLimiteConta() ;

        return imprimir;
    }


    public boolean equals(Object outroNumConta) {
        if(outroNumConta instanceof Conta) {
            Conta outraConta = (Conta) outroNumConta;
            return this.getNumeroConta().equals(outraConta.getNumeroConta());
        } else {
            return false;
        }
    }


    public void imprimirExtratoTaxas(){

        double taxaManutencao = this.calculaTaxas();
        double totalOperacoes = 0;

        System.out.println("\n===== Extrato de Taxas =====");
        System.out.println("Manutenção da conta: R$" + taxaManutencao);
        System.out.println("Operações");

        for(int i=0; i<numSaques; i++){
            OperacaoSaque op = (OperacaoSaque) operacoes[i];
            System.out.println("Saque: " + op.calculaTaxas());
            totalOperacoes += op.calculaTaxas();
        }

        totalOperacoes += taxaManutencao;
        System.out.println("\nTotal: R$" + totalOperacoes);
    }
}