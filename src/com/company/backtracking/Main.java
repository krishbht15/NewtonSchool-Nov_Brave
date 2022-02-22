package com.company.backtracking;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println(climbingStairs(5));
        char[][] chess = new char[4][4];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = '.';
            }
//            Arrays.fill(chess[i], '.');
        }
        nQueens(chess, 0, 0, 0);
    }

    //    https://leetcode.com/problems/climbing-stairs/
    public static int climbingStairs(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int oneStep = climbingStairs(n - 1);
        int twoSteps = climbingStairs(n - 2);
        return oneStep + twoSteps;
    }

    public static boolean canBePlaced(char[][] chess, int r, int c) {
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}};
        for (int i = 0; i < dir.length; i++) {
            int nr = r;
            int nc = c;
            int dirR = dir[i][0];
            int dirC = dir[i][1];
            while (nr >= 0 && nc >= 0 && nc < chess.length) {
                if (chess[nr][nc] == 'Q') return false;
                nr += dirR;
                nc += dirC;
            }
        }
        return true;
    }

    public static void nQueens(char[][] chess, int r, int c, int queens) {
        if (chess.length == queens) {
            System.out.println(Arrays.deepToString(chess));
            return;
        }
        if (c == chess.length) return;
        if (canBePlaced(chess, r, c)) {
            chess[r][c] = 'Q';
            nQueens(chess, r + 1, 0, queens + 1);
            chess[r][c] = '.';
        }
        nQueens(chess, r, c + 1, queens);
    }
}

