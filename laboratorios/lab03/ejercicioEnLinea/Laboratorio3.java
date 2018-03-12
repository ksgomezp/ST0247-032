package laboratorio3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ksgomezp
 */
public class Laboratorio3 {



    public static ArrayList<Integer> costoMinimo(Digraph g, int inicio, int fin) {
        int[] costo = new int[g.size];
        for (int i = 0; i < g.size; i++) {
            costo[i] = Integer.MAX_VALUE;
        }
        ArrayList<Integer> recorrido = new ArrayList();
        recorrido.add(inicio);
        costo[inicio]=0;
        
        dfs(g, inicio, costo,recorrido,0);
       // if(costo[fin]==Integer.MAX_VALUE) return -1;
        return recorrido;
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo,ArrayList<Integer> recorrido,int acum) {

        ArrayList<Integer> hijos = g.getSuccessors(v);
        if (hijos == null) {
            return;
        }

        for (Integer vecino : hijos) {
            if (costo[vecino] > acum) {
                costo[vecino] = g.getWeight(v, vecino) + acum;
                acum += g.getWeight(v, vecino);
                recorrido.add(vecino);
             dfs(g, vecino, costo,recorrido,acum);
             acum-=g.getWeight(v, vecino);
             
             
                
            }

        }

    }
    
 static String[] cred;
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int m = sc.nextInt();
     Digraph g = new DigraphAL(n+1);
     
        for (int i = 0; i < m; i++) {
           int a= sc.nextInt();
           int b = sc.nextInt();
           int c = sc.nextInt();
               g.addArc(a,b,c);      
        }
      
        System.out.println(costoMinimo(g, 1, n));
    }

}