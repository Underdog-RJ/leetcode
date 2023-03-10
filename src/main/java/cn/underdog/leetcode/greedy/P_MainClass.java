package cn.underdog.leetcode.greedy;

import java.util.*;
import java.util.stream.Collectors;


public class P_MainClass {

    public static void main(String[] args) {
//        int ccc = longestPalindrome("ababababa");
//        int ccc = arrayPairSum(new int[]{1,4,3,2});
//        int ccc = arrayPairSum(new int[]{6, 2, 6, 5, 1, 2});
//        int ccc = findContentChildren(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3});
//        lemonadeChange(new int[]{5, 5, 5, 20});
//        validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
//        largestPerimeter(new int[]{2, 1, 2});
//        minSubsequence(new int[]{6});
//        minSubsequence(new int[]{4, 3, 10, 9, 8});
//        minSubsequence(new int[]{4, 4, 7, 6, 7});
//        System.out.println(largestSumAfterKNegations(new int[]{4, 2, 3}, 2));
        /*maximumUnits(new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}},
                35);*/
//        minOperations(new int[]{1, 5, 2, 4, 1});
//        minOperations(new int[]{1, 1, 1});
       /* String s = largestOddNumber("3691669784801845146");
        System.out.println(s);*/
//        int xxox = minimumMoves("XXOX");
//       int count =  balancedStringSplit("RLRRLLRLRL");
//        int count = balancedStringSplit("RRLRRLRLLLRL");
//        System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0, 1}, 2));
//        diStringMatch("III");
//        System.out.println(canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
//        canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});
//        minCostToMoveChips(new int[]{1, 2, 3});
//        minCostToMoveChips(new int[]{2, 2, 2, 3, 3});
//        minCostToMoveChips(new int[]{1,1000000000});
//        System.out.println(minTimeToType("pdy"));
        P_MainClass p_mainClass = new P_MainClass();
        p_mainClass.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
    }

    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * <p>
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * <p>
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * "abccccdd"
     * <p>
     * 输出:
     * 7
     * <p>
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int count = 0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        if (map.size() == 1) {
            return s.length();
        }
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value > 1) {
                if (value % 2 == 0) {
                    count += value;
                } else {
                    if (!flag) {
                        count += value;
                        flag = true;
                    } else {
                        count += value - 1;
                    }
                }
            } else {
                if (!flag) {
                    count++;
                    flag = true;
                }
            }
        }
        return count;
    }


    /**
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     * <p>
     * 返回该 最大总和 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,4,3,2]
     * 输出：4
     * 解释：所有可能的分法（忽略元素顺序）为：
     * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     * 所以最大总和为 4
     * 示例 2：
     * <p>
     * 输入：nums = [6,2,6,5,1,2]
     * 输出：9
     * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/array-partition-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            res += nums[i];
        }
        return res;
    }

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * <p>
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * <p>
     *  
     * 示例 1:
     * <p>
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     * <p>
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        boolean[] flag = new boolean[s.length];
        for (int i = 0; i < g.length; i++) {
            for (int j = i; j < s.length; j++) {
                if (s[j] >= g[i] && !flag[j]) {
                    res++;
                    flag[j] = true;
                    break;
                }
            }
        }
        return res;
    }


    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * <p>
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * <p>
     * 注意，一开始你手头没有任何零钱。
     * <p>
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：bills = [5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     * 示例 2：
     * <p>
     * 输入：bills = [5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lemonade-change
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param bills
     * @return
     */
    /*public static boolean lemonadeChange(int[] bills) {
        List<Integer> list5 = new ArrayList<>();
        List<Integer> list10 = new ArrayList<>();
        for (int bill : bills) {
            if (bill == 5) {
                list5.add(5);
            }
            if (bill == 10) {
                if (list5.size() == 0) {
                    return false;
                } else {
                    list10.add(10);
                    list5.remove(list5.size() - 1);
                }
            }
            if (bill == 20) {
                if (list5.size() == 0)
                    return false;
                if (list10.size() != 0) {
                    list10.remove(list10.size() - 1);
                    list5.remove(list5.size() - 1);
                } else {
                    if (list5.size() < 3)
                        return false;
                    else {
                        list5 = list5.stream().skip(3).collect(Collectors.toList());
                    }
                }
            }
        }
        return true;
    }*/


    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "aba"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "abca"
     * 输出: true
     * 解释: 你可以删除c字符。
     * 示例 3:
     * <p>
     * 输入: s = "abc"
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        return validPalindromeDg(s, 0, s.length() - 1, false);
    }

    public static boolean validPalindromeDg(String s, int left, int right, boolean flag) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (flag)
                    return false;
                if (left + 1 == right)
                    return true;
                return validPalindromeDg(s, left + 1, right, true) || validPalindromeDg(s, left, right - 1, true);
            }
        }
        return true;
    }

    /**
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
     * <p>
     * 如果不能形成任何面积不为零的三角形，返回 0。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[2,1,2]
     * 输出：5
     * 示例 2：
     * <p>
     * 输入：[1,2,1]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：[3,2,3,4]
     * 输出：10
     * 示例 4：
     * <p>
     * 输入：[3,6,2,3]
     * 输出：8
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int largestPerimeter(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                if (nums[i] + nums[i + 1] + nums[i + 2] > max) {
                    max = nums[i] + nums[i + 1] + nums[i + 2];
                }
            }
        }
        return max;
    }

    /**
     * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
     * <p>
     * 以这种方式修改数组后，返回数组可能的最大和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = [4,2,3], K = 1
     * 输出：5
     * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
     * 示例 2：
     * <p>
     * 输入：A = [3,-1,0,2], K = 3
     * 输出：6
     * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
     * 示例 3：
     * <p>
     * 输入：A = [2,-3,-1,5,-4], K = 2
     * 输出：13
     * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        while (k != 0) {
            if (nums[0] < 0) {
                nums[0] = -nums[0];
                k--;
                Arrays.sort(nums);
            } else if (nums[0] == 0) {
                k = 0;
            } else {
                if (k % 2 == 0) {
                    break;
                } else {
                    nums[0] = -nums[0];
                    break;
                }
            }
        }
        return Arrays.stream(nums).sum();
    }


    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int currentSum = 0;
        int tempSum = sum - currentSum;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (currentSum <= tempSum) {
                res.add(nums[i]);
            } else {
                break;
            }
            currentSum += nums[i];
            tempSum = sum - currentSum;
        }
        return res;
    }


    /**
     * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
     * <p>
     * numberOfBoxesi 是类型 i 的箱子的数量。
     * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
     * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
     * <p>
     * 返回卡车可以装载 单元 的 最大 总数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
     * 输出：8
     * 解释：箱子的情况如下：
     * - 1 个第一类的箱子，里面含 3 个单元。
     * - 2 个第二类的箱子，每个里面含 2 个单元。
     * - 3 个第三类的箱子，每个里面含 1 个单元。
     * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
     * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-units-on-a-truck
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> priorityQueue = new ArrayList<>();

        int num = boxTypes.length;

        for (int i = 0; i < num; i++) {
            priorityQueue.add(boxTypes[i]);
        }
        priorityQueue = priorityQueue.stream().sorted(Comparator.comparing(item -> item[1])).collect(Collectors.toList());
        Collections.reverse(priorityQueue);
        int count = 0;
        while (truckSize != 0) {
            if (priorityQueue.size() == 0)
                break;
            int[] poll = priorityQueue.remove(0);
            if (truckSize > poll[0]) {
                truckSize -= poll[0];
                count += poll[0] * poll[1];
            } else {
                count += truckSize * poll[1];
                break;
            }

        }
        return count;
    }

    /**
     * 给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
     * <p>
     * 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
     * 请你返回使 nums 严格递增 的 最少 操作次数。
     * <p>
     * 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。一个长度为 1 的数组是严格递增的一种特殊情况。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1]
     * 输出：3
     * 解释：你可以进行如下操作：
     * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
     * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
     * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,5,2,4,1]
     * 输出：14
     * 示例 3：
     * <p>
     * 输入：nums = [8]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
     * <p>
     * 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
     * 请你返回使 nums 严格递增 的 最少 操作次数。
     * <p>
     * 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。一个长度为 1 的数组是严格递增的一种特殊情况。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1]
     * 输出：3
     * 解释：你可以进行如下操作：
     * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
     * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
     * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,5,2,4,1]
     * 输出：14
     * 示例 3：
     * <p>
     * 输入：nums = [8]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int minOperations(int[] nums) {
        if (nums.length == 1)
            return 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                continue;
            if (nums[i] == nums[i - 1]) {
                nums[i]++;
                res++;
            }
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i - 1] - nums[i] + 1;
                res += temp;
                nums[i] += temp;
            }
        }
        return res;
    }

    /**
     * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
     * <p>
     * 子字符串 是字符串中的一个连续的字符序列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = "52"
     * 输出："5"
     * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
     * 示例 2：
     * <p>
     * 输入：num = "4206"
     * 输出：""
     * 解释：在 "4206" 中不存在奇数。
     * 示例 3：
     * <p>
     * 输入：num = "35427"
     * 输出："35427"
     * 解释："35427" 本身就是一个奇数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-odd-number-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public static String largestOddNumber(String num) {
        if (Integer.parseInt(num.charAt(num.length() - 1) + "") % 2 != 0) {
            return num;
        }
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            if (Integer.parseInt(num.charAt(right) + "") % 2 == 0) {
                right--;
            } else {
                break;
            }
        }
        String substring = num.substring(0, right + 1);
        return (Integer.parseInt(substring.charAt(substring.length() - 1) + "") % 2 == 0) ? "" : num.substring(0, right + 1);
    }

    /**
     * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
     * <p>
     * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
     * <p>
     * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "XXX"
     * 输出：1
     * 解释：XXX -> OOO
     * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
     * 示例 2：
     * <p>
     * 输入：s = "XXOX"
     * 输出：2
     * 解释：XXOX -> OOOX -> OOOO
     * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
     * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
     * 示例 3：
     * <p>
     * 输入：s = "OOOO"
     * 输出：0
     * 解释：s 中不存在需要转换的 'X'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-convert-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int minimumMoves(String s) {
        int count = 0;
        for (int i = 0; i <= s.length() - 1; ) {
            if (s.charAt(i) == 'O') {
                i++;
            } else {
                i = i + 3;
                count++;
            }
        }
        return count;
    }


    /**
     * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
     * <p>
     * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     * <p>
     * 注意：分割得到的每个字符串都必须是平衡字符串，且分割得到的平衡字符串是原平衡字符串的连续子串。
     * <p>
     * 返回可以通过分割得到的平衡字符串的 最大数量 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * 示例 2：
     * <p>
     * 输入：s = "RLLLLRRRLR"
     * 输出：3
     * 解释：s 可以分割为 "RL"、"LLLRRR"、"LR" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * 示例 3：
     * <p>
     * 输入：s = "LLLLRRRR"
     * 输出：1
     * 解释：s 只能保持原样 "LLLLRRRR".
     * 示例 4：
     * <p>
     * 输入：s = "RLRRRLLRLL"
     * 输出：2
     * 解释：s 可以分割为 "RL"、"RRRLLRLL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int balancedStringSplit(String s) {

        int count = 0;
        List<Character> current = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            if (current.size() == 0) {
                current.add(s.charAt(i));
                i++;
            } else {
                Character last = current.get(current.size() - 1);
                if (last == s.charAt(i)) {
                    current.add(s.charAt(i));
                    i++;
                } else {
                    if (current.size() == 1) {
                        current.clear();
                        count++;
                        i++;
                    } else {
                        int tempCount = 0;
                        int tempJ = 0;
                        for (int j = i; j < s.length(); j++) {
                            if (tempCount == current.size()) {
                                current.clear();
                                count++;
                                i = j;
                                break;
                            }
                            if (s.charAt(j) == last) {
                                current.add(s.charAt(j));
                            } else {
                                tempCount++;
                            }
                            tempJ = j;
                        }
                        if (tempCount == current.size()) {
                            count++;
                            i = tempJ;
                            current.clear();
                        }
                    }
                }
            }
        }
        return count;
    }


    /**
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * <p>
     * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：flowerbed = [1,0,0,0,1], n = 1
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：flowerbed = [1,0,0,0,1], n = 2
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-place-flowers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        if (flowerbed.length == 1 && flowerbed[0] == 0 && n <= 1)
            return true;
        else if (flowerbed.length == 1 && flowerbed[0] == 1 && n <= 1)
            return false;
        if (flowerbed.length == 1 && n > 1)
            return false;

        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (n == 0)
                break;
            if (flowerbed[i] == 1)
                continue;
            if (flowerbed[i] == 0) {
                boolean flag = true;
                if (i == 0) {
                    for (int j = i + 1; j < i + 2; j++) {
                        if (flowerbed[j] == 1) {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    if (i + 2 == flowerbed.length) {
                        for (int j = i + 1; j < i + 2; j++) {
                            if (flowerbed[j] == 1) {
                                flag = false;
                                break;
                            }
                        }
                    } else {
                        for (int j = i + 1; j < i + 3; j++) {
                            if (flowerbed[j] == 1) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (i == 0 && flag) {
                    n--;
                    flowerbed[0] = 1;
                } else {
                    if (flag) {
                        n--;
                        flowerbed[i + 1] = 1;
                    }
                }

            }
        }
        return n <= 0 ? true : false;
    }

    /**
     * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
     * <p>
     * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
     * <p>
     * 如果 S[i] == "I"，那么 A[i] < A[i+1]
     * 如果 S[i] == "D"，那么 A[i] > A[i+1]
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入："IDID"
     * 输出：[0,4,1,3,2]
     * 示例 2：
     * <p>
     * 输入："III"
     * 输出：[0,1,2,3]
     * 示例 3：
     * <p>
     * 输入："DDI"
     * 输出：[3,2,0,1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/di-string-match
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static int[] diStringMatch(String s) {
        int N = s.length();
        int[] res = new int[N + 1];
        int min = 0;
        int max = N;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[res.length - 1] = max;
        return res;
    }

    /**
     * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
     * 输出：true
     * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     * 示例 2：
     * <p>
     * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
     * 输出：true
     * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public static boolean canThreePartsEqualSum(int[] arr) {
        double sum1 = (double) Arrays.stream(arr).sum() / 3;
        int sum = Arrays.stream(arr).sum() / 3;
        if (sum1 != sum)
            return false;
        int currentSum = 0;
        int count = 3;
        for (int i : arr) {
            currentSum += i;
            if (count == 0)
                break;
            if (currentSum == sum) {
                count--;
                currentSum = 0;
            }
        }
        return count == 0 ? true : false;
    }

    /**
     * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
     * <p>
     * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
     * <p>
     * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
     * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
     * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
     * <p>
     * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：chips = [1,2,3]
     * 输出：1
     * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
     * 示例 2：
     * <p>
     * 输入：chips = [2,2,2,3,3]
     * 输出：2
     * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param position
     * @return
     */
    public static int minCostToMoveChips(int[] position) {
       /* int res = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : position)
            map.put(i, map.getOrDefault(i, 0) + 1);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int count = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : entries) {
                if (entry != integerIntegerEntry) {
                    Integer key = Math.abs(integerIntegerEntry.getKey() - entry.getKey());
                    long distance = 0;
                    if (key > 1) {
                        distance = key % 2l;
                    } else {
                        distance = 1;
                    }
                    distance *= integerIntegerEntry.getValue();
                    count += distance;
                }
            }
            if (count < res)
                res = count;
        }

        return res;*/
        int odd = 0, even = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        return Math.min(even, odd);
    }


    /**
     * 有一个特殊打字机，它由一个 圆盘 和一个 指针 组成， 圆盘上标有小写英文字母 'a' 到 'z'。只有 当指针指向某个字母时，它才能被键入。指针 初始时 指向字符 'a' 。
     * <p>
     * <p>
     * 每一秒钟，你可以执行以下操作之一：
     * <p>
     * 将指针 顺时针 或者 逆时针 移动一个字符。
     * 键入指针 当前 指向的字符。
     * 给你一个字符串 word ，请你返回键入 word 所表示单词的 最少 秒数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：word = "abc"
     * 输出：5
     * 解释：
     * 单词按如下操作键入：
     * - 花 1 秒键入字符 'a' in 1 ，因为指针初始指向 'a' ，故不需移动指针。
     * - 花 1 秒将指针顺时针移到 'b' 。
     * - 花 1 秒键入字符 'b' 。
     * - 花 1 秒将指针顺时针移到 'c' 。
     * - 花 1 秒键入字符 'c' 。
     * 示例 2：
     * <p>
     * 输入：word = "bza"
     * 输出：7
     * 解释：
     * 单词按如下操作键入：
     * - 花 1 秒将指针顺时针移到 'b' 。
     * - 花 1 秒键入字符 'b' 。
     * - 花 2 秒将指针逆时针移到 'z' 。
     * - 花 1 秒键入字符 'z' 。
     * - 花 1 秒将指针顺时针移到 'a' 。
     * - 花 1 秒键入字符 'a' 。
     * 示例 3：
     * <p>
     * 输入：word = "zjpc"
     * 输出：34
     * 解释：
     * 单词按如下操作键入：
     * - 花 1 秒将指针逆时针移到 'z' 。
     * - 花 1 秒键入字符 'z' 。
     * - 花 10 秒将指针顺时针移到 'j' 。
     * - 花 1 秒键入字符 'j' 。
     * - 花 6 秒将指针顺时针移到 'p' 。
     * - 花 1 秒键入字符 'p' 。
     * - 花 13 秒将指针逆时针移到 'c' 。
     * - 花 1 秒键入字符 'c' 。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-time-to-type-word-using-special-typewriter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word
     * @return
     */
    public static int minTimeToType(String word) {
        int count = 0;
        int current = 0;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            int length = findMin(current, index);
            current = index;
            count += length + 1;
        }
        return count;
    }

    private static int findMin(int current, int index) {
        if (current == index)
            return 0;
        if (Math.abs(current - index) <= 12) {
            return Math.abs(current - index);
        } else {
            return 26 - Math.abs(current - index);
        }
    }

    /**
     * int length = gas.length;
     * // 从哪个加油站出发
     * int i = 0;
     * while (i < length) {
     * int totalGasNum = 1;
     * int totalGas = gas[i];
     * int next = i;
     * // 判断当前能到达的最远距离
     * while (next < length) {
     * // 如果下一个大于当前的总和则跳出Loop
     * if (cost[next] > totalGas)
     * break;
     * // 如果可以到达下一个并且当前达到的加油站数量达到最大则直接返回
     * totalGasNum++;
     * if (totalGasNum == length+1)
     * return i;
     * // 如果可以到达下一个加油站
     * // 减去当前消耗的
     * totalGas -= cost[next];
     * // 计算下一个索引
     * next = (next + 1) % length;
     * totalGas += gas[next];
     * }
     * i+=totalGasNum;
     * }
     * return -1;
     * <p>
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * 输出: 3
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
     * 输入: gas = [2,3,4], cost = [3,4,3]
     * 输出: -1
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
    // 直接暴力模拟
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        // 从那个加油站出发
        int res = -1;
        for (int i = 0; i < length; ) {
            int totalGas = gas[i];
            int total = 0;
            int current = i;
            while (total < length) {
                // 下一个加油站的下表
                int next = (current + 1) % length;
                // 到达下一个加油站需要花费的汽油
                int nextCost = cost[current];
                // 如果当前总汽油大于等于到达下一站所需要的汽油数量
                if (nextCost <= totalGas) {
                    // 减去下一站所需的量
                    totalGas -= nextCost;
                    // 移动到下一站
                    current = next;
                    // 加上下一站的油量
                    totalGas += gas[next];
                    // 计算达到的全部加油站的数量
                    total++;
                }
                // 如果到不了下一个加油站则直接返回
                else {
                    break;
                }
            }
            if (total == length)
                return i;
            // 走不通时走的最远距离
            i += total + 1;
        }
        return res;

    }

    public boolean lemonadeChange(int[] bills) {
        boolean flag = false;


        return flag;
    }

    /**
     * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
     * <p>
     * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
     * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
     * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "IDID"
     * 输出：[0,4,1,3,2]
     * 示例 2：
     * <p>
     * 输入：s = "III"
     * 输出：[0,1,2,3]
     * 示例 3：
     * <p>
     * 输入：s = "DDI"
     * 输出：[3,2,0,1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/di-string-match
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    /*public int[] diStringMatch(String s) {
        int left = 0;
        int right = s.length();
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[s.length()] = left;
        return res;
    }*/

}
