package laboratorio3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author ksgomezp
 */
public class Laboratorio3 {

    public static LinkedList<Integer> costoMinimo(Digraph g, int inicio, int fin) {
        int[] costo = new int[g.size];
        for (int i = 0; i < g.size; i++) {
            costo[i] = Integer.MAX_VALUE;
        }
        LinkedList<Integer> recorrido = new LinkedList();
        recorrido.add(inicio);
        costo[inicio] = 0;

        dfs(g, inicio, fin, costo, recorrido, 0);

        return pop;
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int fin, int[] costo, LinkedList<Integer> recorrido, int acum) {

        ArrayList<Integer> hijos = g.getSuccessors(v);
        
        
        if (v == fin) {
           
            if (acum<peso) {
                peso = acum;
                pop = (LinkedList)recorrido.clone();
                return;
            }

        }
        if (hijos == null) {
            return;
        }
        for (Integer vecino : hijos) {
            
            if (costo[vecino] > acum) {
                costo[vecino] = g.getWeight(v, vecino) + acum;
                acum += g.getWeight(v, vecino);
                recorrido.add(vecino);
                
                dfs(g, vecino, fin, costo, recorrido, acum);
                acum -= g.getWeight(v, vecino);
                recorrido.removeLast();

            }

        }

    }
    static int peso = Integer.MAX_VALUE;
    static LinkedList<Integer> pop = new LinkedList();
    static String[] cred;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Digraph g = new DigraphAL(n + 1);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            g.addArc(a, b, c);
        }

        System.out.println(costoMinimo(g, 1, n));

    }

}
