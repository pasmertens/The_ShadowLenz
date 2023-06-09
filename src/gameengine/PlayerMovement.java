package gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.*;


public class PlayerMovement extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
    static final int ROOM_WIDTH = 16;
    static final int ROOM_HEIGHT = 9;
    private int playerX = ROOM_WIDTH / 2 - 7;
    private int playerY = ROOM_HEIGHT / 2;
    private char[][] room = new char[ROOM_HEIGHT][ROOM_WIDTH];
    private int monsterX = ROOM_WIDTH / 2;
    private int monsterY = ROOM_HEIGHT / 2 - 1;
    private boolean hasKey = false;
    private Image backgroundImage;

        public PlayerMovement() {
        	ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/RoomBackground.png"));
            backgroundImage = backgroundIcon.getImage().getScaledInstance(1600, 675,Image.SCALE_SMOOTH);                }

        private void initializeRoom() {
        for (int y = 0; y < ROOM_HEIGHT; y++) {
            for (int x = 0; x < ROOM_WIDTH; x++) {
                if (x == 0 || x == ROOM_WIDTH - 1 || y == 0 || y == ROOM_HEIGHT - 1) {
                    room[y][x] = '#'; // Wall
                } else if (x == playerX && y == playerY) {
                    room[y][x] = 'P'; // Player
                } else {
                    room[y][x] = ' '; // Empty space
                }
            }
        }
        room[ROOM_HEIGHT / 2][(ROOM_WIDTH - ROOM_WIDTH) ] = 'D'; // Left door
        room[ROOM_HEIGHT / 2][(ROOM_WIDTH  - 1) ] = 'D'; // Right door
        room[monsterY][monsterX] = 'M'; // Monster
    }
        
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int yOffset = 0; // Add an offset to move the top wall down
            g.drawImage(backgroundImage, 0, yOffset, getWidth(), getHeight() - yOffset, this);

            int scaleFactorX = getWidth()  / ROOM_WIDTH;
            int scaleFactorY = (getHeight() - yOffset) / ROOM_HEIGHT;

            for (int y = 0; y < ROOM_HEIGHT; y++) {
                for (int x = 0; x < ROOM_WIDTH; x++) {
                    char gridElement = room[y][x];
                    if (gridElement != ' ') {
                        if (gridElement == 'P') {
                            g.setColor(Color.BLUE);
                        } else if (gridElement == 'M') {
                            g.setColor(Color.RED);
                        } else {
                            continue; // Skip to the next iteration if the grid element is not a player or a monster
                        }
                        g.fillRect(x * scaleFactorX, yOffset + (y * scaleFactorY), scaleFactorX, scaleFactorY);
                    }
                }
            }
        }

        public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int newX = playerX;
        int newY = playerY;

        if (keyCode == KeyEvent.VK_UP) {
            newY--;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            newY++;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            newX--;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            newX++;
        }

        if (room[newY][newX] != '#' && room[newY][newX] != 'D') { // Check for wall and door
            // Check for monster proximity
            if (Math.abs(newX - monsterX) <= 1 && Math.abs(newY - monsterY) <= 1) {
                enterCombat();
            } else {
                // Update player position
                room[playerY][playerX] = ' ';
                playerX = newX;
                playerY = newY;
                room[playerY][playerX] = 'P';
            }
        } else if (room[newY][newX] == 'D' && newX == (ROOM_WIDTH - 1)) {
            if (hasKey) {
                int result = JOptionPane.showConfirmDialog(null, "Do you want to enter the door?", "Enter Door", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    room[playerY][playerX] = ' '; // Clear the player's previous position
                    repaint(); // Redraw the room after clearing the player's position
                    enterNewRoom();
                    hasKey = false; // Remove the key after entering the new room
                }
            } else {
                JOptionPane.showMessageDialog(null, "Du brauchst einen Schlüssel um diese Tür zu öffnen");
            }
        }
        repaint();
    }

	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}

    public static void main(String[] args) {    
    	
        JFrame frame = new JFrame("Player Movement");
        PlayerMovement playerMovement = new PlayerMovement();
        frame.add(playerMovement);
        frame.setSize(ROOM_WIDTH * 20, ROOM_HEIGHT * 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(playerMovement);
        frame.setSize(1200, 675);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PlayerMovement());
        frame.setSize(ROOM_WIDTH * 20, ROOM_HEIGHT * 20 + 30);
    }

    private void enterCombat() {
        String[] options = {"Steal", "Attack"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0 || choice == 1) {
            hasKey = true;
            JOptionPane.showMessageDialog(null, "You obtained a key!");
        }
    }
    private void enterNewRoom() {
        room[playerY][playerX] = ' '; // Clear the player's previous position
        initializeRoom();
        // Update player position to one space right of the left door
        playerX = (ROOM_WIDTH - 1) / 2 + 1;
        playerY = ROOM_HEIGHT / 2;
        room[playerY][playerX] = 'P';
    }
    

}

