import java.util.Scanner;
public abstract class Conta implements ITaxas {
    //atributos
    private static int totalContas=0;
    private int numConta;
    private Cliente Cliente;
    private double saldo;
    private double limite;
    private boolean tipo;
    private Operacao[] operações = new Operacao[1000];
    private int Numop=0;
    private Cliente dadosCliente;


    //Getters
    public int getnumConta(){
        return this.numConta;
    }
    public Cliente getCliente(){
        return this.Cliente;
    }
    public double getsaldo(){
        return this.saldo;
    }
    public double getlimite(){
        return this.limite;
    }
    public boolean gettipo(){
        return this.tipo;
    }
    public int getNumOp(){
        return this.Numop;
    }
    public int gettotalContas(){
        return totalContas;
    }
    public Cliente getdadosCliente(){
        return this.dadosCliente;
    }
    
    

    //Setters
    public void setnumConta(int numConta){
         this.numConta = numConta;
    }
    public void setcCliente(Cliente Cliente){
         this.Cliente = Cliente;
    }
    public void setsaldo(double saldo){
         this.saldo = saldo;
    }

    public void setlimite(double limite) {
        this.limite = limite;
    }

    private void settotalContas(int totalContas){
        Conta.totalContas = totalContas;
    }
    public void setdadosCliente(Cliente dadosCliente){
        this.dadosCliente = dadosCliente;
    }


    //Ações

        public Conta(Cliente tipo){
            this.dadosCliente=tipo;
            this.numConta =totalContas;
            this.limite = 0;
            this.saldo = 0;
            this.Numop=0;

            settotalContas(this.gettotalContas() + 1);
        }
        

    //Metodo para fazer depositos
    //Para criar um metodo basta colocar o public + retorno +nome + (tipo parametro)
    public boolean depositar(double valor){
        if (valor>=0) {
            this.saldo = this.saldo + valor;
            operações[Numop]=new OperacaoDeposito(valor);
            Numop++;
            return true;
        } else {
            return false;
        }
        
    }

    public abstract void limiteConta(double valor);

    //Metodo para saque 

    public boolean sacar(double valor){ //Para ter retorno se funcionou

        if(valor<=this.saldo){
            this.saldo-= valor;
            operações[Numop]=new OperacaoSaque(valor);
            Numop++;
            return true; 
        }
        else{
            return false;
        }
    }

    public void imprimeExtrato(){
        int i;
        
            for(i = 0; i < this.getNumOp(); i++){
                this.operações[i].toString();
            }
    }

    public String toString() {
		 String dadosCliente ="Numero da Conta: " + this.numConta + "\n" +
						 	 "Limite: " + this.limite + "\n" +
						 	 "Saldo: " + this.saldo;
						 
		return dadosCliente;
	}

    public boolean equals(Object objeto) {

            Conta CompararConta = (Conta) objeto;
        
            if(this.numConta == CompararConta.numConta) {
                return true;
            }else {
                return false;
            }

    }

    public boolean validaOperacao(){
        Scanner entrada = new Scanner(System.in);
        String chaveid;

        System.out.println(this.dadosCliente.getNome() + "\nDigite Sua Senha: ");
        chaveid = entrada.nextLine();

        if(!this.dadosCliente.autenticar(chaveid))
            entrada.close();
            return false;
        
    }

    @Override
    public double calculaTaxa(){
        return 0.0;
    }
    @Override
    public void ExtratoTaxas() {
        double anuidade, soma = 0;

        anuidade = this.calculaTaxa();
        System.out.println("=== Extrato de Taxas ===");
        System.out.println("MANUTENÇÃO CONTA: R$ " + anuidade);

        for(int i = 0; i < this.getNumOp(); i++){
            if(this.operações[i].gettipo() == 's'){
                soma= soma + this.operações[i].calculaTaxa();
                this.operações[i].ExtratoTaxas();
            }
        }

        System.out.println("TOTAL: R$ " + (soma + anuidade));
    }

}