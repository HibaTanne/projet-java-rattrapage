
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
        grid[0][0] = new Pokemon("1", 2, 0, 0);
        grid[0][1] = new Pokemon("2", 2, 1, 0);
        grid[0][2] = new Pokemon("3", 2, 2, 0);
        grid[0][3] = new Pokemon("4", 2, 3, 0);
        grid[0][4] = new Pokemon("5", 2, 4, 0);
        grid[0][5] = new Pokemon("6", 2, 5, 0);
        grid[0][6] = new Pokemon("7", 2, 6, 0);
        grid[0][7] = new Pokemon("8", 2, 7, 0);
        grid[0][8] = new Pokemon("9", 2, 8, 0);

        grid[1][0] = new Pokemon("10", 2, 0, 1);
        grid[1][1] = new Pokemon("12", 2, 1, 1);
        grid[1][2] = new Pokemon("18", 2, 2, 1);
        grid[1][3] = new Pokemon("21", 2, 3, 1);
        grid[1][4] = new Pokemon("27", 2, 4, 1);
        grid[1][5] = new Pokemon("31", 2, 5, 1);
        grid[1][6] = new Pokemon("42", 2, 6, 1);
        grid[1][7] = new Pokemon("46", 2, 7, 1);
        grid[1][8] = new Pokemon("59", 2, 8, 1);

        grid[2][3] = new Pokemon("63", 2, 3, 2);
        grid[2][4] = new Pokemon("74", 2, 4, 2);
        grid[2][5] = new Pokemon("78", 2, 5, 2);

        grid[6][3] = new Pokemon("88", 1, 3, 6);
        grid[6][4] = new Pokemon("95", 1, 4, 6);
        grid[6][5] = new Pokemon("108", 1, 5, 6);

        grid[7][0] = new Pokemon("145", 1, 0, 7);
        grid[7][1] = new Pokemon("150", 1, 1, 7);
        grid[7][2] = new Pokemon("36", 1, 2, 7);
        grid[7][3] = new Pokemon("115", 1, 3, 7);
        grid[7][4] = new Pokemon("146", 1, 4, 7);
        grid[7][5] = new Pokemon("25", 1, 5, 7);
        grid[7][6] = new Pokemon("40", 1, 6, 7);
        grid[7][7] = new Pokemon("17", 1, 7, 7);
        grid[7][8] = new Pokemon("23", 1, 8, 7);
        grid[8][0] = new Pokemon("35", 1, 0, 8);
        grid[8][1] = new Pokemon("51", 1, 1, 8);
        grid[8][2] = new Pokemon("69", 1, 2, 8);
        grid[8][3] = new Pokemon("83", 1, 3, 8);
        grid[8][4] = new Pokemon("102", 1, 4, 8);
        grid[8][5] = new Pokemon("144", 1, 5, 8);
        grid[8][6] = new Pokemon("149", 1, 6, 8);
        grid[8][7] = new Pokemon("29", 1, 7, 8);
        grid[8][8] = new Pokemon("44", 1, 8, 8);
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


