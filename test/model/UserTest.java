/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class UserTest
{

    User user;

    public UserTest()
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
        user = new User("adrian", "Ronsten", "1234");
        user.setHighscore(10);
        user.setTotalScore(22);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetUserName()
    {
        String expResult = "adrian";
        String result = user.getfirstname();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetLastName()
    {
        String expResult = "Ronsten";
        String result = user.getlastname();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPassword()
    {
        String expResult = "1234";
        String result = user.getPassword();
        assertEquals(expResult, result);

    }

    @Test
    public void testHighscore()
    {
        int expResult = 10;
        int result = user.getHightScore();
        assertEquals(expResult, result);

    }

    @Test
    public void testTotalScore()
    {
        int expResult = 22;
        int result = user.getTotalScore();
        assertEquals(expResult, result);

    }

}
