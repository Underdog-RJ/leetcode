package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/4/3022:29
 */
public class D_77 {
    public static void main(String[] args) {
        D_77 d_77 = new D_77();
//        d_77.minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3});
//        System.out.println(d_77.countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}}));
        System.out.println(d_77.countUnguarded(2, 7, new int[][]{{1, 5}, {1, 1}, {1, 6}, {0, 2}}, new int[][]{{0, 6}, {0, 3}, {0, 5}}));
    }

    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (s.startsWith(word))
                res++;
        }
        return res;
    }

    public int minimumAverageDifference(int[] nums) {
        int length = nums.length;
        long[] pre = new long[length];
        pre[0] = nums[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        int res = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < pre.length; i++) {
            long num1 = pre[i] / (i + 1);
            long num2 = 0;
            if (length - i - 1 != 0) {
                num2 = (pre[length - 1] - pre[i]) / (length - i - 1);
            }
            long num3 = Math.abs(num1 - num2);
            if (num3 < min) {
                min = num3;
                res = i;
            }
        }

        return res;
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int total = m * n;
        int length1 = m - 1;
        int length2 = n - 1;
        int num1 = total - guards.length - walls.length;
        Set<String> set = new HashSet<>();
        for (int[] wall : walls) {
            set.add(wall[0] + "-" + wall[1]);
        }
        Set<String> set1 = new HashSet<>();
        for (int[] guard : guards) {
            set1.add(guard[0] + "-" + guard[1]);
        }
        Set<String> tmp = new HashSet<>();
        for (int[] guard : guards) {
            int tmp1 = guard[0];
            int tmp2 = guard[1];

            int tmpS = tmp1;
            // 上
            while (tmpS > 0) {
                tmpS--;
                String key = tmpS + "-" + tmp2;
                if (!set.contains(key) && !set1.contains(key)) {
                    tmp.add(key);
                } else {
                    break;
                }
            }
            int tmpX = tmp1;
            // 下
            while (tmpX < length1) {
                tmpX++;
                String key = tmpX + "-" + tmp2;
                if (!set.contains(key) && !set1.contains(key)) {
                    tmp.add(key);
                } else {
                    break;
                }
            }
            // 左
            int tmpZ = tmp2;
            while (tmpZ > 0) {
                tmpZ--;
                String key = tmp1 + "-" + tmpZ;
                if (!set.contains(key) && !set1.contains(key)) {
                    tmp.add(key);
                } else {
                    break;
                }
            }
            // 右
            int tmpY = tmp2;
            while (tmpY < length2) {
                tmpY++;
                String key = tmp1 + "-" + tmpY;
                if (!set.contains(key) && !set1.contains(key)) {
                    tmp.add(key);
                } else {
                    break;
                }
            }
        }

        return num1 - tmp.size();
    }
}
