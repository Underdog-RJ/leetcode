package cn.underdog.leetcode.competition;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class C_310 {
    public static void main(String[] args) {
        C_310 c_310 = new C_310();
//        c_310.mostFrequentEven(new int[]{1, 2, 2, 2, 3});
        int i = c_310.minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}});
        System.out.println(i);
    }

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if ((num & 1) == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        if (pq.isEmpty()) return -1;
        else return pq.poll()[0];
    }

    public int partitionString(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res++;
                set.clear();
                set.add(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        return res + 1;
    }


    // 维护数组右端点的最小值
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek() < intervals[i][0]) {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

    public int minGroups1(int[][] intervals) {
        int[] diff = new int[(int) 1e6 + 10];
        for (int[] interval : intervals) {
            diff[interval[0]]++;
            diff[interval[1] + 1]--;
        }
        int max = 0;
        for (int i = 0; i < diff.length; i++) {
            diff[i] += diff[i - 1];
            max = Math.max(max, diff[i]);
        }
        return max;
    }

}
