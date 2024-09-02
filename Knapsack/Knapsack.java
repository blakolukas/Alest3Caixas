import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack{
    public static void main(String[] args)
    {
        List<Item> lista1 = Arrays.asList(
            new Item(10, 4),
            new Item(5, 3),
            new Item(2, 7)
        );

        System.out.println(mochila(lista1,12));
    }

    public static List<List<Item>> mochila(List<Item> lista, int capacidade){
        List<List<Item>> listaMochilas = new ArrayList<>();
        for(int i = 0; i< lista.size(); i++){
            int peso = 0;
            List<Item> mochila = new ArrayList<>();
            for(int j = 0; j < lista.size(); j++){
                if(lista.get(j).peso + peso <= capacidade ){
                    mochila.add(lista.get(j));
                    peso += lista.get(j).peso;
                } 
            }
            listaMochilas.add(mochila); 
        }
        return listaMochilas;

    }

}