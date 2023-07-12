package gameengine;

public class Room {
	public final int width = 16;
	public final int height = 9;
	public char[][] room = new char[height][width];
	Player p;
	Enemy f;
	

	public Room(int[] n, int[] m) {

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (x == 0 || x == height - 1 || y == 0 || y == width - 1) {
					room[x][y] = '#'; // Wall
				} else if (x == (n[0] - 1) && y == (n[1])) {
					room[y][x] = 'P'; // Player

				}
			}
		}
		room[height / 2][0] = 'D'; // Left door
		room[height / 2][width - 1] = 'D'; // Right door
		room[m[1]][m[0]] = 'M'; // Monster

	}

	public char[][] getRoom() {
		return room;
	};

}
