/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class ParserTest
{

    private Parser parser;

    public ParserTest()
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
        Game game = new Game();
        parser = new Parser(game);
    }

    @After
    public void tearDown()
    {
    }

//    @Test
//    public void testvalidateUserInput()
//    {
//        String expResult = "abcd";
//        Assert.assertEquals(expResult, parser.validateUserInput("ABCD"));
//    }

    @Test
    public void testMaxMinLettersControl()
    {

        Assert.assertFalse(Parser.maxLetters("abcdefghijklmnopqrstuvwxyzåäö"));
        Assert.assertTrue(Parser.maxLetters("mumintroll"));

    }

    @Test
    public void testIfInputContainsNumbers()
    {

        Assert.assertFalse(Parser.lookForNumbers("hej123"));
        Assert.assertTrue(Parser.lookForNumbers("hejsan"));

    }


    @Test
    public void testPasswordsAreTheSame()
    {

        Assert.assertFalse(Parser.passwordCheck("hej", "då"));
        Assert.assertTrue(Parser.passwordCheck("hej", "hej"));

    }

    @Test
    public void testPasswordMatchingUsername()
    {
        

        Assert.assertTrue(parser.passwordIsCorrect("adrian ronsten", "lol"));
        Assert.assertFalse(parser.passwordIsCorrect("kalle stropp", "snor"));
    }
    
    @Test
    public void testFirstLetterToUpperCase(){
        
        String expResult = "Karl";
        String result = parser.firstLetterCapital("karl");
        
        Assert.assertEquals(expResult, result);
    }

}
