package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.MainClass.ListNode;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/4/510:10
 */
public class MainCompetition {

    public static void main(String[] args) {
        MainCompetition c_287 = new MainCompetition();
//        c_287.digitSum("11111222223", 3);
//        c_287.digitSum("1234", 2);
//        c_287.minimumRounds(new int[]{66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61});
//        c_287.longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe");
//        c_287.longestPath(new int[]{-1, 0, 0, 0}, "aabc");
//        c_287.waysToBuyPensPencils(20, 10, 5);
//        ATM atm = new ATM();
//        atm.deposit(new int[]{0, 0, 1, 2, 1});
//        atm.withdraw(600);
//        atm.deposit(new int[]{0, 1, 0, 1, 1});
//        atm.withdraw(600);
//        atm.withdraw(550);
//        System.out.println(c_287.minimizeResult("999+999"));
//        System.out.println(c_287.minimizeResult("247+38"));
//        c_287.getAncestors(8, new int[][]{{0, 7}, {7, 6}, {0, 3}, {6, 3}, {5, 4}, {1, 5}, {2, 7}, {3, 5}, {3, 1}, {0, 5}, {7, 5}, {2, 1}, {1, 4}, {6, 1}});
//        c_287.getAncestors(8, new int[][]{{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}});
//        c_287.getAncestors(48, new int[][]{{23,5},{23,31},{23,44},{23,20},{23,28},{23,38},{23,47},{23,16},{23,17},{23,36},{23,18},{23,25},{23,33},{23,32},{23,0},{23,43},{23,37},{23,41},{23,9},{23,24},{23,10},{23,39},{23,1},{46,31},{46,47},{46,16},{46,29},{46,18},{46,25},{46,4},{46,30},{46,27},{46,35},{46,0},{46,9},{46,24},{46,39},{46,1},{42,31},{42,6},{42,20},{42,38},{42,16},{42,17},{42,2},{42,36},{42,12},{42,29},{42,25},{42,33},{42,4},{42,30},{42,27},{42,32},{42,45},{42,7},{42,10},{5,14},{5,44},{5,28},{5,40},{5,38},{5,47},{5,8},{5,2},{5,36},{5,12},{5,33},{5,43},{5,10},{5,39},{5,21},{14,6},{14,44},{14,28},{14,13},{14,38},{14,47},{14,34},{14,8},{14,17},{14,36},{14,18},{14,25},{14,33},{14,4},{14,30},{14,27},{14,35},{14,0},{14,19},{14,37},{14,41},{14,24},{14,45},{14,10},{14,1},{31,28},{31,40},{31,26},{31,22},{31,16},{31,17},{31,29},{31,25},{31,4},{31,32},{31,43},{31,37},{31,9},{31,24},{31,7},{31,39},{31,1},{31,21},{6,44},{6,3},{6,15},{6,40},{6,13},{6,47},{6,34},{6,16},{6,2},{6,29},{6,18},{6,4},{6,11},{6,35},{6,0},{6,43},{6,37},{6,7},{6,10},{6,1},{6,21},{44,20},{44,28},{44,40},{44,47},{44,16},{44,17},{44,33},{44,30},{44,11},{44,19},{44,9},{44,1},{3,15},{3,20},{3,26},{3,22},{3,2},{3,36},{3,11},{3,27},{3,35},{3,32},{3,0},{3,37},{3,41},{3,24},{3,39},{15,26},{15,47},{15,4},{15,30},{15,11},{15,43},{15,19},{15,45},{15,10},{20,47},{20,34},{20,16},{20,2},{20,12},{20,33},{20,4},{20,30},{20,11},{20,35},{20,43},{20,19},{20,41},{20,9},{20,21},{28,40},{28,16},{28,36},{28,25},{28,35},{28,32},{28,19},{28,41},{28,24},{28,21},{40,13},{40,38},{40,47},{40,34},{40,16},{40,2},{40,36},{40,12},{40,29},{40,18},{40,4},{40,27},{40,0},{40,41},{40,9},{40,10},{40,1},{26,13},{26,38},{26,22},{26,34},{26,16},{26,25},{26,33},{26,27},{26,35},{26,32},{26,19},{26,39},{26,1},{26,21},{13,38},{13,34},{13,17},{13,2},{13,12},{13,25},{13,33},{13,30},{13,35},{13,0},{13,43},{13,19},{13,37},{13,9},{13,39},{13,1},{38,22},{38,47},{38,8},{38,17},{38,2},{38,12},{38,18},{38,25},{38,4},{38,30},{38,35},{38,32},{38,9},{38,7},{38,10},{22,34},{22,16},{22,36},{22,12},{22,29},{22,25},{22,4},{22,30},{22,11},{22,35},{22,0},{22,43},{22,41},{22,24},{22,45},{22,1},{47,8},{47,16},{47,17},{47,36},{47,33},{47,11},{47,27},{47,19},{47,37},{47,41},{47,24},{34,12},{34,29},{34,30},{34,32},{34,37},{34,45},{34,39},{8,17},{8,2},{8,36},{8,18},{8,33},{8,4},{8,35},{8,37},{8,45},{8,7},{16,17},{16,12},{16,18},{16,25},{16,4},{16,32},{16,0},{16,19},{16,39},{16,1},{17,18},{17,30},{17,11},{17,35},{17,0},{17,7},{2,36},{2,12},{2,29},{2,33},{2,4},{2,30},{2,11},{2,35},{2,43},{2,19},{2,41},{2,24},{2,45},{2,10},{2,1},{36,29},{36,25},{36,33},{36,11},{36,27},{36,19},{36,37},{36,41},{36,24},{36,10},{36,21},{12,33},{12,4},{12,0},{12,43},{12,9},{12,24},{12,7},{29,18},{29,30},{29,11},{29,32},{29,0},{29,37},{29,41},{29,24},{29,10},{29,39},{29,1},{29,21},{18,25},{18,4},{18,30},{18,35},{18,19},{18,41},{18,24},{18,7},{18,1},{25,4},{25,11},{25,35},{25,0},{25,37},{25,41},{25,24},{25,45},{25,39},{25,21},{33,4},{33,30},{33,11},{33,27},{33,43},{33,19},{33,37},{4,35},{4,37},{4,41},{4,9},{4,24},{4,39},{4,1},{4,21},{30,11},{30,27},{30,43},{30,19},{30,41},{30,9},{30,24},{30,7},{11,35},{11,32},{11,43},{11,37},{11,45},{27,35},{27,0},{27,43},{27,37},{27,45},{27,10},{27,1},{27,21},{35,21},{32,0},{32,43},{32,19},{32,37},{32,41},{32,9},{32,10},{0,37},{0,45},{0,7},{43,37},{43,24},{43,45},{43,10},{43,1},{19,37},{19,41},{19,9},{19,24},{19,39},{19,21},{37,41},{37,10},{41,9},{41,45},{41,39},{41,21},{9,24},{9,45},{9,7},{9,39},{24,45},{24,7},{24,10},{45,21},{7,21},{10,21},{1,21}});
//        c_287.countRectangles(new int[][]{{6, 4}, {10, 2}, {5, 5}, {1, 6}, {3, 2}, {9, 5}, {7, 6}}, new int[][]{{2, 1}, {2, 8}, {8, 4}, {10, 8}, {5, 6}, {1, 4}, {2, 4}, {2, 2}, {6, 10}});
//        c_287.countLatticePoints(new int[][]{{2, 2, 1}});
//        c_287.countLatticePoints(new int[][]{{2, 2, 2}, {3, 4, 1}});
//        c_287.sumOfThree(33);
//        c_287.minimumRemoval(new int[]{4, 1, 6, 5});
//        c_287.minCostSetTime(1, 2, 1, 76);
//        c_287.minCostSetTime(1, 2, 1, 600);
//        c_287.minCostSetTime(0, 1, 4, 9);
//        c_287.smallestNumber(-7605);
//        c_287.maxScoreIndices(new int[]{0, 0, 1, 0});
//        c_287.maxScoreIndices(new int[]{0, 0, 0});
//        c_287.countElements(new int[]{11, 7, 2, 15});
//        c_287.findLonely(new int[]{10, 6, 5, 8});
//        c_287.minimumCost(new int[]{1, 2, 3});
//        c_287.minimumCost(new int[]{6, 5, 7, 9, 2, 2});
//        c_287.minimumCost(new int[]{3, 3, 3, 1});
//        c_287.numberOfArrays(new int[]{1, -3, 4}, 1, 6);
//        c_287.numberOfArrays(new int[]{4, -7, 2}, 3, 6);
//        c_287.numberOfArrays(new int[]{-40}, -46, 53);
//        c_287.numberOfArrays(new int[]{-11054, -29384, -79640}, 21923, 53016);
//        c_287.highestRankedKItems(new int[][]{{1, 1, 1}, {0, 0, 1}, {2, 3, 4}}, new int[]{2, 3}, new int[]{0, 0}, 3);
//        c_287.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}});
//        c_287.mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}});
//        c_287.divideString1("abcdefghij", 3, 'x');
//        c_287.wordCount(new String[]{"ant", "act", "tack"}, new String[]{"tack", "act", "acti"});
//        c_287.minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0});
        List<List<String>> tmp = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("yeast");
        list.add("flour");
        List<String> list1 = new ArrayList<>();
        list1.add("bread");
        list1.add("meat");
        tmp.add(list);
        tmp.add(list1);

//        c_287.findAllRecipes(new String[]{"bread", "sandwich"}, tmp, new String[]{"yeast", "flour", "corn", "meat"});
//        c_287.test(new String[]{"hoipw", "xeofornhof", "v", "uyaos", "ouwqbdbay", "j", "twloel", "uvfdibco", "erhrxvgil", "osxjbybca", "ghuowx"}, new String[]{"erhrxvgil", "ouwqbdbay", "j", "v", "osxjbybca", "uyaos", "hoipw", "ghuowx", "twloel", "uvfdibco"});
//        c_287.wateringPlants(new int[]{2, 2, 3, 3}, 5);
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3});
        rangeFreqQuery.query(0, 3, 5);
        rangeFreqQuery.query(5, 6, 2);
        rangeFreqQuery.query(6, 8, 4);
        rangeFreqQuery.query(2, 8, 3);
        rangeFreqQuery.query(4, 5, 1);
        rangeFreqQuery.query(2, 4, 2);
    }

    /**
     * 思路=== 都转换为分钟进行运算
     * hh:mm这种格式需要考虑到进位的问题，不适合做运算，
     * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
     * <p>
     * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
     * <p>
     * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
     * <p>
     * 返回将 current 转化为 correct 需要的 最少操作数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：current = "02:30", correct = "04:35"
     * 输出：3
     * 解释：
     * 可以按下述 3 步操作将 current 转换为 correct ：
     * - 为 current 加 60 分钟，current 变为 "03:30" 。
     * - 为 current 加 60 分钟，current 变为 "04:30" 。
     * - 为 current 加 5 分钟，current 变为 "04:35" 。
     * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
     * 示例 2：
     * <p>
     * 输入：current = "11:00", correct = "11:01"
     * 输出：1
     * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-operations-to-convert-time
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param current
     * @param correct
     * @return
     */
    public int convertTime(String current, String correct) {
        int cnt = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3, 5));
        int crt = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3, 5));
        // 判断是否大于60
        return (crt - cnt) / 60 + (crt - cnt) % 60 / 15 + (crt - cnt) % 15 / 5 + (crt - cnt) % 5;
    }


    /**
     * 最开始的原始思路时用连个map来统计win的和lose的数量，如果输的不包含赢得，则添加到赢得数组中，如果包含则得出输的数量，如果大于==1添加到输的list中
     * 思考：
     * 我们可以用可以转换为统计输的次数，求出每个输的次数，如果时0则为alL win games 如是为1则是lose 1
     * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
     * <p>
     * 返回一个长度为 2 的列表 answer ：
     * <p>
     * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
     * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
     * 两个列表中的值都应该按 递增 顺序返回。
     * <p>
     * 注意：
     * <p>
     * 只考虑那些参与 至少一场 比赛的玩家。
     * 生成的测试用例保证 不存在 两场比赛结果 相同 。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
     * 输出：[[1,2,10],[4,5,7,8]]
     * 解释：
     * 玩家 1、2 和 10 都没有输掉任何比赛。
     * 玩家 4、5、7 和 8 每个都输掉一场比赛。
     * 玩家 3、6 和 9 每个都输掉两场比赛。
     * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
     * 示例 2：
     * <p>
     * 输入：matches = [[2,3],[1,3],[5,4],[6,4]]
     * 输出：[[1,2,5,6],[]]
     * 解释：
     * 玩家 1、2、5 和 6 都没有输掉任何比赛。
     * 玩家 3 和 4 每个都输掉两场比赛。
     * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-players-with-zero-or-one-losses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matches
     * @return
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        // 用treemap统计输的数量
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] match : matches) {
            map.putIfAbsent(match[0], 0);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> list = List.of(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                list.get(entry.getValue()).add(entry.getKey());
            }
        }

        return list;

    }

    /**
     * 思路：每个人最少得到的糖果数是0个，最多得到的糖果数量是10000000,
     * 从0-1000000可以进行枚举试一下当前的糖果是否能平均分给每个孩子（判断能不能的标准为:用每个堆处于当前的平均值，进行类加，如果能满足则查找到）
     * 但是从0-10000000枚举查找太浪费时间了，我们可以进行折半查找，每次选出中间的一个，进行判断，左右指针进行移动
     * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
     * <p>
     * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
     * <p>
     * 返回每个小孩可以拿走的 最大糖果数目 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：candies = [5,8,6], k = 3
     * 输出：5
     * 解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。现在就有五堆大小分别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
     * 示例 2：
     * <p>
     * 输入：candies = [2,5], k = 11
     * 输出：0
     * 解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-candies-allocated-to-k-children
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandies(int[] candies, long k) {
        long left = 0;
        long right = 10000000;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public String digitSum(String s, int k) {

        while (s.length() > k) {
            int totalk = 0;
            String currentStr = "";
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                if (totalk < k) {
                    total += Integer.parseInt(s.charAt(i) + "");
                    totalk++;
                } else if (totalk == k) {
                    currentStr += total;
                    total = Integer.parseInt(s.charAt(i) + "");
                    totalk = 1;
                }
            }

            currentStr += total;
            s = currentStr;
        }
        return s;
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1)
                return -1;
            if (value == 2) {
                res++;
                continue;
            }
            // 贪心
            int g = value % 3;
            if (g == 0) {
                res += value / 3;
            } else if (g == 1) {
                res += (value / 3 - 1) + 2;
            } else {
                res += value / 3 + 1;
            }
        }
        return res;
    }

    public int longestPath(int[] parent, String s) {
        int length = parent.length;
        List<Integer>[] lists = new List[length];
        // 建树
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i < parent.length; i++) {
            lists[parent[i]].add(i);
        }
        // 从0开始遍历当前的每个点所连接的最大长度
        int res = dfsLongestPath(0, lists, s);

        return res + 1;
    }

    // TODO
    private int dfsLongestPath(int i, List<Integer>[] lists, String s) {
        int currentMax = 0;
        for (Integer integer : lists[i]) {
            // s.charAt(i) 是当前父节点连接的值，s.charAt(integer)是子节点连接的值
            if (s.charAt(i) != s.charAt(integer)) {
                int childLength = dfsLongestPath(integer, lists, s);
                childLength++;
                currentMax = Math.max(childLength, currentMax);
            }
        }
        return currentMax;
    }

    public int findClosestNumber(int[] nums) {

        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (min > Math.abs(nums[i])) {
                min = Math.abs(nums[i]);
                res = nums[i];
            } else if (min == Math.abs(nums[i])) {
                min = Math.abs(nums[i]);
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        // 计算可以购买的第一
        int length = total / cost1;
        if (length == 0) {
            return total / cost2 + 1;
        }
        long res = 0;
        for (int i = 0; i <= length; i++) {
            // 计算买第一种笔花费的价格
            int totol1 = i * cost1;
            int shengyu = total - totol1;
            int num = shengyu / cost2 + 1;
            res += num;
        }


        return res;
    }

    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        PriorityQueue<Integer> even = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int tmp = Integer.parseInt(str.charAt(i) + "");
            if ((tmp & 1) == 0) {
                even.add(tmp);
            } else {
                odd.add(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int tmp = Integer.parseInt(str.charAt(i) + "");
            if ((tmp & 1) == 0) {
                sb.append(even.poll());
            } else {
                sb.append(odd.poll());
            }
        }
        return Integer.parseInt(sb.toString());

    }

    public String minimizeResult(String expression) {
        String[] split = expression.split("\\+");
        String str0 = split[0];
        String str1 = split[1];
        int min = Integer.MAX_VALUE;
        int indexI = -1;
        int indexJ = -1;
        for (int i = 0; i < str0.length(); i++) {
            String tmp1 = str0.substring(0, i);
            String tmp2 = str0.substring(i);
            for (int j = 0; j < str1.length(); j++) {
                String tmp3 = str1.substring(0, j + 1);
                String tmp4 = str1.substring(j + 1);
                int tmpSum = Integer.parseInt(tmp2) + Integer.parseInt(tmp3);
                int finalTmp = (Objects.equals("", tmp1) ? 1 : Integer.parseInt(tmp1)) * tmpSum * (Objects.equals("", tmp4) ? 1 : Integer.parseInt(tmp4));
                if (finalTmp < min) {
                    min = finalTmp;
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(indexI, "(");

        sb.insert(str0.length() + 3 + indexJ, ")");

        return sb.toString();
    }

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while (k != 0) {
            Integer poll = priorityQueue.poll();
            poll++;
            priorityQueue.add(poll);
            k--;
        }
        long res = 1;
        long mod = 1000000007;
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            res = (res * next) % mod;
        }

        return (int) res;

    }

    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                res = entry.getKey();
            }
        }
        return res;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            // 1.进行映射
            int num = nums[i];
            String strNum = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < strNum.length(); j++) {
                int index = Integer.parseInt(strNum.charAt(j) + "");
                sb.append(mapping[index]);
            }
            int mappingNum = Integer.parseInt(sb.toString());
            priorityQueue.add(new int[]{mappingNum, i});
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int[] poll = priorityQueue.poll();
            res[i] = nums[poll[1]];
        }
        return res;
    }

    /**
     * 直接进行暴力递归，查找当前出现的和父亲出现的不进行保存。直接超市，
     * 进一步优化为记忆化搜索
     * 当前查找到的用set进行保存，下一次找到时，直接返回时间缩短为o(1);
     *
     * @param n
     * @param edges
     * @return
     */
   /* public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[1]].add(edge[0]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = dfsGetAncestors(i, lists, res);
            res.add(list);
        }
        return res;
    }

    public List<Integer> dfsGetAncestors(int index, List<Integer>[] lists, List<List<Integer>> res) {
        List<Integer> list = lists[index];
        TreeSet<Integer> set = new TreeSet<>(list);
        for (Integer integer : list) {
            List<Integer> tmp = dfsGetAncestors(integer, lists, res);
            set.addAll(tmp);
        }
        return new ArrayList<>(set);
    }*/
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        TreeSet<Integer>[] sets = new TreeSet[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[1]].add(edge[0]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = dfsGetAncestors(i, lists, sets);
            res.add(list);
        }
        return res;
    }

    public List<Integer> dfsGetAncestors(int index, List<Integer>[] lists, TreeSet<Integer>[] sets) {
        TreeSet<Integer> integerTreeSet = sets[index];
        if (integerTreeSet == null) {
            List<Integer> list = lists[index];
            integerTreeSet = new TreeSet<>(list);
            for (Integer integer : list) {
                List<Integer> tmp = dfsGetAncestors(integer, lists, sets);
                integerTreeSet.addAll(new TreeSet<>(tmp));
            }
            sets[index] = integerTreeSet;
        }

        return new ArrayList<>(integerTreeSet);
    }

  /*  public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        TreeSet<Integer>[] sets = new TreeSet[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[1]].add(edge[0]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(List.copyOf(dfsGetAncestors(i, lists, sets)));
        }
        return res;

    }

    public TreeSet<Integer> dfsGetAncestors(int index, List<Integer>[] lists, TreeSet<Integer>[] sets) {
        if (sets[index] == null) {
            List<Integer> list = lists[index];
            sets[index] = new TreeSet<>();
            for (Integer integer : list) {
                sets[index].add(integer);
                sets[index].addAll(dfsGetAncestors(integer, lists, sets));
            }
        }
        return sets[index];
    }*/

    public List<Integer> intersection(int[][] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] tmp = nums[0];
        for (int i : tmp) {
            set.add(i);
        }
        for (int i = 1; i < nums.length; i++) {
            int[] num = nums[i];
            Set<Integer> integers = new HashSet<>();
            for (int j : num) {
                integers.add(j);
            }
            set.retainAll(integers);
        }
        return new ArrayList<>(set);
    }

 /*   public int[] countRectangles(int[][] rectangles, int[][] points) {
        int length = points.length;
        int[] res = new int[length];
        for (int i = 0; i < points.length; i++) {
            int n = 0;
            int[] point = points[i];
            for (int[] rectangle : rectangles) {
                if (rectangle[0] >= point[0] && rectangle[1] >= point[1]) {
                    n++;
                }
            }
            res[i] = n;
        }
        return res;
    }*/

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = points.length;
        int length = rectangles.length;
        int[] res = new int[n];
        String[] strings1 = new String[length];
        String[] strings2 = new String[length];
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            strings1[i] = rectangle[0] + "-" + rectangle[1];
            strings2[i] = rectangle[0] + "-" + rectangle[1];
        }
        Arrays.sort(strings1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("-");
                String[] split2 = o2.split("-");
                return Integer.compare(Integer.parseInt(split1[0]), Integer.parseInt(split2[0]));
            }
        });
        Arrays.sort(strings2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("-");
                String[] split2 = o2.split("-");
                return Integer.compare(Integer.parseInt(split1[1]), Integer.parseInt(split2[1]));
            }
        });

        for (int i = 0; i < points.length; i++) {
            // x1
            int left = 0;
            int right = length - 1;
            int num1 = points[i][0];
            while (left <= right) {
                int mid = (left + right) / 2;
                int target = Integer.parseInt(strings1[mid].split("-")[0]);
                if (target > left) {
                    right = mid - 1;
                } else if (target < num1) {
                    left = mid + 1;
                } else {
                    left = mid;
                    if (left > 0) {
                        left--;
                        while (left > 0 && left == Integer.parseInt(strings1[left].split("-")[0])) {
                            left--;
                        }
                        if (left != 0 && left != Integer.parseInt(strings1[left].split("-")[0])) {
                            left++;
                        }
                    }

                    break;
                }
            }
            Set<String> set = new HashSet<>();
            for (int j = left; j < length; j++) {
                set.add(strings1[j]);
            }

            // x1
            int left1 = 0;
            int right1 = length - 1;
            int num2 = points[i][1];
            while (left1 <= right1) {
                int mid = (left1 + right1) / 2;
                int target = Integer.parseInt(strings2[mid].split("-")[1]);
                if (target > num2) {
                    right1 = mid - 1;
                } else if (target < num2) {
                    left1 = mid + 1;
                } else {
                    left1 = mid;
                    if (left1 > 0) {
                        left1--;
                        while (left1 > 0 && num2 == Integer.parseInt(strings2[left1].split("-")[1])) {
                            left1--;
                        }
                        if (left1 != 0 && num2 != Integer.parseInt(strings2[left1].split("-")[1])) {
                            left1++;
                        }
                    }

                    break;
                }
            }
            Set<String> set1 = new HashSet<>();
            for (int j = left1; j < length; j++) {
                set1.add(strings2[j]);
            }
            set.retainAll(set1);
            int size = set.size();
            res[i] = size;
        }
        return res;

    }


    public int countLatticePoints(int[][] circles) {
        int count = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] circle : circles) {
                    if ((circle[0] - i) * (circle[0] - i) + (circle[1] - j) * (circle[1] - j) <= (circle[2] * circle[2])) {
                        count++;
                    }
                }

            }
        }
        return count;
    }


    public int countEven(int num) {
        int res = 0;
        for (int i = 2; i <= num; i++) {
            String str = String.valueOf(i);
            int tmp = 0;
            for (int j = 0; j < str.length(); j++) {
                tmp += Integer.parseInt(str.charAt(j) + "");
            }
            if ((tmp & 1) == 0)
                res++;
        }

        return res;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode();
        ListNode tail = root;
        ListNode p = head.next;
        int tmp = 0;
        while (p != null) {
            if (p.val != 0) {
                tmp += p.val;
            } else {
                ListNode cnt = new ListNode(tmp);
                tmp = 0;
                tail.next = cnt;
                tail = tail.next;
            }
            p = p.next;
        }
        return root.next;
    }


    /**
     * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,2,2,2,1,3], k = 2
     * 输出：4
     * 解释：
     * 总共有 4 对数符合所有要求：
     * - nums[0] == nums[6] 且 0 * 6 == 0 ，能被 2 整除。
     * - nums[2] == nums[3] 且 2 * 3 == 6 ，能被 2 整除。
     * - nums[2] == nums[4] 且 2 * 4 == 8 ，能被 2 整除。
     * - nums[3] == nums[4] 且 3 * 4 == 12 ，能被 2 整除。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4], k = 1
     * 输出：0
     * 解释：由于数组中没有重复数值，所以没有数对 (i,j) 符合所有要求。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-equal-and-divisible-pairs-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int countPairs(int[] nums, int k) {

        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() >= 2) {
                for (int i = 0; i < value.size(); i++) {
                    for (int j = i + 1; j < value.size(); j++) {
                        int tmp = value.get(i) * value.get(j);
                        if (tmp % k == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;

    }

    /**
     * 给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = 33
     * 输出：[10,11,12]
     * 解释：33 可以表示为 10 + 11 + 12 = 33 。
     * 10, 11, 12 是 3 个连续整数，所以返回 [10, 11, 12] 。
     * 示例 2：
     * <p>
     * 输入：num = 4
     * 输出：[]
     * 解释：没有办法将 4 表示成 3 个连续整数的和。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public long[] sumOfThree(long num) {
        long left = 0;
        long right = num - 1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = mid * 3 + 3;
            if (tmp > num) {
                right = mid - 1;
            } else if (tmp < num) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }
        if (left * 3 + 3 == num) {
            return new long[]{left, left + 1, left + 2};
        } else {
            return new long[0];
        }
    }

    /**
     * 给你两个 非负 整数 num1 和 num2 。
     * <p>
     * 每一步 操作 中，如果 num1 >= num2 ，你必须用 num1 减 num2 ；否则，你必须用 num2 减 num1 。
     * <p>
     * 例如，num1 = 5 且 num2 = 4 ，应该用 num1 减 num2 ，因此，得到 num1 = 1 和 num2 = 4 。然而，如果 num1 = 4且 num2 = 5 ，一步操作后，得到 num1 = 4 和 num2 = 1 。
     * 返回使 num1 = 0 或 num2 = 0 的 操作数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num1 = 2, num2 = 3
     * 输出：3
     * 解释：
     * - 操作 1 ：num1 = 2 ，num2 = 3 。由于 num1 < num2 ，num2 减 num1 得到 num1 = 2 ，num2 = 3 - 2 = 1 。
     * - 操作 2 ：num1 = 2 ，num2 = 1 。由于 num1 > num2 ，num1 减 num2 。
     * - 操作 3 ：num1 = 1 ，num2 = 1 。由于 num1 == num2 ，num1 减 num2 。
     * 此时 num1 = 0 ，num2 = 1 。由于 num1 == 0 ，不需要再执行任何操作。
     * 所以总操作数是 3 。
     * 示例 2：
     * <p>
     * 输入：num1 = 10, num2 = 10
     * 输出：1
     * 解释：
     * - 操作 1 ：num1 = 10 ，num2 = 10 。由于 num1 == num2 ，num1 减 num2 得到 num1 = 10 - 10 = 0 。
     * 此时 num1 = 0 ，num2 = 10 。由于 num1 == 0 ，不需要再执行任何操作。
     * 所以总操作数是 1 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-operations-to-obtain-zero
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1
     * @param num2
     * @return
     */
    public int countOperations(int num1, int num2) {
        int res = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
            res++;
        }
        return res;
    }

    /**
     * 给你一个 正 整数数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
     * <p>
     * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少 还有 一颗 魔法豆的袋子）魔法豆的数目 相等 。一旦魔法豆从袋子中取出，你不能将它放到任何其他的袋子中。
     * <p>
     * 请你返回你需要拿出魔法豆的 最少数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：beans = [4,1,6,5]
     * 输出：4
     * 解释：
     * - 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
     * 剩下袋子中魔法豆的数目为：[4,0,6,5]
     * - 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[4,0,4,5]
     * - 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[4,0,4,4]
     * 总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
     * 没有比取出 4 个魔法豆更少的方案。
     * 示例 2：
     * <p>
     * 输入：beans = [2,10,3,2]
     * 输出：7
     * 解释：
     * - 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[0,10,3,2]
     * - 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[0,10,3,0]
     * - 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
     * 剩下袋子中魔法豆的数目为：[0,10,0,0]
     * 总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
     * 没有比取出 7 个魔法豆更少的方案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/removing-minimum-number-of-magic-beans
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param beans
     * @return
     */
