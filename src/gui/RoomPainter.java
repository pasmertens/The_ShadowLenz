package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameengine.*;

public class RoomPainter extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	
	
	
	public void keyPressed(KeyEvent e, player p, enemy m, room r) {
	    int keyCode = e.getKeyCode();
	    int newX = p.currentLocation[0];
	    int newY = p.currentLocation[1];

	    if (keyCode == KeyEvent.VK_UP) {
	        newY--;
	    } else if (keyCode == KeyEvent.VK_DOWN) {
	    	newY++;
	    } else if (keyCode == KeyEvent.VK_LEFT) {
	    	newX--;
	    } else if (keyCode == KeyEvent.VK_RIGHT) {
	    	newX++;
	    }

	    if (r.room[newY][newX] != '#' && r.room[newY][newX] != 'D') { // Check for wall and door
	        // Check for monster proximity
	        if (Math.abs(newX - m.spawnpoint[0]) <= 1 && Math.abs(newY - m.spawnpoint[1]) <= 1) {
	            coreLogic.encounter(p, m);
	        } else {
	            // Update player position
	            r.room[p.currentLocation[1]][p.currentLocation[0]] = ' ';
	            p.currentLocation[0] = newX;
	            p.currentLocation[1] = newY;
	            r.room[p.currentLocation[0]][p.currentLocation[1]] = 'P';
	        }
	    } else if (r.room[newY][newX] == 'D' && newX == (r.width - 1)) {
	        if (p.keyCount>0) {
	            int result = JOptionPane.showConfirmDialog(null, "Do you want to enter the door?", "Enter Door", JOptionPane.YES_NO_OPTION);
	            if (result == JOptionPane.YES_OPTION) {
	                r.room[p.currentLocation[1]][p.currentLocation[0]] = ' '; // Clear the player's previous position
//	                repaint(); // Redraw the room after clearing the player's position
	                p.keyCount -= 1; // Remove the key after entering the new room
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Du brauchst einen Schlüssel um diese Tür zu öffnen");
	        }
	    }
//	    repaint();
	}
	public void keyReleased(KeyEvent e) {
	}


	public void keyTyped(KeyEvent e) {
	}
	
	
	public static void main(String[] args) {    
    	
        JFrame frame = new JFrame("Player Movement");
        RoomPainter rp = new RoomPainter();
        frame.add(rp);
        frame.setSize(gameeingine.room.width * 20, r.height * 20);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(rp);
        frame.setSize(400, 225);
        frame.setResizable(true); // Make the window non-resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PlayerMovement());
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}

}
