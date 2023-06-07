package gameengine;

public class oni extends enemy{


	oni() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 4;
		maxHP = 15;
		currentHP = maxHP;
		minAtk = 3;
		maxAtk = 6;
		currentLocation = spawnpoint;
		alertness = 0.20;
	
	}
}
