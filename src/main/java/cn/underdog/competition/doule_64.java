package cn.underdog.competition;

import java.util.*;

public class doule_64 {
    public static void main(String[] args) {
//        platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}});
//        platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}});
        platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}});
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String str = "";
        List<String> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        if (k > list.size())
            return "";
        else {
            return list.get(k - 1);
        }
    }

    /**
     * @param s
     * @param queries
     * @return
     */
   /* public static int[] platesBetweenCandles(String s, int[][] queries) {
        int row = queries.length;
        int[] res = new int[row];
        if (row == 0)
            return res;
        for (int i = 0; i < row; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            boolean flag = false;
            while (left < right) {
                if (s.charAt(left) == '*') {
                    left++;
                    flag = true;
                }
                if (s.charAt(right) == '*') {
                    right--;
                    flag = true;
                }
                if (!flag)
                    break;
                flag = false;
            }
            int count = 0;
            int l1 = left + 1;
            int r1 = right - 1;
            while (l1 < r1) {
                if (s.charAt(l1++) == '*')
                    count++;
                if (s.charAt(r1--) == '*')
                    count++;
            }
            if (l1 == r1 && s.charAt(l1) == '*')
                count++;
            res[i] = count;
        }
        return res;
    }*/
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int row = queries.length;
        int[] res = new int[row];
        if (row == 0)
            return res;
        for (int i = 0; i < row; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            boolean lflag = false;
            boolean rflag = false;
            int count = 0;
            while (left < right) {
                if (lflag && rflag) {
                    if (s.charAt(left++) == '*')
                        count++;
                    if (s.charAt(right--) == '*')
                        count++;
                } else {
                    if (s.charAt(left) == '*') {
                        lflag = false;
                        left++;
                    } else {
                        lflag = true;
                    }
                    if (s.charAt(right) == '*') {
                        rflag = true;
                        right--;
                    } else {
                        rflag = true;
                    }
                }
            }
            if (left == right && s.charAt(left) == '*')
                count++;
            res[i] = count;
        }
        return res;
    }

    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int[] sum = new int[s.length()], left = new int[s.length()], right = new int[s.length()],
                result = new int[queries.length];
        for (int i = 0; i < s.length(); i++) {
            sum[i] = (s.charAt(i) == '*' ? 1 : 0) + (i > 0 ? sum[i - 1] : 0);
            left[i] = s.charAt(i) == '|' ? i : (i > 0 ? left[i - 1] : -1);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            right[i] = s.charAt(i) == '|' ? i : (i < s.length() - 1 ? right[i + 1] : -1);
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = left[queries[i][1]] == -1 || right[queries[i][0]] == -1 ? 0
                    : Math.max(0, sum[left[queries[i][1]]] - sum[right[queries[i][0]]]);
        }
        return result;
    }


}
