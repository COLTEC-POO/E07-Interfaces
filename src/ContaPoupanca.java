public class ContaPoupanca extends Account {

    public ContaPoupanca(Client owner, double total, double limit, int id) {
        super(owner, total, limit, id);
    }

    @Override
    public void setLimit(double limit) {
        if (limit > 1000) {
            throw new IllegalArgumentException("Limit cannot be greater than 1000");
        }
        if (limit < 100) {
            throw new IllegalArgumentException("Limit cannot be less than 100");
        }

        this.limit = limit;
    }
}
