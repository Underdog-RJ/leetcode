package cn.underdog.leetcode.competition;

import java.math.BigDecimal;
import java.util.*;

public class C_294 {

    public static void main(String[] args) {
        C_294 c_294 = new C_294();
//        c_294.maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2);
//        c_294.minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}});
//        c_294.minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}});
        c_294.minimumLines(new int[][]{{36, 9}, {17, 93}, {34, 4}, {30, 11}, {11, 41}, {53, 36}, {5, 92}, {81, 92}, {28, 36}, {3, 45}, {72, 33}, {64, 1}, {4, 70}, {16, 73}, {99, 20}, {49, 33}, {47, 74}, {83, 91}});
    }

    public int percentageLetter(String s, char letter) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Integer integer = map.getOrDefault(letter, 0);
        if (integer == 0)
            return 0;
        return (int) Math.floor((double) integer / length * 100);
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] == rocks[i])
                res++;
            else {
                int tmp = capacity[i] - rocks[i];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            // 把当前装满需要的
            int cntTotal = key * value;
            if (cntTotal < additionalRocks) {
                res += value;
                additionalRocks -= cntTotal;
            } else {
                res += additionalRocks / key;
                return additionalRocks;
            }
        }
        return res;
    }

    /*public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 1;
        int[] pre = stockPrices[0];
        int[] cnt = stockPrices[1];
        int lastFlag = -1;
        // 上
        if (cnt[0] > pre[0] && cnt[1] > pre[1]) {
            lastFlag = 0;
        } else if (cnt[0] == pre[0] || cnt[1] == pre[1]) {
            lastFlag = 1;
        } else {
            lastFlag = 2;
        }
        for (int i = 2; i < stockPrices.length; i++) {
            pre = stockPrices[i - 1];
            cnt = stockPrices[i];
            int cntFlas = -1;
            if (cnt[0] > pre[0] && cnt[1] > pre[1]) {
                cntFlas = 0;
            } else if (cnt[0] == pre[0] || cnt[1] == pre[1]) {
                cntFlas = 1;
            } else {
                cntFlas = 2;
            }
            if (cntFlas != lastFlag) {
                res++;
                lastFlag = cntFlas;
            }
        }

        return res;
    }*/

    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1)
            return 1;
        Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);
        int res = 1;
        int[] pre = stockPrices[0];
        int[] cnt = stockPrices[1];
        long lastX = cnt[0] - pre[0];
        long lastY = cnt[1] - pre[1];
        for (int i = 2; i < stockPrices.length; i++) {
            pre = stockPrices[i - 1];
            cnt = stockPrices[i];
            long cntX = cnt[0] - pre[0];
            long cntY = cnt[1] - pre[1];
            if (lastY * cntX != lastX * cntY) {
                res++;
                lastX = cntX;
                lastY = cntY;
            }
        }
        return res;
    }
}
