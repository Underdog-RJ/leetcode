package cn.underdog.competition;

import java.util.*;
import java.util.stream.Collectors;

public class D_67 {
    public static void main(String[] args) {
        D_67 d_67 = new D_67();
//        d_67.maxSubsequence(new int[]{3, 4, 3, 3}, 2);
//        d_67.maxSubsequence(new int[]{-1, -2, 3, 4}, 3);
//        d_67.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
//        d_67.goodDaysToRobBank(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2);
//        d_67.goodDaysToRobBank(new int[]{4, 3, 2, 1}, 1);
//        System.out.println(d_67.goodDaysToRobBank(new int[]{4, 3, 2, 1}, 1));
//        System.out.println(d_67.goodDaysToRobBank(new int[]{0, 0, 0, 0, 0}, 3));
        System.out.println(d_67.goodDaysToRobBank(new int[]{1, 1}, 1));
    }

    public int[] maxSubsequence(int[] nums, int k) {

        int[] res = new int[k];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            Integer integer = list.stream().min(Comparator.comparing(item -> item.intValue())).get();
            if (integer < nums[i]) {
                list.remove(integer);
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int length = security.length;
        // 直接返回
        if (time == 0) {
            for (int i = 0; i < length; i++) {
                res.add(i);
            }
            return res;
        }

        if (time > length)
            return res;
        List<Boolean> listA = new ArrayList<>();
        List<Boolean> listB = new ArrayList<>();
        int total = time * 2;
        if (total >= length)
            return res;
        for (int i = 0; i < time; i++) {
            if (security[i] < security[i + 1])
                listA.add(false);
            else
                listA.add(true);
        }

        for (int i = time; i < total && total < length; i++) {
            if (security[i] > security[i + 1])
                listB.add(false);
            else
                listB.add(true);
        }
        if (!listA.contains(false) && !listB.contains(false))
            res.add(time);

        OUT:
        for (int i = time + 1; i < security.length - time; i++) {
            // 开始非递增
           /* for (int j = i - time; j < i; j++) {
                if (security[j] < security[j + 1])
                    continue OUT;
            }
            // 结束非递减
            for (int u = i; u < i + time; u++) {
                if (security[u] > security[u + 1])
                    continue OUT;
            }*/
            listA.remove(0);
            if (security[i - 1] < security[i])
                listA.add(false);
            else
                listA.add(true);
            listB.remove(0);
            if (security[i + time - 1] > security[i + time])
                listB.add(false);
            else
                listB.add(true);

            if (!listA.contains(false) && !listB.contains(false))
                res.add(i);
        }


        return res;
    }

    /**
     * 给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
     * <p>
     * 炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
     * <p>
     * 你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
     * <p>
     * 给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：bombs = [[2,1,3],[6,1,4]]
     * 输出：2
     * 解释：
     * 上图展示了 2 个炸弹的位置和爆炸范围。
     * 如果我们引爆左边的炸弹，右边的炸弹不会被影响。
     * 但如果我们引爆右边的炸弹，两个炸弹都会爆炸。
     * 所以最多能引爆的炸弹数目是 max(1, 2) = 2 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：bombs = [[1,1,5],[10,10,5]]
     * 输出：1
     * 解释：
     * 引爆任意一个炸弹都不会引爆另一个炸弹。所以最多能引爆的炸弹数目为 1 。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
     * 输出：5
     * 解释：
     * 最佳引爆炸弹为炸弹 0 ，因为：
     * - 炸弹 0 引爆炸弹 1 和 2 。红色圆表示炸弹 0 的爆炸范围。
     * - 炸弹 2 引爆炸弹 3 。蓝色圆表示炸弹 2 的爆炸范围。
     * - 炸弹 3 引爆炸弹 4 。绿色圆表示炸弹 3 的爆炸范围。
     * 所以总共有 5 个炸弹被引爆。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/detonate-the-maximum-bombs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param bombs
     * @return
     */
    int res = 0;

    // TODO不会
    public int maximumDetonation(int[][] bombs) {
        dfsMaxmunDetonation(0, res, bombs);
        return res;
    }

    private void dfsMaxmunDetonation(int start, int res, int[][] bombs) {
        for (int j = start; j < bombs.length; j++) {
            int[] bomb = bombs[start];
            int[] wInt = new int[2];
            int[] sInt = new int[2];
            int[] aInt = new int[2];
            int[] dInt = new int[2];
            wInt[0] = bomb[0];
            wInt[1] = bomb[1] + bomb[2];
            sInt[0] = bomb[0];
            sInt[1] = bomb[1] - bomb[2];
            aInt[1] = bomb[1];
            aInt[1] = bomb[1] + bomb[2];
            wInt[0] = bomb[0];
            wInt[1] = bomb[1] + bomb[2];
        }
    }


}
