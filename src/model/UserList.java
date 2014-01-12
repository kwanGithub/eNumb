/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class UserList
{

    private ArrayList<User> userlist;

    public UserList()
    {
        userlist = new ArrayList<User>();

    }

    public void addUser(String[] s)
    {
        userlist.add(new User(s[0], s[1], s[2]));
    }

    public void addUser(User user)
    {

        userlist.add(user);

    }

    public int getSize()
    {
        return userlist.size();
    }

    public User getUser(int i)
    {
        int index = i;
        return userlist.get(index);
    }

    public User getUser(String s)
    {

        for (User u : userlist)
        {
            if (u.getUsername().equals(s))
            {
                return u;
            }
        }
        return null;
    }

    public void removUser(int i)
    {
        userlist.remove(i);
    }

    public String[] showList()
    {

        ArrayList<String> tempList = new ArrayList<>();

        for (User u : userlist)
        {
            tempList.add(u.getUsername());

        }

        String[] listOfNames = new String[tempList.size()];

        for (int i = 0; i < tempList.size(); i++)
        {
            listOfNames[i] = tempList.get(i);
        }
        // System.out.println(listOfNames[0]);

        return listOfNames;
    }
 

    public boolean nameAvailable(String username) {
        
        for(User u : userlist ){
            if(u.getUsername().equals(username)){
                return false;
            }
        }
          
                return true;
    }

}
