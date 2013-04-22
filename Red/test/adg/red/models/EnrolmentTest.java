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
public class EnrolmentTest {
    
    public EnrolmentTest() {
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
     * Test of getIsActive method, of class Enrolment.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        Enrolment instance = new Enrolment();
        boolean expResult = false;
        instance.setIsActive(expResult);
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class Enrolment.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        Enrolment instance = new Enrolment();
        instance.setIsActive(isActive);
        assertEquals(isActive,instance.getIsActive());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


   

  

    /**
     * Test of getScore method, of class Enrolment.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        Enrolment instance = new Enrolment();
        Integer expResult = 80;
        instance.setScore(expResult);
        Integer result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getScoreAsString method, of class Enrolment.
     */
   

    /**
     * Test of setScore method, of class Enrolment.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        Integer score = 60;
        Enrolment instance = new Enrolment();
        instance.setScore(score);
        assertEquals(score,instance.getScore());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   

    

   

   
 

   
  

   

    /**
     * Test of getTerm method, of class Enrolment.
     */
    
    
}