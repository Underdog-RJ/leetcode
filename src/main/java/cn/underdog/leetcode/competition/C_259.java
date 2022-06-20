package cn.underdog.leetcode.competition;

public class C_259 {
    public static void main(String[] args) {
        C_259 c_259 = new C_259();
//        c_259.sumOfBeauties(new int[]{1, 2, 3});
        c_259.sumOfBeauties(new int[]{2, 4, 6, 4});
    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
     * <p>
     * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
     * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
     * 0，如果上述条件全部不满足
     * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：2
     * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
     * - nums[1] 的美丽值等于 2
     * 示例 2：
     * <p>
     * 输入：nums = [2,4,6,4]
     * 输出：1
     * 解释：对于每个符合范围 1 <= i <= 2 的下标 i :
     * - nums[1] 的美丽值等于 1
     * - nums[2] 的美丽值等于 0
     * 示例 3：
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：0
     * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
     * - nums[1] 的美丽值等于 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sum-of-beauty-in-the-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int sumOfBeauties(int[] nums) {
        int length = nums.length;
        int[] leftMax = new int[length];
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[leftMax[i - 1]]) {
                leftMax[i] = i;
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }
        int[] rightMin = new int[length];
        rightMin[length - 1] = length - 1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[rightMin[i + 1]]) {
                rightMin[i] = i;
            } else {
                rightMin[i] = rightMin[i + 1];
            }
        }
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            if (leftMax[i] == i && rightMin[i] == i)
                res += 2;
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1])
                res++;
        }

        return res;
    }
}
