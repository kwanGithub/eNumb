/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.AddNewSectionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
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
 * - Nä, inte ett hår på pojkens kropp.
 */
public class AddNewSection extends JPanel
{

    private final JLabel fromWord, toWord, no0, no1, no2, no3, no4, no5, no6, no7, no8, no9, no10, no11, addWeekNameText, mascotLabel, mascotBubble;
    private final JPanel fieldContainer, mainContainer, numberContainer, weekNamePanel, saveButtonPanel, leftPanel, rightPanel, innerContainer, bubblePanel;
    private final JTextField xWord1, xWord2, xWord3, xWord4, xWord5, xWord6, xWord7, xWord8, xWord9, xWord10, addWeekName;
    private final JTextField yWord1, yWord2, yWord3, yWord4, yWord5, yWord6, yWord7, yWord8, yWord9, yWord10;
    private final JButton saveWords, cancel;
    private final Enumb main;
    private final ValidationPanel panel;
    private final ValidationGroup group;

    public AddNewSection(Enumb jf)
    {

        //labels
        fromWord = new JLabel("Ord på svenska:");
        toWord = new JLabel("Ord på det nya språket:");
        addWeekNameText = new JLabel("Gloslista: ");
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratsection.png"));
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
        setLayout(new BorderLayout());
        innerContainer = new JPanel();
        mainContainer = new JPanel(new FlowLayout());
        fieldContainer = new JPanel(new GridLayout(12, 2, 5, 5));
        numberContainer = new JPanel(new GridLayout(12, 1, 0, 5));
        weekNamePanel = new JPanel();
        bubblePanel = new JPanel();
        saveButtonPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
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
            xWord1, yWord1, xWord2, yWord2, xWord3, yWord3, xWord4, yWord4, xWord5,
            yWord5, xWord6, yWord6, xWord7, yWord7, xWord8, yWord8, xWord9, yWord9,
            xWord10, yWord10
        };

        //New Buttons
        saveWords = new JButton("Spara");
        cancel = new JButton("Avbryt");

        main = jf;

        AddNewSectionListener listener = new AddNewSectionListener(saveWords, cancel,  addWeekName, main, inputField);

        

        //new Font
        Font font = new Font("Century Gothic", Font.BOLD, 15);

        //set size
        bubblePanel.setPreferredSize(new Dimension(790, 290));
        leftPanel.setPreferredSize(new Dimension(250, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));
        numberContainer.setPreferredSize(new Dimension(20, 430));
        mainContainer.setPreferredSize(new Dimension(500, 550));
        fieldContainer.setPreferredSize(new Dimension(400, 430));
        fromWord.setPreferredSize(new Dimension(200, 30));
        weekNamePanel.setPreferredSize(new Dimension(490, 40));
        addWeekName.setPreferredSize(new Dimension(100, 30));
        addWeekNameText.setPreferredSize(new Dimension(70, 30));
        saveButtonPanel.setPreferredSize(new Dimension(490,50));
        saveWords.setPreferredSize(new Dimension(90, 40));
        cancel.setPreferredSize(new Dimension(90, 40));
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
        fieldContainer.setFont(font);
        fromWord.setFont(font);
        saveWords.setFont(font);
        cancel.setFont(font);
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
        saveWords.addActionListener(listener);
        cancel.addActionListener(listener);
        
        //Border settings
        

        //set backgrounds
        innerContainer.setBackground(new Color(203, 114, 216));
        saveButtonPanel.setBackground(new Color(242, 172, 253));
        leftPanel.setBackground(new Color(242, 172, 253));
        rightPanel.setBackground(new Color(242, 172, 253));
        weekNamePanel.setBackground(new Color(242, 172, 253));
        mainContainer.setBackground(new Color(242, 172, 253));
        numberContainer.setBackground(new Color(242, 172, 253));
        fieldContainer.setBackground(new Color(242, 172, 253));

        //set alignment
        fromWord.setHorizontalAlignment(SwingConstants.CENTER);
        toWord.setHorizontalAlignment(SwingConstants.CENTER);
        addWeekNameText.setHorizontalAlignment(SwingConstants.CENTER);

        //Addings
        bubblePanel.add(Box.createRigidArea(new Dimension(280, 330)));
        bubblePanel.add(mascotBubble);
        
        saveButtonPanel.add(Box.createRigidArea(new Dimension(20, 40)));
        saveButtonPanel.add(saveWords);
        saveButtonPanel.add(cancel);
        
        weekNamePanel.add(Box.createRigidArea(new Dimension(50, 35)));
        weekNamePanel.add(addWeekNameText);
        weekNamePanel.add(addWeekName);

        rightPanel.add(Box.createRigidArea(new Dimension(250, 585)));
        rightPanel.add(mascotLabel);

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

        fieldContainer.add(fromWord);
        fieldContainer.add(toWord);
        fieldContainer.add(xWord1);
        fieldContainer.add(yWord1);
        fieldContainer.add(xWord2);
        fieldContainer.add(yWord2);
        fieldContainer.add(xWord3);
        fieldContainer.add(yWord3);
        fieldContainer.add(xWord4);
        fieldContainer.add(yWord4);
        fieldContainer.add(xWord5);
        fieldContainer.add(yWord5);
        fieldContainer.add(xWord6);
        fieldContainer.add(yWord6);
        fieldContainer.add(xWord7);
        fieldContainer.add(yWord7);
        fieldContainer.add(xWord8);
        fieldContainer.add(yWord8);
        fieldContainer.add(xWord9);
        fieldContainer.add(yWord9);
        fieldContainer.add(xWord10);
        fieldContainer.add(yWord10);

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
        
        mainContainer.add(weekNamePanel);
        mainContainer.add(numberContainer);
        mainContainer.add(fieldContainer);
        mainContainer.add(saveButtonPanel);

        innerContainer.add(Box.createRigidArea(new Dimension(800, 150)));
        innerContainer.add(mainContainer);
        
        mainContainer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        
        
        add(innerContainer, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.LINE_START);
        add(rightPanel, BorderLayout.LINE_END);
        

    }
    public void addAddNewSectionPanel(){
       // add(mainContainer);
        mainContainer.setVisible(true);
        panel.setVisible(true);
        mainContainer.updateUI();
    }
    
    public void removeAddNewSectionPanel(){
       // remove(mainContainer);
        mainContainer.setVisible(false);
        panel.setVisible(false);
        mainContainer.updateUI();
    }
    
    

}
