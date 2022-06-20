package cn.underdog.leetcode.primaryAlgorithm;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day_01 {

    public static void main(String[] args) {

        System.out.println( (int) Math.random()*10);
//        int search = searchInsert(new int[]{1,3,5,6}, 7);
//        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target)
                right = mid-1;
            else
                left = mid;
        }
        if(nums[left]==target)
            return left;
        else
            return -1;
    }

    public int firstBadVersion(int n) {
        return 0;
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = 0;
        if(target>nums[nums.length-1])
            return nums.length;
        if(target<nums[0])
            return 0;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(nums[left]<target&&target<nums[right]){
                pos = mid;
            }
            if (nums[mid] > target)
                right = mid-1;
            else
                left = mid;

        }
        if(nums[left]==target)
            return left;
        else
            return pos;
    }



}
