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
        setLayout(null);
        
        enemyname = en.getName();

        encounterLabel = new JLabel("Ein " + enemyname + " steht vor dir");
        fightLabel = new JLabel("Was willst du tun?");
        playerDamageLabel = new JLabel("Du hast den " + enemyname + " angegriffen und ihm " + playerdamage + " schaden zugefügt");
        enemyDamageLabel = new JLabel ("Der " + enemyname + " hat dich angegriffen und dir " + enemydamage + " schaden zugefügt");

        pHealthBar =  new HealthBar(p, f);
        enHealthBar = new HealthBar(en, f);

        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, (int) (f.getWidth() * 0.3), f.getHeight()/20));
        healthPanel.setOpaque(false);
        healthPanel.setBounds(0, 0, f.getWidth(), f.getHeight());
        System.out.println(healthPanel.getBounds());
        healthPanel.add(pHealthBar);
        healthPanel.add(enHealthBar);

        encounterPanel = createEncounterPanel(f);
        fightPanel = createFightPanel(f);
        logPanel = createLogPanel(f);

        fightPanel.setVisible(false);
        encounterPanel.setVisible(false);

        add(encounterPanel);
        add(fightPanel);
        add(logPanel);
        add(healthPanel);
    }

    public JPanel createEncounterPanel(JFrame f) {
        JPanel panel = createInnerPannel(f);

        JPanel textPanel = createTextPanel(panel, encounterLabel);
        JPanel buttonPanel = createButtonPanel(panel);
        
        fightButton = createButton(f, "Kämpfen");
        buttonPanel.add(fightButton);    

        stealButton = createButton(f, "Den Schlüssel klauen");
        buttonPanel.add(stealButton);
        
        panel.add(textPanel);
        panel.add(buttonPanel);
        return panel;
    }

    public JPanel createFightPanel(JFrame f) {
        JPanel panel = createInnerPannel(f);

        JPanel textPanel = createTextPanel(panel, fightLabel);
        JPanel buttonPanel = createButtonPanel(panel);
        
        attackButton = createButton(f, "Angreifen");
        buttonPanel.add(attackButton);
        
        panel.add(textPanel);
        panel.add(buttonPanel);
        return panel;
    }

    public JPanel createLogPanel(JFrame f) {
        JPanel panel = createInnerPannel(f);

        JPanel playerDamagePanel = createTextPanel(panel, playerDamageLabel);
        JPanel enemyDamagePanel = createTextPanel(panel, enemyDamageLabel);
        enemyDamagePanel.setBounds(0,  panel.getHeight()/6, panel.getWidth(), panel.getHeight());
        JPanel buttonPanel = createButtonPanel(panel);
        buttonPanel.setBounds(0, panel.getHeight()/9, panel.getWidth(), panel.getHeight());

        returnButton = createButton(f, "Ok");
        buttonPanel.add(returnButton);
        
        panel.add(playerDamagePanel);
        panel.add(enemyDamagePanel);
        panel.add(buttonPanel);
        return panel;
    }

    
    public JPanel createInnerPannel(JFrame f) {
        JPanel panel = new JPanel();
        /* 
         * Setzt das Panel auf zum frame relative Größe   
         * setSize muss hier trotz setBounds ausgeführt werden, 
         * da das Panel sonst keine Größe hat, auf die die Subpanels zurückgreifen können 
         */
        panel.setSize(f.getWidth()-f.getWidth()/30, f.getHeight()/4); 
        panel.setBounds(f.getWidth()/60, (int) (f.getHeight()*1), panel.getWidth(), panel.getHeight());                                                                                                                                                   panel.setBounds(f.getWidth()/60, (int) (f.getHeight()*0.7), panel.getWidth(), panel.getHeight());
        panel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(137,112,88), 2, true));
        panel.setLayout(null);
        return panel;
    }
    
    private JPanel createTextPanel(JPanel p, JLabel text) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, p.getHeight()/9));
        panel.setOpaque(false);
        panel.setBounds(0, 0, p.getWidth(), p.getHeight());
        panel.add(text);
        
        return panel;
    }

    private JPanel createButtonPanel(JPanel p) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, p.getWidth()/8, (int) (p.getHeight() * 0.4)));
        panel.setOpaque(false);
        panel.setBounds(0, 0, p.getWidth(), p.getHeight());
        return panel;
    }

    private JButton createButton(JFrame f, String s) {
        JButton button = new JButton(s);
        button.setPreferredSize(new Dimension(f.getWidth()/5, f.getHeight()/18));
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(new java.awt.Color(137,112,88), 2, true));
        button.setFocusable(false);

        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                button.setBorder(BorderFactory.createLineBorder(new java.awt.Color(137,112,88), 5, true));
            }
            @Override
            public void mouseExited(MouseEvent e){
                button.setBorder(BorderFactory.createLineBorder(new java.awt.Color(137,112,88), 2, true));
            }
        });

        return button;
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Player p = new Player();
                Goblin en = new Goblin();
                GameFrame f = new GameFrame();
                f.setSize(1200, 675);
                //f.setUndecorated(false);
                BattlePanel battleScreen = new BattlePanel(p, en, 1, 2, f);

                
                
                f.add(battleScreen);
                f.setVisible(true);
            }
        });
    }
    
}

