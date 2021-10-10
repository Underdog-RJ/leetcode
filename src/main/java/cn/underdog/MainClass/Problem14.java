package cn.underdog.MainClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 *
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 *
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 * 输入：machines = [1,0,5]
 * 输出：3
 * 解释：
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3
 * 第三步:    2     1 <-- 3    =>    2     2     2
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem14 {

    public static void main(String[] args) {
        int[] machines = {9,1,8,8,9};
        int minMoves = findMinMoves(machines);
        System.out.println(minMoves);
    }

    /**
     * 思路：
     *      1.如果衣服等不能平均分配直接返回-1
     *      2.因为题中说明，每次最多可以向m个相邻洗衣机移动一件衣服，
     *        则找出需要移动最多的即可遍历集合，前i个为一组标记为A，
     *        剩余的为一组标记为B.
     *          currentAvg : 代表当前元素-品均值
     *          currentTotalAvg: 代表前A组内全部的平均值
     *
     *          2.1
     *              当currentTotalAvg为正时，代表A内元素多余平均值，需要向B组内移动currentTotalAvg个
     *              当currentTotalAvg为正时，代表A内元素多余平均值，需要向B组内移动Math.abs(currentTotalAvg)个
     *          2.2
     *              当本次第i个 元素 数量大于平均值时，需要向左右两侧移动machines[i]-avg个元素
     *      3.遍历数组
     *          3.1 每次比较2.1和2.2中的最大值。
     *
     * @param machines
     * @return
     */
    public static int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();

        if(sum%machines.length!=0)
            return -1;

        int ans = 0;
        int currentTotalAvg = 0;
        int avg= sum/machines.length;
        for (int num : machines) {
           int currentAvg =num-avg;
           currentTotalAvg += currentAvg;
           int max = Math.max(currentAvg,Math.abs(currentTotalAvg));
           ans = Math.max(ans,max);
        }
        return ans;
    }
}
