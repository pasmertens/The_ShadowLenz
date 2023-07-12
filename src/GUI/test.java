package gui;

import java.awt.*;
import javax.swing.*;

public class test extends JFrame {
    public test() {
        setTitle("Resizable Components Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Create and add resizable components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Component 1
        JPanel component1 = new JPanel();
        component1.setBackground(Color.RED);
        add(component1, gbc);

        // Component 2
        JPanel component2 = new JPanel();
        component2.setBackground(Color.GREEN);
        add(component2, gbc);

        // Component 3
        JPanel component3 = new JPanel();
        component3.setBackground(Color.BLUE);
        add(component3, gbc);

        //pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new test();
            }
        });
    }
}
