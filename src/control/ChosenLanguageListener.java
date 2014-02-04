/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Game;
import view.Enumb;
import view.Help;

/**
 * Handles button and actions for ChosenLanguage view
 *
 * @author kevin
 */
public class ChosenLanguageListener implements ActionListener
{

    private JLabel chooseWeekText, addNewWeekText;
    private JPanel container;
    private JComboBox<String> section;
    private JButton help, addNewSection, back, commit;
    private Enumb main;
    private Parser parser;
    private Game game;

    /**
     * Class consctructor
     *
     * @param chooseWeekText Filename for list file
     * @param section ComboBox JText options
     * @param help hel pbutton
     * @param addNewSection NewSection button
     * @param back back button
     * @param main enumb view
     * @param commit commit button
     */
    public ChosenLanguageListener(JLabel chooseWeekText,
            JComboBox section, JButton help, JButton addNewSection, JButton back,
            Enumb main, JButton commit)
    {
        this.chooseWeekText = chooseWeekText;
        this.section = section;
        this.help = help;
        this.addNewSection = addNewSection;
        this.back = back;
        this.main = main;
        this.commit = commit;

        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    /**
     * Actions when button is triggerd
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object choice = (e.getSource());
        if (choice == help)
        {
            Help.display("ChosenLanguage");
        }
        else if (choice == back)
        {
            main.goFromLogin();
        }
        else if (choice == commit)
        {
            if (section.getItemAt(section.getSelectedIndex()) != null)
            {
                game.setWordlist(section.getItemAt(section.getSelectedIndex()));
                main.goFromChosenLanguageToDifficulty();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Det verkar inte finnas några gloslistor för det här språket. \nLägg till en ny och försök igen");
            }
        }
        else if (choice == addNewSection)
        {
            main.goFromChosenLanguageToAddNewSection();
        }
    }

    /**
     * Loads the section list with wordLists
     */
    public void getSectionList()
    {

        try
        {
            String[] temp = game.getListOfLanguageSections();
            for (int i = 0; i < temp.length; i++)
            {
                section.addItem(temp[i]);

            }
        }
        catch (Exception e)
        {
        }

        section.updateUI();
    }

}
