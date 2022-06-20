package cn.underdog.leetcode.MainClass;

import java.util.*;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem53 {

    public static void main(String[] args) {
//        threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
//        threeSumClosest(new int[]{0,2,1,-3}, 1);
        threeSumClosest(new int[]{2,3,4,5,11}, 33);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int Min_Value = Integer.MAX_VALUE;
        int Min_length = Integer.MAX_VALUE;
        int length = nums.length - 2;
        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int currentNum = nums[i];
            while (left < right) {
                // 当前三值之和，
                int total = currentNum + nums[left] + nums[right];
                // 三值之和与目标值的距离
                int uLength = Math.abs(target-total);
                // 如果和大于target 向右移动
                if (total > target) {
                    right--;
                }
                // 如果和大于target向左移动
                else if (total <= target) {
                    left++;
                }
                // 记录最小位置 如果当前位置小于最小位置则更新为把当前位置更新为最小位置
                if(uLength<Min_length){
                    Min_length=uLength;
                    Min_Value=total;
                }
            }
        }
        return Min_Value;
    }


}
