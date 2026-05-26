import java.util.Random;

public class JeuTicTacToe {
    private Case[] tableau = new Case[9];
    private boolean isUserStarting = false;
    private boolean ongoingGame = true;
    private char letterP1 = 'X';
    private char letterP2 = 'O';

    public void initializeBoard(){
        int j = 1;
        for(int i = 0; i < tableau.length; i++){
            tableau[i] = new Case((char) (j + '0'));
            j++;
        }
    }

    //DÉTERMINE LE JOUEUR QUI COMMENCE
    public void startingPlayer(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(2);
        if(randomNumber == 0){
            isUserStarting = true;
        }
    }

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
        do {

        } while (ongoingGame);
    }

    public String tableauToString(){
        String grille = "";
        grille += " " + tableau[0].getValue() + " | " + tableau[1].getValue() + " | " + tableau[2].getValue() + " \n";
        grille += "---+---+---" + '\n';
        grille += " " + tableau[3].getValue() + " | " + tableau[4].getValue() + " | " + tableau[5].getValue() + " \n";
        grille += "---+---+---" + '\n';
        grille += " " + tableau[6].getValue() + " | " + tableau[7].getValue() + " | " + tableau[8].getValue() + " \n";
        return grille;
    }

    void main() {
        //DÉROULEMENT DE LA PARTIE
        System.out.println("Welcome to the Tic-Tac-Toe!");

        initializeBoard();
        System.out.println(tableauToString());
        game();
    }
}
