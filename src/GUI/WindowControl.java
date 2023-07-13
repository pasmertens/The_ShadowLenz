package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowControl extends JPanel {
    protected JButton exitButton;
    protected JButton fullScreenButton;
    protected JButton minimizeButton;

    private boolean isFullScreen;

   public WindowControl(GameFrame f) {
        initButtons(f);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        setBackground(Color.BLUE);
        add(minimizeButton);
        add(fullScreenButton);
        add(exitButton);
        setOpaque(false);
    }

    private void initButtons(GameFrame f) {
        exitButton = createButton("CloseIcon");
        fullScreenButton = createButton("MaximizeIcon");     
        minimizeButton = createButton("MinimizeIcon");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add code to handle exit button click
                JLabel message = new JLabel("<html>Willst du das Spiel wirklich verlassen? Dein Fortschritt geht verloren<html>");
                Object[] options = new Object[]{"JA", "NEIN"};
                JOptionPane optionPane = new JOptionPane(
                    message, 
                    JOptionPane.WARNING_MESSAGE, 
                    JOptionPane.YES_NO_OPTION, 
                    null, 
                    options, 
                    null);
                JDialog exitConfirm = optionPane.createDialog("Spiel verlassen?");
                exitConfirm.setSize(320, 180);
                exitConfirm.setResizable(false);
                exitConfirm.setVisible(true);
                if (optionPane.getValue() == options [0]) {
                    System.exit(0);
                }
            }
        });

        fullScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFullScreen == false) {
                    f.setFullScreen();
                    isFullScreen = true;
                    //f.getContentPane().setSize(new Dimension(f.getWidth(), f.getHeight()));
                    setSize(getSize());
                    System.out.println(f.getSize());
                    revalidate();
                    repaint();
                } else {
                    f.setWindowed();
                    isFullScreen = false;
                    setPreferredSize(new Dimension(f.getWidth(), f.getHeight()));
                    revalidate();
                    repaint();
                    System.out.println(getSize());
                }
            }
        });

        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setState(JFrame.ICONIFIED);
            }
        });
    }

    private JButton createButton(String iconname) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(20, 20));
        String iconpath = "/images/" + iconname + ".png";
        ImageIcon i = new ImageIcon(getClass().getResource(iconpath));
        Image img = i.getImage() ; 
        Image scaledimg = img.getScaledInstance((int) button.getPreferredSize().getHeight(), (int) button.getPreferredSize().getWidth(), Image.SCALE_SMOOTH ) ;  
        i = new ImageIcon(scaledimg);
        button.setIcon(i);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
        button.setFocusable(false);

        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                button.setBorderPainted(true);
            }
            @Override
            public void mouseExited(MouseEvent e){
                button.setBorderPainted(false);
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        GameFrame gFrame = new GameFrame();
        JLayeredPane pane = new JLayeredPane();
        TitlePanel tPan = new TitlePanel(gFrame);
        WindowControl winCon = new WindowControl(gFrame);
        gFrame.setTitle("Window Control Example");
        gFrame.setUndecorated(true);
        gFrame.setSize(1200, 675);
        //pane.setLayout(new BorderLayout());
        gFrame.setContentPane(pane);
        tPan.setSize(new Dimension(gFrame.getWidth(), gFrame.getHeight()));
        winCon.setSize(new Dimension(gFrame.getWidth(), gFrame.getHeight()));
        gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gFrame.getContentPane().add(tPan, JLayeredPane.DEFAULT_LAYER);
        gFrame.getContentPane().add(winCon, JLayeredPane.DRAG_LAYER);
        
        gFrame.setVisible(true);
    }
}
