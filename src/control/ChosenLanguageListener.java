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
import javax.swing.JPanel;
import model.Game;
import view.Enumb;
import view.Help;

/**
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

    public ChosenLanguageListener(JLabel chooseWeekText, JLabel addNewWeekText, 
            JComboBox section, JButton help, JButton addNewSection, JButton back, 
            Enumb main, JButton commit)
    {
        this.chooseWeekText = chooseWeekText;
        this.addNewWeekText = addNewWeekText;
        this.section = section;
        this.help = help;
        this.addNewSection = addNewSection;
        this.back = back;
        this.main = main;
        this.commit = commit;
        
        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    public ChosenLanguageListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
            game.setWordlist(section.getItemAt(section.getSelectedIndex()));
            main.goFromChosenLanguageToDifficulty();
        }
        else if(choice == addNewSection){
            main.goFromChosenLanguageToAddNewSection();
        }
    }
    
    public void getSectionList(){
               
        
        String[] temp = game.getListOfLanguageSections();
        for (int i = 0; i < temp.length; i++) {
            section.addItem(temp[i]);
            
        }
        
        section.updateUI();
    }

}
