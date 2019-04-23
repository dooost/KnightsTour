
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Basir Doost
 */
public class KTSolver {
    private final int N;
    private final int startRow;
    private final int startColumn;
    
    private int[][] board;
    private int plength;
    
    // List of possible moves on a clockwise direction
    private static final int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    
    public KTSolver(int N, int row, int column) {
        this.N = N;
        startRow = row;
        startColumn = column;
        plength = 0;
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                    board[i][j] = -1;
            }
        }
    }
    
    
    public void solve() {
        if (btSolve(startRow, startColumn)) {
                printBoard();
        } else {
                System.out.println("Impossible...");
        }
    }
    
    // The backtracking algorithm to find the solution
    private boolean btSolve(int row, int column) {
        if (board[row][column] != -1) {
            return false;
        }
        
        board[row][column] = plength;
        plength++;
        
        // If we have visited all the squares on the board
        if (plength == N * N) {
            
            // This loop checks whether we can end up at the starting position
            // from the last square
            for (int i = 0; i < xMove.length; ++i) {
                if (isValid(row + xMove[i], column + yMove[i])
                        && board[row + xMove[i]][column + yMove[i]] == 0)
                    return true;
            }
            
            // If we can't end up back at the starting position, we backtrack
            board[row][column] = -1;
            plength--;
            return false;
        }
        
        // Check if any move from the current square can lead to a solution
        for (int i = 0; i < xMove.length; ++i) {
            if (isValid(row + xMove[i], column + yMove[i]) 
                    && btSolve(row + xMove[i], column + yMove[i])) {
                return true;
            }
        }
        
        
        // Solution was not found, backtracking...
        board[row][column] = -1;
        plength--;
        return false;
    }
    
    private boolean isValid(int row, int col) {
        if (row >= 0 && col >= 0 && row < N && col < N) return true;
        return false;
    }
    
    private void printBoard() {
        DecimalFormat format = new DecimalFormat("00");
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("   " + format.format(board[i][j]));
            }
            System.out.println();
        }
    }
}
