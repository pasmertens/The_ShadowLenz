package gameengine;

public class bonfire extends enemy{
	bonfire() {
		spawnpoint[0] = 8;
		spawnpoint[1] = 4;
		maxHP = 1;
		currentHP = maxHP;
		minAtk = 0;
		maxAtk = 0;
		currentLocation = spawnpoint;
		alertness = 0.0;
		name = "Bonfire";
	}
}
