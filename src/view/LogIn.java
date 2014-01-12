package view;

import control.GetHandler;
import control.LoginListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.HAND_CURSOR;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Viktor
 */
public class LogIn extends JPanel
{

    private final JComboBox<String> name;
    private final JLabel whatName, whatPassword;
    private final JTextField password;
    private final JButton logIn, newUser;
    private final Enumb main;
    private final JLayeredPane jPane;

    public LogIn(Enumb jf) throws IOException
    {

        //new Labels
        JLabel background = new JLabel(new ImageIcon("images\\background2new.png"));
        whatName = new JLabel("Vad är ditt namn?");
        whatPassword = new JLabel("Vad är ditt lösenord?");

        //new Buttons
        logIn = new JButton("Logga in");
        newUser = new JButton("Ny användare");

        //new ComboBoxes
        name = new JComboBox<>();

        //new LayeredPane
        jPane = new JLayeredPane();

        //new PasswordFields
        password = new JPasswordField(10);

        main = jf;

        //LoginListener
        LoginListener listener = new LoginListener(name, password, logIn, newUser, main);

        //adding ActionListeners
        logIn.addActionListener(listener);
        newUser.addActionListener(listener);

        //size settings
        setPreferredSize(new Dimension(512, 680));
        background.setSize(512, 680);
        jPane.setPreferredSize(new Dimension(512, 680));

        //location settings.
        password.setBounds(180, 165, 180, 30);
        name.setBounds(180, 130, 180, 30);
        logIn.setBounds(180, 200, 180, 30);
        newUser.setBounds(180, 235, 180, 30);
        whatName.setBounds(58, 130, 180, 30);
        whatPassword.setBounds(58, 165, 180, 30);

        //background settings.
        setBackground(new Color(235, 235, 235));
        name.setBackground(new Color(255, 255, 255));
        logIn.setBackground(new Color(240, 240, 240));
        newUser.setBackground(new Color(240, 240, 240));

        //layout settings
        setLayout(new FlowLayout());

        //Cursor settings.
        name.setCursor(new Cursor(HAND_CURSOR));
        logIn.setCursor(new Cursor(HAND_CURSOR));
        newUser.setCursor(new Cursor(HAND_CURSOR));

        //Adding stuff to the LayeredPane
        jPane.add(background, new Integer(1));
        jPane.add(logIn, new Integer(2));
        jPane.add(name, new Integer(3));
        jPane.add(password, new Integer(4));
        jPane.add(whatName, new Integer(5));
        jPane.add(newUser, new Integer(7));
        jPane.add(whatPassword, new Integer(8));

        add(jPane);//Adding to extended JPanel.
        updateList();

    }

    public void updateList()
    {
        //Adding items to the username comboBox. Just for show right now...
        name.removeAllItems();
        name.addItem("Välj användare");

        GetHandler handler = new GetHandler();
        String[] temp = handler.getUserList();

        for (int i = 0; i < temp.length; i++)
        {
            name.addItem(temp[i]);
        }
    }
}
