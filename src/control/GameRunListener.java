/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;
import model.Game;
import view.Enumb;
import view.Help;

/**
 * controll klass for gamerun klass
 *
 * @author kevin
 */
public class GameRunListener implements ActionListener
{

    private JButton help, menu, choiceNr1, choiceNr2, choiceNr3, choiceNr4, commit;
    private Enumb main;
    private int counter, points, lives, level;
    private JTextField wordToTranslate, inputField, score;
    private JLabel topLabel, mascotBubble;
    private final String welcome = "Spelet är igång! Ord nummer ";
    private Parser parser;
    private Game game;
    private Random random;
    private Color color;
    private ArrayList<JButton> buttonList;
    private JProgressBar progressBar;
    private Timer timer2;

    /**
     * conscrutor
     *
     * @param help btton
     * @param menu button
     * @param choiceNr1 button
     * @param choiceNr2 button
     * @param choiceNr3 button
     * @param choiceNr4 button
     * @param main enumb view
     * @param wordToTranslate jtextfield
     * @param inputField inputfield
     * @param score scoure field
     * @param topLabel toplabe
     * @param commit button
     * @param mascotBubble mascot label
     * @param progressBar progress bar
     * @param level game level
     */
    public GameRunListener(JButton help, JButton menu, JButton choiceNr1, JButton choiceNr2,
            JButton choiceNr3, JButton choiceNr4, Enumb main,
            JTextField wordToTranslate, JTextField inputField, JTextField score, JLabel topLabel,
            JButton commit, JLabel mascotBubble, JProgressBar progressBar, int level)
    {
        this.help = help;
        this.menu = menu;
        this.choiceNr1 = choiceNr1;
        this.choiceNr2 = choiceNr2;
        this.choiceNr3 = choiceNr3;
        this.choiceNr4 = choiceNr4;
        this.main = main;
        this.wordToTranslate = wordToTranslate;
        this.inputField = inputField;
        this.score = score;
        this.topLabel = topLabel;
        this.commit = commit;
        this.mascotBubble = mascotBubble;
        this.progressBar = progressBar;
        this.level = level;

        parser = MainFactory.getParser();
        game = parser.getGame();

        score.setText("" + points);

        counter = 1;
        lives = 3;

        random = new Random();

        if (level < 3)
        {
            updateButtonsAndFields();
        }

        color = new Color(240, 240, 240);

        buttonList = new ArrayList<>();
        buttonList.add(choiceNr1);
        buttonList.add(choiceNr2);
        buttonList.add(choiceNr3);
        buttonList.add(choiceNr4);
        
        inputField.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent evt)
            {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    validateWrittenAnswer();
                }
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

        Object choice = (e.getSource());

        if (choice == help)
        {
            Help.display("GameRun");
        }
        else if (choice == menu)
        {           
            main.goFromLogin();
            
            if(level == 2){
                timer2.stop();
            }
        }

        else if (choice == choiceNr1)
        {
            controlAnswer(choiceNr1);
        }
        else if (choice == choiceNr2)
        {
            controlAnswer(choiceNr2);
        }

