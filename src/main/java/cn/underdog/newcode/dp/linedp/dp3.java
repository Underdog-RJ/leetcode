package cn.underdog.newcode.dp.linedp;

import java.util.Scanner;

public class dp3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 物品
        for (int i = 1; i <= n; i++) {
            // 背包
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }

        System.out.println(dp[n]);
    }



}
