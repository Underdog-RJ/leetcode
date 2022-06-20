package cn.underdog.leetcode.design;

import java.util.*;

/**
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * <p>
 * 在一个给定的矩形覆盖的空间内任何整数点都有可能被返回。
 * <p>
 * 请注意 ，整数点是具有整数坐标的点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]
 * <p>
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 1.计算每个矩形有多少个点，用前缀和存储每个据行有多少个点
 * 2.在一共的点中随机生成一个数子，找出这个数组的对应的索引下标，并计算出剩余元素的个数
 * 3.计算X,Y轴的偏移量
 */
class Solution {

    int[][] rects = null;
    int[] preSum = null;

    public Solution(int[][] rects) {
        this.rects = rects;
        preSum = new int[rects.length + 1];
        for (int i = 0; i < rects.length; i++) {
            int a = rects[i][0], b = rects[i][1], c = rects[i][2], d = rects[i][3];
            preSum[i + 1] = preSum[i] + (c - a + 1) * (d - b + 1);
        }
    }

    public int[] pick() {
        Random random = new Random();
        int k = random.nextInt(preSum[preSum.length - 1]);
        int index = binarySearch(k + 1) - 1;
        int[] cur = rects[index];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }

    private int binarySearch(int k) {
        int left = 0, right = preSum.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (preSum[mid] == k)
                return mid;
            else if (preSum[mid] > k) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */