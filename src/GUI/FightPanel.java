package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FightPanel extends JPanel {

    private JButton attackButton;

    private JLabel fightLabel;

    private JFrame f;

    public FightPanel(JFrame frame) {
        f = frame;
        setProperties();

        fightLabel = new JLabel("Was willst du tun?");

        JPanel textPanel = createTextPanel(fightLabel);
        JPanel buttonPanel = createButtonPanel();
        
        attackButton = createButton(f, "Angreifen");
        buttonPanel.add(attackButton);    

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
}
