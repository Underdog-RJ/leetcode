package cn.underdog.leetcode.competition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C_266 {
    public static void main(String[] args) {
//        countVowelSubstrings("aeiouu");

        C_266 c_266 = new C_266();
//        c_266.countVowels("noosabasboosa");
        System.out.println(c_266.minimizedMaximum(6, new int[]{11, 6}));
    }

    public static int countVowelSubstrings(String word) {
        String s = "aeiou";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < word.length(); j++) {
                if (s.indexOf(word.charAt(j)) < 0)
                    break;
                set.add(word.charAt(j));
                if (set.size() == 5)
                    count++;
            }
        }
        return count;
    }

    public long countVowels(String word) {
        // 定义dp 为i结束的总数量
        long[] dp = new long[word.length()];
        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        dp[0] = set.contains(word.charAt(0)) ? 1 : 0;
        for (int i = 1; i < word.length(); i++) {
            int cnt = i + 1;
            if (set.contains(word.charAt(i))) {
                dp[i] = dp[i - 1] + cnt;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        long res = 0;
        for (long i : dp) {
            res += i;
        }
        return res;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0;
        int right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int quantity : quantities) {
                count += Math.ceil((double) quantity / mid);
            }
            if (count <= n) {
                right = mid - 1;
            } else if (count > n) {
                left = mid + 1;
            }
        }
        return left;
    }
}
