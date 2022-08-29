package cn.underdog.leetcode.competition;


import cn.underdog.leetcode.MainClass.ListNode;

import java.util.*;

public class C_300 {

    public static void main(String[] args) {
        C_300 c_300 = new C_300();
//        c_300.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
//        c_300.peopleAwareOfSecret(6, 2, 4);
//        c_300.spiralMatrix(8, 8);
        c_300.countPaths(new int[][]{{1, 1}, {3, 4}});
    }
    //[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
    //[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]

    public String decodeMessage(String key, String message) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            if (Character.isLetter(key.charAt(i)) && !map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), index++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (Character.isLetter(message.charAt(i))) {
                char cnt = message.charAt(i);
                char tmp = (char) (map.get(cnt) + 97);
                sb.append(tmp);
            } else {
                sb.append(" ");
            }

        }
        return sb.toString();
    }


    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] res = new int[m][n];
        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], -1);
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 循环次数
        int loop = Math.min(m, n) / 2;
        // 定义每次循环起始位置
        int startX = 0;
        int startY = 0;

        // 定义偏移量
        int offset = 1;

        // 定义填充数字
        int count = 0;

        while (loop > 0) {
            int i = startX;
            int j = startY;
            // 模拟上侧从左到右
            for (; j < startY + n - offset; ++j) {
                int cnt = count >= list.size() ? -1 : list.get(count++);
                res[startX][j] = cnt;
            }

            // 模拟右侧从上到下
            for (; i < startX + m - offset; ++i) {
                int cnt = count >= list.size() ? -1 : list.get(count++);

                res[i][j] = cnt;
            }

            // 模拟下侧从右到左
            for (; j > startY; j--) {
                int cnt = count >= list.size() ? -1 : list.get(count++);

                res[i][j] = cnt;
            }

            // 模拟左侧从下到上
            for (; i > startX; i--) {
                int cnt = count >= list.size() ? -1 : list.get(count++);

                res[i][j] = cnt;
            }

            loop--;

            startX += 1;
            startY += 1;

            offset += 2;
        }
        int tmp = Math.min(m, n);
        if ((tmp & 1) == 1) {
            if (m <= n) {
                // 模拟上侧从左到右
                int j = startX;
                for (; j <= startY + n - offset; ++j) {
                    int cnt = count >= list.size() ? -1 : list.get(count++);

                    res[startX][j] = cnt;
                }
            } else if (m > n) {
                int i = startX;
                // 模拟右侧从上到下
                for (; i <= startX + m - offset; ++i) {
                    int cnt = count >= list.size() ? -1 : list.get(count++);

                    res[i][startY] = cnt;
                }
            }
        }
        return res;

    }


    public int peopleAwareOfSecret(int n, int delay, int forget) {
        // 定义dp为第i天知道秘密的人的增量
        int[] dp = new int[n + 1];
        // 转移公式为当天在区间[i+delay,i+forget]内的元素全部加+1
        // 更新方向是反向，当天可以更新后面的值
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i + delay; j < i + forget; j++) {
                if (j <= n) {
                    dp[j] += dp[i];
                    dp[j] %= 1000000007;
                }
            }
        }
        int sum = 0;
        for (int i = n - forget + 1; i < dp.length; i++) {
            sum += dp[i];
            sum %= 1000000007;
        }
        return sum %= 1000000007;
    }

    /**
     * 记忆化搜索，记录每个位置的严格递增的数量
     */
    private int[][] gridCount = null;
    /**
     * 当前节点是否访问过
     */
    private boolean[][] gridVisited = null;

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        gridCount = new int[m][n];
        gridVisited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 如果当前节点没有访问过，对当前节点进行遍历
                if (!gridVisited[i][j]) {
                    res += dfsCountPath(grid, i, j);
                    res %= 1000000007;
                }
                // 访问过则直接进行累加
                else {
                    res += gridCount[i][j];
                    res %= 1000000007;
                }
            }
        }
        return res;
    }

    private int dfsCountPath(int[][] grid, int i, int j) {
        if (gridVisited[i][j]) return gridCount[i][j];
        gridVisited[i][j] = true;
        int cnt = 1;
        if (i + 1 < grid.length && grid[i][j] < grid[i + 1][j])
            cnt += dfsCountPath(grid, i + 1, j);
        if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j])
            cnt += dfsCountPath(grid, i - 1, j);
        if (j + 1 < grid[0].length && grid[i][j] < grid[i][j + 1])
            cnt += dfsCountPath(grid, i, j + 1);
        if (j - 1 >= 0 && grid[i][j] < grid[i][j - 1])
            cnt += dfsCountPath(grid, i, j - 1);
        cnt %= 1000000007;
        gridCount[i][j] = cnt;
        return gridCount[i][j];
    }
}
