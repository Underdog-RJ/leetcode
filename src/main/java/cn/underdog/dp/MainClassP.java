package cn.underdog.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClassP {
    public static void main(String[] args) {
//        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        maxProfit(null);
//        System.out.println(climbStairs(45));
        /*List<List<Integer>> generate = generate(33);
        for (List<Integer> list : generate) {
            System.out.println(list.toString());
        }*/
//        getRow(5);
//        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
//        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
//        rob(new int[]{2, 1, 1, 2});
//        System.out.println(fib(4));
//        isSubsequence("abc", "ahbgdc");
//        waysToStep(1000000);
//        massage(new int[]{1, 2, 3, 1});
        maxProfit1(new int[]{1,2,3,4,5});
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null)
            return 0;
        if (prices.length <= 1)
            return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - min;
            if (temp > res) {
                res = temp;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return res;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     * <p>
     * 输入：nums = [-100000]
     * 输出：-100000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
   /* public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int res = Integer.MIN_VALUE;
        int preSum = 0;
        int currentSum = 0;
        for (int num : nums) {
            if (preSum < 0)
                preSum = 0;
            currentSum = preSum + num;
            preSum = currentSum;
            if (currentSum > res)
                res = currentSum;
        }
        return res;
    }*/
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        /*int[] memoNums = new int[n + 1];
        return climbStairsDG(n, memoNums);*/
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int climbStairsDG(int n, int[] memoNums) {
        if (memoNums[n] > 0)
            return memoNums[n];
        if (n == 1)
            memoNums[n] = 1;
        else if (n == 2)
            memoNums[n] = 2;
        else {
            memoNums[n] = climbStairsDG(n - 1, memoNums) + climbStairsDG(n - 2, memoNums);
        }
        return memoNums[n];
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        res.add(list1);
        if (numRows == 1)
            return res;
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        res.add(list2);
        if (numRows == 2)
            return res;
        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> list = res.get(i - 1);
            temp.add(1);
            for (int j = 0; j < list.size() / 2; j++) {
                temp.add(list.get(j) + list.get(j + 1));
            }
            List<Integer> tempReverse = new ArrayList<>();
            if (i % 2 == 0) {
                tempReverse.addAll(temp.subList(0, i - i / 2));
            } else {
                tempReverse.addAll(temp);
            }
            Collections.reverse(tempReverse);
            temp.addAll(tempReverse);
            res.add(temp);
        }
        return res;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> generate = generate(rowIndex);

        return generate.get(rowIndex - 1);
    }


    /**
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     * <p>
     * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
     * <p>
     * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：cost = [10, 15, 20]
     * 输出：15
     * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
     *  示例 2：
     * <p>
     * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出：6
     * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/GzCJIP
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; // 到达第一节为0
        dp[1] = 0; // 到达第二节为0
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }


    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }


    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * <p>
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     * <p>
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     * <p>
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        if (n == 0)
            return 0;
        dp[0] = 0;
        if (n == 1)
            return 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：2
     * 输出：true
     * 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * 示例 2：
     * <p>
     * 输入：3
     * 输出：false
     * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divisor-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    /**
     * 泰波那契序列 Tn 定义如下： 
     * <p>
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * <p>
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 4
     * 输出：4
     * 解释：
     * T_3 = 0 + 1 + 1 = 2
     * T_4 = 1 + 1 + 2 = 4
     * 示例 2：
     * <p>
     * 输入：n = 25
     * 输出：1389537
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        if (n == 0)
            return 0;
        dp[0] = 0;
        if (n == 1)
            return 1;
        dp[1] = 1;
        if (n == 2)
            return 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     * <p>
     * 输入：n = 0
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        if (n == 0)
            return 1;
        dp[0] = 1;
        if (n == 1)
            return 1;
        dp[1] = 1;
        if (n == 2)
            return 2;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 进阶：
     * <p>
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     * <p>
     * 致谢：
     * <p>
     * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：s = "axc", t = "ahbgdc"
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == n;
    }

    /**
     * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     * <p>
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     * 返回生成数组 nums 中的 最大 值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 7
     * 输出：3
     * 解释：根据规则：
     * nums[0] = 0
     * nums[1] = 1
     * nums[(1 * 2) = 2] = nums[1] = 1
     * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
     * nums[(2 * 2) = 4] = nums[2] = 1
     * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
     * nums[(3 * 2) = 6] = nums[3] = 2
     * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
     * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
     * 示例 2：
     * <p>
     * 输入：n = 2
     * 输出：1
     * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
     * 示例 3：
     * <p>
     * 输入：n = 3
     * 输出：2
     * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int getMaximumGenerated(int n) {
        int[] dp = new int[n + 1];
        if (n == 0)
            return 0;
        dp[0] = 0;
        if (n == 1)
            return 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[(i - 1) / 2] + dp[(i - 1) / 2 + 1];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     * <p>
     * 示例1:
     * <p>
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     * 示例2:
     * <p>
     * 输入：n = 5
     * 输出：13
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int waysToStep(int n) {
        final int MOD = 1000000007;
        long[] dp = new long[n + 1];
        if (n == 0)
            return 1;
        dp[0] = 1;
        if (n == 1)
            return 1;
        dp[1] = 1;
        if (n == 2)
            return 2;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD;
        }
        return (int) dp[n];
    }

    /**
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     * <p>
     * 注意：本题相对原题稍作改动
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入： [1,2,3,1]
     * 输出： 4
     * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
     * 示例 2：
     * <p>
     * 输入： [2,7,9,3,1]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
     * 示例 3：
     * <p>
     * 输入： [2,1,4,5,3,1,1,3]
     * 输出： 12
     * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        dp[0] = nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * <p>
     * 输入: prices = [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: prices = [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public static int  maxProfit1(int[] prices) {
        int[] dp = new int[prices.length];
        if (prices.length == 1)
            return 0;
        dp[0] = 0;
        if (prices.length == 2)
            return prices[0] >= prices[1] ? 0 : prices[1] - prices[0];
        dp[1] = prices[0] >= prices[1] ? 0 : prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - prices[i - 1], 0);
        }
        return Arrays.stream(dp).sum();

    }


}
