
/**
 * Write a description of class Taller10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller10

{
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
