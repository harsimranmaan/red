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
public class DepartmentTest {
    
    public DepartmentTest() {
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
     * Test of getDepartmentId method, of class Department.
     */
    @Test
    public void testGetDepartmentId() {
        System.out.println("getDepartmentId");
        Department instance = new Department();
        String expResult = "American Literature";
        instance.setDepartmentId(expResult);
        String result = instance.getDepartmentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartmentId method, of class Department.
     */
    @Test
    public void testSetDepartmentId() {
        System.out.println("setDepartmentId");
        String departmentId = "Chem";
        Department instance = new Department();
        instance.setDepartmentId(departmentId);
        assertEquals(departmentId, instance.getDepartmentId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Department.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Department instance = new Department();
        String expResult = "Law";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Department.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Chemistry";
        Department instance = new Department();
        instance.setName(name);
        assertEquals(name,instance.getName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsActive method, of class Department.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        Department instance = new Department();
        boolean expResult = false;
        instance.setIsActive(expResult);
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class Department.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        Department instance = new Department();
        instance.setIsActive(isActive);
        assertEquals(isActive,instance.getIsActive());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
}

   

    

    
    


 