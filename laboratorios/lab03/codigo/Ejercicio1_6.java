import java.util.ArrayList;
import java.util.Arrays;
public class Ejercicio1_6
{
 public static int caminoCorto(Digraph g, int v, int w){
        int[] distancia = new int[g.size()];
        boolean[] visitado = new boolean[g.size()];
        Arrays.fill(distancia,Integer.MAX_VALUE);
        ArrayList<Integer> successors = g.getSuccessors(v);
        if(successors != null){
            for(int nodo : successors){
                distancia[nodo] = g.getWeight(v,nodo);
            }
        }
        distancia[v] = 0;
        visitado[v] = true;
        while(true){
            int vertice = Integer.MAX_VALUE;
            boolean val = true;
            for(boolean val1 : visitado ){
                val = val && val1;
            }
            if(val) break;
            for (int i = 0; i < g.size(); i++) {
                if (distancia[i] < vertice && !visitado[i])
                    vertice = i;
            }
            visitado[vertice] = true;
            ArrayList<Integer> successors2 = g.getSuccessors(vertice);
            if(successors2 != null){
                for(int nodo : successors2){
                    if(distancia[nodo]>distancia[vertice]+g.getWeight(vertice,nodo)){
                        distancia[nodo] = distancia[vertice]+g.getWeight(vertice,nodo);
                    }
                }
            }
        }
        return distancia[w];
    }  
}
