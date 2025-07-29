import MG2D.*;
import MG2D.geometrie.*;
import java.util.ArrayList;
import java.awt.Font;

public class GamePanel {
    private Plateau plateau;
    private Pokemon[][] grid;
    private Souris souris;
    private int currentPlayer = 1;
    private Pokemon selected = null;
    private ArrayList<CercleAccessible> cerclesAccessibles = new ArrayList<>();
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

        boucleJeu();
    }

    private void boucleJeu() {
        while (true) {
            if (souris.getClicGauche()) {
                Point pos = souris.getPosition();
                int x = pos.getX() / Plateau.TAILLE_CASE;
                int y = pos.getY() / Plateau.TAILLE_CASE;

                if (x >= 0 && x < 9 && y >= 0 && y < 9) {
                    handleClick(x, y);
                }
                souris.reinitialisation();
            }

            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }

    private void handleClick(int x, int y) {
        Pokemon cible = grid[y][x];

        if (selected == null) {
            if (cible != null && cible.getPlayerId() == currentPlayer) {
                selected = cible;
                afficherCasesAccessibles(cible);
                System.out.println("Sélectionné : " + selected.getName());
            }
        } else {
            if (estCaseAccessible(x, y)) {
                if (cible == null) {
                    grid[selected.getGridY()][selected.getGridX()] = null;
                    selected.setGridPosition(x, y);
                    grid[y][x] = selected;
                    changerTour();
                } else if (cible.getPlayerId() != currentPlayer) {
                    if (cible.getHealth() <= 0) {
                        grid[y][x] = null;
                        if (cible.getKeyName().equalsIgnoreCase("150")) {
                            victoire(currentPlayer);
                        }
                    }
                    changerTour();
                }

                selected = null;
                plateau.majAffichage();
                // réafficher le message du tour
                plateau.getFenetre().ajouter(messageTour);
                plateau.getFenetre().rafraichir();
            } else {
                System.out.println("Cible hors de portée.");
                selected = null;
                plateau.majAffichage();
                plateau.getFenetre().ajouter(messageTour);
                plateau.getFenetre().rafraichir();
            }
        }
    }

    private void afficherCasesAccessibles(Pokemon p) {
        cerclesAccessibles.clear();
        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        for (int[] d : dirs) {
            int nx = p.getGridX() + d[0];
            int ny = p.getGridY() + d[1];
            if (nx >= 0 && nx < 9 && ny >= 0 && ny < 9) {
                Pokemon cible = grid[ny][nx];
                if (cible == null || cible.getPlayerId() != p.getPlayerId()) {
                    Point centre = new Point(
                        nx * Plateau.TAILLE_CASE + Plateau.TAILLE_CASE / 2,
                        ny * Plateau.TAILLE_CASE + Plateau.TAILLE_CASE / 2
                    );
                    Cercle cercle = new Cercle(Couleur.NOIR, centre, Plateau.TAILLE_CASE / 4, false);
                    cerclesAccessibles.add(new CercleAccessible(cercle, nx, ny));
                    plateau.getFenetre().ajouter(cercle);
                }
            }
        }
        plateau.getFenetre().rafraichir();
    }

    private boolean estCaseAccessible(int x, int y) {
        for (CercleAccessible c : cerclesAccessibles) {
            if (c.x == x && c.y == y) return true;
        }
        return false;
    }

    private void changerTour() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
        System.out.println("Tour du joueur " + currentPlayer);
        messageTour.setTexte("Au joueur " + (currentPlayer == 1 ? "rouge" : "vert") + " de jouer");
        messageTour.setCouleur(currentPlayer == 1 ? Couleur.ROUGE : Couleur.VERT);
    }

    private void victoire(int joueur) {
        System.out.println("🎉 Joueur " + joueur + " a gagné !");
        messageTour.setTexte("🎉 Joueur " + joueur + " a gagné !");
        messageTour.setCouleur(Couleur.BLEU);
        plateau.getFenetre().ajouter(messageTour);
        plateau.getFenetre().rafraichir();
        try { Thread.sleep(5000); } catch (Exception e) {}
        System.exit(0);
    }

    private class CercleAccessible {
        Cercle cercle;
        int x, y;

        CercleAccessible(Cercle c, int x, int y) {
            this.cercle = c;
            this.x = x;
            this.y = y;
        }
    }
}

