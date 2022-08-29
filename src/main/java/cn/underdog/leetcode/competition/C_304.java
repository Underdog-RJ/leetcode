package cn.underdog.leetcode.competition;

import java.util.*;

public class C_304 {

    public static void main(String[] args) {
        C_304 c_304 = new C_304();
//        c_304.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1);
        c_304.closestMeetingNode(new int[]{4, 3, 0, 5, 3, 1}, 4, 0);
    }

    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (num != 0) priorityQueue.add(num);
        }
        int res = 0;
        while (!priorityQueue.isEmpty()) {
            Integer poll = priorityQueue.poll();
            List<Integer> list = new ArrayList<>();
            for (Integer integer : priorityQueue) {
                if (integer != poll) {
                    list.add(integer - poll);
                }
            }
            priorityQueue.clear();
            priorityQueue = new PriorityQueue<>(list);
            res++;
        }
        return res;
    }

    public int maximumGroups(int[] grades) {
        long n = grades.length;
        long target = n * 2;
        long left = 1, right = n;
        while (left <= right) {
            long mid = left + right >> 1;
            long tmp = (mid + 1) * mid;
            if (tmp == target) return (int) mid;
            else if (tmp > target) right = mid - 1;
            else left = mid + 1;
        }
        return (int) left - 1;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int n = edges.length;
        boolean[] booleans = new boolean[n];
        dfsCMN(edges, node1, map1, 0, booleans);
        Map<Integer, Integer> map2 = new HashMap<>();
        booleans = new boolean[n];
        dfsCMN(edges, node2, map2, 0, booleans);
        Set<Integer> set1 = map1.keySet();
        Set<Integer> set1_1 = new HashSet<>(set1);
        Set<Integer> set2 = map2.keySet();
        set1_1.retainAll(set2);
        int minCount = Integer.MAX_VALUE;
        int minNode = Integer.MAX_VALUE;
        for (Integer integer : set1_1) {
            Integer integer1 = map1.get(integer);
            Integer integer2 = map2.get(integer);
            int max = Math.max(integer1, integer2);
            if (minCount > max) {
                minCount = max;
                minNode = integer;
            } else if (minCount == max) {
                minNode = Math.min(minNode, integer);
            }
        }
        return minNode == Integer.MAX_VALUE ? -1 : minNode;
    }

    private void dfsCMN(int[] edges, int node1, Map<Integer, Integer> map, int cnt, boolean[] booleans) {
        if (node1 != -1) {
            if (booleans[node1])
                return;
            booleans[node1] = true;
            map.put(node1, cnt);
            int edge = edges[node1];
            dfsCMN(edges, edge, map, cnt + 1, booleans);
        }
    }


}
