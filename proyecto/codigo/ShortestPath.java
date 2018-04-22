import java.util.PriorityQueue;
import javafx.util.Pair;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPath {

    public static void tsp(Graph graph) {
        boolean[] cVisited = new boolean[Main.data.getM()+1];
        cVisited[0] = true;
        short element = 0, dst = 0;
        boolean minFlag = false;
        float timeT = 0f;
        float timeP = 0f;
        short noRutas = 1;
        System.out.print("Ruta "+noRutas+": 0");
            while (true) {
                float min = Float.MAX_VALUE;
                for (short i = 1; i < Main.data.getM()+1; i++){
                    if (graph.getWeight(element, i) > 0 && !cVisited[i]) {
                        if (min > graph.getWeight(element, i)) {
                            min = graph.getWeight(element, i);
                            dst = i;
                            minFlag = true;
                        }
                    }
                }
                if (minFlag) {
                    if(timeP+(graph.getWeight(dst, (short)0)) / Main.data.getSpeed() > Main.data.getTmax()) {
                        element = 0;
                        timeP += graph.getWeight(dst,0)/Main.data.getSpeed();
                        timeT += timeP;
                        timeP = 0;
                        System.out.print(" (" + ((graph.getWeight(dst,0)/Main.data.getSpeed())/60)+" min) 0");
                        noRutas++;
                        System.out.println("Ruta "+noRutas+":");
                        continue;
                    }
                    cVisited[dst] = true;
                    element = dst;
                    timeP += min/Main
                    System.out.print(" (" + ((min/Main.data.getSpeed())/60)+" min) " +dst);
                    minFlag = false;
                    continue;
                }
                break;
            }
        timeT += graph.getWeight(dst,0)/Main.data.getSpeed();
        System.out.print(" (" + ((min/Main.data.getSpeed())/60)+" min) " +dst);
    }

}