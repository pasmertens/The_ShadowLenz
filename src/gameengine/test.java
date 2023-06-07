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

	
	public static enemy enemySelect(int n) { //decides, which monster will appear in the dungeon
	enemy ort;
	
	if( n == 1) {
	ort = new oni();
	return ort ;}else {
		ort = new enemy();
		return ort;
	}
	
	
	}
	
	
	
	public static void main(String[] args) {
		//create new player
		player p = new player();
		
		//create an enemy
		enemy o = enemySelect(1);
		enemySelect(1);		
		
		//try damage, regeneration and attack
		p.damage(4);
		p.regenHP(9);
		//System.out.println(p.getAtk());
		System.out.println(p.currentHP);
		
		//try random steal function
		if (o.steal(p.stealth) == 1) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		;
		
		//try room creation
		room test = new room(p.spawnpoint, o.spawnpoint);
		
		//try getRoom funktion
		printRoom(test.getRoom());
	
		
		
		/* 	
		
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
