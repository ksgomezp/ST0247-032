
package laboratorioo1;
import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author ksgomezp
 */
public class MedGrafo {
    
    public static void leerArchivo(){
   try{
            
            FileInputStream fstream = new FileInputStream("medellin_colombia-grande.txt");
            DataInputStream entrada = new DataInputStream(fstream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            while ((strLinea = buffer.readLine()) != null)   {
             Scanner sc = new Scanner(strLinea);
             
             System.out.println(strLinea);
              
            }
           
            entrada.close();
        }catch (Exception e){ 
            System.err.println("Ocurrio un error: " + e.getMessage());
        } 
    }
    
    }
    

