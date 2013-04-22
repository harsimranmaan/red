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

    /**
     * Test of getCourse method, of class CoRequisite.
     */
    @Test
    public void testGetCourse() {
        System.out.println("getCourse");
        CoRequisite instance = new CoRequisite();
        Course expResult = null;
        Course result = instance.getCourse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourse method, of class CoRequisite.
     */
    @Test
    public void testSetCourse() {
        System.out.println("setCourse");
        Course course = null;
        CoRequisite instance = new CoRequisite();
        instance.setCourse(course);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourse1 method, of class CoRequisite.
     */
    @Test
    public void testGetCourse1() {
        System.out.println("getCourse1");
        CoRequisite instance = new CoRequisite();
        Course expResult = null;
        Course result = instance.getCourse1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCourse1 method, of class CoRequisite.
     */
    @Test
    public void testSetCourse1() {
        System.out.println("setCourse1");
        Course course1 = null;
        CoRequisite instance = new CoRequisite();
        instance.setCourse1(course1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class CoRequisite.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CoRequisite instance = new CoRequisite();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class CoRequisite.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        CoRequisite instance = new CoRequisite();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CoRequisite.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CoRequisite instance = new CoRequisite();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCourse method, of class CoRequisite.
     */
    @Test
    public void testGetByCourse() {
        System.out.println("getByCourse");
        Course course = null;
        List expResult = null;
        List result = CoRequisite.getByCourse(course);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}