package cn.underdog.leetcode.practiceCompetition;

import java.util.*;

public class C_280 {

    public static void main(String[] args) {
        C_280 c_280 = new C_280();
//        c_280.minimumOperations(new int[]{1, 2, 2, 2, 2});
//        c_280.minimumOperations(new int[]{3, 1, 3, 2, 4, 3});
//        c_280.minimumRemoval(new int[]{4, 1, 6, 5});
        c_280.minimumRemoval(new int[]{2, 10, 3, 2});
    }

    public int minimumOperations(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return 0;
        TreeMap<Integer, Integer> even = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, Integer> odd = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 1) {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            } else {
                even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            }
        }
        PriorityQueue<int[]> priorityQueue1 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<int[]> priorityQueue2 = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : even.entrySet()) {
            priorityQueue1.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (Map.Entry<Integer, Integer> entry : odd.entrySet()) {
            priorityQueue2.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] even1 = priorityQueue1.poll();
        int[] even2 = priorityQueue1.poll();
        int[] odd1 = priorityQueue2.poll();
        int[] odd2 = priorityQueue2.poll();
        // 如果两者出现次数最多的不等
        if (even1[0] != odd1[0]) {
            return length - even1[1] - odd1[1];
        } else {
            // 偶数第一和奇数第二
            int num1 = 0;
            if (odd2 != null) {
                num1 = odd2[1];
            }
            int tmp1 = length - even1[1] - num1;
            // 偶数第二和奇数第一
            int num2 = 0;
            if (even2 != null) {
                num2 = even2[1];
            }
            int tmp2 = length - odd1[1] - num2;
            return Math.min(tmp1, tmp2);
        }

    }

    public long minimumRemoval(int[] beans) {
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long res = Long.MAX_VALUE;
        int length = beans.length;
        Arrays.sort(beans);
        for (int i = 0; i < beans.length; i++) {
            int cnt = beans[i];
            long tmp = sum - (long) cnt * (length - i); // 注意转换为long类型的。
            res = Math.min(res, tmp);
        }
        return res;
    }

}
