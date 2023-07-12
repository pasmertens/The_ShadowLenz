package guiSideboard;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TitlePane extends JPanel {
    private JPanel titlePanel;
    private JPanel backgroundPanel;
    private JButton enterButton;
    private JButton leaveButton;
    private JLabel questionLabel; //TODO erstellen oder nicht?
    private Image backgroundImage;

    private JButton FSButton;

    public TitlePane(JFrame GameFrame) {
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/TitleScreen.png"));
        backgroundImage = backgroundIcon.getImage();
        
        backgroundPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        setLayout(null);
        componentPanel.setOpaque(false);
    
        enterButton = new JButton("JA"); //TODO create messages
        leaveButton = new JButton("NEIN");        
        
        enterButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }
        });

        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }   
        });

        titlePanel.add(enterButton);
        titlePanel.add(leaveButton);
        FSButton();
    }

    private void initScreen(JFrame GameFrame) {
        add(titlePanel);
        add(backgroundPanel);
        setSize(1200, 675);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        resizeComponents();
    /*
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                resizeComponents();  
            }
        });
    */
    }
    }

    private void initComponents() {
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/TitleScreen.png"));
        backgroundImage = backgroundIcon.getImage();
        
        backgroundPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        
        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setOpaque(false);
    
        enterButton = new JButton("JA"); //TODO create messages
        leaveButton = new JButton("NEIN");        
        
        enterButton.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }
        });

        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO add code
            }   
        });

        titlePanel.add(enterButton);
        titlePanel.add(leaveButton);
        FSButton();
    }

    private void initScreen(JFrame GameFrame) {
        initComponents();
        add(titlePanel);
        add(backgroundPanel);
        setSize(1200, 675);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);

        resizeComponents();
    /*
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                resizeComponents();  
            }
        });
    */
    }

    private void resizeComponents() {
        titlePanel.setBounds(0 ,0 , getWidth(), getHeight());
        enterButton.setBounds(getWidth()/2 - 150,(int) (getHeight() * 0.55), 100, 35);
        leaveButton.setBounds(getWidth()/2 +  50, (int) (getHeight() * 0.55), 100, 35); 

        FSButton.setBounds(getWidth() - 100, 0, 100, 35);
    }

    private void setFullScreen() {
        setSize(0, 0, GameFrame.get)
        resizeComponents();
    }

    private void FSButton() {
        FSButton = new JButton("Fullscreen");
        
        FSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFullScreen();
            }   
        });

        titlePanel.add(FSButton);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TitleScreenFrame(); 
            }
        });
    }
}

