package gameengine;

public class witch extends enemy {

	witch() {
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
