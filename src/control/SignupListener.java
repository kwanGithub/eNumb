/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;

/**
 *
 * @author Magnum
 */
public class SignupListener
{

    private String firstName;
    private String lastName;
    private String password;
    private String passwordRetype;
    private Game game;
    private Parser parser;

    public SignupListener(String firstName, String lastName, String password, String passwordRetype)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordRetype = passwordRetype;

        addNewUser(firstName, lastName, password, password);
        parser = MainFactory.getParser();
        game = parser.getGame();
    }

    public void addNewUser(String firstName, String lastName, String password, String passwordRetype)
    {

    }

}
