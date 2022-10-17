package cn.underdog.leetcode.competition;

import java.util.*;

public class C_313 {

    public static void main(String[] args) {
        C_313 c_313 = new C_313();
//        c_313.maxSum(new int[][]{{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}});
//        System.out.println(c_313.minimizeXor(3, 5));
//        System.out.println(c_313.minimizeXor(25, 72));
//        System.out.println(c_313.minimizeXor(65, 84));
        System.out.println(c_313.deleteString("abcabcdabc"));
        System.out.println(c_313.deleteString("aaabaab"));
        System.out.println(c_313.deleteString("aaaaa"));
    }


    public int commonFactors(int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if ((a % i) == 0 && (b % i) == 0) {
                count++;
            }
        }

        return count;

    }

    public int maxSum(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int cnt = 0;
                for (int t = 0; t <= 2; t++) {
                    for (int u = 0; u <= 2; u++) {
                        cnt += grid[i + t][j + u];
                    }
                }
                cnt -= grid[i + 1][j];
                cnt -= grid[i + 1][j + 2];
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public int minimizeXor(int num1, int num2) {
        String s1 = Integer.toBinaryString(num1);
        int n = s1.length();
        int diff = 32 - n;
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            tmp.append("0");
        }
        tmp.append(s1);
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        if (c1 == c2)
            return num1;
        else {
            StringBuilder sb = new StringBuilder();
            if (c1 > c2) {
                for (int i = 0; i <= 31; i++) {
                    if (tmp.charAt(i) == '0') {
                        sb.append("0");
                    } else {
                        if (c2 > 0) {
                            sb.append("1");
                            c2--;
                        } else {
                            sb.append("0");
                        }
                    }
                }
                return Integer.parseUnsignedInt(sb.toString(), 2);

            } else {
                c2 = c2 - c1;
                for (int i = 31; i >= 0; i--) {
                    if (tmp.charAt(i) == '0') {
                        if (c2 > 0) {
                            sb.append("1");
                            c2--;
                        } else {
                            sb.append("0");
                        }
                    } else {
                        sb.append("1");
                    }
                }
                return Integer.parseUnsignedInt(sb.reverse().toString(), 2);

            }
        }

    }

    //    private Integer maxDS = 1;
    private Integer cntDS = 0;
    private int length = 0;
    private HashMap<Integer, Integer> memo = new HashMap<>();

//    public int deleteString(String s) {
//        this.length = s.length();
//        return backtrackDS(s, 0);
//    }

    private int backtrackDS(String s, int startIndex) {
        if (startIndex >= s.length()) return 0;
        if (memo.containsKey(startIndex)) return memo.get(startIndex);
        int count = 1;
        for (int i = startIndex; i < s.length(); i++) {
            String str1 = s.substring(startIndex, i + 1);
            int nextLength = (i + 1) + str1.length();
            if (nextLength > length) {
                return count;
            }
            String str2 = s.substring(i + 1, nextLength);
            if (str1.equals(str2)) {
                count = Math.max(count, 1 + backtrackDS(s, i + 1));
            }
        }
        memo.put(startIndex, count);
        return memo.get(startIndex);
    }

    public int deleteString(String s) {
        long base = 191, mod = 99384773;
        char c[] = s.toCharArray();
        int n = c.length;
        int ans[] = new int[n];
        long power[] = new long[n + 5], hash[] = new long[n + 1];
        Arrays.fill(ans, 1);
        power[0] = 1;
        for (int i = 1; i <= n + 2; i++) {
            power[i] = power[i - 1] * base % mod;
        }
        for (int i = n - 1; i >= 0; i--) {
            hash[i] = (hash[i + 1] * base + c[i]) % mod;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= (n - i) / 2; j++) {
                long hash1 = (hash[i] + mod - hash[i + j] * power[j] % mod) % mod;
                long hash2 = (hash[i + j] + mod - hash[i + j * 2] * power[j] % mod) % mod;
                if (hash1 == hash2) {
                    ans[i] = Math.max(ans[i], 1 + ans[i + j]);
                }
            }
        }
        return ans[0];
    }

}
