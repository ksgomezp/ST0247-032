
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestEjercicio1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestEjercicio1_1
{
    /**
     * Default constructor for test class TestEjercicio1
     */
    public TestEjercicio1_1()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void From0()
    {
        ArrayList<ArrayList<int[]>> soluciones = new  ArrayList<>();
            ArrayList<int[]> sol = new ArrayList<>();
                sol.add(null);
                soluciones.add(sol);
            ArrayList<int[]> sol1 = new ArrayList<>();
                int[] r10 = {0};sol1.add(r10);
                soluciones.add(sol1);
            ArrayList<int[]> sol2 = new ArrayList<>();
                sol2.add(null);
                soluciones.add(sol2);
            ArrayList<int[]> sol3 = new ArrayList<>();
                sol3.add(null);
                soluciones.add(sol3);
            ArrayList<int[]> sol4 = new ArrayList<>();
                int[] r40 = {1,3,0,2};sol4.add(r40);
                int[] r41 = {2,0,3,1};sol4.add(r41);
                soluciones.add(sol4);
        int i = 0;
        for(ArrayList<int[]> lista : soluciones){
            boolean aux = false;
            for(int[] res :lista)
                 aux = aux || Arrays.equals(res,Ejercicio1_1.nReinas(i));   
            i++;
            assertEquals(true,aux);
        }
    }
}
