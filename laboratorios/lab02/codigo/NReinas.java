
/**
 *[N Reinas]
 * 
 * @author Santiago Soto M & Kevyn Santiago Gomez P 
 * @version 02/2018
 */
public class NReinas
{   
    private static int numS;
    
    private static boolean tableroValido(int[] tablero) {
        for(int i = 0; i < tablero.length; i++){
           for(int j = i+1; j < tablero.length; j++){
               if(tablero[i] == tablero[j])
                    return false;
               if(Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j))
                    return false;
           }
        }
        return true;
    }
    
    public static int nReinas(int n) {
        numS = 0;
        int[] tablero = new int[n];
        return nReinas(0, n, tablero);
    }
    
    private static int nReinas(int r, int n, int[] tablero) {
        if (r == n){
            if(tableroValido(tablero))
                 numS++;//imprimirTablero(tablero);
        }else{
            for(int i = 0; i < n; i++){
                tablero[r] = i;
                nReinas(r+1, n, tablero);
            }
        } 
        return numS;
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
    
     public static void TakeTime(int n){
      long startTime = System.currentTimeMillis();
      nReinas(n);
      long estimatedTime = System.currentTimeMillis() - startTime;
      System.out.println(estimatedTime);
  }//fin del método
  
  public static void main(String[] args)
  {
      int[] a;
    
      for(int i =1; i<=2; i++)
      {
        TakeTime(11);
     }//fin ciclo
  }
}

