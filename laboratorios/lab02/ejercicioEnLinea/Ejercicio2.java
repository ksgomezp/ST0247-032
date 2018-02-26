/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio2;

import java.util.Scanner;

/**
 *
 * @author ksgomezp
 */
public class Ejercicio2 {

    private static int numS;

    static String[] cred;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int caso = 1;
        n = sc.nextInt();
        while (n != 0) {
            cred = new String[n];
            for (int i = 0; i < n; i++) {
                cred[i] = sc.next();
            }
            System.out.println("Case " + caso + ": " + nReinas(n));
            n = sc.nextInt();
            caso++;
            numS = 0;
        }
      
    }

    private static boolean puedoPonerReina(int r, int[] tablero) {
        for (int i = 0; i < r; i++) {
            if (tablero[i] == tablero[r]) {
                return false;
            }
            if (Math.abs(tablero[i] - tablero[r]) == Math.abs(i - r)) {
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
        if (r == n) {
            //imprimirTablero(tablero);
            numS++;
        } else {
            for (int i = 0; i < n; i++) {
                if (cred[r].charAt(i) == '.') {
                    tablero[r] = i;
                    if (puedoPonerReina(r, tablero)) {
                        nReinas(r + 1, n, tablero);
                    }
                }
            }
        }
        return numS;
    }

}
