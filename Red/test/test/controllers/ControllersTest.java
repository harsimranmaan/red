/*
 * 
 * 
 */
package test.controllers;

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
    MainFormControllerTest.class
})
public class ControllersTest
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        System.out.println("Running Tests for Controllers");
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
        System.out.println("Tests completed for Controllers");
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
