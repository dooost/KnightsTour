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
        KTSolver kt = new KTSolver(8, 0, 0);
        kt.solve();
    }
    
}
