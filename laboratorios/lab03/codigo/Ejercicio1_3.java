import java.util.*;


public class Ejercicio1_3
{
    public static ArrayList<Integer> bfs(Digraph g, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        bfs(g, start,list);
        if (list.size() == 0) {
            return null;
        }
        return list;

    }

    private static void bfs(Digraph g, int nodo, ArrayList<Integer> list) {
        boolean[] visitados = new boolean[g.size];
        Queue<Integer> queue = new LinkedList();
        queue.add(nodo);
        visitados[nodo] = true;
        list.add(nodo);
        while (!queue.isEmpty()) {
            ArrayList<Integer> vecinos  =  g.getSuccessors(queue.remove());
            if(vecinos != null){ 
                for (Integer vecino : vecinos) {
                    if(!visitados[vecino]){
                        list.add(vecino);
                        visitados[vecino]= true;
                        queue.add(vecino);
                    }
                }
            }
        }
    }
}
