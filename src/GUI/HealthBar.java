package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import gameengine.Creature;

public class HealthBar extends JProgressBar {
    private JLabel healthLabel;

    private int maxhp;
    private int currenthp;

public HealthBar(Creature c, JFrame f) {
    updateVariables(c);

    healthLabel = new JLabel(currenthp + "/" + maxhp);
    resizeBar(f);
    setBackground(new java.awt.Color(250, 250, 250));
    setForeground(new java.awt.Color(204, 51, 0)); 
    setMaximum(maxhp);
    setValue(currenthp);
    setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0,0,0)));
    setOpaque(true);
    setLayout(new FlowLayout(FlowLayout.CENTER, 0, getHeight()/2-10));
    
    add(healthLabel);
    
    }

    public void updateVariables(Creature c) {
        currenthp = c.getCurrentHP();
        maxhp = c.getMaxHP();
    }

    public void updateBar(Creature c) {
        updateVariables(c);
        healthLabel.setText(currenthp + "/" + maxhp);
        setValue(currenthp);
    }
    
    public void resizeBar(JFrame f) {
        setSize(new Dimension(f.getWidth()/5,   f.getHeight()/20));
        setPreferredSize(getSize());
        System.out.println(getSize());        
    }
}
