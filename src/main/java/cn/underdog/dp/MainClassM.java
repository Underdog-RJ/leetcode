package cn.underdog.dp;

import java.util.*;

public class MainClassM {

    public static void main(String[] args) {
//        generateParenthesis(4);
//        System.out.println(jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
//        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(jump(new int[]{1,1,1,1}));
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
//        System.out.println(canJump(new int[]{0}));
//        canJump(new int[]{1,2,3});
        longestSubsequence(new int[]{1,2,3,4},1);
    }


    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        res.add("()");
        if (n == 1)
            return res;
        res.add("(())");
        res.add("()()");
        res.remove(0);
        if (n == 2)
            return res;
        for (int i = 3; i <= n; i++) {
            Set<String> set = new HashSet<>();
            for (int j = 0; j < res.size(); j++) {
                String temp = res.get(j);
                set.add("()" + temp);
                set.add(temp + "()");
                set.add("(" + temp + ")");
            }
            res = new ArrayList<>(set);
        }
        return res;
    }


    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        // 如果数组长度为1则一定能跳到，返回true
        if (nums.length == 1)
            return true;
        // 用current记录当前位置
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前最大位置为0并且在当前位置则直接返回false
            if (nums[current] == 0 && current == i)
                return false;
            // 如果当前i和当前的跳跃位置大于最大位置更新最大位置
            if (nums[i] + i > current)
                current = nums[i] + i;
            // 如果当前的最大位置为已经值最后一个返回true
            if (current >= nums.length - 1)
                return true;
        }
        return false;
    }


    /**
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
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        // 用current记录当前最大位置位置
        int current = 0;
        // 记录次数
        int count = 0;
        // 记录上一次出现的最大值
        int lastCurrent = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前i和当前的跳跃位置大于最大位置更新最大位置
            if (nums[i] + i > current)
                current = nums[i] + i;
            // 如果当前值为上一次出现的最大值，则count++并且更新lastCurrent;
            if (i == lastCurrent) {
                count++;
                lastCurrent = current;
            }
        }
        return count;
    }


    public static int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer,Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v,dp.getOrDefault(v-difference,0)+1);
            ans = Math.max(ans,dp.get(v));
        }
        return ans;

    }
}
