package cn.underdog.leetcode.MainClass;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 *
 * 输入：nums = [1,2,1,4,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *
 */
public class Problem4 {

    public static void main(String[] args) {

        int[] nums= {1,2,3};
        System.out.println(findPeakElement2(nums));

    }

    public static int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums.length==2)
            return nums[0] > nums[1] ? 0 : 1;
        for (int i = 1; i < nums.length; i++) {
            if(i+1==nums.length)
                return nums[i] > nums[0] ? i : 0;
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
                return i;
        }
        return 0;
    }

    /**
     * 二分查找，因为题目限定左右两边是负无穷，所以说
     *      1.首先查找中间的值（如果满足条件直接返回）
     *      2.如果中间的值大于右边的值 right =mid
     *      3.如果中间的值小于右边的指 left = mid + 1;
     *      4.开始下一次比较，如果两个mid = left (最左边) + (right - left)/2 -->寻找中间值
     *      5.如果left>=right时查找结束跳出循环
     *
     * @param nums
     * @return
     */
    public static int findPeakElement1(int[] nums) {
        int left=0,right=nums.length-1;
        for (;left<right;){
            int mid= left + (right-left)/2;
            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }

    public static int findPeakElement2(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums.length==2)
            return nums[0] > nums[1] ? 0 : 1;
        for (int i = nums.length-2; i >=0; i--) {
            if(i==0)
                return nums[0] > nums[nums.length-1] ? 0 : nums.length-1;
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])
                return i;
        }
        return 0;
    }


}
