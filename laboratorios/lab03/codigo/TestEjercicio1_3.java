
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestEjercicio3.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestEjercicio1_3
{
    /**
     * Default constructor for test class TestEjercicio3
     */
    public TestEjercicio1_3()
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
        Digraph g = new DigraphAL(12);
        g.addArc(7,8,1);
        g.addArc(7,11,1);
        g.addArc(11,2,1);
        g.addArc(11,9,1);
        g.addArc(11,10,1);
        
        Integer[] sol = {7,8,11,2,9,10};
        boolean aux = Arrays.equals(sol,Ejercicio1_3.bfs(g,7).toArray());
        assertEquals(true,aux);
    }
}
