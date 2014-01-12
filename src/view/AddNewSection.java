/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AddNewSectionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;
import org.netbeans.validation.api.ui.swing.ValidationPanel;

/**
 *
 * @author Adrian
 */
public class AddNewSection extends JPanel
{

    private final JLabel fromWord, toWord, no0, no1, no2, no3, no4, no5, no6, no7, no8, no9, no10, no11, addWeekNameText;
    private final JPanel leftContainer, mainContainer, numberContainer, weekNamePanel;
    private final JTextField xWord1, xWord2, xWord3, xWord4, xWord5, xWord6, xWord7, xWord8, xWord9, xWord10, addWeekName;
    private final JTextField yWord1, yWord2, yWord3, yWord4, yWord5, yWord6, yWord7, yWord8, yWord9, yWord10;
    private final JButton saveWords;
    private final Enumb main;
    private final ValidationPanel panel;
    private final ValidationGroup group;

    public AddNewSection(Enumb jf)
    {

        //labels
        fromWord = new JLabel("Ord på svenska:");
        toWord = new JLabel("Ord på det nya språket:");
        addWeekNameText = new JLabel("Vecka: ");
        no0 = new JLabel("");
        no1 = new JLabel(" 1.");
        no2 = new JLabel(" 2.");
        no3 = new JLabel(" 3.");
        no4 = new JLabel(" 4.");
        no5 = new JLabel(" 5.");
        no6 = new JLabel(" 6.");
        no7 = new JLabel(" 7.");
        no8 = new JLabel(" 8.");
        no9 = new JLabel(" 9.");
        no10 = new JLabel("10.");
        no11 = new JLabel("");

        //panels
        mainContainer = new JPanel(new FlowLayout());
        leftContainer = new JPanel(new GridLayout(12, 2, 5, 5));
        numberContainer = new JPanel(new GridLayout(12, 1, 0, 5));
        weekNamePanel = new JPanel();
        panel = new ValidationPanel();

        //New textfields
        addWeekName = new JTextField();

        //textfields x
        xWord1 = new JTextField();
        xWord2 = new JTextField();
        xWord3 = new JTextField();
        xWord4 = new JTextField();
        xWord5 = new JTextField();
        xWord6 = new JTextField();
        xWord7 = new JTextField();
        xWord8 = new JTextField();
        xWord9 = new JTextField();
        xWord10 = new JTextField();

        //textfields y
        yWord1 = new JTextField();
        yWord2 = new JTextField();
        yWord3 = new JTextField();
        yWord4 = new JTextField();
        yWord5 = new JTextField();
        yWord6 = new JTextField();
        yWord7 = new JTextField();
        yWord8 = new JTextField();
        yWord9 = new JTextField();
        yWord10 = new JTextField();

        JTextField[] inputField =
        {
            xWord1, xWord2, xWord3, xWord4, xWord5, xWord6,
            xWord7, xWord8, xWord9, xWord10, yWord1, yWord2, yWord3, yWord4, yWord5,
            yWord6, yWord7, yWord8, yWord9, xWord10
        };

        //New Buttons
        saveWords = new JButton("Spara");

        main = jf;

        AddNewSectionListener listener = new AddNewSectionListener(saveWords, addWeekName, main, inputField);

        saveWords.addActionListener(listener);

        //new Font
        Font font = new Font("Century Gothic", Font.BOLD, 15);

        //set size
        numberContainer.setPreferredSize(new Dimension(20, 430));
        mainContainer.setPreferredSize(new Dimension(500, 550));
        leftContainer.setPreferredSize(new Dimension(400, 430));
        fromWord.setPreferredSize(new Dimension(200, 30));
        weekNamePanel.setPreferredSize(new Dimension(490, 40));
        addWeekName.setPreferredSize(new Dimension(100, 30));
        addWeekNameText.setPreferredSize(new Dimension(70, 30));
        saveWords.setPreferredSize(new Dimension(90, 40));
        no0.setPreferredSize(new Dimension(30, 30));
        no1.setPreferredSize(new Dimension(30, 30));
        no2.setPreferredSize(new Dimension(30, 30));
        no3.setPreferredSize(new Dimension(30, 30));
        no4.setPreferredSize(new Dimension(30, 30));
        no5.setPreferredSize(new Dimension(30, 30));
        no6.setPreferredSize(new Dimension(30, 30));
        no7.setPreferredSize(new Dimension(30, 30));
        no8.setPreferredSize(new Dimension(30, 30));
        no9.setPreferredSize(new Dimension(30, 30));
        no10.setPreferredSize(new Dimension(30, 30));
        no11.setPreferredSize(new Dimension(30, 30));
        xWord1.setPreferredSize(new Dimension(150, 30));
        xWord2.setPreferredSize(new Dimension(150, 30));
        xWord3.setPreferredSize(new Dimension(150, 30));
        xWord4.setPreferredSize(new Dimension(150, 30));
        xWord5.setPreferredSize(new Dimension(150, 30));
        xWord6.setPreferredSize(new Dimension(150, 30));
        xWord7.setPreferredSize(new Dimension(150, 30));
        xWord8.setPreferredSize(new Dimension(150, 30));
        xWord9.setPreferredSize(new Dimension(150, 30));
        xWord10.setPreferredSize(new Dimension(150, 30));
        toWord.setPreferredSize(new Dimension(200, 30));
        yWord1.setPreferredSize(new Dimension(200, 30));
        yWord2.setPreferredSize(new Dimension(200, 30));
        yWord3.setPreferredSize(new Dimension(200, 30));
        yWord4.setPreferredSize(new Dimension(200, 30));
        yWord5.setPreferredSize(new Dimension(200, 30));
        yWord6.setPreferredSize(new Dimension(200, 30));
        yWord7.setPreferredSize(new Dimension(200, 30));
        yWord8.setPreferredSize(new Dimension(200, 30));
        yWord9.setPreferredSize(new Dimension(200, 30));
        yWord10.setPreferredSize(new Dimension(200, 30));

        //set font
        addWeekName.setFont(font);
        addWeekNameText.setFont(font);
        leftContainer.setFont(font);
        fromWord.setFont(font);
        saveWords.setFont(font);
        no0.setFont(font);
        no1.setFont(font);
        no2.setFont(font);
        no3.setFont(font);
        no4.setFont(font);
        no5.setFont(font);
        no6.setFont(font);
        no7.setFont(font);
        no8.setFont(font);
        no9.setFont(font);
        no10.setFont(font);
        no11.setFont(font);
        xWord1.setFont(font);
        xWord2.setFont(font);
        xWord3.setFont(font);
        xWord4.setFont(font);
        xWord5.setFont(font);
        xWord6.setFont(font);
        xWord7.setFont(font);
        xWord8.setFont(font);
        xWord9.setFont(font);
        xWord10.setFont(font);
        toWord.setFont(font);
        yWord1.setFont(font);
        yWord2.setFont(font);
        yWord3.setFont(font);
        yWord4.setFont(font);
        yWord5.setFont(font);
        yWord6.setFont(font);
        yWord7.setFont(font);
        yWord8.setFont(font);
        yWord9.setFont(font);
        yWord10.setFont(font);

        //Adding ActionListeners
        //back.addActionListener(listener);
        //addNewWords.addActionListener(listener);
        //Border settings
        mainContainer.setBorder(BorderFactory.createRaisedBevelBorder());

        //set backgrounds
        weekNamePanel.setBackground(new Color(15, 161, 163));
        mainContainer.setBackground(new Color(15, 161, 163));
        numberContainer.setBackground(new Color(15, 161, 163));
        leftContainer.setBackground(new Color(15, 161, 163));

        //set alignment
        fromWord.setHorizontalAlignment(SwingConstants.CENTER);
        toWord.setHorizontalAlignment(SwingConstants.CENTER);
        addWeekNameText.setHorizontalAlignment(SwingConstants.CENTER);

        //Addings
        weekNamePanel.add(Box.createRigidArea(new Dimension(50, 35)));
        weekNamePanel.add(addWeekNameText);
        weekNamePanel.add(addWeekName);

        mainContainer.add(weekNamePanel);
        mainContainer.add(numberContainer);
        mainContainer.add(leftContainer);
        mainContainer.add(saveWords);

        numberContainer.add(no0);
        numberContainer.add(no1);
        numberContainer.add(no2);
        numberContainer.add(no3);
        numberContainer.add(no4);
        numberContainer.add(no5);
        numberContainer.add(no6);
        numberContainer.add(no7);
        numberContainer.add(no8);
        numberContainer.add(no9);
        numberContainer.add(no10);
        numberContainer.add(no11);

        leftContainer.add(fromWord);
        leftContainer.add(toWord);
        leftContainer.add(xWord1);
        leftContainer.add(yWord1);
        leftContainer.add(xWord2);
        leftContainer.add(yWord2);
        leftContainer.add(xWord3);
        leftContainer.add(yWord3);
        leftContainer.add(xWord4);
        leftContainer.add(yWord4);
        leftContainer.add(xWord5);
        leftContainer.add(yWord5);
        leftContainer.add(xWord6);
        leftContainer.add(yWord6);
        leftContainer.add(xWord7);
        leftContainer.add(yWord7);
        leftContainer.add(xWord8);
        leftContainer.add(yWord8);
        leftContainer.add(xWord9);
        leftContainer.add(yWord9);
        leftContainer.add(xWord10);
        leftContainer.add(yWord10);

        group = panel.getValidationGroup();
        group.add(xWord1, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord2, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord3, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord4, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord5, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord6, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord7, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord8, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord9, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(xWord10, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord1, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord2, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord3, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord4, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord5, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord6, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord7, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord8, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord9, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));
        group.add(yWord10, StringValidators.REQUIRE_NON_EMPTY_STRING, StringValidators.maxLength(25));

        add(Box.createRigidArea(new Dimension(700, 200)));
        add(mainContainer);

    }

}
