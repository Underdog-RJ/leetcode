package cn.underdog.leetcode.competition;

import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author underdog_rj
 * @date2022/5/320:35
 */
public class D_73 {

    public static void main(String[] args) {
        D_73 d_73 = new D_73();
//        d_73.getAncestors_1(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}});
        d_73.getAncestors_1(6, new int[][]{{0, 3}, {5, 0}, {2, 3}, {4, 3}, {5, 3}, {1, 3}, {2, 5}, {0, 1}, {4, 5}, {4, 2}, {4, 0}, {2, 1}, {5, 1}});
    }

    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                res = entry.getKey();
            }
        }
        return res;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return Integer.compare(o1[1], o2[1]);

                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            // 1.进行映射
            int num = nums[i];
            String strNum = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < strNum.length(); j++) {
                int index = Integer.parseInt(strNum.charAt(j) + "");
                sb.append(mapping[index]);
            }
            int mappingNum = Integer.parseInt(sb.toString());
            priorityQueue.add(new int[]{mappingNum, i});
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int[] poll = priorityQueue.poll();
            res[i] = nums[poll[1]];
        }
        return res;
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        TreeSet<Integer>[] sets = new TreeSet[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[1]].add(edge[0]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = dfsGetAncestors(i, lists, sets);
            res.add(list);
        }
        return res;
    }

    public List<Integer> dfsGetAncestors(int index, List<Integer>[] lists, TreeSet<Integer>[] sets) {
        TreeSet<Integer> integerTreeSet = sets[index];
        if (integerTreeSet == null) {
            List<Integer> list = lists[index];
            integerTreeSet = new TreeSet<>(list);
            for (Integer integer : list) {
                List<Integer> tmp = dfsGetAncestors(integer, lists, sets);
                integerTreeSet.addAll(new TreeSet<>(tmp));
            }
            sets[index] = integerTreeSet;
        }

        return new ArrayList<>(integerTreeSet);
    }


    public int[] sortJumbled_1(int[] mapping, int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String str = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                sb.append(mapping[str.charAt(j) - '0']);
            }
            int tmp = Integer.parseInt(sb.toString());
            List<Integer> orDefault = treeMap.getOrDefault(tmp, new ArrayList<>());
            orDefault.add(num);
            treeMap.put(tmp, orDefault);
        }
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            List<Integer> value = entry.getValue();
            for (Integer integer : value) {
                res[index] = integer;
            }
        }
        return res;

    }

    public List<List<Integer>> getAncestors_1(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[1]].add(edge[0]);
        }
        Map<Integer, TreeSet<Integer>> existMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!existMap.containsKey(i)) {
                TreeSet<Integer> tmp = dfsGetAncestors1(i, lists, existMap);
                res.add(new ArrayList<>(tmp));
            } else {
                res.add(new ArrayList<>(existMap.get(i)));
            }
        }

        return res;
    }

    private TreeSet<Integer> dfsGetAncestors1(int i, List<Integer>[] lists, Map<Integer, TreeSet<Integer>> existMap) {
        if (existMap.containsKey(i))
            return existMap.get(i);
        List<Integer> list = lists[i];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer integer : list) {
            if (existMap.containsKey(integer)) {
                TreeSet<Integer> tmp = existMap.get(integer);
                treeSet.addAll(tmp);
                treeSet.add(integer);
            } else {
                TreeSet<Integer> child = dfsGetAncestors1(integer, lists, existMap);
                treeSet.addAll(child);
                treeSet.add(integer);
            }
        }
        existMap.put(i, treeSet);
        return existMap.put(i, treeSet);
    }
}
