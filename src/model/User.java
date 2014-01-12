/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kevin
 */
public class User
{

    private String username, firstname, lastname, password;
    private int Highscore;
    private int TotalScore;

    public User(String firstname, String lastname, String password)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = firstname + " " + lastname;
    }

    public User(String[] s)
    {
        firstname = s[0];
        lastname = s[1];
        password = s[2];
        username = s[0] + " " + s[1];
    }

    public String getfirstname()
    {
        return this.firstname;
    }

    public String getlastname()
    {
        return this.lastname;
    }

    public String getPassword()
    {
        return password;
    }

    public void setHighscore(int i)
    {
        this.Highscore = i;
    }

    public void setTotalScore(int i)
    {
        this.TotalScore = i;
    }

    int getHightScore()
    {
        return this.Highscore;
    }

    int getTotalScore()
    {
        return this.TotalScore;
    }

    public String getUsername()
    {
        return username;
    }
}
