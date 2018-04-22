import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Pair;

public class Main {

    public static ArrayList<Node> nodes;
    public static Graph map;
    public static Data data;

    public static void read() throws IOException {
        String cadena;
        BufferedReader b = new BufferedReader(new FileReader("DataSets/tc2c320s24cf1.txt"));

        String[] dat = new String[10];
        for (int i = 0; i < dat.length; i++)
                dat[i] = b.readLine();
        data = new Data(dat);
        b.readLine(); b.readLine(); b.readLine();

        nodes = new ArrayList<>(data.getN());

        for (int i = 0; i < data.getN(); i++)
            nodes.add(new Node((b.readLine()).split(" ")));
        b.readLine(); b.readLine(); b.readLine();

        String[] l = new String[3];
        String[] g = new String[3];
        for (int i = 0; i < 3; i++)
            l[i] = b.readLine();
        b.readLine(); b.readLine(); b.readLine();

        for (int i = 0; i < 3; i++)
            g[i] = b.readLine();
        data.addLG(l,g);
        b.close();
    }

    private static void makeGraph(){
        map = new Graph(data.getN());
        for ( Node node : nodes ) {
            for ( Node node2 : nodes ) {
                map.addArc(node.getID(),node2.getID(), (float) Math.sqrt(
                            Math.pow(node.getxCoordinate() - node2.getxCoordinate(),2) +
                            Math.pow(node.getyCoordinate() - node2.getyCoordinate(),2)
                            )
                );
            }
        }
    }

    public static void main(String[] args){
        try {
            read();
            makeGraph();
            ShortestPath.tsp(map);
        } catch (IOException e) {
            System.err.println("IOException");
        }

    }

}
