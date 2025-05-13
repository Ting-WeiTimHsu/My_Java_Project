
/**
 * Tic- Tac- Toe Game-Main Tic-Tac-Toe Class
 * @author Tim Hsu
 * @version 20241204
 */
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board currentboard = new Board(); // create currentboard with the TicTacToe.Board() class
        char currentPlayer = 'x';
        boolean valid_input;
        int rows = -1, cols = -1; // initialize rows and columns

        while (!currentboard.isFull() && !currentboard.isWin()) {
            valid_input = false;
            currentboard.print(); // print the initial board at the start of the game
            System.out.printf("%c player: Enter row and column numbers:", currentboard.getCurrentPlayer()); // get the
                                                                                                            // choice
                                                                                                            // from the
                                                                                                            // players
            while (!valid_input) {
                rows = in.nextInt() - 1; // adjust the index into java index from the players
                cols = in.nextInt() - 1;
                if ((0 <= rows && rows < 3) && (0 <= cols && cols < 3) && currentboard.setRowCol(rows, cols)) {
                    valid_input = true;
                } else {
                    System.out.println("Incorrect cell. Try again!"); // check the valid input and if the cell isn't
                                                                      // occupied.
                    System.out.print("Enter row and column numbers:");
                }
            }
            if (currentboard.isWin()) { // check if one of the players win after each move
                currentboard.print();
                System.out.printf("%c player wins!\n", currentPlayer); // print the winning message
                System.out.println("Goodbye!");
                return;
            }
            currentboard.changePlayer(); // switch the player
        }
    }

    /**
     * Tic- Tac- Toe Game-TicTacToe.Board Class
     * 
     * @author Tim Hsu
     * @version 20241204
     */
    public static class Board {

        private char[][] board;
        private char currentPlayer;

        /**
         * This is the constructor for the class. It initializes the board so all cells
         * in the board are equal to '-'. The currentPlayer
         * is initialized to 'x'.
         *
         */
        public Board() {
            currentPlayer = 'x'; // default current player to x
            board = new char[3][3]; // create the initial 3x3 board with -
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = '-';
                }
            }
        }

        /**
         * The method outputs the board in the following format. First the message
         * "Current board" underligned is printed.
         * Then the content of the board is printed as a 3 by 3 matrix.
         */
        public void print() {
            System.out.println("Current TicTacToe.Board"); // print the title
            System.out.println("-------------");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + "  "); // print the board with the matrix index
                }
                System.out.println();
            }
        }

        /**
         * The method checks if all the positions on the board have been played.
         *
         * @return true if all the cells in the board are different than '-', false
         *         otherwise.
         */
        public boolean isFull() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    } // check if all the index are occupied by both players
                }
            }
            return true;
        }

        /**
         * The method checks if there is a winner.
         *
         * @return true if either a column, a row or a diagonal is filled by the same
         *         character and the character is different than '-',
         *         false otherwise.
         */
        public boolean isWin() {
            return checkRows() || checkColumns() || checkDiagonals(); // check if one of the player wins
        }

        /**
         * The method checks if at least one row is occupied by the same player.
         *
         * @return true if any row is filled by the same character and the character is
         *         different than '-',
         *         false otherwise.
         */
        private boolean checkRows() {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                    return true;
                }
            }
            return false;
        }

        /**
         * The method checks if at least one column is occupied by the same player.
         *
         * @return true if any column is filled by the same character and the character
         *         is different than '-',
         *         false otherwise.
         */
        private boolean checkColumns() {
            for (int j = 0; j < 3; j++) {
                if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                    return true;
                }
            }
            return false;
        }

        /**
         * The method checks if at least one diagonal is occupied by the same player.
         *
         * @return true if any diagonal is filled by the same character and the
         *         character is different than '-',
         *         false otherwise.
         */
        private boolean checkDiagonals() {
            return (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                    (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
        }

        /**
         * The method changes the currentPlayer. If the currentPlayer is 'x', it changes
         * to 'o'.
         * If the currentPlayer is 'o', it changes to 'x'.
         *
         */
        public void changePlayer() {
            if (currentPlayer == 'x') { // switch the player to the other
                currentPlayer = 'o';
            } else {
                currentPlayer = 'x';
            }
        }

        public char getCurrentPlayer() {
            return currentPlayer; // get who is current player
        }

        /**
         * The method attempts to set the cell on the position indicated by the row and
         * column given to the currentPlayer value if
         * the cell is unoccupied (equal to '-') in which case returns true. If the
         * position is occupied (not equal to '-') the cell
         * remains unchanged and the method returns false.
         *
         */
        public boolean setRowCol(int row, int col) {
            if (board[row][col] == '-') {
                board[row][col] = currentPlayer; // check if the index is available first, if yes and set it to the
                return true;// character of current player, else return flse.
            }
            return false;
        }
    }
}