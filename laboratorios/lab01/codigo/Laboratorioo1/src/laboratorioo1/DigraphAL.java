package laboratorioo1;
import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
    
    ArrayList<ArrayList<Pair>> array1;

    public DigraphAL(int size) {
        super(size);
        array1 = new ArrayList<>(size+1);
        for(int i=0;i<=size;i++){
            array1.add(new ArrayList<Pair>(0));
        }
    }

    public void addArc(int source, int destination, int weight) {
        
        Pair pair = new Pair(destination,weight);
        array1.get(source).add(pair);

    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Pair> pair = array1.get(vertex);
        for (Pair pair1 : pair) {
            result.add(pair1.a);
            
        }
        return result;
    }
    

    public int getWeight(int source, int destination) {
       
       ArrayList<Pair> array2 = array1.get(source);
       for(Pair i: array2 ){
        if(i.a==destination)
            return i.b;
       }
       return 0;
    }

}
