import java.util.*;

/**
 * Write a description of class Punto2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2
{
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int numC = sc.nextInt();
        for (int i = 0; i < numC; i++) {
            int numM = sc.nextInt()*sc.nextInt();
            //double mapa[][] = new double[sc.nextInt()][sc.nextInt()];
            /*for (int j = 0; j < mapa.length; j++) 
                Arrays.fill(mapa[i],Double.MAX_VALUE);*/
            ArrayList<Pair> puntos = new ArrayList<Pair>(numM);
            puntos.add(Pair.makePair(sc.nextInt(),sc.nextInt()));
            int numP = sc.nextInt();
            for (int j = 0; j < numP; j++) 
                puntos.add(Pair.makePair(sc.nextInt(),sc.nextInt()));
            Digraph g = new DigraphAL(puntos.size());
            for (int p1 = 0; p1 < puntos.size(); p1++) {
                for (int p2 = 0; p2 < puntos.size(); p2++) {
                    if(p1 != p2) {
                        g.addArc(p1,p2,(Math.abs((int)puntos.get(p1).first - (int)puntos.get(p2).first)) + Math.abs((int)puntos.get(p1).second - (int)puntos.get(p2).second));
                    }
                }
            }
           System.out.println("The shortest path has length " + Punto1_2.heldKarp(g));
        }
    }
}
