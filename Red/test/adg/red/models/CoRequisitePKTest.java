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
public class CoRequisitePKTest {
    
    public CoRequisitePKTest() {
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
     * Test of getCourseNumber method, of class CoRequisitePK.
     */
    @Test
    public void testGetCourseNumber() {
        System.out.println("getCourseNumber");
        CoRequisitePK instance = new CoRequisitePK();
        int expResult = 100;
        instance.setCourseNumber(expResult);
        int result = instance.getCourseNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCourseNumber method, of class CoRequisitePK.
     */
    @Test
    public void testSetCourseNumber() {
        System.out.println("setCourseNumber");
        int courseNumber = 200;
        CoRequisitePK instance = new CoRequisitePK();
        instance.setCourseNumber(courseNumber);
        assertEquals(courseNumber,instance.getCourseNumber());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartmentId method, of class CoRequisitePK.
     */
    @Test
    public void testGetDepartmentId() {
        System.out.println("getDepartmentId");
        CoRequisitePK instance = new CoRequisitePK();
         String expResult = "CICS";
        instance.setDepartmentId(expResult);
        String result = instance.getDepartmentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartmentId method, of class CoRequisitePK.
     */
    @Test
    public void testSetDepartmentId() {
        System.out.println("setDepartmentId");
        String departmentId = "EE";
        CoRequisitePK instance = new CoRequisitePK();
        instance.setDepartmentId(departmentId);
        assertEquals(departmentId,instance.getDepartmentId());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getCoRequisiteNumber method, of class CoRequisitePK.
     */
    @Test
    public void testGetCoRequisiteNumber() {
        System.out.println("getCoRequisiteNumber");
        CoRequisitePK instance = new CoRequisitePK();
        int expResult = 300;
        instance.setCoRequisiteNumber(expResult);
        int result = instance.getCoRequisiteNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCoRequisiteNumber method, of class CoRequisitePK.
     */
    @Test
    public void testSetCoRequisiteNumber() {
        System.out.println("setCoRequisiteNumber");
        int coRequisiteNumber = 510;
        CoRequisitePK instance = new CoRequisitePK();
        instance.setCoRequisiteNumber(coRequisiteNumber);
        assertEquals(coRequisiteNumber,instance.getCoRequisiteNumber());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCoRequisiteDeptId method, of class CoRequisitePK.
     */
    @Test
    public void testGetCoRequisiteDeptId() {
        System.out.println("getCoRequisiteDeptId");
        CoRequisitePK instance = new CoRequisitePK();
        String expResult = "MATH";
        instance.setCoRequisiteDeptId(expResult);
        String result = instance.getCoRequisiteDeptId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCoRequisiteDeptId method, of class CoRequisitePK.
     */
    @Test
    public void testSetCoRequisiteDeptId() {
        System.out.println("setCoRequisiteDeptId");
        String coRequisiteDeptId = "CHE";
        CoRequisitePK instance = new CoRequisitePK();
        instance.setCoRequisiteDeptId(coRequisiteDeptId);
        assertEquals(coRequisiteDeptId,instance.getCoRequisiteDeptId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

   
  