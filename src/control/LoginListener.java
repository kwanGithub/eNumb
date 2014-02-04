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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Game;
import view.Enumb;

/**
 * This class handles the login actions, and sends the user to the new user section
 *
 * @author kevin
 */
public class LoginListener implements ActionListener
{

    private final JComboBox<String> name;

    private final JTextField password;
    private final JButton logIn, newUser;
    private final Enumb main;

    private Parser parser;
    private Game game;

    /**
     * Constructor
     *
     * @param name List of registerd users
     * @param password Enterd password
     * @param logIn Login button
     * @param newUser NewUser button
     * @param main Enumb class
     */
    public LoginListener(JComboBox<String> name, JTextField password, JButton logIn, JButton newUser, Enumb main)
    {
        this.name = name;
        this.password = password;
        this.logIn = logIn;
        this.newUser = newUser;
        this.main = main;
        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    public LoginListener()
    {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Verfiys userName and userPassword if match user logs in
     *
     * @param userName chosen username from checkbox
     * @param password enterd password
     */
    public void verifyUserAndPassword(String userName, String password)
    {
        if (Parser.validateUserInput(userName) && Parser.validateUserInput(password) == true)

        {
            if (game.checkPassword(userName, password) == true)
            {
                game.setUser(userName);
                main.goFromLogin();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Fel lösenord, försök igen");

            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Något gick fel, försök igen");
        }
    }

    /**
     * Button actions
     *
     * @param e When button is triggerd
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());

        if (choice == logIn)
        {

            String userName = name.getSelectedItem().toString();
            String userPass = password.getText();

            verifyUserAndPassword(userName, userPass);
            password.setText("");

           // main.goFromLogin();
        }
        else if (choice == newUser)
        {
            main.goFromLoginToNewUser();
            password.setText("");

        }
    }
}
