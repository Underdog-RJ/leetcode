package cn.underdog.leetcode.bitoperation;

/**
 * 异或运算的
 * 性值：
 * a^a = 0;
 * a^b = b^a
 * a^b^c = a^(b^c) = (a^b)^c
 * d= a^b^c 可以推出a=d^b^c
 * a^b^a = b
 * 简单使用:
 * 1.两数字交换
 * a = a^b
 * b = a^b
 * a = a^b
 * 2.判断奇偶
 * a^1 ==1?偶数：奇数
 *
 * @author underdog_rj
 * @date2022/3/269:13
 */
public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
        mainClass.countPrimeSetBits(10, 15);
    }


    /**
     * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
     * <p>
     * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
     * <p>
     * 并返回一个包含给定查询 queries 所有结果的数组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
     * 输出：[2,7,14,8]
     * 解释：
     * 数组中元素的二进制表示形式是：
     * 1 = 0001
     * 3 = 0011
     * 4 = 0100
     * 8 = 1000
     * 查询的 XOR 值为：
     * [0,1] = 1 xor 3 = 2
     * [1,2] = 3 xor 4 = 7
     * [0,3] = 1 xor 3 xor 4 xor 8 = 14
     * [3,3] = 8
     * 示例 2：
     * <p>
     * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
     * 输出：[8,0,4,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int length = arr.length;
        int[] preSum = new int[length];
        preSum[0] = arr[0];
        for (int i = 1; i < length; i++) {
            preSum[i] = preSum[i - 1] ^ arr[i];
        }
        int qLength = queries.length;
        int[] res = new int[qLength];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (start == 0) {
                res[i] = preSum[end];
            } else {
                res[i] = preSum[end] ^ preSum[start - 1];
            }
        }
        return res;
    }

    /**
     * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 5
     * 输出：true
     * 解释：5 的二进制表示是：101
     * 示例 2：
     * <p>
     * 输入：n = 7
     * 输出：false
     * 解释：7 的二进制表示是：111.
     * 示例 3：
     * <p>
     * 输入：n = 11
     * 输出：false
     * 解释：11 的二进制表示是：1011.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {

        String string = Integer.toBinaryString(n);
        if (string.length() == 1)
            return true;
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1))
                return false;
        }
        return true;

    }

    /**
     * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
     * <p>
     * 计算置位位数 就是二进制表示中 1 的个数。
     * <p>
     * 例如， 21 的二进制表示 10101 有 3 个计算置位。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：left = 6, right = 10
     * 输出：4
     * 解释：
     * 6 -> 110 (2 个计算置位，2 是质数)
     * 7 -> 111 (3 个计算置位，3 是质数)
     * 9 -> 1001 (2 个计算置位，2 是质数)
     * 10-> 1010 (2 个计算置位，2 是质数)
     * 共计 4 个计算置位为质数的数字。
     * 示例 2：
     * <p>
     * 输入：left = 10, right = 15
     * 输出：5
     * 解释：
     * 10 -> 1010 (2 个计算置位, 2 是质数)
     * 11 -> 1011 (3 个计算置位, 3 是质数)
     * 12 -> 1100 (2 个计算置位, 2 是质数)
     * 13 -> 1101 (3 个计算置位, 3 是质数)
     * 14 -> 1110 (3 个计算置位, 3 是质数)
     * 15 -> 1111 (4 个计算置位, 4 不是质数)
     * 共计 5 个计算置位为质数的数字。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param left
     * @param right
     * @return
     */
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            int count = Integer.bitCount(i);
            if (count > 1 && isZhishu(count)) {
                res++;
            }
        }
        return res;
    }

    private boolean isZhishu(int count) {
        int target = (int) Math.sqrt(count);
        for (int i = 2; i <= target; i++) {
            if (count % i == 0)
                return false;
        }
        return true;
    }
}
