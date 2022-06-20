package cn.underdog.leetcode.greedy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class M_MainClass {

    public static void main(String[] args) {
//        removeDuplicateLetters("cbacdcbc");
//        removeDuplicateLetters("bcabc");
//        System.out.println(largestNumber(new int[]{8308,8308,830}));
//        System.out.println(largestNumber(new int[]{0, 0}));
//        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
//        System.out.println(largestNumber(new int[]{1,0}));
//        M_MainClass mainClass = new M_MainClass();
//        int res = mainClass.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
//        int res = mainClass.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        int res = mainClass.wiggleMaxLength(new int[]{1, 1});
//        int res = mainClass.wiggleMaxLength(new int[]{3, 3, 3, 2, 5});
        M_MainClass mainClass = new M_MainClass();
//        mainClass.partitionLabels("ababcbacadefegdehijhklij");
//        mainClass.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
//        System.out.println(res);
//        mainClass.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
//        mainClass.findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}});
//        mainClass.eraseOverlapIntervals(new int[][]{{1, 4}, {2, 3}, {3, 4}, {1, 3}});
//        mainClass.eraseOverlapIntervals(new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}});
//        System.out.println(mainClass.monotoneIncreasingDigits(999989998));
//        System.out.println(mainClass.monotoneIncreasingDigits(8997988));
//        mainClass.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
//        mainClass.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
//        mainClass.maxProfit(new int[]{1, 4, 6, 2, 8, 3, 10, 14}, 3);
//        mainClass.repeatLimitedString("cczazcc", 3);
//        mainClass.repeatLimitedString("aababab", 2);
//        mainClass.maximumEvenSplit(12);
//        mainClass.maximumEvenSplit(14);
//        mainClass.maximumEvenSplit(28);
//        mainClass.minimumOperations(new int[]{69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28, 79});
//        mainClass.minimumOperations(new int[]{2, 2, 2, 2, 2, 2});
//        mainClass.minimumOperations(new int[]{1, 2, 2, 2, 2});
//        mainClass.minimumOperations(new int[]{48, 38, 42, 18, 13, 1, 97, 88, 82, 48, 54, 16, 78, 59, 52, 30, 40, 77, 59, 87, 71, 28});
//        mainClass.longestPalindrome(new String[]{"lc", "cl", "gg", "cl", "lc"});
//        mainClass.longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"});
//        mainClass.longestPalindrome(new String[]{"gg", "xx", "zz", "zz"});
//        mainClass.longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"});
//        mainClass.longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"});
//        mainClass.canReorderDoubled(new int[]{2, 2, 4, 2, 3, 6});
//        mainClass.canReorderDoubled(new int[]{4, -2, 2, -4});
//        mainClass.canReorderDoubled(new int[]{2, 1, 2, 6});
//        mainClass.canReorderDoubled(new int[]{10, 20, 40, 80});
//        mainClass.stoneGameIX(new int[]{20, 3, 20, 17, 2, 12, 15, 17, 4});
//        mainClass.findOriginalArray(new int[]{0, 0, 0, 0});
        mainClass.findOriginalArray(new int[]{2, 1, 2, 4, 2, 4});
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

    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            list.add(String.valueOf(nums[i]));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long value1 = Long.parseLong(o1 + o2);
                long value2 = Long.parseLong(o2 + o1);
                return value1 > value2 ? -1 : 1;
            }
        });
        if (list.get(0).equals("0"))
            return 0 + "";
        for (String s : list)
            sb.append(s);

        return sb.toString();
    }


    /**
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
     * <p>
     * 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
     * <p>
     * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
     * <p>
     * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,7,4,9,2,5]
     * 输出：6
     * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
     * 输出：7
     * 解释：这个序列包含几个长度为 7 摆动序列。
     * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3,4,5,6,7,8,9]
     * 输出：2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return 思路：想要达到最长的子序列的长度  == 》 局部达到最长 ==》 局部有峰值 ==》选择差最大的。
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1)
            return 1;
        int res = 1; // 结果集
        int currentDiff = 0;// 当前差值
        int preDiff = 0; // 前一对差值
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前差值
            currentDiff = nums[i + 1] - nums[i];
            // 如果当前差值大于0并且上一次的差值和本次不同，这这当前差值小于0并且上一次的差值和本次不同，出现峰值===》结果集增加。
            if ((currentDiff > 0 && preDiff <= 0) || (currentDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = currentDiff;
            }
        }
        return res;
    }

    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * <p>
     * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * 解释：
     * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
     * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
     * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
     * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
     * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
     * 示例 2：
     * <p>
     * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
     * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }

   /* public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> orDefault = map.getOrDefault(s.charAt(i), new ArrayList<>());
            orDefault.add(i);
            map.put(s.charAt(i), orDefault);
        }
        for (Map.Entry<Character, List<Integer>> characterListEntry : map.entrySet()) {

        }
        return new ArrayList<>();

    }*/

    /**
     * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
     * <p>
     * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
     * <p>
     * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
     * 输出：2
     * 解释：气球可以用2支箭来爆破:
     * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
     * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
     * 示例 2：
     * <p>
     * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
     * 输出：4
     * 解释：每个气球需要射出一支箭，总共需要4支箭。
     * 示例 3：
     * <p>
     * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
     * 输出：2
     * 解释：气球可以用2支箭来爆破:
     * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
     * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int res = 1;
        int currentRight = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (currentRight >= points[i][0] && currentRight <= points[i][1])
                continue;
            else {
                currentRight = points[i][1];
                res++;
            }
        }
        return res;

    }


    /**
     * 删除最小的重叠区间的数量，直接求，太难了，可以转换为熟悉的不重叠区间的最大数量===用总和减去
     * 如何求不重叠的区间？
     * 可以按照右边出现的顺序正序排序，后出现的一定最大， 此时可以按照从左到右判断当前Left和上次的right和关系
     * 如果本次的left>=上次的right则为不相交的区间，统计不相交区间的数量
     * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     * <p>
     * 输入: intervals = [ [1,2], [1,2], [1,2] ]
     * 输出: 2
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     * <p>
     * 输入: intervals = [ [1,2], [2,3] ]
     * 输出: 0
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照右边排序，从左到右遍历，到右边时，已经是可以到达的最远距离
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 求不相交的区间，转为相交的区间==>>求出最大的连续区间，则为删除的最小区间
        int end = intervals[0][1];
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (left >= end) {
                end = right;
                res++;
            }
        }
        return intervals.length - res;
    }


    /**
     * 思路：
     * 1.用map统计每个字母出现的最后位置
     * 2.从左到右遍历，更新目前遍历过的字符串出现的最大位置
     * 3.如果目前的位置和最大位置保持一致，则为划分的片段
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        // 用Map统计每个字符出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);

        List<Integer> list = new ArrayList<>();
        // 记录当前出现的最大值
        int max = Integer.MIN_VALUE;
        int last = 0;
        // 从左到右遍历
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(map.get(s.charAt(i)), max);
            // 如果当前位置为已经出现的最大位置
            if (i == max) {
                list.add(max - last + 1);
                last = max + 1;
            }
        }
        return list;
    }

    /**
     * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
     * <p>
     * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: n = 10
     * 输出: 9
     * 示例 2:
     * <p>
     * 输入: n = 1234
     * 输出: 1234
     * 示例 3:
     * <p>
     * 输入: n = 332
     * 输出: 299
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        int length = str.length();
        boolean flag = false;
        int i = 0;
        // 判断当前数字是否满足条件如果满足则直接返回
        for (; i < length - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                flag = true;
                break;
            }
        }
        StringBuilder sb = new StringBuilder(str);
        if (!flag) {
            return n;
        } else {
            // 当前数字不满足，则用贪心，找到当前不满足的索引下标后面的全部设为9,索引下标前面的数字-1进行回溯判断
            // 优化进行  剪枝错做，返回上次索引位置，为结束位置
            int pre = i;
            char preC = sb.charAt(i);
            i++;
            for (; i < length; i++) {
                sb.setCharAt(i, '9');
            }
            char res = (char) (preC - 1);
            sb.setCharAt(pre, res);
            str = String.valueOf(monotoneIncreasingDigits(Integer.parseInt(sb.toString())));
        }
        return Integer.parseInt(str);
    }

    /**
     * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
     * <p>
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * <p>
     * 返回获得利润的最大值。
     * <p>
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出：8
     * 解释：能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
     * 示例 2：
     * <p>
     * 输入：prices = [1,3,7,5,10,3], fee = 3
     * 输出：6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int min = prices[0];
        int[] dp = new int[prices.length];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            // 计算本次和
            int cntTotal = prices[i] - prices[i - 1] > fee ? prices[i] - prices[i - 1] - fee : 0;
            int minTotal = prices[i] - min > fee ? prices[i] - min - fee : 0;
            dp[i] = Math.max(minTotal, cntTotal + dp[i - 1]);
            if (prices[i] < min) {
                min = prices[i];
            }

           /* // 判断当前已经出现的最小值是否有利可图
            // 当前有利可图
            if (prices[i] - min > fee) {
                res += prices[i] - min - fee;
                min = prices[i];
                continue;
            }
            // 当前无利
            else {
                min = Math.min(min, prices[i]);
            }*/

        }

        return dp[prices.length - 1];
    }

    /**
     * 给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
     * <p>
     * 返回 字典序最大的 repeatLimitedString 。
     * <p>
     * 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "cczazcc", repeatLimit = 3
     * 输出："zzcccac"
     * 解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
     * 字母 'a' 连续出现至多 1 次。
     * 字母 'c' 连续出现至多 3 次。
     * 字母 'z' 连续出现至多 2 次。
     * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
     * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
     * 注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
     * 示例 2：
     * <p>
     * 输入：s = "aababab", repeatLimit = 2
     * 输出："bbabaa"
     * 解释：
     * 使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。
     * 字母 'a' 连续出现至多 2 次。
     * 字母 'b' 连续出现至多 2 次。
     * 因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
     * 该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。
     * 注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-string-with-repeat-limit
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param repeatLimit
     * @return
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        // 用TreeMap来堆字母进行排序，并且统计出现的次数
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        // 记录上次出现的值
        char pre = 'Z';
        while (map.size() != 0) {
            // 题目要求字典序最大，用贪心的思想，每次查找map中最后一个字母
            Map.Entry<Character, Integer> entry = map.pollLastEntry();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            // 如果当前的key和上次key相同
            if (key == pre) {
                // 查找下一个,字典序最大的，并且仅仅应该添加一个。因为本次不是最大的。
                Map.Entry<Character, Integer> integerEntry = map.pollLastEntry();
                // 如果下一个已经是null,则表明，不存在，本次和上次相同，直接返回结果
                if (integerEntry == null)
                    return sb.toString();
                // 之前的放入
                map.put(key, entry.getValue());
                Character key1 = integerEntry.getKey();
                Integer value1 = integerEntry.getValue();
                // 如果本次的value1不为1，进行将本次继续添加
                if (value1 != 1)
                    map.put(key1, value1 - 1);
                sb.append(key1);
                pre = key1;
            }
            // 如果本次和上次不相同，则直接添加
            else {
                if (value >= repeatLimit) {
                    if (value != repeatLimit)
                        map.put(key, value - repeatLimit);
                    for (int i = 0; i < repeatLimit; i++)
                        sb.append(key);
                } else {
                    for (int i = 0; i < value; i++)
                        sb.append(key);
                }
                pre = key;
            }
        }
        return sb.toString();
    }


    /**
     * 给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。
     * <p>
     * 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
     * 请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返回这些整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：finalSum = 12
     * 输出：[2,4,6]
     * 解释：以下是一些符合要求的拆分：(2 + 10)，(2 + 4 + 6) 和 (4 + 8) 。
     * (2 + 4 + 6) 为最多数目的整数，数目为 3 ，所以我们返回 [2,4,6] 。
     * [2,6,4] ，[6,2,4] 等等也都是可行的解。
     * 示例 2：
     * <p>
     * 输入：finalSum = 7
     * 输出：[]
     * 解释：没有办法将 finalSum 进行拆分。
     * 所以返回空数组。
     * 示例 3：
     * <p>
     * 输入：finalSum = 28
     * 输出：[6,8,2,12]
     * 解释：以下是一些符合要求的拆分：(2 + 26)，(6 + 8 + 2 + 12) 和 (4 + 24) 。
     * (6 + 8 + 2 + 12) 有最多数目的整数，数目为 4 ，所以我们返回 [6,8,2,12] 。
     * [10,2,4,12] ，[6,2,4,16] 等等也都是可行的解。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-split-of-positive-even-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param finalSum
     * @return
     */
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 0) {
            long start = 2;
            while (finalSum >= start) {
                res.add(start);
                finalSum -= start;
                start += 2;
            }
            if (finalSum != 0) {
                Long remove = res.remove(res.size() - 1);
                res.add(remove + finalSum);
            }

        }
        return res;
    }

    /**
     * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
     * <p>
     * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
     * <p>
     * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
     * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
     * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
     * <p>
     * 返回使数组变成交替数组的 最少操作数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,3,2,4,3]
     * 输出：3
     * 解释：
     * 使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
     * 在这种情况下，操作数为 3 。
     * 可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,2,2,2]
     * 输出：2
     * 解释：
     * 使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
     * 在这种情况下，操作数为 2 。
     * 注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-alternating
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        // 如果是长度为1则直接返回0
        if (nums.length == 1)
            return 0;
        // 用Map存储每个奇偶的最大数量
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map0 = new HashMap<>();
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                map0.put(nums[i], map0.getOrDefault(nums[i], 0) + 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        // 用大根堆，排序
        PriorityQueue<int[]> peven = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<int[]> podd = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map0.entrySet()) {
            peven.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            podd.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] peven0 = peven.poll();
        int[] podd0 = podd.poll();
        // 如果最大值相同
        if (peven0[0] == podd0[0]) {
            // 则用奇数的最大值和偶数的第二大的值  奇数的第二大的值和偶数的最大值
            int[] peven1 = new int[2];
            int[] podd1 = new int[2];
            if (peven != null && peven.size() != 0) {
                peven1 = peven.poll();
            }
            if (podd != null && podd.size() != 0) {
                podd1 = podd.poll();
            }
            int tmp1 = peven0[1] + podd1[1];
            int tmp2 = peven1[1] + podd0[1];
            int tmp = Math.max(tmp1, tmp2);
            return length - tmp;
        }
        // 如果奇偶位置上最多的元素不相同,则用总和减去 奇数和偶数的最大数量即可
        else {
            return length - peven0[1] - podd0[1];
        }

    }

    /**
     * 你正在玩一个整数游戏。从整数 1 开始，期望得到整数 target 。
     * <p>
     * 在一次行动中，你可以做下述两种操作之一：
     * <p>
     * 递增，将当前整数的值加 1（即， x = x + 1）。
     * 加倍，使当前整数的值翻倍（即，x = 2 * x）。
     * 在整个游戏过程中，你可以使用 递增 操作 任意 次数。但是只能使用 加倍 操作 至多 maxDoubles 次。
     * <p>
     * 给你两个整数 target 和 maxDoubles ，返回从 1 开始得到 target 需要的最少行动次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 5, maxDoubles = 0
     * 输出：4
     * 解释：一直递增 1 直到得到 target 。
     * 示例 2：
     * <p>
     * 输入：target = 19, maxDoubles = 2
     * 输出：7
     * 解释：最初，x = 1 。
     * 递增 3 次，x = 4 。
     * 加倍 1 次，x = 8 。
     * 递增 1 次，x = 9 。
     * 加倍 1 次，x = 18 。
     * 递增 1 次，x = 19 。
     * 示例 3：
     * <p>
     * 输入：target = 10, maxDoubles = 4
     * 输出：4
     * 解释：
     * 最初，x = 1 。
     * 递增 1 次，x = 2 。
     * 加倍 1 次，x = 4 。
     * 递增 1 次，x = 5 。
     * 加倍 1 次，x = 10 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-moves-to-reach-target-score
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target
     * @param maxDoubles
     * @return
     */
    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        // 把 + * 用转化为 - /
        // 判断当前target能否整除2如果能够整除2，并且maxDoubles不为0，则折半，（贪心思想，每次选择的是最大的值进行折半，局部最优，则整体最优）
        while (target != 1) {
            if (maxDoubles == 0)
                return res + target - 1;
            if (maxDoubles != 0 && target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else {
                target--;
            }
            res++;
        }
        return res;
    }

    /**
     * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
     * <p>
     * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
     * <p>
     * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
     * <p>
     * 回文串 指的是从前往后和从后往前读一样的字符串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["lc","cl","gg"]
     * 输出：6
     * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
     * "clgglc" 是另一个可以得到的最长回文串。
     * 示例 2：
     * <p>
     * 输入：words = ["ab","ty","yt","lc","cl","ab"]
     * 输出：8
     * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
     * "lcyttycl" 是另一个可以得到的最长回文串。
     * 示例 3：
     * <p>
     * 输入：words = ["cc","ll","xx"]
     * 输出：2
     * 解释：最长回文串是 "cc" ，长度为 2 。
     * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindrome-by-concatenating-two-letter-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    public int longestPalindrome(String[] words) {
        // 用concurrentHashMap解决遍历过程中移除元素报修改异常问题
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        boolean flag = false;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            String word = iterator.next().getKey();
            // 如果两者相同，则直接查找次数*2，因为两个子没有相同，一定可以组成回文串
            if (word.charAt(0) == word.charAt(1)) {
                Integer integer = map.get(word);
                // 奇数只能用一次
                if (integer % 2 == 0) {
                    res += integer * 2;
                } else {
                    if (!flag) {
                        res += integer * 2;
                        flag = true;
                    } else {
                        res += (integer - 1) * 2;
                    }
                }
            } else {
                String reverse = word.charAt(1) + "" + word.charAt(0);
                // 判断相反字符串是否存在 ，map contains的时间复杂度为o(1)
                if (map.containsKey(reverse)) {
                    // 贪心的思想用两者中间的最小元素
                    Integer integer = map.getOrDefault(word, 0);
                    Integer integer1 = map.getOrDefault(reverse, 0);
                    int tmp = Math.min(integer, integer1);
                    res += tmp * 4;
                    map.remove(reverse);
                }
            }
            // 每次移除本次的值
            map.remove(word);
        }
        return res;
    }

    /**
     * 给你一个整数 mass ，它表示一颗行星的初始质量。再给你一个整数数组 asteroids ，其中 asteroids[i] 是第 i 颗小行星的质量。
     * <p>
     * 你可以按 任意顺序 重新安排小行星的顺序，然后让行星跟它们发生碰撞。如果行星碰撞时的质量 大于等于 小行星的质量，那么小行星被 摧毁 ，并且行星会 获得 这颗小行星的质量。否则，行星将被摧毁。
     * <p>
     * 如果所有小行星 都 能被摧毁，请返回 true ，否则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：mass = 10, asteroids = [3,9,19,5,21]
     * 输出：true
     * 解释：一种安排小行星的方式为 [9,19,5,3,21] ：
     * - 行星与质量为 9 的小行星碰撞。新的行星质量为：10 + 9 = 19
     * - 行星与质量为 19 的小行星碰撞。新的行星质量为：19 + 19 = 38
     * - 行星与质量为 5 的小行星碰撞。新的行星质量为：38 + 5 = 43
     * - 行星与质量为 3 的小行星碰撞。新的行星质量为：43 + 3 = 46
     * - 行星与质量为 21 的小行星碰撞。新的行星质量为：46 + 21 = 67
     * 所有小行星都被摧毁。
     * 示例 2：
     * <p>
     * 输入：mass = 5, asteroids = [4,9,23,4]
     * 输出：false
     * 解释：
     * 行星无论如何没法获得足够质量去摧毁质量为 23 的小行星。
     * 行星把别的小行星摧毁后，质量为 5 + 4 + 9 + 4 = 22 。
     * 它比 23 小，所以无法摧毁最后一颗小行星。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/destroying-asteroids
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param mass
     * @param asteroids
     * @return
     */
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long tmp = mass;
        for (int asteroid : asteroids) {
            if (tmp >= asteroid) {
                tmp += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [3,1,3,6]
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：arr = [2,1,2,6]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：arr = [4,-2,2,-4]
     * 输出：true
     * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    /*public boolean canReorderDoubled(int[] arr) {
        ConcurrentHashMap<Integer, Integer> map1 = new ConcurrentHashMap<>();
        ConcurrentHashMap<Integer, Integer> map2 = new ConcurrentHashMap<>();
        int count = 0;
        for (int i : arr) {
            if (i >= 0) {
                count++;
                map1.put(i, map1.getOrDefault(i, 0) + 1);
            } else {
                map2.put(i, map2.getOrDefault(i, 0) + 1);
            }
        }
        // map1根据key排序
        ConcurrentHashMap<Integer, Integer> tmp = map1.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        }).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, ConcurrentHashMap::new));
        if (count % 2 != 0)
            return false;
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext() && map1.size() != 0) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            if (key == 0) {
                Integer value = entry.getValue();
                if (value % 2 != 0)
                    return false;
                else {
                    map1.remove(key);
                    continue;
                }
            }
            if (map1.containsKey(key * 2)) {
                Integer value = entry.getValue();
                Integer value2 = map1.get(key * 2);
                if (value > value2)
                    return false;
                else if (value == value2)
                    map1.remove(key * 2);
                else
                    map1.put(key * 2, value2 - value);
            } else {
                return false;
            }
            map1.remove(key);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator1 = map2.entrySet().iterator();
        while (iterator1.hasNext() && map2.size() != 0) {
            Map.Entry<Integer, Integer> entry = iterator1.next();
            int key = entry.getKey();
            if (map2.containsKey(key * 2)) {
                Integer value = entry.getValue();
                Integer value2 = map2.get(key * 2);
                if (value > value2)
                    return false;
                else if (value == value2)
                    map2.remove(key * 2);
                else
                    map2.put(key * 2, value2 - value);
            } else {
                return false;
            }
            map2.remove(key);
        }

        return true;

    }*/
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, Integer> map1 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;
        for (int i : arr) {
            if (i >= 0) {
                count++;
                map.put(i, map.getOrDefault(i, 0) + 1);
            } else {
                map1.put(i, map1.getOrDefault(i, 0) + 1);
            }
        }
        if (count % 2 != 0)
            return false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key == 0) {
                if (value % 2 != 0)
                    return false;
            }
            if (value == 0)
                continue;
            int target = key * 2;
            if (map.containsKey(target)) {
                Integer integer = map.get(target);
                if (value > integer)
                    return false;
                else if (value == integer)
                    map.put(target, 0);
                else
                    map.put(target, integer - value);
            } else
                return false;
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 0)
                continue;
            int target = key * 2;
            if (map1.containsKey(target)) {
                Integer integer = map1.get(target);
                if (value > integer)
                    return false;
                else if (value == integer)
                    map1.put(target, 0);
                else
                    map1.put(target, integer - value);
            } else
                return false;
        }
        return true;
    }


    /**
     * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。
     * <p>
     * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。
     * <p>
     * 如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
     * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
     * 假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：stones = [2,1]
     * 输出：true
     * 解释：游戏进行如下：
     * - 回合 1：Alice 可以移除任意一个石子。
     * - 回合 2：Bob 移除剩下的石子。
     * 已移除的石子的值总和为 1 + 2 = 3 且可以被 3 整除。因此，Bob 输，Alice 获胜。
     * 示例 2：
     * <p>
     * 输入：stones = [2]
     * 输出：false
     * 解释：Alice 会移除唯一一个石子，已移除石子的值总和为 2 。
     * 由于所有石子都已移除，且值总和无法被 3 整除，Bob 获胜。
     * 示例 3：
     * <p>
     * 输入：stones = [5,1,2,4,3]
     * 输出：false
     * 解释：Bob 总会获胜。其中一种可能的游戏进行方式如下：
     * - 回合 1：Alice 可以移除值为 1 的第 2 个石子。已移除石子值总和为 1 。
     * - 回合 2：Bob 可以移除值为 3 的第 5 个石子。已移除石子值总和为 = 1 + 3 = 4 。
     * - 回合 3：Alices 可以移除值为 4 的第 4 个石子。已移除石子值总和为 = 1 + 3 + 4 = 8 。
     * - 回合 4：Bob 可以移除值为 2 的第 3 个石子。已移除石子值总和为 = 1 + 3 + 4 + 2 = 10.
     * - 回合 5：Alice 可以移除值为 5 的第 1 个石子。已移除石子值总和为 = 1 + 3 + 4 + 2 + 5 = 15.
     * Alice 输掉游戏，因为已移除石子值总和（15）可以被 3 整除，Bob 获胜。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/stone-game-ix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param stones
     * @return
     */
    public boolean stoneGameIX(int[] stones) {

        int currentSum = 0;
        while (currentSum != 0) {
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] == 0)
                    continue;
                if (stones[i] % 3 != 0) {
                    currentSum += stones[i];
                    stones[i] = 0;
                }
            }
        }

        int sum = Arrays.stream(stones).sum();
        int length = stones.length;
        boolean flag = false;
        for (int stone : stones) {
            if (stone % 3 != 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return false;

        /// 如果总和，可以被3整除 并且长度为奇数为false,为偶数时为true,如果不能被3整除===》则直接返回false
        if (sum % 3 == 0) {
            if (length % 2 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int[] findOriginalArray(int[] changed) {
        List<Integer> list = new ArrayList<>();
        int length = changed.length;
        if (length % 2 != 0)
            return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : changed) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            if (key == 0) {
                if (value % 2 != 0) {
                    return new int[0];
                } else {
                    for (int i = 0; i < value / 2; i++) {
                        list.add(0);
                    }
                    continue;
                }
            }
            if (value == 0)
                continue;
            int target = key * 2;
            if (map.containsKey(target)) {
                Integer integer = map.get(target);
                if (value > integer) {
                    return new int[0];
                } else if (value == integer) {
                    map.put(target, 0);
                } else {
                    map.put(target, integer - value);
                }
                for (Integer i = 0; i < value; i++) {
                    list.add(key);
                }
            } else {
                return new int[0];
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
     * <p>
     * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
     * <p>
     * 返回 弱角色 的数量。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：properties = [[5,5],[6,3],[3,6]]
     * 输出：0
     * 解释：不存在攻击和防御都严格高于其他角色的角色。
     * 示例 2：
     * <p>
     * 输入：properties = [[2,2],[3,3]]
     * 输出：1
     * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
     * 示例 3：
     * <p>
     * 输入：properties = [[1,5],[10,4],[4,3]]
     * 输出：1
     * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param properties
     * @return
     */
    public int numberOfWeakCharacters(int[][] properties) {
        return 1;

    }

    /**
     * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
     * <p>
     * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：2
     * 解释：
     * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
     * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [1,10,2,9]
     * 输出：16
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    /**
     * 贪心：
     * 两个数 a大于b 让a和b变为相同的数字x需要的距离
     * x一定在ab中间 (b-x + x -a ) === b-a所以说 b-a为 ab变为相同 数组所需要的次数和具体的数字无关，只要在(a,b)中间
     * 对于多个数来说我们需要尽可能的找到，全部数组中最中间的那个数，则次数最小即为中位数
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        long target = nums[length / 2];
        long res = 0;
        for (int num : nums) {
            res += Math.abs(num - target);
        }

        return (int) res;
    }


}
