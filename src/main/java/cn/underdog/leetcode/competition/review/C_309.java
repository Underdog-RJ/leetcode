package cn.underdog.leetcode.competition.review;

import java.util.HashMap;
import java.util.HashSet;

public class C_309 {
    public static void main(String[] args) {
        C_309 c_309 = new C_309();
        c_309.numberOfWays(1, 2, 3);
    }

    // 记忆化搜索，存储连个变量，当前的位置和k一共的可能性。
    HashMap<String, Long> memo = new HashMap<>();

    public int numberOfWays1(int startPos, int endPos, int k) {
        long res = dfsNOF(startPos, endPos, k);
        return (int) (res % 1000000007);
    }

    private long dfsNOF(int startPos, int endPos, int k) {
        // 剪纸，当两个距离大于k是不可能。
        if (Math.abs(endPos - startPos) > k) return 0;
        if (startPos == endPos && k == 0) return 1;
        if (k == 0) return 0;
        String cntK = startPos + "-" + k;
        if (memo.containsKey(cntK)) return memo.get(cntK);
        long left = dfsNOF(startPos - 1, endPos, k - 1) % 1000000007;
        long right = dfsNOF(startPos + 1, endPos, k - 1) % 1000000007;
        memo.put(cntK, left + right);
        return memo.get(cntK);
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp = new long[3005][1005];
        dp[startPos + 1 + 1000][1] = 1;
        dp[startPos - 1 + 1000][1] = 1;
        for (int i = 2; i <= k; i++) {
            for (int j = 1000 + startPos - k; j <= 1000 + startPos + k; j++) {
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
                dp[j][i] %= 1000000007;
            }
        }
        return (int) dp[endPos + 1000][k];
    }

    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        int left = 0, rigtht = 0, n = nums.length, mask = 0;
        while (rigtht < n) {
            while ((mask & nums[rigtht]) > 0) {
                mask ^= nums[left++];
            }
            mask ^= nums[rigtht++];
            max = Math.max(max, rigtht - left);
        }
        return max;
    }

}
