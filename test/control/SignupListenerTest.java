/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class SignupListenerTest
{

    private NewUserListener sl;

    public SignupListenerTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {

    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {

    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of addNewUser method, of class SignupListener.
     */
    @Test
    public void testAddNewUser()
    {
        System.out.println("addNewUser");
        String firstName = "magnus";
        String lastName = "justo";
        String password = "123456";
        String passwordRetype = "123456";
        String expResult = "";
        //String result
        //        = sl.addNewUser(firstName, lastName, password, passwordRetype);
        // TODO review the generated test code and remove the default call to fail.
        //Assert.assertEquals(expResult, result);
    }

}
