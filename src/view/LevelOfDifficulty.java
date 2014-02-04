/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.*;
import javax.swing.*;
import control.LevelOfDiffucltyListener;
import java.util.Hashtable;
//TheReal
/**
 *
 * @author Viktor
 */
public class LevelOfDifficulty extends JPanel
{

    private JPanel centerPanel, leftPanel, rightPanel, bubblePanel;
    private JLabel chooseDifficultyText, mascotLabel, mascotBubble;
    private JSlider slider;
    private JButton back, go;
    private Enumb main;

    public LevelOfDifficulty(Enumb jf)
    {

        //new Panels
        bubblePanel = new JPanel();
        centerPanel = new JPanel(new FlowLayout());
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        //new Labels
        chooseDifficultyText = new JLabel("Välj svårighetsgrad!");
        mascotLabel = new JLabel(new ImageIcon("images\\mouse.png"));
        mascotBubble = new JLabel(new ImageIcon("images\\pratdifficulty.png"));

        //new Buttons
        back = new JButton("Tillbaka");
        go = new JButton("Kör!");

        //new Slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, 2, 0);

        setLayout(new BorderLayout());

        //new HashTable
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(0, new JLabel("Lätt"));
        labelTable.put(1, new JLabel("Medel"));
        labelTable.put(2, new JLabel("Svårt"));

        slider.setPaintTicks(true);
        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);

        main = jf;

        //LevelOfDiffucltyListener
        LevelOfDiffucltyListener listener = new LevelOfDiffucltyListener(chooseDifficultyText, slider, back, go, main);

        //Size settings
        go.setPreferredSize(new Dimension(200, 40));
        back.setPreferredSize(new Dimension(200, 40));
        bubblePanel.setPreferredSize(new Dimension(790, 300));
        mascotLabel.setPreferredSize(new Dimension(200, 300));
        mascotBubble.setPreferredSize(new Dimension(500, 280));
        slider.setPreferredSize(new Dimension(800, 150));
        centerPanel.setPreferredSize(new Dimension(500, 900));
        leftPanel.setPreferredSize(new Dimension(250, 900));
        rightPanel.setPreferredSize(new Dimension(250, 900));
        chooseDifficultyText.setPreferredSize(new Dimension(800, 65));

        //Background settings
        centerPanel.setBackground(new Color(105, 203, 88));
        leftPanel.setBackground(new Color(148, 231, 134));
        rightPanel.setBackground(new Color(148, 231, 134));
        slider.setBackground(new Color(105, 203, 88));
        bubblePanel.setBackground(new Color(105, 203, 88));
        go.setBackground(new Color(240, 240, 240));
        back.setBackground(new Color(240, 240, 240));

        //Border settings
        go.setBorder(BorderFactory.createRaisedBevelBorder());
        back.setBorder(BorderFactory.createRaisedBevelBorder());

        //Font settings
        slider.setFont(new Font("century gothic", Font.BOLD, 10));
        chooseDifficultyText.setFont(new Font("century gothic", Font.BOLD, 30));
        chooseDifficultyText.setHorizontalAlignment(SwingConstants.CENTER);

        //add actionListeners and changeListeners
        back.addActionListener(listener);
        go.addActionListener(listener);
        slider.addChangeListener(listener);

        //Addings
        bubblePanel.add(Box.createRigidArea(new Dimension(279, 330)));
        bubblePanel.add(mascotBubble);

        rightPanel.add(Box.createRigidArea(new Dimension(250, 563)));
        rightPanel.add(mascotLabel);

        centerPanel.add(Box.createRigidArea(new Dimension(500, 200)));
        centerPanel.add(chooseDifficultyText);
        centerPanel.add(Box.createRigidArea(new Dimension(800, 90)));
        centerPanel.add(slider);
        centerPanel.add(Box.createRigidArea(new Dimension(15, 40)));
        centerPanel.add(go);
        centerPanel.add(Box.createRigidArea(new Dimension(150, 40)));
        centerPanel.add(back);
        centerPanel.add(Box.createRigidArea(new Dimension(500, 0)));
        centerPanel.add(bubblePanel);
        add(centerPanel);
        add(leftPanel, BorderLayout.LINE_START);
        add(rightPanel, BorderLayout.LINE_END);

    }

}
