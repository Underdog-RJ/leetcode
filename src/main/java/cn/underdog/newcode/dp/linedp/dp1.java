package cn.underdog.newcode.dp.linedp;

import java.util.Scanner;

public class dp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] dp = new int[length + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[length]);
    }

}
