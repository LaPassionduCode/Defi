import java.util.Scanner;

public class JeuPrincipal {
    //On crée les variable de différent type pour stocker l'évolution du jeu
    private Plateau plateau;
    private Etat etatActuel;
    private EtatCellule joueurActuel;

    private static Scanner in = new Scanner(System.in);  // input Scanner

    public JeuPrincipal(){
    plateau = new Plateau();

    initieJeu();
    do {
        //On demande ce que veux jouer le joueur
        mouvementJoueur(joueurActuel);
        //on affiche l'état du jeu
        plateau.peindre();
        majJeu(joueurActuel);
        // Affiche un message en cas de fin de partie
        if (etatActuel == Etat.CROIX_GAGNE) {
            System.out.println("'X' a gagné! Au Revoir!");
        } else if (etatActuel == Etat.ROND_GAGNE) {
            System.out.println("'O' a gagné! Au Revoir!");
        } else if (etatActuel == Etat.EGALITER) {
            System.out.println("C'est une égalité! Au Revoir!");
        }
        // Change de joueur
        joueurActuel = (joueurActuel == EtatCellule.CROIX) ? EtatCellule.ROND : EtatCellule.CROIX;
        } while (etatActuel == Etat.EN_COURS);
    }

    //Méthode qui initialise la partie. Défini le premier joueur, et crée la grille vide
    public void initieJeu() {
        plateau.init();
        joueurActuel = EtatCellule.CROIX;
        etatActuel = Etat.EN_COURS;
    }

    //Méthode pour demander le mouvement du joueur.
    public void mouvementJoueur(EtatCellule leContenu) {
        boolean validInput = false;  // Pour s'assurer que l'utilisateur rentre une valeur correcte
        do {
            if (leContenu == EtatCellule.CROIX) {
                System.out.print("Joueur 'X', entrez votre mouvement (ligne[1-3] colonne[1-3]): ");
            } else {
                System.out.print("Player 'O', entrez votre mouvement (ligne[1-3] colonne[1-3]): ");
            }
            int ligne = in.nextInt() - 1;
            int colonne  = in.nextInt() - 1;
            if (ligne >= 0 && ligne < Plateau.LIGNES && colonne  >= 0 && colonne  < Plateau.COLONNES
                    && plateau.cellules[ligne][colonne ].contenu == EtatCellule.VIDE) {
                plateau.cellules[ligne][colonne ].contenu = leContenu;
                plateau.ligneActuel = ligne;
                plateau.colonneActuel = colonne ;
                validInput = true;
            } else {
                System.out.println("Le mouvement (" + (ligne + 1) + "," + (colonne  + 1)
                        + ") n'est pas valide. Essayez encore...");
            }
        } while (!validInput);
    }

    //Méthode qui contrôle si la partie est finie.
    public void majJeu(EtatCellule leContenu) {
        if (plateau.victoire(leContenu)) {  // contrôle les conditions de victoires
            etatActuel = (leContenu == EtatCellule.CROIX) ? Etat.CROIX_GAGNE : Etat.ROND_GAGNE;
        } else if (plateau.egaliter()) {  // contrôle l'égalité
            etatActuel = Etat.EGALITER;
        }
    }

    public static void main (String[] args){
        new  JeuPrincipal();
    }
}
