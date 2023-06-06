package gameengine;

import javax.swing.*;

public class test {

	public static void main(String[] args) {
		player p = new player();
		oni o = new oni();
		p.damage(4);
		p.regenHP(9);
		if ( o.steal(p.stealth) == 1) {
			System.out.println("Yes");
		}else
		{
			System.out.println("No");
		}
		;
		//System.out.println(p.getAtk());
			}
}
