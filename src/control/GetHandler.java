/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;

/**
 *
 * @author kevin
 */
public class GetHandler
{

    Game game;

    public GetHandler()
    {
        game = new Game();
    }

    public String[] getUserList()

    {
        return game.getUserList();

    }

    public String[] getWordList()
    {
        return null; // game.getListOfLanguageSections("engelska");

    }

}
