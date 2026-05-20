
/**
 * Classe contenant une methode a utiliser pour le TP3 de INF1120.
 * @author Melanie Lord
 * @version H26
 */
public class TP3Util {
   
   //CONSTANTES PRIVEES
   private final static char MINE = '*';
   private final static char ESP = ' ';
   
   /**
    * Cette methode construit aleatoirement une grille de jeu de demineur 
    * (jeu solution) selon un nombre donne de mines, et un nombre donne de lignes 
    * et de colonnes.
    * 
    * Par exemple, la construction d'une grille de 3 lignes par 3 colonnes et
    * contenant 4 mines pourrait retourner le tableau de caracteres a deux 
    * dimensions suivant :
    * 
    *       | * | 3 | * | 
    *       -------------
    *       | 2 | 4 | * |
    *       -------------
    *       | * | 2 | 1 |   
    *
    * @param nbrLignes le nombre de lignes de la grille du jeu a construire.
    *       ANT: nbrLignes est un entier > 0.
    * @param nbrCol le nombre de colonnes de la grille du jeu a construire.
    *       ANT: nbrCol est un entier > 0.
    * @param nbrMines le nombre de mines dans le jeu a construire.
    *       ANT: nbrMines est un entier >= 0 et <= (nbrLignes * nbrCol).
    * @return un tableau de caracteres a 2 dimensions qui represente la grille 
    *         solution (avec les indices et les mines) d'un jeu de demineur 
    *         construit aleatoirement.
    */
   public static char[][] construireGrilleJeuSolution(int nbrLignes, int nbrCol, int nbrMines) {
      
      char[][] grille;
      
      //5 grilles fixes (pour tests)
      
      if (nbrMines == 7 && nbrLignes == 4 && nbrCol == 3) {
         //Grille 4 X 3 (avec 7 mines)
         grille = new char[][] { 
               {MINE, '3', MINE}, 
               {'4', MINE, '3'}, 
               {MINE, MINE, '4'}, 
               {'3', MINE, MINE} 
         };
         
      } else if (nbrMines == 12 && nbrLignes == 5 && nbrCol == 5) {
         //Grille 5 X 5 (avec 12 mines)
         grille = new char[][] { 
                     {'2', MINE, '2', '2', '2'}, 
                     {MINE, '3', '3', MINE, MINE}, 
                     {'2', '4', MINE, '6', MINE}, 
                     {'3', MINE, MINE, MINE, '3'}, 
                     {MINE, MINE, '4', '3', MINE} };
         
      } else if (nbrMines == 3 && nbrLignes == 3 && nbrCol == 3) {
         //Grille 3 X 3 (avec 3 mines)
         grille = new char[][] { 
                     {'1', '3', MINE}, 
                     {MINE, '3', MINE}, 
                     {'1', '2', '1'} 
         };
      
      } else if (nbrMines == 16 && nbrLignes == 7 && nbrCol == 8) {
         //Grille 7 X 8 (avec 16 mines)
         grille = new char[][] { 
            {'1', '2', '2', '3', MINE, '2', '1', '1'},
            {MINE, '2', MINE, MINE, '4', '3', MINE, '1'},
            {'3', '4', '4', MINE, MINE, '4', '2', '2'},
            {MINE, MINE, '2', '3', MINE, '4', MINE, '1'},
            {'3', '4', '3', '2', '2', MINE, '2', '1'},
            {'1', MINE, MINE, '2', '1', '1', '2', '1'},
            {'1', '3', MINE, '2', '0', '0', '1', MINE}
         };
         
      } else if (nbrMines == 9 && nbrLignes == 4 && nbrCol == 5) {
         //Grille 4 X 5 (avec 9 mines)
         grille = new char[][] { 
            {'2', MINE, MINE, '3', '2'}, 
            {MINE, '4', '5', MINE, MINE}, 
            {'3', MINE, '4', MINE, '4'}, 
            {MINE, '2', '3', MINE, '2'} 
         };
         
      } else {
         //autres grilles aleatoires
         grille = new char[nbrLignes][nbrCol];
         viderGrille(grille);
         placerMinesDansJeu(grille, nbrMines);
         placerIndicesDansJeu(grille);
      }
      
      return grille;
   }
   

   /************************
    * METHODES PRIVEES
    ************************/
   
   /**
    * Affecte chaque case de la grille donnee par un caractere espace (' ').
    * @param grille la grille a remplir avec des espaces.
    *    ANT: grille n'est pas null. 
    */
   private static void viderGrille (char[][] grille) {
      //remplir les cases d'espaces (' ')
      for (char[] ligne : grille) {
         for (int i = 0 ; i < ligne.length ; i++) {
            ligne[i] = ESP;
         }
      }
   }
   
   /**
    * Affecte le caractere '*' a nbrMines cases de la grille donnee, de maniere
    * aleatoire.
    * @param grille la grille dans laquelle on veut placer les mines ('*')  
    *        aleatoirement.
    *        ANT : grille n'est pas null et contient au moins une case.
    * @param nbrMines le nombre de mines a placer aleatoirement dans la grille.
    */
   private static void placerMinesDansJeu(char[][] grille, int nbrMines) {
      int noLigne;
      int noCol;
      int nbr;
      
      for (int i = 1 ; i <= nbrMines ; i++) {
         nbr = tirerUnNombre(0, (grille.length * grille[0].length - 1));
         noLigne = nbr / grille[0].length;
         noCol = nbr % grille[0].length;
         
         while (grille[noLigne][noCol] == MINE) {
            nbr = tirerUnNombre(0, (grille.length * grille[0].length - 1));
            noLigne = nbr / grille[0].length;
            noCol = nbr % grille[0].length;
         }
         
         grille[noLigne][noCol] = MINE;
      }     
   }
   
   /**
    * Affecte un indice dans chaque case de la grille donnee qui ne contient 
    * pas le caractere '*'. L'indice dans une case x represente le nombre de cases 
    * contenant le caractere '*' dans les cases adjacentes a cette case x.
    * 
    * @param grille la grille dans laquelle on ajoute les indices.
    *        ANT : grille n'est pas null, et contient au moins une case.
    */
   private static void placerIndicesDansJeu(char[][] grille) {
      int nbMinesAutour;
      
      for (int i = 0 ; i < grille.length ; i++) {
         for (int j = 0  ; j < grille[i].length ; j++) {
            nbMinesAutour = 0;
            
            if (grille[i][j] != MINE) {
               try {
                  if (grille[i - 1][j - 1] == MINE) nbMinesAutour++; 
               } catch (IndexOutOfBoundsException e) {}
               try {
                  if (grille[i - 1][j] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               try {
                  if (grille[i - 1][j + 1] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               try {
                  if (grille[i][j - 1] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               try {
                  if (grille[i][j + 1] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               try {
                  if (grille[i + 1][j - 1] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               try {
                  if (grille[i + 1][j] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               try {   
                  if (grille[i + 1][j + 1] == MINE) nbMinesAutour++;
               } catch (IndexOutOfBoundsException e) {}
               
               grille[i][j] = (nbMinesAutour + "").charAt(0);
            }
         }
      }
   }
   
   /**
    * Retourne un nombre entier tire au hasard entre min et max inclusivement.
    *
    * @param min la borne minimale du nombre a tirer.
    * @param max la borne maximale du nombre a tirer.
    * @return un entier tire au hasard entre min et max inclusivement.
    */
   private static int tirerUnNombre(int min, int max) {
      return (int) (Math.random() * (max - min) + min + 0.5);
   }

}
