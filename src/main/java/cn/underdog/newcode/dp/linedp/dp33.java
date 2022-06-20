package cn.underdog.newcode.dp.linedp;

import java.util.Scanner;

public class dp33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        int[][] dp = new int[n][2 * k + 1];
        for (int i = 0; i < 2 * k + 1; i++) {
            dp[0][i] = (i & 1) == 1 ? -ints[0] : 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if ((j & 1) == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - ints[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + ints[i]);
                }
            }
        }
        System.out.println(dp[n - 1][2 * k]);
    }


}
