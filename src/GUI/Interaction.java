package GUI;

import javax.swing.JOptionPane;

public class Interaction {
public int steal() {
	String[] options = { "Steal", "Attack" };
	int i =JOptionPane.showOptionDialog(null, "Choose an action:", "Combat", JOptionPane.DEFAULT_OPTION,
			JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	return i;
}
}
