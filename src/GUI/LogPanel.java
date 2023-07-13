package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LogPanel extends JPanel {

    private JButton returnButton;

    private JLabel eventLabel;
    private JLabel consequenceLabel;


    private JFrame f;

    public LogPanel(JFrame frame) {
        f = frame;

        setProperties();

        JPanel eventPanel = createTextPanel(eventLabel);
        JPanel consequencePanel = createTextPanel(consequenceLabel);
        consequencePanel.setBounds(0,  getHeight()/6, getWidth(), 5 * getHeight()/6);
        
        JPanel buttonPanel = createButtonPanel();
        buttonPanel.setBounds(0, getHeight()/9, getWidth(), 8 * getHeight()/9);

        returnButton = createButton("Ok");

        returnButton.addActionListener(e -> {
            //mache die benötigten Komponenten sichtbar und den Rest unsichtbar
            //logPanel.setVisible(false);
            //fightPanel.setVisible(true);
        });

        buttonPanel.add(returnButton);
        
        add(eventPanel);
        add(consequencePanel);
        add(buttonPanel);      
    }

    private void setProperties() {
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

    private JButton createButton(String s) {
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

    public void updateText(String eventText, String consequenceText) {
        if (eventText != null) {
            eventLabel.setText(eventText);
        }
        if (eventText != null) {
            consequenceLabel.setText(consequenceText);
        }
    }
}
