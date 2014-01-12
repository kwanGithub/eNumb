/*
 * Sets the rules for userinput
 * Then passes it to model
 */
package control;

import javax.swing.JOptionPane;
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

    /**
     *
     * @param word
     * @return
     */
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

    public static boolean verifyNoEmptyFieldsRegistering(String first, String last, String pass, String passRetype)
    {
        if (first.isEmpty() || last.isEmpty() || pass.isEmpty() || passRetype.isEmpty())
        {
            return false;
        }
        return true;

    }

    public static boolean verifyNoEmptyFieldNewWordList(String[] listFields)
    {

        for (String string : listFields)
        {
            if (string.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Alla fält måste vara ifyllda");
                return false;
            }

        }
        return true;
    }

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
