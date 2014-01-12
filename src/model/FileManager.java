/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.io.*;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class FileManager
{

    File tempFile;
    Scanner scanner;
    File wordDirectory = new File("data\\words");
    File[] wordfiles = wordDirectory.listFiles();
    File userDirectory = new File("data\\users");
    File[] userfiles = userDirectory.listFiles();
    ArrayList<WordList> wordSections;
    
    public FileManager(){
        
        wordSections = new ArrayList<>();
      
    }

 

    public void writeUserFile(User user)
    {

        User tempUser = user;

        tempFile = new File("data\\users\\" + tempUser.getUsername() + ".txt");
        tempFile.getParentFile().getParentFile().mkdirs();
        tempFile.getParentFile().mkdirs();

         PrintWriter writer = null;
        try
        {
            writer = new PrintWriter(tempFile);
            writer.println(tempUser.getfirstname());
            writer.println(tempUser.getlastname());
            writer.println(tempUser.getPassword());
            writer.println(tempUser.getHightScore());
            writer.println(tempUser.getTotalScore());
            
        }
        catch (Exception e){}
        finally {
            if (writer != null) {
            writer.close();
            }
        }

    }
    
    public UserList readUserFiles()
    {
      
        UserList userlist = new UserList();
        int index = 0;

        while (index < userfiles.length)
        {
            userlist.addUser(readLines(userfiles[index], 5));
            index++;
        }
        return userlist;
    }
    

    void removeUserFile(String fileName)
    {

        File removeFile = new File("data\\users\\" + fileName + ".txt");
        removeFile.delete();

    }
    
    
    
    public void writeWordFile(WordList wl)
    {

        tempFile = new File("data\\words\\" + wl.getName() + ".txt");
        tempFile.getParentFile().getParentFile().mkdirs();
        tempFile.getParentFile().mkdirs();

        try
        {
            PrintWriter writer = new PrintWriter(tempFile);
            writer.println(wl.getLang());
            for (int i = 0; i < 10; i++)
            {
                String[] s = wl.getWord(i);
                writer.println(s[0]);
                writer.println(s[1]);
            }
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("write failed");
        }
    }
    
    public WordList readWordFile(File filename)
    {

        String name = filename.getName();
        String newName = name.substring(0, name.length()-4);
        
        File actualFile = new File("data\\words\\" + filename.getName());
        
        WordList words = new WordList(newName);
        String[] allLines = readLines(actualFile, 21);        
        String lang = allLines[0];
        
        for (int i = 1; i < 21; i++)
        {
            if( i % 2 == 0 ){
            words.addNewWord(allLines[i-1], allLines[i], lang);
               // System.out.println(allLines[i-1] + " " + allLines[i]);
            }
        }
       
        return words;
    }
    
    public void removeWordFile(String fileName)
    {

        File removeFile = new File("data\\words\\" + fileName + ".txt");
        removeFile.delete();

    }
    
    
    
    private void readAllWordFiles(){
           
        for (int i = 0; i < wordfiles.length; i++) {        
           
            wordSections.add(readWordFile(wordfiles[i]));  
            
        }  
    }
    
    public String[] getListOfWordSections(){
        
        readAllWordFiles();
        
        String[] sections = new String[wordSections.size()];
        
        for (int i = 0; i < wordSections.size(); i++) {
            
            sections[i] = wordSections.get(i).getName();  
        }
        
        return sections;
    }

    public ArrayList<WordList> getAllListsOfLang(String lang) {
        
        readAllWordFiles();
       
        ArrayList<WordList> tempList = new ArrayList<>();
        
        for(WordList w : wordSections){
            
            if(w.getLang().equals(lang)){
                tempList.add(w);               
            } 
        }
        
        return tempList;
        
    }
    

    public void writeLangList(String[] langs) {
       
        try{
        PrintWriter writer = new PrintWriter("data//langs.txt");
            for (int i = 0; i < langs.length; i++) {
                writer.println(langs[i]);
            }
            writer.close();
        }
        catch(Exception e){}
  
    }

    public String[] readLangFile() {
        
        String temp = "";
        try{
        scanner = new Scanner(new File("data//langs.txt"));
        while(scanner.hasNext()){
            temp += scanner.nextLine() + " ";
            }
            scanner.close();
        return temp.split(" ");
        }
        catch(Exception e){}
        return null;
    }
   
    public String[] readLines(File file, int rows){
        
        String[] temp = new String[rows];
        
        try{
        scanner = new Scanner(file);   
            for (int i = 0; i < rows; i++) {
                temp[i] = scanner.nextLine().trim().toLowerCase();
            }    
        }
        catch(Exception e){
        }         
        return temp;
    }
    
    
    
    
    
    
    
  
}
