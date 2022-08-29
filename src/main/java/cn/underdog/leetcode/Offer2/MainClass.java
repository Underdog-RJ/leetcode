package cn.underdog.leetcode.Offer2;

import java.util.HashSet;
import java.util.Set;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
    }

    /**
     * 找出数组中重复的数字。
     * <p>
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;

    }


    private boolean[][] longestVisited = null;
    private int[][] longestCount = null;

    // 112
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        longestCount = new int[m][n];
        longestVisited = new boolean[m][n];
        int longestMax = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!longestVisited[i][j]) {
                    dfsLongest(matrix, i, j);
                }
                longestMax = Math.max(longestMax, longestCount[i][j]);
            }
        }
        return longestMax;

    }

    private int dfsLongest(int[][] grid, int i, int j) {
        if (longestVisited[i][j]) return longestCount[i][j];
        longestVisited[i][j] = true;
        int cnt = 1;
        int cntMax = 0;
        if (i + 1 < grid.length && grid[i][j] < grid[i + 1][j])
            cntMax = Math.max(cntMax, dfsLongest(grid, i + 1, j));
        if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j])
            cntMax = Math.max(cntMax, dfsLongest(grid, i - 1, j));
        if (j + 1 < grid[0].length && grid[i][j] < grid[i][j + 1])
            cntMax = Math.max(cntMax, dfsLongest(grid, i, j + 1));
        if (j - 1 >= 0 && grid[i][j] < grid[i][j - 1])
            cntMax = Math.max(cntMax, dfsLongest(grid, i, j - 1));
        longestCount[i][j] = cnt + cntMax;
        return longestCount[i][j];
    }

}
