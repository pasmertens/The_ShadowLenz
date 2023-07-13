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
        enterButton = createButton(f, "JA");
        leaveButton = createButton(f, "NEIN");
        
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k=2;
                setVisible(false);
            }
        });

        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k=3;
                System.exit(0);
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

    private JButton createButton(JFrame f, String s) {
        JButton button = new JButton(s);
        button.setPreferredSize(new Dimension(f.getWidth()/10, f.getHeight()/18));
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(new java.awt.Color(137,112,88), 2, true));
        button.setOpaque(false);
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

    protected void resizeComponents(JFrame frame) {
        f = frame;
        setBounds               ( 0,                     0,                             f.getWidth(),     f.getHeight()   );
        componentPanel.setBounds( 0,                     0,                             f.getWidth(),     f.getHeight()     );
        enterButton.setBounds   ( f.getWidth()/2 - 150,  (int) (f.getHeight() * 0.55),  f.getWidth()/10,  f.getHeight()/18 );
        leaveButton.setBounds   ( f.getWidth()/2 +  50,  (int) (f.getHeight() * 0.55),  f.getWidth()/10,  f.getHeight()/18 ); 
    }

    public int returnK() {
        return k;
    }

    public static void main(String[] args) {
        GameFrame gFrame = new GameFrame();
        WindowControl winCon = new WindowControl(gFrame);
        gFrame.setSize(1200, 675);
        TitlePanel tPanel = new TitlePanel(gFrame);
        gFrame.add(tPanel);
        gFrame.add(winCon);
        gFrame.setVisible(true);
    }

}    
