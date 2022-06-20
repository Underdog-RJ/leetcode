package cn.underdog.leetcode.competition;

import java.util.*;

public class D_65 {
    public static void main(String[] args) {
        D_65 d_65 = new D_65();
        d_65.maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{1, 2, 3, 4, 5, 6});
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            char1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            char2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(char1[i] - char2[i]) > 3)
                return false;
        }
        return true;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, ((o1, o2) -> o1[0] - o2[0]));
        int length = items.length;
        int[] preMax = new int[length];
        preMax[0] = items[0][1];
        for (int i = 1; i < length; i++) {
            preMax[i] = Math.max(preMax[i - 1], items[i][1]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = items.length - 1;
            int target = queries[i];
            while (left <= right) {
                int mid = (left + right) / 2;
                if (items[mid][0] <= target) {
                    left = mid + 1;
                } else if (items[mid][0] > target) {
                    right = mid - 1;
                }
            }
            if (right < 0)
                res[i] = 0;
            else {
                res[i] = preMax[right];
            }
        }
        return res;

    }

    public int[] maximumBeauty1(int[][] items, int[] queries) {
        Arrays.sort(items, (o, p) -> o[0] - p[0]);
        int[] res = new int[queries.length];
        TreeMap<Integer, Integer> map = new TreeMap<>(Map.of(0, 0));
        int max = 0;
        for (int[] item : items) {
            max = Math.max(item[1], max);
            map.put(item[0], max);
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.floorEntry(queries[i]).getValue();
        }
        return res;
    }

}
