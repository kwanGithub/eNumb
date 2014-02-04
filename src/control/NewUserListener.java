package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Game;
import model.UserList;
import view.Enumb;

/**
 * This class is for handling the events of a button click for the newUser class When the button is triggred data will be sent to model
 *
 * @author kevin
 */
public class NewUserListener implements ActionListener
{

    private JTextField firstName, lastName, password, password_2;

    private JButton save, cancel;

    private Enumb main;
    private Parser parser;
    private UserList userlist;
    private Game game;
    private JComboBox<String> name;

    /**
     * Consructor
     *
     * @param firstName Register firstname textfield
     * @param lastName Register lastname textfield
     * @param password Register password textfield
     * @param password_2 Retyped password textfield
     * @param save Save button
     * @param cancel Cancel button
     * @param main Sets view
     */
    public NewUserListener(JTextField firstName, JTextField lastName, JTextField password, JTextField password_2, JButton save, JButton cancel, Enumb main)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.password_2 = password_2;
        this.save = save;
        this.cancel = cancel;
        this.main = main;
        parser = MainFactory.getParser();
        game = parser.getGame();

    }

    public NewUserListener()
    {

    }

    /**
     * Validates the fields before registering a new user
     *
     * @param first Register firstname field
     * @param last Register lastname field
     * @param pass Register password field
     * @param pass2 Retyping password field
     */
    public boolean addNewUser(String first, String last, String pass, String pass2)
    {
        if (!Parser.verifyNoEmptyFieldsRegistering(first, last, pass, pass2))
        {
            JOptionPane.showMessageDialog(null, "Alla fält måste vara ifyllda");
            return false;
        }
        else if (!Parser.validateUserInput(first) == true && Parser.validateUserInput(last))
        {
            JOptionPane.showMessageDialog(null, "Fler än 24 tecken är ej tillåtet");
        }
        else if (!Parser.passwordCheck(pass, pass2))
        {
            JOptionPane.showMessageDialog(null, "Lösenorden måste vara identiska");
        }
        else if (!parser.userExists(first, last))
        {
            JOptionPane.showMessageDialog(null, "Användaren finns redan");
        }
        else
        {
            first = parser.cleanUp(first);
            last = parser.cleanUp(last);
            pass = parser.cleanUp(pass);

            game.addNewUser(first, last, pass, pass);
            JOptionPane.showMessageDialog(null, "Grattis, du är nu registrerad användare i eNumb");
            main.logOutUser();
            return true;
        }
        return false;
    }

    /**
     * Set the registerng fiels empty
     */
    public void emptyFields()
    {
        firstName.setText("");
        lastName.setText("");
        password.setText("");
        password_2.setText("");
    }

    /**
     * Lister events for button choice
     *
     * @param e listener source
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object choice = (e.getSource());
        if (choice == save)
        {
            String first = this.firstName.getText();
            String last = this.lastName.getText();
            String pass = this.password.getText();
            String pass2 = this.password_2.getText();
            if (addNewUser(first, last, pass, pass2))
            {
                main.logOutUser();
            }
            else
            {
                main.goFromLoginToNewUser();
            }
            //updates the userlist
            emptyFields();

            //main.logOutUser();
        }
        else if (choice == cancel)
        {
            main.logOutUser();
            emptyFields();
        }

    }
}
