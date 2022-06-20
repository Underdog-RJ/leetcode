package cn.underdog.leetcode.greedy;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        Practice p = new Practice();
//        p.jump(new int[]{2,3,1,1,4});
//        p.jump(new int[]{1, 2, 1, 1, 1});
        p.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3});
    }


    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * <p>
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * <p>
     *  
     * 示例 1:
     * <p>
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     * <p>
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param g
     * @param s
     * @return 思路：要最大程度的满足孩子的胃口
     * 饼干要分配合理 s[j] -g[i]要尽可能的小
     * 每次选择最小的===>>整体最小
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0; // 记录饼干的位置
        // 遍历饼干,看当前饼干能够满足
        for (int i = 0; i < s.length; i++) {
            // 如果饼干能满足（并且没达到），则进入下一个 孩子
            if (index < g.length && s[i] >= g[index]) {
                index++;
            }
        }
        return index;
    }


    /**
     * // 用current记录当前最大位置位置
     * int current = 0;
     * // 记录次数
     * int count = 0;
     * // 记录上一次出现的最大值
     * int lastCurrent = 0;
     * for (int i = 0; i < nums.length-1; i++) {
     * // 如果当前i和当前的跳跃位置大于最大位置更新最大位置
     * if (nums[i] + i > current)
     * current = nums[i] + i;
     * // 如果当前值为上一次出现的最大值，则count++并且更新lastCurrent;
     * if (i == lastCurrent) {
     * count++;
     * lastCurrent = current;
     * }
     * }
     * return count;
     * <p>
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * <p>
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路
     * 最少步骤达到最后一步===》》每步选择最优的=====》》每次都判断当前能否达到最后一步
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int current = 0;
        int lastMax = 0;
        int length = nums.length - 1;
        int count = 0;
        // 不访问最后一个，最后一个，一定能访问到边界
        for (int i = 0; i < length; i++) {
            // 判断当前值是否大于最大值
            current = Math.max(i + nums[i], current);
            if (i == lastMax) {
                count++;
                lastMax = current;
            }

        }
        return count;

    }

}

