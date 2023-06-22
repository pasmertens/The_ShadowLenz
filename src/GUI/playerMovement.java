package GUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameengine.*;
public class playerMovement extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public player p;
	private room r;
	public enemy m;
	
	public playerMovement() {};
	
	public playerMovement(player s, enemy t, room u){
		p = s;
		m = t;
		r = u;
	}
	

	 public void keyPressed(KeyEvent e) {
	        int keyCode = e.getKeyCode();
	        int lastLocation[] = new int[2];

	        if (keyCode == KeyEvent.VK_UP) {
	            lastLocation = p.currentLocation;
	        	p.currentLocation[1]--;
	        } else if (keyCode == KeyEvent.VK_DOWN) {
	        	lastLocation = p.currentLocation;
	        	p.currentLocation[1]++;
	        } else if (keyCode == KeyEvent.VK_LEFT) {
	        	lastLocation = p.currentLocation;
	        	p.currentLocation[0]--;
	        } else if (keyCode == KeyEvent.VK_RIGHT) {
	        	lastLocation = p.currentLocation;
	        	p.currentLocation[0]++;
	        }	
	        
	        if (r.room[ p.currentLocation[1]][ p.currentLocation[0]] != '#' && r.room[ p.currentLocation[1]][ p.currentLocation[0]] != 'D') { // Check for wall and door
	            
	            if (Math.abs( p.currentLocation[0] - m.spawnpoint[0]) <= 1 && Math.abs( p.currentLocation[1] - m.spawnpoint[1]) <= 1) {// Check for monster proximity
	                
	            } else {
	                // Update player position
	                r.room[lastLocation[1]][lastLocation[0]] = ' ';
	               
	                r.room[p.currentLocation[1]][p.currentLocation[0]] = 'P';
	            }
	        }
	    }

		public void keyReleased(KeyEvent e) {
		}


		public void keyTyped(KeyEvent e) {
		}
	
	
	
}
