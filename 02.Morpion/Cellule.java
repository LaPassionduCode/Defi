//Classe qui permettra de gérer les différentes cellules du plateau
public class Cellule {
    //on crée une variable de type EtatCellule
    EtatCellule contenu;

    int ligne, colonne;

    //Constructeur
    public Cellule (int ligne, int colonne){
        this.ligne = ligne;
        this.colonne = colonne;
        clear();
    }

    //Méthode pour vider la cellule
    public void clear(){
        contenu = EtatCellule.VIDE;
    }

    //Fonction qui affiche le contenu de la cellule
    public void peindre(){
        switch (contenu){
            case CROIX: System.out.print(" X "); break;
            case ROND: System.out.print(" O "); break;
            case VIDE: System.out.print("   "); break;
            }
    }
}
