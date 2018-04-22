public class Node {

    private short ID;
    private String name;
    private float xCoordinate;
    private float yCoordinate;
    private char nodeType;
    private byte stationType;

    public Node(short ID, String name, float xCoordinate, float yCoordinate, char nodeType, byte stationType) {
        this.ID = ID;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.nodeType = nodeType;
        this.stationType = stationType;
    }

    public Node(String[] data){
        ID = Short.parseShort(data[0]);
        name = data[1];
        xCoordinate = Float.parseFloat(data[2]);
        yCoordinate = Float.parseFloat(data[3]);
        nodeType = data[4].charAt(0);
        stationType = Byte.parseByte(data[5]);
    }

    public short getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public float getxCoordinate() {
        return xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public char getNodeType() {
        return nodeType;
    }

    public byte getStationType() {
        return stationType;
    }

    @Override
    public String toString() {
        return "ID: " + ID + " - Name: " + name;
    }
}