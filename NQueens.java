//Practical 4 for Nqueens
class NQueens {
    int count = 0;

    void solveNQueens() {
        int[][] board = new int[8][8];
        solve(board, 0);
    }

    void solve(int[][] board, int col) {
        if (col == 8) {
            // All queens are successfully placed 
            count++;
            print(board);
            return;
        }

        for (int row = 0; row < 8; row++) {
            if (isValid(board, row, col)) {
                board[row][col] = 1; // Place the queen at position (row, col)
                solve(board, col + 1); // Recursive call to place queens in the next column
                board[row][col] = 0; // Backtrack and remove the queen from position (row, col)
            }
        }
    }

    boolean isValid(int[][] board, int row, int col) {
        // Check the left side of the current column
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == 1)
                return false;
        }

        int i, j;
        // Check the upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check the lower left diagonal
        for (i = row, j = col; i < 8 && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true; // The position is valid
    }

    void print(int[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens();
        System.out.println("Total solutions: " + nQueens.count);
    }
}
