package gameengine;

public class cyclops extends enemy {

	
	cyclops() {
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
