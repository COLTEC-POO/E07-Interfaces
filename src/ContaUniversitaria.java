public class ContaUniversitaria extends Account {

    public ContaUniversitaria(Client owner, double total, double limit, int id) {
        super(owner, total, limit, id);
    }

    @Override
    public void setLimit(double limit) {
        if (limit > 500) {
            throw new IllegalArgumentException("Limit cannot be greater than 1000");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be less than 100");
        }

        this.limit = limit;
    }

}
