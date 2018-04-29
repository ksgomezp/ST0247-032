
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    //Punto 1.1
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
    
    //Punto 1.3
    public static int lcs(String x, String y) {
        int[][] table = new int[x.length()+1][y.length()+1];
        
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i-1) == y.charAt(j-1))
                    table[i][j] = 1+table[i-1][j-1];
                else
                    table[i][j] = Math.max(table[i][j-1],table[i-1][j]); 
             }
        }
        return table[x.length()][y.length()];
    }
    
}
