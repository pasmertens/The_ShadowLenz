package gameengine;

import java.util.Random;

public class creatures {
	protected int maxHP;
	protected int currentHP;
	protected int[] spawnpoint = new int[2];
	protected int minAtk;
	protected int maxAtk;

	
	
	
	protected int getCurrentHp() {
		return currentHP;
	};

	protected int getMaxHP() {
		return maxHP;
			};
	
	protected void regenHP(int n) {
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

