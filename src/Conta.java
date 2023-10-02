public abstract class Conta {

    //atribuições
    protected int numero;
    protected Cliente dono;
    protected double saldo;
    protected double limite;
    //private String senha;
    protected Operacao operacoes[];
    protected int operacaoAtual=0;
    protected static int TOTAL_CONTAS=0;

    //acoes
    public Conta(int numero, double saldo, double limite, Cliente dono) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.dono = dono;

        this.operacoes = new Operacao[1000];
        this.operacaoAtual = 0;

        TOTAL_CONTAS++;
    }

    public boolean depositar(double valor){
        if (valor >= 0) {
            this.saldo += valor;
            this.operacoes[operacaoAtual] = new OperacaoDeposito(valor);
            this.operacaoAtual=this.operacaoAtual+1;
            return true;
        } else {
            return false;
        }
    }
    public boolean sacar(double valor){
        if(valor<= this.saldo && valor>=0 && valor<=this.limite){
            this.saldo -= valor;
            this.operacoes[operacaoAtual] = new OperacaoSaque(valor);
            this.operacaoAtual=this.operacaoAtual+1;
            return true;
        }else{
            return false;
        }
    }

    public boolean transferir(Conta contaDestino, double valor){
        boolean retirou = this.sacar(valor);
        if(retirou){
            contaDestino.depositar(valor);
            return true;
        }else{
            return false;
        }
    }
    public String toString() {
        String operacoesStr = "";
        for (int i = 0; i < this.operacaoAtual; i++)
            operacoesStr += this.operacoes[i] + ", ";
        if (this.operacaoAtual > 0)
            operacoesStr = "[" + operacoesStr + operacoes[this.operacaoAtual-1] + "]";
        else
            operacoesStr = "[ ]";

        return "Conta{" +
                "\n\tnumero=" + numero +
                ",\n\tdono=" + dono +
                ",\n\tsaldo=" + saldo +
                ",\n\tlimite=" + limite +
                ",\n\toperacoes=" + operacoesStr +
                "\n}";
    }
    public boolean equals(Object outro) {
        if (outro instanceof Conta) {
            Conta outraConta = (Conta) outro;
            return this.getNumero() == outraConta.getNumero();
        }
        return false;
    }

    public Cliente getDono(){
        return this.dono;
    }
    public void setDono(Cliente dono){
        this.dono = dono;
    }
    public double getSaldo() {
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }

    public double getLimite(){
        return this.limite;
    }
    abstract void setLimite(double limite);

    public static double getTotalContas() {
        return Conta.TOTAL_CONTAS;
    }
    public int getOperacaoAtual(){
        return this.operacaoAtual;
    }


    /*public void imprimir(){
        System.out.println("INFORMACOES DA CONTA:");
        System.out.println("Numero: "+this.numero);
        System.out.println("Nome: "+this.dono.nome);
        System.out.println("Saldo: "+this.saldo);
        System.out.println("Limite: "+this.limite);
        System.out.println("INFORMACOES DO CLIENTE: ");
        //System.out.println("CPF: "+this.dono.cpf);
        System.out.println("Endereco: "+this.dono.endereco);
        //System.out.println("Sexo: "+this.dono.sexo);
        //System.out.println("Idade: "+this.dono.idade);
    }*/
    public void extrato(){
        for (int i=0; i<operacaoAtual; i++){
            operacoes[i].imprimirExtrato(operacoes[i]);
        }
    }
}


