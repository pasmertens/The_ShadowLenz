package gameengine;

import java.util.Random;

import javax.swing.JOptionPane;

public class coreLogic {

	public static boolean interaction(player p, enemy e) {
		// creates a pop-up window with steal and attack option
		String[] options = { "Steal", "Attack" };
		int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		// choice steal
		if (choice == 0) {
			// steal successful
			if (e.steal(p.stealth) == true) {
				return true;
			}
			// steal unsuccessful
			else {
				return fight(p, e, 1);
			}
		}
		// choice attack
		else if (choice == 1) {
			return fight(p, e, 0);
		} else {
			System.out.println(" Interaction Failed");// diagnose tool to realize if this part doesn't work
			return false;
		}

	}

	public static boolean fight(player p, enemy e, int n) { // fight logic
		if (n == 0) {
			//in case the player has no more hp the fight is over
			if (p.currentHP <= 0) {
				return false;
			}else {
				Object[] options = { "Attack" };
				int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Combat",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				if (choice == 0) {
					int d = p.getAtk();
					e.damage(d);
					System.out.println("You have done " + d + " damage");
					if (e.currentHP <= 0) {
						return true;
					} else {
						int g = e.getAtk();
						p.damage(g);
						System.out.println("The " + e.name + " has done " + g + " damage");
						return fight(p, e, n);
					}
				}
			}

		} else if (n == 1) {
			int g = e.getAtk();
			System.out.println("The " + e.name + " has recognized you and charges.");
			System.out.println("The " + e.name + " has done " + g + " damage");
			p.damage(g);
			n = 0;
			return fight(p, e, n);
		}
		return false;
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

	public static void main(String[] args) {
		player p = new player(); // create  player
		enemy o = enemySelect(); //create
		if (interaction(p, o) == true) {
			System.out.println("Du hast einen Schlüssel erhalten");
			p.keyCount += 1;
		} else {
			System.out.println("Du bist gestorben!");
		}
		;
	}
	// TODO Auto-generated method stub

}

// Keine Ahnung ob man das so aufbauen würde oder ob