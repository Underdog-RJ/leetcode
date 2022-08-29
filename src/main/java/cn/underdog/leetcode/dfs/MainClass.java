package cn.underdog.leetcode.dfs;

import org.apache.pdfbox.pdmodel.font.CIDFontMapping;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        int[] ball =   mainClass.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1},});
//        int[] ball = mainClass.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}});
//        int[] ball = mainClass.findBall(new int[][]{{-1}});
//
//        for (int i : ball) {
//            System.out.println(i);
//        }
//        long l = mainClass.subArrayRanges(new int[]{1, 2, 3});
//        long l = mainClass.subArrayRanges(new int[]{4, -2, -3, 4, 1});
//        System.out.println(l);
//        mainClass.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
//        mainClass.countMaxOrSubsets(new int[]{3, 1});
//        Employee employee1 = new Employee();
//        employee1.setId(1);
//        employee1.setImportance(5);
//        List<Integer> list = Arrays.asList(2, 3);
//        employee1.setSubordinates(list);
//        Employee employee2 = new Employee();
//        employee2.setId(2);
//        employee2.setImportance(3);
//        employee2.setSubordinates(new ArrayList<>());
//        Employee employee3 = new Employee();
//        employee3.setId(3);
//        employee3.setImportance(3);
//        employee3.setSubordinates(new ArrayList<>());
//        List<Employee> list1 = new ArrayList<>();
//        list1.add(employee1);
//        list1.add(employee2);
//        list1.add(employee3);
//        System.out.println(mainClass.getImportance(list1, 1));

//        System.out.println(mainClass.trailingZeroes(80));

