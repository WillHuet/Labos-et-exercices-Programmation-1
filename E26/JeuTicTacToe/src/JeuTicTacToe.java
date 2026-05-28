import java.util.*;

public class JeuTicTacToe {
    //CONSTANTES
    private final String LIGNE_SEPARATRICE = "***********";
    private final String LIGNE_HORIZONTALE = Colors.GREEN + "---+---+---" + Colors.RESET;
    private final String LIGNE_VERTICALE = Colors.GREEN + " | " + Colors.RESET;
    private final String INPUT_CASE_SELECTION = "Choisissez une case valide : ";
    private final String ERROR_USED_CASE = Colors.FOND_ROUGE + "ERREUR! La case sélectionnée est déjà prise!" + Colors.RESET;
    private final String ERROR_WRONG_SELECTION = Colors.FOND_ROUGE + "ERREUR! La case sélectionnée n'est pas valide (entre 1 et 9)." + Colors.RESET;
    private final String WINNER_USER = "Vous avez gagné !!!";
    private final String WINNER_COMPUTER = "L'ordinateur a gagné ...";
    private final String DRAW = "Match nul ...";



    private final char LETTER_P1 = 'X';
    private final char LETTER_P2 = 'O';
    private List<Integer> VALID_CASE_CHOICE = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    //VARIABLES
    private Case[] tableau = new Case[9];
    private Random rand = new Random();
    Scanner input = new Scanner(System.in);

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
        if (c.getValue() == LETTER_P1 || c.getValue() == LETTER_P2) {
            result = false;
        }
        return result;
    }

    public void computersTurn(Case[] tab, char character){
        List<Character> available = new ArrayList<>();
        for(Case c : tab){
            if (c.getValue() != LETTER_P1 && c.getValue() != LETTER_P2) {
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

    public void playersTurn(Case[] tab, char character){
        boolean ongoingTurn = true;
        while (true) {
            System.out.print(tableauToString());
            System.out.println();
            System.out.print(INPUT_CASE_SELECTION);
            int position = input.nextInt();

            if (VALID_CASE_CHOICE.contains(position)) {
                if (isCaseAvailable(tab[position-1])) {
                    tab[position-1].setValue(character);
                    break;
                } else {
                    System.out.println(ERROR_USED_CASE);
                }
            } else {
                System.out.println(ERROR_WRONG_SELECTION);
            }
        }
    }


    public boolean isDraw(Case[] board) {
        boolean result = true;
        // Vérifie s'il y a une case vide
        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i].getValue() != LETTER_P1 && tableau[i].getValue() != LETTER_P2) {
                result = false;
            }
        }

        // Vérifie s'il y a un gagnant
        if (hasWinner(board, LETTER_P1) || hasWinner(board, LETTER_P2)) {
            result = false;
        }

        return result; // pas de case vide et pas de gagnant
    }

    //VALIDE SI UNE LIGNE GAGNANTE EST SUR LE PLATEAU, RETOURNE VRAI SI C'EST LE CAS
    public boolean hasWinner(Case[] board, char player) {
        boolean result = false;
        //LIGNES HORIZONTALES
        if(board[0].getValue() == player && board[1].getValue() == player && board[2].getValue() == player){
            result = true;
        } else if(board[3].getValue() == player && board[4].getValue() == player && board[5].getValue() == player){
            result = true;
        } else if(board[6].getValue() == player && board[7].getValue() == player && board[8].getValue() == player){
            result = true;
        }
        // LIGNES VERTICALES
        else if(board[0].getValue() == player && board[3].getValue() == player && board[6].getValue() == player){
            result = true;
        } else if(board[1].getValue() == player && board[4].getValue() == player && board[7].getValue() == player){
            result = true;
        } else if(board[2].getValue() == player && board[5].getValue() == player && board[8].getValue() == player){
            result = true;
        }
        //LIGNES DIAGONALES
        else if(board[0].getValue() == player && board[4].getValue() == player && board[8].getValue() == player){
            result = true;
        } else if(board[2].getValue() == player && board[4].getValue() == player && board[6].getValue() == player){
            result = true;
        }

        return result;
    }

    public void game(){
        boolean startingPlayer = isUserStarting();
        boolean ongoingGame = true;

        if(startingPlayer){
            System.out.println("Vous allez jouer en premier!");
        } else {
            System.out.println("L'ordinateur jouera en premier...");
        }

        while (true){
            if(startingPlayer){
                playersTurn(tableau, LETTER_P1);

                //verifie pour une ligne gagnante
                if(hasWinner(tableau, LETTER_P1)) {
                    System.out.println(tableauToString());
                    System.out.println("JOUEUR GAGNANT!!!");
                    break;
                }

                //verifie pour une egalite
                if (isDraw(tableau)) {
                    System.out.println(tableauToString());
                    System.out.println("Match nul ...");
                    break;
                }

                computersTurn(tableau, LETTER_P2);

                //verifie pour une ligne gagnante
                if(hasWinner(tableau, LETTER_P2)) {
                    System.out.println(tableauToString());
                    System.out.println("Ordinateur gagnant...");
                    break;
                }

                //verifie pour une egalite
                if (isDraw(tableau)) {
                    System.out.println(tableauToString());
                    System.out.println("Match nul ...");
                    break;
                }

            } else {
                computersTurn(tableau, LETTER_P1);

                //verifie pour une ligne gagnante
                if(hasWinner(tableau, LETTER_P1)) {
                    System.out.println(tableauToString());
                    System.out.println("Ordinateur gagnant...");
                    break;
                }

                //verifie pour une egalite
                if (isDraw(tableau)) {
                    System.out.println(tableauToString());
                    System.out.println("Match nul ...");
                    break;
                }

                playersTurn(tableau, LETTER_P2);

                //verifie pour une ligne gagnante
                if(hasWinner(tableau, LETTER_P2)) {
                    System.out.println(tableauToString());
                    System.out.println("JOUEUR GAGNANT!!!");
                    break;
                }

                //verifie pour une egalite
                if (isDraw(tableau)) {
                    System.out.println(tableauToString());
                    System.out.println("Match nul ...");
                    break;
                }
            }
        }
    }

    public String tableauToString(){
        String grille = "";

        List<String> newTableau = new ArrayList<>();
        for(int i = 0; i < tableau.length; i++){
            if(tableau[i].getValue() == LETTER_P1){
                newTableau.add(Colors.RED + tableau[i].getValue() + Colors.RESET);
            } else if(tableau[i].getValue() == LETTER_P2){
                newTableau.add(Colors.BLUE + tableau[i].getValue() + Colors.RESET);
            } else {
                newTableau.add("" + tableau[i].getValue());
            }
        }

        grille += " " + newTableau.get(0) + LIGNE_VERTICALE + newTableau.get(1) + LIGNE_VERTICALE + newTableau.get(2) + " \n";
        grille += LIGNE_HORIZONTALE + '\n';
        grille += " " + newTableau.get(3) + LIGNE_VERTICALE + newTableau.get(4) + LIGNE_VERTICALE + newTableau.get(5) + " \n";
        grille += LIGNE_HORIZONTALE + '\n';
        grille += " " + newTableau.get(6) + LIGNE_VERTICALE + newTableau.get(7) + LIGNE_VERTICALE + newTableau.get(8) + " \n";

        return grille;
    }

    void main() {
        //DÉROULEMENT DE LA PARTIE
        System.out.println("Bienvenue sur le jeu TicTacToe!");

        initializeBoard();
        game();
    }
}
