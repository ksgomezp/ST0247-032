/**
 * Clase en la cual se implementan los metodos del Taller de Clase #9
 * 
 */
public class Taller9 {

    public static int levenshtein(String a, String b) {
        int[][] distance = new int[a.length() + 1][b.length()+1];
        for (int i = 0; i <= a.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= b.length(); j++)
            distance[0][j] = j;
            
        for (int i = 1; i <= a.length(); i++)
            for (int j = 1; j <= b.length(); j++)
                distance[i][j] = Math.min(distance[i - 1][j] + 1,Math.min(
                distance[i][j - 1] + 1,distance[i - 1][j - 1] +
                ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1)));
                
        return distance[a.length()][b.length()];
    }
    
}