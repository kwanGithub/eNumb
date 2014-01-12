/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ChosenLanguageListener;
import control.GetHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Viktor
 */
public class ChosenLanguage extends JPanel
{

    private JLabel chooseWeekText, addNewWeekText, mascotLabel, mascotBubble;
    private JPanel leftPanel, rightPanel, centerPanel, bubblePanel;
    private JComboBox section;
    private JButton help, addNewSection, back, commit;
    private Enumb main;
    private ChosenLanguageListener listener;

    public ChosenLanguage(Enumb jf)
    {

        //new Labels
        chooseWeekText = new JLabel("Välj vecka:");
        addNewWeekText = new JLabel("Lägg till ny vecka:");
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratsection.png"));

        //new Buttons
        help = new JButton("Hjälp");
        addNewSection = new JButton("Lägg till ny sektion");
        back = new JButton("Tillbaka");
        commit = new JButton("Nästa");

        //new Panels
        centerPanel = new JPanel(new FlowLayout());
        bubblePanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        //new ComboBoxes
        section = new JComboBox();

        //new Fonts
        Font font = new Font("century gothic", Font.BOLD, 15);
        Font font2 = new Font("century gothic", Font.BOLD, 20);

        main = jf;

        //ChosenLanguageListener
        listener = new ChosenLanguageListener(chooseWeekText, addNewWeekText, 
                section, help, addNewSection, back, main, commit);

        //Size settings
        help.setPreferredSize(new Dimension(200, 40));
        back.setPreferredSize(new Dimension(200, 40));
        addNewWeekText.setPreferredSize(new Dimension(200, 40));
        addNewSection.setPreferredSize(new Dimension(200, 40));
        chooseWeekText.setPreferredSize(new Dimension(600, 50));
        section.setPreferredSize(new Dimension(300, 30));
        centerPanel.setPreferredSize(new Dimension(500, 200));
        leftPanel.setPreferredSize(new Dimension(250, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));
        mascotLabel.setPreferredSize(new Dimension(200, 300));
        mascotBubble.setPreferredSize(new Dimension(500, 280));
        bubblePanel.setPreferredSize(new Dimension(790, 290));

        //Background settings
        setBackground(new Color(5, 255, 255));
        section.setBackground(new Color(255, 255, 255));
        leftPanel.setBackground(new Color(163, 42, 15));
        rightPanel.setBackground(new Color(240, 90, 40));
        help.setBackground(new Color(240, 240, 240));
        back.setBackground(new Color(240, 240, 240));
        addNewSection.setBackground(new Color(240, 240, 240));

        //Layout settings
        setLayout(new BorderLayout());

        //Border settings
        centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        leftPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        rightPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
        help.setBorder(BorderFactory.createRaisedBevelBorder());
        back.setBorder(BorderFactory.createRaisedBevelBorder());
        addNewSection.setBorder(BorderFactory.createRaisedBevelBorder());

        //Font settings
        chooseWeekText.setFont(font2);
        chooseWeekText.setHorizontalAlignment(SwingConstants.CENTER);
        addNewSection.setFont(font);
        addNewWeekText.setFont(font2);
        help.setFont(font);
        back.setFont(font);

        
        

        //Addings
        bubblePanel.add(Box.createRigidArea(new Dimension(280, 330)));
        bubblePanel.add(mascotBubble);

        centerPanel.add(Box.createRigidArea(new Dimension(500, 200)));
        centerPanel.add(chooseWeekText);
        centerPanel.add(Box.createRigidArea(new Dimension(250, 0)));
        centerPanel.add(section);
        centerPanel.add(Box.createRigidArea(new Dimension(250, 219)));
        centerPanel.add(commit);
        
        centerPanel.add(bubblePanel);

        leftPanel.add(Box.createRigidArea(new Dimension(250, 130)));
        leftPanel.add(addNewWeekText);
        leftPanel.add(Box.createRigidArea(new Dimension(250, 0)));
        leftPanel.add(addNewSection);

        rightPanel.add(Box.createRigidArea(new Dimension(250, 180)));
        rightPanel.add(help);
        rightPanel.add(Box.createRigidArea(new Dimension(250, 310)));
        rightPanel.add(back);
        rightPanel.add(mascotLabel);

        add(leftPanel, BorderLayout.LINE_START);
        add(rightPanel, BorderLayout.LINE_END);
        add(centerPanel, BorderLayout.CENTER);

        //adding actionListeners
        back.addActionListener(listener);
        help.addActionListener(listener);
        section.addActionListener(listener);
        addNewSection.addActionListener(listener);
        commit.addActionListener(listener);
        
        
    }
    
    public void removeCenterPanel(){
    remove(centerPanel);
    //centerPanel.add()
    }
    
    public void fillList(){
        //Adding to ComboBox
        
        //section.removeAllItems();
        listener.getSectionList();
    }

}
