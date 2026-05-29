import java.util.*;

public class JeuTicTacToe {
    /*
    //  ++++++++++++++
    //  + CONSTANTES +
    //  ++++++++++++++
    */
    private final String LINE_JUMP = " \n";
    private final String LINE_BREAK = "***********";
    private final String BOARD_HORIZONTAL_LINE = Colors.GREEN + "---+---+---" + Colors.RESET;
    private final String BOARD_VERTICAL_LINE = Colors.GREEN + " | " + Colors.RESET;
    private final String MSG_WELCOME = Colors.FOND_VERT + "BIENVENUE SUR LE JEU DE TIC-TAC-TOE!" + Colors.RESET;
    private final String MSG_INPUT_POSITION_SELECTION = "À VOTRE TOUR" + LINE_JUMP + "Choisissez une case valide : ";
    private final String MSG_WINNER_USER = "VOUS AVEZ GAGNÉ!!!" + LINE_JUMP + "Félicitation!!!";
    private final String MSG_WINNER_COMPUTER = "L'ordinateur a gagné" + LINE_JUMP + "Meilleur chance la prochaine fois...";
    private final String MSG_DRAW = "Match nul" + LINE_JUMP + "Personne ne gagne...";
    private final String MSG_PLAYER_STARTS = "Vous allez jouer en premier!";
    private final String MSG_COMPUTER_STARTS = "L'ordinateur jouera en premier...";

    private final String ERROR_USED_CASE = Colors.FOND_ROUGE + "ERREUR! La case sélectionnée est déjà prise!" + Colors.RESET;
    private final String ERROR_WRONG_SELECTION = Colors.FOND_ROUGE + "ERREUR! La case sélectionnée n'est pas valide (entre 1 et 9)." + Colors.RESET;
    private final String ERROR_WRONG_INPUT = Colors.FOND_ROUGE + "ERREUR! La valeur rentrée n'est pas numérique! Recommencez..." + Colors.RESET;

    private final char LETTER_P1 = 'X';
    private final char LETTER_P2 = 'O';
    private final List<Integer> VALID_POSITION_LIST = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    /*
    //  +++++++++++++
    //  + VARIABLES +
    //  +++++++++++++
    */
    private Case[] gameBoard = new Case[9];
    private Random rand = new Random();
    private Scanner input = new Scanner(System.in);

    /*
    //  +++++++++++++++++++++++
    //  + MÉTHODES VALIDATION +
    //  +++++++++++++++++++++++
    */

    /**
     * Cette méthode construit le tableau de jeu vide (case 1 à 9)
     */
    public void initializeBoard(){
        int j = 1;
        for(int i = 0; i < gameBoard.length; i++){
            gameBoard[i] = new Case((char) (j + '0'));
            j++;
        }
    }

    /**
     * Cette méthode utilise un objet « Random » afin de déterminer quel joueur commencera.
     * L'objet peut seulement retourner la valeur 0 ou 1. L'utilisateur commence si la valeur est 0.
     */
    public boolean isUserStarting(){
        boolean result = false;
        int randomNumber = rand.nextInt(2);
        if(randomNumber == 0){
            result = true;
        }
        return result;
    }

    /**
     * Cette méthode détermine si la case sélectionnée est disponible ou pas.
     *
     * @param c la case que l'on souhaite valider
     * @return TRUE si la case est libre, FALSE si elle ne l'est pas
     */
    public boolean isCaseAvailable(Case c){
        boolean result = true;
        if (c.getValue() == LETTER_P1 || c.getValue() == LETTER_P2) {
            result = false;
        }
        return result;
    }

    /**
     * Cette méthode effectue le tour de l'ordinateur.
     * On commence par créer une nouvelle ArrayList<>() et d'y ajouter toutes les cases encore disponible.
     * Ensuite, avec un objet « Random », on va choisir aléatoirement une des cases de cette nouvelle liste
     * et y ajouter la lettre qui correspond à l'ordinateur (X ou O).
     *
     * @param board le tableau de jeu déjà initialisé et actualisé.
     * @param character le caractère qui correspond à l'ordinateur (dépends s'il commence ou pas).
     */
    public void computersTurn(Case[] board, char character){
        List<Character> available = new ArrayList<>();
        for(Case c : board){
            if (c.getValue() != LETTER_P1 && c.getValue() != LETTER_P2) {
                available.add(c.getValue());
            }
        }
        int selectedPosition = rand.nextInt(available.size());
        char selected = available.get(selectedPosition);
        for(Case c : board){
            if (c.getValue() == selected) {
                c.setValue(character);
            }
        }
    }

