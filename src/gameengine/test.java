package gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class test {

	public static void printRoom(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);

			}
			System.out.println();
		}
	}

	private static enemy enemySelect() { // decides, which monster will appear in the dungeon
		enemy e;
		
		Random r = new Random();
		
		int i = r.nextInt(4);

		System.out.println(i);
		
		switch (i) {
		case 0:
			e = new oni();
			return e;
		case 1:
			e = new cyclops();
			return e;
		case 2:
			e = new witch();
			return e;
		case 3:
			e = new goblin();
			return e;
		
		default:
			e = new goblin();
			return e;
		}
		
		
		;
		

	}

	public static void main(String[] args) {
		// create new player
		player p = new player();

		// create an enemy
		enemy o = enemySelect();
		// enemySelect(1);

		// try damage, regeneration and attack
		p.damage(12);
		p.regenHP(9);
		// System.out.println(p.getAtk());
		System.out.println(p.currentHP);

		// try random steal function
		if (o.steal(p.stealth) == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		;

		// try room creation
		room test = new room(p.spawnpoint, o.spawnpoint,);

		// try getRoom funktion
		printRoom(test.getRoom());

		/*
		 * 
		 * JFrame frame = new JFrame("Test"); // PlayerMovement playerMovement = new
		 * PlayerMovement(); frame.add(test); frame.setSize(test.width * 20, test.height
		 * * 20); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * frame.setVisible(true); // frame.addKeyListener(playerMovement);
		 * frame.setSize(400, 225); frame.setResizable(false); // Make the window
		 * non-resizable frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
		 * frame.add(r);
		 */
	}

	
	
	
	private boolean fight(player p, enemy e) {
		String[] options = {"Steal", "Attack"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            boolean f = e.steal(p.stealth);
            if(f = true) {
        	p.keyCount += 1;}else {}
            
            JOptionPane.showMessageDialog(null, "You obtained a key!");
        }
    }else{};
		
		
		
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
