package cn.underdog.mediumAlgorithm;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day_01 {

    public static void main(String[] args) {
//        search(new int[]{4,5,6,7,0,1,2},0);
//        search(new int[]{3, 1}, 1);
//        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
//        System.out.println(searchMatrix(new int[][]{{1}}, 1));
        System.out.println(searchMatrix(new int[][]{{1}, {3}}, 3));
    }

    /**
     * 暴力递归
     *
     * @param nums
     * @param target
     * @return
     */
    /*public int search(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                index = i;
            }
        }
        return index;
    }*/
    public static int search(int[] nums, int target) {

        int length = nums.length;
        if (length == 0)
            return -1;
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 如果mid直接相等直接返回
            if (nums[mid] == target)
                return mid;
            // 如果左边有序
            if (nums[0] < nums[mid]) {
                // 此时左边有序且target在有序数组里面 则右指针设为mid -1
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } // 如果左边有序，但是target不在有序数组里面则移动左指针 =  m +1
                else {
                    left = mid + 1;
                }
            }
            // 右边有序
            else {
                // 如果target 在有序数组里面移动左指针 = mid +1
                if (nums[mid + 1] <= target && nums[right] >= target) {
                    left = mid + 1;
                } //此时范围在左边移动right = mid -1;
                else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }


    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            if (matrix[i].length == 1) {
                if (matrix[i][0] == target) {
                    return true;
                } else {
                    continue;
                }
            }
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                int left = 0;
                int right = matrix[i].length - 1;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    if (matrix[i][mid] == target)
                        return true;
                    if (matrix[i][mid] > target)
                        right = mid - 1;
                    else if (matrix[i][mid] < target)
                        left = mid;
                }
                return matrix[i][left] == target ? true : false;
            }
        }
        return false;
    }

}
