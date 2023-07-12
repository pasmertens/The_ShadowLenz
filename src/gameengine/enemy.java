package gameengine;

public class Enemy extends Creature {
	protected double alertness;

	public boolean steal(Player p) {

		double n = Math.random() + p.stealth;
		// System.out.println(n);
		if (n > alertness) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return name;
	}
}