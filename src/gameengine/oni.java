package gameengine;

public class oni extends enemy{


	oni() {
		maxHP = 15;
		currentHP = maxHP;
		minAtk = 3;
		maxAtk = 6;
		currentLocation = spawnpoint;
		alertness = 0.20;
	
	}
}
