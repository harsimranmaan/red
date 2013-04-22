/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class CoRequisiteTest {
    
    public CoRequisiteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

  

    /**
     * Test of getIsActive method, of class CoRequisite.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        CoRequisite instance = new CoRequisite();
        boolean expResult = false;
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class CoRequisite.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        CoRequisite instance = new CoRequisite();
        instance.setIsActive(isActive);
        assertEquals(isActive,instance.getIsActive());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsMust method, of class CoRequisite.
     */
    @Test
    public void testGetIsMust() {
        System.out.println("getIsMust");
        CoRequisite instance = new CoRequisite();
        boolean expResult = false;
        instance.setIsMust(expResult);
        boolean result = instance.getIsMust();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsMust method, of class CoRequisite.
     */
    @Test
    public void testSetIsMust() {
        System.out.println("setIsMust");
        boolean isMust = false;
        CoRequisite instance = new CoRequisite();
        instance.setIsMust(isMust);
        assertEquals(isMust,instance.getIsMust());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
 
  
}