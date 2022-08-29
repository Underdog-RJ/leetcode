package cn.underdog.leetcode.dp;

import com.sun.jdi.VMMismatchException;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Practice practice = new Practice();
//        practice.minCostClimbingStairs(new int[]{10, 15, 20});
//        practice.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
//        practice.countTexts("22233");
        practice.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7});
    }


    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            if (prices[i] < min) min = prices[i];
        }
        return res;
    }

    // dp
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    // greedy
    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];
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

//    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i < n; i++)
//            dp[i] = dp[i - 1] + dp[i - 2];
//        return dp[n - 1];
//    }

//    public static int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length + 1];
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i = 2; i <= cost.length; i++) {
//            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
//        }
//        return dp[cost.length];
//    }


    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        // 定义dp为爬上第i阶楼梯花费的最少费用
        int[] dp = new int[length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[length];
    }


    public int uniquePaths(int m, int n) {
        // 定义dp为走到当前位置的路径方案数目
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

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        // 定义dp为到达第i层第j个的最少花费，则每个状态都能从上一层的全部状态中获得。
        int[][] dp = new int[m][n];
        dp[0] = grid[0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int u = 0; u < n; u++) {
                    min = Math.min(min, dp[i - 1][u] + moveCost[grid[i - 1][u]][j]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }


    public int countHousePlacements(int n) {
        // 定义dp[i]为当前位置放置房子的方案数目
        // 当前位置的状态数目有2中，放置与不防止，都和前面的状态相关，
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007);
        }
        long sum = dp[n];
        return (int) ((sum * sum) % 1000000007);
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target ? true : false;
    }

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

   /* public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum) return 0;
        if (((sum + target) & 1) == 1) return 0;
        int num = (sum + target) / 2;
        if (num < 0) return 0;
        // 定义dp为第i件物品之前和容量为j的有多少种组成方案
        int[][] dp = new int[nums.length + 1][num + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= num; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][num];
    }*/

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum) return 0;
        if (((sum + target) & 1) == 1) return 0;
        int num = (sum + target) / 2;
        if (num < 0) return 0;
        // 定义dp为第i件物品之前和容量为j的有多少种组成方案
        int[] dp = new int[num + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = num; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[num];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroCount = 0;
            int oneCount = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /*public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lisNum = new int[n];
        int cntIndex = 0;
        lisNum[cntIndex++] = nums[0];
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = nums[i];
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] < nums[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lisNum[left] = nums[i];
            }
            max = Math.max(max, cntIndex);
        }
        return max;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            else return o2[0] - o1[0];
        });
        int n = envelopes.length;
        int max = 1, cntIndex = 0;
        int[] lisNum = new int[n];
        lisNum[cntIndex++] = envelopes[0][0];
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][0] > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = envelopes[i][0];
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] >= envelopes[i][0]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lisNum[left] = envelopes[i][0];
            }
            max = Math.max(max, cntIndex);
        }
        return max;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length, cntIndex = 0;
        int[] lisNum = new int[n];
        int[] dp = new int[n];
        dp[0] = 1;
        lisNum[cntIndex++] = obstacles[0];
        for (int i = 1; i < obstacles.length; i++) {
            if (obstacles[i] >= lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = obstacles[i];
                dp[i] = cntIndex;
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] <= obstacles[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                lisNum[left] = obstacles[i];
                dp[i] = left + 1;
            }
        }
        return dp;
    }

    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) list.add(map.get(arr[i]));
        }
        if (list.size() == 0) return target.length;
        int n = list.size(), max = 1, cntIndex = 0;
        int[] lisNum = new int[n];
        lisNum[cntIndex++] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = list.get(i);
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] >= list.get(i)) {

                        right = mid - 1;

                    } else {

                        left = mid + 1;
                    }
                }
                lisNum[left] = list.get(i);
            }
            max = Math.max(max, cntIndex);
        }

        return target.length - max;
    }

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

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] >= 100000 ? -1 : dp[amount];
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] flags = new boolean[n + 1];
        flags[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (flags[j] && wordDict.contains(s.substring(j, i))) {
                    flags[i] = true;
                }
            }
        }

        return flags[n];
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] flags = new boolean[4901];
        int n = mat[0].length;
        int m = mat.length;
        for (int i = 0; i < n; i++) {
            flags[mat[0][i]] = true;
        }
        for (int i = 1; i < m; i++) {
            boolean[] cnt = new boolean[4901];
            for (int j = 0; j < flags.length; j++) {
                if (flags[j]) {
                    for (int u = 0; u < n; u++) {
                        if (j + mat[i][u] < 4901) cnt[j + mat[i][u]] = true;
                    }
                }
            }
            flags = cnt;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) min = Math.min(min, Math.abs(i - target));
        }

        return min;
    }


    public int countTexts(String pressedKeys) {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{1, 2, 3, 4};
        long res = 1;
        int mod = 1000000009;
        char preChar = pressedKeys.charAt(0);
        int preIndex = 0;
        for (int i = 1; i < pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i) != preChar) {
                int cntCount = i - preIndex;
                long total = countDp(preChar == '7' || preChar == '9' ? num2 : num1, cntCount, mod);
                res *= total;
                res %= mod;
                preIndex = i;
                preChar = pressedKeys.charAt(i);
            }
        }
        int cntCount = pressedKeys.length() - preIndex;
        long total = countDp(preChar == '7' || preChar == '9' ? num2 : num1, cntCount, mod);
        res *= total;
        res %= mod;
        return (int) res;
    }

    private long countDp(int[] ints, int cntCount, int mod) {
        long[] dp = new long[cntCount + 1];
        dp[0] = 1;
        for (int i = 1; i <= cntCount; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (i >= ints[j]) dp[i] += dp[i - ints[j]];
                dp[i] %= mod;
            }
        }
        return dp[cntCount];
    }

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
                }
            }
        }
        return dp[n][m];
    }


}
