package cn.underdog.leetcode.competition;

import java.util.*;

public class D_88 {
    public static void main(String[] args) {
        D_88 d = new D_88();
//        d.equalFrequency("cbccca");
        d.equalFrequency("abcc");
//        LUPrefix luPrefix = new LUPrefix(4);
//        luPrefix.upload(3);
//        luPrefix.longest();
//        luPrefix.upload(2);
//        luPrefix.longest();
//        luPrefix.upload(1);
//        luPrefix.longest();
//        d.xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0});
    }

    public boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char cntK = word.charAt(i);
            map.put(cntK, map.getOrDefault(cntK, 0) + 1);

        }

        Map<Integer, Integer> m = new HashMap<>();
        for (Integer value : map.values()) {
            m.put(value, m.getOrDefault(value, 0) + 1);
        }
        if (m.size() == 1) {
            if (m.containsKey(1)) return true;
            else {
                Integer cntK = m.entrySet().iterator().next().getKey();
                Integer integer = m.get(cntK);
                if (integer.equals(1)) return true;
                else return false;
            }
        } else if (m.size() == 2) {
            Set<Integer> set = new HashSet<>(m.values());
            if (set.contains(1) && m.containsKey(1) && m.get(1) == 1) return true;
            else return false;
        } else {
            return false;
        }
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            Integer orDefault = map.getOrDefault(i, 0);
            map.put(i, orDefault + n2);
        }
        for (int i : nums2) {
            Integer orDefault = map.getOrDefault(i, 0);
            map.put(i, orDefault + n1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if ((value & 1) == 1) {
                res ^= entry.getKey();
            }
        }


        return res;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int left = 0, right = 1, n = nums1.length - 1;
        long res = 0;
        while (right < n) {
            int num1 = nums1[left] - nums1[right];
            int num2 = nums2[left] - nums2[right] + diff;
            while (num1 <= num2) {
                left++;
            }
        }
        return res;
    }

}
