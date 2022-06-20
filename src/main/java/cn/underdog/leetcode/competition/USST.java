package cn.underdog.leetcode.competition;

import java.io.*;
import java.util.*;

/**
 * @author underdog_rj
 * @date2022/4/228:31
 */
public class USST {

    public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
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
