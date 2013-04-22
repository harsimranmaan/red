/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.util.Date;
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
public class AdministratorTest {
    
    public AdministratorTest() {
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
     * Test of getAdminId method, of class Administrator.
     */
    @Test
    public void testGetAdminId() {
        System.out.println("getAdminId");
        Administrator instance = new Administrator();
        Integer expResult = 200;
        instance.setAdminId(expResult);
        Integer result = instance.getAdminId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setAdminId method, of class Administrator.
     */
    @Test
    public void testSetAdminId() {
        System.out.println("setAdminId");
        Integer adminId = 123;
        Administrator instance = new Administrator();
        instance.setAdminId(adminId);
        assertEquals(adminId, instance.getAdminId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    

    /**
     * Test of getIsActive method, of class Administrator.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        Administrator instance = new Administrator();
        boolean expResult = false;
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class Administrator.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        Administrator instance = new Administrator();
        instance.setIsActive(isActive);
        assertEquals(isActive,instance.getIsActive());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   

   

   

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Administrator instance = new Administrator(123);
        Administrator instance1= new Administrator(123);
        boolean expResult = true;
        boolean result = instance.equals(instance1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

   }