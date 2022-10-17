package cn.underdog.leetcode.competition;

import java.util.*;

public class C_315 {
    public static void main(String[] args) {
        C_315 c_315 = new C_315();
//        c_315.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
        c_315.countSubarrays(new int[]{1, 1, 1, 1}, 1, 1);
    }


    public int findMaxK(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (!set.isEmpty()) {
            Integer integer = set.pollLast();
            if (integer < 0) {
                break;
            }
            if (set.contains(-integer)) return integer;
        }
        return -1;
    }


    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            set.add(Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString()));
        }

        return set.size();
    }

    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            int tmp = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
            if (tmp + i == num) return true;
        }
        return false;
    }

//    public long countSubarrays(int[] nums, int minK, int maxK) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        long count = 0;
//        int left = 0, right = 0, n = nums.length, cnt = 0;
//        while (right < n) {
//            int cntK = nums[right];
//            map.put(cntK, map.getOrDefault(cntK, 0) + 1);
//
//            if (map.firstKey().equals(minK) && map.lastKey().equals(maxK)) {
//                cnt++;
//                int num = nums[left++];
//                Integer integer = map.get(num);
//                if (integer > 1) {
//                    map.put(num, integer - 1);
//                } else {
//                    map.remove(num);
//                }
//            }
//
//            right++;
//
//        }
//
//        return count;
//    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minIdx = -1, maxIdx = -1, left = 0;
        for (int i = 0; i < nums.length; i++) {
            int cntNum = nums[i];
            if (cntNum < minK || cntNum > maxK) {
                left = i + 1;
                maxIdx = -1;
                minIdx = -1;
            }
            if (cntNum == minK) {
                minIdx = i;
            }
            if (cntNum == maxK) {
                maxIdx = i;
            }
            if (minIdx != -1 && maxIdx != -1) {
                count += Math.min(minIdx, maxIdx) - left + 1;
            }
        }
        return count;
    }


}
