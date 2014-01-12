/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.*;

/**
 *
 * @author Adrian
 */
public class AddNewLanguage {
    
    public static void display() {
            
    Object[] possibilities = {"Franska", "Spanska"};

    String newLanguage = (String)JOptionPane.showInputDialog(null, "Välj vilket språk du vill lägga till:",
    "Ytterligare språk", JOptionPane.PLAIN_MESSAGE, null, possibilities, "Franska");
    
    if ((newLanguage != null) && (newLanguage.length() > 0)) {System.out.println("Du valde " + newLanguage + " !");}
        
    }
    
}