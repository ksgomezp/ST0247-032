import java.util.Arrays;

public class Taller12 {
    public static void nReinas (int n) {
        int tabla[] = new int[n];
        int tablaBest[] = new int[n];
        int heu = heuristico (tabla);
        while (true) {
            for (int i = 1; i < tabla.length; i++) {
                for (int j = 0; j < tabla.length; j++ ){
                    int tablaTemp[] = Arrays.copyOf(tabla, tabla.length);
                    tablaTemp[j] += i;
                    int heu2 = heuristico (tablaTemp);
                    if(heu > heu2) {
                        tablaBest = Arrays.copyOf(tablaTemp, tablaTemp.length);
                        heu = heu2;
                    }      
                }
            }
            tabla = Arrays.copyOf(tablaBest, tablaBest.length);
            if (heu == 0)
                break;
        }
        System.out.println(Arrays.toString(tabla));
    }
    
    private static int heuristico(int tabla[]) {
        int cont = 0;
        for (int i = 0; i < tabla.length; i++) {
            for (int j = i+1; j < tabla.length; j++ ) {
              if(tabla[i]==tabla[j])
                cont++;
              if(Math.abs(tabla[i] - tabla[j]) == Math.abs(i - j))
                cont++;
            }
       }
       return cont;
    }
}
