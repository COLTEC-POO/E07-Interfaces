import com.sun.security.ntlm.Client;

import java.util.Objects;
import java.util.Scanner;

public abstract class Conta implements ITaxas{

    //----------------------------------------- Atribultos Classe ------------------------------------------------//

    //Numero de Contas Abertas:
    private static Integer numContasCriadas = 0;

    private static Integer numMaxOperacoesArmazenadas = 1000;


    private int nOperacoesConta;

    //Numero da Conta:
    private Integer numConta;

    //Titular:
    private Cliente dadosCliente;

    //Limite Credito Conta:
    private double limite;

    //Saldo Disponivel:
    private double saldo;

    //Extrato de Operações - Maximo de 1000 operações salvas.
    private Operacao[] operacoes = new Operacao[numMaxOperacoesArmazenadas];

    //---------------------------------------- Fim Atribultos Classe ---------------------------------------------//


    //----------------------------------------- Metodo Construtor ------------------------------------------------//

    public Conta(Cliente tipo){
        this.dadosCliente = tipo;
        this.numConta = numContasCriadas + 1000;
        this.saldo = 0;
        this.nOperacoesConta = 0;
        setNumContasCriadas(this.getNumContasCriadas() + 1);
    }

    //---------------------------------------- Fim Metodo Construtor ---------------------------------------------//

    //--------------------------------------------- Metodos Get --------------------------------------------------//

    /**
     * Metodo para ler numero da conta
     * @return numero da conta.
     */
    private Integer getNumConta() {
        return this.numConta;
    }

    /**
     * Metodo para ler dados cliente.
     * @return dados do cliente.
     */
    public Cliente getDadosCliente() {
        return this.dadosCliente;
    }

    /**
     * Metodo para ler limite da conta.
     * @return limite de credito.
     */
    private double getLimite() {
        return this.limite;
    }

    /**
     * Metodo para ler saldo da conta.
     * @return saldo disponivel.
     */
    private double getSaldo() {
        return this.saldo;
    }

    /**
     * Metodo para ler numero de contas criadas.
     * @return numero de contas criadas.
     */
    public Integer getNumContasCriadas() {
        return numContasCriadas;
    }

    /**
     * Metodo para acessar numero de operações realizadas.
     * @return Retorna numero de operacoes realizadas
     */
    public int nOperacoesRealizadas(){
        return (this.operacoes[0].getnOperacoes());
    }

    public int getnOperacoesConta() {
        return nOperacoesConta;
    }

    //-------------------------------------------- Fim Metodos Get -----------------------------------------------//

    //--------------------------------------------- Metodos Set --------------------------------------------------//

    public void setLimite(double limite){
        this.limite = limite;
    }

    public static void setNumContasCriadas(Integer numContasCriadas) {
        Conta.numContasCriadas = numContasCriadas;
    }

    public void setnOperacoesConta(int nOperacoesConta) {
        this.nOperacoesConta = nOperacoesConta;
    }

    //-------------------------------------------- Fim Metodos Set -----------------------------------------------//

    //----------------------------------------- Funcionalidades Conta --------------------------------------------//


    @Override
    public double calcularTaxa(){
        return 0.0;
    }

    public abstract void definirLimite(double valor);

    /**
     * Metodo para realizar o deposito de um valor x;
     * EX:
     *      boolean retorno = depositar(1500) //Para depositar R$1500;
     *
     * @param valor valor a ser depositado.
     * @return true = caso deposito realizado // false = caso ocorra erro.
     */
    public boolean depositar(double valor){
        boolean VALOR_VALIDO;

        VALOR_VALIDO = (valor > 0);

        if(VALOR_VALIDO) {
            this.saldo += valor;

            this.operacoes[this.getnOperacoesConta()] = new OperacaoDeposito(valor); //Armazena a operação no extrato.
            this.setnOperacoesConta(getnOperacoesConta() + 1);
            System.out.println("\nDEPOSITO REALIZADO COM SUCESSO");
            imprimirExtrato();

            return true;
        }else {
            System.out.println("\nIMPOSSIVEL REALIZAR OPERAÇÃO");
            return false;
        }
    }

    /**
     * Função para realizar saque da conta de um valor x.
     * EX:
     *      boolean retorno = sacar(1500) //Para sacar R$1500;
     *
     *  @param valor valor a ser sacado.
     * @return true = caso valor sacado // false = caso ocorra erros.
     */
    public boolean sacar(double valor){
        boolean retorno, SALDO_INSUFICIENTE, VALOR_INVALIDO;

        retorno = validarOperacao();

        if(retorno){
            VALOR_INVALIDO = (valor < 0);
            SALDO_INSUFICIENTE = (valor > getSaldo());

            if(SALDO_INSUFICIENTE){
                System.out.println("\nSALDO INSUFICIENTE");
                retorno =  false;
            }else if(VALOR_INVALIDO){
                System.out.println("\nVALOR INVALIDO");
                retorno = false;
            }else{
                this.saldo -= valor;

                this.operacoes[this.getnOperacoesConta()] = new OperacaoSaque(valor);
                setnOperacoesConta(getnOperacoesConta() + 1);
                System.out.println("\nSAQUE REALIZADO COM SUCESSO");
                imprimirExtrato();

                retorno = true;
            }
        }

        return retorno;
    }

