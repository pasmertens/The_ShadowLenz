package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TitlePanel extends JPanel {
    private JPanel componentPanel;
    private JButton enterButton;
    private JButton leaveButton;
    private Image backgroundImage;
    private JFrame f;
    private int k;
    private Dimension buttonSize;

    public TitlePanel(JFrame frame) {
        f = frame;
        setProperties();
        initBackground();
        initButtons();
        initComponentPanel();
        add(componentPanel);        
        //resizeComponents();
    }

    private void setProperties() {
        setSize(f.getWidth(), f.getHeight());
        setLayout(new BorderLayout());
    }
    
    private void initBackground() {
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/TitleScreen.png"));
        backgroundImage = backgroundIcon.getImage().getScaledInstance(2560, 1440, Image.SCALE_SMOOTH);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void initButtons() {
        enterButton = new JButton("JA");
        leaveButton = new JButton("NEIN");

        enterButton.setForeground(Color.WHITE);
        leaveButton.setForeground(Color.WHITE);
        
        //enterButton.setBackground(new Color(0, 0, 0, 50));
        enterButton.setContentAreaFilled(false);
        enterButton.setBorderPainted(true);
        enterButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
        //enterButton.setOpaque(false);
        enterButton.setFocusable(false);

        leaveButton.setContentAreaFilled(false);
        leaveButton.setBorderPainted(true);
        leaveButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
        leaveButton.setOpaque(false);
        leaveButton.setFocusable(false);

        
        

        enterButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                enterButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
            }
            @Override
            public void mouseExited(MouseEvent e){
                enterButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
            }
        });

        leaveButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                leaveButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
            }
            @Override
            public void mouseExited(MouseEvent e){
                leaveButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));
            }
        });
        
        buttonSize = new Dimension(new Dimension((int) (f.getWidth() * 0.1),(int) (f.getHeight() * 0.05)));

        enterButton.setPreferredSize(buttonSize);
        leaveButton.setPreferredSize(buttonSize);
        //enterButton.setBounds   (   f.getWidth()/2 - 150,       (int) (f.getHeight() * 0.55),       200,            35              );
        //leaveButton.setBounds   (   f.getWidth()/2 +  50,       (int) (f.getHeight() * 0.55),       100,            35              ); 
        
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k=2;
                //TODO add code
            }
        });

        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k=3;
                //TODO add code
            }   
        });
        
    }

    private void initComponentPanel() {
        componentPanel = new JPanel();
        componentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,(int) (f.getWidth() * 0.1), (int) (f.getHeight() * 0.55)));
        componentPanel.setOpaque(false);
        componentPanel.add(enterButton);
        componentPanel.add(leaveButton);
    }

    

    private void resizeComponents() {
        setBounds               (   0,                        0,                                f.getWidth(),   f.getHeight()   );
        componentPanel.setBounds(   0,                        0,                                f.getWidth(),   f.getHeight()     );
        enterButton.setBounds   (   f.getWidth()/2 - 150,       (int) (f.getHeight() * 0.55),       100,            35              );
        leaveButton.setBounds   (   f.getWidth()/2 +  50,       (int) (f.getHeight() * 0.55),       100,            35              ); 
    }

    public int returnK() {
        return k;
    }

    public static void main(String[] args) {
        GameFrame gFrame = new GameFrame();
        WindowControl winCon = new WindowControl(gFrame);
        gFrame.setSize(800, 600);
        TitlePanel tPanel = new TitlePanel(gFrame);
        gFrame.add(tPanel);
        gFrame.add(winCon);
        gFrame.setVisible(true);
    }

}    
