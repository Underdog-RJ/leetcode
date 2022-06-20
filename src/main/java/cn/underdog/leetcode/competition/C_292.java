package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

public class C_292 {

    public static void main(String[] args) {

    }

    /**
     * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
     * <p>
     * 该整数是 num 的一个长度为 3 的 子字符串 。
     * 该整数由唯一一个数字重复 3 次组成。
     * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
     * <p>
     * 注意：
     * <p>
     * 子字符串 是字符串中的一个连续字符序列。
     * num 或优质整数中可能存在 前导零 。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = "6777133339"
     * 输出："777"
     * 解释：num 中存在两个优质整数："777" 和 "333" 。
     * "777" 是最大的那个，所以返回 "777" 。
     * 示例 2：
     * <p>
     * 输入：num = "2300019"
     * 输出："000"
     * 解释："000" 是唯一一个优质整数。
     * 示例 3：
     * <p>
     * 输入：num = "42352338"
     * 输出：""
     * 解释：不存在长度为 3 且仅由一个唯一数字组成的整数。因此，不存在优质整数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-3-same-digit-number-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
   /* public String largestGoodInteger(String num) {
        String res = "";
        Out:
        for (int i = 0; i <= num.length() - 3; i++) {
            String str = num.substring(i, i + 3);
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) != str.charAt(j + 1)) {
                    continue Out;
                }
            }
            int tmp = res.compareTo(str);
            if (tmp < 0) {
                res = str;
            }
        }
        return res;
    }*/
    public String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            if (num.contains("" + i + i + i))
                return "" + i + i + i;
        }
        return "";
    }


    /**
     * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
     * <p>
     * 注意：
     * <p>
     * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
     * root 的 子树 由 root 和它的所有后代组成。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [4,8,5,0,1,null,6]
     * 输出：5
     * 解释：
     * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
     * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
     * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
     * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
     * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [1]
     * 输出：1
     * 解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-nodes-equal-to-average-of-subtree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 采用后续遍历，返回每个节点的孩子的孩子个数，和总和
     */
    int totalAvg = 0;

    public int averageOfSubtree(TreeNode root) {
        // 1.先统计当前节点的节点个数
        dfsAvg(root);
        return totalAvg;
    }

    private int[] dfsAvg(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            int count = 1;
            int sum = root.val;
            int[] ints = dfsAvg(root.left);
            int[] ints1 = dfsAvg(root.right);
            sum += ints[0] + ints1[0];
            count += ints[1] + ints1[1];
            if (root.val == sum / count) {
                totalAvg++;
            }
            return new int[]{sum, count};
        }
    }

    /**
     * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
     * <p>
     * <p>
     * <p>
     * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
     * <p>
     * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
     * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
     * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
     * <p>
     * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
     * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
     * <p>
     * 由于答案可能很大，将它对 109 + 7 取余 后返回。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：pressedKeys = "22233"
     * 输出：8
     * 解释：
     * Alice 可能发出的文字信息包括：
     * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
     * 由于总共有 8 种可能的信息，所以我们返回 8 。
     * 示例 2：
     * <p>
     * 输入：pressedKeys = "222222222222222222222222222222222222"
     * 输出：82876089
     * 解释：
     * 总共有 2082876103 种 Alice 可能发出的文字信息。
     * 由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-number-of-texts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 思路：1进行分段，总和=段1*段2*段3...段n
     * 分别求出每段
     * 转换为背包问题：其中背包的重量为段的长度，物品的价格有两种（234568对应的都有三个）----{1.2.3} （79对应的都有四个）{1，2，3，4}
     * 每个物品可以选择无限次所以转换为完全背包问题
     * dp[i] 的定义为容量为i的背包有多少种组成方案
     * 在完全背包中两个
     * 如果对于求最大或者最小的问题，两个for循环的遍历顺序可以颠倒
     * 如果时组合问题：外层for循环是物品个数，内层for循环时背包容量 （因为此时只需要一种循序就行，比如说1,3和3,1对应的时同一种情况因此外层for为物品个数时此时顺序为正序）
     * 如果时排列问题：外层for循环时容量，内容for循环时物品个数(因为此时需要全部的顺序1,3和3,1时两种不同的，外层容量固定，内容的物品循序可以无序)
     * 针对此题来说  22，2（b,a）和2，22(a,b)表达的意思不同则为排序问题
     * 对于每个状态dp[i]（每个容量为i的背包的的组成方案）可以有每个物品j推出来
     * dp[i] += dp[i-nums[j]]
     *
     * @param pressedKeys
     * @return
     */
    public int countTexts(String pressedKeys) {
        long res = 1;
        int mod = 1000000007;
        int[] coings1 = new int[]{1, 2, 3};
        int[] coings2 = new int[]{1, 2, 3, 4};
        int preIndex = 0;
        char preChar = pressedKeys.charAt(0);
        for (int i = 1; i < pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i) != preChar) {
                int total = i - preIndex;
                char tmp = preChar;
                preChar = pressedKeys.charAt(i);
                preIndex = i;
                res *= change((tmp == '7' || tmp == '9') ? coings2 : coings1, total);
                res %= mod;
            }
        }
        // 计算最后一次
        int total = pressedKeys.length() - preIndex;
        char tmp = pressedKeys.charAt(pressedKeys.length() - 1);
        res *= change((tmp == '7' || tmp == '9') ? coings2 : coings1, total) % mod;
        res %= mod;
        return (int) res;
    }

    public int change(int[] nums, int target) {
        int mod = 1000000007;
        // 定义dp[i]为容量为i 的背包有多少种排列方式
        long[] dp = new long[target + 1];
        // 初始化dp
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                    dp[i] %= mod;
                }
            }
        }
        return (int) dp[target];
    }


}
