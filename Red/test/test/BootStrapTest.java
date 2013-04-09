/*
 * 
 * 
 */
package test;

import adg.red.BootStrap;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hsmaan
 */
public class BootStrapTest
{

    public BootStrapTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of start method, of class BootStrap.
     */
//    @Test
//    public void testStart() throws Exception
//    {
//        System.out.println("start");
//        Stage stage = null;
//        BootStrap instance = new BootStrap();
//        instance.start(stage);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getUserInterfaceUrl method, of class BootStrap.
     */
    @Test
    public void testGetUserInterfaceUrl()
    {
        System.out.println("getUserInterfaceUrl");
        String fileName = "test";
        BootStrap instance = new BootStrap();
        String expResult = "/adg/red/userInterface/test.fxml";
        String result = instance.getUserInterfaceUrl(fileName);
        assertEquals(expResult, result);

    }
    /**
     * Test of main method, of class BootStrap.
     */
//    @Test
//    public void testMain()
//    {
//        System.out.println("main");
//        String[] args = null;
//        BootStrap.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
