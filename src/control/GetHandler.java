/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Game;

/**
 * Handlig get request and creating game and parser
 *
 * @author kevin
 */
public class GetHandler
{

    Parser parser;
    Game game;

    public GetHandler()
    {
        Parser parser = MainFactory.getParser();
        game = parser.getGame();
    }

    /**
     * gets urser list
     *
     * @return userlist
     */
    public String[] getUserList()

    {
        return game.getUserList();

    }

    public String[] getWordList()
    {
        return null; // game.getListOfLanguageSections("engelska");

    }

}
