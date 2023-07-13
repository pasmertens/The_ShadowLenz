package gameengine;

public class Cyclops extends Enemy {
	Cyclops() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 5;
		maxHP = 30;
		currentHP = maxHP;
		minAtk = 9;
		maxAtk = 10;
		currentLocation = spawnpoint;
		alertness = 0.30;
		name = "Cyclops";
	}
}
