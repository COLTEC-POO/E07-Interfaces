public abstract class Conta implements ITaxas{

    // Variaveis privadas basicas da conta
    final int numero;
    final String senha;
    private double saldo;
    final String dono;
    public double limite;

    // inicializando cliente;
    public final Cliente cliente;

    // Inicializando o array de operacoes
    final Operacao[] operacoes;

    // Numeros de Operacoes;
    public int numOp;

    // Comparando Contas
    public boolean equals(Object outro) {
        if (outro instanceof Conta) {
            Conta outraConta = (Conta) outro;

            System.out.println("As contas sao iguais");

            return this.numero == outraConta.numero;

        } else {
            System.out.println("As contas nao sao iguais");
            return false;
        }
    }

    // Construtor da Conta
    public Conta(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.dono = dono;

        this.cliente = cliente;

        this.limite = limite;

        this.operacoes = new Operacao[1000];

        this.numOp = 0;
    }

    // Metodo abstrato para forçar subClasses a implementar
    public abstract void depositar(double valor);

    // Metodo abstrato para forçar subClasses a implementar
    public abstract void sacar(double valor);

    // Metodo abstrato para forçar subClasses a implementar
    public abstract void imprimirExtrato();

    public abstract double setLimite(double valor);

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Imprimir dados de conta
    public String toString() {
        return "Número da Conta: " + this.numero + "\nSaldo: R$" + getSaldo() + "\nDono: " + this.dono + "\nLimite: R$" + this.limite + "\n \n=== Dados como cliente === \n" + this.cliente.toString();
    }

    public void imprimirExtratoTaxas() {
        double totalTaxas = 0;

        System.out.println("=== Extrato de Taxas ===");
        System.out.println("Manutenção da conta: " + calculaTaxas());

        for (int i = 0; i < numOp; i++) {
            if (operacoes[i] instanceof ITaxas) {
                double taxa = ((ITaxas) operacoes[i]).calculaTaxas();
                System.out.println("Saque: " + taxa);
                totalTaxas += taxa;
            }
        }

        System.out.println("Total: " + (totalTaxas + calculaTaxas()));
    }

    public static class ContaCorrente extends Conta  implements ITaxas {

        public ContaCorrente(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
            super(numero, senha, saldo, dono, limite, cliente);
            setLimite(limite);
        }

        @Override

            public double calculaTaxas() {
                if (cliente instanceof Cliente.PessoaFisica) {
                    return 10.0;
                } else if (cliente instanceof Cliente.PessoaJuridica) {
                    return 20.0;
                }
                return 0.0; // Se não for nem PessoaFisica nem PessoaJuridica, retorna 0.
            }

        @Override
        public void sacar(double valor) {
            double saldoAtual = getSaldo();

            if (valor >= 0 && valor <= saldoAtual) {
                double taxa = 0;
                // Verifica se há operações antes de tentar acessar o array
                if (numOp > 0 && operacoes[numOp - 1] instanceof Operacao.OperacaoSaque) {
                    taxa = ((Operacao.OperacaoSaque) operacoes[numOp - 1]).calculaTaxas() + valor;
                }

                // Adiciona a taxa de saque ao saldo
                this.setSaldo(saldoAtual - valor - taxa);

                this.operacoes[numOp] = new Operacao.OperacaoSaque(valor);
                numOp++;
            } else {
                System.out.println("Dinheiro indisponível, valor disponível: R$: " + saldoAtual);
            }
        }

        @Override
        public void depositar(double valor) {
            double saldoAtual = getSaldo();

            if (valor >= 0) {
                this.setSaldo(saldoAtual + valor);

                this.operacoes[numOp] = new Operacao.OperacaoDeposito(valor);
                numOp++;
            }
        }

        @Override
        public void imprimirExtrato() {
            System.out.println("Extrato da conta de " + this.dono);
            for (int i = 0; i < numOp; i++) {
                System.out.println(operacoes[i].toString());
            }
        }

        @Override
        public double setLimite(double valor) {
            if (valor >= -100) {
                return this.limite = valor;
            } else {
                System.out.println("Limite mínimo de -100 reais");
            }
            return 0;
        }
    }

    public static class ContaPoupanca extends Conta {

        public ContaPoupanca(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
            super(numero, senha, saldo, dono, limite, cliente);
            setLimite(limite);
        }

        public double calculaTaxas() {
            return 0;
        }

        @Override
        public void sacar(double valor) {
            double saldoAtual = getSaldo();

            if (valor >= 0 && valor <= saldoAtual) {
                double taxa = 0;
                // Verifica se há operações antes de tentar acessar o array
                if (numOp > 0 && operacoes[numOp - 1] instanceof Operacao.OperacaoSaque) {
                    taxa = ((Operacao.OperacaoSaque) operacoes[numOp - 1]).calculaTaxas() * valor;
                }

                // Adiciona a taxa de saque ao saldo
                this.setSaldo(saldoAtual - valor - taxa);

                this.operacoes[numOp] = new Operacao.OperacaoSaque(valor);
                numOp++; // Incrementa numOp após adicionar a operação
            } else {
                System.out.println("Dinheiro indisponível, valor disponível: R$: " + saldoAtual);
            }
        }

        @Override
        public void depositar(double valor) {
            double saldoAtual = getSaldo();

            if (valor >= 0) {
                this.setSaldo(saldoAtual + valor);

                this.operacoes[numOp] = new Operacao.OperacaoDeposito(valor);
                numOp++;
            }
        }

        @Override
        public void imprimirExtrato() {
            System.out.println("Extrato da conta de " + this.dono);
            for (int i = 0; i < numOp; i++) {
                System.out.println(operacoes[i].toString());
            }
        }

        @Override
        public double setLimite(double valor) {
//            Limite máximo de 1000 reais, e limite mínimo de 100 reais.
            if (valor >= 100 && valor <= 1000) {
                return this.limite = valor;
            } else {
                System.out.println("Limite mínimo de 100 reais e máximo de 1000");
            }
            return 0;
        }
    }

    public static class ContaUniversitaria extends Conta {

        public ContaUniversitaria(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
            super(numero, senha, saldo, dono, limite, cliente);
            setLimite(limite);
        }

        @Override
        public void sacar(double valor) {
            double saldoAtual = getSaldo();

            if (valor >= 0 && valor <= saldoAtual) {
                this.setSaldo(saldoAtual - valor);

                this.operacoes[numOp] = new Operacao.OperacaoSaque(valor);
                numOp++;
            } else {
                System.out.println("Dinheiro indisponivel, valor disponivel: R$: " + saldoAtual);
            }
        }

        @Override
        public void depositar(double valor) {
            double saldoAtual = getSaldo();

            if (valor >= 0) {
                this.setSaldo(saldoAtual + valor);

                this.operacoes[numOp] = new Operacao.OperacaoDeposito(valor);
                numOp++;
            }
        }

        @Override
        public void imprimirExtrato() {
            System.out.println("Extrato da conta de " + this.dono);
            for (int i = 0; i < numOp; i++) {
                System.out.println(operacoes[i].toString());
            }
        }

        @Override
        public double setLimite(double valor) {
//            Limite máximo de 1000 reais, e limite mínimo de 100 reais.
            if (valor >= 0 && valor <= 500) {
                return this.limite = valor;

            } else {
                System.out.println("Limite máximo de 1000 reais e mínimo de 100 reais");
            }
            return 0;
        }

        @Override
        public double calculaTaxas() {
            return 0;
        }
    }
}