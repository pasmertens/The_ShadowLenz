package gameengine;

public class room {

	protected final int width = 16;
	protected final int height = 9;
	char[][] room = new char[height][width];

	public room(int[] n, int[] m) {

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


/*
 * private void enterNewRoom(int[] n) { room[n[1]][n[0]] = ' '; // Clear the
 * player's previous position room(); // Update player position to one space
 * right of the left door playerX = (ROOM_WIDTH - 1) / 2 + 1; playerY =
 * ROOM_HEIGHT / 2; room[playerY][playerX] = 'P'; } /*public static void
 * main(String[] args) { // TODO Auto-generated method stub int[] p
 * 
 * inializeRoom(); }
 * 
 * }
 */
