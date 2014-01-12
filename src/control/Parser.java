/*
 * Sets the rules for userinput
 * Then passes it to model
 */
package control;

import model.Game;

/**
 *
 * @author kevin
 */
public class Parser
{

    private Game game;

    public Parser(Game game)
    {
        this.game = game;
    }

    public void getUserList()
    {
        game.getUserList();

    }

    //Behövs den här? väldigt lik validate answer..
    // Och man kan använda andra metoder för att täcka funktionaliteten
    public static boolean validateUserInput(String word)
    {
        String input = cleanUp(word);
        if (maxLetters(input) == true)
        {
            return true;
        }
        return false;
    }

    public static boolean maxLetters(String word)
    {
        if (word.length() > 24 || word.length() < 1)
        {
            return false;
        }
        return true;
    }

    public static boolean lookForNumbers(String input)
    {
        String numbers = "1234567890";

        for (int i = 0; i < 10; i++)
        {
            if (input.contains(numbers.substring(i, i + 1)))
            {
                return false;
            }
        }
        return true;
    }

    public static String cleanUp(String s)
    {

        return s.toLowerCase().trim();

    }

    public static boolean passwordCheck(String password, String retype)
    {
        if (password.equals(retype))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean verifyNoEmptyFields(String first, String last, String pass, String passRetype)
    {
        if (first.isEmpty() || last.isEmpty() || pass.isEmpty() || passRetype.isEmpty())
        {
            return false;
        }
        return true;

    }

//    public boolean validateUserName(String name)
//    {
//
//        String user = cleanUp(name);
//
//        if((maxLetters(user) && lookForNumbers(name) && game.usernameAvailable(user)))
//        {
//
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//
//    }
    public boolean validateAnswer(String answer, int index)
    {

        if (maxLetters(answer) && lookForNumbers(answer))
        {
            String word = cleanUp(answer);
            return game.checkWord(index, word);
        }

        return false;
    }

    

    public boolean passwordIsCorrect(String user, String password)
    {
        //game.setUser(user);
        return game.checkPassword(user, password);

    }

    public boolean userExists(String first, String last)
    {
        String f = cleanUp(first);
        String l = cleanUp(last);

        if (game.usernameAvailable(f + " " + l))
        {
            return true;
        }
        return false;
    }

    public Game getGame()
    {

        return game;
    }

    public String firstLetterCapital(String name)
    {

        String properName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return properName;

    }
}
