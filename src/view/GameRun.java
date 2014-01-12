/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GameRunListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Viktor
 */
public class GameRun extends JPanel
{

    private Enumb main;
    private JButton help, menu, choiceNr1, choiceNr2, choiceNr3, choiceNr4, fulKnappSomTasBort, commit;
    private JPanel leftPanel, rightPanel, buttonPanel, wordToTranslateFieldPanel, bubblePanel, outerButtonPanel, commitButtonPanel;
    private JLabel topLabel, correctNumbersLabel, progressbarLabel, wordToTranslateLabel, translateFieldLabel, tickingTime, mascotLabel, mascotBubble;
    private JTextField wordToTranslate, translateField, correctNumbersField;
    private JProgressBar progressBar;
    private int wordNumber, correctNumbers, level;
    private Timer timer;
    private GameRunListener listener;

    public GameRun(Enumb jf, int level)
    {

        this.level = level;
        
        //new Labels
        topLabel = new JLabel();
        correctNumbersLabel = new JLabel("Antal rätt:");
        progressbarLabel = new JLabel("Tid kvar:");
        wordToTranslateLabel = new JLabel("Översätt ordet:");
        translateFieldLabel = new JLabel("Skriv din översättning här:");
        tickingTime = new JLabel();
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratsection.png"));

        //new Panels
        bubblePanel = new JPanel();
        buttonPanel = new JPanel();
        outerButtonPanel = new JPanel();
        leftPanel = new JPanel(); // Left panel holds wordToTranslate field and translateField.
        rightPanel = new JPanel(); // Right panel holds progressbar, "correct number"-field and help-menu buttons.
        commitButtonPanel = new JPanel(); // This panel holds the commitButton.
        wordToTranslateFieldPanel = new JPanel();

        //new TextFields
        wordToTranslate = new JTextField();
        translateField = new JTextField();
        correctNumbersField = new JTextField(correctNumbers);

        //new Buttons
        help = new JButton("Hjälp");
        menu = new JButton("Meny");
        choiceNr1 = new JButton("Alternativ 1");
        choiceNr2 = new JButton("Alternativ 2");
        choiceNr3 = new JButton("Alternativ 3");
        choiceNr4 = new JButton("Alternativ 4");
        fulKnappSomTasBort = new JButton("TAS BORT");
        commit = new JButton("Svara");

        main = jf;
        
        //new Progressbars
        progressBar = new JProgressBar(0, 200);

        //GameRunListener
        listener = new GameRunListener(help, menu, choiceNr1, 
                choiceNr2, choiceNr3, choiceNr4, fulKnappSomTasBort, main, 
                wordToTranslate, translateField, correctNumbersField, topLabel, 
                commit, mascotBubble, progressBar, level);

        //Adding ActionListeners
        choiceNr1.addActionListener(listener);
        choiceNr2.addActionListener(listener);
        choiceNr3.addActionListener(listener);
        choiceNr4.addActionListener(listener);
        help.addActionListener(listener);
        menu.addActionListener(listener);
        fulKnappSomTasBort.addActionListener(listener);
        commit.addActionListener(listener);
        

        

        //Layout settings.
        setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        bubblePanel.setLayout(new FlowLayout());
        leftPanel.setLayout(new FlowLayout());
        rightPanel.setLayout(new FlowLayout());
        wordToTranslateFieldPanel.setLayout(new FlowLayout());

        //Size settings
        mascotLabel.setPreferredSize(new Dimension(200, 300));
        mascotBubble.setPreferredSize(new Dimension(500, 230));
        bubblePanel.setPreferredSize(new Dimension(500, 230));
        choiceNr1.setPreferredSize(new Dimension(00, 50));
        choiceNr2.setPreferredSize(new Dimension(100, 50));
        choiceNr3.setPreferredSize(new Dimension(100, 50));
        choiceNr4.setPreferredSize(new Dimension(100, 50));
        buttonPanel.setPreferredSize(new Dimension(700, 100));
        outerButtonPanel.setPreferredSize(new Dimension(1000, 110));
        topLabel.setPreferredSize(new Dimension(1000, 50));
        leftPanel.setPreferredSize(new Dimension(1080, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));
        translateFieldLabel.setPreferredSize(new Dimension(700, 50));
        translateField.setPreferredSize(new Dimension(700, 50));
        wordToTranslateFieldPanel.setPreferredSize(new Dimension(1000, 60));
        wordToTranslateLabel.setPreferredSize(new Dimension(1000, 50));
        wordToTranslate.setPreferredSize(new Dimension(700, 45));
        progressbarLabel.setPreferredSize(new Dimension(245, 20));
        progressBar.setPreferredSize(new Dimension(240, 40));
        correctNumbersLabel.setPreferredSize(new Dimension(250, 20));
        correctNumbersField.setPreferredSize(new Dimension(80, 80));
        commitButtonPanel.setPreferredSize(new Dimension(700, 45));
        commit.setPreferredSize(new Dimension(140, 30));

        //buttonPanel.setVisible(false);
        //background settings.
        buttonPanel.setBackground(Color.YELLOW);
        outerButtonPanel.setBackground(Color.YELLOW);
        bubblePanel.setBackground(Color.YELLOW);
        mascotBubble.setBackground(Color.YELLOW);
        wordToTranslateFieldPanel.setBackground(Color.YELLOW);
        commitButtonPanel.setBackground(Color.YELLOW);
        leftPanel.setBackground(Color.YELLOW);
        rightPanel.setBackground(Color.RED);
        choiceNr1.setBackground(new Color(240, 240, 240));
        choiceNr2.setBackground(new Color(240, 240, 240));
        choiceNr3.setBackground(new Color(240, 240, 240));
        choiceNr4.setBackground(new Color(240, 240, 240));
        help.setBackground(new Color(240, 240, 240));
        menu.setBackground(new Color(240, 240, 240));
        wordToTranslate.setBackground(Color.WHITE);
        correctNumbersField.setBackground(Color.WHITE);


       // wordNumber = 5; // Bara som ett visningsexempel för tillfället.
        correctNumbers = 8; // Bara som ett visningsexempel för tillfället.

        // Font and alignment settings.
        topLabel.setText("Spelet är igång! Ord nummer " + 1);
        topLabel.setFont(new Font("century gothic", Font.BOLD, 34));
        wordToTranslateLabel.setFont(new Font("century gothic", Font.BOLD, 24));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        correctNumbersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordToTranslateLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //editable settings.
        wordToTranslate.setEditable(false);
        correctNumbersField.setEditable(false);

        //Addings.
        //bubblePanel.add(Box.createRigidArea(new Dimension(280, 230)));
        bubblePanel.add(mascotBubble);

        wordToTranslateFieldPanel.add(wordToTranslate);

        leftPanel.add(Box.createRigidArea(new Dimension(300, 60)));
        leftPanel.add(topLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(300, 100)));
        leftPanel.add(wordToTranslateLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(260, 50)));
        leftPanel.add(wordToTranslateFieldPanel);
        

        buttonPanel.add(choiceNr1);
        //buttonPanel.add(Box.createRigidArea(new Dimension(60,90)));
        buttonPanel.add(choiceNr2);
        //buttonPanel.add(Box.createRigidArea(new Dimension(60,40)));
        buttonPanel.add(choiceNr3);
        //buttonPanel.add(Box.createRigidArea(new Dimension(60,40)));
        buttonPanel.add(choiceNr4);
        //buttonPanel.add(Box.createRigidArea(new Dimension(60,40)));
        outerButtonPanel.add(buttonPanel);
        
        commitButtonPanel.add(commit);

        //Adds or removes components in GameRun panel(Don't you dare move it from this place!)
        if (level == 0)
        {
            rightPanel.add(Box.createRigidArea(new Dimension(250, 65)));
            leftPanel.add(Box.createRigidArea(new Dimension(66, 110)));
            leftPanel.add(outerButtonPanel);
            leftPanel.add(Box.createRigidArea(new Dimension(1000, 0)));
            leftPanel.add(Box.createRigidArea(new Dimension(540, 230)));
            progressBar.setVisible(false);
            translateField.setVisible(false);
            progressbarLabel.setVisible(false);
            updateUI();

        }
        else if (level == 1)
        {
            progressBar.setVisible(false);
            progressbarLabel.setVisible(false);
                     
            leftPanel.add(translateField);
            leftPanel.add(commitButtonPanel);
            leftPanel.add(Box.createRigidArea(new Dimension(65, 100)));
            leftPanel.add(Box.createRigidArea(new Dimension(540, 230)));
            leftPanel.add(bubblePanel);
            updateUI();

        }
        else if (level == 2)
        {   
            listener.countDownProgressBar();
            leftPanel.add(translateFieldLabel);
            leftPanel.add(translateField);
            leftPanel.add(commitButtonPanel);
            updateUI();
        }

        rightPanel.add(Box.createRigidArea(new Dimension(500, 160)));
        rightPanel.add(progressbarLabel);
        rightPanel.add(progressBar);
        rightPanel.add(Box.createRigidArea(new Dimension(500, 100)));
        rightPanel.add(correctNumbersLabel);
        rightPanel.add(correctNumbersField);
        rightPanel.add(Box.createRigidArea(new Dimension(500, 104)));
        rightPanel.add(help);
        rightPanel.add(menu);
        rightPanel.add(fulKnappSomTasBort);
        rightPanel.add(mascotLabel);

        add(rightPanel, BorderLayout.LINE_END);
        add(leftPanel, BorderLayout.CENTER);

    }
    
    

    

}
