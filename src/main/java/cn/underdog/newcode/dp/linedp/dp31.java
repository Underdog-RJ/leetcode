package cn.underdog.newcode.dp.linedp;

import java.util.Scanner;

public class dp31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        int[][] dp = new int[n][2];
        dp[0][0] = -ints[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - ints[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + ints[i]);
        }
        System.out.println(dp[n - 1][1]);
    }
}
