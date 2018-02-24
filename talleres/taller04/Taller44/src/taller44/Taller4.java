package Taller44;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 *
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {

    /* public static int recorrido(Digraph g) {

    }

    // recomendacion
    private static int recorrido(Digraph g, int v, int[] unvisited) {

    }

    // recomendacion
    private static int[] removeAt(int k, int a[]) {

    }
**/
    public static ArrayList<Integer> dfs(Digraph g, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visitados = new boolean[g.size];
        dfs(g, start, visitados, list);
        if (list.size() <= 1) {
            return null;
        }
        return list;

    }

    private static void dfs(Digraph g, int nodo, boolean[] visitados, ArrayList<Integer> list) {
        visitados[nodo] = true;
        list.add(nodo);
        ArrayList<Integer> hijos = g.getSuccessors(nodo);
        if (hijos == null) {
            return;
        }
        for (Integer vecino : hijos) {
            if (!visitados[vecino]) {
                dfs(g, vecino, visitados, list);
            }
        }

    }

    public static ArrayList<Integer> bfs(Digraph g, int start) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visitados = new boolean[g.size];
        dfs(g, start, visitados, list);
        if (list.size() <= 1) {
            return null;
        }
        return list;

    }

    private static void bfs(Digraph g, int nodo, boolean[] visitados, ArrayList<Integer> list) {
        Queue<Integer> queue = new LinkedList();
        queue.add(nodo);
        visitados[nodo] = true;
        list.add(nodo);

        while (!queue.isEmpty()) {
            ArrayList<Integer> vecinos  =  g.getSuccessors(queue.remove());
            for (Integer vecino : vecinos) {
                if(!visitados[vecino]){
                list.add(vecino);
                visitados[vecino]= true;
                queue.add(vecino);
                    
                }
            }
        }

    }

    public static boolean hayCaminoDFS(Digraph g, int v, int w) {
        boolean[] visitados = new boolean[g.size()];
        return hayCaminoDFS(g, v, w, visitados);
    }

    private static boolean hayCaminoDFS(Digraph g, int v, int w, boolean[] visitados) {
        if (v == w) {
            return true;
        }
        boolean aux = false;
        visitados[v] = true;
        ArrayList<Integer> successors = g.getSuccessors(v);
        if (successors != null) {
            for (int nodo : successors) {
                if (!visitados[nodo]) {
                    aux = hayCaminoDFS(g, nodo, w, visitados);
                }
            }
        }
        return aux;
    }

    public static boolean hayCaminoBFS(Digraph g, int v, int w) {
        boolean[] visitados = new boolean[g.size()];
        return hayCaminoBFS(g, v, w, visitados);
    }

    private static boolean hayCaminoBFS(Digraph g, int v, int w, boolean[] visitados) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            v = queue.remove();
            if (v == w) {
                return true;
            }
            if (visitados[v] == false) {
                visitados[v] = true;
                ArrayList<Integer> successors = g.getSuccessors(v);
                if (successors != null) {
                    queue.addAll(successors);
                }
            }
        }
        return false;
    }

    public static int costoMinimo(Digraph g, int inicio, int fin) {
        ArrayList<Integer> costo = new ArrayList<>();
        dfs(g, inicio, fin, 0);
    }

    // recomendacion
    private static int dfs(Digraph g, int v, int w, int costo) {
        if (v == w) {
            return costo;
        }
        int[] visitados = new int[g.size()];
        boolean aux = false;
        visitados[v] = true;
        ArrayList<Integer> successors = g.getSuccessors(v);
        if (successors != null) {
            for (int nodo : successors) {
                if (!visitados[nodo]) {
                    aux = hayCaminoDFS(g, nodo, w, visitados);
                }
            }
        }
        return aux;

    }

}
