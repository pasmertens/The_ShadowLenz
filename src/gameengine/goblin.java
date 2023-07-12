package gameengine;

public class Goblin extends Enemy {
	public Goblin() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 2;
		maxHP = 15;
		currentHP = 10;
		minAtk = 5;
		maxAtk = 7;
		currentLocation = spawnpoint;
		alertness = 0.70;
		name = "Goblin";
	}
}