        else if (choice == choiceNr3)
        {
            controlAnswer(choiceNr3);
        }
        else if (choice == choiceNr4)
        {
            controlAnswer(choiceNr4);
        }
        else if (choice == commit)
        {
            validateWrittenAnswer();
        }

    }

    /**
     * updates buttons and fields
     */
    public void updateButtonsAndFields()
    {

        topLabel.setText(welcome + counter);
        score.setText("" + points);
        wordToTranslate.setText(game.getWord(counter - 1)[0]);
        inputField.setText("");
        inputField.requestFocus(true);

        choiceNr1.setEnabled(true);
        choiceNr2.setEnabled(true);
        choiceNr3.setEnabled(true);
        choiceNr4.setEnabled(true);

        choiceNr1.setText(game.getRandomAnswer(game.getWord(counter - 1)[1]));
        choiceNr1.setBackground(color);
        choiceNr2.setText(game.getRandomAnswer(game.getWord(counter - 1)[1]));
        choiceNr2.setBackground(color);
        choiceNr3.setText(game.getRandomAnswer(game.getWord(counter - 1)[1]));
        choiceNr3.setBackground(color);
        choiceNr4.setText(game.getRandomAnswer(game.getWord(counter - 1)[1]));
        choiceNr4.setBackground(color);

        mascotBubble.setIcon(new ImageIcon("images//" + lives + ".png"));

        int order = random.nextInt(4);

        switch (order)
        {

            case 0:
                choiceNr1.setText(game.getWord(counter - 1)[1]);
                break;
            case 1:
                choiceNr2.setText(game.getWord(counter - 1)[1]);
                break;
            case 2:
                choiceNr3.setText(game.getWord(counter - 1)[1]);
                break;
            case 3:
                choiceNr4.setText(game.getWord(counter - 1)[1]);
                break;

        }

    }

    /**
     * checks the answers
     *
     * @param knapp answer button
     */
    private void controlAnswer(JButton knapp)
    {

        choiceNr1.setEnabled(false);
        choiceNr2.setEnabled(false);
        choiceNr3.setEnabled(false);
        choiceNr4.setEnabled(false);

        greenLightCorrectAnswer();

        if (!(knapp.getText().equals(game.getWord(counter - 1)[1])))
        {
            knapp.setBackground(Color.RED);
        }
        else
        {
            points++;
        }

        counter++;
        next();
    }

    /**
     * next starts the timer
     */
    private void next()
    {

        ActionListener listener = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {

                if (counter == 11)
                {

                    game.saveScore(points);
                    main.goFromGameRunToResult();

                }
                else
                {
                    updateButtonsAndFields();
                }
            }
        };
        Timer timer = new Timer(1100, listener);
        timer.start();
        timer.setRepeats(false);

    }

    /**
     * button turns greent if answer is correct
     */
    private void greenLightCorrectAnswer()
    {

        for (JButton jb : buttonList)
        {
            if (jb.getText().equals(game.getWord(counter - 1)[1]))
            {
                jb.setBackground(Color.GREEN);
            }
        }
    }

    /**
     * validates the answers
     */
    private void validateWrittenAnswer()
    {

        lives--;

        String answer = inputField.getText().toLowerCase().trim();
        game.saveScore(points);
        if (counter == 10)
        {

            if (answer.equals(game.getWord(counter - 1)[1]))
            {
                points++;
                game.saveScore(points);
            }
            if (level == 2)
            {
                timer2.stop();              
            }
            
            main.goFromGameRunToResult();

        }
        else if (answer.equals(game.getWord(counter - 1)[1]))
        {
            counter++;
            points++;
            lives = 3;
            timer2.stop();
            countDownProgressBar();
            updateButtonsAndFields();

        }
        else if (lives == 0 && level == 1)
        {
            counter++;
            lives = 3;
            updateButtonsAndFields();
        }
        else if (!answer.equals(game.getWord(counter - 1)[1]) && level == 2)
        {

            counter++;
            timer2.stop();
            countDownProgressBar();
            updateButtonsAndFields();
        }

        mascotBubble.setIcon(new ImageIcon("images//" + lives + ".png"));
    }

    /**
     * progress bars setup
     */
    public void countDownProgressBar()
    {
        ActionListener listener2 = new ActionListener()
        {
            int countdown = 200;

            public void actionPerformed(ActionEvent ae)
            {
                countdown--;
                progressBar.setValue(countdown);

                if (countdown < 1 && level == 2 && counter < 11)
                {
                    JOptionPane.showMessageDialog(null, "Tiden ute!");
                    countdown = 200;
                    counter++;
                    updateButtonsAndFields();
                    //timer.stop();
                    // CountDownProgressBar();
                }
            }
        };
        timer2 = new Timer(80, listener2);
        timer2.start();
    }

    

    

}
