package gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class test {

	public static void printRoom(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		player p = new player();
		oni o = new oni();
		p.damage(4);
		p.regenHP(9);
		if (o.steal(p.stealth) == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		;
		
		room test = new room(p.spawnpoint, o.spawnpoint);
		printRoom(test.getRoom());
	
		
		
		/* System.out.println(p.getAtk());
		
		
		JFrame frame = new JFrame("Test");
		// PlayerMovement playerMovement = new PlayerMovement();
		frame.add(test);
		frame.setSize(test.width * 20, test.height * 20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// frame.addKeyListener(playerMovement);
		frame.setSize(400, 225);
		frame.setResizable(false); // Make the window non-resizable
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.add(r);*/
	}

}
