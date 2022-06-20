package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/320:15
 */
public class C_287 {

    public static void main(String[] args) {
        C_287 c_287 = new C_287();
//        c_287.maximumCandies_1(new int[]{5, 8, 3}, 3);
        c_287.maximumCandies_1(new int[]{2, 5}, 11);
    }


    public int convertTime(String current, String correct) {
        int cnt = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3, 5));
        int crt = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3, 5));
        // 判断是否大于60
        return (crt - cnt) / 60 + (crt - cnt) % 60 / 15 + (crt - cnt) % 15 / 5 + (crt - cnt) % 5;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        // 用treemap统计输的数量
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> list = List.of(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                list.get(entry.getValue()).add(entry.getKey());
            }
        }
        return list;
    }

    public int maximumCandies(int[] candies, long k) {
        long left = 0;
        long right = 10000000;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }


    public List<List<Integer>> findWinners_1(int[][] matches) {
        TreeSet<Integer> winSet = new TreeSet<>();
        HashMap<Integer, Integer> loseMap = new HashMap<>();
        for (int[] match : matches) {
            winSet.add(match[0]);
            loseMap.put(match[1], loseMap.getOrDefault(match[1], 0) + 1);
        }
        Set<Integer> set = loseMap.keySet();

        winSet.removeAll(set);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(winSet));
        TreeSet<Integer> loseSet = new TreeSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : loseMap.entrySet()) {
            if (integerIntegerEntry.getValue() == 1) {
                loseSet.add(integerIntegerEntry.getKey());
            }
        }
        res.add(new ArrayList<>(loseSet));
        return res;
    }

    /**
     * 二分查找
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandies_1(int[] candies, long k) {
        int left = 0;
        int right = 10000000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
