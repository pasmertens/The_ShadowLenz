package gameengine;

import java.util.Random;

//
public class CoreLogic {
	Player p = new Player();

	public void playerMoveUp(Player p) {
		if (p.currentLocation[1] > 0) {
			p.currentLocation[1]--;
		} else {
			p.currentLocation[1] = 0;
		}
	}

	public void playerMoveDown(Player p) {
		if (p.currentLocation[1] < 9) {
			p.currentLocation[1]--;
		} else {
			p.currentLocation[1] = 9;
		}
	}

	public void playerMoveLeft(Player p) {
		if (p.currentLocation[0] > 0) {
			p.currentLocation[0]--;
		} else {
			p.currentLocation[1] = 0;
		}
	}

	public void playerMoveRight(Player p) {
		if (p.currentLocation[0] < 16) {
			p.currentLocation[0]--;
		} else {
			p.currentLocation[1] = 16;
		}
	}

	public Enemy enemySelectStage1() { // decides, which monster will appear in the dungeon room (stage 1)
		Enemy e;

		Random r = new Random();

		int i = r.nextInt(3);

		switch (i) {
		case 0:
			e = new Oni();
			return e;
		case 1:
			e = new Cyclops();
			return e;
		case 2:
			e = new Goblin();
			return e;

		default:
			e = new Goblin();
			return e;
		}
	}

	public Enemy enemySelectStage2() { // decides, which monster will appear in the dungeon room (stage 2)
		Enemy e;

		Random r = new Random();

		int i = r.nextInt(3);
		switch (i) {
		case 0:
			e = new Oni();
			return e;
		case 1:
			e = new Cyclops();
			return e;
		case 2:
			e = new Witch();
			return e;

		default:
			e = new Oni();
			return e;
		}
	}

	public boolean checkPosition(Player p, Enemy m) {
		if (Math.abs(p.currentLocation[0] - m.spawnpoint[0]) > 1
				&& Math.abs(p.currentLocation[1] - m.spawnpoint[1]) > 1) {
			return false;
		} else if (Math.abs(p.currentLocation[0] - m.spawnpoint[0]) <= 1
				&& Math.abs(p.currentLocation[1] - m.spawnpoint[1]) <= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkDoor(Player p) {
		if (p.currentLocation[0]  == 16
				&& p.currentLocation[1] == 4) {
			return true;
		} else {
			return false;
		}
	}

	public int playerAtk(Player p, Enemy e) {
		int d = p.getAtk();
		e.damage(d);
		return d;
	}

	public int enemyAtk(Player p, Enemy e) {
		int g = e.getAtk();
		p.damage(g);
		return g;
	}

	public boolean checkPlayerHP(Player p) {
		if (p.currentHP <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkEnemyHP(Enemy e) {
		if (e.currentHP <= 0) {
			return false;
		} else {
			return true;
		}
	}

//	public boolean playerAttack(Player p, Enemy e, boolean b) {
//		playerAtk(p, e);
//		b = checkEnemyHP(e);
//		return b;}
//	
//	public boolean enemyAttack(Player p, Enemy e, boolean a) {
//		enemyAtk(p, e);
//		a = checkPlayerHP(p);
//		return a;
//	}
	
	
	
//gegener auswählen, raum erstellen

}
