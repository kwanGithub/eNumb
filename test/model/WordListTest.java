/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Felix
 */
public class WordListTest
{

    private WordList wl;

    public WordListTest()
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
        wl = new WordList("djur");
        wl.addNewWord("hund", "dog", "engelska");
        wl.addNewWord("katt", "cat", "engelska");
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testIfAllWordsHaveBeenAdded()
    {

        assertEquals(2, wl.getListSize());

    }

    @Test
    public void testWithWrongNumber()
    {

        assertFalse(wl.getListSize() == 3);
    }

    @Test
    public void testgetWord()
    {

        String[] expResult = wl.getWord(1);
        String[] result = new String[]
        {
            "katt", "cat", "engelska"
        };
        assertArrayEquals(expResult, result);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWord()
    {

        wl.removeWord(1);
        assertNull(wl.getWord(1));

    }
    
    @Test
    public void testGettingListOfWords(){
        
        Assert.assertNotNull(wl.getWords());
    }

}
