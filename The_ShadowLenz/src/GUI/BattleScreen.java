package GUI;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class BattleScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel fightPanel;
    private JPanel logPanel;

    private JLabel gnomeLabel;
    private JLabel moveLabel;
    private JLabel playerDamageLabel;
    private JLabel enemyDamageLabel;
    private JLabel defenseChoiceLabel;
    
    private JButton stealButton;
    private JButton fightButton;
    private JButton attackButton;
    private JButton defendButton;
    private JButton returnButton;

    private HealthBar healthBar;

    private int playerdamage;
    private int enemydamage;
    private double x;
    private double y;
    
    private String enemyname; 

    public BattleScreen() {
        initVariables();
        initComponents();
    }

    private void initVariables() {
        playerdamage = 3;       //TODO add method to get the amount of damage player has done
        enemydamage = 2;      //TODO add method to get the amount of damage enemy has done
        enemyname = "gnome";      //enemy.getName;
        x = 1;
        y = 1;
    }

    private void initComponents() {
        mainPanel = new JPanel();
        fightPanel = new JPanel();
        logPanel = new JPanel();

        gnomeLabel = new JLabel("A " + enemyname + " is standing in front of you");
        moveLabel = new JLabel("Make your move");
        playerDamageLabel = new JLabel("You attacked the " + enemyname + " and dealt " + playerdamage + " damage");
        enemyDamageLabel = new JLabel("The " + enemyname + " attacked you and dealt " + enemydamage + " damage");
        defenseChoiceLabel = new JLabel("You chose to defend yourself:");

        stealButton = new JButton("Steal its key");
        fightButton = new JButton("Fight!");
        attackButton = new JButton("Attack");
        defendButton = new JButton("Defend");
        returnButton = new JButton("Ok");

        healthBar = new HealthBar();

        setLayout(null);
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Battle Screen");

        add(healthBar);

        mainPanel.setBounds(20, 300, 746, 100);
        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(137,112,88)));
        mainPanel.setLayout(null);

        gnomeLabel.setBounds(10, 10, 340, 20);
        mainPanel.add(gnomeLabel);

        stealButton.setBounds(200, 40, 120, 30);
        mainPanel.add(stealButton);

        fightButton.setBounds(40, 40, 120, 30);
        mainPanel.add(fightButton);



        fightPanel.setBounds(20, 300, 746, 100);
        fightPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(137,112,88)));
        fightPanel.setLayout(null);

        moveLabel.setBounds(10, 10, 340, 20);
        fightPanel.add(moveLabel);

        attackButton.setBounds(40, 40, 120, 30);
        fightPanel.add(attackButton);

        defendButton.setBounds(200, 40, 120, 30);
        fightPanel.add(defendButton);



        logPanel.setBounds(20, 300, 746, 100);
        logPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(137,112,88)));
        logPanel.setLayout(null);

        playerDamageLabel.setBounds(10, 10, 340, 20);
        logPanel.add(playerDamageLabel);

        enemyDamageLabel.setBounds(10, 40, 340, 20);
        logPanel.add(enemyDamageLabel);

        defenseChoiceLabel.setBounds(10, 10, 340, 20);
        defenseChoiceLabel.setVisible(false);
        logPanel.add(defenseChoiceLabel);

        returnButton.setBounds(10, 70, 120, 30);
        logPanel.add(returnButton);



        fightPanel.setVisible(false);
        logPanel.setVisible(false);

        add(mainPanel);
        add(fightPanel);
        add(logPanel);

        //passt alle Komponenten automatisch an, wenn framegröße verändert wird
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double framewidth = getWidth();
                double frameheight = getHeight();
                x = framewidth / 800;
                y = frameheight / 450;
                updateComponentSizes();
                healthBar.resizeBar(x, y);
                setLocationRelativeTo(null); 
            }
        });


        fightButton.addActionListener(e -> {
            mainPanel.setVisible(false);
            fightPanel.setVisible(true);
        });

        stealButton.addActionListener(e -> {

        });

        defendButton.addActionListener(e -> {
            //mache die benötigten Komponenten sichtbar und den Rest unsichtbar
            playerDamageLabel.setVisible(false);
            defenseChoiceLabel.setVisible(true);
            fightPanel.setVisible(false);
            logPanel.setVisible(true);

            //aktualisiere die HP Leiste
            healthBar.updateBar();
        });

        attackButton.addActionListener(e -> {
            fightPanel.setVisible(false);
            logPanel.setVisible(true);
            
            //aktualisiere die HP Leiste
            healthBar.updateBar();
        });
        returnButton.addActionListener(e -> {
            //mache die benötigten Komponenten sichtbar und den Rest unsichtbar
            logPanel.setVisible(false);
            fightPanel.setVisible(true);
            defenseChoiceLabel.setVisible(false);
            playerDamageLabel.setVisible(true);
        });
    }

    private void updateComponentSizes() {
        mainPanel.setBounds(         (int) (x * 20),     (int) (y * 300),    (int) (x * 746),    (int) (y * 100) );
        gnomeLabel.setBounds(        (int) (x * 10),     (int) (y * 5),      (int) (x * 340),    (int) (y * 20)  );
        stealButton.setBounds(       (int) (x * 200),    (int) (y * 40),     (int) (x * 120),    (int) (y * 30)  );
        fightButton.setBounds(       (int) (x * 40),     (int) (y * 40),     (int) (x * 120),    (int) (y * 30)  );
        fightPanel.setBounds(        (int) (x * 20),     (int) (y * 300),    (int) (x * 746),    (int) (y * 100) );
        moveLabel.setBounds(         (int) (x * 10),     (int) (y * 5),      (int) (x * 340),    (int) (y * 20)  );
        attackButton.setBounds(      (int) (x * 40),     (int) (y * 40),     (int) (x * 120),    (int) (y * 30)  );
        defendButton.setBounds(      (int) (x * 200),    (int) (y * 40),     (int) (x * 120),    (int) (y * 30)  );
        logPanel.setBounds(          (int) (x * 20),     (int) (y * 300),    (int) (x * 746),    (int) (y * 100) );
        playerDamageLabel.setBounds( (int) (x * 10),     (int) (y * 5),      (int) (x * 340),    (int) (y * 20)  );
        enemyDamageLabel.setBounds(  (int) (x * 10),     (int) (y * 35),     (int) (x * 340),    (int) (y * 20)  );
        defenseChoiceLabel.setBounds((int) (x * 10),     (int) (y * 5),      (int) (x * 340),    (int) (y * 20)  );
        returnButton.setBounds(      (int) (x * 10),     (int) (y * 65),     (int) (x * 120),    (int) (y * 30)  );
        setSize(                     (int) (x * 800),    (int) (y * 450)                                         );
    }

    public static void main(String[] args) {
        BattleScreen battleScreen = new BattleScreen();
        battleScreen.setVisible(true);
    }
}
