package cn.underdog.leetcode.competition;

import java.util.*;

public class C_305 {

    public static void main(String[] args) {
        C_305 c_305 = new C_305();
//        c_305.reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5});
//        System.out.println(c_305.validPartition(new int[]{4, 4, 4, 5, 6}));
        c_305.longestIdealString("acfgbd", 2);
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int u = j + 1; u < nums.length; u++) {
                    if (nums[u] - nums[j] == nums[j] - nums[i] && nums[j] - nums[i] == diff) res++;
                }
            }
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
        int total = 0;
        boolean[] flags = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        total = dfsRN(0, list, flags, set);
        return total;
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

    HashMap<Integer, Boolean> map = new HashMap<>();
    public boolean validPartition(int[] nums) {
        return dfsVP(nums, 0);
    }

    private boolean dfsVP(int[] nums, int startIndex) {
        if (startIndex == nums.length) return true;
        if (startIndex > nums.length) return false;
        if (map.containsKey(startIndex)) return map.get(startIndex);
        if (startIndex + 1 < nums.length && nums[startIndex] == nums[startIndex + 1]) {
            boolean child = dfsVP(nums, startIndex + 2);
            if (child) return true;
        }
        if (startIndex + 2 < nums.length && nums[startIndex] == nums[startIndex + 1] && nums[startIndex] == nums[startIndex + 2]) {
            boolean child = dfsVP(nums, startIndex + 3);
            if (child) return true;
        }
        if (startIndex + 2 < nums.length && nums[startIndex] + 1 == nums[startIndex + 1] && nums[startIndex] + 2 == nums[startIndex + 2]) {
            boolean child = dfsVP(nums, startIndex + 3);
            if (child) return true;
        }
        map.put(startIndex, false);
        return false;
    }

    public int longestIdealString(String s, int k) {
        int max = 1;
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'a';
            int num = 1;
            for (int j = tmp - k; j <= tmp + k; j++) {
                char cntK = (char) (j + 'a');
                if (map1.containsKey(cntK)) {
                    num = Math.max(num, map1.get(cntK) + 1);
                }
            }
            map1.put(s.charAt(i), num);
            max = Math.max(max, num);
        }
        return max;
    }

}
