package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI    {

    private JFrame homeScreen;
    private JFrame gameScreen;
    private JPanel homePanel;
    private JPanel gamePanel;
    private JButton buttonEnter;
    private JButton buttonLeave;
    private JLabel questionLabel;
    private JLabel backgroundLabel;
    private JLabel leavingLabel;

/*
 * TODO Die einzelnen frames, labels etc will ich der Übersichtlichkeit 
 * halber noch klassieren, aber damit erstmal was da ist, schonmal in einem
 */

    public GUI() {
        
        gameScreen = new JFrame();  
        gameScreen.setSize(1200, 675);
        gameScreen.setLocationRelativeTo(null);

        backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/images/RoomBackground.png"))); 
        //TODO soll noch so bearbeitet werden, dass es sich automatisch an die Screen größe anpasst

        gamePanel = new JPanel();
        gamePanel.add(backgroundLabel);
        
        
        gameScreen.add(gamePanel, BorderLayout.CENTER);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setTitle("The ShadowLenz"); 
        gameScreen.pack();


        buttonEnter = new JButton("Enter Dungeon!");
        buttonEnter.setBounds(275, 250, 250, 50);
        buttonEnter.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(false);
                gameScreen.setVisible(true);
            }
        });
        

        buttonLeave = new JButton("'better leave, while I still can!'");
        buttonLeave.setBounds(275, 350, 250, 50);
        buttonLeave.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                buttonEnter.setVisible(false);
                buttonLeave.setVisible(false);
                questionLabel.setVisible(false);
                leavingLabel = new JLabel("<html>Ashamed of your own fear you returned home and never came back to this place. Coward!");
                leavingLabel.setBounds(300, 200, 200, 100);

                homePanel.add(leavingLabel);
            }   
        });
        
        homeScreen = new JFrame();
        homeScreen.setSize(800, 600);
        homeScreen.setLocationRelativeTo(null);

        questionLabel = new JLabel("<html>You are standing in front of the entry of a dungeon, a rotten smell gets into your nose and you hear loud growling. Do you want to enter the dungeon?</html>");
        questionLabel.setBounds(200, 100, 400, 100);

        homePanel = new JPanel();
        homePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        homePanel.setLayout(null);
        homePanel.add(questionLabel);
        homePanel.add(buttonEnter);
        homePanel.add(buttonLeave);
        
        
        homeScreen.add(homePanel, BorderLayout.CENTER);
        homeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeScreen.setTitle("GUI");
        homeScreen.setVisible(true);
    }

    public static void main(String[] args) {   
        new GUI();
    }
}
