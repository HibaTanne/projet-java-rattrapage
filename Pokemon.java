import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class Pokemon {
    private String name;
    private String keyName;
    private int attack, defense, health, speed = 50;
    private int playerId;
    private Texture image;
    private int gridX, gridY;

    // Static maps to replace switches
    private static final Map<String, Integer> healthMap = new HashMap<>();
    private static final Map<String, int[]> statsMap = new HashMap<>();
    private static final Map<String, Integer> type1Map = new HashMap<>();
    private static final Map<String, Integer> type2Map = new HashMap<>();

    // Static initializer block
    static {
        healthMap.put("63", 25); 
        healthMap.put("74", 40);
        healthMap.put("78", 65); 
        healthMap.put("88", 80);
        healthMap.put("95", 35); 
        healthMap.put("108", 90); 
        
        statsMap.put("63", new int[]{20, 15, 90});
        statsMap.put("74", new int[]{80, 100, 20});
        statsMap.put("78", new int[]{100, 70, 105});
        statsMap.put("88", new int[]{80, 50, 25});
        statsMap.put("95", new int[]{45, 160, 70});
        statsMap.put("108", new int[]{55, 75, 30});
    }

    public Pokemon(String name, int playerId, int gridX, int gridY) {
        this.name = name;
        this.keyName = name.toLowerCase();
        this.playerId = playerId;
        this.gridX = gridX;
        this.gridY = gridY;
        this.health = healthMap.getOrDefault(keyName, 50);

        int[] statArray = statsMap.get(keyName);
        if (statArray != null) {
            this.attack = statArray[0];
            this.defense = statArray[1];
            this.speed = statArray[2];
        }

        loadImage();
    }

    private void loadImage() {
        String path = "images/" + keyName + ".png";
        Point position = new Point(gridX * 64, gridY * 64);
        try {
            image = new Texture(path, position, 64, 64);
        } catch (Exception e) {
            System.out.println("Image not found: " + keyName);
        }
    }

    public void afficher(Fenetre f) {
        if (image != null) {
            image.setA(new Point(gridX * 64, gridY * 64));
            f.ajouter(image);
        }

        Texte t = new Texte(
            (playerId == 1) ? Couleur.ROUGE : Couleur.VERT,
            String.valueOf(health),
            new Font("Arial", Font.BOLD, 12),
            new Point(gridX * 64 + 5, gridY * 64 + 5)
        );
        f.ajouter(t);
    }

    // Getters and setters
    public void setGridX(int x) { gridX = x; }
    public void setGridY(int y) { gridY = y; }
    public void setGridPosition(int x, int y) { gridX = x; gridY = y; }
    public void setHealth(int h) { health = h; }
    public String getName() { return name; }
    public String getKeyName() { return keyName; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getHealth() { return health; }
    public int getSpeed() { return speed; }
    public int getPlayerId() { return playerId; }
    public int getGridX() { return gridX; }
    public int getGridY() { return gridY; }
}
