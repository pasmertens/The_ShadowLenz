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
    
    private JButton stealButton;
    private JButton fightButton;
    private JButton attackButton;
    private JButton returnButton;

    private HealthBar pHealthBar;
    private HealthBar enHealthBar;

    public BattlePanel(CoreLogic logic, GameFrame f, ImageIcon backgroundIcon) {
        setLayout(null);

        pHealthBar =  new HealthBar(p, f);
        enHealthBar = new HealthBar(en, f);

        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, (int) (f.getWidth() * 0.3), f.getHeight()/20));
        healthPanel.setOpaque(false);
        healthPanel.setBounds(0, 0, f.getWidth(), f.getHeight());
        System.out.println(healthPanel.getBounds());
        healthPanel.add(pHealthBar);
        healthPanel.add(enHealthBar);

        

        stealButton.addActionListener(e -> {

        });

        attackButton.addActionListener(e -> {
            fightPanel.setVisible(false);
            logPanel.setVisible(true);
            
            //aktualisiere die HP Leiste
            //HealthBar.updateBar();
        });
        
        

        fightPanel.setVisible(false);
        logPanel.setVisible(false);

        add(encounterPanel);
        add(fightPanel);
        add(logPanel);
        add(healthPanel);
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

