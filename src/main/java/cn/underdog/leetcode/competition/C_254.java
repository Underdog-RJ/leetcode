package cn.underdog.leetcode.competition;

import java.util.*;

public class C_254 {

    public static void main(String[] args) {

    }

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            int index = word.indexOf(pattern);
            if (index != -1)
                count++;
        }
        return count;
    }

    public int[] rearrangeArray(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = set.pollFirst();
            } else {
                nums[i] = set.pollLast();
            }
        }
        return nums;
    }
}
