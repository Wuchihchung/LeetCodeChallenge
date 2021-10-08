package com.leetcode.bryan.easy;


public class FindWinneronaTicTacToeGame {
    public String tictactoe(int[][] moves) {
        if (checkPlay(moves, 0)) return "A";
        if (checkPlay(moves, 1)) return "B";

        if (moves.length < 9) return "Pending";
        else return "Draw";
    }

    private boolean checkPlay(int[][] moves, int player) {
        int[] row = new int[3];
        int[] col = new int[3];
        int[] diag = new int[2];

        for (int m = player; m < moves.length; m += 2) {
            int[] move = moves[m];

            row[move[0]] += 1;
            col[move[1]] += 1;

            if (move[0] == move[1]) diag[0] += 1;
            if (move[0] + move[1] == 2) diag[1] += 1;
        }

        for (int g = 0; g < 3; g++) {
            if (row[g] == 3) return true;
            if (col[g] == 3) return true;
        }

        for (int g = 0; g < 2; g++) {
            if (diag[g] == 3) {
                return true;
            }
        }

        return false;
    }
}