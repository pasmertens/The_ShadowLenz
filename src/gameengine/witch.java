package gameengine;

public class Witch extends Enemy {
	Witch() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 1;
		maxHP = 30;
		currentHP = maxHP;
		minAtk = 7;
		maxAtk = 10;
		currentLocation = spawnpoint;
		alertness = 0.40;
		name = "Witch";
	}
}
