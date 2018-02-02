import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
	
    int [][] m;
	public DigraphAM(int size) {
		super(size);
		m= new int [size][size];
	}

	public void addArc(int source, int destination, int weight) {
		m[source][destination]=weight;
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		for(int i=0;i<=size;i++){
		  if(m[vertex][i]!=0){
		   s.add(i);
		  }
		  }
		  if(s.size()>0){
		  return s;
		  }
		  return null;
	}

	public int getWeight(int source, int destination) {
		return m[source][destination];
	}

}