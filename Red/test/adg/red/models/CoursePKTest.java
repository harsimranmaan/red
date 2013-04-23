/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

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
public class CoursePKTest {
    
    public CoursePKTest() {
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
     * Test of getCourseNumber method, of class CoursePK.
     */
    @Test
    public void testGetCourseNumber() {
        System.out.println("getCourseNumber");
        CoursePK instance = new CoursePK();
        int expResult = 711;
        instance.setCourseNumber(expResult);
        int result = instance.getCourseNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCourseNumber method, of class CoursePK.
     */
    @Test
    public void testSetCourseNumber() {
        System.out.println("setCourseNumber");
        int courseNumber = 720;
        CoursePK instance = new CoursePK();
        instance.setCourseNumber(courseNumber);
        assertEquals(courseNumber,instance.getCourseNumber());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartmentId method, of class CoursePK.
     */
    @Test
    public void testGetDepartmentId() {
        System.out.println("getDepartmentId");
        CoursePK instance = new CoursePK();
        String expResult = "Literature";
        instance.setDepartmentId(expResult);
        String result = instance.getDepartmentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartmentId method, of class CoursePK.
     */
    @Test
    public void testSetDepartmentId() {
        System.out.println("setDepartmentId");
        String departmentId = "Society Work";
        CoursePK instance = new CoursePK();
        instance.setDepartmentId(departmentId);
       assertEquals(departmentId, instance.getDepartmentId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
   
   

   