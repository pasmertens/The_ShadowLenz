package gameengine;

public class oni extends enemy{


	oni() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 3;
		maxHP = 20;
		currentHP = maxHP;
		minAtk = 6;
		maxAtk = 8;
		currentLocation = spawnpoint;
		alertness = 0.60;
		name = "Oni";
	
	}
}
