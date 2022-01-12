public class ContaCorrente extends Account {

    public ContaCorrente(Client owner, double total, double limit, int id) {
        super(owner, total, limit, id);
    }

    @Override
    public void setLimit(double limit) {
        if (limit < -100) {
            throw new IllegalArgumentException("Limit cannot be less than 100");
        }

        this.limit = limit;
    }

    public double calculaTaxas() {
        if (this.owner instanceof PessoaFisica) {
            return 10;
        } else if (this.owner instanceof PessoaJuridica) {
            return 20;
        }

        throw new IllegalStateException("Owner is not a PessoaFisica or PessoaJuridica");
    }
}
