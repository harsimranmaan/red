/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
    test.controllers.ControllersTest.class,
    test.models.ModelsTest.class, test.userInterface.UserInterfaceTest.class,
    BootStrapTest.class
})
public class RedTestSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        System.out.println("Running Tests for Adg-Red");
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
        System.out.println("Tests completed for Adg-Red");
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
