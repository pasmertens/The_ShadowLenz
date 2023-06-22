package gameengine;

import java.util.Random;
import GUI.*;
import javax.swing.JOptionPane;

public class coreLogic {

	public static void main(String[] args) {
		startGame();
	}

	private static void startGame() {
		player p = new player(); // create the player for the whole run
		int roomCount = 0;

		while (p.currentHP > 0) {

			if (p.currentHP > 0 && roomCount < 5) { // stage one
				enemy o = enemySelect(1);
				room test = new room(p.spawnpoint, o.spawnpoint);
				p.currentLocation = p.spawnpoint;
				roomCount += 1;
				o.currentHP = o.maxHP;
				playerMovement move = new playerMovement(p, o, test);
				printRoom(test.getRoom());
				//checkPosition(move, p, o);

			}

			else if (p.currentHP > 0 && roomCount == 5) { // bonfire
				enemy o = new bonfire();
				room test = new room(p.spawnpoint, o.spawnpoint);
				p.currentLocation = p.spawnpoint;
				System.out.println("You entered a bonfire room");
				test = new room(p.spawnpoint, o.spawnpoint);
				roomCount += 1;
				playerMovement move = new playerMovement(p, o, test);
				printRoom(test.getRoom());
				if (Math.abs(move.p.currentLocation[0] - move.m.spawnpoint[0]) <= 1
						&& Math.abs(move.p.currentLocation[1] - move.m.spawnpoint[1]) <= 1) {
					sitDown(p);
				}
				System.out.println("You regenerated 30 HP");
			}

			else if (p.currentHP > 0 && roomCount > 5 && roomCount < 11) { // stage two
				enemy o = enemySelect(2);
				room test = new room(p.spawnpoint, o.spawnpoint);
				p.currentLocation = p.spawnpoint;
				roomCount += 1;
				o.currentHP = o.maxHP;
				playerMovement move = new playerMovement(p, o, test);
				printRoom(test.getRoom());
				if (Math.abs(move.p.currentLocation[0] - move.m.spawnpoint[0]) <= 1
						&& Math.abs(move.p.currentLocation[1] - move.m.spawnpoint[1]) <= 1) {
					encounter(p, o);
				}
			}

			else if (p.currentHP > 0 && roomCount == 11) { // boss
				System.out.println("You entered the boss room");
				p.keyCount -= 1;
				enemy o = new boss();
//				System.out.println(o.name);
				room test = new room(p.spawnpoint, o.spawnpoint);
				roomCount += 1;
				playerMovement move = new playerMovement(p, o, test);
				o.currentHP = o.maxHP;
				printRoom(test.getRoom());
				if (Math.abs(move.p.currentLocation[0] - move.m.spawnpoint[0]) <= 1
						&& Math.abs(move.p.currentLocation[1] - move.m.spawnpoint[1]) <= 1) {
					boolean f = fight(p, o, 0);
					if (f == true) {
						System.out.println("Congrats. You cleared the Dungeon");
					} else {
						System.out.println("Du bist gestorben!");
					}
				}
				;
			}
			;
		}
		;
	};

	private static enemy enemySelect(int k) { // decides, which monster will appear in the dungeon
		enemy e;

		Random r = new Random();
		if (k == 1) {
			int i = r.nextInt(3);

			// System.out.println(i);

			switch (i) {
			case 0:
				e = new oni();
				return e;
			case 1:
				e = new cyclops();
				return e;
			case 2:
				e = new goblin();
				return e;

			default:
				e = new goblin();
				return e;
			}
		} else if (k == 2) {
			int i = r.nextInt(3);
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

			default:
				e = new oni();
				return e;
			}
		} else {
			e = new bonfire();
			return e;
		}

		;

	}

	private static boolean interaction(player p, enemy e) {
		Interaction i= new Interaction();
		if (i.steal() == 0) {

			if (e.steal(p.stealth) == true) {
//						System.out.println("Steal");
				return true;
			} else {
//						System.out.println("Steal-Fight");
				return fight(p, e, 1);
			}

		} else if (i.steal() == 1) {
//					System.out.println("Fight");
			return fight(p, e, 0);
		} else {
//					System.out.println("Failed");
			return false;
		}
	}

	private static boolean fight(player p, enemy e, int n) {
//				System.out.println("enemy HP" + e.currentHP);
		if (n == 0) {
			if (p.currentHP <= 0) {
//						System.out.println("a");
				return false;// Player is defeated
			} else if (e.currentHP <= 0) {
//						System.out.println("b");
				return true;// Enemy is defeated
			} else {
//						System.out.println("c");
				Object[] options = { "Attack" };
				int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				if (choice == 0) {
					int d = p.getAtk();
					e.damage(d);
					System.out.println("You have done " + d + " damage");
					if (e.currentHP <= 0) {
//								System.out.println("d");
						return true;
					} else {
//									System.out.println("e");
						int g = e.getAtk();
						p.damage(g);
						System.out.println("The " + e.name + " has done " + g + " damage");
						return fight(p, e, n);
					} // Continue the fight
				}
			}

		} else if (n == 1) {
//					System.out.println("f");
			int g = e.getAtk();
			System.out.println("The " + e.name + " has spotted you and charges.");
			System.out.println("The " + e.name + " has done " + g + " damage");
			p.damage(g);
			n = 0;
			return fight(p, e, n);// Continue the fight
		}
		return false;
	}

	private static void sitDown(player p) {
		Object[] options = { "Sit Down" };
		int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "SitDown", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (choice == 0) {
			p.regenHP(30);
		}
	}

	public static void encounter(player p, enemy o) {
		boolean encounter = interaction(p, o);
		if (encounter == true) {// if fight is won, key is added
			System.out.println("Du hast einen Schlüssel erhalten");
			System.out.println(p.currentHP);
			p.keyCount += 1;

		} else {// if fight is lost, player is dead
			System.out.println("Du bist gestorben!");
		}
	}

	private static void printRoom(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);

			}
			System.out.println();
		}
	}

	private static void checkPosition(playerMovement move, player p, enemy o) {
		while(Math.abs(move.p.currentLocation[0] - move.m.spawnpoint[0]) > 1
				&& Math.abs(move.p.currentLocation[1] - move.m.spawnpoint[1]) > 1) {
			checkPosition(move, p, o);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (Math.abs(move.p.currentLocation[0] - move.m.spawnpoint[0]) <= 1
				&& Math.abs(move.p.currentLocation[1] - move.m.spawnpoint[1]) <= 1) {
			encounter(p, o);

		} else {
			checkPosition(move, p, o);
		}
	}

}
