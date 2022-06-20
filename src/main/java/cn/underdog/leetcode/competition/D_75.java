package cn.underdog.leetcode.competition;

/**
 * @author underdog_rj
 * @date2022/4/59:16
 */
public class D_75 {


    public static void main(String[] args) {
        D_75 d_75 = new D_75();
//        d_75.numberOfWays("001101");

//        d_75.triangularSum_1(new int[]{1, 2, 3, 4, 5});

        d_75.numberOfWays_1("001101");
    }


    /**
     * 思路：原本想的是，比较字符串的长度，拼接成相同的字符串=
     * 太慢了，直接进行异或运算,统计1的个数
     * 一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。
     * <p>
     * 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。
     * 给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：start = 10, goal = 7
     * 输出：3
     * 解释：10 和 7 的二进制表示分别为 1010 和 0111 。我们可以通过 3 步将 10 转变成 7 ：
     * - 翻转右边起第一位得到：1010 -> 1011 。
     * - 翻转右边起第三位：1011 -> 1111 。
     * - 翻转右边起第四位：1111 -> 0111 。
     * 我们无法在 3 步内将 10 转变成 7 。所以我们返回 3 。
     * 示例 2：
     * <p>
     * 输入：start = 3, goal = 4
     * 输出：3
     * 解释：3 和 4 的二进制表示分别为 011 和 100 。我们可以通过 3 步将 3 转变成 4 ：
     * - 翻转右边起第一位：011 -> 010 。
     * - 翻转右边起第二位：010 -> 000 。
     * - 翻转右边起第三位：000 -> 100 。
     * 我们无法在 3 步内将 3 变成 4 。所以我们返回 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-bit-flips-to-convert-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param start
     * @param goal
     * @return
     */
  /*  public int minBitFlips(int start, int goal) {
        int a = start ^ goal;
        int count = 0;
        String string = Integer.toBinaryString(a);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1')
                count++;
        }
        return count;
    }*/

    /**
     * 用位图统计
     *
     * @param start
     * @param goal
     * @return
     */
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }


    /**
     * 原本的思路是，用list来添加元素，每次在清空元素， 最后求0个，但是内存空间浪费太大。
     * 观察到，本次数组前面的用了一次，可以节省空间
     * 给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是 0 到 9 之间（两者都包含）的一个数字。
     * <p>
     * nums 的 三角和 是执行以下操作以后最后剩下元素的值：
     * <p>
     * nums 初始包含 n 个元素。如果 n == 1 ，终止 操作。否则，创建 一个新的下标从 0 开始的长度为 n - 1 的整数数组 newNums 。
     * 对于满足 0 <= i < n - 1 的下标 i ，newNums[i] 赋值 为 (nums[i] + nums[i+1]) % 10 ，% 表示取余运算。
     * 将 newNums 替换 数组 nums 。
     * 从步骤 1 开始 重复 整个过程。
     * 请你返回 nums 的三角和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：nums = [1,2,3,4,5]
     * 输出：8
     * 解释：
     * 上图展示了得到数组三角和的过程。
     * 示例 2：
     * <p>
     * 输入：nums = [5]
     * 输出：5
     * 解释：
     * 由于 nums 中只有一个元素，数组的三角和为这个元素自己。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-triangular-sum-of-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int triangularSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

    /**
     * 思路：想要不重复的类型，===只有两种类型  0 1 0  和 1 0 1
     * 如果当前位置是 0 统计前后 1 的数量
     * 如果当前位置是 1 统计前后 0 的数量
     * 我们可以用前缀和的思路，需要维护四个数组，浪费空间
     * 我们可以转换统计当前查找到的 1 的数量，然后用 用i 减去1的数量就是0的数量，维护一个后缀数组，统计1的数量，用总数减去其余三个
     * 给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中：
     * <p>
     * s[i] = '0' 表示第 i 栋建筑是一栋办公楼，
     * s[i] = '1' 表示第 i 栋建筑是一间餐厅。
     * 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。
     * <p>
     * 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合 题意。
     * 请你返回可以选择 3 栋建筑的 有效方案数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "001101"
     * 输出：6
     * 解释：
     * 以下下标集合是合法的：
     * - [0,2,4] ，从 "001101" 得到 "010"
     * - [0,3,4] ，从 "001101" 得到 "010"
     * - [1,2,4] ，从 "001101" 得到 "010"
     * - [1,3,4] ，从 "001101" 得到 "010"
     * - [2,4,5] ，从 "001101" 得到 "101"
     * - [3,4,5] ，从 "001101" 得到 "101"
     * 没有别的合法选择，所以总共有 6 种方法。
     * 示例 2：
     * <p>
     * 输入：s = "11100"
     * 输出：0
     * 解释：没有任何符合题意的选择。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-ways-to-select-buildings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public long numberOfWays(String s) {
        int length = s.length();
        int[] r2l1 = new int[s.length()];
        r2l1[length - 1] = s.charAt(length - 1) - '0';
        for (int i = length - 2; i >= 0; i--)
            r2l1[i] += s.charAt(i) - '0' + r2l1[i + 1];
        long count = 0, one = 0;
        for (int i = 0; i < length; i++) {
            count += s.charAt(i) == '0' ? one * r2l1[i] : (i - one) * (length - i - r2l1[i]);
            one += s.charAt(i) - '0';
        }
        return count;
    }


    /**
     * 滚动数组
     *
     * @param nums
     * @return
     */
    public int triangularSum_1(int[] nums) {
        int total = 1;
        int length = nums.length;
        while (total != length) {
            for (int i = 0; i < nums.length - total; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            total++;
        }
        return nums[0];
    }

    /**
     * 思路：
     *      如果想要三个补充和，只有两种情况  101 和010 这个两种
     *          对于每个字符，如果当前值为1则统计，前面和后面0的数量
     *          如果当前值为0则统计前面和后面1的数量即可，
     * 实现方式：
     *      为了降低时间复杂度：使用前后缀数组，
     *          对于前面出现的0来变量统计zero
     *          对于前面出现的1来 i-zero
     *          对于后面出现的0来统计后缀数组实现lastSum[i]
     *          对于后面出现的1来统计后缀数组实现length - i -lastSum[i]
     * @param s
     * @return
     */
    public long numberOfWays_1(String s) {
        // 统计后缀和
        int length = s.length();
        long[] lastSum = new long[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) - '0' == 0) {
                lastSum[i] = lastSum[i + 1] + 1;
            } else {
                lastSum[i] = lastSum[i + 1];
            }
        }
        int zero = 0;
        long count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) - '0' == 0) {
                count += (i - zero) * (length - i - lastSum[i]);
                zero++;
            } else {
                count += zero * lastSum[i];
            }
        }
        return count;
    }


}
