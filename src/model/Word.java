/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Felix
 */
public class Word
{

    private final String swedishWord, foreginWord, language;

    public Word(String sw, String fw, String lang)
    {

        swedishWord = sw;
        foreginWord = fw;
        language = lang;

    }

    public String getSwed()
    {
        return swedishWord;
    }

    public String getFor()
    {
        return foreginWord;
    }

    public String getLang()
    {
        return language;
    }

    public String[] toStringArray()
    {

        String[] stringAr = new String[]
        {
            swedishWord, foreginWord, language
        };
        return stringAr;
    }

}
