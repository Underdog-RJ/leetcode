package cn.underdog.leetcode.prefixSum;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Practice practice = new Practice();
        practice.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
    }


    /**
     * 你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。
     * <p>
     * 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
     * <p>
     * 第 i 天前和后都分别至少有 time 天。
     * 第 i 天前连续 time 天警卫数目都是非递增的。
     * 第 i 天后连续 time 天警卫数目都是非递减的。
     * 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
     * <p>
     * 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：security = [5,3,3,3,5,6,2], time = 2
     * 输出：[2,3]
     * 解释：
     * 第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
     * 第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
     * 没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
     * 示例 2：
     * <p>
     * 输入：security = [1,1,1,1,1], time = 0
     * 输出：[0,1,2,3,4]
     * 解释：
     * 因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
     * 示例 3：
     * <p>
     * 输入：security = [1,2,3,4,5,6], time = 2
     * 输出：[]
     * 解释：
     * 没有任何一天的前 2 天警卫数目是非递增的。
     * 所以没有适合打劫银行的日子，返回空数组。
     * 示例 4：
     * <p>
     * 输入：security = [1], time = 5
     * 输出：[]
     * 解释：
     * 没有日子前面和后面有 5 天时间。
     * 所以没有适合打劫银行的日子，返回空数组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param security
     * @param time
     * @return
     */
    /*public List<Integer> goodDaysToRobBank(int[] security, int time) {
        // 前缀和
        int length = security.length;
        int[] prev = new int[length];
        int[] last = new int[length];
        // 前缀当前天的有多少天是连续递减的。
        prev[0] = 0;
        for (int i = 1; i < security.length; i++) {
            if (security[i - 1] >= security[i]) {
                prev[i] = prev[i - 1] + 1;
            } else {
                prev[i] = 0;
            }
        }
        // 后缀当前天之后有多少天是递增的
        last[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                last[i] = last[i + 1] + 1;
            } else {
                last[i] = 0;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (prev[i] >= time && last[i] >= time)
                res.add(i);
        }
        return res;

    }*/

    // 滑动窗口
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        if (security.length <= time * 2 + 1)
            return res;
        if (time == 0) {
            for (int i = 0; i < security.length; i++)
                res.add(i);
            return res;
        }
        int up = 0;
        // 判断从0-time不符合要求的数量
        for (int i = 0; i < time; i++) {
            if (security[i] < security[i + 1])
                up++;
        }
        // 判断从time-time+time的不符合要求的数量
        int down = 0;
        for (int i = 0; i < time + time; i++) {
            if (security[i] > security[i + 1])
                down++;
        }
        // 通过滑动窗口减小计算量
        for (int i = time + 1; i <= security.length - time; i++) {
            if (up == 0 && down == 0)
                res.add(i - 1);
            if (i == security.length - time)
                break;
            // 判断上次的不满足情况
            if (security[i - time - 1] < security[i - time])
                up--;
            if (security[i - 1] < security[i])
                up++;
            // 判断down
            if (security[i - 1] > security[i])
                down--;
            if (security[i + time - 1] > security[i + time])
                down++;
        }
        return res;
    }

    /**
     * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
     * <p>
     * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
     * <p>
     * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
     * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
     * 输出：[2,3]
     * 解释：
     * - queries[0] 有两个盘子在蜡烛之间。
     * - queries[1] 有三个盘子在蜡烛之间。
     * 示例 2:
     * <p>
     * <p>
     * <p>
     * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
     * 输出：[9,0,0,0,0]
     * 解释：
     * - queries[0] 有 9 个盘子在蜡烛之间。
     * - 另一个查询没有盘子在蜡烛之间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plates-between-candles
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param queries
     * @return
     */
    // 使用treesort
    /*public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        int[] stars = new int[length];
        int[] res = new int[queries.length];
        // 前缀和统计当前出现的数量
        stars[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '*')
                stars[i] = stars[i - 1] + 1;
            else
                stars[i] = stars[i - 1];
        }
        // TreeSort来统计每个|出现的位置
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '|')
                treeSet.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            Integer lF = treeSet.ceiling(left);
            Integer rF = treeSet.floor(right);
            if (lF == null || rF == null || lF >= rF) {
                res[i] = 0;
            } else {
                res[i] = stars[rF] - stars[lF];
            }
        }
        return res;
    }*/
    // 自定义数组
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        int[] stars = new int[length];
        int[] res = new int[queries.length];
        // 前缀和统计当前出现的数量
        stars[0] = s.charAt(0) == '*' ? 1 : 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '*')
                stars[i] = stars[i - 1] + 1;
            else
                stars[i] = stars[i - 1];
        }
        // 用两个数组来存储最近的left和right出现的位置
        int[] leftDist = new int[length];
        int[] rightDist = new int[length];

        int tmp = -1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != '*')
                tmp = i;
            leftDist[i] = tmp;
        }
        tmp = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != '*')
                tmp = i;
            rightDist[i] = tmp;
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int lF = rightDist[left];
            int rF = leftDist[right];
            if (lF == -1 || rF == -1 || lF > rF)
                res[i] = 0;
            else
                res[i] = stars[rF] - stars[lF];
        }

        return res;
    }

}
