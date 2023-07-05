package gameengine;

public class goblin extends enemy{
	goblin() {
		spawnpoint[0] = 9;
		spawnpoint[1] = 2;
		maxHP = 15;
		currentHP = maxHP;
		minAtk = 5;
		maxAtk = 7;
		currentLocation = spawnpoint;
		alertness = 0.70;
		name = "Goblin";
	}
}