//        mainClass.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}});
//        mainClass.findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}});
//        mainClass.findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}});
//        mainClass.findFarmland(new int[][]{{1, 1}, {1, 1}});
//        System.out.println(mainClass.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        mainClass.getKth(12, 15, 2);
    }

    /**
     * 用一个大小为 m x n 的二维网格 grid 表示一个箱子。你有 n 颗球。箱子的顶部和底部都是开着的。
     * <p>
     * 箱子中的每个单元格都有一个对角线挡板，跨过单元格的两个角，可以将球导向左侧或者右侧。
     * <p>
     * 将球导向右侧的挡板跨过左上角和右下角，在网格中用 1 表示。
     * 将球导向左侧的挡板跨过右上角和左下角，在网格中用 -1 表示。
     * 在箱子每一列的顶端各放一颗球。每颗球都可能卡在箱子里或从底部掉出来。如果球恰好卡在两块挡板之间的 "V" 形图案，或者被一块挡导向到箱子的任意一侧边上，就会卡住。
     * <p>
     * 返回一个大小为 n 的数组 answer ，其中 answer[i] 是球放在顶部的第 i 列后从底部掉出来的那一列对应的下标，如果球卡在盒子里，则返回 -1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/where-will-the-ball-fall
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int[] findBall(int[][] grid) {
        int length = grid[0].length;
        int total = grid.length;
        int[] ans = new int[length];
        int currentBall = 0;
        for (int i = 0; i < length; i++) {
            dfs(grid, ans, 0, i, total, length, currentBall++);
        }
        return ans;
    }

    private void dfs(int[][] grid, int[] ans, int i, int j, int total, int length, int currentBall) {
        if (i > total) {
            ans[currentBall] = -1;
            return;
        }
        if (i == total) {
            ans[currentBall] = j;
            return;
        }
        int current = grid[i][j];
        // 如果当前是1 则看右边
        if (current == 1) {
            if (j + 1 >= length) {
                ans[currentBall] = -1;
                return;
            }
            int next = grid[i][j + 1];
            if (next == 1) {
                // 下一次递归
                dfs(grid, ans, i + 1, j + 1, total, length, currentBall);
            } else {
                ans[currentBall] = -1;
                return;
            }
        }
        // 当前是-1 则看左边
        else {
            if (j <= 0) {
                ans[currentBall] = -1;
                return;
            }
            int next = grid[i][j - 1];
            if (next == -1) {
                // 下一次递归
                dfs(grid, ans, i + 1, j - 1, total, length, currentBall);
            } else {
                ans[currentBall] = -1;
                return;
            }
        }
    }

    public long subArrayRanges(int[] nums) {
        long res = 0;
//        for (int i = 2; i <= nums.length; i++) {
//            for (int j = 0; j <= nums.length - i; j++) {
//                int[] current = new int[i];
//                System.arraycopy(nums, j, current, 0,  i );
//                int min = Arrays.stream(current).min().getAsInt();
//                int max = Arrays.stream(current).max().getAsInt();
//                res += max - min;
//            }
//        }
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res += max - min;
            }
        }
        return res;
    }


    /**
     * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
     * <p>
     * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
     * <p>
     * 请你返回有 最高得分 节点的 数目 
     * 输入：parents = [-1,2,0,2,0]
     * 输出：3
     * 解释：
     * - 节点 0 的分数为：3 * 1 = 3
     * - 节点 1 的分数为：4 = 4
     * - 节点 2 的分数为：1 * 1 * 2 = 2
     * - 节点 3 的分数为：4 = 4
     * - 节点 4 的分数为：4 = 4
     * 最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
     * 输入：parents = [-1,2,0]
     * 输出：2
     * 解释：
     * - 节点 0 的分数为：2 = 2
     * - 节点 1 的分数为：2 = 2
     * - 节点 2 的分数为：1 * 1 = 1
     * 最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
     * 输入：parents = [-1,2,0,2,0]
     * 输出：3
     * 解释：
     * - 节点 0 的分数为：3 * 1 = 3
     * - 节点 1 的分数为：4 = 4
     * - 节点 2 的分数为：1 * 1 * 2 = 2
     * - 节点 3 的分数为：4 = 4
     * - 节点 4 的分数为：4 = 4
     * 最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：parents = [-1,2,0]
     * 输出：2
     * 解释：
     * - 节点 0 的分数为：2 = 2
     * - 节点 1 的分数为：2 = 2
     * - 节点 2 的分数为：1 * 1 = 1
     * 最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-nodes-with-the-highest-score
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param parents
     * @return
     */
    public int countHighestScoreNodes(int[] parents) {
        int length = parents.length;
        // 构建拓扑图
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) continue;
            List<Integer> orDefault = map.getOrDefault(parents[i], new ArrayList<>());
            orDefault.add(i);
            map.put(parents[i], orDefault);
        }
        dfs(0, map, length);
        return cnt;
    }

    static long max;
    static int cnt;

    private int dfs(int current, Map<Integer, List<Integer>> map, int length) {
        // 如果不包含则为叶子节点，返回1
        long score = 1;
        // 出去当前节点剩下的节点数量
        int count = length - 1;
        List<Integer> list = map.getOrDefault(current, new ArrayList<>());
        // 如果有孩子，则计算dfs计算孩子的数量根据孩子的数量计算当前current的得分情况  当前score的得分情况 = score* 当前孩子数量
        for (Integer integer : list) {
            // 深度优先统计出当前孩子的数量
            int childCount = dfs(integer, map, length);
            score *= childCount;
            count -= childCount;
        }
        // 如果没有孩子，则直接计算得分
        if (current != 0) {
            score *= count;
        }
        if (score == max) {
            cnt++;
        } else if (score > max) {
            max = score;
            cnt = 1;
        }
        return length - count;
    }

    public int countMaxOrSubsets(int[] nums) {
        int res = 0;
        // 查找子集
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> currentSet = new ArrayList<>();
            List<Integer> temp = null;
            for (List<Integer> list : subset) {
                temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(num);
                currentSet.add(temp);
            }
            subset.addAll(currentSet);
        }
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : subset) {
            if (list.isEmpty()) continue;
            int temp = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                temp |= list.get(i);
            }
            if (temp == max) {
                res++;
            } else if (temp > max) {
                max = temp;
                res = 1;
            }
        }
        return res;
    }


    /**
     * Alice 和 Bob 是一场射箭比赛中的对手。比赛规则如下：
     * <p>
     * Alice 先射 numArrows 支箭，然后 Bob 也射 numArrows 支箭。
     * 分数按下述规则计算：
     * 箭靶有若干整数计分区域，范围从 0 到 11 （含 0 和 11）。
     * 箭靶上每个区域都对应一个得分 k（范围是 0 到 11），Alice 和 Bob 分别在得分 k 区域射中 ak 和 bk 支箭。如果 ak >= bk ，那么 Alice 得 k 分。如果 ak < bk ，则 Bob 得 k 分
     * 如果 ak == bk == 0 ，那么无人得到 k 分。
     * 例如，Alice 和 Bob 都向计分为 11 的区域射 2 支箭，那么 Alice 得 11 分。如果 Alice 向计分为 11 的区域射 0 支箭，但 Bob 向同一个区域射 2 支箭，那么 Bob 得 11 分。
     * <p>
     * 给你整数 numArrows 和一个长度为 12 的整数数组 aliceArrows ，该数组表示 Alice 射中 0 到 11 每个计分区域的箭数量。现在，Bob 想要尽可能 最大化 他所能获得的总分。
     * <p>
     * 返回数组 bobArrows ，该数组表示 Bob 射中 0 到 11 每个 计分区域的箭数量。且 bobArrows 的总和应当等于 numArrows 。
     * <p>
     * 如果存在多种方法都可以使 Bob 获得最大总分，返回其中 任意一种 即可。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：numArrows = 9, aliceArrows = [1,1,0,1,0,0,2,1,0,1,2,0]
     * 输出：[0,0,0,0,1,1,0,0,1,2,3,1]
     * 解释：上表显示了比赛得分情况。
     * Bob 获得总分 4 + 5 + 8 + 9 + 10 + 11 = 47 。
     * 可以证明 Bob 无法获得比 47 更高的分数。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：numArrows = 3, aliceArrows = [0,0,1,0,0,0,0,0,0,0,0,2]
     * 输出：[0,0,0,0,0,0,0,0,1,1,1,0]
     * 解释：上表显示了比赛得分情况。
     * Bob 获得总分 8 + 9 + 10 = 27 。
     * 可以证明 Bob 无法获得比 27 更高的分数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-points-in-an-archery-competition
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numArrows
     * @param aliceArrows
     * @return
     */

    int globalMax = 0;
    int[] res = new int[12];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] currentNum = new int[12];
        dfsMaximumBobPoints(numArrows, aliceArrows, 11, currentNum, 0);
        return res;
    }

    private void dfsMaximumBobPoints(int numArrows, int[] aliceArrows, int index, int[] currentNum, int currentTotal) {
        // 递归出口，如果当前箭全部射出，则结束当前层递归
        if (numArrows == 0) {
            if (index == -1) {
                currentNum[0] += numArrows;
            }
            if (currentTotal > globalMax) {
                globalMax = currentTotal;
                System.arraycopy(currentNum, 0, res, 0, 12);
            }
        }
        for (int i = index; i >= 0; i--) {
            // 当前alices的箭的数量
            int currentAlices = aliceArrows[i];
            int winCurrent = currentAlices + 1;
            // 如果想要赢下当前的比赛，最少需要的箭
            if (numArrows >= winCurrent) {
                // 当前和类加
                currentTotal += i;
                // 记录当前bob的数量
                currentNum[i] = winCurrent;
                // 当前箭减去所需赢的箭的数量
                numArrows -= winCurrent;
                dfsMaximumBobPoints(numArrows, aliceArrows, i - 1, currentNum, currentTotal);
                // 当前层进行回溯操作减去上层的结果
                currentTotal -= i;
                currentNum[i] = 0;
                numArrows += winCurrent;
            }
        }
        if (index == 0) {
            currentNum[0] += numArrows;
        }
        if (currentTotal > globalMax) {
            globalMax = currentTotal;
            System.arraycopy(currentNum, 0, res, 0, 12);
        }
    }

    int count = 0;

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            int id1 = employee.id;
            if (id1 == id) {
                count += employee.importance;
                List<Integer> subordinates = employee.subordinates;
                for (Integer subordinate : subordinates) {
                    getImportance(employees, subordinate);
                }
            }
        }
        return count;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0) {
                int tmp = i / 5;
                int tmpCount = 1;
                while (tmp % 5 == 0) {
                    tmp /= 5;
                    tmpCount++;
                }
                count += tmpCount;
            }
        }

        return count;
    }

    List<Integer> resMinHeightTrees = new ArrayList<>();
    int minHeightTrees = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = lists[i];
            if (list.size() == 1) continue;
            Set<Integer> hasVisited = new HashSet<>();
            hasVisited.add(i);
            int count = dfsFindMinHeightTrees(lists, i, hasVisited);
            if (count == minHeightTrees) {
                resMinHeightTrees.add(i);
            } else if (count < minHeightTrees) {
                resMinHeightTrees.clear();
                resMinHeightTrees.add(i);
                minHeightTrees = count;
            }
        }
        return resMinHeightTrees;
    }

    private int dfsFindMinHeightTrees(List<Integer>[] lists, int i, Set<Integer> hasVisited) {
        List<Integer> list = lists[i];
        // 如果当前节点是叶子节点
        // 递归出口条件
        if (list.size() == 1 && hasVisited.contains(list.get(0))) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (!hasVisited.contains(integer)) {
                hasVisited.add(integer);
                max = Math.max(max, dfsFindMinHeightTrees(lists, integer, hasVisited));
            }
        }
        return max + 1;
    }

    public int[] findRedundantoCnnection(int[][] edges) {
        Set<Integer> integers = new HashSet<>();
        for (int[] edge : edges) {
            if (integers.contains(edge[0]) && integers.contains(edge[1])) return edge;
            else {
                integers.add(edge[0]);
                integers.add(edge[1]);
            }
        }
        return new int[2];
    }

    private int[][] memoMinCost = new int[101][3];

    public int minCost(int[][] costs) {
        return dfsMinCost(costs, 0, 0);
    }


    private int dfsMinCost(int[][] costs, int index, int lastIndex) {
        if (index == costs.length) return 0;
        if (memoMinCost[index][lastIndex] != 0) return memoMinCost[index][lastIndex];
        int cntResult = Integer.MAX_VALUE;
        for (int i = 0; i < costs[index].length; i++) {
            if (index != 0 && i == lastIndex) continue;
            int child = dfsMinCost(costs, index + 1, i) + costs[index][i];
            cntResult = Math.min(cntResult, child);
        }
        memoMinCost[index][lastIndex] = cntResult;
        return cntResult;
    }

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lo; i <= hi; i++) {
            int sum = dfsGetKth(i, map);
            priorityQueue.add(new int[]{i, sum});
        }
        int res = 0;
        while (k != 0) {
            res = priorityQueue.poll()[0];
            k--;
        }
        return res;
    }

    private int dfsGetKth(int i, HashMap<Integer, Integer> map) {
        if (i == 1) return 0;
        if (map.containsKey(i)) return map.get(i);
        int count = 0;
        count++;
        if ((i & 1) == 0) {
            count += dfsGetKth(i / 2, map);
        } else {
            count += dfsGetKth(i * 3 + 1, map);
        }
        map.put(i, count);
        return map.get(i);
    }


    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return dfsIsPowerOfTwo(n, 1);
    }

    private boolean dfsIsPowerOfTwo(int target, long cnt) {
        if (cnt == target) return true;
        if (cnt > target) return false;
        return dfsIsPowerOfTwo(target, cnt * 2);
    }

}
