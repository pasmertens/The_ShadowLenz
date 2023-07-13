package gui;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import gameengine.*;

public class MasterGUI {

	public static void main(String[] args) {

		Player dummyPlayer = new Player();
		Goblin dummyEnemy = new Goblin();
		GameFrame frame = new GameFrame();
		TitlePanel title = new TitlePanel(frame);
		BattlePanel battle = new BattlePanel(dummyPlayer, dummyEnemy, 0, 0, frame);
		WindowControl winCon = new WindowControl(frame);

		title.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		winCon.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		battle.setBounds(0, 0, frame.getWidth(), frame.getHeight());

		frame.getContentPane().add(winCon, 1, 0);

		frame.getContentPane().add(title, 0, 0);
		frame.getContentPane().add(battle, 0, 1);
		
		frame.setVisible(true);

		frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
				title.resizeComponents(frame);
				winCon.setBounds(0, 0, frame.getWidth(), frame.getHeight());
				battle.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            }
        });






		
		//brauchen wir nen Phasenindikator z.B. ne int um GUI zu verändern?
		
		//
		
		
		
		
		
		
		/*
		 * TODO Titlescreen visible actionlistener muss verzweigung aufmachen, wenn nein
		 * → feigling,
		 * wenn ja weiter
		 */

		CoreLogic logic = new CoreLogic();
		Player p = new Player();
		boolean playerAlive = true;
		boolean enemyAlive = true;
		boolean encounter = false;
		boolean doorencounter = false;
		boolean steal = false;
		int roomCount = 0;

		while (playerAlive = true) {
			if (p.currentHP > 0 && roomCount < 5) {
				enemyAlive = true;
				playerAlive = true;
				Enemy f = logic.enemySelectStage1();
				f.currentHP = f.maxHP;
				Room r = new Room(p.spawnpoint, f.spawnpoint);
				roomCount++;
				while (encounter == false) {
					// TODO roomscreen passend zum enemy, Acxtion listener → Movement
					encounter = logic.checkPosition(p, f);// compares the current position of the player with the
															// position of the enemy
					doorencounter = logic.checkDoor(p);
					if (doorencounter == true && p.keyCount < 1) {
						// TODO Meldung ohne Schlüssel kein weiterkommen
					} else if (doorencounter == true && p.keyCount > 0) {
						break;
					}
				}
				if (encounter == true) {
					boolean attack = false;
					// TODO Auswahl attack (true) oder steal(false) → änderung attack
					if (attack == true) {
						while (playerAlive == true && enemyAlive == true) {
							// TODO Action Listener attack
							int damage = logic.playerAtk(p, f);
							// TODO NAchricht, damage wurde gemacht
							enemyAlive = logic.checkEnemyHP(f);

							if (enemyAlive == false) {// enemy defeated
								p.keyCount += 1;
								break;
							} else {
								damage = logic.enemyAtk(p, f);
								playerAlive = logic.checkPlayerHP(p);
								// TODO NAchricht, damage wurde gemacht
								if (playerAlive == false) {
									break;
								}
							}
						}
					} else {
						steal = f.steal(p);
						if (steal == true) {// steal successfull
							p.keyCount += 1;

						}

						else {// steal unsuccessful
							int damage = logic.enemyAtk(p, f);
							playerAlive = logic.checkPlayerHP(p);
							// TODO NAchricht, damage wurde gemacht
							if (playerAlive == false) {
								break;
							}
							while (playerAlive == true && enemyAlive == true) {
								// TODO Action Listener attack
								damage = logic.playerAtk(p, f);
								// TODO NAchricht, damage wurde gemacht
								enemyAlive = logic.checkEnemyHP(f);

								if (enemyAlive == false) {

									p.keyCount += 1;
									break;
								} else {
									damage = logic.enemyAtk(p, f);
									playerAlive = logic.checkPlayerHP(p);
									// TODO NAchricht, damage wurde gemacht
									if (playerAlive == false) {
										break;
									}
								}
							}
						}
					}
				}

			} else if (p.currentHP > 0 && roomCount == 5) { // bonfire
				enemyAlive = true;
				playerAlive = true;
				Enemy f = new Bonfire();
				Room r = new Room(p.spawnpoint, f.spawnpoint);
				roomCount++;
				p.keyCount += 1;
				while (doorencounter == false) {
					while (encounter == false) {
						// TODO roomscreen passend zum enemy, Acxtion listener → Movement
						encounter = logic.checkPosition(p, f);
						doorencounter = logic.checkDoor(p);
						if (doorencounter == true) {
							break;
						}
					}
					if (encounter == true) {
						// TODO Actionlistener Button "Sit down"
						p.regenHP(30);
						encounter = false;
						// Message "Regained 30 HP
					}
					doorencounter = logic.checkDoor(p);
				}
				p.keyCount -= 1;

			} else if (p.currentHP > 0 && roomCount > 5 && roomCount < 11) { // stage two

				// TODO Copy Stage 1 and change enemyselsctor to stage 2

			} else if (p.currentHP > 0 && roomCount == 11) { // boss
				enemyAlive = true;
				playerAlive = true;
				Enemy f = new Boss();
				f.currentHP = f.maxHP;
				Room r = new Room(p.spawnpoint, f.spawnpoint);

				while (encounter == false) {
					// TODO roomscreen passend zum enemy, Acxtion listener → Movement
					encounter = logic.checkPosition(p, f);
				}
				while (playerAlive == true && enemyAlive == true) {
					// TODO Action Listener attack
					int damage = logic.playerAtk(p, f);
					// TODO NAchricht, damage wurde gemacht
					enemyAlive = logic.checkEnemyHP(f);

					if (enemyAlive == false) {// enemy defeated
						p.keyCount += 1;
						break;
					} else {
						damage = logic.enemyAtk(p, f);
						playerAlive = logic.checkPlayerHP(p);
						// TODO NAchricht, damage wurde gemacht
						if (playerAlive == false) {
							break;
						}
					}
				}
				break;
			}
			;

			if (playerAlive == true) {
				encounter = false;
				steal = false;
				while (doorencounter == false) {
					// TODO room visible, movement wieder aktiv, message enemy besiegt (3s),
					doorencounter = logic.checkDoor(p);
				}

			} else {
				break;
			}

		}
		if (playerAlive == true) {
			// TODO Victory screen
		} else {
			boolean a = false;
			// TODO Game over screen visible mit erneut versuchen? → Änderung a
			if (a == true) {
				main(args);
			}
		}
	}

}