    /**
     * Cette méthode effectue le tour de l'utilisateur.
     * On commence par afficher le tableau actualisé et on demande à l'utilisateur de rentrer une valeur.
     * Une validation est effectuée. Si jamais l'utilisateur rentre une valeur non-numérique, une valeur
     * non conforme ou bien une valeur déjà prise, on affiche un message d'erreur et demande à nouveau.
     *
     * Si la valeur est conforme, on remplace sa valeur par le caractère de l'utilisateur (X ou O).
     *
     * @param board le tableau de jeu déjà initialisé et actualisé.
     * @param character le charactère qui correspond à l'utilisateur (dépends s'il commence ou pas)
     */
    public void playersTurn(Case[] board, char character){
        int position = 0;
        boolean ongoingTurn = true;
        while (true) {
            System.out.print(boardToString());
            System.out.println();
            System.out.print(MSG_INPUT_POSITION_SELECTION);

            if (input.hasNextInt()) {
                position = input.nextInt();
            } else {
                System.out.println(ERROR_WRONG_INPUT);
                input.nextLine();
                continue;
            }

            if (VALID_POSITION_LIST.contains(position)) {
                if (isCaseAvailable(board[position-1])) {
                    board[position-1].setValue(character);
                    break;
                } else {
                    System.out.println(ERROR_USED_CASE);
                }
            } else {
                System.out.println(ERROR_WRONG_SELECTION);
            }
        }
    }

