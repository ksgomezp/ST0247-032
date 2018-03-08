import java.util.ArrayList;

public class Taller6 {

    public static int recorrido(Digraph g) {

        boolean[] visitados = new boolean[g.size()];
        int suma = 0;
        int nodo1 = 0;
        int cont = 1;
        while (true) {
            visitados[nodo1] = true;
            ArrayList<Integer> succ = g.getSuccessors(nodo1);
            int menor = Integer.MAX_VALUE;
            int nodo2 = 0;
            for (int su : succ) {
                if (g.getWeight(nodo1, su) < menor && !visitados[su]) {
                    menor = g.getWeight(nodo1, su);
                    nodo2 = su;
                }
            }
            nodo1 = nodo2;
            cont++;
            suma += menor;
            if(cont == g.size){
                suma += g.getWeight(nodo1, 0);
                break;
            }
        }
        return suma;
    }
}

