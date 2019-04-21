
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
    private int N;
    private int startRow;
    private int startColumn;
    private int[][] board;
    private int plength;
    
    public KTSolver(int n, int row, int column) {
        N = n;
        startRow = row;
        startColumn = column;
        plength = 0;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    board[i][j] = -1;
            }
        }
    }
    
    public void solve() {
        if (btSolve(startRow, startColumn)) {
                print();
        } else {
                System.out.println("NO PATH FOUND");
        }
    }
    
    private boolean btSolve(int row, int column) {
        if (board[row][column] != -1) {
            return false;
        }
        
        board[row][column] = plength;
        plength++;
        
        if (plength == N * N) {
            return true;
        }
        
        if (isValid(row + 2, column + 1) && btSolve(row + 2, column + 1)) {
                return true;
        }
        
        if (isValid(row + 1, column + 2) && btSolve(row + 1, column + 2)) {
                return true;
        }
        
        if (isValid(row - 1, column + 2) && btSolve(row - 1, column + 2)) {
                return true;
        }
        
        if (isValid(row - 2, column + 1) && btSolve(row - 2, column + 1)) {
                return true;
        }

        if (isValid(row - 2, column - 1) && btSolve(row - 2, column - 1)) {
                return true;
        }
        
        if (isValid(row - 1, column - 2) && btSolve(row - 1, column - 2)) {
                return true;
        }
        
        if (isValid(row + 1, column - 2) && btSolve(row + 1, column - 2)) {
                return true;
        }
        
        if (isValid(row + 2, column - 1) && btSolve(row + 2, column - 1)) {
                return true;
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
    
    public void print() {
        DecimalFormat format = new DecimalFormat("00");
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("   " + format.format(board[i][j]));
            }
            System.out.println();
        }
    }
}
