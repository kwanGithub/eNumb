/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.NewUserListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

/**
 *
 * @author Viktor
 */
public class NewUser extends JPanel
{

    private JTextField firstName, lastName, password, password_2;
    ;
    //private JPasswordField
    private JButton save, cancel;
    private JLabel registerNew, firstNameLabel, lastNameLabel, passwordLabel, passwordLabel_2;
    private JPanel mainPanel;
    private Enumb main;
    private ValidationPanel panel;
    private ValidationGroup group;

    public NewUser(Enumb jf)
    {

        //new JPanels
        mainPanel = new JPanel();
        panel = new ValidationPanel();

        //new JLabels
        registerNew = new JLabel("Ny användare");
        firstNameLabel = new JLabel("Förnamn: ");
        lastNameLabel = new JLabel("Efternamn: ");
        passwordLabel = new JLabel("Lösenord: ");
        passwordLabel_2 = new JLabel("Upprepa lösenord: ");

        //new JTextFields
        firstName = new JTextField();
        lastName = new JTextField();

        //new PasswordFields
        password = new JPasswordField();
        password_2 = new JPasswordField();

        //new JButtons
        save = new JButton("Spara");
        cancel = new JButton("Avbryt");

        main = jf;

        NewUserListener listener = new NewUserListener(firstName, lastName, password, password_2, save, cancel, main);

        //Listeners
        save.addActionListener(listener);
        cancel.addActionListener(listener);

        //Layout settings
        setLayout(new FlowLayout());

        //Font settings
        Font font = new Font("century gothic", Font.BOLD, 25);
        registerNew.setFont(font);

        //border
        mainPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        cancel.setBorder(BorderFactory.createRaisedBevelBorder());
        save.setBorder(BorderFactory.createRaisedBevelBorder());

        //Background settings
        setBackground(Color.DARK_GRAY);
        cancel.setBackground(new Color(240, 240, 240));
        save.setBackground(new Color(240, 240, 240));

        //Size settings
        setPreferredSize(new Dimension(512, 680));
        cancel.setPreferredSize(new Dimension(100, 30));
        save.setPreferredSize(new Dimension(100, 30));
        mainPanel.setPreferredSize(new Dimension(400, 500));
        registerNew.setPreferredSize(new Dimension(300, 100));
        firstNameLabel.setPreferredSize(new Dimension(300, 30));
        firstName.setPreferredSize(new Dimension(300, 30));
        lastNameLabel.setPreferredSize(new Dimension(300, 30));
        lastName.setPreferredSize(new Dimension(300, 30));
        passwordLabel.setPreferredSize(new Dimension(300, 30));
        password.setPreferredSize(new Dimension(300, 30));
        passwordLabel_2.setPreferredSize(new Dimension(300, 30));
        password_2.setPreferredSize(new Dimension(300, 30));

        registerNew.setHorizontalAlignment(SwingConstants.CENTER);

        //Addings
        add(Box.createRigidArea(new Dimension(500, 70)));
        mainPanel.add(registerNew);
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstName);
        mainPanel.add(Box.createRigidArea(new Dimension(500, 5)));
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastName);
        mainPanel.add(Box.createRigidArea(new Dimension(500, 5)));
        mainPanel.add(passwordLabel);
        mainPanel.add(password);
        mainPanel.add(Box.createRigidArea(new Dimension(500, 5)));
        mainPanel.add(passwordLabel_2);
        mainPanel.add(password_2);
        mainPanel.add(Box.createRigidArea(new Dimension(500, 5)));
        mainPanel.add(save);
        mainPanel.add(Box.createRigidArea(new Dimension(50, 30)));
        mainPanel.add(cancel);

        group = panel.getValidationGroup();
        group.add(firstName, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(firstName, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(lastName, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(password, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(password_2, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));

        add(mainPanel);

    }

}
