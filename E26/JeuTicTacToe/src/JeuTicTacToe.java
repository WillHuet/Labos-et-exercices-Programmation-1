import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JeuTicTacToe {
    //CONSTANTES
    private String ligneHorizontale = "---+---+---";
    private String separateur = " | ";
    private char letterP1 = 'X';
    private char letterP2 = 'O';

    //VARIABLES
    private Case[] tableau = new Case[9];
    private Random rand = new Random();
    private boolean ongoingGame = true;

    public void initializeBoard(){
        int j = 1;
        for(int i = 0; i < tableau.length; i++){
            tableau[i] = new Case((char) (j + '0'));
            j++;
        }
    }

    //DÉTERMINE LE JOUEUR QUI COMMENCE
    public boolean isUserStarting(){
        boolean result = false;
        int randomNumber = rand.nextInt(2);
        if(randomNumber == 0){
            result = true;
        }
        return result;
    }

    //DÉTERMINE SI LA CASE SÉLECTIONNÉE EST DISPONIBLE OU PAS
    public boolean isCaseAvailable(Case c){
        boolean result = true;
        if (c.getValue() == letterP1 || c.getValue() == letterP2) {
            result = false;
        }
        return result;
    }

    public void computersTurn(Case[] tab, char character){
        List<Character> available = new ArrayList<>();
        for(Case c : tab){
            if (c.getValue() != letterP1 && c.getValue() != letterP2) {
                available.add(c.getValue());
            }
        }
        int selectedPosition = rand.nextInt(available.size());
        char selected = available.get(selectedPosition);

        for(Case c : tab){
            if (c.getValue() == selected) {
                c.setValue(character);
            }
        }
    }

    //VALIDE SI UNE LIGNE GAGNANTE EST SUR LE PLATEAU, RETOURNE VRAI SI C'EST LE CAS
    public boolean isThereAWinningLine(){
        boolean result = false;
        //LIGNES HORIZONTALES
        if(tableau[0].getValue() == tableau[1].getValue() && tableau[0].getValue() == tableau[2].getValue()){
            result = true;
        } else if(tableau[3].getValue() == tableau[4].getValue() && tableau[3].getValue() == tableau[5].getValue()){
            result = true;
        } else if(tableau[6].getValue() == tableau[7].getValue() && tableau[6].getValue() == tableau[8].getValue()){
            result = true;
        }
        // LIGNES VERTICALES
        else if(tableau[0].getValue() == tableau[3].getValue() && tableau[0].getValue() == tableau[6].getValue()){
            result = true;
        } else if(tableau[1].getValue() == tableau[4].getValue() && tableau[1].getValue() == tableau[7].getValue()){
            result = true;
        } else if(tableau[2].getValue() == tableau[5].getValue() && tableau[2].getValue() == tableau[8].getValue()){
            result = true;
        }
        //LIGNES DIAGONALES
        else if(tableau[0].getValue() == tableau[4].getValue() && tableau[0].getValue() == tableau[8].getValue()){
            result = true;
        } else if(tableau[2].getValue() == tableau[4].getValue() && tableau[2].getValue() == tableau[6].getValue()){
            result = true;
        }

        return result;
    }

    public void game(){
        boolean startingPlayer = isUserStarting();
        Scanner input = new Scanner(System.in);
        if(startingPlayer){
            System.out.println("Vous allez jouer en premier!");
        } else {
            System.out.println("L'ordinateur jouera en premier...");
        }

        do {
            if(startingPlayer){
                tableauToString();
                System.out.print("Choisissez une case : ");
                char position = input.next().charAt(0);
                for (Case c : tableau) {
                    if (c.getValue() == position) {
                        c.setValue(letterP1);
                    }
                }
                System.out.println("Maintenant l'ordinateur va jouer!");
                computersTurn(tableau, letterP2);
            } else {

            }
        } while (ongoingGame);
    }

    public String tableauToString(){
        String grille = "";
        grille += " " + tableau[0].getValue() + separateur + tableau[1].getValue() + separateur + tableau[2].getValue() + " \n";
        grille += ligneHorizontale + '\n';
        grille += " " + tableau[3].getValue() + separateur + tableau[4].getValue() + separateur + tableau[5].getValue() + " \n";
        grille += ligneHorizontale + '\n';
        grille += " " + tableau[6].getValue() + separateur + tableau[7].getValue() + separateur + tableau[8].getValue() + " \n";
        return grille;
    }

    void main() {
        //DÉROULEMENT DE LA PARTIE
        System.out.println("Welcome to the Tic-Tac-Toe!");


        initializeBoard();
        tableau[0].setValue(letterP1);
        System.out.println(tableauToString());
        game();
    }
}
