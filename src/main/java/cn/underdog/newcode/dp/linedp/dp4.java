package cn.underdog.newcode.dp.linedp;

import java.util.Scanner;

public class dp4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + ints[i - 1], dp[i - 2] + ints[i-2]);
        }
        System.out.println(dp[n]);
    }
}
