package cn.underdog.leetcode.competition;

import java.util.*;

public class C_297 {
    public static void main(String[] args) {
        C_297 c_297 = new C_297();
        c_297.minPathCost1(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}});
//        c_297.distributeCookies(new int[]{8, 15, 10, 20, 8}, 2);
    }

    public double calculateTax(int[][] brackets, int income) {
        int pre = 0;
        double res = 0.0;
        for (int i = 0; i < brackets.length && income > 0; i++) {
            int[] bracket = brackets[i];
            int tmp = bracket[0] - pre;
            tmp = Math.min(tmp, income);
            res += (double) (tmp * ((double) bracket[1] / 100));
            pre = bracket[0];
            income -= tmp;
        }
        return res;
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid[0].length;
        int[] dp = new int[n];
        int[] tmp = grid[0];
        System.arraycopy(tmp, 0, dp, 0, n);
        for (int i = 1; i < grid.length; i++) {
            int[] pre = grid[i - 1];
            int[] cnt = grid[i];
            int[] preDp = new int[n];
            System.arraycopy(dp, 0, preDp, 0, n);
            for (int j = 0; j < cnt.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int u = 0; u < pre.length; u++) {
                    min = Math.min(min, moveCost[pre[u]][j] + preDp[u]);
                }
                dp[j] = min + cnt[j];
            }

        }
        return Arrays.stream(dp).min().getAsInt();
    }

    public int minPathCost1(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        // 定义dp为到达i行j列的最小值
        int[][] dp = new int[m][n];
        dp[0] = grid[0];
        // 递推公式为dp[i][j] = dp[i-1][0-u] + moveCost[0-u]的最小值
        for (int i = 1; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int u = 0; u < ints.length; u++) {
                    min = Math.min(min, dp[i - 1][u] + moveCost[grid[i - 1][u]][j]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public int distributeCookies1(int[] cookies, int k) {
        return backtrackingDistribution1(cookies, new int[k], 0, 0);
    }

    private int backtrackingDistribution1(int[] cookies, int[] ints, int startIndex, int max) {
        if (startIndex == cookies.length)
            return max;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            ints[i] += cookies[startIndex];
            int childMin = backtrackingDistribution1(cookies, ints, startIndex + 1, Math.max(max, ints[i]));
            min = Math.min(min, childMin);
            ints[i] -= cookies[startIndex];

        }
        return min;
    }

    public int distributeCookies(int[] cookies, int k) {
        return backtrackingDistribution(cookies, new int[k], 0, 0);
    }

    private int backtrackingDistribution(int[] cookies, int[] ints, int startIndex, int max) {
        if (startIndex == cookies.length)
            return max;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length; i++) {
            ints[i] += cookies[startIndex];
            int child = backtrackingDistribution(cookies, ints, startIndex + 1, Math.max(max, ints[i]));
            min = Math.min(min, child);
            ints[i] -= cookies[startIndex];
        }
        return min;
    }


}
