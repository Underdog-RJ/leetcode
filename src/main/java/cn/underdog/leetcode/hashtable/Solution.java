package cn.underdog.leetcode.hashtable;

import java.util.*;

class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int length = list.size();
        Random random = new Random();
        int i = random.nextInt(length);
        return list.get(i);
    }
}
