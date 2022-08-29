package cn.underdog.leetcode.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D_61 {
    public static void main(String[] args) {
        D_61 d_61 = new D_61();
//        d_61.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});
        d_61.maxTaxiEarnings(20, new int[][]{{2, 3, 6}, {8, 9, 8}, {5, 9, 7}, {8, 9, 1}, {2, 9, 2}, {9, 10, 6}, {7, 10, 10}, {6, 7, 9}, {4, 9, 7}, {2, 3, 1}});
    }


    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += Math.abs(nums[i] - nums[j]) == k ? 1 : 0;
            }
        }
        return count;
    }

    public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        if ((length & 1) == 1) return new int[0];
        int[] targets = new int[100001];
        for (int i : changed) {
            ++targets[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < targets.length; i++) {
            int cntTotal = targets[i];
            if (i == 0) {
                if ((cntTotal & 1) == 1) return new int[0];
                for (int u = 0; u < cntTotal / 2; u++) {
                    list.add(0);
                }
            } else {
                if (targets[i] != 0) {
                    if (i * 2 >= targets.length) return new int[0];
                    int targetTotal = targets[i * 2];
                    if (targetTotal < cntTotal) return new int[0];
                    targets[i * 2] -= cntTotal;
                    for (int u = 0; u < cntTotal; u++) {
                        list.add(i);
                    }
                }
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 超时
     *
     * @param n
     * @param rides
     * @return
     */
    public long maxTaxiEarnings1(int n, int[][] rides) {
        Arrays.sort(rides, ((o1, o2) -> o1[1] - o2[1]));
        int length = rides.length;
        long[] dp = new long[length];
        dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
        for (int i = 1; i < rides.length; i++) {
            int[] cnt = rides[i];
            int cntValue = cnt[1] - cnt[0] + cnt[2];
            dp[i] = cntValue;
            for (int j = 0; j < i; j++) {
                int[] pre = rides[j];
                if (cnt[0] >= pre[1]) {
                    dp[i] = Math.max(dp[j] + cntValue, dp[i]);
                } else {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
        }
        return dp[length - 1];
    }

    /**
     * 对于当前下标有2个状态能选择和不能选择都跟前一个状态有关系想到动态规划
     * 1定义：dp[i]为第i个人最多能够赚取的最大价值。
     * 2.转移公式 当前状态i跟前面任意一个都有关系
     * tips明确两个概念
     * 能选择：当前start小于第j个的end
     * 不能选择：当前star大于第j个的end
     * 则j从0-i-1
     * 能选择第j时候：
     * dp[i] = Math.max(dp[j] + cntValue, dp[i]);
     * 不能选择第j的时候
     * dp[i] = Math.max(dp[j], dp[i]);
     * 3.初始化
     * dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
     * 4.遍历顺序 跟前一个有关则正序便利
     *5.Tips
     *  定义为dp[i]为到i最大的值所以dp[i]>=dp[i-1]
     *  对rides按照end排序，前面的需要遍历从0-i-1我们可以使用二分查找，找到最右边的小于等于当前的start的下标
     * @param n
     * @param rides
     * @return
     */
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, ((o1, o2) -> o1[1] - o2[1]));
        int length = rides.length;
        long[] dp = new long[length];
        dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
        for (int i = 1; i < rides.length; i++) {
            int[] cnt = rides[i];
            int cntValue = cnt[1] - cnt[0] + cnt[2];
            dp[i] = cntValue;
            int left = 0, right = i - 1;
            int target = rides[i][0];
            while (left <= right) {
                int mid = left + right >> 1;
                int cntNum = rides[mid][1];
                if (cntNum > target) right = mid - 1;
                else left = mid + 1;
            }
            if (right < 0) dp[i] = Math.max(dp[i - 1], dp[i]);
            else dp[i] = Math.max(dp[i - 1], dp[right] + cntValue);
        }
        return dp[length - 1];
    }


}
