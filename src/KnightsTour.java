
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Basir Doost
 */
public class KnightsTour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        int row;
        int col;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter board length:");
        n = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.println("Enter starting row [0,n-1]:");
        row = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.println("Enter starting column [0,n-1]:");
        col = keyboard.nextInt();
        keyboard.nextLine();
        
        KTSolver kt = new KTSolver(n, row, col);
        kt.solve();
    }
    
}
