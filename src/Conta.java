public abstract class Conta {

    //atributos da classe Conta
    protected Cliente dono;
    private String numero;//transformei em string para usar o equals

    private double saldo;
    public Operacao[ ]operacoes;

    //variavel para controlar o indice do vetor de operações
    public int numeroOp;

    //numero de contas criadas durante a execução do sistema
    public static int totalContas=0;

    //metodos da classe conta:
    //construtor:

    //metodo para criar
    public Conta(Cliente dono,int numConta){
        this.saldo=0;
        this.numero="0";
        this.dono=dono;
        this.operacoes=new Operacao[1000];
        numeroOp=0;
        Conta.totalContas++;
    }

    //metodos getters e setters:
    public String getDono(){
        return dono.getNome();
    }

    public void setDono(String nome){
        dono.setNome(nome);
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String numero){
        this.numero=numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    /*public double getLimite() {
        return limite;
    }*/

    public abstract void setLimite(double limite);


    //metodo - saque: possibilita a retirada de dinheiro da conta
    public boolean sacar(double valor){
        if(valor<=this.saldo){
            operacoes[numeroOp]=new OperacaoSaque(valor);
            this.saldo-=valor;
            numeroOp++;
            return true;
        } else{
            return false;
        }
    }

    //metodo - depositar: possibilita o deposito de dinheiro na conta
    public void depositar(double valor){
        operacoes[numeroOp]=new OperacaoDeposito(valor);
        this.saldo=this.saldo+valor;
        numeroOp++;
    }

    public String toString(){
        String contaStr= "Número:"+this.numero+"\n"+
                "Nome:"+this.dono.getNome()+"\n"+
                "Saldo:"+this.saldo+"\n";
        return contaStr;
    }

    public boolean equals(Object obj){

        if(obj instanceof Conta){
            Conta objConta=(Conta)obj;
            if(this.numero.equals(objConta.numero)){
                return true;
            }
            else{
                return false;
            }
        }else{
            return false;
        }

    }

}
