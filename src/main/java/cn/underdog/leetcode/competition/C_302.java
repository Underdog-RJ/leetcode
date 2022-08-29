package cn.underdog.leetcode.competition;

import java.util.*;

public class C_302 {


    public static void main(String[] args) {
        C_302 c_302 = new C_302();
//        c_302.maximumSum(new int[]{18, 43, 36, 13, 7});
//        c_302.maximumSum(new int[]{4, 6, 10, 6});
//        c_302.smallestTrimmedNumbers(new String[]{"64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"}
//                , new int[][]{{9, 4}, {6, 1}, {3, 8}, {12, 9}, {11, 4}, {4, 9}, {2, 7}, {10, 3}, {13, 1}, {13, 1}, {6, 1}, {5, 10}});
//        c_302.smallestTrimmedNumbers(new String[]{"24","37","96","04"},new int[][]{{2,1},{2,2}});
//        c_302.smallestTrimmedNumbers(new String[]{"24","37","96","04"},new int[][]{{2,1},{2,2}});
//        System.out.println("8".compareTo("8"));
//        c_302.minOperations(new int[]{2, 3, 2, 4, 3}, new int[]{9, 6, 9, 3, 15});
        c_302.minOperations(new int[]{4, 3, 6}, new int[]{8, 2, 6, 10});
    }

    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res1 = 0;
        int res2 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                res2 = entry.getValue() % 2;
            }
            res1 += entry.getValue() / 2;
        }
        return new int[]{res1, res2};
    }

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            String str = String.valueOf(num);
            int tmp = 0;
            for (char c : str.toCharArray()) {
                tmp += c - '0';
            }
            PriorityQueue<Integer> orDefault = map.getOrDefault(tmp, new PriorityQueue<>((o1, o2) -> o2 - o1));
            orDefault.add(num);
            map.put(tmp, orDefault);
        }
        int res = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                PriorityQueue<Integer> value = entry.getValue();
                Integer num1 = value.poll();
                Integer num2 = value.poll();
                res = Math.max(res, num1 + num2);
            }
        }
        return res == 0 ? -1 : res;
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int index = 0;
        for (int[] query : queries) {
            List<String[]> priorityQueue = new ArrayList<>();
            int k = query[0];
            int release = query[1];
            String[] clone = nums.clone();
            int length = clone[0].length();
            int tmp = length - release;
            for (int i = 0; i < clone.length; i++) {
                priorityQueue.add(new String[]{clone[i].substring(tmp), String.valueOf(i)});
            }
            Collections.sort(priorityQueue, (o1, o2) -> o1[0].compareTo(o2[0]));
            res[index++] = Integer.parseInt(priorityQueue.get(k - 1)[1]);
        }
        return res;
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(numsDivide);
        int maxGcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            maxGcd = gcd(numsDivide[i], maxGcd);
        }
        int res = 0;
        boolean flag = false;
        while (map.size() != 0) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            if (entry.getKey() > maxGcd) {
                continue;
            }
            if (maxGcd % entry.getKey() != 0) {
                res += entry.getValue();
            } else {
                flag = true;
                break;
            }
        }
        return !flag ? -1 : res;
    }

    public int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }


}
