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
 * @author Administrator
 */
public class EmailCodeTest {
    
    public EmailCodeTest() {
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
     * Test of getUsername method, of class EmailCode.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        EmailCode instance = new EmailCode();
        String expResult = "Sakura";
        instance.setUsername(expResult);
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class EmailCode.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Taylor";
        EmailCode instance = new EmailCode();
        instance.setUsername(username);
        assertEquals(username,instance.getUsername());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class EmailCode.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        EmailCode instance = new EmailCode();
        String expResult = "please use the code to reset your password";
        instance.setCode(expResult);
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCode method, of class EmailCode.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "please follow the instruction below";
        EmailCode instance = new EmailCode();
        instance.setCode(code);
        assertEquals(code,instance.getCode());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

   
    

    

   