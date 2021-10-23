package cn.underdog.MainClass;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 */
public class day_02 {


    public static void main(String[] args) {
//        int min = findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
//        int min = findMin(new int[]{11,13,15,17});
//        int min = findMin(new int[]{3,4,5,1,2});
//        int min = findMin(new int[]{3,1,2});
//        int min = findPeakElement(new int[]{1,2,1,3,5,6,4});
        int min = findPeakElement(new int[]{1, 3, 2, 1});
        System.out.println(min);
    }

    public static int findMin(int[] nums) {

        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[1] : nums[0];

        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 左边有序
            if (nums[left] < nums[mid]) {
                if (min > nums[left]) {
                    min = nums[left];
                }
                left = mid;
            }
            // 右边有序
            else {
                if (min > nums[mid]) {
                    min = nums[mid];
                }
                right = mid - 1;
            }

        }

        return min;
    }

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * <p>
     * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     * <p>
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * 输入：nums = [1,2,3,1]
     * 输出：2
     * 解释：3 是峰值元素，你的函数应该返回其索引 2。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-peak-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums.length == 2)
            return nums[0] > nums[1] ? 0 : 1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid+1])
                right = mid;
            else
                left =mid+1;
        }
        return left;
    }
}
