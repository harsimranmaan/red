/*
 * 
 * 
 */
package test.userInterface;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author hsmaan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
})
public class UserInterfaceTest
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        System.out.println("Running Tests for UI");
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
        System.out.println("Tests completed for UI");
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
}
