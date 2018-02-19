package laboratorioo1;
import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo,kevyn Gomez
 */
public class DigraphAM extends Digraph {
	
    int [][] m;
    
   /**
    * constructor
    * @param size es el numero de vertices que tiene el grafo
    */
	public DigraphAM(int size) {
		super(size);
		m= new int [size][size];
	}
  /**
   *  Agrega un arco entre dos nodos
   * @param source : es el nodo de partida
   * @param destination : es el nodo de llegada
   * @param weight : es el peso del arco
   */
	public void addArc(int source, int destination, int weight) {
		m[source][destination]=weight;
	}
/**
 * Obtiene los sucesores de un vertice especifico
 * @param vertex : es el vertice de salida
 * @return : retorna una lista de arreglos de enteros los cuales son los nodos sucesores
 */
	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		for(int i=0;i<size;i++){
		  if(m[vertex][i]!=0){
		   s.add(i);
		  }
		  }
		  if(s.size()>0){
		  return s;
		  }
		  return null;
	}
/**
 *  Obtiene el peso del arco entre dos nodos
 * @param source nodo de salida
 * @param destination nodo de llegada
 * @return el peso del arco como entero
 */
	public int getWeight(int source, int destination) {
		return m[source][destination];
	}
      /**
       *  Calcula el vertice con mas sucesores en un grafo
       * @param dg : es el grafo que se analiza para saber cual vertice tiene mas sucesores
       * @return 
       */  
         public static int masSucesoresAm(DigraphAM dg) {
        ArrayList<Integer> w = new ArrayList<Integer>();
        for (int i = 0; i <= dg.size; i++) {
            
            for (int j = 0; i <= dg.size; i++) {
                int aux = 0;
                if (dg.m[i][j] != 0) {
                    aux += 1;
                }
                w.add(aux);
            }
        }
        int cont = 0;
        for (int i = 0; i <= w.size() - 1; i++) {
            if (w.get(i) > w.get(i + 1)) {
                cont = i;
            }

        }
        return cont;
    }

}