/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.models;

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
public class ModelsTest
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        System.out.println("Running Tests for Models");
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
        System.out.println("Tests completed for Models");
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
