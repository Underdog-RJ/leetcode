package cn.underdog.leetcode.competition;

import java.util.*;
import java.util.stream.Collectors;


public class C_306 {

    public static void main(String[] args) {
        C_306 c_306 = new C_306();
//        c_306.edgeScore(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 1});
        c_306.smallestNumber1("IIIDIDDD");
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] m = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int max = Integer.MIN_VALUE;
                for (int u = 0; u < 3; u++) {
                    for (int t = 0; t < 3; t++) {
                        max = Math.max(max, grid[i + u][j + t]);
                    }
                }
                m[i][j] = max;
            }
        }

        return m;
    }

    public int edgeScore(int[] edges) {
        int res = 0;
        long max = Integer.MIN_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            List<Integer> orDefault = map.getOrDefault(edges[i], new ArrayList<>());
            orDefault.add(i);
            map.put(edges[i], orDefault);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            long collect = 0;
            List<Integer> value = entry.getValue();
            for (Integer integer : value) {
                collect += integer;
            }
            if (collect > max) {
                max = collect;
                res = entry.getKey();
            } else if (collect == max) {
                res = Math.min(res, entry.getKey());
            }
        }
        return res;
    }

    StringBuilder sb = new StringBuilder();
    private String res = "999999999";

    public String smallestNumber(String pattern) {
        boolean[] flag = new boolean[10];
        for (int i = 1; i <= 9; i++) {
            flag[i] = true;
            sb.append(i);
            dfs(pattern, 0, flag);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
        return res;
    }

    private void dfs(String pattern, int startIndex, boolean[] flag) {
        if (sb.length() == pattern.length() + 1) {
            String tmp = sb.toString();
            if (tmp.compareTo(res) < 0) {
                res = tmp;
            }
            return;
        }
        int pre = Integer.parseInt(sb.charAt(sb.length() - 1) + "");
        if (pattern.charAt(startIndex) == 'I') {
            for (int i = pre + 1; i <= 9; i++) {
                if (!flag[i]) {
                    flag[i] = true;
                    sb.append(i);
                    dfs(pattern, startIndex + 1, flag);
                    sb.deleteCharAt(sb.length() - 1);
                    flag[i] = false;
                }
            }
        } else {
            for (int i = 1; i < pre; i++) {
                if (!flag[i]) {
                    flag[i] = true;
                    sb.append(i);
                    dfs(pattern, startIndex + 1, flag);
                    sb.deleteCharAt(sb.length() - 1);
                    flag[i] = false;
                }
            }
        }
    }

    //TODO
    public String smallestNumber1(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        String nums = "123456789";
        int i = 0;
        while (i < n) {
            if (i > 0 && pattern.charAt(i) == 'I')


            while (i < n && pattern.charAt(i) == 'D') {

            }


        }
        return sb.toString();

    }


}
