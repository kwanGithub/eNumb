/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class WordList
{

    private ArrayList<Word> words;
    private String fileName;

    public WordList(String name)
    {
        words = new ArrayList<Word>();
        fileName = name;
    }

    void addNewWord(String sw, String fw, String lang)
    {
        Word temp = new Word(sw, fw, lang);
        words.add(temp);

    }

    public String[] getWord(int i)
    {
      
        return words.get(i).toStringArray();
    }
    
    public ArrayList<Word> getWords(){
        
        return words;
    }

    public int getListSize()
    {
        return words.size();
    }

    void removeWord(int i)
    {

        words.remove(i);
    }

    public String getLang()
    {

        return words.get(0).getLang();
    }

    public String getName()
    {

        return fileName;
    }

}
