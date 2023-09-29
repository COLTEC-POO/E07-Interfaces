import java.util.Date;

// Classe Cliente que representa um cliente genérico
public abstract class Cliente {
    String endereco;
    String nome;
    Date data;

    // Construtor do Cliente
    protected Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.data = new Date();
    }

    // Método abstrato de autenticação
    public abstract boolean autenticar(String chave);

    // Métodos abstratos para forçar subclasses a criar instâncias
    public abstract String getTipo();

    // Classe interna PessoaFisica que representa um cliente pessoa física
    public static class PessoaFisica extends Cliente {
        public String cpf;
        public int idade;
        public char sexo;

        // Construtor de PessoaFisica
        public PessoaFisica(String nome, String endereco, String cpf, int idade, char sexo) {
            // Chama o construtor da superClasse Cliente
            super(nome, endereco);

            this.cpf = cpf;
            this.idade = idade;
            this.sexo = sexo;
        }

        // Sobrescreve o método para retornar o tipo
        @Override
        public String getTipo() {
            return "Pessoa Fisica";
        }

        // Sobrescreve a função abstrata acima
        @Override
        public boolean autenticar(String chave) {

            return this.cpf.equals(chave);
        }

        // Sobrescreve a função toString() para exibir informações de PessoaFisica
        @Override
        public String toString() {
            return "Pessoa Fisica: \n" +
                    "Nome: " + nome + " \n" +
                    "Endereço: " + endereco + " \n" +
                    "Data: " + data + " \n" +
                    "CPF: " + cpf + "\n" +
                    "Idade: " + idade + "\n" +
                    "Sexo: " + sexo;
        }

        // Sobrescreve a função equals para comparar objetos PessoaFisica com base no CPF
        @Override
        public boolean equals(Object outroCliente) {
            if (outroCliente instanceof Cliente.PessoaFisica) {
                Cliente.PessoaFisica pessoaFisica = (Cliente.PessoaFisica) outroCliente;

                return this.cpf.equals(pessoaFisica.cpf);
            }
            return false;
        }
    }

    // Classe interna PessoaJuridica que representa um cliente pessoa jurídica
    public static class PessoaJuridica extends Cliente {
        public String cnpj;
        public String setor;
        public int numFunc;

        // Construtor de PessoaJuridica
        public PessoaJuridica(String nome, String endereco, String setor, String cnpj, int numFunc) {
            // Chama o construtor da superClasse Cliente
            super(nome, endereco);

            this.cnpj = cnpj;
            this.numFunc = numFunc;
            this.setor = setor;
        }

        // Sobrescreve o método para retornar o tipo
        @Override
        public String getTipo() {
            return "Pessoa Juridica";
        }

        // Sobrescreve a função abstrata de autenticar
        @Override
        public boolean autenticar(String chave) {
            return this.cnpj.equals(chave);
        }

        // Sobrescreve a função toString() para exibir informações de PessoaJuridica
        @Override
        public String toString() {
            return "Pessoa Juridica: \n" +
                    "Nome: " + nome + " \n" +
                    "Endereço: " + endereco + " \n" +
                    "Data: " + data + " \n" +
                    "CNPJ: " + cnpj + "\n" +
                    "NumFuncionarios: " + numFunc + "\n" +
                    "Setor: " + setor;
        }

        // Sobrescreve a função equals para comparar objetos PessoaJuridica com base no CNPJ
        @Override
        public boolean equals(Object outroCliente) {
            if (outroCliente instanceof Cliente.PessoaJuridica) {
                Cliente.PessoaJuridica pessoaJuridica = (Cliente.PessoaJuridica) outroCliente;

                return this.cnpj.equals(pessoaJuridica.cnpj);
            }
            return false;
        }
    }
}