    /**
     * Função para realizar transferência de um valor x entre contas.
     * EX:
     *      boolean retorno = trasferir(ContaX, 1500) //Para transferir R$1500 para conta X;
     *
     * @param destino Endereço Conta destino.
     * @param valor Valor a ser tranferido
     * @return true = se tranferencia realizada // false = caso ocorra erros.
     */
    public boolean tranferencia(Conta destino, double valor){
        boolean retorno;

        if (valor < this.getSaldo()) {

            System.out.println("\nTRANSFERINDO R$ " + valor + " PARA " + destino.dadosCliente.getNome());
            retorno = sacar(valor); //Tenta realizar o saque do valor.

            if (retorno) {

                retorno = destino.depositar(valor); // Se sacou, tenta depositar na conta destino.

                if (retorno) {
                    System.out.println("TRANSFERENCIA REALIZADA COM SUCESSO");
                    return true; //Se conseguiu depositar retorna.
                } else {
                    this.depositar(valor); //Se não conseguir depositar no destino retorna valor para conta.
                }
            }

            //Exibe mensagem de erro para o usuario.
            System.out.println("ERRO NA OPERAÇÃO - TENTE NOVAMENTE MAIS TARDE");

        } else {
            System.out.println("ERRO NA OPERAÇÃO - TENTE NOVAMENTE MAIS TARDE");
        }


        return false;//Retorno falso, não conseguindo realizar a operação por erro de saldo ou transferencia.
    }

    public boolean validarOperacao(){
        Scanner entrada = new Scanner(System.in);
        String senha;
        Boolean retorno = true;

        System.out.println(this.dadosCliente.getNome() + "\nDigite Sua Senha: ");
        senha = entrada.nextLine();

        if(!this.dadosCliente.autenticar(senha)) retorno = false;

        return retorno;
    }

    //--------------------------------------- Fim Funcionalidades Conta ------------------------------------------//

    //----------------------------------------- Metodos Exibir Dados ---------------------------------------------//

    @Override
    public void imprimirExtratoTaxas() {
        double manutencao, somaTaxas = 0;

        exibirDadosConta();
        System.out.println("==== EXTRATO DE TAXAS ====");

        manutencao = this.calcularTaxa();
        System.out.println("MANUTENÇÃO CONTA: R$ " + manutencao);

        for(int i = 0; i < this.getnOperacoesConta(); i++){
            if(this.operacoes[i].getTipo() == 's'){
                somaTaxas += this.operacoes[i].calcularTaxa();
                this.operacoes[i].imprimirExtratoTaxas();
            }
        }

        System.out.println("TOTAL: R$ " + (somaTaxas + manutencao) + "\n==============\n");
    }

    /**
     * Metodo para exibir dados simples da conta. Titular / Numero Conta
     */
    public void exibirDadosConta(){
        System.out.println("TITULAR: " + this.dadosCliente.getNome());
        System.out.println("CONTA: " + this.getNumConta());
    }

    /**
     * Metodo para exibir dados detalhados da conta. Dados Titular / Dados da Conta / Valores / Operacoes
     */
    public void exibirDadosDetalhado(){
        this.dadosCliente.toString();
        System.out.println("SALDO: " + this.saldo);
        System.out.println("LIMITE: " + this.limite);
        System.out.println("N° OPERACOES REALIZADAS: " + this.getnOperacoesConta());
    }

    /**
     * Metodo para exibir o saldo disponivel em conta.
     */
    public void exibirSaldo(){
        exibirDadosConta();
        System.out.println("SALDO: " + this.getSaldo());
    }

    /**
     * Metodo para exibir o limite de credito da conta.
     */
    public void exibirLimite(){
        exibirDadosConta();
        System.out.println("SALDO: " + this.getLimite());
    }

    /**
     * Metodo para exibir ultima operação realizada na conta.
     */
    public void imprimirExtrato(){
        exibirDadosConta();
        System.out.println(operacoes[this.getnOperacoesConta() - 1].toString());
    }

    /**
     * Metodo para exibir todas as operações realizadas pela conta - limite 1000.
     */
    public void imprimirExtratoDetalhado(){
        int i;
        boolean SEM_DADOS;

        SEM_DADOS = (this.operacoes[0].getnOperacoes() == 0);

        if(SEM_DADOS){
            System.out.println("SEM REGISTROS DE OPERAÇÕES");
        }else{
            System.out.println("\nEXTRATO DETALHADO");
            exibirDadosDetalhado();

            for(i = 0; i < this.getnOperacoesConta(); i++){
                this.operacoes[i].toString();
            }
            System.out.println("\n");
        }
    }

    //--------------------------------------- Fim Metodos Exibir Dados -------------------------------------------//

    //------------------------------------------ Redefinição Objects ---------------------------------------------//

    public String toString(){
        return dadosCliente.toString() + "\nDADOS CONTA: " + "\nNUMERO: " + getNumConta() + "\nLIMITE: " + getLimite()
                +"\nSALDO: " + getSaldo() +"\nNUMERO OPERACOES: " + getnOperacoesConta() ;
    }

    public boolean equals(Object obj) {
        boolean NOT_ERRO, retorno = false;
        Conta contaComparada = (Conta) obj;

        NOT_ERRO = (contaComparada != null);

        if(NOT_ERRO){
            retorno = (Objects.equals(this.getNumConta(), contaComparada.getNumConta()));
            retorno = this.dadosCliente.equals(contaComparada.dadosCliente);
        }

        return retorno;
    }

    //---------------------------------------- Fim Redefinição Objects -------------------------------------------//

}