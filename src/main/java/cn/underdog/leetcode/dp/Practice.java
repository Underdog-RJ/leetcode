package cn.underdog.leetcode.dp;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{10, 15, 20});
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1)
            return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            if (prices[i] < min)
                min = prices[i];
        }
        return res;
    }

    // dp
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    // greedy
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int lastSum = 0;
        int currentSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (lastSum < 0) lastSum = 0;
            currentSum = lastSum + nums[i];
            res = Math.max(res, currentSum);
            lastSum = currentSum;
        }
        return res;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n - 1];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }


    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
