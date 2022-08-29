package cn.underdog.leetcode.competition;


import java.util.ArrayList;
import java.util.List;

public class D_81 {

    public static void main(String[] args) {
        D_81 d_81 = new D_81();
        d_81.countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}});
    }

    public int countAsterisks(String s) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((num & 1) == 0) {
                if (s.charAt(i) == '*') {
                    count++;
                }
            }
            if (s.charAt(i) == '|') {
                num++;
            }
        }
        return count;
    }

    /**
     * 拓扑排序的变形题
     * 无向图添加两个，有向图添加一个，判断是否存在  回路，需要添加一个额外数组
     *
     * @param n
     * @param edges
     * @return
     */
    /**
     * 判断当前节点 所连接的全部节点数目
     *
     * @param n
     * @param edges
     * @return
     */
    public long countPairs(int n, int[][] edges) {
        int length = n;
        List<Integer>[] lists = new List[length];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        long res = 0;
        boolean[] flags = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 判断是否存在回路
            long count = dfsCountPairs(lists, i, flags);
            res += (n - count) * count;
        }
        return res / 2;
    }

    private long dfsCountPairs(List<Integer>[] lists, int i, boolean[] flags) {
        if (flags[i]) return 0;
        flags[i] = true;
        List<Integer> list = lists[i];
        long cntCount = 1;
        for (Integer integer : list) {
            long child = dfsCountPairs(lists, integer, flags);
            cntCount += child;
        }
        return cntCount;
    }

}
