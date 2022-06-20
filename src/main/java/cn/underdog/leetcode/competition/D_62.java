package cn.underdog.leetcode.competition;

import java.util.HashMap;

public class D_62 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;
        int total = m * n;
        if (length != total)
            return new int[0][];
        int targetArray[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                targetArray[i][j] = original[i * n + j];
            }
        }
        return targetArray;
    }

    //TODO 更新为hash表
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (target.equals(nums[i] + nums[j]))
                    count++;
            }
        }

        return count;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    public int maxConsecutiveAnswers(String answerKey, int k, Character ch) {

        int sum = 0;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while (right < answerKey.length()) {
            // 每次把left转移到最合适的指
            if (ch != answerKey.charAt(right)) {
                sum++;
                while (sum > k) {
                    if (ch != answerKey.charAt(left++))
                        sum--;
                }
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
