public class Type {

    public static final int NORMAL = 0;
    public static final int FEU = 1;
    public static final int EAU = 2;
    public static final int PLANTE = 3;
    public static final int ELECTRIK = 4;
    public static final int GLACE = 5;
    public static final int COMBAT = 6;
    public static final int POISON = 7;
    public static final int SOL = 8;
    public static final int VOL = 9;
    public static final int PSY = 10;
    public static final int INSECTE = 11;
    public static final int ROCHE = 12;
    public static final int SPECTRE = 13;
    public static final int DRAGON = 14;
    public static final int SANS = 15;

    public static final String[] TYPE_NAMES = {
        "Normal", "Feu", "Eau", "Plante", "Electrik", "Glace",
        "COMBAT", "Poison", "SOL", "VOL", "PSY",
        "INSECTE", "ROCHE", "SPECTRE", "Dragon", "Sans"
    };

    private static final double[][] EFFECTIVENESS = {
        // N    F    W    G    E    I    Fi   P    Gr   Fl   Ps   B    R    Gh   D    S
        {1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0.5, 0,   1,   1},  // Normal
        {1, 0.5, 0.5, 2,   1,   2,   1,   1,   1,   1,   1,   2,   0.5, 1,  0.5, 1},  // FEU
        {1,   2, 0.5, 0.5, 1,   1,   1,   1,   2,   1,   1,   1,   2,   1,  0.5, 1},  // EAU
        {1, 0.5, 2, 0.5,   1,   1,   1, 0.5,   2, 0.5,   1, 0.5,   2,   1,  0.5, 1},  // PLANTE
        {1,   1,   2, 0.5, 0.5,   1, 1,   1,   0,   2,   1,   1,   1,   1,  0.5, 1},  // ELECTRIK
        {1, 0.5, 0.5, 2,   1, 0.5, 1,   1,   2,   2,   1,   1,   1,   1,    2, 1},  // GLACE
        {2,   1,   1,   1,   1,   2, 1, 0.5,   1, 0.5, 0.5, 0.5,   2,   0,    1, 1},  // COMBAT
        {1,   1,   1,   2,   1,   1, 1, 0.5, 0.5,   1,   1,   1, 0.5, 0.5,   1, 1},  // Poison
        {1,   2,   1, 0.5,   2,   1, 1,   2,   1,   0,   1, 0.5,   2,   1,   1, 1},  // SOL
        {1,   1,   1,   2, 0.5,   1, 2,   1,   1,   1,   1,   2, 0.5,   1,   1, 1},  // VOL
        {1,   1,   1,   1,   1,   1, 2,   2,   1,   1, 0.5,   1,   1,   1,   1, 1},  // PSY
        {1, 0.5,   1,   2,   1,   1, 0.5, 0.5, 1, 0.5,   2,   1,   1, 0.5,   1, 1},  // INSECTE
        {1,   2,   1,   1,   1,   2, 0.5,   1, 0.5,   2,   1,   2,   1,   1,   1, 1},  // ROCHE
        {0,   1,   1,   1,   1,   1, 1,   1,   1,   1,   2,   1,   1,   2,   1, 1},  // SPECTRE
        {1,   1,   1,   1,   1,   1, 1,   1,   1,   1,   1,   1,   1,   1,   2, 1},  // Dragon
        {1,   1,   1,   1,   1,   1, 1,   1,   1,   1,   1,   1,   1,   1,   1, 1}   // Sans
    };

    public static double getEffectiveness(int attackerType, int defenderType) {
        if (attackerType >= 0 && attackerType < EFFECTIVENESS.length &&
            defenderType >= 0 && defenderType < EFFECTIVENESS[attackerType].length) {
            return EFFECTIVENESS[attackerType][defenderType];
        }
        return 1.0;
    }

    public static String getTypeName(int typeId) {
        if (typeId < 0 || typeId >= TYPE_NAMES.length) {
            return "Unknown";
        }
        return TYPE_NAMES[typeId];
    }
}
