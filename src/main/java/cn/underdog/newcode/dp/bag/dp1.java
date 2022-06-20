package cn.underdog.newcode.dp.bag;

import java.util.Scanner;

public class dp1 {

    // 二维dp
 /*   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int[] prices = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            prices[i] = sc.nextInt();
        }
        // 在0-i号物品中容量为j的背包中，的最大价值
        int[][] dp = new int[n][cap + 1];
        int[][] dp1 = new int[n][cap + 1];
        for (int i = 0; i <= cap; i++) {
            if (i >= weights[0]) {
                dp[0][i] = prices[0];
            }
            if (i == weights[0]) {
                dp1[0][i] = prices[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + prices[i]);
                }
                if (j == weights[i]) {
                    dp1[i][j] = Math.max(prices[i], dp1[i - 1][j]);
                } else if (j > weights[i]) {
                    if (dp1[i - 1][j - weights[i]] != 0) {
                        dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i - 1][j - weights[i]] + prices[i]);
                    } else {
                        dp1[i][j] = dp1[i - 1][j];
                    }
                } else if (j < weights[i]) {
                    dp1[i][j] = dp1[i - 1][j];
                }
            }
        }
        System.out.println(dp[n - 1][cap]);
        System.out.println(dp1[n - 1][cap]);
    }*/


    // 一维dp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cap = sc.nextInt();
        int[] prices = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            prices[i] = sc.nextInt();
        }
        // 在0-i号物品中容量为j的背包中，的最大价值
        int[] dp = new int[cap + 1];
        int[] dp1 = new int[cap + 1];
        for (int i = 0; i < n; i++) {
            for (int j = cap; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + prices[i]);
                if (j == weights[i]) {
                    dp1[j] = Math.max(prices[i], dp1[j]);
                } else if (dp1[j - weights[i]] != 0) {
                    dp1[j] = Math.max(dp1[j], dp1[j - weights[i]] + prices[i]);
                }
            }
        }
        System.out.println(dp[cap]);
        System.out.println(dp1[cap]);
    }

}
