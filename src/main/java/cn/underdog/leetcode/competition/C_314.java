package cn.underdog.leetcode.competition;

import java.util.Arrays;
import java.util.Stack;

public class C_314 {
    public static void main(String[] args) {
        C_314 c_314 = new C_314();
//        c_314.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}});
//        c_314.hardestWorker(2, new int[][]{{0, 10}, {1, 20}});
//        c_314.numberOfPaths(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3);
        c_314.numberOfPaths(new int[][]{{1, 5, 3, 7, 3, 2, 3, 5}}, 29);
//        c_314.robotWithString("bydizfve");
    }

    public int hardestWorker(int n, int[][] logs) {
        int max = -1;
        int maxIndex = n + 1;
        int pre = 0;
        for (int i = 0; i < logs.length; i++) {
            int cnt = logs[i][1] - pre;
            if (cnt > max) {
                max = cnt;
                maxIndex = logs[i][0];
            } else if (cnt == max) {
                maxIndex = Math.min(maxIndex, logs[i][0]);
            }
            pre = logs[i][1];
        }
        return maxIndex;
    }

    public int[] findArray(int[] pref) {
        int[] clone = pref.clone();
        for (int i = 1; i < pref.length; i++) {
            clone[i] = pref[i - 1] ^ pref[i];
        }
        return clone;
    }

    public String robotWithString(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
            counts[c - 'a']--;
            while (!stack.isEmpty()) {
                // 判断之后的字符是否都大于当前字符
                boolean flag = false;
                int index = stack.peek() - 'a';
                for (int j = 0; j < index; j++) {
                    if (counts[j] > 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    sb.append(stack.pop());
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }


    private int mod = 1000000007;
    private long[][][] memo = null;
    private long res = 0;

//    public int numberOfPaths(int[][] grid, int k) {
//        long cntTotal = 0;
//        int m = grid.length, n = grid[0].length;
//        memo = new long[m][n][k];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                Arrays.fill(memo[i][j], -1);
//            }
//        }
//        dfsNP(grid, k, cntTotal, 0, 0);
//        return (int) (res % mod);
//    }

    private long dfsNP(int[][] grid, int k, long cntTotal, int i, int j) {
        if (i >= grid.length || j >= grid[0].length)
            return 0;
        cntTotal += grid[i][j];
        cntTotal %= k;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (cntTotal % k == 0) {
                res++;
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[i][j][(int) (cntTotal % k)] != -1) {
            res += (int) (memo[i][j][(int) (cntTotal % k)] % mod);
            return memo[i][j][(int) (cntTotal % k)] % mod;
        }

        long tmp = (dfsNP(grid, k, cntTotal, i + 1, j) + dfsNP(grid, k, cntTotal, i, j + 1)) % mod;
        memo[i][j][(int) (cntTotal % k)] = tmp;
        return tmp;
    }

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, mod = 1000000007;
        // 定义dp为mod ==k的方案数目
        long[][][] dp = new long[m + 1][n + 1][k];
        dp[0][1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t < k; t++) {
                    dp[i + 1][j + 1][(t + grid[i][j]) % k] = dp[i + 1][j][t] + dp[i][j + 1][t];
                    dp[i + 1][j + 1][(t + grid[i][j]) % k] %= mod;
                }
            }
        }
        return (int) (dp[m][n][0] % mod);

    }
}
