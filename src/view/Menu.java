/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MenuListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

/**
 *
 * @author Viktor
 */
public class Menu extends JPanel
{

    private JTextField newLanguageField;
    private JComboBox<String> chooseLanguage;
    private JButton addNewLanguage, help, quit, next, logOut;
    private JPanel containerW, containerE, topLine, centerPanel, bubblePanel, topPanel, bottomPanel;
    private JLabel topHeading, mascotLabel, mascotBubble, flagLabel;
    private Enumb main;
    private MenuListener listener;

    public Menu(Enumb jf)
    {

        //new textFields
        newLanguageField = new JTextField();

        //new Panels
        containerE = new JPanel();
        containerW = new JPanel();
        centerPanel = new JPanel();
        topLine = new JPanel();
        bubblePanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        //new Labels
        topHeading = new JLabel(new ImageIcon("images\\globe7.png"));
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratmenu.png"));
        flagLabel = new JLabel(new ImageIcon("images\\engelska.png"));

        //new Buttons
        addNewLanguage = new JButton("Lägg till nytt språk");
        help = new JButton("Hjälp");
        quit = new JButton("Avsluta");
        next = new JButton("Nästa");
        logOut = new JButton("Logga ut");

        //new ComboBoxes
        chooseLanguage = new JComboBox<String>();

        //new Font
        Font font = new Font("century gothic", Font.BOLD, 15);

        main = jf;

        //MenuListern
        listener = new MenuListener(newLanguageField, addNewLanguage, help, quit, next, logOut,
                main, chooseLanguage, flagLabel);

        //Adding ActionListeners
        addNewLanguage.addActionListener(listener);
        quit.addActionListener(listener);
        next.addActionListener(listener);
        chooseLanguage.addActionListener(listener);
        help.addActionListener(listener);
        logOut.addActionListener(listener);

        //Size settings.
        containerE.setPreferredSize(new Dimension(250, 900));
        containerW.setPreferredSize(new Dimension(250, 900));
        centerPanel.setPreferredSize(new Dimension(790, 890));
        topHeading.setPreferredSize(new Dimension(790, 500));

        bubblePanel.setPreferredSize(new Dimension(700, 250));
        mascotLabel.setPreferredSize(new Dimension(200, 300));
        mascotBubble.setPreferredSize(new Dimension(500, 280));

        flagLabel.setPreferredSize(new Dimension(250, 150));
        chooseLanguage.setPreferredSize(new Dimension(200, 30));
        newLanguageField.setPreferredSize(new Dimension(200, 30));
        addNewLanguage.setPreferredSize(new Dimension(200, 40));
        help.setPreferredSize(new Dimension(200, 40));
        quit.setPreferredSize(new Dimension(200, 40));
        next.setPreferredSize(new Dimension(200, 40));
        logOut.setPreferredSize(new Dimension(200, 40));

        //Background settings.
        containerE.setBackground(new Color(17, 54, 56));
        containerW.setBackground(new Color(184, 101, 0));
        topPanel.setBackground(new Color(184, 101, 0));
        bottomPanel.setBackground(new Color(17, 54, 56));
        chooseLanguage.setBackground(new Color(255, 255, 255));
        quit.setBackground(new Color(240, 240, 240));
        help.setBackground(new Color(240, 240, 240));
        addNewLanguage.setBackground(new Color(240, 240, 240));
        logOut.setBackground(new Color(240, 240, 240));
        next.setBackground(new Color(240, 240, 240));
        flagLabel.setBackground(new Color(240, 240, 240));

        //Border settings
        quit.setBorder(BorderFactory.createRaisedBevelBorder());
        next.setBorder(BorderFactory.createRaisedBevelBorder());
        chooseLanguage.setBorder(BorderFactory.createRaisedBevelBorder());
        addNewLanguage.setBorder(BorderFactory.createRaisedBevelBorder());
        help.setBorder(BorderFactory.createRaisedBevelBorder());
        logOut.setBorder(BorderFactory.createRaisedBevelBorder());
        containerW.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        containerE.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));

        //Font settings
        chooseLanguage.setFont(font);
        quit.setFont(font);
        help.setFont(font);
        logOut.setFont(font);
        addNewLanguage.setFont(font);
        next.setFont(font);

        //Layout settings.
        setLayout(new BorderLayout());
        bubblePanel.setLayout(new OverlayLayout(bubblePanel));

        //Adding to bubblePanel
        bubblePanel.add(Box.createRigidArea(new Dimension(390, 200)));
        bubblePanel.add(mascotBubble);

        //Adding to centerPanel
        centerPanel.add(Box.createRigidArea(new Dimension(790, 120)));
        centerPanel.add(topHeading);
        centerPanel.add(Box.createRigidArea(new Dimension(90, 80)));
        centerPanel.add(bubblePanel);

        //Adding to WEST container.
        containerW.add(Box.createRigidArea(new Dimension(250, 5)));
        containerW.add(flagLabel);
        containerW.add(chooseLanguage);

        containerW.add(next);
        containerW.add(Box.createRigidArea(new Dimension(250, 257)));
        containerW.add(newLanguageField);
        containerW.add(addNewLanguage);

        //Adding to EAST container.
        containerE.add(Box.createRigidArea(new Dimension(300, 180)));
        containerE.add(help);
        containerE.add(Box.createRigidArea(new Dimension(300, 265)));
        containerE.add(logOut);
        containerE.add(quit);
        containerE.add(mascotLabel);

        //Adding to main container.
        add(topPanel, BorderLayout.PAGE_START);
        add(bottomPanel, BorderLayout.PAGE_END);
        add(centerPanel, BorderLayout.CENTER);
        add(containerW, BorderLayout.LINE_START);
        add(containerE, BorderLayout.LINE_END);

        //Adding to comboBox
        listener.setDropDown();

    }

}
