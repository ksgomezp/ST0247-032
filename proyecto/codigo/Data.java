public class Data {

    private short n;
    private short m;
    private short u;
    private short breaks;
    private float r;
    private float speed;
    private float Tmax;
    private float Smax;
    private float stCustomer;
    private float Q;
    private float[][] l;
    private float[][] g;

    public Data(String[] data) throws NumberFormatException {
        n = Short.parseShort(data[0].substring(data[0].indexOf('=')+2));
        m = Short.parseShort(data[1].substring(data[1].indexOf('=')+2));
        u = Short.parseShort(data[2].substring(data[2].indexOf('=')+2));
        breaks = Short.parseShort(data[3].substring(data[3].indexOf('=')+2));
        r = Float.parseFloat(data[4].substring(data[4].indexOf('=')+2));
        speed = Float.parseFloat(data[5].substring(data[5].indexOf('=')+2));
        Tmax = Float.parseFloat(data[6].substring(data[6].indexOf('=')+2));
        Smax = Float.parseFloat(data[7].substring(data[7].indexOf('=')+2));
        stCustomer = Float.parseFloat(data[8].substring(data[8].indexOf('=')+2));
        Q = Float.parseFloat(data[9].substring(data[9].indexOf('=')+2));
    }

    public void addLG(String[] l, String[] g){
        for (int i = 0; i < 3; i++){
            String[] temL = l[i].split(" ");
            String[] temG = g[i].split(" ");
            this.l = new float[3][breaks];
            this.g = new float[3][breaks];
            for(int j = 0; j < breaks;j++){
                this.l[i][j] =  Float.parseFloat(temL[j]);
                this.g[i][j] =  Float.parseFloat(temG[j]);
            }
        }
    }

    public short getN() {
        return n;
    }

    public short getM() {
        return m;
    }

    public short getU() {
        return u;
    }

    public short getBreaks() {
        return breaks;
    }

    public float getR() {
        return r;
    }

    public float getSpeed() {
        return speed;
    }

    public float getTmax() {
        return Tmax;
    }

    public float getSmax() {
        return Smax;
    }

    public float getStCustomer() {
        return stCustomer;
    }

    public float getQ() {
        return Q;
    }

    public float[][] getL() {
        return l;
    }

    public float[][] getG() {
        return g;
    }

}