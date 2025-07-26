import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;
import java.awt.Font;

public class GamePanel {
    private Plateau plateau;
    private Souris souris;

    public GamePanel(Plateau plateau) {
        this.plateau = plateau;
        this.souris = new Souris(Plateau.TAILLE_CASE * 9);
        plateau.getFenetre().addMouseListener(souris);
        plateau.getFenetre().addMouseMotionListener(souris);
    }
}

