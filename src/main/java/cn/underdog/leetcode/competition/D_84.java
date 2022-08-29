package cn.underdog.leetcode.competition;

import java.util.*;

public class D_84 {

    public static void main(String[] args) {
        D_84 d_84 = new D_84();
        d_84.taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3);
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n1 = items1.length, n2 = items2.length;
        for (int i = 0; i < n1; i++) {
            int[] ints = items1[i];
            map.put(ints[0], ints[1]);
        }
        for (int i = 0; i < n2; i++) {
            int[] ints = items2[i];
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(List.of(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long sum = n * (n - 1) / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = i - nums[i];
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        long total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long value = (long) entry.getValue();
            if (value >= 2) {
                long tmp = value * (value - 1) / 2;
                total += tmp;
            }
        }
        return sum - total;
    }

    public long taskSchedulerII(int[] tasks, int space) {
        long time = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int cntK = tasks[i];
            if (map.containsKey(cntK)) {
                Long before = map.get(cntK);
                long tmp = before + space;
                time = Math.max(time + 1, tmp + 1);
            } else {
                time++;
            }
            map.put(cntK, time);
        }
        return time;
    }



}
