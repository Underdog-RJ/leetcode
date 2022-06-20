package cn.underdog.leetcode.competition;

import java.util.*;

public class C_271 {

    public static void main(String[] args) {
        C_271 c = new C_271();
//        c.countPoints("B0B6G0R6R0R6G9");
//        System.out.println(c.subArrayRanges(new int[]{1, 3, 3}));
//        System.out.println(c.subArrayRanges(new int[]{1, 2, 3}));
        System.out.println(c.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
//        System.out.println(c.minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));
//        System.out.println(c.minimumRefill(new int[]{2, 2, 5, 2, 2}, 5, 5));
//        System.out.println(c.minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5));
    }

    public int countPoints(String rings) {
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new HashSet<>());
        }
        for (int i = 1; i < rings.length(); i += 2) {
            list.get(rings.charAt(i) - '0').add(rings.charAt(i - 1));
        }

        int res = 0;
        for (Set<Character> characters : list) {
            if (characters.size() == 3)
                res++;
        }

        return res;
    }

    /**
     * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
     * <p>
     * 返回 nums 中 所有 子数组范围的 和 。
     * <p>
     * 子数组是数组中一个连续 非空 的元素序列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：4
     * 解释：nums 的 6 个子数组如下所示：
     * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
     * [2]，范围 = 2 - 2 = 0
     * [3]，范围 = 3 - 3 = 0
     * [1,2]，范围 = 2 - 1 = 1
     * [2,3]，范围 = 3 - 2 = 1
     * [1,2,3]，范围 = 3 - 1 = 2
     * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
     * 示例 2：
     * <p>
     * 输入：nums = [1,3,3]
     * 输出：4
     * 解释：nums 的 6 个子数组如下所示：
     * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
     * [3]，范围 = 3 - 3 = 0
     * [3]，范围 = 3 - 3 = 0
     * [1,3]，范围 = 3 - 1 = 2
     * [3,3]，范围 = 3 - 3 = 0
     * [1,3,3]，范围 = 3 - 1 = 2
     * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
     * 示例 3：
     * <p>
     * 输入：nums = [4,-2,-3,4,1]
     * 输出：59
     * 解释：nums 中所有子数组范围的和是 59
     *
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }


    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int res = 0;
        int left = 0;
        int right = plants.length - 1;
        int Atotal = capacityA;
        int Btotal = capacityB;

        while (left < right) {
            if (capacityA >= plants[left]) {
                capacityA -= plants[left];
                left++;
            } else {
                capacityA = Atotal;
                capacityA -= plants[left];
                left++;
                res++;
            }
            if (capacityB >= plants[right]) {
                capacityB -= plants[right];
                right--;
            } else {
                capacityB = Btotal;
                capacityB -= plants[right];
                right--;
                res++;
            }
        }
        if (left == right) {
            if (capacityA == capacityB) {
                if (capacityA < plants[left])
                    res++;
            } else {
                if (Math.max(capacityA, capacityB) < plants[left])
                    res++;
            }
        }

        return res;
    }


}
