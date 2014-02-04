/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Game;
import view.Enumb;
import view.Help;

/**
 * controller for menu class
 *
 * @author kevin
 */
public class MenuListener implements ActionListener
{

    private JTextField newLanguageField;
    private JButton addNewLanguage, help, quit, next, logOut;
    private Enumb main;
    private Parser parser;
    private Game game;
    private JComboBox<String> chooseLanguage;
    private JLabel flagLabel;

    /**
     * consctructor
     *
     * @param newLanguageField language inputfield
     * @param addNewLanguage button for new language
     * @param help help button
     * @param quit quit button
     * @param next next button
     * @param logOut logout button
     * @param main enumb view
     * @param chooseLanguage combobox for languages
     * @param flagLabel countryflags
     */
    public MenuListener(JTextField newLanguageField, JButton addNewLanguage,
            JButton help, JButton quit, JButton next, JButton logOut, Enumb main,
            JComboBox<String> chooseLanguage, JLabel flagLabel)
    {
        this.newLanguageField = newLanguageField;
        this.addNewLanguage = addNewLanguage;
        this.help = help;
        this.quit = quit;
        this.next = next;
        this.logOut = logOut;
        this.main = main;
        this.chooseLanguage = chooseLanguage;
        this.flagLabel = flagLabel;
        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    public MenuListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Checks supported lang
     *
     * @param inputLang language name
     * @return true or false pending of the availbitly of the lang
     */
    private boolean languageAvailable(String inputLang)
    {

        if (parser.validateUserInput(inputLang))
        {
            String lang = parser.cleanUp(inputLang);
            String[] langs = game.getListOfLanguages();
            for (int i = 0; i < langs.length; i++)
            {
                if (langs[i].equals(lang))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public String[] getLanguages()
    {

        String[] languages = game.getListOfLanguages();
        String[] langWithCaps = new String[languages.length];

        for (int i = 0; i < languages.length; i++)
        {
            langWithCaps[i] = parser.firstLetterCapital(languages[i]);
        }
        return langWithCaps;
    }

    /**
     * sets droopdown menu
     */
    public void setDropDown()
    {

        chooseLanguage.removeAllItems();

        String[] langs = getLanguages();

        for (String s : langs)
        {

            chooseLanguage.addItem(s);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        String language = chooseLanguage.getItemAt(chooseLanguage.getSelectedIndex());
        ImageIcon flag = new ImageIcon("images\\flags\\" + language + ".png");

        if (flag.getIconHeight() < 1)
        {
            flag = new ImageIcon("images\\flags\\pride.png");
        }

        flagLabel.setIcon(flag);

        Object choice = (e.getSource());

        if (choice == addNewLanguage)
        {
            // AddNewLanguage.display();
            String lang = Parser.cleanUp(newLanguageField.getText());
            if (languageAvailable(lang))
            {
                game.addNewLanguage(lang);
                newLanguageField.setText("");
                setDropDown();

            }

        }
        else if (choice == quit)
        {
            System.exit(0);
        }
        else if (choice == logOut)
        {
            main.logOutUser();
        }
        else if (choice == next)
        {
            String lang = chooseLanguage.getItemAt(chooseLanguage.getSelectedIndex()).toLowerCase();
            game.setTempLang(lang);
            main.goFromMenuToChosenLanguage();
        }
        else if (choice == help)
        {
            Help.display("Menu");
        }
    }

}
