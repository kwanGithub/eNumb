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
import view.ChosenLanguage;
import view.Enumb;

/**
 * This class handles the the addNewSection buttons
 *
 * @author kevin
 */
public class AddNewSectionListener implements ActionListener
{

    private final JButton saveWords, cancel;
    private final Enumb main;
    private final JTextField[] inputField;
    private final JTextField addWeekName;
    private String[] convertedToString;
    private final Game game;
    private final Parser parser;

    /**
     * Consctructor
     *
     * @param saveWords savebutton
     * @param cancel canvelbutton
     * @param addWeekName filename
     * @param main enubm main
     * @param inputField array that stores the words the users wants to use for the List
     */
    public AddNewSectionListener(JButton saveWords, JButton cancel, JTextField addWeekName, Enumb main, JTextField[] inputField)

    {
        this.saveWords = saveWords;
        this.main = main;
        this.inputField = inputField;
        this.addWeekName = addWeekName;
        this.cancel = cancel;
        parser = MainFactory.getParser();
        game = parser.getGame();

    }

    /**
     * Empties the input fields
     */
    public void emptyFieldsNewSection()
    {
        addWeekName.setText("");
        for (JTextField inputField1 : inputField)
        {
            inputField1.setText("");
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
     * Validates the list language, filename and list words
     *
     * @param filename Listfiel name
     * @param language List language name
     * @param convertedToString List of words
     * @return
     */
    public boolean validateInputField(String filename, String language, String[] convertedToString)
    {
        filename = Parser.cleanUp(filename);
        language = Parser.cleanUp(language);
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
     * Validates and checks if the inputfields are empty or not before creating a new wordsList
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
            ChosenLanguage lang = new ChosenLanguage(main);
            lang.fillList();

            emptyFieldsNewSection();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Listan är inte sparad, försök igen");
            emptyFieldsNewSection();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object choice = (e.getSource());
        if (choice == saveWords)
        {
            String listName = Parser.cleanUp(this.addWeekName.getText());

            convertJTextToString();

            addNewSectionList(listName, game.getCurrentLanguage(), convertedToString);

            main.goFromMenuToChosenLanguage();
        }
        else if (choice == cancel)
        {
            main.goFromMenuToChosenLanguage();
        }

    }

}
