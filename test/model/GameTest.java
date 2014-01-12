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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Felix
 */
public class GameTest
{

    Game game;

    public GameTest()
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

        game = new Game();

    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetUsernameList()
    {

        String[] result = game.getUserList();
        String expResult = "adrian ronsten";

        assertEquals(expResult, result[0]);
    }

    @Test
    public void testGetUser()
    {

        String expResult = "adrian ronsten";

        User result = game.getUser(expResult);

        assertEquals(expResult, result.getUsername());

    }

    @Test
    public void testMatchingPassword()
    {

        assertTrue(game.checkPassword("adrian ronsten", "lol"));

    }

    @Test
    public void testAddingNewUser()
    {

        game.addNewUser("kalle", "stropp", "12345", "12345");

        assertNotNull(game.getUser("kalle stropp"));

    }

    @Test
    public void testCreateWordList()
    {

        String[] words = new String[]
        {

            "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat",
            "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat", "katt", "cat",
        };
        
        game.getListOfLanguageSections("engelska");
        game.createWordList("vecka 1", "engelska", words);

        assertNotNull(game.getWordList("vecka 1"));

    }
    
    
    @Test
    public void testGettingListOfLangauges(){
        
        assertNotNull(game.getListOfLanguages());  
    }
    
    @Test
    public void testSettingListOfLanguages(){
        
        String[] expResult = new String[]{"engelska", "spanska", "franska"};
        
        game.setLanguageList(expResult);
        
        String[] result = game.getListOfLanguages();
        
    }
    
    @Test
    public void testGettingListOfEnglishWordLists(){
        
        String[] expResult = new String[]{"hund", "vecka 1", "words"};
        
        String[] result = game.getListOfLanguageSections("engelska");
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    
    @Test
    public void testIfInputWordMatchesTranslation(){
        
        game.getListOfLanguageSections("engelska");
        game.setListandLevel("words",  1);
        game.setUser("adrian ronsten");
        
        assertTrue( game.checkWord(1, "cat") );
        
    }
    
    @Test
    public void testGettingWord(){
        
        game.getListOfLanguageSections("engelska");
        game.setListandLevel("words",  1);
        game.setUser("adrian ronsten");
        
        String[] expResult = new String[]{"katt", "cat", "engelska"};
        
        String[] result = game.getWord(1);
        
        Assert.assertArrayEquals(expResult, result);
    }
    
    
    @Test
    public void testPlayingTheGameGettingAndSavingScore(){
        
        game.getListOfLanguageSections("engelska");
        game.setListandLevel("words",  1);
        game.setUser("adrian ronsten");
        
        for (int i = 0; i < 10; i++) {
            game.checkWord(i, "cat");
        }
        
        game.saveScore(0);     
        
        int result = game.getUser("adrian ronsten").getHightScore();
        
        int expResult = 100;
        
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGettingRandomAnswers(){
       
        
        game.getListOfLanguageSections("engelska");
        game.setListandLevel("words",  1);
        game.setUser("adrian ronsten");
        
        String rightAnswer = game.getWord(1)[1];
        
        String a = game.getRandomAnswer(rightAnswer);
        String b = game.getRandomAnswer(rightAnswer);
                
        Assert.assertFalse( rightAnswer.equals(b));
        Assert.assertFalse( rightAnswer.equals(a));
        
    }
    
    @Test
    public void testCheckingIfUserNameIsTaken(){
        
        assertTrue(game.usernameAvailable("snusmumriken11"));
          
    }        
}
