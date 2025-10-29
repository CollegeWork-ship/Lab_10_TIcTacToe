import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String[][] board = new String[ROWS][COLS];

    public static void main(String[] args){
        clearBoard();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String player;
        int moveCnt = 0;
        int MOVES_TO_WIN = 4;
        int row;
        int col;
        boolean finished;
        boolean playing;
        do{

            player = "X";
            playing = true;
            clearBoard();
            do{
                do{
                    printBoard();

                    System.out.println("Enter move for " + player);
                     row = SafeInput.getRangedInt(input, "Enter row ", 1, 3);
                     col = SafeInput.getRangedInt(input2, "Enter column ", 1, 3);
                    row--; col--;
                }while(!isValidMove(row, col));
                board[row][col] = player;
                moveCnt++;
                System.out.println("move count: " + moveCnt);
                if(moveCnt >= MOVES_TO_WIN){
                    if (isWin(player)) {
                        printBoard();
                        System.out.println("Congratulations! You win!");
                        playing = false;
                    }
                }
                if(player.equals("X")){
                    player = "O";
                }
                else {
                    player = "X";
                }
                if(isTie()){
                    printBoard();
                    System.out.println("You tie!");
                    playing = false;
                }
            }while(playing);
            finished = SafeInput.getYNConfirm(input, "Done Playing? ");
            if(SafeInput.getYNConfirm(input, "Are you sure?")) {
                System.out.println("Thanks for playing!");
            }
        }while(finished);
    }
    private static void clearBoard() { // Clear the Board
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }
    private static void printBoard() { // Show the Board
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col] + " - ");
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }
    private static boolean isRowWin(String player){
        for (int row = 0; row < ROWS; row++) {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)){
                return true;
            }
        }
        return false;
    }
    private static boolean isColWin(String player){
        for (int col = 0; col < COLS; col++) {
            if(board[col][0].equals(player) && board[col][1].equals(player) && board[col][2].equals(player)){
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagnalWin(String player){

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        else if(board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player)) {
            return true;
        }
         return false;
    }
    private static boolean isWin(String player) {
        if (isRowWin(player) || isColWin(player) || isDiagnalWin(player)) {
            return true;
        }
        return false;
    }
    private static boolean isTie () {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
