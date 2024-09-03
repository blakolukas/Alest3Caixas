public class Item{
    int peso;
    double valor;
    double coef;

    public Item(int peso,double valor){
        this.peso = peso;
        this.valor = valor;
        this.coef = valor/peso;
        
    }

    public double getCoef(){
        return this.coef;
    }

    public double getPeso(){
        return this.peso;
    }

    @Override
    public String toString(){
        return "Peso: "+ peso + " Valor: "+ valor;
    }
}