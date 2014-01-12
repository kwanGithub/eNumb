/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Felix
 */
public class Game
{

    private UserList ul;
    private FileManager fm;
    private WordList tempWordlist;
    private ArrayList<WordList> tempWordSections;
    private String[] languages;
    private final int LEVEL1 = 8, LEVEL2 = 9, LEVEL3 = 10;
    private User tempUser;
    private String currentLanguage;
    private int score, level;
    private ArrayList<Word> tempWords;

    public Game()
    {

        fm = new FileManager();
        ul = new UserList();
        ul = fm.readUserFiles();
        languages = fm.readLangFile();
        score = 0;

    }

    public String[] getUserList()
    {

        return ul.showList();
    }

    public User getUser(String user)
    {

        return ul.getUser(user);

    }

    public String getUserInformation(String username, int choice) throws NullPointerException
    {

        User user = getUser(username);

        switch (choice)
        {

            case 1:
                return user.getfirstname();

            case 2:
                return user.getlastname();

            case 3:
                return user.getPassword();

            case 4:
                String s = "";
                s += user.getHightScore();
                return s;

            case 5:
                String r = "";
                r += user.getTotalScore();
                return r;

            default:
                return "du har gjort fel";

        }

    }

    /**
     * Compares the given password with the actual password of the requested user.
     *
     * @param username
     * @param password
     * @return
     */
    public boolean checkPassword(String username, String password)
    {

        User user = getUser(username);

        if (user.getPassword().equals(password))
        {
            return true;
        }
        else
        {

            return false;
        }
    }

    /**
     *
     * Adds a new User and returns true if successful and false if not.
     *
     * @param fName
     * @param lName
     * @param pw1
     * @param pw2
     * @return
     */
    public boolean addNewUser(String fName, String lName, String pw1, String pw2)
    {

        if (pw1.equals(pw2))
        {
            User newUser = new User(new String[]
            {
                fName, lName, pw1
            });
            ul.addUser(newUser);
            fm.writeUserFile(newUser);
            return true;
        }
        else
        {
            return false;
        }

    }

    public void createWordList(String fileName, String lang, String[] words)
    {

        tempWordlist = new WordList(fileName);

        for (int i = 0; i < 20; i++)
        {
            if (i % 2 == 0 || i == 0)
            {
                tempWordlist.addNewWord(words[i], words[i + 1], lang);
            }
        }
        fm.writeWordFile(tempWordlist);

    }

    public WordList getWordList(String fileName)
    {
        
        for (WordList w : tempWordSections)
        {

            if (fileName.equals(w.getName()))
            {
                return w;
            }
        }
        return null;
    }

    public String[] getListOfLanguages()
    {

        languages = fm.readLangFile();
        return languages;
    }

    public void setLanguageList(String[] langs)
    {

        languages = langs;
        fm.writeLangList(langs);

    }

    public void addNewLanguage(String newLang)
    {

        int index = languages.length;
        String[] temp = new String[index + 1];
        for (int i = 0; i < index; i++)
        {
            temp[i] = languages[i];
            System.out.println(temp[i]);
        }
        temp[index] = newLang;
        System.out.println(temp[index]);

        fm.writeLangList(temp);
    }

    private void getwordSections(String lang)
    {

        tempWordSections = fm.getAllListsOfLang(lang);
    }

    public String[] getListOfLanguageSections()
    {

        getwordSections(currentLanguage);

        String[] filenames = new String[tempWordSections.size()];

        for (int i = 0; i < tempWordSections.size(); i++)
        {
            filenames[i] = tempWordSections.get(i).getName();
        }

        return filenames;
    }

    public void setWordlist(String wordSection)
    {
        
        tempWordlist = getWordList(wordSection);
        

        listAllWords();

        

    }
    
    public void setLevel(int level){
        
        switch (level)
        {

            case 0:
                this.level = LEVEL1;
                break;
            case 1:
                this.level = LEVEL2;
                break;
            case 2:
                this.level = LEVEL3;
        }
        
    }

    public boolean checkWord(int i, String s)
    {
        if (tempWordlist.getWord(i)[1].equals(s))
        {
            score += level;
            return true;
        }
        else
        {
            return false;
        }
    }

    public String[] getWord(int index)
    {
        return tempWordlist.getWord(index);
    }

    public int getScore()
    {

        return score;
    }

    public void saveScore(int score)
    {
        
        tempUser.setTotalScore(tempUser.getTotalScore() + score);

        if (score > tempUser.getHightScore())
        {
            tempUser.setHighscore(score);
        }
        fm.writeUserFile(tempUser);

    }

    private void listAllWords()
    {

        tempWords = new ArrayList<>();

        for (WordList w : tempWordSections)
        {

            tempWords.addAll(w.getWords());
            System.out.println(w.getName());
        }
    }

    public String getRandomAnswer(String notThisWord)
    {

        Collections.shuffle(tempWords);
        int index = 0;

        while (notThisWord.equals(tempWords.get(index).getFor()))
        {
            index++;
        }

        return tempWords.get(index).toStringArray()[1];
    }

    public boolean usernameAvailable(String username)
    {

        return ul.nameAvailable(username);
    }

    public void setUser(String user)
    {

        tempUser = ul.getUser(user);

    }
    
    public void setChosenLanguage(String lang){
        
        tempWordSections = fm.getAllListsOfLang(lang);
           
    }
    
    public void setTempLang(String lang){
        
        currentLanguage = lang;
    }
    
    public String getCurrentLanguage(){
        
        return currentLanguage;
    }

}
