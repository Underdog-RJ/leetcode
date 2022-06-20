package cn.underdog.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class dfsArray {
    public static void main(String[] args) {
        dfsArray dfsArray = new dfsArray();
//        dfsArray.findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}});
//        System.out.println(dfsArray.canFinish(2, new int[][]{{1, 0}}));
//        System.out.println(dfsArray.findOrder(2, new int[][]{{0, 1}}));
//        System.out.println(dfsArray.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
//        System.out.println(dfsArray.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        dfsArray.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
    }

    /**
     * 给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
     * <p>
     * 为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，也就是说一个农场组中的任何一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。
     * <p>
     * land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角的坐标。一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。
     * <p>
     * 请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。可以以 任意顺序 返回所有农场组。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：land = [[1,0,0],[0,1,1],[0,1,1]]
     * 输出：[[0,0,0,0],[1,1,2,2]]
     * 解释：
     * 第一个农场组的左上角为 land[0][0] ，右下角为 land[0][0] 。
     * 第二个农场组的左上角为 land[1][1] ，右下角为 land[2][2] 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：land = [[1,1],[1,1]]
     * 输出：[[0,0,1,1]]
     * 解释：
     * 第一个农场组左上角为 land[0][0] ，右下角为 land[1][1] 。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：land = [[0]]
     * 输出：[]
     * 解释：
     * 没有任何农场组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-groups-of-farmland
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param land
     * @return
     */
    int rowLengthFindFarmLand = 0;
    int colLengthFindFarmLand = 0;

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        rowLengthFindFarmLand = land.length;
        colLengthFindFarmLand = land[0].length;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                // 左上角找到一个0
                if (land[i][j] == 1) {
                    int[] tmp = new int[4];
                    tmp[0] = i;
                    tmp[1] = j;
                    dfsFindFarmland(tmp, i, j, land);
                    list.add(tmp);
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void dfsFindFarmland(int[] tmp, int i, int j, int[][] land) {
        if (i + 1 > rowLengthFindFarmLand || j + 1 > colLengthFindFarmLand || land[i][j] != 1) {
            return;
        }
        land[i][j] = 2;
        // 向右走
        dfsFindFarmland(tmp, i + 1, j, land);
        dfsFindFarmland(tmp, i, j + 1, land);
        if (tmp[2] == 0 && tmp[3] == 0) {
            tmp[2] = i;
            tmp[3] = j;
        }
    }

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfsNumIslands(grid, i, j);
                }
            }
        }
        return res;

    }

    private void dfsNumIslands(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfsNumIslands(grid, i - 1, j);
        dfsNumIslands(grid, i + 1, j);
        dfsNumIslands(grid, i, j - 1);
        dfsNumIslands(grid, i, j + 1);
    }


    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * <p>
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     * 示例 2：
     * <p>
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] canFinished = new boolean[numCourses];
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            lists[prerequisite[0]].add(prerequisite[1]);
        }
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                canFinished[i] = dfsCanFinish(i, lists, visited, canFinished);
            }
            if (canFinished[i]) {
                total++;
            }
        }
        return total == numCourses;
    }

    private boolean dfsCanFinish(int i, List<Integer>[] lists, boolean[] visited, boolean[] canFinished) {
        if (visited[i])
            return canFinished[i];
        visited[i] = true;
        List<Integer> list = lists[i];
        for (Integer integer : list) {
            boolean childCanFinish = dfsCanFinish(integer, lists, visited, canFinished);
            if (!childCanFinish)
                return false;
        }
        canFinished[i] = true;
        return true;
    }


    /**
     * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
     * <p>
     * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
     * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：[0,1]
     * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * 示例 2：
     * <p>
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：[0,2,1,3]
     * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
     * 示例 3：
     * <p>
     * 输入：numCourses = 1, prerequisites = []
     * 输出：[0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] canFinished = new boolean[numCourses];
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            lists[prerequisite[0]].add(prerequisite[1]);
        }
        int total = 0;
        List<Integer> resTmp = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                canFinished[i] = dfsFindOrder(i, lists, visited, canFinished, resTmp);
            }
            if (canFinished[i]) {
                total++;
            }
        }
        if (total == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < resTmp.size(); i++) {
                res[i] = resTmp.get(i);
            }
            return res;
        } else {
            return new int[0];
        }

    }

    private boolean dfsFindOrder(int i, List<Integer>[] lists, boolean[] visited, boolean[] canFinished, List<Integer> resTmp) {
        if (visited[i])
            return canFinished[i];
        visited[i] = true;
        List<Integer> list = lists[i];
        for (Integer integer : list) {
            boolean flag = dfsFindOrder(integer, lists, visited, canFinished, resTmp);
            if (!flag)
                return false;
        }
        resTmp.add(i);
        canFinished[i] = true;
        return true;
    }


    /**
     * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
     * <p>
     * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
     * <p>
     * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
     * <p>
     * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
     * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
     * 示例 2：
     * <p>
     * 输入: heights = [[2,1],[1,2]]
     * 输出: [[0,0],[0,1],[1,0],[1,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights
     * @return
     */
    int rowPA = 0;
    int colPA = 0;
    int cntRow = 0;
    int cntCol = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rowPA = heights.length;
        colPA = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                boolean[] tmp = new boolean[2];
                dfsPA(heights, i, j, tmp);
                if (tmp[0] && tmp[1])
                    res.add(List.of(i, j));
            }
        }

        return res;
    }

    private void dfsPA(int[][] heights, int i, int j, boolean[] tmp) {
        // 上
        int cntS = i;
        while (cntS >= 0) {
            if (heights[i][j] >= heights[cntS][j]) {
                cntS--;
            } else {
                break;
            }
        }
        if (cntS < 0)
            tmp[0] = true;
        if (!tmp[0]) {
            int cntZ = j;
            while (cntZ >= 0) {
                if (heights[i][j] >= heights[i][cntZ]) {
                    cntZ--;
                } else {
                    break;
                }
            }
            if (cntZ < 0)
                tmp[0] = true;
        }
        // 下
        int cntX = i;
        while (cntX < rowPA) {
            if (heights[i][j] >= heights[cntX][j]) {
                cntX++;
            } else {
                break;
            }
        }
        if (cntX >= rowPA)
            tmp[1] = true;
        if (!tmp[1]) {
            int cntY = j;
            while (cntY < colPA) {
                if (heights[i][j] >= heights[i][cntY]) {
                    cntY++;
                } else {
                    break;
                }
            }
            if (cntY >= colPA) {
                tmp[1] = true;
            }
        }
    }

    /*private void dfsPA(int[][] heights, int i, int j, boolean[] tmp) {
        if (i < 0 || j < 0) {
            tmp[0] = true;
            return;
        }
        if (i >= rowPA || j >= colPA) {
            tmp[1] = true;
            return;
        }
        if (tmp[0] && tmp[1])
            return;
        if (heights[i][j] < heights[cntRow][cntCol])
            return;
        if (!tmp[0]) {
            dfsPA(heights, i - 1, j, tmp);
        }
        if (!tmp[0]) {
            dfsPA(heights, i + 1, j, tmp);
        }
        if (!tmp[1]) {
            dfsPA(heights, i, j - 1, tmp);
            dfsPA(heights, i, j + 1, tmp);
        }
    }*/


}
