/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Game;
import view.Enumb;

/**
 * Controller for levelofdiffculty class
 *
 * @author kevin
 */
public class LevelOfDiffucltyListener implements ActionListener, ChangeListener
{

    private JPanel container;
    private JLabel chooseDifficultyText;
    private JSlider slider;
    private JButton back, go;
    private Enumb main;
    private int fps;
    private Parser parser;
    private Game game;

    /**
     * Class Constructor
     *
     * @param chooseDifficultyText Diffculty text
     * @param slider Slider
     * @param back backbutton
     * @param go gobutton
     * @param main enumb view
     */
    public LevelOfDiffucltyListener(JLabel chooseDifficultyText, JSlider slider, JButton back, JButton go, Enumb main)
    {
        this.container = container;
        this.chooseDifficultyText = chooseDifficultyText;
        this.slider = slider;
        this.back = back;
        this.go = go;
        this.main = main;

        parser = MainFactory.getParser();
        game = parser.getGame();

    }

    public LevelOfDiffucltyListener()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * slider events
     *
     * @param e event
     */
    @Override
    public void stateChanged(ChangeEvent e)
    {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting())
        {
            fps = (int) source.getValue();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == back)
        {
            main.goFromMenuToChosenLanguage();
        }
        else if (choice == go)
        {

            game.setLevel(fps);

            if (fps == 1 || fps == 0 || fps == 2)
            {
                main.goFromDifficultyToRunGame(fps);
            }
            else
            {
                System.out.println("JAHADUDETBLIDDEFEL");
            }
        }
    }

}