    /**
     * Cette méthode détermine si une égalité est survenue.
     * On retourne TRUE de base. Si l'une des cases n'a pas été sélectionné ou
     * si l'un des deux joueurs a gagné, on change la valeur pour faux.
     *
     * @param board le tableau de jeu déjà initialisé et actualisé.
     * @return TRUE s'il y une égalité, FALSE si non.
     */
    public boolean isDraw(Case[] board) {
        boolean result = true;
        // Vérifie s'il y a une case vide
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i].getValue() != LETTER_P1 && gameBoard[i].getValue() != LETTER_P2) {
                result = false;
            }
        }

        // Vérifie s'il y a un gagnant
        if (hasWinner(board, LETTER_P1) || hasWinner(board, LETTER_P2)) {
            result = false;
        }

        return result; // pas de case vide et pas de gagnant
    }

    /**
     * Cette méthode détermine si l'un des deux joueurs possède une ligne gagnante.
     * On retourne FALSE de base. Si l'un des joueurs possède une ligne horizontale, verticale ou diagonale complète,
     * on change la valeur pour TRUE.
     *
     * @param board le tableau de jeu déjà initialisé et actualisé.
     * @param player caractère du joueur que l'on souhaite analyser
     * @return TRUE s'il y a une ligne gagnante, FALSE si non.
     */
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

    /**
     * Cette méthode effectue la partie de TicTacToe.
     * On commence par appeler la méthode « initializeBoard() » pour initialiser le tableau.
     * Ensuite, on appelle la méthode « isUserStarting() » pour déterminer qui commence.
     *
     * Après chaque coup, que ce soit par l'utilisateur ou l'ordinateur, on valide si son coup met fin
     * à la partie (si cette personne a gagné ou si elle cause une égalité).
     * Si ce n'est pas le cas, la boucle "while" continue.
     */
    public void game(){
        initializeBoard();
        boolean startingPlayer = isUserStarting();
        boolean ongoingGame = true;

        if(startingPlayer){
            System.out.println(MSG_PLAYER_STARTS);
        } else {
            System.out.println(MSG_COMPUTER_STARTS);
        }

        while (true){

            //===================================
            //JOUEUR EN PREMIER, ORDI EN DEUXIÈME
            //===================================
            if(startingPlayer){
                //TOUR DE L'UTILISATEUR
                playersTurn(gameBoard, LETTER_P1);

                //SI LE JOUEUR A GAGNÉ
                if(hasWinner(gameBoard, LETTER_P1)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_WINNER_USER);
                    break;
                }

                //SI UNE ÉGALITÉ
                if (isDraw(gameBoard)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_DRAW);
                    break;
                }

                //TOUR DE L'ORDINATEUR
                computersTurn(gameBoard, LETTER_P2);

                //SI L'ORDI A GAGNÉ
                if(hasWinner(gameBoard, LETTER_P2)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_WINNER_COMPUTER);
                    break;
                }

                //SI UNE ÉGALITÉ
                if (isDraw(gameBoard)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_DRAW);
                    break;
                }

            //===================================
            //ORDI EN PREMIER, JOUEUR EN DEUXIÈME
            //===================================
            } else {
                computersTurn(gameBoard, LETTER_P1);

                //SI L'ORDI A GAGNÉ
                if(hasWinner(gameBoard, LETTER_P1)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_WINNER_COMPUTER);
                    break;
                }

                //SI UNE ÉGALITÉ
                if (isDraw(gameBoard)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_DRAW);
                    break;
                }

                //TOUR DU JOUEUR
                playersTurn(gameBoard, LETTER_P2);

                //SI LE JOUEUR A GAGNÉ
                if(hasWinner(gameBoard, LETTER_P2)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_WINNER_USER);
                    break;
                }

                //SI UNE ÉGALITÉ
                if (isDraw(gameBoard)) {
                    System.out.println(boardToString());
                    System.out.println(MSG_DRAW);
                    break;
                }
            }
        }
    }

    /**
     * Cette méthode permet d'afficher le tableau actualisé.
     *
     * On commence par créer une nouvelle liste afin de mettre des couleurs aux 'X' et 'O'.
     * (NOTE: choix personnel, je trouvais que c'était difficile à lire les coups lorsque tout était en blanc)
     * (Les 'X' en rouge et les 'O' en bleu.)
     *
     * On effectue par la suite une concaténation de toutes les valeurs afin d'obtenir quelque chose comme ceci:
     *
     * ***********
     *  1 | 2 | 3
     * ---+---+---
     *  4 | 5 | 6
     * ---+---+---
     *  7 | 8 | 9
     * ***********
     *
     * (au fil de la partie, les chiffres seront remplacés par les 'X' et 'O')
     *
     * @return la concaténation de tout ce qui forme notre tableau.
     */
    public String boardToString(){
        String board = "";

        List<String> newBoard = new ArrayList<>();
        for(int i = 0; i < gameBoard.length; i++){
            if(gameBoard[i].getValue() == LETTER_P1){
                newBoard.add(Colors.RED + gameBoard[i].getValue() + Colors.RESET);
            } else if(gameBoard[i].getValue() == LETTER_P2){
                newBoard.add(Colors.BLUE + gameBoard[i].getValue() + Colors.RESET);
            } else {
                newBoard.add("" + gameBoard[i].getValue());
            }
        }
        board += LINE_JUMP + LINE_BREAK + LINE_JUMP;
        board += " " + newBoard.get(0) + BOARD_VERTICAL_LINE + newBoard.get(1) + BOARD_VERTICAL_LINE + newBoard.get(2) + LINE_JUMP;
        board += BOARD_HORIZONTAL_LINE + LINE_JUMP;
        board += " " + newBoard.get(3) + BOARD_VERTICAL_LINE + newBoard.get(4) + BOARD_VERTICAL_LINE + newBoard.get(5) + LINE_JUMP;
        board += BOARD_HORIZONTAL_LINE + LINE_JUMP;
        board += " " + newBoard.get(6) + BOARD_VERTICAL_LINE + newBoard.get(7) + BOARD_VERTICAL_LINE + newBoard.get(8) + LINE_JUMP;
        board += LINE_BREAK + LINE_JUMP;

        return board;
    }

    /*
    //  ++++++++++++++++++++++++++
    //  + CLASSE EXÉCUTABLE MAIN +
    //  ++++++++++++++++++++++++++
    */

    /**
     * Cette méthode est exécutable.
     * On affiche seulement un message d'accueil ainsi que l'appel de la méthode « game() ».
     */
    void main() {
        System.out.println(MSG_WELCOME + LINE_JUMP);
        game();
    }
}
