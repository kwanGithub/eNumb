/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Game;
import view.Enumb;

/**
 * This class handles the funktion to create a new wordList
 *
 * @author kevin
 */
public class AddNewSectionListener implements ActionListener
{

    private JButton saveWords;
    private Enumb main;
    private JTextField[] inputField;
    private JTextField addWeekName;
    private String[] convertedToString;
    private Game game;
    private Parser parser;

    /**
     *
     * @param saveWords savebutton
     * @param addWeekName filename
     * @param main enubm main
     * @param inputField array that stores the words the users wants to use for the List
     */
    public AddNewSectionListener(JButton saveWords, JTextField addWeekName, Enumb main, JTextField[] inputField)

    {
        this.saveWords = saveWords;
        this.main = main;
        this.inputField = inputField;
        this.addWeekName = addWeekName;
        parser = MainFactory.getParser();
        game = parser.getGame();

    }

    /**
     * Sets the inputfields
     */
    public void emptyFieldsNewSection()
    {
        addWeekName.setText("");

        for (int i = 0; i < inputField.length; i++)
        {
            inputField[i].setText("");

        }

    }

    /**
     * Converts the elements inte the JText array to a String Array
     */
    public void convertJTextToString()
    {

        convertedToString = new String[inputField.length];
        for (int i = 0; i < inputField.length; i++)
        {
            convertedToString[i] = new String(inputField[i].getText());
            //debug
            System.out.println(convertedToString[i]);

        }

    }

    /**
     * Validates the lists language, filename and list words
     *
     * @param filename Listfiel name
     * @param language List language name
     * @param convertedToString List of words
     * @return
     */
    public boolean validateInputField(String filename, String language, String[] convertedToString)
    {
        filename = parser.cleanUp(filename);
        language = parser.cleanUp(language);
        if (Parser.validateUserInput(language) && Parser.validateUserInput(filename) == true)
        {

            for (String string : convertedToString)
            {
                if (Parser.validateUserInput(string) == true)
                {
                    string = parser.cleanUp(string);
                    return true;

                }
                else
                {
                    return false;
                }

            }
        }
        return false;
    }

    /**
     * Validates and checks if the inputfields are empty or note before creating a new wordsList
     *
     * @param filename Listfiel name
     * @param language List language name
     * @param convertedToString List of words
     */
    public void addNewSectionList(String filename, String language, String[] convertedToString)
    {

        if (Parser.verifyNoEmptyFieldNewWordList(convertedToString) == true && (validateInputField(filename, language, convertedToString) == true))
        {
            game.createWordList(filename, language, convertedToString);
            JOptionPane.showMessageDialog(null, "Listan sparad");
            emptyFieldsNewSection();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Listan är inte sparad, försök igen");
            emptyFieldsNewSection();
        }

    }

    public void addNewSectionList()
    {
        String language = game.getCurrentLanguage();
        game.createWordList("lol", language, convertedToString);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object choice = (e.getSource());
        if (choice == saveWords)
        {
            String listName = this.addWeekName.getText();
            //debug
            System.out.println(listName);

            convertJTextToString();

            addNewSectionList(listName, game.getCurrentLanguage(), convertedToString);

            //printTest();
            addNewSectionList();

        }

    }

}
