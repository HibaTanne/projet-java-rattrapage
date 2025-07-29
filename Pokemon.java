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
    private int type1, type2;

    // Static maps to replace switches
    private static final Map<String, Integer> healthMap = new HashMap<>();
    private static final Map<String, int[]> statsMap = new HashMap<>();
    private static final Map<String, Integer> type1Map = new HashMap<>();
    private static final Map<String, Integer> type2Map = new HashMap<>();

    // Static initializer block
    static {
        healthMap.put("1", 45); healthMap.put("2", 60); healthMap.put("3", 80);
        healthMap.put("4", 39); healthMap.put("5", 58); healthMap.put("6", 78);
        healthMap.put("7", 44); healthMap.put("8", 59); healthMap.put("9", 79);
        healthMap.put("10", 45); healthMap.put("12", 60); healthMap.put("17", 63);
        healthMap.put("18", 83); healthMap.put("21", 40); healthMap.put("23", 35);
        healthMap.put("27", 50); healthMap.put("31", 90); healthMap.put("35", 70);
        healthMap.put("42", 75); healthMap.put("46", 35); healthMap.put("51", 35);
        healthMap.put("59", 90); healthMap.put("63", 25); healthMap.put("69", 50);
        healthMap.put("74", 40); healthMap.put("78", 65); healthMap.put("83", 52);
        healthMap.put("88", 80); healthMap.put("95", 35); healthMap.put("102", 60);
        healthMap.put("108", 90); healthMap.put("115", 105); healthMap.put("144", 90);
        healthMap.put("145", 90); healthMap.put("146", 90); healthMap.put("149", 91);
        healthMap.put("150", 106); healthMap.put("25", 35); healthMap.put("29", 55);
        healthMap.put("36", 95); healthMap.put("40", 140); healthMap.put("44", 60);

        statsMap.put("150", new int[]{110, 80, 130});
        statsMap.put("4", new int[]{52, 43, 65});
        statsMap.put("7", new int[]{48, 65, 43});
        statsMap.put("1", new int[]{49, 49, 45});
        statsMap.put("2", new int[]{60, 63, 60});
        statsMap.put("5", new int[]{64, 58, 80});
        statsMap.put("3", new int[]{82, 83, 80});
        statsMap.put("144", new int[]{85, 100, 85});
        statsMap.put("9", new int[]{83, 100, 78});
        statsMap.put("145", new int[]{90, 85, 100});
        statsMap.put("149", new int[]{134, 95, 80});
        statsMap.put("146", new int[]{100, 90, 90});
        statsMap.put("8", new int[]{63, 80, 58});
        statsMap.put("6", new int[]{84, 78, 100});
        statsMap.put("12", new int[]{45, 50, 70});
        statsMap.put("18", new int[]{80, 75, 91});
        statsMap.put("23", new int[]{60, 44, 55});
        statsMap.put("27", new int[]{75, 85, 40});
        statsMap.put("31", new int[]{82, 87, 76});
        statsMap.put("35", new int[]{45, 48, 35});
        statsMap.put("42", new int[]{80, 70, 90});
        statsMap.put("46", new int[]{70, 55, 25});
        statsMap.put("51", new int[]{80, 50, 120});
        statsMap.put("59", new int[]{110, 80, 95});
        statsMap.put("63", new int[]{20, 15, 90});
        statsMap.put("69", new int[]{75, 35, 40});
        statsMap.put("74", new int[]{80, 100, 20});
        statsMap.put("78", new int[]{100, 70, 105});
        statsMap.put("83", new int[]{65, 55, 60});
        statsMap.put("88", new int[]{80, 50, 25});
        statsMap.put("95", new int[]{45, 160, 70});
        statsMap.put("102", new int[]{40, 80, 40});
        statsMap.put("108", new int[]{55, 75, 30});
        statsMap.put("115", new int[]{95, 80, 90});
        statsMap.put("10", new int[]{30, 35, 45});
        statsMap.put("17", new int[]{60, 55, 71});
        statsMap.put("21", new int[]{60, 30, 70});
        statsMap.put("25", new int[]{55, 30, 90});
        statsMap.put("29", new int[]{47, 52, 41});
        statsMap.put("36", new int[]{70, 73, 60});
        statsMap.put("40", new int[]{70, 45, 45});
        statsMap.put("44", new int[]{65, 70, 40});

        // Type1 assignments
        type1Map.put("150", Type.PSY);
        type1Map.put("4", Type.FEU); type1Map.put("5", Type.FEU); type1Map.put("6", Type.FEU); type1Map.put("146", Type.FEU);
        type1Map.put("7", Type.EAU); type1Map.put("8", Type.EAU); type1Map.put("9", Type.EAU);
        type1Map.put("1", Type.PLANTE); type1Map.put("2", Type.PLANTE); type1Map.put("3", Type.PLANTE); type1Map.put("102", Type.PLANTE); type1Map.put("44", Type.PLANTE);
        type1Map.put("144", Type.GLACE); type1Map.put("145", Type.ELECTRIK); type1Map.put("25", Type.ELECTRIK);
        type1Map.put("149", Type.DRAGON);
        type1Map.put("10", Type.INSECTE);
        type1Map.put("12", Type.PLANTE); type1Map.put("46", Type.PLANTE); type1Map.put("69", Type.PLANTE);
        type1Map.put("18", Type.NORMAL); type1Map.put("17", Type.NORMAL); type1Map.put("21", Type.NORMAL); type1Map.put("35", Type.NORMAL);
        type1Map.put("36", Type.NORMAL); type1Map.put("40", Type.NORMAL); type1Map.put("83", Type.NORMAL); type1Map.put("108", Type.NORMAL); type1Map.put("115", Type.NORMAL);
        type1Map.put("23", Type.POISON); type1Map.put("27", Type.POISON); type1Map.put("31", Type.POISON); type1Map.put("42", Type.POISON); type1Map.put("88", Type.POISON); type1Map.put("29", Type.POISON);
        type1Map.put("59", Type.FEU); type1Map.put("78", Type.FEU);
        type1Map.put("63", Type.PSY); type1Map.put("80", Type.PSY);
        type1Map.put("74", Type.ROCHE); type1Map.put("76", Type.ROCHE); type1Map.put("95", Type.ROCHE);

        // Type2 assignments
        type2Map.put("150", Type.SANS);
        type2Map.put("6", Type.VOL); type2Map.put("146", Type.VOL); type2Map.put("144", Type.VOL); type2Map.put("145", Type.VOL); type2Map.put("149", Type.VOL);
        type2Map.put("3", Type.POISON); type2Map.put("2", Type.POISON); type2Map.put("1", Type.POISON); type2Map.put("102", Type.PSY); type2Map.put("44", Type.POISON);
        type2Map.put("12", Type.VOL); type2Map.put("46", Type.VOL);
        type2Map.put("18", Type.VOL); type2Map.put("17", Type.VOL); type2Map.put("21", Type.VOL); type2Map.put("42", Type.VOL); type2Map.put("83", Type.VOL);
        type2Map.put("27", Type.SOL); type2Map.put("51", Type.SOL); type2Map.put("74", Type.SOL); type2Map.put("76", Type.SOL); type2Map.put("95", Type.SOL);
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

        this.type1 = type1Map.getOrDefault(keyName, Type.SANS);
        this.type2 = type2Map.getOrDefault(keyName, Type.SANS);

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

    public String attack(Pokemon target) {
        StringBuilder log = new StringBuilder();
        Pokemon attacker = (this.speed >= target.getSpeed()) ? this : target;
        Pokemon defender = (attacker == this) ? target : this;

        log.append(attacker.getName()).append(" attaque ").append(defender.getName()).append("\n");

        int dmg;
        if (defender.getSpeed() > attacker.getSpeed()) {
            dmg = calculateDamage(defender, attacker);
            attacker.setHealth(attacker.getHealth() - dmg);
            log.append(" ➤ ").append(dmg).append(" dégâts infligés à ").append(attacker.getName()).append(".\n");
            if (attacker.getHealth() <= 0) {
                log.append(attacker.getName()).append(" est KO !");
            }
        } else {
            dmg = calculateDamage(attacker, defender);
            defender.setHealth(defender.getHealth() - dmg);
            log.append(" ➤ ").append(dmg).append(" dégâts infligés.\n");
            if (defender.getHealth() <= 0) {
                log.append(defender.getName()).append(" est KO !");
            }
        }

        return log.toString();
    }

    private int calculateDamage(Pokemon attacker, Pokemon defender) {
        double eff1 = Type.getEffectiveness(attacker.getType1(), defender.getType1());
        double eff2 = Type.getEffectiveness(attacker.getType2(), defender.getType2());
        double totalEff = eff1 + eff2;
        int base = Math.max(attacker.getAttack() - defender.getDefense(), 1);
        return (int) (base * totalEff);
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
    public int getType1() { return type1; }
    public int getType2() { return type2; }
}
