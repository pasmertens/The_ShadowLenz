package gameengine;

public class Player extends Creature {
	public int keyCount;
	
	protected void addKey(int n) {
		keyCount += n;
	};
	public Player() {
		
		spawnpoint[0] = 2;
		spawnpoint[1] = 4;
		maxHP = 80;
		currentHP = maxHP;
		minAtk = 6;
		maxAtk = 12;
		currentLocation = spawnpoint;
		stealth = 0.0;
		keyCount = 0;
	}

	protected int getCurrentLocation(int n) {
		return currentLocation[n];
	}

}
