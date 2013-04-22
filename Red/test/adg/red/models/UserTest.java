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
public class UserTest {
    
    public UserTest() {
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
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User();
        String expResult ="Snoopy" ;
        instance.setUsername(expResult);
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Chibi Maruko";
        User instance = new User();
        instance.setUsername(username);
        assertEquals(username,instance.getUsername());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

  
   

    /**
     * Test of getFirstName method, of class User.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        User instance = new User();
        String expResult = "Chibi";
        instance.setFirstName(expResult);
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class User.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Sakura";
        User instance = new User();
        instance.setFirstName(firstName);
        assertEquals(firstName,instance.getFirstName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class User.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        User instance = new User();
        String expResult = "Cardcaptor";
        instance.setLastName(expResult);
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class User.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Maruko";
        User instance = new User();
        instance.setLastName(lastName);
        assertEquals(lastName,instance.getLastName());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getIsOnline method, of class User.
     */
    @Test
    public void testGetIsOnline() {
        System.out.println("getIsOnline");
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.getIsOnline();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsOnline method, of class User.
     */
    @Test
    public void testSetIsOnline() {
        System.out.println("setIsOnline");
        boolean isOnline = false;
        User instance = new User();
        instance.setIsOnline(isOnline);
        assertEquals(isOnline, instance.getIsOnline());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPhoneNumber method, of class User.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        User instance = new User();
        String expResult = "657331366";
        instance.setPhoneNumber(expResult);
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPhoneNumber method, of class User.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "705-722-6891";
        User instance = new User();
        instance.setPhoneNumber(phoneNumber);
        assertEquals(phoneNumber,instance.getPhoneNumber());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "mickey@gmail.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "minnie@gmail.com";
        User instance = new User();
        instance.setEmail(email);
        assertEquals(email,instance.getEmail());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDateOfBirth method, of class User.
     */
    @Test
    public void testGetDateOfBirth() {
        System.out.println("getDateOfBirth");
        User instance = new User();
        Date expResult = null;
        Date result = instance.getDateOfBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    /**
     * Test of getIsActive method, of class User.
     */
    @Test
    public void testGetIsActive() {
        System.out.println("getIsActive");
        User instance = new User();
        boolean expResult = false;
        instance.setIsActive(expResult);
        boolean result = instance.getIsActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setIsActive method, of class User.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        User instance = new User();
        instance.setIsActive(isActive);
        assertEquals(isActive,instance.getIsActive());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }


    
  
}