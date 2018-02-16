import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller3 {
    
    private static int numS;
    
    private static boolean puedoPonerReina(int r, int[] tablero) {
        for(int i = 0; i < r; i++){
           if(tablero[i] == tablero[r])
                return false;
           if(Math.abs(tablero[i] - tablero[r]) == Math.abs(i - r))
                return false;
        }
        return true;
    }
    
    public static int nReinas(int n) {
        numS = 0;
        int[] tablero = new int[n];
        return nReinas(0, n, tablero);
    }
    
    private static int nReinas(int r, int n, int[] tablero) {
        if (r == n){
            //imprimirTablero(tablero);
            numS++;
        }else{
            for(int i = 0; i < n; i++){
                tablero[r] = i;
                if(puedoPonerReina(r, tablero))
                    nReinas(r+1, n, tablero);
            }
        }
        return numS;
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
    
   public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
        boolean[] visitados = new boolean[g.size()];
        ArrayList<Integer> list = new ArrayList<>();
        if (dfs(g,inicio,fin,visitados,list))
            return list;
        return new ArrayList<Integer>();
    }

    // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        if(nodo == objetivo){
         list.add(nodo);   
         return true;
        }else{
            ArrayList<Integer> successors = g.getSuccessors(nodo);
            visitados[nodo] = true;
            if(successors != null){
                for(int successor: successors){
                    if(!visitados[successor]){
                       list.add(nodo);
                       return dfs(g,successor,objetivo,visitados,list); 
                    } 
                 }
                list.remove(list.size());
            }
        }

        return false;
     }
}


