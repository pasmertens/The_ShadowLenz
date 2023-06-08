package gameengine;

public class goblin extends enemy{
	goblin() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 2;
		maxHP = 30;
		currentHP = maxHP;
		minAtk = 9;
		maxAtk = 10;
		currentLocation = spawnpoint;
		alertness = 0.20;
	}
}
