package cn.underdog.leetcode.competition;

import java.util.*;

public class C_298 {

    public static void main(String[] args) {
        C_298 c_298 = new C_298();
//        c_298.minimumNumbers(58, 9);
//        c_298.minimumNumbers(4, 0);
//        System.out.println(c_298.minimumNumbers(18, 3));
//        c_298.longestSubsequence("1001010", 5);
        c_298.longestSubsequence("00101001", 1);
    }


    public String greatestLetter(String s) {
        String res = "";
        Set<Character> characters = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char tmp = Character.toLowerCase(c);
                if (characters.contains(tmp)) {
                    if (res.compareTo(c + "") < 0) {
                        res = c + "";
                    }
                }
            } else {
                char tmp = Character.toUpperCase(c);
                if (characters.contains(tmp)) {
                    if (res.compareTo(tmp + "") < 0) {
                        res = tmp + "";
                    }
                }
            }
            characters.add(c);
        }
        return res;
    }

    int min = Integer.MAX_VALUE;
    List<Integer> cntNumber = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public int minimumNumbers(int num, int k) {
        if (k == 0)
            return num % 10 == 0 ? num == 0 ? 0 : 1 : -1;
        dfsMinimum(k, num);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfsMinimum(int k, int cnt) {
        if (cnt < 0)
            return;
        if (cnt == 0) {
            min = Math.min(min, cntNumber.size());
            return;
        }
        if (set.contains(cnt))
            return;
        set.add(cnt);
        int number = cnt / 10;
        for (int i = number; i >= 0; i--) {
            int total = i * 10 + k;
            cntNumber.add(total);
            dfsMinimum(k, cnt - total);
            cntNumber.remove(cntNumber.size() - 1);
        }
    }

    public int longestSubsequence(String s, int k) {
        long sum = 0;
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                cnt++;
            } else {
                if (cnt <= 32 && sum + (1l << cnt) <= k) {
                    sum += (1l << cnt);
                    cnt++;
                }
            }
        }
        return cnt;
    }


}
