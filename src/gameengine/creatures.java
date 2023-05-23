package gameengine;

public class creatures {

	//returns spawnpoint of a creature
			public static int[] getSpawnpoint (int x , int y) {
				 int[] coordinaten = new int [ 2 ];
				 coordinaten[0] =  x;
				 coordinaten[1] = y;
				 return coordinaten;
				 
			};
		//returns base hp of a creature
		public static int getBaseHp () {
			int lp = 0;
			return lp;
		};
		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

	}
	//Der Plan wäre es die Gegner und den Spieler als Objekte hier anzulegen