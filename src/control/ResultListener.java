/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Game;
import view.Enumb;
import view.Help;

/**
 * Result class controller
 *
 * @author kevin
 */
public class ResultListener implements ActionListener
{

    private JButton menu, help, quit;
    private Enumb main;
    private Parser parser;
    private Game game;

    /**
     * class constructor
     *
     * @param menu menu button
     * @param help help button
     * @param quit quit button
     * @param main enum view
     */
    public ResultListener(JButton menu, JButton help, JButton quit, Enumb main)
    {
        this.menu = menu;
        this.help = help;
        this.quit = quit;
        this.main = main;

        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());

        if (choice == menu)
        {
            main.goFromLogin();
        }
        else if (choice == help)
        {
            Help.display("Result");
        }
        else if (choice == quit)
        {
            System.exit(0);
        }
    }

    public String getPoints()
    {

        return "" + game.getScore();
    }

    public String getScore()
    {
        return "" + (game.getScore() * game.getLevel());
    }

    public String getTotalScore()
    {
        return "" + game.getTotalScore();
    }

    public String betterOrWorse()
    {

        int newScore = (game.getScore() * game.getLevel());
        int oldScore = game.getHighscore();
        if (newScore < oldScore)
        {
            return "" + (oldScore - newScore) + "mindre";
        }
        else if (newScore > oldScore)
        {
            return "" + (newScore - oldScore) + "mer";
        }
        else
        {
            return "varken mer eller mindre";
        }
    }

    public String percentage()
    {

        int perc = (game.getScore() * 10);
        System.out.println(perc);
        return "" + perc;

    }

    public String getHighscore()
    {
        return "" + game.getHighscore();
    }

}
