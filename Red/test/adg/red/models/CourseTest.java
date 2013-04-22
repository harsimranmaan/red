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
 * @author Mengmeng Jiang
 */
public class CourseTest {
    
    public CourseTest() {
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
     * Test of getName method, of class Course.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Course instance = new Course();
        String expResult = "Digital Circuit";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Course.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Operating System";
        Course instance = new Course();
        instance.setName(name);
        assertEquals(name,instance.getName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Course.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Course instance = new Course();
        String expResult = "Introduction to Operating System";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Course.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "Learn how to set up database for a medium company";
        Course instance = new Course();
        instance.setDescription(description);
        assertEquals(description,instance.getDescription());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCredits method, of class Course.
     */
    @Test
    public void testGetCredits() {
        System.out.println("getCredits");
        Course instance = new Course();
        int expResult = 6;
        instance.setCredits(expResult);
        int result = instance.getCredits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCredits method, of class Course.
     */
    @Test
    public void testSetCredits() {
        System.out.println("setCredits");
        int credits = 3;
        Course instance = new Course();
        instance.setCredits(credits);
        assertEquals(credits,instance.getCredits());
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getPassingRequirement method, of class Course.
     */
    @Test
    public void testGetPassingRequirement() {
        System.out.println("getPassingRequirement");
        Course instance = new Course();
        String expResult = "68percentage";
        instance.setPassingRequirement(expResult);
        String result = instance.getPassingRequirement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPassingRequirement method, of class Course.
     */
    @Test
    public void testSetPassingRequirement() {
        System.out.println("setPassingRequirement");
        String passingRequirement = "B-";
        Course instance = new Course();
        instance.setPassingRequirement(passingRequirement);
        assertEquals(passingRequirement,instance.getPassingRequirement());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsActive method, of class Course.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        Course instance = new Course();
        boolean expResult = false;
        instance.setIsActive(expResult);
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class Course.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        Course instance = new Course();
        instance.setIsActive(isActive);
        assertEquals(isActive,instance.getIsActive());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
     }

   
    

   