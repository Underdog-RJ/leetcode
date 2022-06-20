package cn.underdog.leetcode.competition;

import java.util.HashSet;
import java.util.Set;

/**
 * @author underdog_rj
 * @date2022/5/321:03
 */
public class C_275 {

    public boolean checkValid(int[][] matrix) {
        int length = matrix.length;
        // 检查行
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int k = 0; k < matrix.length; k++) {
                set1.add(matrix[i][k]);
                set2.add(matrix[k][i]);
            }
            if (set1.size() != length || set2.size() != length) return false;
        }
        return true;
    }

    public int minSwaps(int[] nums) {
        // 统计1的个数
        int total1 = 0;
        for (int num : nums) {
            if (num == 1) total1++;
        }
        // 统计i=0时，区间内0的个数，
        int total0 = 0;
        for (int i = 0; i < total1; i++) {
            if (nums[i] == 0) total0++;
        }
        int min = total0;
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            // 计算当前区间内0的个数
            if (nums[(i - 1) % length] == 0)
                total0--;
            if (nums[(i + total1 - 1) % length] == 0)
                total0++;
            min = Math.min(total0, min);
        }
        return min;
    }

    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> startSet = new HashSet<>();
        for (String startWord : startWords) {
            StringBuilder sb = new StringBuilder("000000000000000000000000000");
            for (int i = 0; i < startWord.length(); i++) {
                sb.setCharAt(startWord.charAt(i) - 'a', '1');
            }
            startSet.add(sb.toString());
        }
        int res = 0;
        for (String targetWord : targetWords) {
            for (int i = 0; i < targetWord.length(); i++) {
                StringBuilder sb = new StringBuilder(targetWord);
                sb.deleteCharAt(i);
                String string = sb.toString();
                StringBuilder sb1 = new StringBuilder("000000000000000000000000000");
                for (int j = 0; j < string.length(); j++) {
                    sb1.setCharAt(string.charAt(j) - 'a', '1');
                }
                if (startSet.contains(sb1.toString())) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
