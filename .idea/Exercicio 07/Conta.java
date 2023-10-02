public abstract class Conta implements ITaxas{

    protected int numero;
    protected String senha;
    protected double saldo;
    protected Cliente dono;
    protected double limite;
    private Operacao[] operacoes;
    private int ProxOperacao;
    protected static int totalContas = 0;
    private double totalTaxas;

    public String toString(){


        String ContaStr =
                "========== Conta =========" +"\n" +
                        "Numero da Conta: " + this.numero + "\n" +
                        "Saldo: " + this.saldo + "\n" +
                        "Dono: " + this.dono.nome + "\n" +
                        "Limte: " + this.limite + "\n" +
                        "==========================" + "\n";

        return ContaStr;
    }


    public Conta(int numero, String senha, double saldo,Cliente dono,double limite){

        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.dono = dono;
        this.limite = limite;

        operacoes = new Operacao[1000];
        ProxOperacao = 0;
        totalTaxas = 0.0;

        // Conta quantas novas contas já foram criadas
        totalContas++;

    }


    //public TIPO_RETORNO NOME_DO_MÉTODO(TIPO VARI1, TIPO VARI2,...){
    //}

    public boolean depositar(double valor) {
        if (valor >= 0) {
            this.saldo += valor;

            Operacao operacao = new OperacaoDeposito(valor);
            RegistrarOperacoes(operacao);

            return true;
        }
        else{
            return false;
        }
    }

    public boolean sacar(double valor){

        if(valor >= 0 && valor <= this.saldo) {
            this.saldo -= valor;

            Operacao operacao = new OperacaoSaque(valor);
            RegistrarOperacoes(operacao);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean transferir(double valor, Conta destino){
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        else{
            return false;
        }
    }

    public void RegistrarOperacoes(Operacao operacao){

        if (ProxOperacao < 1000) {
            operacoes[ProxOperacao] = operacao;
            ProxOperacao++;
        }

    }

    public void imprimirExtrato(){

        for(int i = 0; i < ProxOperacao; i++){

            Operacao operacao = operacoes[i];
            System.out.println(operacao.getData() + "\t" + operacao.getTipo() + "\t" + operacao.getValor());
        }
    }

    public boolean equals(Object outraC){

        if(outraC instanceof Conta){

            Conta outraConta = (Conta) outraC;
            return this.getNumero() == outraConta.getNumero();

        } else{
            return false;
        }

    }

    public void imprimirExtratoTaxas(){

        double manutencao = calculaTaxas();

        System.out.println("==== Extrato de Taxas ====");
        System.out.println("Manutencao da conta: " + manutencao);

        for(int i = 0; i < ProxOperacao; i++){

            Operacao operacao = operacoes[i];

            // double taxa = operacao.calculaTaxas();

            //if (taxa > 0.0) {

            //if(operacao.getTipo() == 's'){
            //System.out.println("Saque: " + taxa);

            //}
            //if(operacao.getTipo() == 'd'){
            //System.out.println("Deposito: " + taxa);

            //}
            //totalTaxas += taxa;
            //}
        }

        //System.out.println("\nTotal: " + totalTaxas);

    }

    public abstract void setLimite();


    // DONO
    public Cliente getDono(){
        return this.dono;
    }
    public Cliente setDono(){
        return this.dono;
    }

    // NUMERO
    public int getNumero(){
        return this.numero;
    }
    public int setNumero(){
        return this.numero;
    }

    // SALDO
    public double getSaldo(){
        return this.saldo;
    }

    //LIMITE
    public double getLimite(double limite){

        return this.limite;
    }

    // TOTAL DE CONTAS

    public static int getTotalContas(){
        return totalContas;
    }

}

