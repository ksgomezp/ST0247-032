/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author ksgomezp
 */
public class Lab4 {

    public static void agenteViajero(Digraph g) {
        int costo = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int numberOfNodes = g.size;
        boolean[] visited = new boolean[numberOfNodes];
        visited[0] = true;
        stack.push(0);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(0 + "\t");
        while (!stack.isEmpty()) {
            element = stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes) {
                if (g.getWeight(element, i) > 0
                        && visited[i] == false) {
                    if (min > g.getWeight(element, i)) {
                        min = g.getWeight(element, i);
                        
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) {
                visited[dst] = true;
                stack.push(dst);
                System.out.print(dst + "\t");
                costo+=g.getWeight(element,dst );
                
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        costo+=g.getWeight(dst, 0);
        System.out.println("0");
        System.out.println("costo:"+costo);
    }


public static void main(String[] args) {
 DigraphAL g1 = new DigraphAL(5);
		g1.addArc(0, 1, 2);
		g1.addArc(0, 2, 2);
		g1.addArc(0, 3, 1);
		g1.addArc(0, 4, 4);
		g1.addArc(1, 0, 2);
		g1.addArc(1, 2, 3);
		g1.addArc(1, 3, 2);
		g1.addArc(1, 4, 3);
		g1.addArc(2, 0, 2);
		g1.addArc(2, 1, 3);
		g1.addArc(2, 3, 2);
		g1.addArc(2, 4, 2);
		g1.addArc(3, 0, 1);
		g1.addArc(3, 1, 2);
		g1.addArc(3, 2, 2);
		g1.addArc(3, 4, 4);
		g1.addArc(4, 0, 4);
		g1.addArc(4, 1, 3);
		g1.addArc(4, 2, 2);
		g1.addArc(4, 3, 4);
                
                System.out.println("Respuesta esperada = 12, respuesta obtenida=");
                agenteViajero(g1);
    }
    
}
