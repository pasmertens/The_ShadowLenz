package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

import gameengine.*;

public class BattlePanel extends JPanel {
    private JPanel encounterPanel;
    private JPanel fightPanel;
    private JPanel logPanel;

    private JLabel encounterLabel;
    private JLabel fightLabel;
    private JLabel playerDamageLabel;
    private JLabel enemyDamageLabel;
    
    private JButton stealButton;
    private JButton fightButton;
    private JButton attackButton;
    private JButton returnButton;

    private HealthBar pHealthBar;
    private HealthBar enHealthBar;

    private String enemyname; 

    public BattlePanel(Player p, Enemy en, int playerdamage, int enemydamage, GameFrame f) {
        initComponents(p, en, playerdamage, enemydamage, f);
    }

    
    
    

    private void initComponents(Player p, Enemy en, int playerdamage, int enemydamage, GameFrame f) {
        setLayout(new BorderLayout());
        encounterPanel = new JPanel();
        fightPanel = new JPanel();
        logPanel = new JPanel();

        enemyname = en.getName();

        encounterLabel = new JLabel("Ein " + enemyname + " steht vor dir");
        fightLabel = new JLabel("Was willst du tun?");
        playerDamageLabel = new JLabel("Du hast den " + enemyname + " angegriffen und ihm " + playerdamage + " schaden zugefügt");
        enemyDamageLabel = new JLabel ("Der " + enemyname + " hat dich angegriffen und dir " + enemydamage + " schaden zugefügt");

        stealButton = new JButton("Den Schlüssel klauen");
        fightButton = new JButton("Kämpfen");
        attackButton = new JButton("Angreifen");
        returnButton = new JButton("Ok");

        pHealthBar =  new HealthBar(p, f);
        enHealthBar = new HealthBar(en, f);

        JPanel HealthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, f.getWidth()/2, f.getHeight()/20));
        HealthPanel.setOpaque(false);
        HealthPanel.add(pHealthBar);
        HealthPanel.add(enHealthBar);

        encounterPanel = createPanel(f);
        
        fightPanel.setBounds(20, 300, 746, 100);
        fightPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(137,112,88)));
        fightPanel.setLayout(null);

        fightLabel.setBounds(   
            (int) (fightPanel.getWidth() * 0.5 - 170), 
            (int) (fightPanel.getHeight() * 0.9), 
            340, 
            20);
        fightPanel.add(fightLabel);

        attackButton.setBounds(
            (int) (fightPanel.getWidth() * 0.5 - 60), 
            (int) (fightPanel.getHeight() * 0.5), 
            120, 
            30);
        fightPanel.add(attackButton);

        logPanel.setBounds(20, 300, 746, 100);
        logPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(137,112,88)));
        logPanel.setLayout(null);

        playerDamageLabel.setBounds(   
            (int) (logPanel.getWidth() * 0.5 - 170), 
            (int) (logPanel.getHeight() * 0.9), 
            340, 
            20);
        logPanel.add(playerDamageLabel);

        enemyDamageLabel.setBounds(   
            (int) (logPanel.getWidth() * 0.5 - 170), 
            (int) (logPanel.getHeight() * 0.7), 
            340, 
            20);
        logPanel.add(enemyDamageLabel);

        returnButton.setBounds(
            (int) (logPanel.getWidth() * 0.5 - 60), 
            (int) (logPanel.getHeight() * 0.5), 
            120, 
            30);
        logPanel.add(returnButton);

        encounterPanel.setVisible(true);
        fightPanel.setVisible(false);
        logPanel.setVisible(false);

        add(HealthPanel);
        add(encounterPanel);
        add(fightPanel);
        add(logPanel);
    }

    public JPanel createPanel(JFrame f) {
        JPanel panel = new JPanel();
        panel.setSize(f.getWidth()-f.getWidth()/30, f.getHeight()/4); //muss hier trotz set Bounds nochmal gesetzt werden, 
                                                                      //da sonst die SubPanels keine Size übernehmen können
        panel.setBounds(f.getWidth()/60, (int) (f.getHeight()*0.7), panel.getWidth(), panel.getHeight());
        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(137,112,88)));
        panel.setLayout(null);

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, panel.getHeight()/10));
        textPanel.setOpaque(false);
        textPanel.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        textPanel.add(encounterLabel);
        panel.add(textPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth()/4, panel.getHeight()/2));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(0, 0, panel.getWidth(), panel.getHeight());

        fightButton.setPreferredSize(new Dimension(f.getWidth()/5, f.getHeight()/18));
        buttonPanel.add(fightButton);    

        stealButton.setPreferredSize(new Dimension(f.getWidth()/5, f.getHeight()/18));
        buttonPanel.add(stealButton);
        
        panel.add(buttonPanel);
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Player p = new Player();
                Goblin en = new Goblin();
                GameFrame f = new GameFrame();
                f.setSize(1200, 675);

                BattlePanel battleScreen = new BattlePanel(p, en, 1, 2, f);

                
                
                f.add(battleScreen);
                f.setVisible(true);
            }
        });
    }
    
}

