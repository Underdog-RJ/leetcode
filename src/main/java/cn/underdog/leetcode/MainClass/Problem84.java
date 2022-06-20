package cn.underdog.leetcode.MainClass;

import java.util.*;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem84 {

    public static void main(String[] args) {
        findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
    }

    public static int findLHS(int[] nums) {

        int ans = 0;
        int begin = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - nums[begin] > 1)
                begin++;
            if (nums[i] - nums[begin] == 1) {
                ans = Math.max(ans, i - begin + 1);
            }
        }
        return ans;

    }
}
