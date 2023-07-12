package gameengine;

import java.util.Random;

public class Creature {

	public int maxHP;
	public int currentHP;
	public int[] spawnpoint = new int[2];
	public int[] currentLocation = new int[2];
	protected int minAtk;
	protected int maxAtk;
	protected double stealth;
	protected String name;

	public int getCurrentHP() {
		return currentHP;
	};

	public int getMaxHP() {
		return maxHP;
	};

	public void regenHP(int n) {
		if (currentHP < maxHP) {
			currentHP += n;
		}
		if (currentHP > maxHP) {
			currentHP = maxHP;
		}
	};

	protected void damage(int n) {
		currentHP -= n;
	};

	// returns Spawnpoint of a class
	protected int[] getSpawnpoint() {

		return spawnpoint;
	};

	// returns a random int number within the range of Atk
	protected int getAtk() {
		Random r = new Random();
		return r.nextInt(maxAtk - minAtk) + minAtk;

	};
}