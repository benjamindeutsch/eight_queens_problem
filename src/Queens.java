public class Queens {
    private int counter;

    public static void main(String[] args) {
        Queens instance = new Queens();
        instance.printSolutions(8);
    }

    public void printSolutions(int n) {
        counter = 0;
        boolean[][] board = new boolean[n][n];

        placeQueen(board, 0);
        System.out.println();
        System.out.println("Total number of solutions: " + counter);
    }

    private void printBoard(boolean[][] board) {
        System.out.println();
        for (boolean[] row : board) {
            for (boolean field : row) {
                System.out.print(" | " + (field ? '1' : '0'));
            }
            System.out.println(" |");
        }
    }

    private void placeQueen(boolean[][] board, int row) {
        for (int i = 0; i < board.length; i++) {
            if (this.couldPlaceQueen(board, row, i)) {
                board[row][i] = true;
                if (row == board.length - 1) {
                    this.printBoard(board);
                    counter++;
                } else {
                    placeQueen(board, row + 1);
                }
                board[row][i] = false;
            }
        }
    }

    private boolean couldPlaceQueen(boolean[][] board, int x, int y) {
        //check row and column
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] || board[i][y]) {
                return false;
            }
        }
        //check diagonals
        for (int i = 0; i < board.length; i++) {
            int diagonalX = x - (y - i);
            if (diagonalX >= 0 && diagonalX < board.length && board[diagonalX][i]) {
                return false;
            }
            diagonalX = x + (y - i);
            if (diagonalX >= 0 && diagonalX < board.length && board[diagonalX][i]) {
                return false;
            }
        }
        return true;
    }
}