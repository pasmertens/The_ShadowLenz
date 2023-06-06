package gameengine;



public class player extends creatures {

	player() {
		maxHP = 30;
		currentHP = maxHP;
		minAtk = 3;
		maxAtk = 7;
		currentLocation = spawnpoint;
		stealth = 0.0;
	}


}
