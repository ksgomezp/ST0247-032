
public class Ejercicio1_7
{
    public static void main(String[] args){
        DigraphAL g3 = new DigraphAL(4);
        g3.addArc(0, 0, 0);
        g3.addArc(0, 1, 7);
        g3.addArc(0, 2, 15);
        g3.addArc(0, 3, 6);
        g3.addArc(1, 0, 2);
        g3.addArc(1, 1, 0);
        g3.addArc(1, 2, 7);
        g3.addArc(1, 3, 3);
        g3.addArc(2, 0, 9);
        g3.addArc(2, 1, 6);
        g3.addArc(2, 2, 0);
        g3.addArc(2, 3, 12);
        g3.addArc(3, 0, 10);
        g3.addArc(3, 1, 4);
        g3.addArc(3, 2, 8);
        g3.addArc(3, 3, 0);
        Ejercicio1_6.caminoCorto(g3,0,3);
    }
}
