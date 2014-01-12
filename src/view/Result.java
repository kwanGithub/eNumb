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
    private JLabel topLabel, goodResultText, okayResultText, badResultText, resultSummary, percentText, compareResult, easyResultWindow, mediumResultWindow, hardResultWindow;
    private JPanel leftContainer, rightContainer, allLevelsIncludedLabel;
    private JButton menu, help, quit;
    private int correctAnswers, inPercent, comparedToEarlierResult, easyLevelResult, mediumLevelResult, hardLevelResult;

    public Result(Enumb jf)
    {
        //Bara för att se att skiten funkar.
        correctAnswers = 6;
        inPercent = 17;
        comparedToEarlierResult = 66;
        easyLevelResult = 6;
        mediumLevelResult = 8;
        hardLevelResult = 10;

        //new JLabels
        topLabel = new JLabel("Ditt resultat");
        goodResultText = new JLabel("Bra jobbat!");
    //okayResultText = new JLabel("Bra, men finns en del kvar att lära.");
        //badResultText = new JLabel("Detta behöver du öva mera på.");
        resultSummary = new JLabel("Du svarade rätt på " + correctAnswers + " frågor av 10");
        percentText = new JLabel("Det blir " + inPercent + "% totalt!");
        compareResult = new JLabel("Det var " + comparedToEarlierResult + " mer/mindre än ditt bästa resultat.");

        easyResultWindow = new JLabel("Snitt på lätt nivå: " + easyLevelResult + "%");
        mediumResultWindow = new JLabel("Snitt på medelnivå: " + mediumLevelResult + "%");
        hardResultWindow = new JLabel("Snitt på svår nivå: " + hardLevelResult + "%");

        //new JButtons
        menu = new JButton("Meny");
        help = new JButton("Hjälp");
        quit = new JButton("Avsluta");

        //new JPanels
        leftContainer = new JPanel();
        rightContainer = new JPanel();
        allLevelsIncludedLabel = new JPanel();

        //new Fonts
        Font font = new Font("sanserif", Font.PLAIN, 20);

        setLayout(new FlowLayout());

        main = jf;

        ResultListener listener = new ResultListener(menu, help, quit, main);

        //ActionListeners
        menu.addActionListener(listener);
        help.addActionListener(listener);
        quit.addActionListener(listener);

        //Size settings
        setPreferredSize(new Dimension(1290, 890));
        goodResultText.setPreferredSize(new Dimension(400, 50));
        easyResultWindow.setPreferredSize(new Dimension(220, 40));
        mediumResultWindow.setPreferredSize(new Dimension(220, 40));
        hardResultWindow.setPreferredSize(new Dimension(220, 40));
        resultSummary.setPreferredSize(new Dimension(400, 50));
        percentText.setPreferredSize(new Dimension(400, 50));
        compareResult.setPreferredSize(new Dimension(400, 50));
    //okayResultText.setPreferredSize(new Dimension(200, 90));
        //badResultText.setPreferredSize(new Dimension(200, 90));
        help.setPreferredSize(new Dimension(200, 40));
        quit.setPreferredSize(new Dimension(200, 40));
        menu.setPreferredSize(new Dimension(200, 40));
        topLabel.setPreferredSize(new Dimension(1290, 50));
        allLevelsIncludedLabel.setPreferredSize(new Dimension(300, 150));
        leftContainer.setPreferredSize(new Dimension(600, 800));
        rightContainer.setPreferredSize(new Dimension(400, 800));

        //Font settings
        easyResultWindow.setFont(font);
        mediumResultWindow.setFont(font);
        hardResultWindow.setFont(font);
        resultSummary.setFont(font);
        percentText.setFont(font);
        compareResult.setFont(font);
        goodResultText.setFont(new Font("century gothic", Font.BOLD, 34));
        topLabel.setFont(new Font("century gothic", Font.BOLD, 34));
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Border settings
        allLevelsIncludedLabel.setBorder(new TitledBorder(""));

        //topLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GRAY));
        rightContainer.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        //addings
        allLevelsIncludedLabel.add(easyResultWindow);
        allLevelsIncludedLabel.add(mediumResultWindow);
        allLevelsIncludedLabel.add(hardResultWindow);

        leftContainer.add(Box.createRigidArea(new Dimension(600, 190)));
        leftContainer.add(goodResultText);
    //leftContainer.add(okayResultText);
        //leftContainer.add(badResultText);
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

}
