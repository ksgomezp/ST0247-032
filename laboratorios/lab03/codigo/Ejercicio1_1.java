
public class Ejercicio1_1
{
    public static int[] nReinas(int n) {
        int[] tablero = new int[n];
        if(!nReinas(0, n, tablero)){
           //System.out.println("No tiene solucion");
           return null;
        }
        //mprimirTablero(tablero);
        return tablero;
    }
    
    private static boolean puedoPonerReina(int r, int[] tablero) {
        for(int i = 0; i < r; i++){
           if(tablero[i] == tablero[r])
                return false;
           if(Math.abs(tablero[i] - tablero[r]) == Math.abs(i - r))
                return false;
        }
        return true;
    }
    
    private static boolean nReinas(int r, int n, int[] tablero) {
        if (r == n && r != 0){
            
            return true;
        }else{
            for(int i = 0; i < n; i++){
                tablero[r] = i;
                if(puedoPonerReina(r, tablero)){
                    if(nReinas(r+1, n, tablero))
                        return true;
                }
            }
        }
        return false;
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
                System.out.print((tablero[j] == i ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public static void TakeTime(int j){
      long startTime = System.currentTimeMillis();
      nReinas(j);
      long estimatedTime = System.currentTimeMillis() - startTime;
      System.out.println(estimatedTime);
   }
   
   public static void main(String[] args)
   {  
     for(int j = 5; j <=50; j++ ){
         System.out.println("["+j+"]");
          System.out.println();
       for(int i =1; i<=10; i++)
       {
        TakeTime(j);
     }
    }
}
}
