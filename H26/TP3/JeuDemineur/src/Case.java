
/**
 * Cette classe modelise une case dans une grille n x m ou n est le nombre de 
 * lignes de la grille et m, son nombre de colonnes. Une case est representee
 * par un numero de ligne (entre 1 et n) et un numero de colonne (entre 1 et m).
 * 
 * ATTENTION : les methodes de cette classe n'empeche pas la creation d'une
 * case avec un nombre negatif ou nul comme numero de ligne ou de colonne ou 
 * un nombre > n pour le numero de ligne et un nombre > m pour le numero de 
 * colonne. Il en revient au programme utilisateur de verifier la validite 
 * du numero de ligne et de colonne.
 * 
 * Classe fournie dans le cadre du TP3 INF1120
 * 
 * @author Melanie Lord
 * @version H26
 */
public class Case {
   
   private int noLigne;    //le numero de ligne de cette case
   private int noColonne;  //le numero de colonne de cette case
   
   /**
    * Constructeur qui initialise le numero de ligne et de colonne de cette 
    * case par noLigne et noCol donnes en parametres.
    * @param noLigne le numero de ligne de cette case.
    * @param noCol le numero de colonne de cette case.
    */
   public Case (int noLigne, int noCol) {
      this.noLigne = noLigne;
      this.noColonne = noCol;
   }

   /**
    * Permet d'obtenir le numero de ligne de cette case.
    * @return le numero de ligne de cette case.
    */
   public int getNoLigne() {
      return noLigne;
   }

   /**
    * Permet de modifier le numero de ligne de cette case par le noLigne donne.
    * @param noLigne le nouveau numero de ligne de cette case.
    */
   public void setNoLigne(int noLigne) {
      this.noLigne = noLigne;
   }

   /**
    * Permet d'obtenir le numero de colonne de cette case.
    * @return le numero de colonne de cette case.
    */
   public int getNoColonne() {
      return noColonne;
   }

   /**
    * Permet de modifier le numero de colonne de cette case par le noColonne 
    * donne.
    * @param noColonne le nouveau numero de colonne de cette case.
    */
   public void setNoColonne(int noColonne) {
      this.noColonne = noColonne;
   }

}
