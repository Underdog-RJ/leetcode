package cn.underdog.competition;


import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class ddd {
    public static void main(String[] args) {
//        System.out.println(minimumBuckets("HH......."));
//        System.out.println(minimumBuckets(".HH.HH.HH.HH..H"));
//        System.out.println(minimumBuckets(".HH.H.H.H.."));
//        System.out.println(minimumBuckets(".H.H"));

        minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7});
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words1.length; i++)
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        for (int i = 0; i < words2.length; i++)
            map2.put(words2[i], map2.getOrDefault(words2[i], 0) + 1);
        int res = 0;
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(1)) {
                String key = entry.getKey();
                if (map2.containsKey(key) && map2.get(key) == 1)
                    res++;
            }
        }
        return res;

    }

    /*
    优先右边放置水桶：右边放置水桶，下一个左边也可以使用，一次可以跳过2个位置，贪心选择最优
    如果右边无法放置水桶，则看左边是否能放置水桶，如果左边可以，则进行下一个，如果左边不行
    则直接返回-1无法放置水桶
     */

    /**
     * 给你一个下标从 0 开始的字符串 street 。street 中每个字符要么是表示房屋的 'H' ，要么是表示空位的 '.' 。
     * <p>
     * 你可以在 空位 放置水桶，从相邻的房屋收集雨水。位置在 i - 1 或者 i + 1 的水桶可以收集位置为 i 处房屋的雨水。一个水桶如果相邻两个位置都有房屋，那么它可以收集 两个 房屋的雨水。
     * <p>
     * 在确保 每个 房屋旁边都 至少 有一个水桶的前提下，请你返回需要的 最少 水桶数。如果无解请返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：street = "H..H"
     * 输出：2
     * 解释：
     * 我们可以在下标为 1 和 2 处放水桶。
     * "H..H" -> "HBBH"（'B' 表示放置水桶）。
     * 下标为 0 处的房屋右边有水桶，下标为 3 处的房屋左边有水桶。
     * 所以每个房屋旁边都至少有一个水桶收集雨水。
     * 示例 2：
     * <p>
     * 输入：street = ".H.H."
     * 输出：1
     * 解释：
     * 我们可以在下标为 2 处放置一个水桶。
     * ".H.H." -> ".HBH."（'B' 表示放置水桶）。
     * 下标为 1 处的房屋右边有水桶，下标为 3 处的房屋左边有水桶。
     * 所以每个房屋旁边都至少有一个水桶收集雨水。
     * 示例 3：
     * <p>
     * 输入：street = ".HHH."
     * 输出：-1
     * 解释：
     * 没有空位可以放置水桶收集下标为 2 处的雨水。
     * 所以没有办法收集所有房屋的雨水。
     * 示例 4：
     * <p>
     * 输入：street = "H"
     * 输出：-1
     * 解释：
     * 没有空位放置水桶。
     * 所以没有办法收集所有房屋的雨水。
     * 示例 5：
     * <p>
     * 输入：street = "."
     * 输出：0
     * 解释：
     * 没有房屋需要收集雨水。
     * 所以需要 0 个水桶。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param street
     * @return
     */
    public static int minimumBuckets(String street) {
        int res = 0;
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) == 'H') {
                if (i + 1 < street.length() && street.charAt(i + 1) == '.') {
                    i += 2;
                    res++;
                }
                if (i - 1 >= 0 && street.charAt(i - 1) == '.') {
                    res++;
                } else {
                    return -1;
                }
            }
        }
        return res;
    }


    /**
     * 给你一个 m x n 的网格图，其中 (0, 0) 是最左上角的格子，(m - 1, n - 1) 是最右下角的格子。给你一个整数数组 startPos ，startPos = [startrow, startcol] 表示 初始 有一个 机器人 在格子 (startrow, startcol) 处。同时给你一个整数数组 homePos ，homePos = [homerow, homecol] 表示机器人的 家 在格子 (homerow, homecol) 处。
     * <p>
     * 机器人需要回家。每一步它可以往四个方向移动：上，下，左，右，同时机器人不能移出边界。每一步移动都有一定代价。再给你两个下标从 0 开始的额整数数组：长度为 m 的数组 rowCosts  和长度为 n 的数组 colCosts 。
     * <p>
     * 如果机器人往 上 或者往 下 移动到第 r 行 的格子，那么代价为 rowCosts[r] 。
     * 如果机器人往 左 或者往 右 移动到第 c 列 的格子，那么代价为 colCosts[c] 。
     * 请你返回机器人回家需要的 最小总代价 。
     * 输入：startPos = [1, 0], homePos = [2, 3], rowCosts = [5, 4, 3], colCosts = [8, 2, 6, 7]
     * 输出：18
     * 解释：一个最优路径为：
     * 从 (1, 0) 开始
     * -> 往下走到 (2, 0) 。代价为 rowCosts[2] = 3 。
     * -> 往右走到 (2, 1) 。代价为 colCosts[1] = 2 。
     * -> 往右走到 (2, 2) 。代价为 colCosts[2] = 6 。
     * -> 往右走到 (2, 3) 。代价为 colCosts[3] = 7 。
     * 总代价为 3 + 2 + 6 + 7 = 18
     * 示例 2：
     * <p>
     * 输入：startPos = [0, 0], homePos = [0, 0], rowCosts = [5], colCosts = [26]
     * 输出：0
     * 解释：机器人已经在家了，所以不需要移动。总代价为 0 。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param startPos
     * @param homePos
     * @param rowCosts
     * @param colCosts
     * @return
     */
    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {

        // 如果两个数组相等，则直接返回，不需要移动
        if (Arrays.equals(startPos, homePos))
            return 0;
        // 贪心法，每次向着最优的方向移动，不管怎么移动都是直接向着目标移动最近
        // 计算行需要移动的方向
        int rowD = homePos[0] - startPos[0];
        // 计算列需要移动的方向
        int colD = homePos[1] - startPos[1];
        int res = 0;
        // 如果行方向为正，
        if (rowD > 0) {
            int temp = rowD;
            int index = startPos[0];
            while (temp != 0) {
                res += rowCosts[++index];
                temp--;
            }
        }
        // 如果行方向为负
        else if (rowD < 0) {
            int temp = Math.abs(rowD);
            int index = startPos[0];
            while (temp != 0) {
                res += rowCosts[--index];
                temp--;
            }
        }
        // 如果列方向为正
        if (colD > 0) {
            int temp = colD;
            int index = startPos[1];
            while (temp != 0) {
                res += colCosts[++index];
                temp--;
            }
        }
        // 如果列方向为负
        else if (colD < 0) {
            int temp = Math.abs(colD);
            int index = startPos[1];
            while (temp != 0) {
                res += colCosts[--index];
                temp--;
            }
        }

        return res;


    }


}
