import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {

     public static ArrayList<String> combinations(String s) {
        ArrayList<String> list = new ArrayList<String>();
        String v = "";
        combinations(v,s,list);
        return list;
     }

    // recomendacion
    private static void combinations(String pre, String pos, ArrayList<String> list) {
        if(pos.length()==0)  
           list.add(pre);
        else {
           combinations(pre+pos.charAt(0),pos.substring(1),list); 
        combinations(pre,pos.substring(1),list);
       }
        
    }
    
    public static ArrayList<String> permutations(String s) {
        
        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i<s.length(); i++){
           permutations(s.charAt(i)+"", s.substring(0,i) + s.substring(i+1),list);
        }
        return list;
        
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        
        if(pos.length()==0){
            list.add(pre);
            return;
        }
        for(int i =0; i<pos.length(); i++){
            permutations(pre+pos.charAt(i), pos.substring(0,i) + pos.substring(i+1),list);
        }
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

    public static boolean esValido(int[] tablero) {
       for(int i=0; i<tablero.length;i++){
          for(int j=i+1;j<tablero.length;j++){
          if(tablero[i]==tablero[j]){
           return false;
          }
          if (j==0 ) j--;
          if(Math.abs(tablero[i]-tablero[j])==j){
           return false;
          }
          if (j!=0 ) j--;
          }
          }
          return true;
    }

    public static int queens(int n) {
        
        int esValido = 0;
        String cadena ="";
        for(int i=0; i < n ; i++){
            cadena += i;
        }
        
       ArrayList<String> array = permutations(cadena);
       
       for (String item : array) {
           int [] tablero = new int[n];

 
           for (int i = 0; i < item.length(); i++) {
               tablero[i] = Integer.parseInt(item.substring(i,i+1));
           }
           
            if(esValido(tablero)){
                esValido++;
                //imprimirTablero(tablero);
            }
        }

       return esValido;
        
    }

}