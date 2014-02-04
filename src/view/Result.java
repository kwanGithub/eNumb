/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ResultListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Viktor
 */
public class Result extends JPanel
{

    private Enumb main;
    private JLabel topLabel, goodResultText, resultSummary, percentText, compareResult, easyResultWindow, mediumResultWindow, hardResultWindow, mascotLabel, mascotBubble;
    private JPanel leftContainer, rightContainer, allLevelsIncludedLabel, bubblePanel;
    private JButton menu, help, quit;
    private int correctAnswers, inPercent, comparedToEarlierResult, easyLevelResult, mediumLevelResult, hardLevelResult;
    private ResultListener listener;

    public Result(Enumb jf)
    {
        //new JLabels
        topLabel = new JLabel("Ditt resultat");
        goodResultText = new JLabel("Bra jobbat!");
        resultSummary = new JLabel("Du svarade rätt på " + correctAnswers + " frågor av 10");
        percentText = new JLabel("Det blir " + inPercent + "% totalt!");
        compareResult = new JLabel("Det var " + comparedToEarlierResult + " mer/mindre än ditt bästa resultat.");
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratresult.png"));

        easyResultWindow = new JLabel("Snitt på lätt nivå: " + easyLevelResult + "%");
        mediumResultWindow = new JLabel("Snitt på medelnivå: " + mediumLevelResult + "%");
        hardResultWindow = new JLabel("Snitt på svår nivå: " + hardLevelResult + "%");

        //new JButtons
        menu = new JButton("Meny");
        help = new JButton("Hjälp");
        quit = new JButton("Avsluta");

        //new JPanels
        leftContainer = new JPanel(new FlowLayout());
        rightContainer = new JPanel();
        allLevelsIncludedLabel = new JPanel();
        bubblePanel = new JPanel();

        //new Fonts
        Font font = new Font("san serif", Font.PLAIN, 20);
        Font font2 = new Font("sans serif", Font.BOLD, 14);

        setLayout(new FlowLayout());

        main = jf;

        listener = new ResultListener(menu, help, quit, main);

        //ActionListeners
        menu.addActionListener(listener);
        help.addActionListener(listener);
        quit.addActionListener(listener);

        //Size settings
        setPreferredSize(new Dimension(1290, 890));
        easyResultWindow.setPreferredSize(new Dimension(350, 40));
        mediumResultWindow.setPreferredSize(new Dimension(350, 40));
        hardResultWindow.setPreferredSize(new Dimension(350, 40));
        resultSummary.setPreferredSize(new Dimension(600, 50));
        percentText.setPreferredSize(new Dimension(600, 50));
        compareResult.setPreferredSize(new Dimension(600, 50));
        help.setPreferredSize(new Dimension(200, 40));
        quit.setPreferredSize(new Dimension(200, 40));
        menu.setPreferredSize(new Dimension(200, 40));
        topLabel.setPreferredSize(new Dimension(1290, 50));
        allLevelsIncludedLabel.setPreferredSize(new Dimension(390, 150));
        leftContainer.setPreferredSize(new Dimension(800, 800));
        rightContainer.setPreferredSize(new Dimension(400, 800));

        //Background settings
        setBackground(new Color(200,248,217));
        leftContainer.setBackground(new Color(200,248,217));
        rightContainer.setBackground(new Color(200,248,217));
        topLabel.setBackground(new Color(200,248,217));
        compareResult.setBackground(new Color(200,248,217));
        easyResultWindow.setBackground(new Color(200,248,217));
        mediumResultWindow.setBackground(new Color(200,248,217));
        hardResultWindow.setBackground(new Color(200,248,217));
        help.setBackground(new Color(240, 240, 240));
        menu.setBackground(new Color(240, 240, 240));
        quit.setBackground(new Color(240, 240, 240));
        
        //Font settings
        easyResultWindow.setFont(font2);
        mediumResultWindow.setFont(font2);
        hardResultWindow.setFont(font2);
        resultSummary.setFont(font);
        percentText.setFont(font);
        compareResult.setFont(font);
        goodResultText.setFont(new Font("century gothic", Font.BOLD, 34));
        topLabel.setFont(new Font("century gothic", Font.BOLD, 34));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Border settings
        allLevelsIncludedLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        help.setBorder(BorderFactory.createRaisedBevelBorder());
        menu.setBorder(BorderFactory.createRaisedBevelBorder());
        quit.setBorder(BorderFactory.createRaisedBevelBorder());

        //addings
        allLevelsIncludedLabel.add(easyResultWindow);
        allLevelsIncludedLabel.add(mediumResultWindow);
        allLevelsIncludedLabel.add(hardResultWindow);

        leftContainer.add(Box.createRigidArea(new Dimension(600,85)));
        leftContainer.add(mascotLabel);
        leftContainer.add(mascotBubble);
        leftContainer.add(resultSummary);
        leftContainer.add(percentText);
        leftContainer.add(compareResult);
        leftContainer.add(Box.createRigidArea(new Dimension(600, 45)));
        leftContainer.add(menu);

        rightContainer.add(Box.createRigidArea(new Dimension(400, 250)));
        rightContainer.add(allLevelsIncludedLabel);
        rightContainer.add(Box.createRigidArea(new Dimension(400, 50)));
        rightContainer.add(help);
        rightContainer.add(Box.createRigidArea(new Dimension(400, 50)));
        rightContainer.add(quit);

        add(topLabel);
        add(leftContainer);
        add(rightContainer);

    }

    public void updateLabels(){
        
        //new JLabels
        topLabel.setText("Ditt resultat:");
        goodResultText.setText("Bra jobbat!");
        resultSummary.setText("Du svarade rätt på " + listener.getPoints() + " frågor av 10.");
        percentText.setText("Det blir " + listener.percentage() + "% totalt!");
        compareResult.setText("Du fick " + listener.betterOrWorse() + " poäng än ditt bästa resultat.");

        easyResultWindow.setText("Din poäng den här omgången : " + listener.getScore());
        mediumResultWindow.setText("Din högsta poäng för enskild spelomgång: " + listener.getHighscore());
        hardResultWindow.setText("Din totala spelpoäng: " + listener.getTotalScore());
        
        
    }
}
