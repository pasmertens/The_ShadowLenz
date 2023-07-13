package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class GameFrame extends JFrame{

    private JLayeredPane layers;

    private Dimension windowedSize;

    public GameFrame() {
        //setze Standardwerte für die Fensteransicht
        windowedSize = new Dimension(1200, 675);
        setSize(windowedSize);
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initLayeredPane();
    }

    public void setFullScreen() {
        setExtendedState(MAXIMIZED_BOTH);
        layers.setSize(getWidth(), getHeight());
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    public void setWindowed() {
        setSize(windowedSize);
        layers.setSize(getWidth(), getHeight());
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    private void initLayeredPane() {
        layers = new JLayeredPane();
        //layers.setLayout(new BorderLayout());
        setContentPane(layers);
    }
}