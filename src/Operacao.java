import java.util.Date;
public abstract class Operacao implements ITaxas{
    /* Data de realização da operação */
    public Date data;

    /* Tipo da operação */
    public char tipo;

    /* Valor da operação */
    public double valor;

    public Date getdata(){
            return this.data;
    }
    public char gettipo(){
        return this.tipo;
    }
    public double getvalor(){
        return this.valor;
    }
    
    public void setdata(){
        this.data = new Date();
    }
    public void settipo(char tipo){
        if(tipo=='d' || tipo=='s'){
            this.tipo= tipo;
        }
    }
    public void setvalor(double valor){
        this.valor = valor;
    }



    /**
     * @param tipo Tipo da operação, podendo ser 'd' ou 's'
     * @param valor Valor da operação
     */
    public Operacao(char tipo, double valor) {
        settipo(tipo);
        setvalor(valor);
        setdata();
    }
    public Operacao(){
        
    }

    public String toString() {
        String dadosOperacao = "Data da Operação: " + this.data + "\n" +
                            "Tipo de Operação: " + this.tipo + "\n" +
                            "Valor: " + this.valor;
                             
            return dadosOperacao;
    }

        public abstract double calculaTaxa();
    //Metodo para imprimir extrato
    public void ExtratoTaxas() {
        double tx;

        tx = this.calculaTaxa();
        System.out.println("TIPO DA OPERAÇÃO: " + this.tipo);
        System.out.println("DATA: " + this.data);
        System.out.println("VALOR: " + this.valor);
        System.out.println("TAXA: " + tx);
    }
    
}