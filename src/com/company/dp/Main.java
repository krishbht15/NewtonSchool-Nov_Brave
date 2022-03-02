package com.company.dp;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibDp(n, dp));
    }

    public static int fibDp(int n, int[] dp) {
        if (n == 0 || n == 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibDp(n - 1, dp) + fibDp(n - 2, dp);
    }

    public static int knapsack01(int[] wt, int[] val, int W, int i) {
        if (i == wt.length) return 0;
        int sel = W >= wt[i] ?
                knapsack01(wt, val, W - wt[i], i + 1) + val[i] : 0;
        int rej = knapsack01(wt, val, W, i + 1);
        return Math.max(sel, rej);
    }

    public static int knapsack01DP(int[] wt, int[] val, int W, int i, int[][] dp) {
        if (i == wt.length) return 0;
        if (dp[i][W] != 0) return dp[i][W];
        int sel = W >= wt[i] ?
                knapsack01DP(wt, val, W - wt[i], i + 1, dp) + val[i] : 0;
        int rej = knapsack01DP(wt, val, W, i + 1, dp);
        return dp[i][W] = Math.max(sel, rej);
    }
//https://leetcode.com/problems/longest-common-subsequence/
    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i + 1][j + 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
