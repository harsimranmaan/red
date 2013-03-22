/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.controllers;

import adg.red.controllers.MainFormController;
import java.net.URL;
import java.util.ResourceBundle;
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
public class MainFormControllerTest
{

    public MainFormControllerTest()
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
     * Test of initialize method, of class MainFormController.
     */
    @Test
    public void testInitialize()
    {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        MainFormController instance = new MainFormController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        //dummy
        assertEquals(1, 1);
    }
}
