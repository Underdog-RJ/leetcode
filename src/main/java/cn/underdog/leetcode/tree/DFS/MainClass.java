package cn.underdog.leetcode.tree.DFS;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        System.out.println(findOrder(3, new int[][]{{1, 0}, {2, 1}}));
//        System.out.println(lexicalOrder(100));
        System.out.println(lexicalOrder(192));
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
     *  
     * 思路
     * 判断二维数组中
     * 如果存在环路，则当前环路内的全部作废
     * 如果不存在环路的先修课程大于给定的k则返回true否则返回false
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/course-schedule
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    // 深度优先
    /**
     * 思路：
     * 1.用valid表示是否存在环，如果存在环返回false否则返回true
     * 2.用visited代表将要访问的数组
     * 0代表未访问
     * 1代表正在访问
     * 2达标访问完成
     */
    static boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        // 初始化数组
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfsCanFinish(list, visited, i);
        }
        return valid;
    }

    /**
     * 把当前访问的节点设置为1进行深度优先遍历，如果当前节点为在访问过曾中存在已经访问过的节点，则表明存在环路，直接返回true访问接收之后设置为2
     *
     * @param list
     * @param visited
     * @param i
     */
    private static void dfsCanFinish(List<List<Integer>> list, int[] visited, int i) {
        visited[i] = 1; // 标记为搜索中
        for (Integer integer : list.get(i)) {
            if (visited[integer] == 0) {
                dfsCanFinish(list, visited, integer);
                if (!valid)
                    return;
            } else {
                if (visited[integer] == 1) {
                    valid = false;
                    return;
                }
            }
        }
        visited[i] = 2;
    }

    // 广度优先
   /* public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] bfsNums = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        // 初始化数组
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
            ++bfsNums[prerequisite[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        // 判断第一次的
        for (int i = 0; i < bfsNums.length; i++) {
            if (bfsNums[i] == 0)
                queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            Integer current = queue.poll();
            for (Integer integer : list.get(current)) {
                --bfsNums[integer];
                if (bfsNums[integer] == 0)
                    queue.add(integer);
            }
        }
        return visited == numCourses;
    }*/


    // 返回顺序 BFS
    /*public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] bfsCourses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            ++bfsCourses[prerequisite[0]];
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();
        for (int i = 0; i < bfsCourses.length; i++) {
            if (bfsCourses[i] == 0) {
                queue.offer(i);
                queue1.offer(i);
            }
        }
        int temp = 0;
        while (!queue.isEmpty()) {
            temp++;
            Integer poll = queue.poll();
            for (Integer integer : list.get(poll)) {
                --bfsCourses[integer];
                if (bfsCourses[integer] == 0) {
                    queue.add(integer);
                    queue1.add(integer);
                }
            }
        }
        int[] res = new int[numCourses];
        if (temp == numCourses) {
            for (int i = 0; i < res.length; i++) {
                res[i]=queue1.poll();
            }
            return res;
        } else {
            return  new int[0];
        }
    }*/


    static boolean findOrderFlag = true;
    static List<Integer> listFindOrder = new ArrayList<>();

    // 返回顺序深度优先
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] dfsCourses = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < dfsCourses.length && findOrderFlag; i++) {
            if (dfsCourses[i] == 0)
                findOrderDFS(list, dfsCourses, i);
        }
        if (findOrderFlag) {

            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = listFindOrder.get(numCourses - 1 - i);
            }
            return res;
        } else {
            return new int[0];
        }
    }

    public static void findOrderDFS(List<List<Integer>> list, int[] dfsCourses, int i) {
        dfsCourses[i] = 1;
        for (Integer integer : list.get(i)) {
            if (dfsCourses[integer] == 0) {
                findOrderDFS(list, dfsCourses, integer);
                if (!findOrderFlag)
                    return;
            } else if (dfsCourses[integer] == 1) {
                findOrderFlag = false;
                return;
            }
        }
        listFindOrder.add(i);
        dfsCourses[i] = 2;
    }

    /**
     * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
     * <p>
     * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 13
     * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
     * 示例 2：
     * <p>
     * 输入：n = 2
     * 输出：[1,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        dfsLexicalOrder(0, 1, n, res);
        return res;
    }

    private static void dfsLexicalOrder(int base, int start, int n, List<Integer> res) {
        if (base > n)
            return;
        for (int i = start; i < 10; i++) {
            int num = i + base;
            if (num < n) {
                res.add(num);
                dfsLexicalOrder(num * 10, 0, n, res);
            }
        }

    }

}


