import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio2_1
{
    private static LinkedList<Integer> graph[];

    private static void makeGraph (int v)
    {
        graph = new LinkedList[v];
        for (int i = 0; i < v; i++)
            graph[i] = new LinkedList();
    }

    private static void addEdge(int a, int b)
    {
        graph[a].add(b);
        graph[a].add(b);
    }

    private static void coloring(int v)
    {
        byte[] colors = new byte[v];
        Arrays.fill(colors, (byte)-1);
        colors[0] = 0;

        for (int i = 0; i < v; i++)
        {
            byte colorSuccersors = 1;
            for ( int j : graph[i] )
            {
                if (colors[j] == -1) {
                    colors[j] = colorSuccersors;
                }else if (colors[j] != colorSuccersors )
                {
                    System.out.println("NOT BICOLORABLE.");
                    return;
                }
            }
            colorSuccersors = colorSuccersors==1?(byte)0:1;
        }
        System.out.println("BICOLORABLE.");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int v = sc.nextInt();
            if (v == 0)
                break;
            int e = sc.nextInt();
            makeGraph(v);
            for (int i = 0; i < e; i++)
                addEdge(sc.nextInt(), sc.nextInt());
            coloring(v);
        }
    }


}
