package cn.underdog.leetcode.rating;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                m1.put(nums[i], m1.getOrDefault(nums[i], 0) + 1);
            } else {
                m2.put(nums[i], m2.getOrDefault(nums[i], 0) + 1);
            }
        }
        PriorityQueue<int[]> p1 = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        PriorityQueue<int[]> p2 = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            p1.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (Map.Entry<Integer, Integer> entry : m2.entrySet()) {
            p2.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] even0 = p1.poll();
        int[] odd0 = p2.poll();
        if (even0[0] != odd0[0]) {
            int n1 = even0[1];
            int n2 = odd0[1];
            System.out.println(n - n1 - n2);
        } else {
            int[] even1 = new int[]{-1, 0};
            int[] odd1 = new int[]{-1, 0};
            if (!p1.isEmpty()) {
                even1 = p1.poll();
            }
            if (!p2.isEmpty()) {
                odd1 = p2.poll();
            }
            int max = Math.max(odd0[1] + even1[1], odd1[1] + even0[1]);
            System.out.println(n - max);
        }
    }


}
