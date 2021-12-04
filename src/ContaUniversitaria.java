public class ContaUniversitaria extends Conta{

    public void setLimite(int limite){
        if (limite > 500) {
            throw new IllegalArgumentException("O limite não pode ser maior que 500!");
        }else{
            if (limite < 0){
                throw new IllegalArgumentException("O limite não pode ser menor que 0!");
            }
        }
    }
    public double calculaTaxas(){
        return 0;
    }
}
