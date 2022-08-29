package cn.underdog.leetcode.competition.review;

import java.util.*;
import java.util.Set;

public class C_305 {

    public static void main(String[] args) {

    }


    // 枚举第三个节点
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - diff) && set.contains(nums[i] - 2 * diff)) res++;
            set.add(nums[i]);
        }
        return res;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        boolean[] flags = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        return dfsRN(0, list, flags, set);
    }

    private int dfsRN(int i, List<Integer>[] list, boolean[] flags, Set<Integer> set) {
        if (set.contains(i)) return 0;
        if (flags[i]) return 0;
        flags[i] = true;
        int count = 1;
        for (Integer integer : list[i]) {
            count += dfsRN(integer, list, flags, set);
        }
        return count;
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] flags = new boolean[n];
        flags[1] = nums[0] == nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (flags[i - 2]) {
                if (nums[i] == nums[i - 1]) {
                    flags[i] = true;
                }
            }
            if (i == 2 || flags[i - 3]) {
                if ((nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) || (nums[i] - 1 == nums[i - 1] && nums[i] - 2 == nums[i - 2]))
                    flags[i] = true;
            }
        }
        return flags[n - 1];
    }


}
