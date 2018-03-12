import java.util.ArrayList;

/**
 * Write a description of class Ejercicio1_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio1_5
{
    public static boolean hayCiclo(Digraph g) {
        for(int i = 0; i < g.size(); i++){
            boolean[] visitados = new boolean[g.size];
            if(hayCiclo(g, i, visitados))
                return true;
        }
        return false;
    }

    private static boolean hayCiclo(Digraph g, int nodo, boolean[] visitados) {
        visitados[nodo] = true;
        ArrayList<Integer> hijos = g.getSuccessors(nodo);
        if (hijos == null) {
            return false;
        }
        for (Integer vecino : hijos) {
            if (visitados[vecino]) 
                return true;
            else
               return hayCiclo(g, vecino, visitados);
        }
        return false;
    }
}
