import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Graph {
    protected int size;
    float[][] matrix;

    public Graph(int size) {
        matrix = new float[size][size];
        this.size = size;
    }

    public void addArc(short source, short destination, float weight) {
        matrix[source][destination] = weight;
    }

    public ArrayList<Short> getSuccessors(int vertex) {
        ArrayList<Short> s = new ArrayList<>();
        for (short i = 0; i < size; ++i)
            if (matrix[vertex][i] != 0)
                s.add(i);
        return s.size() == 0 ? null : s;
    }

    public float getWeight(int source, int destination) {
        return matrix[source][destination];
    }
}