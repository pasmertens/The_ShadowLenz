package gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class test {

	private static void printRoom(char[][] board) {

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

		//System.out.println(i);

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

	private static void startGame() {
		player p = new player(); // create the player for the whole run
		int roomCount = 0;
		
		while(p.currentHP> 0){
		
			if (p.currentHP > 0 && roomCount < 5) {							//stage one
			enemy o = enemySelect();	
				room test = new room(p.spawnpoint, o.spawnpoint);	
			//test= nextRoom(p, o, test);
			roomCount += 1;
			o.currentHP=o.maxHP;
			printRoom(test.getRoom());
			encounter(p, o );
			}
			
			else if(p.currentHP > 0 && roomCount == 5) {					//bonfire
				enemy o = enemySelect();	
				room test = new room(p.spawnpoint, o.spawnpoint);
			System.out.println("You entered a bonfire room");
			p.keyCount -= 1;
			o = new bonfire();
			System.out.println(o.name);
			test = new room(p.spawnpoint, o.spawnpoint);
			roomCount += 1;
			o.currentHP=o.maxHP;
			printRoom(test.getRoom());
			sitDown(p);
			}
			
			else if(p.currentHP > 0 && roomCount > 5 && roomCount < 11) {	//stage two
				enemy o = enemySelect();	
				room test = new room(p.spawnpoint, o.spawnpoint);
				roomCount += 1;
				o.currentHP=o.maxHP;
				printRoom(test.getRoom());
				encounter(p, o );
				}
			
			else if(p.currentHP > 0 && roomCount == 11) {					//boss
				System.out.println("You entered the boss room");
				p.keyCount -= 1;
				enemy o = new boss();
//				System.out.println(o.name);
				room test = new room(p.spawnpoint, o.spawnpoint);
				roomCount += 1;
				o.currentHP=o.maxHP;
				printRoom(test.getRoom());
				boolean f = fight(p, o, 0);
				if (f == true) {
					System.out.println("Congrats. You cleared the Dungeon");
				}else {
					System.out.println("Du bist gestorben!");
				}
			};
			};	};
	
	
	public static void main(String[] args) {
		// create new player
		player p = new player();

		// create an enemy
		//enemy o = enemySelect();
		//System.out.println(o.name);
		
		int roomCount = 0;
		// try damage, regeneration and attack
		// p.damage(12);
//		p.regenHP(9);
		// System.out.println(p.getAtk());
//		System.out.println(p.currentHP);

		// try random steal function
//		if (o.steal(p.stealth) == true) {
//			System.out.println("Yes");
//		} else {
//			System.out.println("No");
//		}
//		;

		// try room creation
//		room test = new room(p.spawnpoint, o.spawnpoint);
		//room test = new room(p.spawnpoint, o.spawnpoint);
		// try getRoom funktion
//		printRoom(test.getRoom());

		//test encounter
		while(p.currentHP> 0){
			
		//stage one
		if (p.currentHP > 0 && roomCount < 5) {
		enemy o = enemySelect();	
			room test = new room(p.spawnpoint, o.spawnpoint);	
		//test= nextRoom(p, o, test);
		roomCount += 1;
		o.currentHP=o.maxHP;
		printRoom(test.getRoom());
		encounter(p, o );
		}
		
		
		
		
		
		//bonfire
		else if(p.currentHP > 0 && roomCount == 5) {
			enemy o = enemySelect();	
			room test = new room(p.spawnpoint, o.spawnpoint);
		System.out.println("You entered a bonfire room");
		p.keyCount -= 1;
		o = new bonfire();
		System.out.println(o.name);
		test = new room(p.spawnpoint, o.spawnpoint);
		roomCount += 1;
		o.currentHP=o.maxHP;
		printRoom(test.getRoom());
		sitDown(p);
		}
		
		
		
		
		//stage two
		else if(p.currentHP > 0 && roomCount > 5 && roomCount < 11) {
			enemy o = enemySelect();	
			room test = new room(p.spawnpoint, o.spawnpoint);
			roomCount += 1;
			o.currentHP=o.maxHP;
			printRoom(test.getRoom());
			encounter(p, o );
			}
		
		
		
		//boss
		else if(p.currentHP > 0 && roomCount == 11) {
			System.out.println("You entered the boss room");
			p.keyCount -= 1;
			enemy o = new boss();
//			System.out.println(o.name);
			room test = new room(p.spawnpoint, o.spawnpoint);
			roomCount += 1;
			o.currentHP=o.maxHP;
			printRoom(test.getRoom());
			boolean f = fight(p, o, 0);
			if (f == true) {
				System.out.println("Congrats. You cleared the Dungeon");
			}else {
				System.out.println("Du bist gestorben!");
			}
		};
		};	};
	
		
		
		
		
		
		
		
		
		// try interaction
		/*if (interaction(p, o) == true) {
			System.out.println("Du hast einen Schlüssel erhalten");
			System.out.println(p.currentHP);
			p.keyCount += 1;
			test= nextRoom(p, o, test);
			printRoom(test.getRoom());
			interaction(p, o);
		} else {
			System.out.println("Du bist gestorben!");
		}
		;*/

		/*
		 * // try fight if (fight(p, o, 0) == true) {
		 * System.out.println("Schlüssel erhalten"); p.keyCount += 1; } else {
		 * System.out.println("Du bist gestorben!"); }
		 */

		
	
	
	private static boolean interaction(player p, enemy e) {
		String[] options = { "Steal", "Attack" };
		int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (choice == 0) {

			if (e.steal(p.stealth) == true) {
				System.out.println("Steal");
				return true;
			} else {
				System.out.println("Steal-Fight");
				return fight(p, e, 1);
			}

		} else if (choice == 1) {
			System.out.println("Fight");
			return fight(p, e, 0);
		} else {
			System.out.println("Failed");
			return false;
		}}


	
	private static boolean fight(player p, enemy e, int n) {
//		System.out.println("enemy HP" + e.currentHP);
		if (n == 0) {
			if (p.currentHP <= 0) {
//				System.out.println("a");
				return false;// Player is defeated
			} else if (e.currentHP <= 0) {
//				System.out.println("b");
				return true;// Enemy is defeated
			} else {
//				System.out.println("c");
				Object[] options = { "Attack" };
				int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				if (choice == 0) {
					int d = p.getAtk();
					e.damage( d );
					System.out.println("You have done " + d + " damage");
					if (e.currentHP <= 0) {
//						System.out.println("d");
						return true;}else {
//							System.out.println("e");
					int g = e.getAtk();	
					p.damage(g);
					System.out.println( "The " + e.name + " has done " + g + " damage");
					return fight(p, e, n);}// Continue the fight
				}
			}

		} else if (n == 1) {
//			System.out.println("f");
			int g= e.getAtk();
			System.out.println( "The " + e.name + " has spotted you and charges.");
			System.out.println( "The " + e.name + " has done " + g + " damage");
			p.damage(g);
			n = 0;
			return fight(p, e, n);// Continue the fight
		}
		return false;
	}

		
	private static room nextRoom(player p, enemy o, room r){
		System.out.println("Next Room");
		p.keyCount -= 1;
		o = enemySelect();
//		System.out.println(o.name);
//		System.out.println(o.currentHP);
		r = new room(p.spawnpoint, o.spawnpoint);
		return r;
	};
	
	
	private static void encounter(player p, enemy o) {
		boolean encounter = interaction(p, o);
		if (encounter == true) {
			System.out.println("Du hast einen Schlüssel erhalten"); 
			System.out.println(p.currentHP);
			p.keyCount += 1;
			
		} else {
			System.out.println("Du bist gestorben!");
		}
	}

private static void sitDown(player p) {
	Object[] options = { "Sit Down" };
	int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat",
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

	if (choice == 0) {
	p.regenHP(15);
}}








}
