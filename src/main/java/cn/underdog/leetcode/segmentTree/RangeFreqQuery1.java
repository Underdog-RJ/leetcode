package cn.underdog.leetcode.segmentTree;

/**
 * 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
 * <p>
 * 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
 * <p>
 * 请你实现 RangeFreqQuery 类：
 * <p>
 * RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
 * int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
 * 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["RangeFreqQuery", "query", "query"]
 * [[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
 * 输出：
 * [null, 1, 2]
 * <p>
 * 解释：
 * RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
 * rangeFreqQuery.query(1, 2, 4); // 返回 1 。4 在子数组 [33, 4] 中出现 1 次。
 * rangeFreqQuery.query(0, 11, 33); // 返回 2 。33 在整个子数组中出现 2 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * 1 <= arr[i], value <= 104
 * 0 <= left <= right < arr.length
 * 调用 query 不超过 105 次。
 * 通过次数6,779提交次数22,895
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/range-frequency-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;

/**
 * 本题数据量小，直接开辟数组，不需要动态开点
 * 构造一个node节点，统计每个rt范围内每个数字出现的次数，
 */
public class RangeFreqQuery1 {

    /**
     * key:数字
     * value：次数
     */
    class Node {
        HashMap<Integer, Integer> cnt = new HashMap<>();
    }

    Node[] target = null;
    int[] arr = null;

    public RangeFreqQuery1(int[] arr) {
        int length = arr.length;
        this.arr = arr;
        target = new Node[length << 2];
        for (int i = 0; i < target.length; i++) {
            target[i] = new Node();
        }
        build(1, length, 1);
    }

    private void build(int l, int r, int rt) {
        for (int i = l; i <= r; i++) {
            HashMap<Integer, Integer> cnt = target[rt].cnt;
            cnt.put(arr[i - 1], cnt.getOrDefault(arr[i - 1], 0) + 1);
        }
        if (l == r)
            return;
        int mid = l + r >> 1;
        build(l, mid, rt << 1);
        build(mid, r, rt << 1 | 1);
    }

    public long query(int L, int R, int l, int r, int rt, int value) {
        if (L <= l && r <= R) {
            return target[rt].cnt.getOrDefault(value, 0);
        }
        int mid = l + r >> 1;
        long res = 0;
        if (L <= mid) {
            res += query(L, R, l, mid, rt << 1, value);
        }
        if (R > mid) {
            res += query(L, R, mid + 1, r, rt << 1 | 1, value);
        }
        return res;
    }


    /**
     * 从1开始所以左右都加1
     *
     * @param left
     * @param right
     * @param value
     * @return
     */
    public int query(int left, int right, int value) {
        return (int) query(left + 1, right + 1, 1, arr.length, 1, value);
    }


}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */