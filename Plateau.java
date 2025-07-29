
import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;

public class Plateau {
    public static final int TAILLE_CASE = 64;
    private Fenetre f;
    private ArrayList<Dessin> dessins = new ArrayList<>();

    public Plateau() {
        f = new Fenetre("Jeu Pokémon MG2D", TAILLE_CASE * 9, TAILLE_CASE * 9);
        majAffichage();
    }

    public void dessinerPlateau() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Couleur couleur = ((i + j) % 2 == 0) ? Couleur.GRIS_CLAIR : Couleur.BLANC;
                Carre c = new Carre(couleur, new Point(j * TAILLE_CASE, i * TAILLE_CASE), TAILLE_CASE, true);
                dessins.add(c);
                f.ajouter(c);
            }
        }
    }
    
    public Fenetre getFenetre() { return f; }
    public void majAffichage() {
        f.effacer();
        dessins.clear();
        dessinerPlateau();
    }
}