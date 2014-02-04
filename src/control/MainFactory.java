/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import model.Game;
import view.Enumb;

/**
 * Project main
 *
 * @author Felix
 */
public class MainFactory
{

    private static Parser parser;

    public static void main(String[] args)
    {

        Game game = new Game();
        parser = new Parser(game);

        try
        {
            Enumb enumb = new Enumb();
        }
        catch (IOException e)
        {
        }

    }

    public static Parser getParser()
    {
        return parser;
    }

}
