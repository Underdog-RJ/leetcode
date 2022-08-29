package cn.underdog.leetcode.competition;

import java.util.*;

public class D_85 {

    public static void main(String[] args) {
        D_85 d_85 = new D_85();
//        d_85.secondsToRemoveOccurrences("0110101");
//        d_85.shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}});
        d_85.minimumRecolors("WBBWWBBWBW", 7);
    }

    public int secondsToRemoveOccurrences(String s) {
        int res = 0;
        while (s.contains("01")) {
            s = s.replace("01", "10");
            res++;
        }
        return res;
    }

    public String shiftingLetters(String s, int[][] shifts) {
        char[] diff = s.toCharArray();
        long[] tmp = new long[s.length()];
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];
            if (dir == 1) {
                tmp[start]++;
                if (end + 1 < s.length()) {
                    tmp[end + 1]--;
                }
            } else {
                tmp[start]--;
                if (end + 1 < s.length()) {
                    tmp[end + 1]++;
                }
            }
        }
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i - 1];
        }

        for (int i = 0; i < diff.length; i++) {
            tmp[i] += diff[i];
        }
        for (int i = 0; i < diff.length; i++) {
            long index = tmp[i] - 'a';
            if (index < 0) {
                index = (index % 26 + 26) % 26;
            } else if (index >= 26) {
                index %= 26;
            }
            diff[i] = (char) (index + 'a');
        }
        return new String(diff);
    }

    public int minimumRecolors(String blocks, int k) {
        int res = Integer.MAX_VALUE;
        int num1 = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                num1++;
            }
        }
        for (int i = k; i < blocks.length(); i++) {
            res = Math.min(res, num1);
            if (blocks.charAt(i) == 'W') {
                num1++;
            }
            if (blocks.charAt(i - k) == 'W') {
                num1--;
            }
        }
        res = Math.min(res, num1);
        return res;
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] sum = new long[nums.length + 1], result = new long[removeQueries.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        TreeMap<Long, Integer> map = new TreeMap<>(Map.of(0L, nums.length)), count = new TreeMap<>(Map.of(sum[nums.length], 1));
        for (int i = 0; i < removeQueries.length; i++) {
            Map.Entry<Long, Integer> entry = map.floorEntry((long) removeQueries[i]);
            count.put(sum[entry.getValue()] - sum[entry.getKey().intValue()], count.get(sum[entry.getValue()] - sum[entry.getKey().intValue()]) - 1);
            if (count.get(sum[entry.getValue()] - sum[entry.getKey().intValue()]) == 0) {
                count.remove(sum[entry.getValue()] - sum[entry.getKey().intValue()]);
            }
            map.putAll(Map.of(entry.getKey(), removeQueries[i], removeQueries[i] + 1L, entry.getValue()));
            count.put(sum[removeQueries[i]] - sum[entry.getKey().intValue()], count.getOrDefault(sum[removeQueries[i]] - sum[entry.getKey().intValue()], 0) + 1);
            count.put(sum[entry.getValue()] - sum[removeQueries[i] + 1], count.getOrDefault(sum[entry.getValue()] - sum[removeQueries[i] + 1], 0) + 1);
            result[i] = count.lastKey();
        }
        return result;
    }
}