/*    public long minimumRemoval(int[] beans) {
        long min = Long.MAX_VALUE;
        int max = Arrays.stream(beans).max().getAsInt();
        for (int i = 1; i <= max; i++) {
            long tmp = 0;
            for (int bean : beans) {
                tmp += (bean - i) >= 0 ? (bean - i) : bean;
            }
            if (min > tmp) {
                min = tmp;
            }
        }

        return min;
    }*/
    public long minimumRemoval(int[] beans) {
        long sum = 0;
        long min = Long.MAX_VALUE;
        Arrays.sort(beans);
        for (int bean : beans) {
            sum += bean;
        }
        for (int i = 0; i < beans.length; i++) {
            long take = sum - (long) beans[i] * (beans.length - i);
            min = Math.min(take, min);
        }

        return min;
    }


    /**
     * 给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。
     * <p>
     * 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
     * 请你返回可以得到的 new1 和 new2 的 最小 和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = 2932
     * 输出：52
     * 解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
     * 最小和为数对 [29, 23] 的和：29 + 23 = 52 。
     * 示例 2：
     * <p>
     * 输入：num = 4009
     * 输出：13
     * 解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
     * 最小和为数对 [4, 9] 的和：4 + 9 = 13 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public int minimumSum(int num) {
        int[] tmp = new int[4];
        String str = String.valueOf(num);
        for (int i = 0; i < 4; i++) {
            tmp[i] = Integer.parseInt(str.charAt(i) + "");
        }
        Arrays.sort(tmp);
        int t1 = Integer.parseInt(tmp[0] + "" + tmp[2]);
        int t2 = Integer.parseInt(tmp[1] + "" + tmp[3]);
        return t1 + t2;
    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 pivot 。请你将 nums 重新排列，使得以下条件均成立：
     * <p>
     * 所有小于 pivot 的元素都出现在所有大于 pivot 的元素 之前 。
     * 所有等于 pivot 的元素都出现在小于和大于 pivot 的元素 中间 。
     * 小于 pivot 的元素之间和大于 pivot 的元素之间的 相对顺序 不发生改变。
     * 更正式的，考虑每一对 pi，pj ，pi 是初始时位置 i 元素的新位置，pj 是初始时位置 j 元素的新位置。对于小于 pivot 的元素，如果 i < j 且 nums[i] < pivot 和 nums[j] < pivot 都成立，那么 pi < pj 也成立。类似的，对于大于 pivot 的元素，如果 i < j 且 nums[i] > pivot 和 nums[j] > pivot 都成立，那么 pi < pj 。
     * 请你返回重新排列 nums 数组后的结果数组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [9,12,5,10,14,3,10], pivot = 10
     * 输出：[9,5,3,10,10,12,14]
     * 解释：
     * 元素 9 ，5 和 3 小于 pivot ，所以它们在数组的最左边。
     * 元素 12 和 14 大于 pivot ，所以它们在数组的最右边。
     * 小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [9, 5, 3] 和 [12, 14] ，它们在结果数组中的相对顺序需要保留。
     * 示例 2：
     * <p>
     * 输入：nums = [-3,4,3,2], pivot = 2
     * 输出：[-3,2,4,3]
     * 解释：
     * 元素 -3 小于 pivot ，所以在数组的最左边。
     * 元素 4 和 3 大于 pivot ，所以它们在数组的最右边。
     * 小于 pivot 的元素的相对位置和大于 pivot 的元素的相对位置分别为 [-3] 和 [4, 3] ，它们在结果数组中的相对顺序需要保留。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-array-according-to-given-pivot
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param pivot
     * @return
     */
    public int[] pivotArray(int[] nums, int pivot) {

        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        int equal = 0;
        for (int num : nums) {
            if (num < pivot)
                small.add(num);
            else if (num == pivot)
                equal++;
            else
                big.add(num);
        }
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < small.size(); i++) {
            res[i] = small.get(i);
        }
        for (int i = 0; i <= equal; i++) {
            res[i + small.size()] = pivot;
        }
        for (int i = 0; i < big.size(); i++) {
            res[i + small.size() + equal] = big.get(i);
        }
        return res;

    }

    /**
     * 常见的微波炉可以设置加热时间，且加热时间满足以下条件：
     * <p>
     * 至少为 1 秒钟。
     * 至多为 99 分 99 秒。
     * 你可以 最多 输入 4 个数字 来设置加热时间。如果你输入的位数不足 4 位，微波炉会自动加 前缀 0 来补足 4 位。微波炉会将设置好的四位数中，前 两位当作分钟数，后 两位当作秒数。它们所表示的总时间就是加热时间。比方说：
     * <p>
     * 你输入 9 5 4 （三个数字），被自动补足为 0954 ，并表示 9 分 54 秒。
     * 你输入 0 0 0 8 （四个数字），表示 0 分 8 秒。
     * 你输入 8 0 9 0 ，表示 80 分 90 秒。
     * 你输入 8 1 3 0 ，表示 81 分 30 秒。
     * 给你整数 startAt ，moveCost ，pushCost 和 targetSeconds 。一开始，你的手指在数字 startAt 处。将手指移到 任何其他数字 ，需要花费 moveCost 的单位代价。每 输入你手指所在位置的数字一次，需要花费 pushCost 的单位代价。
     * <p>
     * 要设置 targetSeconds 秒的加热时间，可能会有多种设置方法。你想要知道这些方法中，总代价最小为多少。
     * <p>
     * 请你能返回设置 targetSeconds 秒钟加热时间需要花费的最少代价。
     * <p>
     * 请记住，虽然微波炉的秒数最多可以设置到 99 秒，但一分钟等于 60 秒。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：startAt = 1, moveCost = 2, pushCost = 1, targetSeconds = 600
     * 输出：6
     * 解释：以下为设置加热时间的所有方法。
     * - 1 0 0 0 ，表示 10 分 0 秒。
     *   手指一开始就在数字 1 处，输入 1 （代价为 1），移到 0 处（代价为 2），输入 0（代价为 1），输入 0（代价为 1），输入 0（代价为 1）。
     *   总代价为：1 + 2 + 1 + 1 + 1 = 6 。这是所有方案中的最小代价。
     * - 0 9 6 0，表示 9 分 60 秒。它也表示 600 秒。
     *   手指移到 0 处（代价为 2），输入 0 （代价为 1），移到 9 处（代价为 2），输入 9（代价为 1），移到 6 处（代价为 2），输入 6（代价为 1），移到 0 处（代价为 2），输入 0（代价为 1）。
     *   总代价为：2 + 1 + 2 + 1 + 2 + 1 + 2 + 1 = 12 。
     * - 9 6 0，微波炉自动补全为 0960 ，表示 9 分 60 秒。
     *   手指移到 9 处（代价为 2），输入 9 （代价为 1），移到 6 处（代价为 2），输入 6（代价为 1），移到 0 处（代价为 2），输入 0（代价为 1）。
     *   总代价为：2 + 1 + 2 + 1 + 2 + 1 = 9 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：startAt = 0, moveCost = 1, pushCost = 2, targetSeconds = 76
     * 输出：6
     * 解释：最优方案为输入两个数字 7 6，表示 76 秒。
     * 手指移到 7 处（代价为 1），输入 7 （代价为 2），移到 6 处（代价为 1），输入 6（代价为 2）。总代价为：1 + 2 + 1 + 2 = 6
     * 其他可行方案为 0076 ，076 ，0116 和 116 ，但是它们的代价都比 6 大。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-to-set-cooking-time
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param startAt
     * @param moveCost
     * @param pushCost
     * @param targetSeconds
     * @return
     */
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        // 枚举全部可能的数字因为只有四位数字
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int u = 0; u < 10; u++) {
                    for (int t = 0; t < 10; t++) {
                        // 计算当前的值
                        int tmp = Integer.parseInt(i + "" + j) * 60 + Integer.parseInt(u + "" + t);
                        if (tmp == targetSeconds) {
                            // 去掉前导0
                            int num = Integer.parseInt(i + "" + j);
                            if (num == 0) {
                                int cnt = Integer.parseInt(u + "" + t);
                                strings.add(String.valueOf(cnt));
                            } else {
                                strings.add(num + "" + u + t);
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int before = startAt;
        for (String string : strings) {
            int tmp = 0;
            startAt = before;
            for (int i = 0; i < string.length(); i++) {
                if (Integer.parseInt(string.charAt(i) + "") == startAt) {
                    tmp += pushCost;
                } else {
                    startAt = Integer.parseInt(string.charAt(i) + "");
                    tmp += moveCost + pushCost;
                }
            }

            min = Math.min(tmp, min);
        }
        return min;
    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：
     * <p>
     * 按 非递增 顺序排列 nums 奇数下标 上的所有值。
     * 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。
     * 按 非递减 顺序排列 nums 偶数下标 上的所有值。
     * 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。偶数下标 0 和 2 的值按照非递减顺序重排。
     * 返回重排 nums 的值之后形成的数组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,1,2,3]
     * 输出：[2,3,4,1]
     * 解释：
     * 首先，按非递增顺序重排奇数下标（1 和 3）的值。
     * 所以，nums 从 [4,1,2,3] 变为 [4,3,2,1] 。
     * 然后，按非递减顺序重排偶数下标（0 和 2）的值。
     * 所以，nums 从 [4,1,2,3] 变为 [2,3,4,1] 。
     * 因此，重排之后形成的数组是 [2,3,4,1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,1]
     * 输出：[2,1]
     * 解释：
     * 由于只有一个奇数下标和一个偶数下标，所以不会发生重排。
     * 形成的结果数组是 [2,1] ，和初始数组一样。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-even-and-odd-indices-independently
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = even.poll();
            } else {
                nums[i] = odd.poll();
            }
        }
        return nums;
    }

    /**
     * 给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。
     * <p>
     * 返回不含前导零且值最小的重排数字。
     * <p>
     * 注意，重排各位数字后，num 的符号不会改变。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = 310
     * 输出：103
     * 解释：310 中各位数字的可行排列有：013、031、103、130、301、310 。
     * 不含任何前导零且值最小的重排数字是 103 。
     * 示例 2：
     * <p>
     * 输入：num = -7605
     * 输出：-7650
     * 解释：-7605 中各位数字的部分可行排列为：-7650、-6705、-5076、-0567。
     * 不含任何前导零且值最小的重排数字是 -7650 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-value-of-the-rearranged-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public long smallestNumber(long num) {


        if (num > 0) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            String str = String.valueOf(num);
            int num0 = 0;
            for (int i = 0; i < str.length(); i++) {
                int cnt = Integer.parseInt(str.charAt(i) + "");
                if (cnt == 0) {
                    num0++;
                } else {
                    priorityQueue.add(cnt);
                }
            }
            Integer poll = priorityQueue.poll();
            StringBuilder sb = new StringBuilder(String.valueOf(poll));
            for (int i = 0; i < num0; i++) {
                sb.append("0");
            }
            while (priorityQueue.size() != 0) {
                sb.append(priorityQueue.poll());
            }
            return Long.parseLong(sb.toString());
        } else if (num < 0) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            String str = String.valueOf(Math.abs(num));
            int num0 = 0;
            for (int i = 0; i < str.length(); i++) {
                int cnt = Integer.parseInt(str.charAt(i) + "");
                if (cnt == 0) {
                    num0++;
                } else {
                    priorityQueue.add(cnt);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (priorityQueue.size() != 0) {
                sb.append(priorityQueue.poll());
            }
            for (int i = 0; i < num0; i++) {
                sb.append("0");
            }
            return -Long.parseLong(sb.toString());
        } else {
            return 0;
        }

    }


    /**
     * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
     * <p>
     * 接下来，你需要按下述步骤操作：
     * <p>
     * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
     * 否则，停止这一过程。
     * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
     * 返回 original 的 最终 值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,3,6,1,12], original = 3
     * 输出：24
     * 解释：
     * - 3 能在 nums 中找到。3 * 2 = 6 。
     * - 6 能在 nums 中找到。6 * 2 = 12 。
     * - 12 能在 nums 中找到。12 * 2 = 24 。
     * - 24 不能在 nums 中找到。因此，返回 24 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,7,9], original = 4
     * 输出：4
     * 解释：
     * - 4 不能在 nums 中找到。因此，返回 4 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/keep-multiplying-found-values-by-two
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param original
     * @return
     */
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original *= 2;
            }
        }
        return original;
    }

    /**
     * 给你一个下标从 0 开始的二进制数组 nums ，数组长度为 n 。nums 可以按下标 i（ 0 <= i <= n ）拆分成两个数组（可能为空）：numsleft 和 numsright 。
     * <p>
     * numsleft 包含 nums 中从下标 0 到 i - 1 的所有元素（包括 0 和 i - 1 ），而 numsright 包含 nums 中从下标 i 到 n - 1 的所有元素（包括 i 和 n - 1 ）。
     * 如果 i == 0 ，numsleft 为 空 ，而 numsright 将包含 nums 中的所有元素。
     * 如果 i == n ，numsleft 将包含 nums 中的所有元素，而 numsright 为 空 。
     * 下标 i 的 分组得分 为 numsleft 中 0 的个数和 numsright 中 1 的个数之 和 。
     * <p>
     * 返回 分组得分 最高 的 所有不同下标 。你可以按 任意顺序 返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [0,0,1,0]
     * 输出：[2,4]
     * 解释：按下标分组
     * - 0 ：numsleft 为 [] 。numsright 为 [0,0,1,0] 。得分为 0 + 1 = 1 。
     * - 1 ：numsleft 为 [0] 。numsright 为 [0,1,0] 。得分为 1 + 1 = 2 。
     * - 2 ：numsleft 为 [0,0] 。numsright 为 [1,0] 。得分为 2 + 1 = 3 。
     * - 3 ：numsleft 为 [0,0,1] 。numsright 为 [0] 。得分为 2 + 0 = 2 。
     * - 4 ：numsleft 为 [0,0,1,0] 。numsright 为 [] 。得分为 3 + 0 = 3 。
     * 下标 2 和 4 都可以得到最高的分组得分 3 。
     * 注意，答案 [4,2] 也被视为正确答案。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0]
     * 输出：[3]
     * 解释：按下标分组
     * - 0 ：numsleft 为 [] 。numsright 为 [0,0,0] 。得分为 0 + 0 = 0 。
     * - 1 ：numsleft 为 [0] 。numsright 为 [0,0] 。得分为 1 + 0 = 1 。
     * - 2 ：numsleft 为 [0,0] 。numsright 为 [0] 。得分为 2 + 0 = 2 。
     * - 3 ：numsleft 为 [0,0,0] 。numsright 为 [] 。得分为 3 + 0 = 3 。
     * 只有下标 3 可以得到最高的分组得分 3 。
     * 示例 3：
     * <p>
     * 输入：nums = [1,1]
     * 输出：[0]
     * 解释：按下标分组
     * - 0 ：numsleft 为 [] 。numsright 为 [1,1] 。得分为 0 + 2 = 2 。
     * - 1 ：numsleft 为 [1] 。numsright 为 [1] 。得分为 0 + 1 = 1 。
     * - 2 ：numsleft 为 [1,1] 。numsright 为 [] 。得分为 0 + 0 = 0 。
     * 只有下标 0 可以得到最高的分组得分 2 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/all-divisions-with-the-highest-score-of-a-binary-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<Integer> maxScoreIndices(int[] nums) {
        int length = nums.length;
        int cntTotal0 = 0;
        int Max = Integer.MIN_VALUE;
        int total1 = 0;
        for (int num : nums) {
            if (num == 1) {
                total1++;
            }
        }

        List<Integer> res = new ArrayList<>();
        // 计算0
        res.add(0);
        Max = total1;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == 0) {
                cntTotal0++;
            }
            // 右边1的个数
            int tmp = cntTotal0 + (total1 - (i - cntTotal0));
            if (tmp > Max) {
                Max = tmp;
                res.clear();
                res.add(i);
            } else if (tmp == Max) {
                res.add(i);
            }
        }
        //和最后一个
        if (nums[length - 1] == 0) {
            cntTotal0++;
        }
        if (cntTotal0 > Max) {
            res.clear();
            res.add(length);
        } else if (cntTotal0 == Max) {
            res.add(length);
        }

        return res;


    }

    /**
     * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [11,7,2,15]
     * 输出：2
     * 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
     * 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
     * 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
     * 示例 2：
     * <p>
     * 输入：nums = [-3,3,3,90]
     * 输出：2
     * 解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
     * 由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-elements-with-strictly-smaller-and-greater-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int countElements(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        Integer min = map.firstKey();
        Integer large = map.lastKey();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (min != key && large != key) {
                res += entry.getValue();
            }
        }
        return res;

    }


    /**
     * 给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。
     * <p>
     * 你需要 重排 nums 中的元素，使修改后的数组满足下述条件：
     * <p>
     * 任意 连续 的两个整数 符号相反
     * 对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
     * 重排后数组以正整数开头。
     * 重排元素满足上述条件后，返回修改后的数组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,-2,-5,2,-4]
     * 输出：[3,-2,1,-5,2,-4]
     * 解释：
     * nums 中的正整数是 [3,1,2] ，负整数是 [-2,-5,-4] 。
     * 重排的唯一可行方案是 [3,-2,1,-5,2,-4]，能满足所有条件。
     * 像 [1,-2,2,-5,3,-4]、[3,1,2,-2,-5,-4]、[-2,3,-5,1,-4,2] 这样的其他方案是不正确的，因为不满足一个或者多个条件。
     * 示例 2：
     * <p>
     * 输入：nums = [-1,1]
     * 输出：[1,-1]
     * 解释：
     * 1 是 nums 中唯一一个正整数，-1 是 nums 中唯一一个负整数。
     * 所以 nums 重排为 [1,-1] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rearrange-array-elements-by-sign
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] rearrangeArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        int num0 = 0;
        int num1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = list1.get(num0++);
            } else {
                nums[i] = list2.get(num1++);
            }
        }
        return nums;
    }

    /**
     * 给你一个整数数组 nums 。如果数字 x 在数组中仅出现 一次 ，且没有 相邻 数字（即，x + 1 和 x - 1）出现在数组中，则认为数字 x 是 孤独数字 。
     * <p>
     * 返回 nums 中的 所有 孤独数字。你可以按 任何顺序 返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,6,5,8]
     * 输出：[10,8]
     * 解释：
     * - 10 是一个孤独数字，因为它只出现一次，并且 9 和 11 没有在 nums 中出现。
     * - 8 是一个孤独数字，因为它只出现一次，并且 7 和 9 没有在 nums 中出现。
     * - 5 不是一个孤独数字，因为 6 出现在 nums 中，反之亦然。
     * 因此，nums 中的孤独数字是 [10, 8] 。
     * 注意，也可以返回 [8, 10] 。
     * 示例 2：
     * <p>
     * 输入：nums = [1,3,5,3]
     * 输出：[1,5]
     * 解释：
     * - 1 是一个孤独数字，因为它只出现一次，并且 0 和 2 没有在 nums 中出现。
     * - 5 是一个孤独数字，因为它只出现一次，并且 4 和 6 没有在 nums 中出现。
     * - 3 不是一个孤独数字，因为它出现两次。
     * 因此，nums 中的孤独数字是 [1, 5] 。
     * 注意，也可以返回 [5, 1] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-lonely-numbers-in-the-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1] && nums[0] != nums[1] - 1) {
            list.add(nums[0]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1 && nums[i] != nums[i + 1] && nums[i] != nums[i + 1] - 1) {
                list.add(nums[i]);
            }
        }
        int length = nums.length - 1;
        if (nums[length] != nums[length - 1] && nums[length] != nums[length - 1] + 1) {
            list.add(nums[length]);
        }
        return list;

    }

    /**
     * 一家商店正在打折销售糖果。每购买 两个 糖果，商店会 免费 送一个糖果。
     * <p>
     * 免费送的糖果唯一的限制是：它的价格需要小于等于购买的两个糖果价格的 较小值 。
     * <p>
     * 比方说，总共有 4 个糖果，价格分别为 1 ，2 ，3 和 4 ，一位顾客买了价格为 2 和 3 的糖果，那么他可以免费获得价格为 1 的糖果，但不能获得价格为 4 的糖果。
     * 给你一个下标从 0 开始的整数数组 cost ，其中 cost[i] 表示第 i 个糖果的价格，请你返回获得 所有 糖果的 最小 总开销。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：cost = [1,2,3]
     * 输出：5
     * 解释：我们购买价格为 2 和 3 的糖果，然后免费获得价格为 1 的糖果。
     * 总开销为 2 + 3 = 5 。这是开销最小的 唯一 方案。
     * 注意，我们不能购买价格为 1 和 3 的糖果，并免费获得价格为 2 的糖果。
     * 这是因为免费糖果的价格必须小于等于购买的 2 个糖果价格的较小值。
     * 示例 2：
     * <p>
     * 输入：cost = [6,5,7,9,2,2]
     * 输出：23
     * 解释：最小总开销购买糖果方案为：
     * - 购买价格为 9 和 7 的糖果
     * - 免费获得价格为 6 的糖果
     * - 购买价格为 5 和 2 的糖果
     * - 免费获得价格为 2 的最后一个糖果
     * 因此，最小总开销为 9 + 7 + 5 + 2 = 23 。
     * 示例 3：
     * <p>
     * 输入：cost = [5,5]
     * 输出：10
     * 解释：由于只有 2 个糖果，我们需要将它们都购买，而且没有免费糖果。
     * 所以总最小开销为 5 + 5 = 10 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-cost-of-buying-candies-with-discount
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param cost
     * @return
     */
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : cost) {
            priorityQueue.add(i);
        }
        int total = 0;
        while (priorityQueue.size() != 0) {
            if (priorityQueue.size() > 2) {
                total += priorityQueue.poll() + priorityQueue.poll();
                priorityQueue.poll();
            } else if (priorityQueue.size() == 2) {
                total += priorityQueue.poll() + priorityQueue.poll();
            } else {
                total += priorityQueue.poll();
            }
        }
        return total;
    }

    /**
     * 给你一个下标从 0 开始且长度为 n 的整数数组 differences ，它表示一个长度为 n + 1 的 隐藏 数组 相邻 元素之间的 差值 。更正式的表述为：我们将隐藏数组记作 hidden ，那么 differences[i] = hidden[i + 1] - hidden[i] 。
     * <p>
     * 同时给你两个整数 lower 和 upper ，它们表示隐藏数组中所有数字的值都在 闭 区间 [lower, upper] 之间。
     * <p>
     * 比方说，differences = [1, -3, 4] ，lower = 1 ，upper = 6 ，那么隐藏数组是一个长度为 4 且所有值都在 1 和 6 （包含两者）之间的数组。
     * [3, 4, 1, 5] 和 [4, 5, 2, 6] 都是符合要求的隐藏数组。
     * [5, 6, 3, 7] 不符合要求，因为它包含大于 6 的元素。
     * [1, 2, 3, 4] 不符合要求，因为相邻元素的差值不符合给定数据。
     * 请你返回 符合 要求的隐藏数组的数目。如果没有符合要求的隐藏数组，请返回 0 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：differences = [1,-3,4], lower = 1, upper = 6
     * 输出：2
     * 解释：符合要求的隐藏数组为：
     * - [3, 4, 1, 5]
     * - [4, 5, 2, 6]
     * 所以返回 2 。
     * 示例 2：
     * <p>
     * 输入：differences = [3,-4,5,1,-2], lower = -4, upper = 5
     * 输出：4
     * 解释：符合要求的隐藏数组为：
     * - [-3, 0, -4, 1, 2, 0]
     * - [-2, 1, -3, 2, 3, 1]
     * - [-1, 2, -2, 3, 4, 2]
     * - [0, 3, -1, 4, 5, 3]
     * 所以返回 4 。
     * 示例 3：
     * <p>
     * 输入：differences = [4,-7,2], lower = 3, upper = 6
     * 输出：0
     * 解释：没有符合要求的隐藏数组，所以返回 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-the-hidden-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param differences
     * @param lower
     * @param upper
     * @return
     */
    public int numberOfArrays(int[] differences, int lower, int upper) {

        int tmp = lower;
        int min = tmp;
        int max = tmp;
        for (int i = 0; i < differences.length; i++) {
            // 计算当前值
            tmp += differences[i];
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }
        if (min > upper || max < lower || max > upper)
            return 0;
        int num1 = lower - min;
        int num2 = max + num1;
        int num3 = upper - num2;
        return num3 + 1 > 0 ? num3 + 1 : 0;
    }

    /**
     * 给你一个下标从 0 开始的二维整数数组 grid ，它的大小为 m x n ，表示一个商店中物品的分布图。数组中的整数含义为：
     * <p>
     * 0 表示无法穿越的一堵墙。
     * 1 表示可以自由通过的一个空格子。
     * 所有其他正整数表示该格子内的一样物品的价格。你可以自由经过这些格子。
     * 从一个格子走到上下左右相邻格子花费 1 步。
     * <p>
     * 同时给你一个整数数组 pricing 和 start ，其中 pricing = [low, high] 且 start = [row, col] ，表示你开始位置为 (row, col) ，同时你只对物品价格在 闭区间 [low, high] 之内的物品感兴趣。同时给你一个整数 k 。
     * <p>
     * 你想知道给定范围 内 且 排名最高 的 k 件物品的 位置 。排名按照优先级从高到低的以下规则制定：
     * <p>
     * 距离：定义为从 start 到一件物品的最短路径需要的步数（较近 距离的排名更高）。
     * 价格：较低 价格的物品有更高优先级，但只考虑在给定范围之内的价格。
     * 行坐标：较小 行坐标的有更高优先级。
     * 列坐标：较小 列坐标的有更高优先级。
     * 请你返回给定价格内排名最高的 k 件物品的坐标，将它们按照排名排序后返回。如果给定价格内少于 k 件物品，那么请将它们的坐标 全部 返回。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[1,2,0,1],[1,3,0,1],[0,2,5,1]], pricing = [2,5], start = [0,0], k = 3
     * 输出：[[0,1],[1,1],[2,1]]
     * 解释：起点为 (0,0) 。
     * 价格范围为 [2,5] ，我们可以选择的物品坐标为 (0,1)，(1,1)，(2,1) 和 (2,2) 。
     * 这些物品的排名为：
     * - (0,1) 距离为 1
     * - (1,1) 距离为 2
     * - (2,1) 距离为 3
     * - (2,2) 距离为 4
     * 所以，给定价格范围内排名最高的 3 件物品的坐标为 (0,1)，(1,1) 和 (2,1) 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[1,2,0,1],[1,3,3,1],[0,2,5,1]], pricing = [2,3], start = [2,3], k = 2
     * 输出：[[2,1],[1,2]]
     * 解释：起点为 (2,3) 。
     * 价格范围为 [2,3] ，我们可以选择的物品坐标为 (0,1)，(1,1)，(1,2) 和 (2,1) 。
     * 这些物品的排名为：
     * - (2,1) 距离为 2 ，价格为 2
     * - (1,2) 距离为 2 ，价格为 3
     * - (1,1) 距离为 3
     * - (0,1) 距离为 4
     * 所以，给定价格范围内排名最高的 2 件物品的坐标为 (2,1) 和 (1,2) 。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：grid = [[1,1,1],[0,0,1],[2,3,4]], pricing = [2,3], start = [0,0], k = 3
     * 输出：[[2,1],[2,0]]
     * 解释：起点为 (0,0) 。
     * 价格范围为 [2,3] ，我们可以选择的物品坐标为 (2,0) 和 (2,1) 。
     * 这些物品的排名为：
     * - (2,1) 距离为 5
     * - (2,0) 距离为 6
     * 所以，给定价格范围内排名最高的 2 件物品的坐标为 (2,1) 和 (2,0) 。
     * 注意，k = 3 但给定价格范围内只有 2 件物品。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-highest-ranked-items-within-a-price-range
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @param pricing
     * @param start
     * @param k
     * @return
     */
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        // 使用优先队列判断 0为距离1为价格，2为x,3为y
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                if (o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
                return Integer.compare(o1[3], o2[3]);
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        // bfs+小根堆
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        int rowLength = grid.length;
        int colLengh = grid[0].length;
        // 当前已经遍历遍历过的
        boolean[][] flag = new boolean[rowLength][colLengh];
        flag[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            // 判断当前的情况
            int cntRow = poll[0];
            int cntCol = poll[1];
            int cntCount = poll[2];
            int cntPrice = grid[cntRow][cntCol];
            // 当前感兴趣
            if (cntPrice >= pricing[0] && cntPrice <= pricing[1]) {
                priorityQueue.add(new int[]{cntCount, cntPrice, cntRow, cntCol});
            }
            // 计算四个点坐标
            int num1 = cntRow - 1;
            int num2 = cntRow + 1;
            int num3 = cntCol - 1;
            int num4 = cntCol + 1;
            // 上
            if (num1 >= 0 && !flag[num1][cntCol] && grid[num1][cntCol] != 0) {
                queue.add(new int[]{num1, cntCol, cntCount + 1});
                flag[num1][cntCol] = true;
            }
            // 下
            if (num2 < rowLength && !flag[num2][cntCol] && grid[num2][cntCol] != 0) {
                queue.add(new int[]{num2, cntCol, cntCount + 1});
                flag[num2][cntCol] = true;
            }
            // 左
            if (num3 >= 0 && !flag[cntRow][num3] && grid[cntRow][num3] != 0) {
                queue.add(new int[]{cntRow, num3, cntCount + 1});
                flag[cntRow][num3] = true;
            }
            // 右
            if (num4 < colLengh && !flag[cntRow][num4] && grid[cntRow][num4] != 0) {
                queue.add(new int[]{cntRow, num4, cntCount + 1});
                flag[cntRow][num4] = true;
            }
        }
        while (k != 0 && priorityQueue.size() != 0) {
            int[] poll = priorityQueue.poll();
            res.add(List.of(poll[2], poll[3]));
            k--;
        }
        return res;
    }

    /**
     * 给你一个下标从 0 开始的二维整数数组 questions ，其中 questions[i] = [pointsi, brainpoweri] 。
     * <p>
     * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），针对每个问题选择 解决 或者 跳过 操作。解决问题 i 将让你 获得  pointsi 的分数，但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri 个问题）。如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
     * <p>
     * 比方说，给你 questions = [[3, 2], [4, 3], [4, 4], [2, 5]] ：
     * 如果问题 0 被解决了， 那么你可以获得 3 分，但你不能解决问题 1 和 2 。
     * 如果你跳过问题 0 ，且解决问题 1 ，你将获得 4 分但是不能解决问题 2 和 3 。
     * 请你返回这场考试里你能获得的 最高 分数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：questions = [[3,2],[4,3],[4,4],[2,5]]
     * 输出：5
     * 解释：解决问题 0 和 3 得到最高分。
     * - 解决问题 0 ：获得 3 分，但接下来 2 个问题都不能解决。
     * - 不能解决问题 1 和 2
     * - 解决问题 3 ：获得 2 分
     * 总得分为：3 + 2 = 5 。没有别的办法获得 5 分或者多于 5 分。
     * 示例 2：
     * <p>
     * 输入：questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
     * 输出：7
     * 解释：解决问题 1 和 4 得到最高分。
     * - 跳过问题 0
     * - 解决问题 1 ：获得 2 分，但接下来 2 个问题都不能解决。
     * - 不能解决问题 2 和 3
     * - 解决问题 4 ：获得 5 分
     * 总得分为：2 + 5 = 7 。没有别的办法获得 7 分或者多于 7 分。
     *  
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/solving-questions-with-brainpower
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param questions
     * @return
     */
    public long mostPoints(int[][] questions) {
        int length = questions.length;
        // dp定义为当前节点的分数指，因为前面的值，取决后面的，所以反向dp
        long[] dp = new long[length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            // 当前节点有两种状态，做和不做
            if (i + questions[i][1] + 1 >= dp.length) {
                // 做 （本身的值） + 上次做的值
                long num1 = questions[i][0];
                // 不做 和前一个相同
                long num2 = dp[i + 1];
                dp[i] = Math.max(num1, num2);
            } else {
                // 做 （本身的值） + 上次做的值
                long num1 = questions[i][0] + dp[i + questions[i][1] + 1];
                // 不做 和前一个相同
                long num2 = dp[i + 1];
                dp[i] = Math.max(num1, num2);
            }
        }
        return dp[0];
    }


    /**
     * 字符串 s 可以按下述步骤划分为若干长度为 k 的组：
     * <p>
     * 第一组由字符串中的前 k 个字符组成，第二组由接下来的 k 个字符串组成，依此类推。每个字符都能够成为 某一个 组的一部分。
     * 对于最后一组，如果字符串剩下的字符 不足 k 个，需使用字符 fill 来补全这一组字符。
     * 注意，在去除最后一个组的填充字符 fill（如果存在的话）并按顺序连接所有的组后，所得到的字符串应该是 s 。
     * <p>
     * 给你一个字符串 s ，以及每组的长度 k 和一个用于填充的字符 fill ，按上述步骤处理之后，返回一个字符串数组，该数组表示 s 分组后 每个组的组成情况 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abcdefghi", k = 3, fill = "x"
     * 输出：["abc","def","ghi"]
     * 解释：
     * 前 3 个字符是 "abc" ，形成第一组。
     * 接下来 3 个字符是 "def" ，形成第二组。
     * 最后 3 个字符是 "ghi" ，形成第三组。
     * 由于所有组都可以由字符串中的字符完全填充，所以不需要使用填充字符。
     * 因此，形成 3 组，分别是 "abc"、"def" 和 "ghi" 。
     * 示例 2：
     * <p>
     * 输入：s = "abcdefghij", k = 3, fill = "x"
     * 输出：["abc","def","ghi","jxx"]
     * 解释：
     * 与前一个例子类似，形成前三组 "abc"、"def" 和 "ghi" 。
     * 对于最后一组，字符串中仅剩下字符 'j' 可以用。为了补全这一组，使用填充字符 'x' 两次。
     * 因此，形成 4 组，分别是 "abc"、"def"、"ghi" 和 "jxx" 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-a-string-into-groups-of-size-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param k
     * @param fill
     * @return
     */
    public String[] divideString1(String s, int k, char fill) {

        int tmp = s.length() % k;
        StringBuilder sb = new StringBuilder(s);
        if (tmp != 0) {
            tmp = k - tmp;
            for (int i = 0; i < tmp; i++) {
                sb.append(fill);
            }
        }
        s = sb.toString();
        int total = s.length() / k;
        String[] strings = new String[total];
        int j = 0;
        for (int i = 0; i < s.length(); i += k) {
            strings[j++] = s.substring(i, i + k);
        }
        return strings;

    }

    public boolean checkValid(int[][] matrix) {
        int length = matrix.length;
        // 检查行
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int k = 0; k < matrix.length; k++) {
                set1.add(matrix[i][k]);
                set2.add(matrix[k][i]);
            }
            if (set1.size() != length || set2.size() != length) return false;
        }
        return true;
    }


    /**
     * 给你两个下标从 0 开始的字符串数组 startWords 和 targetWords 。每个字符串都仅由 小写英文字母 组成。
     * <p>
     * 对于 targetWords 中的每个字符串，检查是否能够从 startWords 中选出一个字符串，执行一次 转换操作 ，得到的结果与当前 targetWords 字符串相等。
     * <p>
     * 转换操作 如下面两步所述：
     * <p>
     * 追加 任何 不存在 于当前字符串的任一小写字母到当前字符串的末尾。
     * 例如，如果字符串为 "abc" ，那么字母 'd'、'e' 或 'y' 都可以加到该字符串末尾，但 'a' 就不行。如果追加的是 'd' ，那么结果字符串为 "abcd" 。
     * 重排 新字符串中的字母，可以按 任意 顺序重新排布字母。
     * 例如，"abcd" 可以重排为 "acbd"、"bacd"、"cbda"，以此类推。注意，它也可以重排为 "abcd" 自身。
     * 找出 targetWords 中有多少字符串能够由 startWords 中的 任一 字符串执行上述转换操作获得。返回 targetWords 中这类 字符串的数目 。
     * <p>
     * 注意：你仅能验证 targetWords 中的字符串是否可以由 startWords 中的某个字符串经执行操作获得。startWords  中的字符串在这一过程中 不 发生实际变更。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：startWords = ["ant","act","tack"], targetWords = ["tack","act","acti"]
     * 输出：2
     * 解释：
     * - 为了形成 targetWords[0] = "tack" ，可以选用 startWords[1] = "act" ，追加字母 'k' ，并重排 "actk" 为 "tack" 。
     * - startWords 中不存在可以用于获得 targetWords[1] = "act" 的字符串。
     * 注意 "act" 确实存在于 startWords ，但是 必须 在重排前给这个字符串追加一个字母。
     * - 为了形成 targetWords[2] = "acti" ，可以选用 startWords[1] = "act" ，追加字母 'i' ，并重排 "acti" 为 "acti" 自身。
     * 示例 2：
     * <p>
     * 输入：startWords = ["ab","a"], targetWords = ["abc","abcd"]
     * 输出：1
     * 解释：
     * - 为了形成 targetWords[0] = "abc" ，可以选用 startWords[0] = "ab" ，追加字母 'c' ，并重排为 "abc" 。
     * - startWords 中不存在可以用于获得 targetWords[1] = "abcd" 的字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-words-obtained-after-adding-a-letter
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param startWords
     * @param targetWords
     * @return
     */
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> startSet = new HashSet<>();
        for (String startWord : startWords) {
            StringBuilder sb = new StringBuilder("000000000000000000000000000");
            for (int i = 0; i < startWord.length(); i++) {
                sb.setCharAt(startWord.charAt(i) - 'a', '1');
            }
            startSet.add(sb.toString());
        }
        int res = 0;
        for (String targetWord : targetWords) {
            // 因为最多只有26个字母  ==》o(1)
            for (int i = 0; i < targetWord.length(); i++) {
                StringBuilder sb = new StringBuilder(targetWord);
                sb.deleteCharAt(i);
                String string = sb.toString();
                StringBuilder sb1 = new StringBuilder("000000000000000000000000000");
                for (int j = 0; j < string.length(); j++) {
                    sb1.setCharAt(string.charAt(j) - 'a', '1');
                }
                if (startSet.contains(sb1.toString())) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
     *
     * 环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
     *
     * 给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [0,1,0,1,1,0,0]
     * 输出：1
     * 解释：这里列出一些能够将所有 1 聚集在一起的方案：
     * [0,0,1,1,1,0,0] 交换 1 次。
     * [0,1,1,1,0,0,0] 交换 1 次。
     * [1,1,0,0,0,0,1] 交换 2 次（利用数组的环形特性）。
     * 无法在交换 0 次的情况下将数组中的所有 1 聚集在一起。
     * 因此，需要的最少交换次数为 1 。
     * 示例 2：
     *
     * 输入：nums = [0,1,1,1,0,0,1,1,0]
     * 输出：2
     * 解释：这里列出一些能够将所有 1 聚集在一起的方案：
     * [1,1,1,0,0,0,0,1,1] 交换 2 次（利用数组的环形特性）。
     * [1,1,1,1,1,0,0,0,0] 交换 2 次。
     * 无法在交换 0 次或 1 次的情况下将数组中的所有 1 聚集在一起。
     * 因此，需要的最少交换次数为 2 。
     * 示例 3：
     *
     * 输入：nums = [1,1,0,0,1]
     * 输出：0
     * 解释：得益于数组的环形特性，所有的 1 已经聚集在一起。
     * 因此，需要的最少交换次数为 0 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    /**
     * 思路：  我们可以统计出全部1的个数，开辟一个大小为total1的滑动窗口，接着从位置0开始进行枚举，如果选择i作为起点，那么
     * 这个区间内0的个数，就是需要进行交换的数量，(因为可以随便选择别的位置上的1进行交换)
     *
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {
        // 统计1的个数
        int total1 = 0;
        for (int num : nums) {
            if (num == 1) total1++;
        }
        // 统计i=0时，区间内0的个数，
        int total0 = 0;
        for (int i = 0; i < total1; i++) {
            if (nums[i] == 0) total0++;
        }
        int min = total0;
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            // 计算当前区间内0的个数
            if (nums[(i - 1) % length] == 0)
                total0--;
            if (nums[(i + total1 - 1) % length] == 0)
                total0++;
            min = Math.min(total0, min);
        }
        return min;
    }


    /**
     * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
     * <p>
     * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
     * 否则，将单词首字母大写，剩余字母变成小写。
     * 请你返回 大写后 的 title 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：title = "capiTalIze tHe titLe"
     * 输出："Capitalize The Title"
     * 解释：
     * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
     * 示例 2：
     * <p>
     * 输入：title = "First leTTeR of EACH Word"
     * 输出："First Letter of Each Word"
     * 解释：
     * 单词 "of" 长度为 2 ，所以它保持完全小写。
     * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
     * 示例 3：
     * <p>
     * 输入：title = "i lOve leetcode"
     * 输出："i Love Leetcode"
     * 解释：
     * 单词 "i" 长度为 1 ，所以它保留小写。
     * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/capitalize-the-title
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param title
     * @return
     */
    public String capitalizeTitle(String title) {
        String[] strings = title.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 1 || strings[i].length() == 2)
                strings[i] = strings[i].toLowerCase();
            else {
                String tmp = strings[i];
                strings[i] = tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
            }
        }
        return String.join(" ", strings);

    }

    /**
     * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
     * <p>
     * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
     * 孪生和 定义为一个节点和它孪生节点两者值之和。
     * <p>
     * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [5,4,2,1]
     * 输出：6
     * 解释：
     * 节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
     * 链表中没有其他孪生节点。
     * 所以，链表的最大孪生和是 6 。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [4,2,2,3]
     * 输出：7
     * 解释：
     * 链表中的孪生节点为：
     * - 节点 0 是节点 3 的孪生节点，孪生和为 4 + 3 = 7 。
     * - 节点 1 是节点 2 的孪生节点，孪生和为 2 + 2 = 4 。
     * 所以，最大孪生和为 max(7, 4) = 7 。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,100000]
     * 输出：100001
     * 解释：
     * 链表中只有一对孪生节点，孪生和为 1 + 100000 = 100001 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-twin-sum-of-a-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        // 快反指针（找中点偶数）
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转链表 (头插法)
        ListNode nextHead = slow.next;
        ListNode pre = null;
        while (nextHead != null) {
            ListNode tmp = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = tmp;
        }
        while (head != null && pre != null) {
            max = Math.max(max, head.val + pre.val);
            head = head.next;
            pre = pre.next;
        }
        return max;
    }

    /**
     * 给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aaabbb"
     * 输出：true
     * 解释：
     * 'a' 位于下标 0、1 和 2 ；而 'b' 位于下标 3、4 和 5 。
     * 因此，每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
     * 示例 2：
     * <p>
     * 输入：s = "abab"
     * 输出：false
     * 解释：
     * 存在一个 'a' 位于下标 2 ，而一个 'b' 位于下标 1 。
     * 因此，不能满足每个 'a' 都出现在每个 'b' 之前，所以返回 false 。
     * 示例 3：
     * <p>
     * 输入：s = "bbb"
     * 输出：true
     * 解释：
     * 不存在 'a' ，因此可以视作每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-if-all-as-appears-before-all-bs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean checkString(String s) {
        int maxA = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                maxA = Math.max(maxA, i);
            } else {
                minB = Integer.min(minB, i);
            }
        }
        return maxA < minB;

    }

    /**
     * 银行内部的防盗安全装置已经激活。给你一个下标从 0 开始的二进制字符串数组 bank ，表示银行的平面图，这是一个大小为 m x n 的二维矩阵。 bank[i] 表示第 i 行的设备分布，由若干 '0' 和若干 '1' 组成。'0' 表示单元格是空的，而 '1' 表示单元格有一个安全设备。
     * <p>
     * 对任意两个安全设备而言，如果同时 满足下面两个条件，则二者之间存在 一个 激光束：
     * <p>
     * 两个设备位于两个 不同行 ：r1 和 r2 ，其中 r1 < r2 。
     * 满足 r1 < i < r2 的 所有 行 i ，都 没有安全设备 。
     * 激光束是独立的，也就是说，一个激光束既不会干扰另一个激光束，也不会与另一个激光束合并成一束。
     * <p>
     * 返回银行中激光束的总数量。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：bank = ["011001","000000","010100","001000"]
     * 输出：8
     * 解释：在下面每组设备对之间，存在一条激光束。总共是 8 条激光束：
     * * bank[0][1] -- bank[2][1]
     * * bank[0][1] -- bank[2][3]
     * * bank[0][2] -- bank[2][1]
     * * bank[0][2] -- bank[2][3]
     * * bank[0][5] -- bank[2][1]
     * * bank[0][5] -- bank[2][3]
     * * bank[2][1] -- bank[3][2]
     * * bank[2][3] -- bank[3][2]
     * 注意，第 0 行和第 3 行上的设备之间不存在激光束。
     * 这是因为第 2 行存在安全设备，这不满足第 2 个条件。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：bank = ["000","111","000"]
     * 输出：0
     * 解释：不存在两个位于不同行的设备
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-laser-beams-in-a-bank
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param bank
     * @return
     */
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (String s : bank) {
            int tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    tmp++;
            }
            if (tmp > 0) {
                list.add(tmp);
            }
        }
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += list.get(i) * list.get(i + 1);
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
     * 一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。
     * <p>
     * 给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。
     * <p>
     * 请你返回单个句子里 单词的最多数目 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
     * 输出：6
     * 解释：
     * - 第一个句子 "alice and bob love leetcode" 总共有 5 个单词。
     * - 第二个句子 "i think so too" 总共有 4 个单词。
     * - 第三个句子 "this is great thanks very much" 总共有 6 个单词。
     * 所以，单个句子中有最多单词数的是第三个句子，总共有 6 个单词。
     * 示例 2：
     * <p>
     * 输入：sentences = ["please wait", "continue to fight", "continue to win"]
     * 输出：3
     * 解释：可能有多个句子有相同单词数。
     * 这个例子中，第二个句子和第三个句子（加粗斜体）有相同数目的单词数。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-words-found-in-sentences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param sentences
     * @return
     */
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            max = Math.max(max, sentence.split(" ").length);
        }

        return max;
    }

    /**
     * 你有 n 道不同菜的信息。给你一个字符串数组 recipes 和一个二维字符串数组 ingredients 。第 i 道菜的名字为 recipes[i] ，如果你有它 所有 的原材料 ingredients[i] ，那么你可以 做出 这道菜。一道菜的原材料可能是 另一道 菜，也就是说 ingredients[i] 可能包含 recipes 中另一个字符串。
     * <p>
     * 同时给你一个字符串数组 supplies ，它包含你初始时拥有的所有原材料，每一种原材料你都有无限多。
     * <p>
     * 请你返回你可以做出的所有菜。你可以以 任意顺序 返回它们。
     * <p>
     * 注意两道菜在它们的原材料中可能互相包含。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
     * 输出：["bread"]
     * 解释：
     * 我们可以做出 "bread" ，因为我们有原材料 "yeast" 和 "flour" 。
     * 示例 2：
     * <p>
     * 输入：recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
     * 输出：["bread","sandwich"]
     * 解释：
     * 我们可以做出 "bread" ，因为我们有原材料 "yeast" 和 "flour" 。
     * 我们可以做出 "sandwich" ，因为我们有原材料 "meat" 且可以做出原材料 "bread" 。
     * 示例 3：
     * <p>
     * 输入：recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
     * 输出：["bread","sandwich","burger"]
     * 解释：
     * 我们可以做出 "bread" ，因为我们有原材料 "yeast" 和 "flour" 。
     * 我们可以做出 "sandwich" ，因为我们有原材料 "meat" 且可以做出原材料 "bread" 。
     * 我们可以做出 "burger" ，因为我们有原材料 "meat" 且可以做出原材料 "bread" 和 "sandwich" 。
     * 示例 4：
     * <p>
     * 输入：recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast"]
     * 输出：[]
     * 解释：
     * 我们没法做出任何菜，因为我们只有原材料 "yeast" 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-possible-recipes-from-given-supplies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param recipes
     * @param ingredients
     * @param supplies
     * @return
     */
    /*boolean[] visitedAllRecipes;
    boolean[] makedAllRecipes;
    // 深度优先遍历，自己的思路是改变原材料，错误，如果使用boolean数组做标记，能否完成。
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int length = recipes.length;
        visitedAllRecipes = new boolean[length];
        makedAllRecipes = new boolean[length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], i);
        }
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            if (!visitedAllRecipes[i]) {
                makedAllRecipes[i] = dfsFindAllRecipes(i, ingredients, set, map);
            }
            if (makedAllRecipes[i]) {
                strings.add(recipes[i]);
            }
        }
        return strings;
    }

    private boolean dfsFindAllRecipes(int i, List<List<String>> ingredients, Set<String> set, Map<String, Integer> map) {
        // 如果当前节点已经遍历过了，直接返回，时候能完成
        if (visitedAllRecipes[i])
            return makedAllRecipes[i];
        else {
            visitedAllRecipes[i] = true;
            List<String> list = ingredients.get(i);
            for (int j = 0; j < list.size(); j++) {
                String cnt = list.get(j);
                // 如果不包含当前的原料
                if (!set.contains(cnt)) {
                    // 判断能否通过原料表合成,如果不包含直接返回false
                    if (!map.containsKey(cnt)) return false;
                    // 判断下面的子孩子能不能完成
                    boolean b = dfsFindAllRecipes(map.get(cnt), ingredients, set, map);
                    if (!b) {
                        return false;
                    } else {
                        makedAllRecipes[map.get(cnt)] = true;
                    }
                }
            }
            return true;
        }
    }*/

    /*public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int length = recipes.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], i);
        }
        Set<String> set = new HashSet<>(Arrays.asList(supplies));
        boolean[] flags = new boolean[length];
        Set<String> res = new HashSet<>();
        for (int i = 0; i < recipes.length; i++) {
            if (!res.contains(recipes[i])) {
                boolean b = backTrackAllRecipes(flags, recipes[i], ingredients, set, res, map);
                if (b) {
                    res.add(recipes[i]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private boolean backTrackAllRecipes(boolean[] flags, String recipe, List<List<String>> ingredients, Set<String> set, Set<String> res, Map<String, Integer> map) {
        if (res.contains(recipe))
            return true;
        Integer index = map.get(recipe);
        if (!flags[index]) {
            flags[index] = true;
            List<String> list = ingredients.get(index);
            for (int i = 0; i < list.size(); i++) {
                String cnt = list.get(i);
                if (!set.contains(cnt)) {
                    // 如果原料表不包含，这接返回
                    if (!map.containsKey(cnt))
                        return false;
                    boolean flag = backTrackAllRecipes(flags, cnt, ingredients, set, res, map);
                    if (!flag) {
                        return false;
                    } else {
                        res.add(cnt);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }*/


    // 从入度为0的supplies入手，对于每个原料，先删除当前遍历到的元素，如果当前如果原料入读为0添加到原料表中
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(List.of(supplies));
        while (!queue.isEmpty()) {
            String cntItem = queue.poll();
            for (int i = 0; i < ingredients.size(); i++) {
                List<String> stringList = ingredients.get(i);
                if (stringList.size() == 0)
                    continue;
                stringList.remove(cntItem);
                if (stringList.size() == 0) {
                    queue.offer(recipes[i]);
                    list.add(recipes[i]);
                }
            }
        }
        return list;
    }

    public boolean canBeValid(String s, String locked) {
        int valid1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (valid1 > 0) {
                    valid1--;
                } else {
                    if (locked.charAt(i) == '0') {
                        valid1++;
                    } else {
                        return false;
                    }
                }
            } else {
                if (valid1 > 0 && locked.charAt(i) == '0') {
                    valid1--;
                } else {
                    valid1++;
                }
            }
        }

        return valid1 == 0;
    }


    public int maxDistance(int[] colors) {
        List<Integer>[] lists = new List[101];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            lists[color].add(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.length; i++) {
            List<Integer> list1 = lists[i];
            for (int j = i + 1; j < lists.length; j++) {
                List<Integer> list2 = lists[j];
                for (Integer integer : list1) {
                    for (Integer integer1 : list2) {
                        max = Math.max(max, Math.abs(integer - integer1));
                    }
                }
            }
        }
        return max;
    }


    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int init = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (capacity >= plants[i]) {
                res++;
                capacity -= plants[i];
            } else {
                capacity = init;
                res += i + i + 1;
                capacity -= plants[i];
            }
        }

        return res;
    }


}
