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
 *s
 * @author Felix
 */
public class WordTest
{

    Word w;

    public WordTest()
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
        w = new Word("katt", "cat", "engelska");
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testGettingSwedishWord()
    {
        assertEquals("katt", w.getSwed());
    }

    @Test
    public void testGettingForeignWord()
    {
        String expResult = "cat";
        String result = w.getFor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGettingLanguage()
    {
        assertEquals("engelska", w.getLang());
    }

    @Test
    public void testStringOutput()
    {
        String[] stringAr = w.toStringArray();
        assertEquals("katt", stringAr[0]);
        assertEquals("cat", stringAr[1]);
        assertEquals("engelska", stringAr[2]);
    }

}
