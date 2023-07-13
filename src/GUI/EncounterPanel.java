package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import gameengine.CoreLogic;

public class EncounterPanel extends JPanel {

    private JButton fightButton;
    private JButton stealButton;

    private JLabel encounterLabel;

    private JFrame f;

    private CoreLogic l;

    public EncounterPanel(JFrame frame, CoreLogic logic) {
        f = frame;

        setProperties();

        encounterLabel = new JLabel("null");

        JPanel textPanel = createTextPanel(encounterLabel);
        JPanel buttonPanel = createButtonPanel();
        
        fightButton = createButton(f, "Kämpfen");
        fightButton.addActionListener(e -> {
            logic.phase = 43;
        });

        stealButton = createButton(f, "Den Schlüssel klauen");
        stealButton.addActionListener(e -> {
            
        });
        
        buttonPanel.add(fightButton);   
        buttonPanel.add(stealButton);
        
        add(textPanel);
        add(buttonPanel);
    }
       
    
    

    public void setProperties() {
        /* 
         * Setzt das Panel auf zum frame relative Größe   
         * setSize muss hier trotz setBounds ausgeführt werden, 
         * da das Panel sonst keine Größe hat, auf die die Subpanels zurückgreifen können 
         */
        setSize(f.getWidth()-f.getWidth()/30, f.getHeight()/4); 
        setBounds(f.getWidth()/60, (int) (f.getHeight()*1), getWidth(), getHeight());                                                                                                                                                   
        setBorder(BorderFactory.createLineBorder(new java.awt.Color(137,112,88), 2, true));
        setLayout(null);
    }
    
    private JPanel createTextPanel(JLabel text) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, getHeight()/9));
        panel.setOpaque(false);
        panel.setBounds(0, 0, getWidth(), getHeight());
        panel.add(text);
        
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, getWidth()/8, (int) (getHeight() * 0.4)));
        panel.setOpaque(false);
        panel.setBounds(0, 0, getWidth(), getHeight());
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

    public void updateText(String newtext) {
        encounterLabel.setText(newtext);
    }
}