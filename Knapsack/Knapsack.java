import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Knapsack{
    public static void main(String[] args)
    {
        List<Item> lista1 = Arrays.asList(
            new Item(5, 15),
            new Item(5, 1),
            new Item(2, 4),
            new Item(8, 1)
        );

        System.out.println(mochila(lista1,12));
    }

    public static List<Item> mochila(List<Item> lista, int capacidade){
        List<Item> thebest= new ArrayList<>();
        List<List<Item>> best= new ArrayList<>();
        Stack<Item> mochila = new Stack<>();

        for(int i = 0; i< lista.size(); i++){
            mochila.clear();
            int peso = lista.get(i).peso;
            mochila.add(lista.get(i));

            for(int j = 0; j < lista.size(); j++){
                if(i!=j){
                    if(lista.get(j).peso + peso <= capacidade){
                        mochila.add(lista.get(j));
                        peso += lista.get(j).peso;
                    }else{
                        System.out.println(mochila + "\n");
                        best.add(mochila);
                        peso-= mochila.peek().peso;
                        mochila.pop();
                        if(j<lista.size()-1){
                            j--;
                        }
                    }
                }
            }
        }

        double coef= 0;
        for(int i= 0; i< best.size(); i++){
            if(getCoef(best.get(i))> coef){
                coef= getCoef(best.get(i));
                thebest= best.get(i);
            }
        }

        return thebest;

    }

    public static double getCoef(List<Item> lista){
        double coef= 0;
        for(Item a : lista){
            coef+= a.coef;
        }
        return coef;
    }

}