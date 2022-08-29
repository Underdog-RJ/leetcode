package cn.underdog.leetcode.competition;

import java.util.*;

public class D_83 {


    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        nc.find(10); // 没有数字 10 ，所以返回 -1 。
        nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
        nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
        nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
        nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
        nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
        nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
        nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2
    }

    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> characters = new HashSet<>();
        for (char suit : suits) {
            characters.add(suit);
        }
        if (characters.size() == 1)
            return "Flush";
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3)
                return "Three of a Kind";
            if (entry.getValue() == 2)
                return "Pair";
        }
        if (map.size() == 5)
            return "High Card";
        return "";
    }

    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0)
                dp[i] = 0;
            else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        long res = 0;
        for (long l : dp) {
            res += l;
        }
        return res;
    }
}
