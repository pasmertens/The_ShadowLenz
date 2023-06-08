package gameengine;

public class witch extends enemy {

	witch() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 1;
		maxHP = 30;
		currentHP = maxHP;
		minAtk = 9;
		maxAtk = 10;
		currentLocation = spawnpoint;
		alertness = 0.20;
	}
}
