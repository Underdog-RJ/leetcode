package cn.underdog.leetcode.prefixSum;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {

    int[] numsTarget = null;
    int[] numSum = null;

    public NumArray(int[] nums) {
        this.numsTarget = nums;
        this.numSum = new int[nums.length];
        numSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            numSum[i] = numSum[i - 1] + nums[i];
        }
    }

    public void update(int index, int val) {
        int pre = numsTarget[index];
        if (pre > val) {
            int tmp = pre - val;
            for (int i = index; i < numSum.length; i++) {
                numSum[i] -= tmp;
            }
        } else if (pre < val) {
            int tmp = val - pre;
            for (int i = index; i < numSum.length; i++) {
                numSum[i] += tmp;
            }
        }
        numsTarget[index] = val;

    }

    public int sumRange(int left, int right) {
        if (left == right)
            return numsTarget[left];
        if (left == 0)
            return numSum[right];
        else
            return numSum[right] - numSum[left-1];
    }

}
