

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestReinas.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestReinas
{
    /**
     * Default constructor for test class TestReinas
     */
    public TestReinas()
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
        int[] soluciones = { -1, 1, 0, 0, 2, 10, 4, 40, 92, 352};
        for (int i = 1; i <= 8; ++i)
        {
            assertEquals(soluciones[i],NReinas.nReinas(i));
        }
    }
}
