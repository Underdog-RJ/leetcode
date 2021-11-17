package cn.underdog.greedy;

import java.util.*;

public class M_MainClass {

    public static void main(String[] args) {
        removeDuplicateLetters("cbacdcbc");
//        removeDuplicateLetters("bcabc");
    }

    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * <p>
     * 说明: 
     * <p>
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     * 示例 1:
     * <p>
     * 输入:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * <p>
     * 输出: 3
     * <p>
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     * 示例 2:
     * <p>
     * 输入:
     * gas  = [2,3,4]
     * cost = [3,4,3]
     * <p>
     * 输出: -1
     * <p>
     * 解释:
     * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
     * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
     * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
     * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
     * 因此，无论怎样，你都不可能绕环路行驶一周。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/gas-station
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return 0;
    }


    /**
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     * <p>
     * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "bcabc"
     * 输出："abc"
     * 示例 2：
     * <p>
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        List<Character> list = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (list.contains(s.charAt(i))) {
                Character character = list.get(list.size() - 1);
                int index = list.indexOf(s.charAt(i));
                int i0 = character - 'a';
                int i1 = list.get(index + 1) - 'a';
                int i2 = list.get(index) - 'a';
                if (i1 < i2) {
                    if (index != list.size() - 1) {
                        list.remove(index);
                        list.add(s.charAt(i));
                    }
                } else {
                    if (i0 < i2) {
                        list.remove(index);
                        list.add(s.charAt(i));
                    }
                }

            } else {
                list.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();

    }
}
