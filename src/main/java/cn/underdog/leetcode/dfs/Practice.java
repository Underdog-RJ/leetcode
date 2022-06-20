package cn.underdog.leetcode.dfs;



import java.util.*;

public class Practice {
    public static void main(String[] args) {
        Practice practice = new Practice();
//        practice.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
//        practice.countHighestScoreNodes(new int[]{-1, 0});


    }

    int cnt = 1;
    int max = 0;

    /**
     * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
     * <p>
     * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
     * <p>
     * 请你返回有 最高得分 节点的 数目 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
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

    long globalMax = 0;
    int globalCount = 0;

    public int countHighestScoreNodes(int[] parents) {
        // 当前树的节点个数
        int count = parents.length;
        // 统计每个树的孩子形况，拓扑排序
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1)
                continue;
            List<Integer> orDefault = map.getOrDefault(parents[i], new ArrayList<>());
            orDefault.add(i);
            map.put(parents[i], orDefault);
        }
        dfsCountHighestScoreNodes(count, map, 0);
        return globalCount;
    }

    private int dfsCountHighestScoreNodes(int count, Map<Integer, List<Integer>> map, int i) {
        int currentCount = count - 1;
        long score = 1;
        List<Integer> orDefault = map.getOrDefault(i, new ArrayList<>());
        // 如果当前节点有孩子
        for (Integer integer : orDefault) {
            // 计算当前节点的此次深度优先，移动有多少个孩子
            int childrenCounts = dfsCountHighestScoreNodes(count, map, integer);
            currentCount -= childrenCounts;
            score *= childrenCounts;
        }
        // 如果当前没孩子
        if (i != 0) {
            score *= currentCount;
        }
        // 如果当前值等于全局最大值，则数量++
        if (score == globalMax) {
            globalCount++;
        }
        // 此时更新全局最大值，将数量置为1
        else if (score > globalMax) {
            globalCount = 1;
            globalMax = score;
        }
        return count - currentCount;
    }
}
