package cn.underdog.leetcode.competition;

import java.util.*;

public class C_269 {
    public static void main(String[] args) {
//        getAverages(new int[]{800000000, 800000000, 22}, 2);
//        minimumDeletions(new int[]{-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28});
//        System.out.println(minimumDeletions(new int[]{-14, 61, 29, -18, 59, 13, -67, -16, 55, -57, 7, 74}));
        System.out.println(minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6}));
    }

    public List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }

        return res;
    }

    public static int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[nums.length];
        long[] res1 = new long[nums.length];
        Arrays.fill(res, -1);
        Arrays.fill(res1, -1);
        if (k == 0)
            return nums;
        if (k >= length)
            return res;
        int temp = k * 2 + 1;
        long tempSum = 0;
        if (temp > length)
            return res;
        for (int j = 0; j < temp; j++) {
            tempSum += nums[j];
        }
        for (int i = k; i < length; i++) {
            if (i + k > length)
                break;
            res1[i] = tempSum / temp;
            if (i + k + 1 >= length)
                break;
            tempSum = tempSum - nums[i - k] + nums[i + k + 1];
        }
        for (int i = 0; i < res1.length; i++) {
            res[i] = (int) res1[i];
        }
        return res;
    }

    public static int minimumDeletions(int[] nums) {

        if (nums.length == 1)
            return 1;
        if (nums.length == 2)
            return 2;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        int length = nums.length;
        // 从左边移动
        int left = Math.max(minIndex, maxIndex) + 1;
        // 从右边移动
        int right = Math.max(length - minIndex, length - maxIndex);
        // 从两端移动
        int ll = Math.min(minIndex, maxIndex) + 1;
        int rr = length - Math.max(maxIndex, minIndex) ;
        int lr = ll + rr;
        if (left < right) {
            return Math.min(lr, left);
        } else {
            return Math.min(right, lr);
        }

    }

}
