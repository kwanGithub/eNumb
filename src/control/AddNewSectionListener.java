/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import model.Game;
import view.Enumb;

/**
 *
 * @author kevin
 */
public class AddNewSectionListener implements ActionListener
{

    private JButton saveWords;
    private Enumb main;
    private JTextField[] inputField;
    private String[] convertedToString;
    private Game game;
    private Parser parser;

    public AddNewSectionListener(JButton saveWords, Enumb main, JTextField[] inputField)
    {
        this.saveWords = saveWords;
        this.main = main;
        this.inputField = inputField;
        parser = MainFactory.getParser();
        game = parser.getGame();

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

        }
        //DEBUG
    }

    public void validateInputField()
    {

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

            convertJTextToString();
            //printTest();
            addNewSectionList();
//main.goFromMenuToChosenLanguage();
        }

    }

}
