package gameengine;

public class enemy extends creatures {
	protected double alertness;
	//triggerarea = spawnpoint;
	
	//compares the alertness value of the enemy with a random number + stealth value of the player  
	// true if steal is successful, false if steal is unsuccessful
	
	public boolean steal(double s) {
		
		double n = Math.random()+ s;
		//System.out.println(n);
		if (n > alertness) {
			return true;
		} else {
			return false;
		}
	};

	public void attackTrigger() {
		
	};
}
