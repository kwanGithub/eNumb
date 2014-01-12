/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.Enumb;
import view.Help;

/**
 *
 * @author kevin
 */
public class ResultListener implements ActionListener
{

    private JButton menu, help, quit;
    private Enumb main;

    public ResultListener(JButton menu, JButton help, JButton quit, Enumb main)
    {
        this.menu = menu;
        this.help = help;
        this.quit = quit;
        this.main = main;
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

}
