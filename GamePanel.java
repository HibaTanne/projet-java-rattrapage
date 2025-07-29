import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;
import java.awt.Font;

public class GamePanel {
    private Plateau plateau;
    private Pokemon[][] grid;
    private Souris souris;
    private Pokemon selected = null;
    private Texte messageTour;

    public GamePanel(Plateau plateau) {
        this.plateau = plateau;
        this.grid = plateau.getGrid();

        this.souris = new Souris(Plateau.TAILLE_CASE * 9);
        plateau.getFenetre().addMouseListener(souris);
        plateau.getFenetre().addMouseMotionListener(souris);

        // ✅ Message de tour de joueur
        messageTour = new Texte(
            Couleur.ROUGE,
            "Au joueur rouge de jouer",
            new Font("Arial", Font.BOLD, 22),
            new Point(Plateau.TAILLE_CASE * 2, Plateau.TAILLE_CASE * 9 - 25)
        );
        plateau.getFenetre().ajouter(messageTour);

    }
}

