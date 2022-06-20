package cn.underdog.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainClassH {
    public static void main(String[] args) {
        MainClassH mainClassH = new MainClassH();
//        mainClassH.maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}});
        mainClassH.maxEnvelopes(new int[][]{{2, 1}, {4, 1}, {6, 2}, {8, 3}, {10, 5}, {12, 8}, {14, 13}, {16, 21}, {18, 34}, {20, 55}});
    }

    /**
     * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
     * <p>
     * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * <p>
     * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     * <p>
     * 注意：不允许旋转信封。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
     * 输出：3
     * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
     * 示例 2：
     * <p>
     * 输入：envelopes = [[1,1],[1,1],[1,1]]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= envelopes.length <= 105
     * envelopes[i].length == 2
     * 1 <= wi, hi <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/russian-doll-envelopes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param envelopes
     * @return
     */
    // 超时
   /* public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });
        int length = envelopes.length;
        // 定义dp[i]为i结尾的最长自增子序列
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }*/
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o2[0], o1[0]);
            }
        });
        int length = envelopes.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int[] lisNum = new int[length];
        int max = 1;
        int cntIndex = 0;
        lisNum[cntIndex++] = envelopes[0][0];
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][0] > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = envelopes[i][0];
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] < envelopes[i][0]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                lisNum[left] = envelopes[i][0];
            }
            max = Math.max(max, cntIndex);
        }
        return max;
    }


}
