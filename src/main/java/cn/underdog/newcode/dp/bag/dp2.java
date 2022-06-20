package cn.underdog.newcode.dp.bag;

import java.util.Scanner;

public class dp2 {
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
            for (int j = weights[i]; j <= cap; j++) {
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
