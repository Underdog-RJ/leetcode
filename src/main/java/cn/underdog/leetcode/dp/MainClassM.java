package cn.underdog.leetcode.dp;

import cn.underdog.leetcode.entity.TreeNode;

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
//        longestSubsequence(new int[]{1, 2, 3, 4}, 1);
        MainClassM m = new MainClassM();


//        System.out.println(m.maxProduct(new int[]{-2, 3, -4, -5}));
        System.out.println(m.maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println(m.coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(m.coinChange(new int[]{2}, 3));
//        System.out.println(m.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//        System.out.println(m.minFallingPathSum(new int[][]{{17, 82}, {1, -44}}));
//        m.canPartition(new int[]{1, 5, 11, 5});
//        m.canPartition(new int[]{1, 1, 2, 2});
//        System.out.println(m.canPartition(new int[]{2, 2, 3, 5}));
//        m.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
//        m.findTargetSumWays(new int[]{1}, 1);
//        System.out.println(m.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
//        System.out.println(m.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        m.change(3, new int[]{1, 2, 3});
//        m.numSquares(12);
//        String[] strs = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
//        List<String> strings = new ArrayList<>();
//        strings.add("leet");
//        strings.add("code");
//        List<String> strings1 = Arrays.asList(strs);
//
//        m.wordBreak("leetcode", strings);
//        m.rob2(new int[]{1, 2, 3, 1});
//        TreeNode treeNode = new TreeNode(4);
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode.left = treeNode1;
//        treeNode1.left = treeNode2;
//        treeNode2.left = treeNode3;
//        m.rob3(treeNode);
//        m.maxProfit4_3(2, new int[]{3, 2, 6, 5, 0, 3});
//        m.lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
//        m.findLength_1(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0});
//        m.isSubsequence("abc", "ahbgdc");
//        m.minDistance_1("sea", "eat");
//        m.countSubstrings_1("aaa");
//        m.longestPalindrome("babad");
//        m.minDistance_2("horse", "ros");
//        List<Integer> list = new ArrayList(List.of(2));
//        List<Integer> list1 = new ArrayList(List.of(3, 4));
//        List<Integer> list2 = new ArrayList(List.of(6, 5, 7));
//        List<Integer> list3 = new ArrayList(List.of(4, 1, 8, 7));
//        List<List<Integer>> r = new ArrayList<>(List.of(list, list1, list2, list3));
//        m.minimumTotal(r);
//        m.minCost(new int[][]{{7, 6, 2}});
        m.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
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
        Map<Integer, Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param coins
     * @param amount
     * @return
     */
    // 递归写发，记忆化搜索+贪心
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    /*public int coinChange(int[] coins, int amount) {
        return dpCointChange(coins, amount);
    }
    private int dpCointChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (hashMap.containsKey(amount))
            return hashMap.get(amount);
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int change = dpCointChange(coins, amount - coin);
            if (change == -1)
                continue;
            res = Math.min(res, change++);
        }
        if (res == Integer.MAX_VALUE) {
            hashMap.put(amount, -1);
        } else {
            hashMap.put(amount, res);
        }
        return hashMap.get(amount);
    }*/
    /*public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        if (amount == 0)
            return 0;
        for (int i = 1; i < dp.length; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                int num = dp[i - coin];
                if (num != -1) {
                    tmp = Math.min(tmp, num + 1);
                }
            }
            dp[i] = tmp == Integer.MAX_VALUE ? -1 : tmp;
        }
        return dp[dp.length - 1];
    }*/

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    // 定义dp[i]是每个nums[i]结尾的的结果，所以dp[0] =1
    /*public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    num = Math.max(num, dp[j] + 1);
                }
            }
            dp[i] = num;
        }
        return Arrays.stream(dp).max().getAsInt();
    }*/
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            // dfs，返回当前以i结尾的最大值
            int tmp = dfsLengthOfLIS(nums, i, dp);
            max = Math.max(max, tmp);
        }
        return max;
    }

    private int dfsLengthOfLIS(int[] nums, int i, int[] dp) {
        // 记忆化搜索
        if (dp[i] != 0)
            return dp[i];
        int tmp = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                tmp = Math.max(tmp, dp[j] + 1);
            }
        }
        dp[i] = tmp;
        return dp[i];
    }

    /**
     * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
     * <p>
     * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
     * 输出：13
     * 解释：如图所示，为和最小的两条下降路径
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：matrix = [[-19,57],[-40,-5]]
     * 输出：-59
     * 解释：如图所示，为和最小的下降路径
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        // 初始化dp的值
        int[][] dp = new int[length][length];
        int[] tmps = matrix[0];
        for (int i = 0; i < tmps.length; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < length; i++) {
            int num1 = i - 1;
            for (int j = 0; j < length; j++) {
                // 定义三个方向
                int num2 = j - 1;
                int num3 = j;
                int num4 = j + 1;
                // 定义三个点
                int point1 = Integer.MAX_VALUE;
                int point2 = 0;
                int point3 = Integer.MAX_VALUE;
                if (num2 >= 0) {
                    point1 = dp[num1][num2];
                }
                point2 = dp[num1][num3];
                if (num4 < length) {
                    point3 = dp[num1][num4];
                }
                dp[i][j] = matrix[i][j] + Math.min(point1, Math.min(point2, point3));
            }
        }
        int[] ints = dp[length - 1];
        return Arrays.stream(ints).min().getAsInt();

    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     * <p>
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     * <p>
     * 输入：m = 3, n = 3
     * 输出：6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // dp为每个点的路径总数，每个状态都有两个可以到达，下，右
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 定义dp为到达(i,j)位置的路径方案，如果此路不通用最大值标识
        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < colLength; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < rowLength; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                // 如果两点都不是障碍物
                if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return obstacleGrid[0][0] == 1 ? 0 : obstacleGrid[rowLength - 1][colLength - 1] == 1 ? 0 : dp[rowLength - 1][colLength - 1];

    }

    /**
     * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * <p>
     * 返回 你可以获得的最大乘积 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     * 示例 2:
     * <p>
     * 输入: n = 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 贪心
     *
     * @param n
     * @return
     */
    /*public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        if (n == 4)
            return 4;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }

        return res * n;

    }*/
    public int integerBreak(int n) {
        // dp定义为每个i的最大值， 当前状态需要   === 》》 需要2-n-1的全部状态，  每次状态全部模拟出来
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }


        return dp[n];
    }

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 3
     * 输出：5
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：1
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // dp定义为当前状态的不同二叉树的总数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 枚举左孩子和右孩子的成绩
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


    /*public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1)
            return false;
        int target = sum / 2;
        // 定义dp[j]表示，容量为j的背包当前所能容纳的最大重量，如果dp[target] == target 则表明可以装的下
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) return true;
        return false;
    }
*/

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1)
            return false;
        int target = sum / 2;
        // 定义dp[i][j]表示，从(0-i)里面挑选一个，所能得到的最大的价格
        int[][] dp = new int[nums.length][target + 1];
        // 进行初始化，对于第一个商品来说，判断当前能否放得下
        for (int i = 0; i <= target; i++) {
            dp[0][i] = i >= nums[0] ? nums[0] : 0;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
            }
        }
        if (dp[nums.length - 1][target] == target) return true;
        return false;
    }

   /* Set<Integer> set = new HashSet<>();
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1)
            return false;
        Arrays.sort(nums);
        int half = sum / 2;
        return backtrackingCanPartition(nums, half, 0);
    }

    private boolean backtrackingCanPartition(int[] nums, int cntTotal, int startIndex) {
        if (cntTotal == 0)
            return true;
        if (cntTotal < 0)
            return false;
        for (int i = startIndex; i < nums.length && cntTotal - nums[i] >= 0; i++) {
            boolean flag = backtrackingCanPartition(nums, cntTotal - nums[i], i + 1);
            if (flag)
                return true;

        }

        return false;
    }*/


    /**
     * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
     * <p>
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * <p>
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：stones = [2,7,4,1,8,1]
     * 输出：1
     * 解释：
     * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
     * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
     * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
     * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
     * 示例 2：
     * <p>
     * 输入：stones = [31,26,33,21,40]
     * 输出：5
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }


    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     * <p>
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     * <p>
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3 。
     * -1 + 1 + 1 + 1 + 1 = 3
     * +1 - 1 + 1 + 1 + 1 = 3
     * +1 + 1 - 1 + 1 + 1 = 3
     * +1 + 1 + 1 - 1 + 1 = 3
     * +1 + 1 + 1 + 1 - 1 = 3
     * 示例 2：
     * <p>
     * 输入：nums = [1], target = 1
     * 输出：1
     * 求目标和
     * LeftSum - RightSum = Target  (1)
     * LeftSum + RightSum = TotalSum (2) ====>>>>  RightSum = TotalSum - LeftSum
     * LeftSum  = (TotalSum+Target) / 2
     * 转换为 求组合为LeftSum的值
     * 方法一：回溯方法
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/target-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    /*int totalTargetSumWays = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int TotalSum = Arrays.stream(nums).sum();
        if (target > TotalSum) return 0;
        if ((TotalSum + target) % 2 == 1) return 0;
        int LeftSum = (TotalSum + target) / 2;
        Arrays.sort(nums);
        backtrackingFindTargetSumWays(nums, LeftSum, 0, 0);
        return totalTargetSumWays;
    }
    private void backtrackingFindTargetSumWays(int[] nums, int leftSum, int cntSum, int startIndex) {
        // 如果当前找到一个
        if (cntSum == leftSum) {
            totalTargetSumWays++;
        }
        for (int i = startIndex; i < nums.length; i++) {
            cntSum += nums[i];
            backtrackingFindTargetSumWays(nums, leftSum, cntSum, i + 1);
            cntSum -= nums[i];
        }
    }*/

    /**
     * dp方法  二维数组
     * X 代表证数  Y代表负数
     * X+Y=Sum ==>> Y =Sum -X
     * 所以我们所求的目标转换为 找到一个正数和  以及 负数和 =target
     * 则 X - (Sum-X) = target
     * X=(Sum+target)/2
     *
     * @param nums
     * @param target
     * @return
     */
   /* public int findTargetSumWays(int[] nums, int target) {
        int TotalSum = Arrays.stream(nums).sum();
        if (target > TotalSum) return 0;
        if ((TotalSum + target) % 2 == 1) return 0;
        int LeftSum = (TotalSum + target) / 2;
        if (LeftSum < 0)
            return 0;
        // 定义dp[i][j]为  物品(0-i)在容量j的情况下有多少种组成方案
        int[][] dp = new int[nums.length][LeftSum + 1];
        *//* 对于每个具体的状态dp[i][j]来说，
        有两种状态，能选或者不能选择，当背包容量大于nums[i]是可以选择，反之不能
        j>=nums[i]时dp[i][j] = dp[i-1][j] (不选择当前元素，前面有多少个组成方案，)+dp[i-1][j-nums[i]] （选择当前元素时，应该用当前总容量-当前的容量 ps:保持总容量不变当加上当前元素时）
        j<nums[i]时dp[i][j] = dp[i-1][j]
         *//*
     *//**
     * 进行初始化状态 当背包容量为0时，则每个物品来说都是1都是不选择才能达到
     *  如果nums[0] == 0 对于第一个物品有两种可能，选择为0不选择也为0
     *  当nums[0] !=0时，还需要把dp[0][num[0]] =1
     *//*
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if (nums[0] <= LeftSum) {
                dp[0][nums[0]] = 1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= LeftSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) dp[i][j] += dp[i - 1][j - nums[i]];
            }
        }
        return dp[nums.length - 1][LeftSum];

    }*/

    /**
     * 滚动数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int TotalSum = Arrays.stream(nums).sum();
        if (target > TotalSum) return 0;
        if ((TotalSum + target) % 2 == 1) return 0;
        int LeftSum = (TotalSum + target) / 2;
        if (LeftSum < 0)
            return 0;
        // 定义dp[j] 为容量为j的背包的容量大小有多少种组成方案
        int[] dp = new int[LeftSum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = LeftSum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[LeftSum];
    }


    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * <p>
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     * <p>
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     * 示例 2：
     * <p>
     * 输入：strs = ["10", "0", "1"], m = 1, n = 1
     * 输出：2
     * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 代表最多有i个0j 个1的最大子集时dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zeroNum = 0;
            int oneNum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    zeroNum++;
                else
                    oneNum++;
            }
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
    // ======================================完全背包===============================

    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * <p>
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * <p>
     * 假设每一种面额的硬币有无限个。 
     * <p>
     * 题目数据保证结果符合 32 位带符号整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：amount = 5, coins = [1, 2, 5]
     * 输出：4
     * 解释：有四种方式可以凑成总金额：
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     * 示例 2：
     * <p>
     * 输入：amount = 3, coins = [2]
     * 输出：0
     * 解释：只用面额 2 的硬币不能凑成总金额 3 。
     * 示例 3：
     * <p>
     * 输入：amount = 10, coins = [10]
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change-2
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param amount
     * @param coins
     * @return
     */
    /*public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                // 获取当前
                int coin = coins[i - 1];
                int tmp = j / coin;
                for (int t = 0; t <= tmp; t++) {
                    dp[i][j] += dp[i - 1][j - t * coin];
                }
            }
        }
        return dp[coins.length][amount];
    }*/
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /**
     * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     * <p>
     * 题目数据保证答案符合 32 位整数范围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * 示例 2：
     * <p>
     * 输入：nums = [9], target = 3
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        // 定义dp[i]为容量为i 的背包有多少种排列方式
        long[] dp = new long[target + 1];
        // 初始化dp
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) dp[i] += dp[i - nums[j]];
            }
        }
        return (int) dp[target];
    }

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/coin-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * 示例 2：
     * <p>
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {

        int cap = (int) Math.sqrt(n);
        int[] prices = new int[cap];
        for (int i = 0; i < cap; i++) {
            prices[i] = (int) Math.pow(i + 1, 2);
        }
        // 定义dp[i]为组成背包为I的最少需要的完全平方数的个数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = prices[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - prices[i]] + 1);
            }
        }

        return dp[n];

    }


    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     * <p>
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     * <p>
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     *      注意，你可以重复使用字典中的单词。
     * 示例 3：
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/word-break
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param wordDict
     * @return
     */
    // 记忆化搜索+回溯
  /*  public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] flags = new boolean[s.length()];
        return backtrackingWordBreak(s, set, 0, flags);
    }

    private boolean backtrackingWordBreak(String s, Set<String> set, int startIndex, boolean[] flags) {
        if (startIndex >= s.length())
            return true;
        if (flags[startIndex])
            return false;
        for (int i = startIndex; i < s.length(); i++) {
            // 获取当前层str
            String str = s.substring(startIndex, i + 1);
            if (!set.contains(str))
                continue;
            boolean res = backtrackingWordBreak(s, set, i + 1, flags);
            if (res)
                return true;
        }
        flags[startIndex] = true;
        return false;
    }*/

    /**
     * 给定一个东西，求能否用给出的零件组成/组成方案/组成的最小数量===》》》转换为背包问题
     * 因为字符无限量的使用，转换为背包问题
     * 字符串长度为背包容量
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        // dp[i] 的含义为 长度为i的字符串，能否被给出的wordWict组成 false不能，true可以组成
        boolean[] dp = new boolean[s.length() + 1];
        // 初始化dp[0] =true 长度为0的字符串一定可以组成
        dp[0] = true;
        // dp的每个状态可以有(0-i)组成
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(dp[s.length()]);
        return dp[s.length()];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        /**
         *         dp定义为当前位置的最大金额，对于每个位置有两种选择，
         *          偷  dp[i] = nums[i]+dp[i-2]
         *          不偷 dp[i] = dp[i-1]
         *          则状态转移方程dp[i] = max (dp[i-1],nums[i]+dp[i-2])
         *          初始化，dp[0] = nums[0],dp[1] = max (nums[0],num[1])因为需要用到i-2初始化2个，第一个位置一定不能偷，第二个位置选择前2个最大的
         *          遍历顺序：正序遍历，因为时顺序方向找最大值
         *
         */
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        if (length == 1)
            return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (length == 2)
            return dp[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：3
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        /**
         * 用一个二维数组记录选择0和不选择0的情况，其他和上面情况一样
         */
        int length = nums.length;
        if (length == 1)
            return nums[0];
        if (length == 2)
            return Math.max(nums[0], nums[1]);
        int[][] dp = new int[length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(nums[0], nums[1]);
        dp[1][1] = nums[1];
        for (int i = 2; i < length; i++) {
            if (i != length - 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            }

        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }

    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
     * <p>
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * <p>
     * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: root = [3,2,3,null,3,null,1]
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
     * 示例 2:
     * <p>
     * <p>
     * <p>
     * 输入: root = [3,4,5,1,3,null,1]
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    /**
     * dp用数组返回当前节点的偷或者不偷的最大值
     * 如果当前节点偷：那么对于左右子树，都必须选择不偷的状态
     * 如果当前节点不偷：那么对于左右子树，选择偷或不偷的最大值
     *
     * @param root
     * @return
     */
    // dp
    public int rob3(TreeNode root) {
        int[] res = dfsRob3(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfsRob3(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            int rootVal = root.val;
            int[] lInts = dfsRob3(root.left);
            int[] rInts = dfsRob3(root.right);
            return new int[]{rootVal + lInts[1] + rInts[1], Math.max(lInts[0], lInts[1]) + Math.max(rInts[0], rInts[1])};
        }
    }

    // 暴力dfs
    public int rob4(TreeNode root) {
        if (root == null)
            return 0;
        int memory = root.val;
        int num1 = 0;
        int num2 = 0;
        if (root.left != null) {
            num1 = rob4(root.left.left) + rob4(root.left.right);
        }
        if (root.right != null) {
            num2 = rob4(root.right.left) + rob4(root.right.right);
        }
        int tmp1 = rob4(root.left);
        int tmp2 = rob4(root.right);
        // 当前节点选择+左右孩子的子孩子的值与左右孩子的值的和的最大值
        return Math.max(memory + num1 + num2, tmp1 + tmp2);
    }

    /**
     * dfs+记忆化
     * 对于当前节点，需要遍历孩子节点和孙子节点，然会返回最大值，存在重复遍历问题，我们可以用hashMap来存储当前的值，如果存在直接返回
     *
     * @param root
     * @return
     */
    public int rob5(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return dfsRob5(map, root);
    }

    private int dfsRob5(HashMap<TreeNode, Integer> map, TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int memory = root.val;
        if (root.left != null) {
            memory += dfsRob5(map, root.left.left) + dfsRob5(map, root.left.right);
        }
        if (root.right != null) {
            memory += dfsRob5(map, root.right.left) + dfsRob5(map, root.right.right);
        }
        int left = dfsRob5(map, root.left);
        int right = dfsRob5(map, root.right);
        int tmpMax = Math.max(memory, left + right);
        map.put(root, tmpMax);
        return tmpMax;
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
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    // 贪心，找到已经出现的最小值
    /*public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                maxValue = Math.max(maxValue, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        return maxValue;
    }*/

    /**
     * 1.dp定义
     * dp[i][0] 代表第i天 持有股票需要的最大价格
     * dp[i][1] 代表第i天不持有股票需要的最大价格
     * 2.递推公式。
     * 每个状态dp[i][0]有之前的两个方面推出来
     * dp[i][0]（持有股票）第i-1天持有股票(dp[i][0]=dp[i-1])第i天买入(dp[i][0] = -nums[i])
     * 所以dp[i][0] = max(dp[i-1][0],-nums[i])
     * 每个状态dp[i][1]有之前的两个方面推出来
     * dp[i][1](不持有股票）第i-1天 不持有股票dp[i][1] = dp[i-1][1] 第i天卖出dp[i][1] = dp[i-1][0] + nums[i]
     * 所以dp[i][1] = max(dp[i-1][1],nums[i]+dp[i-1][0]
     * 3.初始化
     * 有递推公式的都需要dp[i-1]的状态===>需要dp[0][0],dp[0][1]
     * 第一天持有股票需要的价格为dp[0][0] = -nums[0],dp[0][1] = 0
     * 4.遍历顺序
     * 需要从前往后一次遍历
     * 思路为二维数组
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }

    public int maxProfit1_1(int[] prices) {
        int length = prices.length;
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);

        }
        return dp[1];
    }

    /**
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     *
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     *
     * 返回 你能获得的 最大 利润 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      总利润为 4 。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    /**
     * 本题，可以参与多次交易，累计交易的最大值
     * 再持有股票的是否，递推公式的变化
     * 第dp[i][0]  第i-1天可能已经持有，第i天买入，当第i天买入的是否对于一次交易来说，最多只能拥有一次，而本次可能之前有余额
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[length - 1][1];
    }

    public int maxProfit2_2(int[] prices) {
        int length = prices.length;
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     * 示例 4：
     *
     * 输入：prices = [1]
     * 输出：0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    /**
     * 思路：我们本题最多可以操作2次交易：表示可以有
     * 0   0次买入
     * 1   1次买入
     * 2   1次卖出
     * 3   2次买入
     * 4   2次卖出
     * 1.dpTable的定义dp[i][j]的定义为，第i天要达到状态j所剩最大现金
     * 2.递推公式
     * 所以说要达到
     * dp[i][1] 可以有两种方案
     * 1.第i天买入股票dp[i][1] = dp[i-1][0] - prices[i]
     * 2.第i天和之前保持一致没有操作 dp[i][1] = dp[i-1][1]
     * 则每次选择最大的最大的剩下的现金
     * dp[i][2] 有2中方案
     * 1.第i天卖出股票dp[i][2] = dp[i-1][1] + prices[i]
     * 2.第i天没有操作和之前保持一致 dp[i][2] = dp[i-1][2]
     * dp[i][3] 有2中方案
     * 1.第i天买入股票dp[i][3] =dp[i-1][2] - prices[1]
     * 2.第i天和之前保持一致dp[i][3] = dp[i-1][3]
     * dp[i][4] 有2中方案
     * 1.第i天卖出股票dp[i][4] = dp[i-1][3] + prices[i]
     * 2.第i天没有操作和之前保持一致dp[i][4] = dp[i-1][4]
     * 3.初始化操作
     * dp[0][0] = 0 (对于0次买入一定是没有剩余现金)
     * dp[0][1]  = -prices[0] （第一次买入，应该是花费当前0号元素的的价格）
     * dp[0][2]  = 0 第一次卖出也是0
     * dp[0][3]  = -prices[0] （第二次买入依赖于第一次卖出的价格（其为0）,所以也应该-prices[0]）
     * dp[0][4] = 0 第二次卖出也是0
     * *
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[length - 1][4];

    }

    public int maxProfit3_3(int[] prices) {
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[3], dp[3] + prices[i]);
        }
        return dp[4];
    }

    /**
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * 示例 2：
     *
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param k
     * @param prices
     * @return
     */
    /**
     * 最多有k次交易，则一共有2*k+1个状态
     * 1.dp Table的定义为dp[i][j] 第i天状态j最大的利润 假设k=2
     * dp[1][0]代表第一天的第0次买入
     * dp[1][1]代表第一天的第一次买入
     * dp[1][2]代表第一天的第一次卖出
     * dp[1][3]代表第一天的第二次买入
     * dp[1][4]代表第一天的第二次卖出
     * 分析知道，除了0之外，j为奇数是买入，偶数是卖出
     * 2.递推公式
     * dp[i][1] 可以有两种方案
     * 1.第i天买入股票dp[i][1] = dp[i-1][0] - prices[i]
     * 2.第i天和之前保持一致没有操作 dp[i][1] = dp[i-1][1]
     * 则每次选择最大的最大的剩下的现金
     * dp[i][2] 有2中方案
     * 1.第i天卖出股票dp[i][2] = dp[i-1][1] + prices[i]
     * 2.第i天没有操作和之前保持一致 dp[i][2] = dp[i-1][2]
     * dp[i][3] 有2中方案
     * 1.第i天买入股票dp[i][3] =dp[i-1][2] - prices[1]
     * 2.第i天和之前保持一致dp[i][3] = dp[i-1][3]
     * dp[i][4] 有2中方案
     * 1.第i天卖出股票dp[i][4] = dp[i-1][3] + prices[i]
     * 2.第i天没有操作和之前保持一致dp[i][4] = dp[i-1][4]
     * 所以递推到k
     * dp[i]
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit4(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2 * k + 1];
        for (int i = 0; i < 2 * k + 1; i++) {
            dp[0][i] = (i & 1) == 1 ? -prices[0] : 0;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if ((j & 1) == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[length - 1][2 * k];
    }

    public int maxProfit4_2(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int length = prices.length;
        int[] dp = new int[2 * k + 1];
        for (int i = 0; i < 2 * k + 1; i++)
            dp[i] = (i & 1) == 1 ? -prices[0] : 0;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < 2 * k + 1; j++)
                dp[j] = Math.max(dp[j], (j & 1) == 1 ? dp[j - 1] - prices[i] : dp[j - 1] + prices[i]);
        }
        return dp[2 * k];
    }

    public int maxProfit4_3(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        int length = prices.length;
        // 第i天第j才操作的买入和卖出情况
        int[][][] dp = new int[length][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] - prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
            }
        }
        return dp[length - 1][k][1];
    }

    /**
     * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: prices = [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * 示例 2:
     *
     * 输入: prices = [1]
     * 输出: 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */

    /**
     * 对于本题，加入了冷静期我们可以可以分析为拥有4个状态
     * 状态一：买入股票的状态(今天买入股票或者之间已经买入股票没有操作)
     * 卖出股票的状态，这里有2中卖出股票的状态
     * 状态二：前两天就卖出了股票，度过了冷静期，一直没有操作，直到今天卖出股票的状态
     * 状态三：今天卖出股票
     * 状态四：今天为冷冻状态，但是今天不可以持续，只有一天。
     * 定义j的状态为
     * 0状态1
     * 1状态2
     * 2状态3
     * 3状态4
     * 2.递推公式
     * 达到买入股票的状态（状态一）即dp[i][0] 有两个操作
     * 操作一：前一天就持有状态（状态一）dp[i][0] = dp[i-1][0]
     * 操作二，今天买入了有两种情况
     * 前一天是冷冻期（状态四），dp[i][0] = dp[i-1][3]-prices[i]
     * 前一天是卖出状态(状态二) dp[i][0] = dp[i-1][1] - prices[i]
     * 三者去最大值
     * 达到卖出的股票的状态二即dp[i][1]
     * 前一天是状态二 dp[i][1] = dp[i-1][1]（距离冷冻期间2天以上）
     * 前一天是状态四 dp[i][1] = dp[i-1][3]（昨天为冷冻期)
     * 两者取最大值
     * 要达到状态三 即dp[i][2]
     * 只有一种可能，前一天是买入状态dp[i][2] = dp[[i-1][0] +prices[i]
     * 要达到状态四即dp[i][3]
     * 只有一种可能，前一天是买入状态
     * dp[i][3] = dp[i][2](昨天卖出了股票)
     * 3.初始化
     * dp[0][0] = -prices[0]
     * dp[0][1] = 0
     * dp[0][2] = 0
     * dp[0][3] = 0
     * qiqi    * @param prices
     * 4.b遍历顺序
     * dp[i] 依赖于dp[i-1]顺序遍历
     *
     * @return
     */
    public int maxProfit5(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Arrays.stream(dp[length - 1]).max().getAsInt();
    }


    /**
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     * <p>
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * <p>
     * 返回获得利润的最大值。
     * <p>
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出：8
     * 解释：能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
     * 示例 2：
     * <p>
     * 输入：prices = [1,3,7,5,10,3], fee = 3
     * 输出：6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit6(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[length - 1][1];
    }

    public int maxProfit6_2(int[] prices, int fee) {
        int length = prices.length;
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }
        return dp[1];
    }

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * 1.定义dp为以i结尾的最常递增子序列的长度
     * 2.递推公式
     * dp[i] 和（0-i）都有关，dp[i] = 如果大于max(dp[i],dp[j]+1);
     * 3.初始化
     * dp[0] = 1 最开始的递增子序列一定为1
     * 4.遍历顺序
     * dp[i] 和dp[i-1]有关所以顺序遍历
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
     * <p>
     * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,5,4,7]
     * 输出：3
     * 解释：最长连续递增序列是 [1,3,5], 长度为3。
     * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,2,2]
     * 输出：1
     * 解释：最长连续递增序列是 [2], 长度为1。
     * 1.定义dp[i]为以i为结尾最长的递增子序列
     * 2.递推公式
     * dp[i]如果nums[i]>nums[i-1] dp[i] = dp[i-1]+1
     * else dp[i] = 1
     * 3.初始化
     * dp[0] =1 最开始长度为1
     * 4.遍历顺序
     * dp[i] 和dp[i-1]有关。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findLengthOfLCIS_1(int[] nums) {
        int length = nums.length;
        int pre = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, ++pre);
            } else {
                pre = 1;
            }
        }
        return max;
    }

    /**
     * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
     * 输出：3
     * 解释：长度最长的公共子数组是 [3,2,1] 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
     * 输出：5
     * 1.定义dp[i][j] 为nums1以i-1结尾nums2以j-1结尾的最长公共子数组的长度
     * 2.递推公式
     * 如果num1[i-1]==num2[j-1] dp[i][j] = dp[i-1][j-1]
     * 3.初始化
     * 全部都为0
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-length-of-repeated-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        int max = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    /**
     * 把二维数组降维成一维数组，此时需要逆序遍历，避免重复计算
     *
     * @param nums1
     * @param nums2
     * @return
     */
//    TODO滑动窗口，思路还没看
    public int findLength_1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] dp = new int[length2 + 1];
        int max = 0;
        for (int i = 1; i <= length1; i++) {
            for (int j = length2; j >= 1; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * <p>
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * <p>
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     * 示例 2：
     * <p>
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     * 示例 3：
     * <p>
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-common-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 1.定义dp[i][j]为text1中以i-1结尾text2中以j-1结尾的最长公共子序列
     * 2.递推公式
     * 如果texts[i]=text2[j] 相等说明找到一个，则 dp[i][j] = dp[i-1][j-1]+1
     * 如果texts[i]!=text2[j] 找到dp[i][j-1]和dp[i-1][j]在最大的值
     * 3.初始化
     * 全部为0
     * 4.遍历顺序
     * dp[i][j]依赖于dp[i-1][j-1]
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2];
    }

    /**
     * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     * <p>
     * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
     * <p>
     *  nums1[i] == nums2[j]
     * 且绘制的直线不与任何其他连线（非水平线）相交。
     * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     * <p>
     * 以这种方法绘制线条，并返回可以绘制的最大连线数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
     * 输出：2
     * 解释：可以画出两条不交叉的线，如上图所示。
     * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
     * 示例 2：
     * <p>
     * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
     * 输出：3
     * 示例 3：
     * <p>
     * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
     * 输出：2
     * <p>
     * 对于数组1来说取1,4在数组2中出现的顺序也是1,4求两者的公共子序列
     * 和上一题一样
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/uncrossed-lines
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[length1][length2];
    }


    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
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
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     * 1.定义dp[i]为以i结尾的最长子数组的和
     * 2.递推公式
     * 如果前一个子数组的和<0则当前+0否则添加前一个的连续和
     * 3.初始化dp[0] = nums[0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray_1(int[] nums) {
        int length = nums.length;
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (pre > 0) {
                max = Math.max(max, nums[i] + pre);
                pre = nums[i] + pre;
            } else {
                pre = nums[i];
                max = Math.max(max, nums[i]);
            }
        }
        return max;
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
     * 链接：https://leetcode.cn/problems/is-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 用最长公共子序列判断是否相等即可
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length1][length2] == length1;
    }

    /**
     * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     * <p>
     * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     * <p>
     * 题目数据保证答案符合 32 位带符号整数范围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "rabbbit", t = "rabbit"
     * 输出：3
     * 解释：
     * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
     * rabbbit
     * rabbbit
     * rabbbit
     * 示例 2：
     * <p>
     * 输入：s = "babgbag", t = "bag"
     * 输出：5
     * 解释：
     * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     * babgbag
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/distinct-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    /**
     * 1.dp[i][j]定义为以s中以i-1结尾在t中以j-1结尾有多少种组成方案
     * 2.递推公式
     * 如果s[i-1]==t[j-1]可以有
     * dp[i][j] = dp[i-1][j-1] +dp[i-1][j]推出来
     * dp[i-1][j-1]为
     *
     * @param s
     * @param t
     * @return
     */
//    TODO 思路不清晰
    public int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length1][length2];
    }

    /**
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     * <p>
     * 每步 可以删除任意一个字符串中的一个字符。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     * 示例  2:
     * <p>
     * 输入：word1 = "leetcode", word2 = "etco"
     * 输出：4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/delete-operation-for-two-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return length1 + length2 - dp[length1][length2] * 2;

    }

    /**
     * 1.dp[i-1][j-1]为满足word中i-1和word2中j-1相同的最少步数
     * 2.递推公式
     * 如果word1.chartAt(i-1)==word.chartAt(j-1)则两个相同所以本次可以从dp[i-1][j-1]中过来
     * 如果不相同
     * dp[i][j]可以从3方面过来 ==
     * 从dp[i-1][j-1]过来需要多加2,
     * 从dp[i-1][j]中过来多添加1
     * 从dp[i][j-1]中过来多添加1
     * 三者取最小值
     * 3.初始化
     * 对于dp[0][0-j] = j 最少的 0个，j个 需要J个
     * 对于dp[0-i][0] = i 最少的 0个，i个 需要I个
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_1(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int num1 = dp[i - 1][j - 1] + 2;
                    int num2 = dp[i][j - 1] + 1;
                    int num3 = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(num1, Math.min(num2, num3));
                }
            }
        }
        return dp[length1][length2];

    }

    /**
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * <p>
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * <p>
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * <p>
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/palindromic-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    // 暴力方法
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (isValid(str)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isValid(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    /**
     * 1.dp[i][j]定义为区间[i-j]内是否是回文串
     * 2.递推公式
     * 如果s[i] ==s[j]
     * 1.如果i==j 则两个相等例如a
     * 2.如果相差1则例如aa
     * 如果一定是回文串直接为true
     * 3.如果相差大于1判断是
     *
     * @param s
     * @return
     */
    public int countSubstrings_1(String s) {
        int length1 = s.length();
        boolean[][] dp = new boolean[length1][length1];
        int results = 0;
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = i; j < length1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j <= 1) {
                        results++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            results++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return results;
    }

    public int countSubstrings_2(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            result += extend(s, i, i, length); // 以i为中心，扩散
            result += extend(s, i, i + 1, length); // 以i+1为中心，扩散
        }
        return result;
    }

    private int extend(String s, int i, int j, int length) {
        int res = 0;
        while (i >= 0 && j < length && s.charAt(i--) == s.charAt(j++))
            res++;
        return res;
    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }

    public String longestPalindrome(String s) {
        String res = "";
        int maxValue = Integer.MIN_VALUE;
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (j - i == 1) {
                        dp[i][j] = 2;
                    } else {
                        if (dp[i + 1][j - 1] != 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                    if (dp[i][j] > maxValue) {
                        res = s.substring(i, j + 1);
                        maxValue = dp[i][j];
                    }
                }
            }
        }
        return res;
    }

    public int minDistance_2(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    String strLongestPalindrome = "";
    int max = -1;

    public String longestPalindrome_1(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            extendLongestPalindrome(s, i, i, length);
            extendLongestPalindrome(s, i, i + 1, length);
        }
        return strLongestPalindrome;
    }

    private void extendLongestPalindrome(String s, int i, int j, int length) {
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            if (j - i > max) {
                max = j - i;
                strLongestPalindrome = s.substring(i, j + 1);
            }
            i--;
            j++;
        }

    }

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }


    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     * <p>
     * 输入：triangle = [[-10]]
     * 输出：-10
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param triangle
     * @return
     */
   /* public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < row; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + list.get(j);
                } else if (j == list.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + list.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + list.get(j);

                }
            }
        }
        return Arrays.stream(dp[row - 1]).min().getAsInt();
    }*/
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[col];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 0; i < row; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = dp[j] + list.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                }
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     * <p>
     * 子数组 是数组的连续子序列。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        // dp[i][0]当前正数的最大值，dp[i][1]为当前负数的最大值
        int[][] dp = new int[length][2];
        if (nums[0] > 0) {
            dp[0][0] = nums[0];
            dp[0][1] = -1;
        } else if (nums[0] < 0) {
            dp[0][0] = 1;
            dp[0][1] = nums[0];
        }
        for (int i = 1; i < length; i++) {
            if (dp[i - 1][0] == 0) {
                if (nums[i] > 0) {
                    dp[i][0] = nums[i];
                    dp[i][1] = -1;
                } else if (nums[i] < 0) {
                    dp[i][0] = 1;
                    dp[i][1] = nums[i];
                }
            }
            if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] * nums[i];
                dp[i][1] = dp[i - 1][1] * nums[i];
            } else if (nums[i] < 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1]);
            }
        }
        return dp[length - 1][0];
    }

    public int minCost(int[][] costs) {
        int length = costs.length;
        int[][] dp = new int[length + 1][3];
        for (int i = 1; i < dp.length; i++) {
            int[] target = costs[i - 1];
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int u = 0; u < 3; u++) {
                    if (j == u)
                        continue;
                    min = Math.min(min, dp[i - 1][u]);
                }
                dp[i][j] = min + target[j];
            }
        }
        return Arrays.stream(dp[length]).min().getAsInt();
    }


}
