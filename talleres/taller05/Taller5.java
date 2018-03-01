import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller5 {

    public static boolean mColoring(Digraph g, int m) {
        int[] colors = new int[g.size()];
        return mColoring(g,0,colors,m);
    }

    // recomendacion
    private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
        ArrayList<Integer> suc = g.getSuccessors(v);
        for(int nodo: suc){
            if(colors[nodo] == c)
                return false;
        }
        return true;
    }

    // recomendacion
    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
        if (v == g.size()){
            return true;
        }else{
            for(int i = 0; i < g.size; i++){
               for(int j = 1; j <= m; j++){
                colors[v] = j;
                if(isSafe(g,v,colors,j))
                   return mColoring(g,v+1,colors,m);
               }
            }
            return false;
        }
    }

}
