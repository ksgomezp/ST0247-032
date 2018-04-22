public class Pair implements Comparable<Pair>{

    private float key;
    private short value;

    public Pair(float key, short value) {
        this.key = key;
        this.value = value;
    }

    public float getKey() {
        return key;
    }

    public short getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair o) {
        return Float.compare(key,o.getKey());
    }

    @Override
    public String toString() {
        return "" + key + " - " + value;
    }
}