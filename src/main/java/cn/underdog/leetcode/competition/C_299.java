package cn.underdog.leetcode.competition;

import java.util.*;

public class C_299 {

    public static void main(String[] args) {
        C_299 c_299 = new C_299();
//        System.out.println(c_299.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
//        System.out.println(c_299.checkXMatrix(new int[][]{{5, 0, 20}, {0, 5, 0}, {6, 0, 2}}));
//        c_299.countHousePlacements(1000);
        c_299.maximumsSplicedArray(new int[]{28, 34, 38, 14, 30, 31, 23, 7, 28, 3}, new int[]{42, 35, 7, 6, 24, 30, 14, 21, 20, 34});

    }


    public boolean checkXMatrix(int[][] grid) {
        int length = grid.length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == j) {
                    if (j == length)
                        length--;
                    if (grid[i][j] == 0)
                        return false;
                } else {
                    if (j == length) {
                        length--;
                        if (grid[i][j] == 0)
                            return false;
                    } else {
                        if (grid[i][j] != 0)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public int countHousePlacements(int n) {
        if (n == 1)
            return 4;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007);
        }
        long sum = dp[n];
        return (int) ((sum * sum) % 1000000007);
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int[] dp = new int[nums1.length];
        dp[0] = nums2[0] - nums1[0];
        for (int i = 1; i < nums1.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums2[i] - nums1[i];
        }
        int asInt = Arrays.stream(dp).max().getAsInt();
        int tmp1 = sum1 + Math.max(asInt, 0);
        int[] dp1 = new int[nums1.length];
        dp1[0] = nums1[0] - nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            dp1[i] = Math.max(0, dp1[i - 1]) + nums1[i] - nums2[i];
        }
        int asInt1 = Arrays.stream(dp1).max().getAsInt();
        int tmp2 = sum2 + Math.max(asInt1, 0);
        return Math.max(tmp1, tmp2);
    }

}
