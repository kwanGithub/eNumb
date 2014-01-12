/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class UserListTest
{

    private UserList userlist;

    public UserListTest()
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
        userlist = new UserList();
        userlist.addUser(new String[]
        {
            "adrian", "ronsten", "1234"
        });
        userlist.addUser(new String[]
        {
            "viktor", "zetterberg", "abcd"
        });
        userlist.addUser(new String[]
        {
            "magnus", "juto", "5678"
        });

    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddUser()
    {
        userlist.addUser(new String[]
        {
            "zlatan", "ibrahimovic", "0987"
        });
        String expResult = "zlatan ibrahimovic";
        String result = userlist.getUser(3).getUsername();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveUser()
    {
        userlist.removUser(0);
        String expResult = "viktor zetterberg";
        String result = userlist.getUser(0).getUsername();
        assertEquals(expResult, result);
    }

    @Test
    public void testShowList()
    {

        userlist = new UserList();
        userlist.addUser(new String[]
        {
            "adrian", "ronsten", "1234"
        });
        userlist.addUser(new String[]
        {
            "viktor", "zetterberg", "abcd"
        });
        userlist.addUser(new String[]
        {
            "magnus", "juto", "5678"
        });

        String[] expResult = new String[]
        {

            "adrian ronsten", "viktor zetterberg", "magnus juto"

        };

        String[] result = userlist.showList();

        Assert.assertArrayEquals(expResult, result);

    }
    
    @Test
    public void testIfUserNameIsFree(){
        
        Assert.assertTrue(userlist.nameAvailable("kopernikus"));
        
    }

}
