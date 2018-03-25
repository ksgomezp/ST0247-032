package lab4;
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
public class Test_ejercicio1
{
    /**
     * Default constructor for test class TestEjercicio3
     */
    public Test_ejercicio1()
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
                int sol = 12;
        
        boolean aux = Lab4.agenteViajero(g1)==sol;
        assertEquals(true,aux);
    }
}