package cn.underdog.leetcode.competition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author underdog_rj
 * @date2022/5/320:03
 */
public class C_289 {

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            int totalk = 0;
            String currentStr = "";
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                if (totalk < k) {
                    total += Integer.parseInt(s.charAt(i) + "");
                    totalk++;
                } else if (totalk == k) {
                    currentStr += total;
                    total = Integer.parseInt(s.charAt(i) + "");
                    totalk = 1;
                }
            }

            currentStr += total;
            s = currentStr;
        }
        return s;
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1)
                return -1;

            if (value == 2) {
                res++;
                continue;
            }
            // 贪心
            int g = value % 3;
            if (g == 0) {
                res += value / 3;
            } else if (g == 1) {
                res += (value / 3 - 1) + 2;
            } else {
                res += value / 3 + 1;
            }
        }
        return res;
    }

    // TODO 不会做
    public int maxTrailingZeros(int[][] grid) {
        return 0;
    }
}
