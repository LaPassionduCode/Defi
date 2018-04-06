//Classe qui gère le plateau de jeu (Grille)
public class Plateau {
    //On définit deux constantes pour la taille de la grille de jeu
    public static final int LIGNES = 3;
    public static final int COLONNES = 3;

    //On crée un tableau à 2 dimension de la classe cellule
    Cellule[][] cellules;
    int ligneActuel, colonneActuel;

    //constructeur pour initialiser le plateau de jeu
    public Plateau(){
        cellules = new Cellule[LIGNES][COLONNES];
        for (int ligne = 0; ligne < LIGNES; ++ligne){
            for (int colonne = 0; colonne < COLONNES; colonne++){
                cellules[ligne][colonne] = new Cellule(ligne, colonne);
            }
        }
    }

    //permet d'initialiser ou réinitialiser le plateau de jeu
    public void init(){
        for (int ligne = 0; ligne < LIGNES; ++ligne){
            for (int colonne = 0; colonne < COLONNES; colonne++){
                cellules[ligne][colonne].clear();
            }
        }
    }

    //permet de savoir si la partie se finie par une égalité
    public boolean egaliter(){
        for (int ligne = 0; ligne < LIGNES; ++ligne){
            for (int colonne = 0; colonne < COLONNES; colonne++){
                if (cellules[ligne][colonne].contenu == EtatCellule.VIDE){
                    return false;
                }
            }
        }
        return true;
    }

    //Permet de contrôler qui a gagné
    public boolean victoire(EtatCellule leContenu) {
        return (cellules[ligneActuel][0].contenu == leContenu         // 3 dans une ligne
                && cellules[ligneActuel][1].contenu == leContenu
                && cellules[ligneActuel][2].contenu == leContenu
                || cellules[0][colonneActuel].contenu == leContenu      // 3 dans une colonne
                && cellules[1][colonneActuel].contenu == leContenu
                && cellules[2][colonneActuel].contenu == leContenu
                || ligneActuel == colonneActuel            // 3 en diagonal
                && cellules[0][0].contenu == leContenu
                && cellules[1][1].contenu == leContenu
                && cellules[2][2].contenu == leContenu
                || ligneActuel + colonneActuel == 2    // 3 dans la diagonal opposée
                && cellules[0][2].contenu == leContenu
                && cellules[1][1].contenu == leContenu
                && cellules[2][0].contenu == leContenu);
    }

    //Permet d'afficher la grille dans la console avec l'état de la grille
    public void peindre() {
        for (int ligne = 0; ligne < LIGNES; ++ligne) {
            for (int colonne = 0; colonne < COLONNES; ++colonne) {
                cellules[ligne][colonne].peindre();   //
                if (colonne < COLONNES - 1) System.out.print("|");
            }
            System.out.println();
            if (ligne < LIGNES - 1) {
                System.out.println("-----------");
            }
        }
    }
}
