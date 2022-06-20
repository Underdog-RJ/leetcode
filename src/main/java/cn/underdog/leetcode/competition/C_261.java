package cn.underdog.leetcode.competition;

import java.util.*;
public class C_261 {

    public int minimumMoves(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 1; ) {
            if (s.charAt(i) == 'O') {
                i++;
            } else {
                i = i + 3;
                count++;
            }
        }
        return count;
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rLength = rolls.length;
        int total = rLength + n;
        int totalSum = total * mean;
        int currentSum = Arrays.stream(rolls).sum();
        // 如果大的不符合则直接返回
        if (totalSum - currentSum > n * 6)
            return new int[0];
        // 如果小的不符合直接返回
        if (totalSum < currentSum || n > totalSum - currentSum)
            return new int[0];
        int needSum = totalSum - currentSum;
        //能整除
        if (needSum % n == 0) {
            int[] ints = new int[n];
            Arrays.fill(ints, needSum / n);
            return ints;
        }
        int[] res = new int[n];
        int di = needSum / n;
        int tar = di * n;
        int totalI = needSum - tar;
        Arrays.fill(res, di);
        for (int i = 0; i < totalI; i++) {
            ++res[i];
        }
        return res;
    }

}
