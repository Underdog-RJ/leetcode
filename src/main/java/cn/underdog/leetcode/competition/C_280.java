package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/320:48
 */
public class C_280 {

    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            res++;
        }
        return res;
    }

    public int minimumOperations(int[] nums) {
        if(nums.length == 1)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map0 = new HashMap<>();
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                map0.put(nums[i], map0.getOrDefault(nums[i], 0) + 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        PriorityQueue<int[]> peven = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<int[]> podd = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map0.entrySet()) {
            peven.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            podd.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] peven0 = peven.poll();
        int[] podd0 = podd.poll();
        if (peven0[0] == podd0[0]) {
            int[] peven1 = new int[2];
            int[] podd1 = new int[2];
            if (peven != null && peven.size() != 0) {
                peven1 = peven.poll();
            }
            if (podd != null && podd.size() != 0) {
                podd1 = podd.poll();
            }
            int tmp1 = peven0[1] + podd1[1];
            int tmp2 = peven1[1] + podd0[1];
            int tmp = Math.max(tmp1, tmp2);
            return length - tmp;
            /*int i1 = peven.peek()[1];
            int j1 = podd.peek()[1];
            if (j1 >= i1) {
                if (nums.length % 2 == 0) {
                    peven.poll();
                    int[] poll = peven.poll();
                    res += nums.length / 2 - poll[1];
                } else {
                    peven.poll();
                    int[] poll = peven.poll();
                    res += nums.length / 2 - poll[1] + 1;
                }
            } else {
                if (nums.length % 2 != 0) {
                    // 计算偶数
                    int[] evenArr = peven.peek();
                    res += nums.length / 2 - evenArr[1] + 1;
                    int[] oddArr = podd.peek();
                    res += nums.length / 2 - oddArr[1];
                } else {
                    // 计算偶数
                    int[] evenArr = peven.peek();
                    res += nums.length / 2 - evenArr[1];
                    int[] oddArr = podd.peek();
                    res += nums.length / 2 - oddArr[1];
                }
            }*/
        }
        // 如果奇偶位置上最多的元素不相同,则用总和减去 奇数和偶数的最大数量即可
        else {
            return length - peven0[1] - podd0[1];
          /*  if (nums.length % 2 != 0) {
                // 计算偶数
                int[] evenArr = peven.peek();
                res += nums.length / 2 - evenArr[1] + 1;
                int[] oddArr = podd.peek();
                res += nums.length / 2 - oddArr[1];
            } else {
                // 计算偶数
                int[] evenArr = peven.peek();
                res += nums.length / 2 - evenArr[1];
                int[] oddArr = podd.peek();
                res += nums.length / 2 - oddArr[1];
            }*/
        }
    }

    public long minimumRemoval(int[] beans) {
        long sum = 0;
        long min = Long.MAX_VALUE;
        Arrays.sort(beans);
        for (int bean : beans) {
            sum += bean;
        }
        for (int i = 0; i < beans.length; i++) {
            long take = sum - (long) beans[i] * (beans.length - i);
            min = Math.min(take,min);
        }

        return min;
    }
}
