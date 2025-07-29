
import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;

public class Plateau {
    public static final int TAILLE_CASE = 64;
    private Pokemon[][] grid = new Pokemon[9][9];
    private Fenetre f;
    private ArrayList<Dessin> dessins = new ArrayList<>();

    public Plateau() {
        f = new Fenetre("Jeu Pokémon MG2D", TAILLE_CASE * 9, TAILLE_CASE * 9);
        setupDefault();
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

    public void placerPokemons() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Pokemon p = grid[i][j];
                if (p != null) {
                    p.afficher(f);
                }
            }
        }
        f.rafraichir();
    }

    public void setupDefault() {

        grid[2][3] = new Pokemon("63", 2, 3, 2);
        grid[2][4] = new Pokemon("74", 2, 4, 2);
        grid[2][5] = new Pokemon("78", 2, 5, 2);

        grid[6][3] = new Pokemon("88", 1, 3, 6);
        grid[6][4] = new Pokemon("95", 1, 4, 6);
        grid[6][5] = new Pokemon("108", 1, 5, 6);
    }

    public Fenetre getFenetre() { return f; }
    public Pokemon[][] getGrid() { return grid; }
    public void majAffichage() {
        f.effacer();
        dessins.clear();
        dessinerPlateau();
        placerPokemons();
    }
}


