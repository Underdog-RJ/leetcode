package cn.underdog.primaryAlgorithm;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day_02 {

    public static void main(String[] args) {
        //rotate(new int[]{1,2,3,4,5,6},11);
        rotate(new int[]{1,2},3);
    }

    public static int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int[] ans = new int[nums.length];
        int index = ans.length - 1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int leftNum= nums[left]*nums[left];
            int rightNum= nums[right]*nums[right];
            if(leftNum>rightNum){
                ans[index--] = leftNum;
                left++;
            }else {
                ans[index--] = rightNum;
                right--;
            }
        }
        return ans;
    }

    public static void rotate(int[] nums, int k) {

        int index = 0;
        int left = 0;
        int right = 0;
        int right1=0;
        if(k>nums.length){
            right =nums.length- k%nums.length;
            right1=nums.length- k%nums.length;
        }
        else {
             right = nums.length-k;
             right1= nums.length-k;
        }
        int[] ans = new int[nums.length];
        while (right < nums.length) {
            ans[index++] = nums[right++];
        }
        while (left < right1) {
            ans[index++] = nums[left++];
        }

        /*
        数组的拷贝
                参数一：新数组
                参数二：新参数的开始索引
                参数三：背拷贝的数组
                参数四，五：背拷贝数组的开始结束索引
         */
        System.arraycopy(ans, 0, nums, 0, nums.length);

    }
}
