public abstract class Conta {

    //atributos
    public static Integer qtdContas = 0;

    private static Integer maxOperacoes = 1000;

    private Cliente cliente;
    private Integer numConta;
    private Double saldo;
    private Double limite;
    private Boolean tipo;
    private Operacao[] operacoes = new Operacao[maxOperacoes];
    private Integer qtdOperacoes = 0;


    // Construct para iniciar a conta

    /**
     * @param cliente
     * @param tipo
     * @param saldo_inicial
     * @param limite
     * @param numConta
     */
    public Conta(Cliente cliente, Boolean tipo, Double saldo_inicial, Double limite, Integer numConta){
        try{
            validaCliente(cliente);
            validaTipo(tipo);
            validaSaldo(saldo_inicial);
            validaLimite(limite);
            validaNumConta(numConta);
            validaQtdOperacoes(0);
            qtdContas++;
        }catch (Exception e) {
            System.out.println("Dados invalidos!");
        }
    }

    public Conta(){
        
    }

    //Getters
    public Cliente cliente(){
        return this.cliente;
    }

    public Boolean getTipo(){
        return this.tipo;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public Double getLimite(){
        return this.limite;
    }

    public Integer getNumConta(){
        return this.numConta;
    }

    public Double getMedia(){
        return 1.0 * operacoes.length / qtdContas;
    }
    public Integer getQtdOperacao(){
        return this.qtdOperacoes;
    }
    //FIM Getters

    //Setters
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void setTipo(Boolean tipo){
        this.tipo = tipo;
    }

    public void setSaldoInicial(Double saldo){
        this.saldo = saldo;
    }

    public void setLimite(Double limite){
        this.limite = limite;
    }

    public void setNumConta(Integer numConta){
        this.numConta = numConta;
    }

    public void setQtdOperacao(Integer qtdOperacoes){
        this.qtdOperacoes = qtdOperacoes;
    }
    //FIM Setters

    //Validadores de dados
    public void validaCliente(Cliente cliente){
        setCliente(cliente);
    }

    public void validaTipo(Boolean tipo){
        setTipo(tipo);
    }

    public void validaSaldo(Double saldo){
        if (saldo >= 0)
            setSaldoInicial(saldo);
    }

    public void validaLimite(Double limite){
        if (limite >= 0)
            setLimite(0.0);
    }

    public void validaNumConta(Integer numConta){
        setNumConta(numConta);
    }

    public void validaQtdOperacoes(Integer qtdOperacoes){
        if (qtdOperacoes >= 0 || qtdOperacoes < maxOperacoes)
            setQtdOperacao(qtdOperacoes);
    }
    //FIM Validadores


    //Operações com as contas
    public void imprimirSaldo() {
        System.out.println("Conta " + this.numConta);
        System.out.println("Saldo: R$" + this.saldo);
    };

    public Boolean sacar(Double valor) {
      if (valor > saldo || valor < 0 || operacoes[operacoes.length - 1] != null) {
          return false;
      } else {
          this.saldo-= valor;
          System.out.println("Valor sacado: R$" + valor);
          System.out.println("Novo Saldo: R$" + this.saldo);
          operacoes[qtdOperacoes] = new OperacaoSaque(valor); 
          qtdOperacoes++;
          return true;
      }
    }

    public Boolean depositar(Double valor) {
        if (valor < 0 || operacoes[operacoes.length - 1] != null){
            return false;
        } else {
            this.saldo += valor;
            System.out.println("Valor depositado: R$" + valor);
            System.out.println("Novo Saldo: R$" + this.saldo);
            operacoes[qtdOperacoes] = new OperacaoDeposito(valor); 
            qtdOperacoes++;
            return true;
        }
    }

    public Boolean transferir(Conta destino, Double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        } else {
            System.out.println("Transferencia incompleta, saldo disponivel: R$" + this.saldo);
            return false;
        }
    }

    public void mostraConta(){
        System.out.println("Conta " + this.numConta);
        System.out.println("Proprietário " + this.cliente.getNome());
        System.out.println("Saldo: R$" + this.saldo + " Limite: R$ " + this.limite);
    }

    public void mostraConta(Boolean compelta){
        System.out.println("Conta " + this.numConta);
        System.out.println("Saldo: R$" + this.saldo + " Limite: R$ " + this.limite);
        cliente.mostraCliente();
    }

    public void mostraExtrato(){
        System.out.println("Conta " + this.numConta + " Titular: " + this.cliente.getNome() + " Saldo: R$ " + this.saldo);
        if (operacoes.length != 0){
            for (Operacao o : operacoes){
                if (o!= null){
                    o.extrato();
                }
            }
            System.out.println("Quantidade de Operações: " + this.qtdOperacoes);
        }
        else{
            System.out.println("Não há operações");
        }
    }

    public abstract Double calculaTaxas();

    public void imprimeExtratoTaxas(){
        System.out.println("\n=== Extrato de Taxas ===");

        System.out.println("\nManutenção de Conta: R$" + this.calculaTaxas());

        System.out.println("\n\nOperações");
        for (ITaxas operacao : operacoes) {
            if (operacao.calculaTaxas() != 0.0)
                System.out.println("Saque: " + operacao.calculaTaxas());
        }


    }
    //FIM Operações com as contas

}