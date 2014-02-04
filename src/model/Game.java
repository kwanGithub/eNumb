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

    /**
     * @return returns with String Array of all registered users.
     */
    public String[] getUserList()
    {

        return ul.showList();
    }

    /**
     * @param user The name of the wanted User object.
     * @return Returns a User object from the UserList.
     */
    public User getUser(String user)
    {

        return ul.getUser(user);

    }


    /**
     * Compares the given password with the actual password of the requested user object.
     *
     * @param username The name of the user that wants to log in.
     * @param password The password that the user tries to log in with.
     * @return Returns true if password is correct, false if not.
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
     * Adds a new User and returns true if successful and false if not.
     * The passwords must be identical for the User object to be created.
     *
     * @param fName First name.
     * @param lName Last name.
     * @param pw1 Password, first typing.
     * @param pw2 password, second typing.
     * @return returns true if the registration is successful.
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

    /**
     * Creates a new WordList object, saves and writes it to file.
     * 
     * @param fileName The name of the wordList.
     * @param lang The language that the words are in.
     * @param words The array containing the swedish and foreign words.
     */
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
        
        tempWordSections.add(tempWordlist);
        fm.writeWordFile(tempWordlist);
        
    }

    
    /**
     * Find a wordList object in the list.
     * @param fileName The name of the wanted wordList.
     * @return Returns teh wordlist.
     */
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

    
    /**
     * 
     * @return Returns the List of all added languages, as an array.
     */
    public String[] getListOfLanguages()
    {

        languages = fm.readLangFile();
        return languages;
    }

    
    /**
     * Sets the temporary language to work with.
     * @param langs The wanted language.
     */
    public void setLanguageList(String[] langs)
    {

        languages = langs;
        fm.writeLangList(langs);

    }

    
    /**
     * Adds a new language to the language list.
     * @param newLang The wanted language to add.
     */
    public void addNewLanguage(String newLang)
    {

        int index = languages.length;
        String[] temp = new String[index + 1];
        for (int i = 0; i < index; i++)
        {
            temp[i] = languages[i];
           // System.out.println(temp[i]);
        }
        temp[index] = newLang;
        //System.out.println(temp[index]);

        fm.writeLangList(temp);
    }

    
    /**
     * Sets the list of wordlists.
     * @param lang the wanted language..
     */
    private void getwordSections(String lang)
    {

        tempWordSections = fm.getAllListsOfLang(lang);
        
    }

    
    /**
     * @return Returns the list of all available wordlist, as an array.
     */
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

    
    /**
     * Sets the wanted worsList to work with, and shuffles it.
     * @param wordSection The name of the wanted section.
     */
    public void setWordlist(String wordSection)
    {
        
        tempWordlist = getWordList(wordSection);
        tempWordlist.shuffleList();

        listAllWords();

    }
    
    
    /**
     * sets the difficulty level.
     * @param level the wanted level.
     */
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

    
    /**
     * Check if the answer is correct 
     * @param index The current index in the wordlist.
     * @param answer The typed answer from the user.
     * @return returns true if correct.
     */
    public boolean checkWord(int index, String answer)
    {
        if (tempWordlist.getWord(index)[1].equals(answer))
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
        this.score = score;
        
        int gameScore = level * score;
        
        tempUser.setTotalScore(tempUser.getTotalScore() + gameScore);

        if (gameScore > tempUser.getHightScore())
        {
            tempUser.setHighscore(gameScore);
        }
        fm.writeUserFile(tempUser);

    }

    private void listAllWords()
    {

        tempWords = new ArrayList<>();

        for (WordList w : tempWordSections)
        {

            tempWords.addAll(w.getWords());
            //System.out.println(w.getName());
        }
    }

    public String getRandomAnswer(String notThisWord)
    {
        try{
        Collections.shuffle(tempWords);
        int index = 0;

        while (notThisWord.equals(tempWords.get(index).getFor()))
        {
            index++;
        }
        
        return tempWords.get(index).toStringArray()[1];
        }
        catch(Exception e){
            return "";
        }
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
    
    public int getLevel(){
        
        return level;
        
    }
    
    public int getTotalScore(){
        
        return tempUser.getTotalScore();
        
    }
    
    public int getHighscore(){
        
        return tempUser.getHightScore();
        
    }

}
