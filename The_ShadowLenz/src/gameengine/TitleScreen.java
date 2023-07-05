package gameengine;

import javax.swing.*;
import java.awt.*;

public class TitleScreen {
    public static void main(String[] args) {
        JLabel banner = new JLabel("The ShadowLenz");
        banner.setFont(new Font("Serif", Font.BOLD, 24));
        banner.setHorizontalAlignment(SwingConstants.CENTER);
        banner.setForeground(Color.WHITE);

        JLabel question = new JLabel("Willst du den Dungeon betreten?");
        question.setFont(new Font("Serif", Font.PLAIN, 16));
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.BLACK);
        panel.add(banner);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between banner and question
        panel.add(question);

        Object[] options = new Object[]{"Yes", "No"};
        JOptionPane optionPane = new JOptionPane(
                panel,
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                null
        );

        JDialog dialog = optionPane.createDialog(null, "Dungeon Entrance");
        dialog.setSize(320, 180);
        dialog.setResizable(false);
        dialog.setVisible(true);

        Object choice = optionPane.getValue();

        if (choice == options[0]) {
            JFrame frame = new JFrame("Player Movement");
            PlayerMovement playerMovement = new PlayerMovement();
            frame.add(playerMovement);
            frame.setSize(PlayerMovement.ROOM_WIDTH * 20, PlayerMovement.ROOM_HEIGHT * 20);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.addKeyListener(playerMovement);
        } else if (choice == options[1]) {
            JOptionPane.showMessageDialog(
                    null,
                    "Feigling! Du wirst auf ewig mit dem Scham leben müssen nicht den Dungeon betreten zu haben.",
                    "Feigling",
                    JOptionPane.WARNING_MESSAGE
            );
            System.exit(0);
        }
    }
}



