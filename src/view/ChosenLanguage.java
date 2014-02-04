/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ChosenLanguageListener;
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
//Thereal

/**
 *
 * @author Viktor
 */
public class ChosenLanguage extends JPanel
{

    private JLabel chooseWeekText, addNewWeekText, mascotLabel, mascotBubble;
    private JPanel leftPanel, rightPanel, centerPanel, bubblePanel, sectionPanel, commitPanel;
    private JComboBox section;
    private JButton help, addNewSection, back, commit;
    private Enumb main;
    private ChosenLanguageListener listener;

    public ChosenLanguage(Enumb jf)
    {

        //new Labels
        chooseWeekText = new JLabel("Välj gloslista:");
        addNewWeekText = new JLabel("");
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratsection.png"));

        //new Buttons
        help = new JButton("Hjälp");
        addNewSection = new JButton("Lägg till ny gloslista");
        back = new JButton("Tillbaka");
        commit = new JButton("Nästa");

        //new Panels
        centerPanel = new JPanel(new FlowLayout());
        bubblePanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        commitPanel = new JPanel();
        sectionPanel = new JPanel();

        //new ComboBoxes
        section = new JComboBox();

        //new Fonts
        Font font = new Font("century gothic", Font.BOLD, 15);
        Font font2 = new Font("century gothic", Font.BOLD, 20);

        main = jf;

        //ChosenLanguageListener
        listener = new ChosenLanguageListener(chooseWeekText, section, help, addNewSection, back, main, commit);

        //Size settings
        help.setPreferredSize(new Dimension(200, 40));
        back.setPreferredSize(new Dimension(200, 40));
        sectionPanel.setPreferredSize(new Dimension(820, 60));
        commit.setPreferredSize(new Dimension(300, 40));
        commitPanel.setPreferredSize(new Dimension(820, 45));
        addNewWeekText.setPreferredSize(new Dimension(200, 40));
        addNewSection.setPreferredSize(new Dimension(200, 40));
        chooseWeekText.setPreferredSize(new Dimension(820, 50));
        section.setPreferredSize(new Dimension(300, 50));
        centerPanel.setPreferredSize(new Dimension(500, 200));
        leftPanel.setPreferredSize(new Dimension(250, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));
        mascotBubble.setPreferredSize(new Dimension(500, 280));
        bubblePanel.setPreferredSize(new Dimension(790, 280));

        //Background settings
        setBackground(new Color(255, 157, 159));
        commitPanel.setBackground(new Color(255, 157, 159));
        sectionPanel.setBackground(new Color(255, 157, 159));
        section.setBackground(new Color(255, 255, 255));
        leftPanel.setBackground(new Color(255, 193, 194));
        centerPanel.setBackground(new Color(255, 157, 159));
        rightPanel.setBackground(new Color(255, 193, 194));
        bubblePanel.setBackground(new Color(255, 157, 159));
        help.setBackground(new Color(240, 240, 240));
        back.setBackground(new Color(240, 240, 240));
        commit.setBackground(new Color(240, 240, 240));
        addNewSection.setBackground(new Color(240, 240, 240));

        //Layout settings
        setLayout(new BorderLayout());

        //Border settings
        commit.setBorder(BorderFactory.createRaisedBevelBorder());
        help.setBorder(BorderFactory.createRaisedBevelBorder());
        back.setBorder(BorderFactory.createRaisedBevelBorder());
        addNewSection.setBorder(BorderFactory.createRaisedBevelBorder());

        //Font settings
        commit.setFont(font);
        section.setFont(font2);
        chooseWeekText.setFont(font2);
        chooseWeekText.setHorizontalAlignment(SwingConstants.CENTER);
        addNewSection.setFont(font);
        addNewWeekText.setFont(font2);
        help.setFont(font);
        back.setFont(font);

        //Addings
        commitPanel.add(commit);
        sectionPanel.add(section);

        bubblePanel.add(Box.createRigidArea(new Dimension(280, 330)));
        bubblePanel.add(mascotBubble);

        centerPanel.add(Box.createRigidArea(new Dimension(500, 200)));
        centerPanel.add(chooseWeekText);
        centerPanel.add(Box.createRigidArea(new Dimension(70, 0)));
        centerPanel.add(sectionPanel);
        centerPanel.add(commitPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(500, 190)));
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

    public void removeCenterPanel()
    {
        centerPanel.setVisible(false);
        updateUI();
    }

    public void addCenterPanel()
    {
        centerPanel.setVisible(true);
        centerPanel.updateUI();
        updateUI();
    }

    public void fillList()
    {
        //Adding to ComboBox
        section.removeAllItems();
        listener.getSectionList();
    }

}
