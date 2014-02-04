/*
 * Sets the rules for userinput
 * Then passes it to model
 */
package control;

import javax.swing.JOptionPane;
import model.Game;

/**
 * This class controls and validates inputs before sending it to model
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
     * Validates input if input passes the rules we have set up it will return true
     *
     * @param word inputtext
     * @return ture or false
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

    /**
     * chekcs the input field if it has more than 24 characthers if not will return true
     *
     * @param word inputfield
     * @return true or false
     */
    public static boolean maxLetters(String word)
    {
        if (word.length() > 24 || word.length() < 1)
        {
            return false;
        }
        return true;
    }

    /**
     * checks the inputfiled for numbers returns true if the field doenst have any numbers
     *
     * @param input inputfield
     * @return true or false
     */
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

    /**
     * sets the input text to lowercase and trims it
     *
     * @param s inputfield
     * @return inputfield cleaned and trimed
     */
    public static String cleanUp(String s)
    {

        return s.toLowerCase().trim();

    }

    /**
     * validtates the regrestation password twice, returns true if pass1 and pass2 are equal
     *
     * @param password pass1 on regrestation field
     * @param retype pass2 on regrestation field
     * @return true if they are equal else false
     */
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

    /**
     * Verfiyt if regresttaions field are not empty
     *
     * @param first firstname field
     * @param last lastname field
     * @param pass password field
     * @param passRetype password field 2
     * @return returs true if the fields arent empty
     */
    public static boolean verifyNoEmptyFieldsRegistering(String first, String last, String pass, String passRetype)
    {
        if (first.isEmpty() || last.isEmpty() || pass.isEmpty() || passRetype.isEmpty())
        {
            return false;
        }
        return true;

    }

    /**
     * verifty fields are not empty when u create a new list
     *
     * @param listFields list of the words the user wants to save
     * @return returns ture if the field are not empty else false
     */
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

    /**
     * Validates answer field ingame
     *
     * @param answer input field
     * @param index the word u want to check
     * @return true or false
     */
    public boolean validateAnswer(String answer, int index)
    {

        if (maxLetters(answer) && lookForNumbers(answer))
        {
            String word = cleanUp(answer);
            return game.checkWord(index, word);
        }

        return false;
    }

    /**
     * Matches the usersname with password
     *
     * @param user username
     * @param password password
     * @return true if match
     */
    public boolean passwordIsCorrect(String user, String password)
    {
        //game.setUser(user);
        return game.checkPassword(user, password);

    }

    /**
     * chekcs if the username is availble
     *
     * @param first first name
     * @param last lastname
     * @return
     */
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

    /**
     * sets string with first capital letter
     *
     * @param name string
     * @return string with the first letter set to capital
     */
    public String firstLetterCapital(String name)
    {

        String properName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return properName;

    }
}
