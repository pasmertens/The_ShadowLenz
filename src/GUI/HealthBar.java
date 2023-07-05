package GUI;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import gameengine.player;

public class HealthBar extends JProgressBar {
    private JLabel healthLabel;

    private int maxhp;
    private int currenthp;

public HealthBar() {
    updateVariables();

    healthLabel = new JLabel(currenthp + "/" + maxhp);

    setBackground(new java.awt.Color(250, 250, 250));
    setForeground(new java.awt.Color(204, 51, 0)); 
    setMaximum(maxhp);
    setValue(currenthp);
    setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0,0,0)));
    setOpaque(true);
    setBounds(20, 20, 200, 30);
    
    healthLabel.setBounds(90, 0, 40, 30); //TODO find good center placement of the label
    add(healthLabel);
    }

    public void updateVariables() {
        player instance = new player(); //TODO hier brauchen wir eine andere Lösung, das hier funktioniert so nicht, da jedes mal ein neuer Player aufgerufen wird
        maxhp = instance.getMaxHP();
        currenthp = instance.getCurrentHP();
    }

    public void updateBar() {
        updateVariables();
        healthLabel.setText(currenthp + "/" + maxhp);
        setValue(currenthp);
    }
    
    public void resizeBar(double x, double y) {
        setBounds(              (int) (x * 20),   (int) (y * 20),   (int) (x * 200),   (int) (y * 30));
        healthLabel.setBounds(  (int) (x * 90),              (0),   (int) (x * 40),    (int) (y * 30));
        
    }
}
