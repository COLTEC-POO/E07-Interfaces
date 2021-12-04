public abstract class Conta implements ITaxas{

    //Conteudo class conta

    private Cliente memoryCliente;
    private int memoryId;
    private double memorySaldo;
    private double memoryLimite;
    private int posicaoOpr = 0;
    static int totalContas = 0;
    Operacao [] operacoes = new Operacao [1000];

    //-----------------------------------------------------------------------------------------------------//
    public Conta (){
        totalContas++;
    }

    //-----------------------------------------------------------------------------------------------------//
    //Getters
    //-----------------------------------------------------------------------------------------------------//
    public int getMemoryId(){
        return this.memoryId;
    }

    public Cliente getMemoryCliente(){
        return this.memoryCliente;
    }

    public double getMemorySaldo(){
        return this.memorySaldo;
    }

    public double getMemoryLimite(){
        return this.memoryLimite;
    }

    //-----------------------------------------------------------------------------------------------------//
    //Setters
    //-----------------------------------------------------------------------------------------------------//
    public void setMemoryCliente(Cliente memoryCliente){
        this.memoryCliente = memoryCliente;
    }

    public void setMemoryId(int memoryId){
        this.memoryId = memoryId;
    }

    public void setLimite(int limite) {
        if (limite < 0) {
            this.memoryLimite = 0;
        } else {
            this.memoryLimite = limite;
        }
    }



    //-----------------------------------------------------------------------------------------------------//
    //Métodos
    //-----------------------------------------------------------------------------------------------------//
    boolean sacar(double valor) {
        Operacao opr;
        if (valor <= this.memorySaldo) {
            this.memorySaldo -= valor;
            opr = new OperacaoSaque (valor);
            operacoes[posicaoOpr] = opr;
            posicaoOpr ++;
            return true;
        } else {
            return false;
        }
    }

    void depositar(double valor) {
        Operacao opr;
        this.memorySaldo += valor;
        opr = new OperacaoDeposito (valor);
        operacoes[posicaoOpr] = opr;
        posicaoOpr ++;
    }

    boolean transferir(Conta destino, double valor) {
        boolean saqueRealizado;
        saqueRealizado = this.sacar(valor);
        if (saqueRealizado) {
            destino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object obj){
        Conta that = (Conta) obj;

        return (this.memoryId == that.memoryId);
    }

    void imprimirExtrato (){
        int i;
        for (i = 0; i < posicaoOpr; i++){
            Operacao operacaoAtual;
            operacaoAtual = operacoes [i];
            System.out.println(operacaoAtual.getDataOperacao() + "\t" + operacaoAtual.getTipo() + "\t$:\t" + operacaoAtual.getValor() + "\tTaxa:\t" + operacaoAtual.calculaTaxas());
        }
    }

    public String toString(){
        return String.format("%s \nID: %d\nSaldo: %f \nLimite: %f", this.memoryCliente.toString(), this.memoryId, this.memorySaldo, this.memoryLimite);
    }

    //-----------------------------------------------------------------------------------------------------//

}
