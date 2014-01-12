/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adrian
 */
public class Help extends JPanel
{

    public static void display(String helpRequest)
    {

        String helpMessage = new String();
        //create textarea, set editable and add to panel
        switch (helpRequest)
        {
            case "Menu":
                helpMessage = ("Om det språket du vill arbeta med finns i listan uppe till" + "\n"
                        + "vänster, markera det och klicka på nästa för att börja." + "\n" + "\n"
                        + "Om det inte finns i listan så klicka på lägg till språk" + "\n"
                        + "nere i vänstra hörnet för att lägga till ett nytt språk.");
                break;
            case "ChosenLanguage":
                helpMessage = ("Här väljer du antingen vilken vecka du vill förhöra" + "\n"
                        + "eller så lägger du till nya ord för en ny vecka.");
                break;
            case "GameRun":
                helpMessage = ("Nu har förhöret precis börjat, lycka till med att skriva de rätta översättningarna.");
                break;
            case "Result":
                helpMessage = ("Här visas statistik om den senaste rundan");
                break;
        }

        JOptionPane.showMessageDialog(null, helpMessage, "Hjälp",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
