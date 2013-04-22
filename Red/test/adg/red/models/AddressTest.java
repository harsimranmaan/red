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
public class AddressTest {
    
    public AddressTest() {
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
     * Test of getAddressId method, of class Address.
     */
    @Test
    public void testGetAddressId() {
        System.out.println("getAddressId");
        Address instance = new Address();
        instance.setAddressId(123);
        Integer expResult = 123;
        Integer result = instance.getAddressId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressId method, of class Address.
     */
    @Test
    public void testSetAddressId() {
        System.out.println("setAddressId");
        Integer addressId = 123;
        Address instance = new Address();
        instance.setAddressId(addressId);
        assertEquals(addressId,instance.getAddressId());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressLineFirst method, of class Address.
     */
    @Test
    public void testGetAddressLineFirst() {
        System.out.println("getAddressLineFirst");
        Address instance = new Address();
        String expResult = "12345 West";
       instance.setAddressLineFirst(expResult);
        String result = instance.getAddressLineFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressLineFirst method, of class Address.
     */
    @Test
    public void testSetAddressLineFirst() {
        System.out.println("setAddressLineFirst");
        String addressLineFirst = "1000 West";
        Address instance = new Address();
        instance.setAddressLineFirst(addressLineFirst);
        assertEquals(addressLineFirst,instance.getAddressLineFirst());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressLineSecond method, of class Address.
     */
    @Test
    public void testGetAddressLineSecond() {
        System.out.println("getAddressLineSecond");
        Address instance = new Address();
        instance.setAddressLineSecond("Great Vancouver");
        String expResult = "Great Vancouver";
        String result = instance.getAddressLineSecond();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setAddressLineSecond method, of class Address.
     */
    @Test
    public void testSetAddressLineSecond() {
        System.out.println("setAddressLineSecond");
        String addressLineSecond = "Elephant Hill District";
        Address instance = new Address();
        instance.setAddressLineSecond(addressLineSecond);
        assertEquals(addressLineSecond, instance.getAddressLineSecond());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCity method, of class Address.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        Address instance = new Address();
        instance.setCity("Vancouver");
        String expResult = "Vancouver";
        String result = instance.getCity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCity method, of class Address.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "Vancouver";
        Address instance = new Address();
        instance.setCity(city);
        assertEquals(city,instance.getCity());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProvince method, of class Address.
     */
    @Test
    public void testGetProvince() {
        System.out.println("getProvince");
        Address instance = new Address();
        instance.setProvince("British Columbia");
        String expResult = "British Columbia";
        String result = instance.getProvince();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setProvince method, of class Address.
     */
    @Test
    public void testSetProvince() {
        System.out.println("setProvince");
        String province = "Ontario";
        Address instance = new Address();
        instance.setProvince(province);
        assertEquals(province,instance.getProvince());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getPostalCode method, of class Address.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        Address instance = new Address();
        instance.setPostalCode("V6M1Z4");
        String expResult = "V6M1Z4";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPostalCode method, of class Address.
     */
    @Test
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "123";
        Address instance = new Address();
        instance.setPostalCode(postalCode);
        assertEquals(postalCode,instance.getPostalCode());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getCountry method, of class Address.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Address instance = new Address();
        instance.setCountry("Canada");
        String expResult = "Canada";
        String result = instance.getCountry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCountry method, of class Address.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "SriLanka";
        Address instance = new Address();
        instance.setCountry(country);
        assertEquals(country,instance.getCountry());
       
    }



    /**
     * Test of equals method, of class Address.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Address instance = new Address(123);
        Address instance1 = new Address(123);
        boolean expResult = true;
        boolean result = instance.equals(instance1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
     

  
}