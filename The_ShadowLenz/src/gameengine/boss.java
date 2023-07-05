package gameengine;

public class boss extends enemy{

	boss() {
		spawnpoint[0] = 8;
		spawnpoint[1] = 4;
		maxHP = 35;
		currentHP = maxHP;
		minAtk = 9;
		maxAtk = 12;
		currentLocation = spawnpoint;
		alertness = 0.70;
		name = "Vampire";
	}

}
