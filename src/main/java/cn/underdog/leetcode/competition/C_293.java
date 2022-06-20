package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.segmentTree.Code01_SegmentTree;

import java.util.*;

public class C_293 {

    public static void main(String[] args) {
        C_293 c_293 = new C_293();
//        c_293.removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"});
//        c_293.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14});
        CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
//        countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
//        countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
//        countIntervals.count();    // 返回 6
//        // 整数 2 和 3 出现在区间 [2, 3] 中
//        // 整数 7、8、9、10 出现在区间 [7, 10] 中
//        countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
//        countIntervals.count();    // 返回 8
//        // 整数 2 和 3 出现在区间 [2, 3] 中
//        // 整数 5 和 6 出现在区间 [5, 8] 中
//        // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
//        // 整数 9 和 10 出现在区间 [7, 10] 中
        countIntervals.count();
        countIntervals.add(39, 44);
        countIntervals.add(13, 49);
        countIntervals.count();
        countIntervals.count();
        countIntervals.add(47, 50);


    }


    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        Map<Character, Integer> cnt = new HashMap<>();
        String str = words[0];
        for (int i = 0; i < str.length(); i++) {
            cnt.put(str.charAt(i), cnt.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 1; i < words.length; i++) {
            String cntStr = words[i];
            Map<Character, Integer> current = new HashMap<>();
            for (int j = 0; j < cntStr.length(); j++) {
                current.put(cntStr.charAt(j), current.getOrDefault(cntStr.charAt(j), 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : cnt.entrySet()) {
                if (current.containsKey(entry.getKey())) {
                    Integer value1 = entry.getValue();
                    Integer value2 = current.get(entry.getKey());
                    if (value1 != value2) {
                        res.add(words[i]);
                        cnt = current;
                        break;
                    }
                } else {
                    res.add(words[i]);
                    cnt = current;
                    break;
                }
            }

            for (Map.Entry<Character, Integer> entry : current.entrySet()) {
                if (cnt.containsKey(entry.getKey())) {
                    Integer value1 = entry.getValue();
                    Integer value2 = cnt.get(entry.getKey());
                    if (value1 != value2) {
                        res.add(words[i]);
                        cnt = current;
                        break;
                    }
                } else {
                    res.add(words[i]);
                    cnt = current;
                    break;
                }
            }

        }

        return res;
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : special) {
            set.add(i);
        }
        max = Math.max(max, set.first() - bottom);
        max = Math.max(max, top - set.last());
        int pre = bottom;
        for (Integer integer : set) {
            max = Math.max(max, integer - pre - 1);
            pre = integer;
        }

        return max;
    }

    /* public int largestCombination(int[] candidates) {
         int length = candidates.length;
         int[] dp = new int[length];
         dp[0] = 1;
         for (int i = 1; i < length; i++) {
             for (int j = 0; j < i; j++) {

                 if ((candidates[i] & candidates[j]) > 0) {
                     dp[i] = Math.max(dp[i], dp[j] + 1);
                 } else {
                     dp[i] = Math.max(dp[i], 1);
                 }
             }
         }
         return Arrays.stream(dp).max().getAsInt();

     }*/
    public int largestCombination(int[] candidates) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 30; i++) {
            int count = 0;
            for (int candidate : candidates) {
                count += (candidate & 1 << i) == 0 ? 0 : 1;
                max = Math.max(max, count);
            }
        }
        return max;
    }

}
