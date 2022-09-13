package cn.underdog.leetcode.competition.review;

import java.util.ArrayList;
import java.util.List;

public class D_86 {
    public static void main(String[] args) {
        //   System.out.println(Integer.parseUnsignedInt("1E", 16));
        D_86 d_86 = new D_86();
        d_86.maximumRows(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}}, 2);
    }


    /**
     * 转换为N进制数字
     *
     * @param n
     * @return
     */
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            StringBuilder sb = new StringBuilder();
            int k = n;
            while (k > 0) {
                sb.append(k % i);
                k /= i;
            }
            System.out.println(sb.reverse());
            boolean par = isPar(sb.toString());
            if (!par) return false;
        }
        return true;
    }

    private boolean isPar(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length, n = mat[0].length, max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]);
            }
            list.add(Integer.parseUnsignedInt(sb.toString(), 2));
        }
        for (int i = 0; i < (1 << n); i++) {
            int count = Integer.bitCount(i);
            int res = 0;
            if (count == cols) {
                for (Integer integer : list) {
                    if (integer.equals((integer & i))) res++;
                }
            }
            max = Integer.max(max, res);
        }
        return max;
    }
}
