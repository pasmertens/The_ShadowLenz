package gameengine;

public class enemy extends creatures {
	protected double alertness;
	//triggerarea = spawnpoint;
	
	//compares the alertness value of the enemy with a random number + stealth value of the player -> 0 if steal unsuccessful, 1 if steal successful
	
	public int steal(double s) {
		
		double n = Math.random()+ s;

		if (n < alertness) {
			return 0;
		} else {
			return 1;
		}
	};

	public void attackTrigger() {
		
	};
}
