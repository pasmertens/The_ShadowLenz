package guiSideboard;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class WindowControl extends JPanel {
    protected JButton exitButton;
    protected JButton fullScreenButton;
    protected JButton minimizeButton;


    public WindowControl() {
        initButtons();
        setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        setBackground(Color.BLACK);
        add(minimizeButton);
        add(fullScreenButton);
        add(exitButton);
        setVisible(true);
    }

    private void initButtons() {
        exitButton = new JButton(".");
        fullScreenButton = new JButton(".");
        minimizeButton = new JButton(".");

        exitButton.setPreferredSize(new Dimension(20, 20));
        fullScreenButton.setPreferredSize(new Dimension(20, 20));
        minimizeButton.setPreferredSize(new Dimension(20, 20));

        exitButton.setForeground(Color.RED);
        fullScreenButton.setForeground(Color.BLUE);
        minimizeButton.setForeground(Color.GREEN);


        exitButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }   
        });

        fullScreenButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }   
        });

        minimizeButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }   
        });
    }
    
    public static void main(String[] args) {
        JFrame gFrame = new JFrame();
        JLayeredPane pane = new JLayeredPane();
        WindowControl winCon = new WindowControl();
        gFrame.setTitle("TOOL_TIP_TEXT_KEY");
        gFrame.setUndecorated(true);
        gFrame.setSize(800, 600);
        pane.add(winCon, JLayeredPane.PALETTE_LAYER);
        gFrame.add(pane);
        gFrame.setVisible(true);

        
    }
    
}
