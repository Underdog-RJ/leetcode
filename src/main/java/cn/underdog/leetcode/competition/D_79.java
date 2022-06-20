package cn.underdog.leetcode.competition;

import java.util.*;

public class D_79 {
    public static void main(String[] args) {
        D_79 d_79 = new D_79();
//        d_79.digitCount("1210");
//        d_79.maximumImportance(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}});
        BookMyShow bookMyShow = new BookMyShow(2, 5);
        bookMyShow.gather(4, 0);
        bookMyShow.gather(2, 0);
        bookMyShow.scatter(5, 1);
        bookMyShow.scatter(5, 1);
    }

    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i) - '0', map.getOrDefault(num.charAt(i) - '0', 0) + 1);
        }
        for (int i = 0; i < num.length(); i++) {
            Integer orDefault = map.getOrDefault(i, 0);
            if (!orDefault.equals(num.charAt(i) - '0'))
                return false;
        }
        return true;
    }

    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++) {
            int cntL = messages[i].split(" ").length;
            map.put(senders[i], map.getOrDefault(senders[i], 0) + cntL);
        }
        int max = Integer.MIN_VALUE;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                res = entry.getKey();
            } else if (value == max) {
                if (res.compareTo(entry.getKey()) < 0) {
                    res = entry.getKey();
                }
            }
        }
        return res;
    }

    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            map.put(road[0], map.getOrDefault(road[0], 0) + 1);
            map.put(road[1], map.getOrDefault(road[1], 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] tmp = new int[]{entry.getKey(), entry.getValue()};
            priorityQueue.add(tmp);
        }
        int[] im = new int[n];
        int count = n;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            im[poll[0]] = count--;
        }
        long res = 0;
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            res += im[road[0]] + im[road[1]];
        }

        return res;
    }
}
