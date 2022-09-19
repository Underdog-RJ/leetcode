package cn.underdog.leetcode.MainClass;

/**
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * <p>
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import cn.underdog.leetcode.entity.TreeNode;
import cn.underdog.leetcode.segmentTree.RangeFreqQuery;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        System.out.println(mainClass.validTicTacToe(new String[]{"OOX", "OXO", "XOX"}));
//        System.out.println(mainClass.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
//        mainClass.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});
//        System.out.println(numWaterBottles(15, 4));
//        System.out.println(numWaterBottles(9, 3));
//        mainClass.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', '.'}});
//        mainClass.countBattleships(new char[][]{{'X', 'X', 'X'}});
//        mainClass.repeatedStringMatch("abcd", "cdabcdab");
//        mainClass.repeatedStringMatch("a", "aa");
//        mainClass.repeatedStringMatch("a", "a");
//        mainClass.repeatedStringMatch("abc", "wxyz");
//        mainClass.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba");
//        mainClass.eatenApples(new int[]{3, 1, 1, 0, 0, 2}, new int[]{3, 1, 1, 0, 0, 2});
//        mainClass.findOcurrences("we will we will rock you", "we", "will");
//        mainClass.numFriendRequests(new int[]{16,17,18});
//        System.out.println(mainClass.numFriendRequests(new int[]{16, 16}));
//        System.out.println(mainClass.numFriendRequests(new int[]{8, 85, 24, 85, 69}));
//        System.out.println(mainClass.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
//        System.out.println(mainClass.countQuadruplets(new int[]{28,8,49,85,37,90,20,8}));
//        System.out.println(mainClass.countQuadruplets(new int[]{9, 6, 8, 23, 39, 23}));
//        mainClass.construct2DArray(new int[]{1,2,3,4},2,2);
//        mainClass.lastRemaining((int) Math.pow(10,9));
//        mainClass.lastRemaining(9);
//        mainClass.dayOfTheWeek(31,8,2019);
//        mainClass.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);
//        mainClass.isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2);
//        mainClass.isNStraightHand(new int[]{2, 1}, 2);
//        mainClass.modifyString("???");
//        System.out.println((int) 'a');
//        System.out.println((int) 'z');
//        mainClass.increasingTriplet(new int[]{1, 2, 3, 4, 5});
//        String s = mainClass.complexNumberMultiply("1+9i", "2+-18i");
//        String s = mainClass.convertToBase7(100);
//        String s = mainClass.convertToBase7(-7);
//        System.out.println(s);
//        new MainClass().validUtf8(new int[]{197, 130, 1});
//        new MainClass().selfDividingNumbers(1, 22);
//        mainClass.toGoatLatin("I speak Goat Latin");
//        mainClass.minDeletionSize(new String[]{"rrjk", "furt", "guzm"});
//        mainClass.oneEditAway("pale", "ple");


//        mainClass.oneEditAway("abcdxabcde", "abcdeabcdx");
//        mainClass.oneEditAway("a", "b");
//        mainClass.canIWin(4, 6);
//        mainClass.findSubstringInWraproundString("cabd");
//        mainClass.findSubstringInWraproundString("zab");
//        mainClass.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student");
//        mainClass.removeOuterParentheses("(()())(())");
//        mainClass.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
//        mainClass.validIPAddress("172.16.254.1");
//        System.out.println(mainClass.consecutiveNumbersSum1(5));
//        System.out.println(mainClass.consecutiveNumbersSum1(9));
//        System.out.println(mainClass.consecutiveNumbersSum1(15));
//        mainClass.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
//        mainClass.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"});
//        mainClass.minFlipsMonoIncr("010110");
//        mainClass.findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb");
//        mainClass.smallestDistancePair(new int[]{1, 3, 1}, 1);
//        mainClass.findPairs3(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3);
//        mainClass.findPairs3(new int[]{3, 1, 4, 1, 5}, 2);
//        mainClass.duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
//        mainClass.findLUSlength(new String[]{"aba", "cdc", "eae"});
//        mainClass.findLUSlength(new String[]{"aaa", "aa", "aaa"});
//        mainClass.findLUSlength(new String[]{"aabbcc", "aabbcc", "bc", "bcc", "aabbccc"});
//        mainClass.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
//        System.out.println(mainClass.numPrimeArrangements(100));
//        mainClass.minimumAbsDifference(new int[]{4, 2, 1, 3});
//        System.out.println(mainClass.nextGreaterElement(2147483476));
//        System.out.println(mainClass.nextGreaterElement(212));

//        mainClass.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;
//        System.out.println(mainClass.longestUnivaluePath(treeNode));
//        mainClass.subsetXORSum(new int[]{1, 3});
//        System.out.println((long) Math.pow(2,16)*16);
        mainClass.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}});
    }


    public boolean validTicTacToe(String[] board) {
        // 判断对角线
        StringBuilder sb = new StringBuilder();
        sb.append(board[0].charAt(0));
        sb.append(board[1].charAt(1));
        sb.append(board[2].charAt(2));
        String s1 = sb.toString();
        if (s1.equals("XXX") || s1.equals("OOO")) return false;
        sb = new StringBuilder();
        sb.append(board[0].charAt(2));
        sb.append(board[1].charAt(1));
        sb.append(board[2].charAt(0));
        String s2 = sb.toString();
        if (s2.equals("XXX") || s2.equals("OOO")) return false;
        // 每一行
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("XXX") || board[i].equals("OOO")) return false;
        }
        // 每一列
        for (int i = 0; i < 3; i++) {
            String s = board[0].charAt(i) + "" + board[1].charAt(i) + "" + board[2].charAt(i);
            if (s.equals("XXX") || s.equals("OOO")) return false;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i].charAt(j) == 'X') num1++;
                else if (board[i].charAt(j) == 'O') num2++;
            }
        }
        if (num1 == 1 && num2 == 0) return true;
        if (num1 == num2) return true;
        else return false;

    }

    /**
     * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
     * <p>
     * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
     * <p>
     * 在匹配 licensePlate 中的字母时：
     * <p>
     * 忽略 licensePlate 中的 数字和空格 。
     * 不区分大小写。
     * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
     * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
     * <p>
     * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
     * 输出："steps"
     * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
     * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
     * "steps" 包含 "t"、"p" 和两个 "s"。
     * "stripe" 缺一个 "s"。
     * "stepple" 缺一个 "s"。
     * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
     * 示例 2：
     * <p>
     * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
     * 输出："pest"
     * 解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
     * 示例 3：
     * <p>
     * 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
     * 输出："husband"
     * 示例 4：
     * <p>
     * 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
     * 输出："enough"
     * 示例 5：
     * <p>
     * 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
     * 输出："simple"
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-completing-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String str = licensePlate.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 97 && str.charAt(i) <= 122)
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            for (int j = 0; j < word.length(); j++)
                temp.put(word.charAt(j), temp.getOrDefault(word.charAt(j), 0) + 1);
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (temp.containsKey(entry.getKey())) {
                    Integer value = entry.getValue();
                    Integer integer = temp.get(entry.getKey());
                    if (integer < value) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (length < min) {
                    min = length;
                    res = word;
                }
            }
            temp.clear();
        }
        return res;

    }

    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            int res = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') res++;
            }
            ints[i] = res;
        }
        return ints;
    }

    /**
     * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "Hello"
     * 输出："hello"
     * 示例 2：
     * <p>
     * 输入：s = "here"
     * 输出："here"
     * 示例 3：
     * <p>
     * 输入：s = "LOVELY"
     * 输出："lovely"
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/to-lower-case
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }


    /**
     * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 高度 0 也被认为是建筑物。
     * <p>
     * 最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。
     * <p>
     * 建筑物高度可以增加的最大总和是多少？
     * <p>
     * 例子：
     * 输入： grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
     * 输出： 35
     * 解释：
     * The grid is:
     * [ [3, 0, 8, 4],
     * [2, 4, 5, 7],
     * [9, 2, 6, 3],
     * [0, 3, 1, 0] ]
     * <p>
     * 从数组竖直方向（即顶部，底部）看“天际线”是：[9, 4, 8, 7]
     * 从水平水平方向（即左侧，右侧）看“天际线”是：[8, 7, 9, 3]
     * <p>
     * 在不影响天际线的情况下对建筑物进行增高后，新数组如下：
     * <p>
     * gridNew = [ [8, 4, 8, 7],
     * [7, 4, 7, 7],
     * [9, 4, 8, 7],
     * [3, 3, 3, 3] ]
     * 说明:
     * <p>
     * 1 < grid.length = grid[0].length <= 50。
     *  grid[i][j] 的高度范围是： [0, 100]。
     * 一座建筑物占据一个grid[i][j]：换言之，它们是 1 x 1 x grid[i][j] 的长方体。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {


        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 获取当前行最大值
                int rowMax = Arrays.stream(grid[i]).max().getAsInt();
                int[] col = new int[grid.length];
                // 获取当前列最大值
                for (int u = 0; u < grid.length; u++) {
                    col[u] = grid[u][j];
                }
                int colMax = Arrays.stream(col).max().getAsInt();
                res += Math.min(rowMax, colMax) - grid[i][j];

            }
        }
        return res;
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;
        if (numBottles == numExchange) return numBottles + 1;
        int res = numBottles;
        while (numBottles >= numExchange) {
            int yushu = numBottles % numExchange;
            numBottles /= numExchange;
            res += numBottles;
            numBottles += yushu;
        }
        return res;
    }

    /**
     * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
     * <p>
     * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：board = [["."]]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/battleships-in-a-board
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        int res = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    if (j > 0 && board[i][j - 1] == 'X') continue;

                    res++;
                }
            }
        }

        return res;
    }

    public void testLRU() {
       /* LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);*/
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }

    /**
     * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
     * <p>
     * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：date = "2019-01-09"
     * 输出：9
     * 示例 2：
     * <p>
     * 输入：date = "2019-02-10"
     * 输出：41
     * 示例 3：
     * <p>
     * 输入：date = "2003-03-01"
     * 输出：60
     * 示例 4：
     * <p>
     * 输入：date = "2004-03-01"
     * 输出：61
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/day-of-the-year
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param date
     * @return
     */
    public int dayOfYear(String date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate of = LocalDate.parse(date, fmt);
        LocalDate with = LocalDate.parse(date, fmt).with(TemporalAdjusters.firstDayOfYear());
        long until = with.until(of, ChronoUnit.DAYS);
        return (int) until;

    }

    /**
     * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     * <p>
     * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：a = "abcd", b = "cdabcdab"
     * 输出：3
     * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
     * 示例 2：
     * <p>
     * 输入：a = "a", b = "aa"
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：a = "a", b = "a"
     * 输出：1
     * 示例 4：
     * <p>
     * 输入：a = "abc", b = "wxyz"
     * 输出：-1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-string-match
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param a
     * @param b
     * @return
     */
    public int repeatedStringMatch(String a, String b) {
        if (" ".equals(b) || b.equals(null)) return 0;
        // 首先判断b中是否存在a中不存在的Chartacter
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();
        for (int i = 0; i < a.length(); i++)
            setA.add(a.charAt(i));
        for (int i = 0; i < b.length(); i++)
            setB.add(b.charAt(i));
        Iterator<Character> iterator = setB.iterator();
        while (iterator.hasNext()) {
            if (!setA.contains(iterator.next())) return -1;
        }
        // 接着每次拼接a并且res++；用indexOf检测是否存在
        // 跳出循环的条件为res执行了三次并且当前累加的长度大于b长度的三倍，因为是字串，所以拼接三次一定可以找出字串。
        StringBuilder sb = new StringBuilder(a);
        int bLength = b.length();
        int res = 1;
        while (true) {
            String s = sb.toString();
            if (res > 3 && s.length() > bLength * 3) return -1;
            if (s.indexOf(b) != -1) return res;
            sb.append(a);
            res++;
        }
    }

    /**
     * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
     * <p>
     * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
     * <p>
     * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
     * 输出：7
     * 解释：你可以吃掉 7 个苹果：
     * - 第一天，你吃掉第一天长出来的苹果。
     * - 第二天，你吃掉一个第二天长出来的苹果。
     * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
     * - 第四天到第七天，你吃的都是第四天长出来的苹果。
     * 示例 2：
     * <p>
     * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
     * 输出：5
     * 解释：你可以吃掉 5 个苹果：
     * - 第一天到第三天，你吃的都是第一天长出来的苹果。
     * - 第四天和第五天不吃苹果。
     * - 第六天和第七天，你吃的都是第六天长出来的苹果。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        for (; i < apples.length; i++) {
            // 添加今天长成的苹果
            Integer orDefault = map.getOrDefault((i + days[i]), 0) + apples[i];
            if (orDefault > 0) map.put(i + days[i], orDefault);
            // 今天能否吃苹果
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(i + 1);
            // 不能直接返回
            if (entry == null) continue;
            res++;
            Integer integer = entry.getKey();
            Integer value = map.get(integer);
            // 今天吃的
            // 如果剩下一个直接移除
            if (value <= 1) map.remove(integer);
                // 如果大于则更新
            else map.put(integer, --value);
        }
        while (true) {
            i++;
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(i);
            if (entry == null) break;
            res++;
            Integer value = entry.getValue();
            if (value == 1) map.remove(entry.getKey());
            else map.put(entry.getKey(), --value);
        }
        return res;
    }

    /**
     * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
     * <p>
     * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
     * 输出：["girl","student"]
     * 示例 2：
     * <p>
     * 输入：text = "we will we will rock you", first = "we", second = "will"
     * 输出：["we","rock"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/occurrences-after-bigram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(first) && i + 1 < s.length && s[i + 1].equals(second) && i + 2 < s.length) {
                res.add(s[i + 2]);
            }
        }
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    // 暴力超时

    /**
     * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
     * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     * 否则，x 将会向 y 发送一条好友请求。
     * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
     * 返回在该社交媒体网站上产生的好友请求总数。
     * 示例 1：
     * 输入：ages = [16,16]
     * 输出：2
     * 解释：2 人互发好友请求。
     * 示例 2：
     * <p>
     * 输入：ages = [16,17,18]
     * 输出：2
     * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
     * 示例 3：
     * <p>
     * 输入：ages = [20,30,100,110,120]
     * 输出：3
     * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
     *
     * @param ages
     * @return
     */
    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);
        int length = ages.length;
        int res = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (ages[j] <= 0.5 * ages[i] + 7) break;
                if (ages[j] > ages[i]) break;
                if (ages[j] > 100 && ages[i] < 100) break;
                if (ages[i] == ages[j]) res += 2;
                else res++;
            }
        }
        return res;
    }

    public int numFriendRequests(int[] ages) {
        int res = 0;
        int left = 0;
        int right = 0;
        Arrays.sort(ages);
        for (int age : ages) {
            if (age < 15) continue;
            while (ages[left] <= 0.5 * age + 7) ++left;
            while (right + 1 < ages.length && ages[right + 1] < age) ++right;
            res += right - left;
        }
        return res;
    }


    /**
     * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
     * <p>
     * nums[a] + nums[b] + nums[c] == nums[d] ，且
     * a < b < c < d
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3,6]
     * 输出：1
     * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,3,6,4,5]
     * 输出：0
     * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
     * 示例 3：
     * <p>
     * 输入：nums = [1,1,1,3,5]
     * 输出：4
     * 解释：满足要求的 4 个四元组如下：
     * - (0, 1, 2, 3): 1 + 1 + 1 == 3
     * - (0, 1, 3, 4): 1 + 1 + 3 == 5
     * - (0, 2, 3, 4): 1 + 1 + 3 == 5
     * - (1, 2, 3, 4): 1 + 1 + 3 == 5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int countQuadruplets(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int u = j + 1; u < length; u++) {
                    for (int k = u + 1; k < length; k++) {
                        int current = nums[i] + nums[j] + nums[u];
                        int target = nums[k];
                        if (current == target) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;
        int total = m * n;
        if (length != total) return new int[0][];
        int targetArray[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                targetArray[i][j] = original[i * n + j];
            }
        }
        return targetArray;
    }

    /**
     * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
     * <p>
     * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
     * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
     * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
     * 给你整数 n ，返回 arr 最后剩下的数字。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 9
     * 输出：6
     * 解释：
     * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
     * arr = [2, 4, 6, 8]
     * arr = [2, 6]
     * arr = [6]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/elimination-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        int cnt = n;
        int k = 0;
        int a1 = 1; // 开头
        int step = 1;
        while (cnt > 1) {
            // 正向 更新头元素
            if (k % 2 == 0) a1 += step;
                // 反向
            else {
                // 反向如果当前元素时奇数则删除，否则不动
                if (cnt % 2 == 1) a1 += step;
            }
            // 记录是偶数还是奇数
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static int MAXIMUM_CAPACITY = 1 << 30;

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate of = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = of.getDayOfWeek();
        String name = dayOfWeek.name();
        String res = name.substring(0, 1) + name.substring(1).toLowerCase();
        return res;
    }

    /**
     * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
     * <p>
     * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num = 28
     * 输出：true
     * 解释：28 = 1 + 2 + 4 + 7 + 14
     * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
     * 示例 2：
     * <p>
     * 输入：num = 6
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：num = 496
     * 输出：true
     * 示例 4：
     * <p>
     * 输入：num = 8128
     * 输出：true
     * 示例 5：
     * <p>
     * 输入：num = 2
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        int sum = 1;
        for (int i = 2; i * i < num; i++) {
            if (integers.contains(i)) continue;
            if (num % i == 0) {
                int temp = num / i;
                sum += i;
                sum += temp;
                integers.add(i);
                integers.add(temp);
            }
        }
        return sum == num;
    }

    /**
     * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
     * <p>
     * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
     * 输出：true
     * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
     * 示例 2：
     * <p>
     * 输入：hand = [1,2,3,4,5], groupSize = 4
     * 输出：false
     * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hand-of-straights
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param hand
     * @param groupSize
     * @return
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Arrays.sort(hand);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < hand.length; i++) {
            list.add(hand[i]);
        }
        int total = groupSize;
        while (groupSize != 0) {
            // 选择当前最小的
            int min = list.get(0);
            int cntTotal = total;
            while (cntTotal != 0) {
                int pre = min;
                boolean contains = list.contains(min++);
                if (!contains) return false;
                list.remove(list.indexOf(pre));
                cntTotal--;
            }
            groupSize--;
        }
        return true;
    }


    /**
     * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
     * <p>
     * 注意：你 不能 修改非 '?' 字符。
     * <p>
     * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
     * <p>
     * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "?zs"
     * 输出："azs"
     * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
     * 示例 2：
     * <p>
     * 输入：s = "ubv?w"
     * 输出："ubvaw"
     * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
     * 示例 3：
     * <p>
     * 输入：s = "j?qg??b"
     * 输出："jaqgacb"
     * 示例 4：
     * <p>
     * 输入：s = "??yw?ipkj?"
     * 输出："acywaipkja"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.charAt(0) == '?') {
            if (sb.length() == 1) {
                return "a";
            } else {
                if (sb.charAt(1) == '?') {
                    sb.setCharAt(0, 'a');
                } else {
                    int head = sb.charAt(1);
                    if ((char) head == 'c') sb.setCharAt(0, 'b');
                    else if ((char) head == 'z') sb.setCharAt(0, 'a');
                    else sb.setCharAt(0, 'c');
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == '?') {
            if (sb.length() == 1) {
                return "a";
            } else {
                if (sb.charAt(sb.length() - 2) == '?') {
                    sb.setCharAt(sb.length() - 1, 'a');
                } else {
                    int head = sb.charAt(sb.length() - 2);
                    if ((char) head == 'a') sb.setCharAt(sb.length() - 1, 'b');
                    else if ((char) head == 'z') sb.setCharAt(sb.length() - 1, 'a');
                    else sb.setCharAt(sb.length() - 1, 'a');
                }
            }
        }
        for (int i = 1; i < sb.length() - 1; i++) {
            if (sb.charAt(i) != '?') continue;
            // 前一个
            int head = sb.charAt(i - 1);
            // 后一个
            int tail = sb.charAt(i + 1);
            int index = 97;
            while (index == head || index == tail) {
                index++;
            }
            sb.setCharAt(i, (char) index);
        }
        return sb.toString();

    }

    // 暴力
   /* public boolean increasingTriplet(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 >= num2)
                    continue;
                for (int u = j + 1; u < nums.length; u++) {
                    int num3 = nums[u];
                    if (num2 >= num3)
                        continue;
                    else
                        return true;
                }
            }
        }
        return false;
    }*/

    // 记录左边最小，右边最大，
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        int[] lmin = new int[length];
        lmin[0] = nums[0];
        for (int i = 1; i < length; i++) {
            lmin[i] = Math.min(nums[i], lmin[i - 1]);
        }
        int[] rmax = new int[length];
        rmax[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rmax[i] = Math.max(nums[i], rmax[i + 1]);
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > lmin[i - 1] && nums[i] < rmax[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
     * <p>
     * 实部 是一个整数，取值范围是 [-100, 100]
     * 虚部 也是一个整数，取值范围是 [-100, 100]
     * i2 == -1
     * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：num1 = "1+1i", num2 = "1+1i"
     * 输出："0+2i"
     * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
     * 示例 2：
     * <p>
     * 输入：num1 = "1+-1i", num2 = "1+-1i"
     * 输出："0+-2i"
     * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String complexNumberMultiply(String num1, String num2) {
        String[] splitNum1 = num1.split("\\+|i");
        String[] splitNum2 = num2.split("\\+|i");
        int a1 = Integer.parseInt(splitNum1[0]);
        int a2 = Integer.parseInt(splitNum1[1]);

        int a3 = Integer.parseInt(splitNum2[0]);
        int a4 = Integer.parseInt(splitNum2[1]);

        String format = String.format("%d+%di", (a1 * a3 - a2 * a4), (a1 * a4 + a2 * a3));
        return format;
    }


    /**
     * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: num = 100
     * 输出: "202"
     * 示例 2:
     * <p>
     * 输入: num = -7
     * 输出: "-10"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/base-7
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = num > 0 ? true : false;
        if (!flag) num = -num;
        while (num >= 7) {
            mod = num % 7;
            num = num / 7;
            sb.append(mod);
        }
        sb.append(num);
        String res = sb.reverse().toString();
        return flag ? res : "-" + res;
    }

    public boolean validUtf8(int[] data) {
        boolean flag = false;
        int start = data[0];
        String s = Integer.toBinaryString(start);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                int datum = data[i];
                String s1 = Integer.toBinaryString(datum);
                if (!s1.startsWith("10")) return false;
            } else {
                break;
            }
        }
        int datum = data[data.length - 1];
        String s1 = Integer.toUnsignedString(datum, 2);
        if (s1.startsWith("0")) {
            flag = true;
        }

        return flag;
    }

    /* public boolean winnerOfGame(String colors) {
         int length = colors.length();
         if (length <= 2)
             return false;
         int countA = 0;
         int countB = 0;
         for (int i = 1; i < length - 1; i++) {
             if (colors.charAt(i) == 'A') {
                 if (colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A')
                     countA++;
             } else {
                 if (colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B')
                     countB++;
             }
         }
         return countA > countB;
     }
 */
    public boolean winnerOfGame(String colors) {
        int length = colors.length();
        if (length <= 2) return false;
        int count = 0;
        for (int i = 1; i < length - 1; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                count++;
            } else if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                count--;
            }
        }
        return count > 0;
    }


    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String str = String.valueOf(i);
            if (str.contains("0")) continue;
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                if (i % (str.charAt(j) - '0') != 0) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) list.add(i);
        }
        return list;
    }

    public String toGoatLatin(String sentence) {
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder("maa");
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');
        characters.add('A');
        characters.add('E');
        characters.add('I');
        characters.add('O');
        characters.add('U');

        for (int i = 0; i < strings.length; i++) {
            String string = sb.toString();
            sb.append('a');
            if (characters.contains(strings[i].charAt(0))) {
                strings[i] = strings[i] + string;
            } else {
                strings[i] = strings[i].substring(1) + strings[i].charAt(0) + string;
            }
        }
        String StringJoiner = String.join(" ", strings);
        return StringJoiner;
    }

    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] res = new int[length];
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == c) {
                integers.add(i);
            }
        }
        for (int i = 0; i < length; i++) {
            Integer ceiling = integers.ceiling(i);
            Integer floor = integers.floor(i);
            if (floor == null) {
                res[i] = Math.abs(i - integers.first());
            } else {

                res[i] = Math.min(Math.abs(i - floor), ceiling == null ? Math.abs(i - integers.last()) : Math.abs(i - ceiling));
            }
        }
        return res;
    }


    /**
     * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
     * <p>
     * 返回满足此条件的 任一数组 作为答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,1,2,4]
     * 输出：[2,4,3,1]
     * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < even.size(); i++) {
            res[i] = even.get(i);
        }
        for (int i = 0; i < odd.size(); i++) {
            res[i + even.size()] = odd.get(i);
        }
        return res;
    }

    /**
     * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
     * <p>
     * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：accounts = [[1,2,3],[3,2,1]]
     * 输出：6
     * 解释：
     * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
     * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
     * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
     * 示例 2：
     * <p>
     * 输入：accounts = [[1,5],[7,3],[3,5]]
     * 输出：10
     * 解释：
     * 第 1 位客户的资产总量 = 6
     * 第 2 位客户的资产总量 = 10
     * 第 3 位客户的资产总量 = 8
     * 第 2 位客户是最富有的，资产总量是 10
     * 示例 3：
     * <p>
     * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
     * 输出：17
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/richest-customer-wealth
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            max = Math.max(max, Arrays.stream(account).sum());
        }
        return max;
    }

    /**
     * 给你一个整数数组 nums，和一个整数 k 。
     * <p>
     * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
     * <p>
     * nums 的 分数 是 nums 中最大和最小元素的差值。 
     * <p>
     * 在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1], k = 0
     * 输出：0
     * 解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
     * 示例 2：
     * <p>
     * 输入：nums = [0,10], k = 2
     * 输出：6
     * 解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
     * 示例 3：
     * <p>
     * 输入：nums = [1,3,6], k = 3
     * 输出：0
     * 解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/smallest-range-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestRangeI(int[] nums, int k) {
        int length = nums.length;
        int sum = Arrays.stream(nums).sum();
        int avg = sum / length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > avg) {
                int tmp = nums[i] - avg;
                int num = Math.min(k, tmp);
                nums[i] = nums[i] - num;
            } else if (nums[i] < avg) {
                int tmp = avg - nums[i];
                int num = Math.min(k, tmp);
                nums[i] = nums[i] + num;
            }
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return max - min;


    }

    public int minDeletionSize(String[] strs) {
        int res = 0;
        String str = strs[0];
        Out:
        for (int i = 0; i < str.length(); i++) {
            char pre = str.charAt(i);
            for (String s : strs) {
                if (s.charAt(i) < pre) {
                    res++;
                    continue Out;
                }
                pre = s.charAt(i);
            }
        }
        return res;
    }

    public boolean oneEditAway(String first, String second) {
        int length1 = first.length();
        int length2 = second.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int num1 = dp[i - 1][j - 1] + 1;
                    int num2 = dp[i][j - 1] + 1;
                    int num3 = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(num1, Math.min(num2, num3));
                }
            }
        }
        return dp[length1][length2] > 1 ? false : true;


    }


    /**
     * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
     * <p>
     * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
     * <p>
     * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
     * <p>
     * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：maxChoosableInteger = 10, desiredTotal = 11
     * 输出：false
     * 解释：
     * 无论第一个玩家选择哪个整数，他都会失败。
     * 第一个玩家可以选择从 1 到 10 的整数。
     * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
     * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
     * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
     * 示例 2:
     * <p>
     * 输入：maxChoosableInteger = 10, desiredTotal = 0
     * 输出：true
     * 示例 3:
     * <p>
     * 输入：maxChoosableInteger = 10, desiredTotal = 1
     * 输出：true
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/can-i-win
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    // TODO不会做
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int index = 0;
        for (int i = maxChoosableInteger; i >= 1; i++) {
            if ((index & 1) == 0) {
                if (i >= desiredTotal) return true;
                else {
                    desiredTotal -= i;
                }
            } else {
                if (i >= desiredTotal) return false;
                else desiredTotal -= i;
            }
            index++;
        }
        return false;

    }

    public boolean isUnivalTree(TreeNode root) {
        int pre = root.val;
        return isUnivalTree(root, pre);
    }

    public boolean isUnivalTree(TreeNode root, Integer pre) {
        if (root != null) {
            int cnt = root.val;
            if (pre.equals(cnt)) {
                return isUnivalTree(root.left, pre) && isUnivalTree(root.right, pre);
            } else return false;
        }
        return true;
    }

    /**
     * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
     * <p>
     * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
     * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: p = "a"
     * 输出: 1
     * 解释: 字符串 s 中只有一个"a"子字符。
     * 示例 2:
     * <p>
     * 输入: p = "cac"
     * 输出: 2
     * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
     * 示例 3:
     * <p>
     * 输入: p = "zab"
     * 输出: 6
     * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param p
     * @return
     */
    /*public int findSubstringInWraproundString(String p) {
        int length = p.length();
        // 定义dp为为i结尾的最长字串的个数
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            int cntIndex = p.charAt(i) - 'a';
            int preIndex = p.charAt(i - 1) - 'a';
            if (cntIndex == 0) {
                if (preIndex - 25 == cntIndex || preIndex + 1 == cntIndex)
                    dp[i] = dp[i - 1] + 1;
            } else {
                if (preIndex + 1 == cntIndex)
                    dp[i] = dp[i - 1] + 1;
            }
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Integer orDefault = map.getOrDefault(p.charAt(i), 0);
            int max = Math.max(orDefault, dp[i]);
            map.put(p.charAt(i), max);
        }
        return map.values().stream().collect(Collectors.summingInt(item -> item.intValue()));
    }*/
    // 改进为一次O(n)
    public int findSubstringInWraproundString(String p) {
        int length = p.length();
        int[] dp = new int[26];
        for (int i = 0; i < length; i++) {
            if (i > 0) {

            } else {

            }
        }
        return length;
    }

    /**
     * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
     * <p>
     * 示例：
     * <p>
     * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
     * 输出：1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-closest-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                if (index2 != -1) {
                    min = Math.min(Math.abs(index1 - index2), min);
                }
            } else if (word2.equals(words[i])) {
                index2 = i;
                if (index1 != -1) {
                    min = Math.min(Math.abs(index1 - index2), min);
                }
            }
        }
        return min;
    }

    /**
     * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
     * <p>
     * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
     * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
     * <p>
     * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
     * <p>
     * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * 示例 2：
     * <p>
     * 输入：s = "(()())(())(()(()))"
     * 输出："()()()()(())"
     * 解释：
     * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
     * 示例 3：
     * <p>
     * 输入：s = "()()"
     * 输出：""
     * 解释：
     * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
     * 删除每个部分中的最外层括号后得到 "" + "" = ""。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/remove-outermost-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String removeOuterParentheses(String s) {
        int count1 = 0;
        int count2 = 0;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (count1 == count2 && count1 != 0) {
                String tmp = s.substring(start + 1, i - 1);
                sb.append(tmp);
                start = i;
                count1 = 0;
                count2 = 0;
            }
            if (s.charAt(i) == '(') count1++;
            else if (s.charAt(i) == ')') count2++;
        }
        if (count1 == count2 && count1 != 0) {
            String tmp = s.substring(start + 1, s.length() - 1);
            sb.append(tmp);
        }
        return sb.toString();
    }

    /**
     * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
     * <p>
     * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: “192.168.1.1” 、 “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1” 为无效IPv4地址。
     * <p>
     * 一个有效的IPv6地址 是一个格式为“x1:x2:x3:x4:x5:x6:x7:x8” 的IP地址，其中:
     * <p>
     * 1 <= xi.length <= 4
     * xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
     * 在 xi 中允许前导零。
     * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：queryIP = "172.16.254.1"
     * 输出："IPv4"
     * 解释：有效的 IPv4 地址，返回 "IPv4"
     * 示例 2：
     * <p>
     * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
     * 输出："IPv6"
     * 解释：有效的 IPv6 地址，返回 "IPv6"
     * 示例 3：
     * <p>
     * 输入：queryIP = "256.256.256.256"
     * 输出："Neither"
     * 解释：既不是 IPv4 地址，又不是 IPv6 地址
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-ip-address
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param queryIP
     * @return
     */
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            String[] split = queryIP.split("\\.");
            if (split.length == 4 && !queryIP.endsWith(".")) {
                for (String s : split) {
                    boolean flag = isValidIPv4Num(s);
                    if (!flag) return "Neither";
                }
                return "IPv4";
            } else {
                return "Neither";
            }
        } else {
            String[] split = queryIP.split(":");
            if (split.length == 8 && !queryIP.endsWith(":")) {
                for (String s : split) {
                    boolean flag = isValidIPv6Num(s);
                    if (!flag) return "Neither";
                }
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }

    Set<Character> set = new HashSet<>(Set.of('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'));

    private boolean isValidIPv6Num(String s) {
        if (s.length() <= 4 && s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    char c = s.charAt(i);
                    if (!set.contains(c)) return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidIPv4Num(String s) {
        if (s.length() == 0 || s.length() > 3) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        int tmp = Integer.parseInt(s);
        if (tmp >= 0 && tmp <= 255) {
            if (tmp == 0 && s.length() > 1) return false;
            if (s.startsWith("0") && tmp != 0) return false;
            else return true;
        }
        return false;
    }

    /**
     * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
     *
     *  
     *
     * 示例 1:
     *
     * 输入: n = 5
     * 输出: 2
     * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
     * 示例 2:
     *
     * 输入: n = 9
     * 输出: 3
     * 解释: 9 = 4 + 5 = 2 + 3 + 4
     * 示例 3:
     *
     * 输入: n = 15
     * 输出: 4
     * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/consecutive-numbers-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    /**
     * 思路：高斯加法
     * 首项用a1表示，步长用k表示，n为目标数字
     * 则 (2*a1+k-1)*k/2 =n
     * （2*a1+k-1)*k = 2*n 因为a1>=1所以说2*a1+k-1>k ==> k<= sqrt(n)
     * 2*a1=2*n/k-k+1 所以说首相可以 通过步长推出来，2*n%k ==0,又因为2*a1是偶数，所以说 2*n/k-k+1是偶数
     *
     * @param n
     * @return
     */
    public int consecutiveNumbersSum(int n) {
        long total = 2 * n;
        long length = (long) Math.sqrt(total);
        int count = 0;
        for (long i = 1; i <= length; i++) {
            if (total % i == 0 && ((total / i - i + 1) & 1) == 0) count++;
        }
        return count;
    }

    /**
     * 计算出可能的长度为sqrt(2n)见上面
     * 高斯加法为 Sn= （2首相+步长-1）*步长/2，
     * 枚举每个步长，对于每个长度枚举首项，使用二分查找能否找到相等的点
     * <p>
     * 作者：Underdog_RJ
     * 链接：https://leetcode.cn/problems/consecutive-numbers-sum/solution/gao-si-jia-fa-by-underdog_rj-0tsi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int consecutiveNumbersSum1(int n) {
        long total = 2 * n;
        long length = (long) Math.sqrt(total);
        int count = 0;
        for (long i = 1; i <= length; i++) {
            long left = 1, right = 1000000000;
            // 寻找步长i
            while (left <= right) {
                long mid = (left + right) / 2;
                // 步长
                // 高斯加法
                long cntTotal = (2l * mid + i - 1) * i / 2;
                if (cntTotal > n) {
                    right = mid - 1;
                } else if (cntTotal < n) {
                    left = mid + 1;
                } else {
                    System.out.println(mid);
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
     * <p>
     * 例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
     * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
     * <p>
     * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
     * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
     * <p>
     * 例如 m.y+name@email.com 将转发到 my@email.com。
     * 可以同时使用这两个规则。
     * <p>
     * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
     * 输出：2
     * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
     * 示例 2：
     * <p>
     * 输入：emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
     * 输出：3
     * <p>
     * 提示：
     * <p>
     * 1 <= emails.length <= 100
     * 1 <= emails[i].length <= 100
     * emails[i] 由小写英文字母、'+'、'.' 和 '@' 组成
     * 每个 emails[i] 都包含有且仅有一个 '@' 字符
     * 所有本地名和域名都不为空
     * 本地名不会以 '+' 字符作为开头
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/unique-email-addresses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> strings = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String tmp = split[0];
            int i = tmp.indexOf('+');
            if (i != -1) {
                tmp = tmp.substring(0, i).replace(".", "");
                strings.add(tmp + "@" + split[1]);
            } else {
                tmp = tmp.replace(".", "");
                strings.add(tmp + "@" + split[1]);
            }
        }

        return strings.size();
    }

    public boolean isBoomerang(int[][] points) {
        Set<Double> set = new HashSet<>();
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            strings.add(points[i][0] + "-" + points[i][1]);
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                if (points[j][0] - points[i][0] == 0) {
                    set.add(0.0);
                    continue;
                }
                set.add((double) ((points[j][1] - points[i][1]) / (points[j][0] - points[i][0])));
            }
        }
        return set.size() >= 2 ? strings.size() == 3 ? true : false : false;
    }

    /**
     * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
     * <p>
     * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
     * <p>
     * 返回使 s 单调递增的最小翻转次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "00110"
     * 输出：1
     * 解释：翻转最后一位得到 00111.
     * 示例 2：
     * <p>
     * 输入：s = "010110"
     * 输出：2
     * 解释：翻转得到 011111，或者是 000111。
     * 示例 3：
     * <p>
     * 输入：s = "00011000"
     * 输出：2
     * 解释：翻转得到 00000000。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 105
     * s[i] 为 '0' 或 '1'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/flip-string-to-monotone-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    /**
     * 非递减序列：有三种情况
     * 1.全部为0 ===》》》把1转换为0
     * 2.全部为1 ===》》》 把0转为1
     * 3.有0有1 ==》》》枚举每个以i开始的点，判断最小
     * 第一次模拟全为1，(11111) 也就是count0d的数量
     * 以0开始后面全部为1  （01111）如果当前为0则count0--否则count0++(因为此时为1，需要反转为0)
     * 以1开始后面全部为1  （00111）如果当前为0则count0--否则count0++
     * 以2开始后面全部为1  （00011）如果当前为0则count0--否则count0++
     *求出以上最小的值
     * @param s
     * @return
     */
    /**
     * 前缀和
     *
     * @param s
     * @return
     */
    /*public int minFlipsMonoIncr(String s) {
        int count0 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            }
        }
        int min = count0;
        // 以i开始的后面全是1的个数
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0--;
            } else {
                count0++;
            }
            min = Math.min(min, count0);
        }
        return min;
    }*/


    /**
     * 每个字符有两种可能0/1所以说，dp有两种状态
     * 1.定义dp[i][0]为以i结束，并且全部都是0的长度的最少修改次数
     * 定义dp[i][1]为以i结束，最后一位是1的递增的长度最少修改次数
     * 2.递推公式
     * dp[i][0] = dp[i-1][0] + s.chatAt(i)=='0'?0:1; 结尾为0前面必须都是0
     * dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + s.chatAt(i)=='0'?1:0; 结尾为0前面可以是0或者1两者取最小值
     * 3.初始化
     * 看第一位
     * 4.遍历顺序，dp[i]跟dp[i-1]有关正序遍历
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        int length = s.length();
        int[][] dp = new int[length][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0] + s.charAt(i) - '0';
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[length - 1][0], dp[length - 1][1]);

    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Character> map = new HashMap<>();
            if (words[i].length() != pattern.length()) continue;
            boolean flag = false;
            for (int u = 0; u < pattern.length(); u++) {
                if (map.containsKey(pattern.charAt(u))) {
                    Character character = map.get(pattern.charAt(u));
                    if (character != words[i].charAt(u)) {
                        flag = true;
                        break;
                    }
                } else {
                    Set<Character> collect = map.values().stream().collect(Collectors.toSet());
                    if (!collect.contains(words[i].charAt(u))) {
                        map.put(pattern.charAt(u), words[i].charAt(u));
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                list.add(words[i]);
            }
        }
        return list;
    }


    /**
     * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
     * <p>
     * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
     * <p>
     * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
     * <p>
     * 返回满足 heights[i] != expected[i] 的 下标数量 。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：heights = [1,1,4,2,1,3]
     * 输出：3
     * 解释：
     * 高度：[1,1,4,2,1,3]
     * 预期：[1,1,1,2,3,4]
     * 下标 2 、4 、5 处的学生高度不匹配。
     * 示例 2：
     * <p>
     * 输入：heights = [5,1,2,3,4]
     * 输出：5
     * 解释：
     * 高度：[5,1,2,3,4]
     * 预期：[1,2,3,4,5]
     * 所有下标的对应学生高度都不匹配。
     * 示例 3：
     * <p>
     * 输入：heights = [1,2,3,4,5]
     * 输出：0
     * 解释：
     * 高度：[1,2,3,4,5]
     * 预期：[1,2,3,4,5]
     * 所有下标的对应学生高度都匹配。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/height-checker
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] ints = new int[101];
        for (int height : heights) {
            ints[height]++;
        }
        int res = 0;
        int index = 0;
        for (int i = 1; i < ints.length; i++) {
            while (ints[i]-- > 0) {
                if (heights[index++] != i) {
                    res++;
                }
            }
        }
        return res;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = left + right >> 1;
            int count = 0;
            int leftIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] - nums[leftIndex] > mid) {
                    leftIndex++;
                }
                count += i - leftIndex;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 给定一个整数数组和一个整数 k，你需要在数组里找到 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
     * <p>
     * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
     * <p>
     * 0 <= i < j < nums.length
     * |nums[i] - nums[j]| == k
     * 注意，|val| 表示 val 的绝对值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3, 1, 4, 1, 5], k = 2
     * 输出：2
     * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * 示例 2：
     * <p>
     * 输入：nums = [1, 2, 3, 4, 5], k = 1
     * 输出：4
     * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 示例 3：
     * <p>
     * 输入：nums = [1, 3, 1, 5, 4], k = 0
     * 输出：1
     * 解释：数组中只有一个 0-diff 数对，(1, 1)。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/k-diff-pairs-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    /**
     * hash+二分
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (!map.containsKey(nums[i])) {
                int left = i + 1, right = nums.length - 1;
                int target = nums[i] + k;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (nums[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (left < nums.length && target == nums[left]) {
                    map.put(nums[i], target);
                }
            }

        }
        return map.size();
    }

    /**
     * hash
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs1(int[] nums, int k) {
        Set<Integer> exists = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            if (exists.contains(num - k)) {
                res.add(num - k);
            }
            if (exists.contains(num + k)) {
                res.add(num);
            }
            exists.add(num);
        }
        return res.size();
    }

    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int quick = 0, count = 0;
        for (int slow = 0; slow < nums.length; slow++) {
            if (slow == 0 || nums[slow] != nums[slow - 1]) {
                while (quick < nums.length && (nums[quick] < nums[slow] + k || slow >= quick)) {
                    quick++;
                }
                if (quick < nums.length && nums[slow] + k == nums[quick]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairs3(int[] nums, int k) {
        RangeFreqQuery freqQuery = new RangeFreqQuery(nums);
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i] - k;
            int query1 = freqQuery.query(i + 1, nums.length, num1);
            if (query1 > 0) {
                res.add(num1);
            }
            int num2 = nums[i] + k;
            int query2 = freqQuery.query(i + 1, nums.length, num2);
            if (query2 > 0) {
                res.add(nums[i]);
            }
        }
        return res.size();
    }

    public void duplicateZeros(int[] arr) {
        int[] clone = arr.clone();
        int slow = 0, quick = 0, length = arr.length;
        while (slow < length && quick < length) {
            if (clone[slow] != 0) {
                arr[quick] = clone[slow];
            } else {
                arr[quick] = 0;
                ++quick;
                if (quick < length) arr[quick] = 0;
            }
            slow++;
            quick++;
        }
    }

    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int m = str.length();
            if (m < max) continue;
            boolean flag = false;
            for (int j = 0; j < strs.length && !flag; j++) {
                if (i == j) continue;
                String str1 = strs[j];
                int common = isSubseq(str, str1); // 求的是最长公共子序列，但是复杂度较高，可以转换为是否是子序列，转换为双指针
                if (common == m) flag = true;
            }
            if (!flag) max = Math.max(max, m);

        }
        return max == 0 ? -1 : max;
    }

    private int isSubseq(String str, String str1) {
        int index = 0;
        int index1 = 0;
        while (index < str.length() && index1 < str1.length()) {
            if (str.charAt(index) == str1.charAt(index1)) index++;
            index1++;
        }
        return index;
    }

    private int LCS(String str, String str1) {
        int[][] dp = new int[str.length() + 1][str1.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                if (str.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[str.length()][str1.length()];
    }

    /**
     * TODO 完善：三向切分。索引转换
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int length = nums.length;
        int middle = (length & 1) == 0 ? (length >> 1) : ((length + 1) >> 1);
        int l = 0;
        int r = middle + 1;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = clone[l++];
            } else {
                nums[i] = clone[r++];
            }
        }
    }

    public int numPrimeArrangements(int n) {
        if (n == 1) return 1;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = isZhiShu(i);
            if (flag) count++;
        }
        long num1 = jiecheng(n - count);
        long num2 = jiecheng(count);
        return (int) ((num1 * num2) % 1000000007);
    }

    private long jiecheng(long n) {
        if (n == 1) return 1;
        return ((n * jiecheng(n - 1))) % 1000000007;
    }

    private boolean isZhiShu(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int cnt = arr[i];
            int pre = arr[i - 1];
            int tmp = Math.abs(cnt - pre);
            List<Integer> list = new ArrayList<>(List.of(pre, cnt));
            if (tmp == min) {
                res.add(list);
            } else if (tmp < min) {
                res.clear();
                min = tmp;
                res.add(list);
            }
        }
        return res;
    }


    private StringBuilder sbNextGreater = new StringBuilder();
    private int minNext = Integer.MAX_VALUE;
    private boolean[] flagNextGreater;

    public int nextGreaterElement(int n) {
        if (n >= 1 && n <= 9) return -1;
        char[] chars = String.valueOf(n).toCharArray();
        flagNextGreater = new boolean[chars.length];
        bkNextGreaterElement(chars, n);
        if (minNext == n) return -1;
        return minNext;
    }

    private void bkNextGreaterElement(char[] chars, int n) {
        if (sbNextGreater.length() == chars.length) {
            long i = Long.parseLong(sbNextGreater.toString());
            if (i > Integer.MAX_VALUE) return;
            if (i > n) {
                minNext = Math.min(minNext, (int) i);
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (flagNextGreater[i]) continue;
            int origin = Integer.parseInt(new String(chars, 0, sbNextGreater.length() + 1));
            long cnt = Long.parseLong(sbNextGreater.toString() + chars[i]);
            if (origin > cnt) {
                continue;
            }
            flagNextGreater[i] = true;
            sbNextGreater.append(chars[i]);
            bkNextGreaterElement(chars, n);
            flagNextGreater[i] = false;
            sbNextGreater.deleteCharAt(sbNextGreater.length() - 1);
        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        return s.equals(s1);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        map.forEach((k, list) -> {
            for (int i = 0; i < list.size(); i += k) {
                ans.add(list.subList(i, i + k));
            }
        });
        return ans;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] diff = new int[100000];
        for (int i = 0; i < startTime.length; i++) {
            diff[startTime[i]]++;
            diff[endTime[i] + 1]--;
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff[queryTime];
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i : arr) {
            int abs = Math.abs(i - x);
            List<Integer> orDefault = map.getOrDefault(abs, new ArrayList<>());
            orDefault.add(i);
            map.put(abs, orDefault);
        }
        while (k > 0) {
            Map.Entry<Integer, List<Integer>> integerListEntry = map.pollFirstEntry();
            List<Integer> value = integerListEntry.getValue();
            int size = value.size();
            if (k >= size) {
                res.addAll(value);
                k -= size;
            } else {
                for (int i = 0; i < k; i++) {
                    res.add(value.get(i));
                }
                k = 0;
            }
        }
        Collections.sort(res);
        return res;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (asteroids[i] < 0) {
                boolean flag = false;
                while (stack.size() != 0) {
                    if (stack.peek() < -asteroids[i]) {
                        stack.pop();
                    } else if (stack.peek() == -asteroids[i]) {
                        stack.pop();
                        flag = true;
                        break;
                    } else {
                        break;
                    }
                }
                if (stack.size() == 0 && !flag) {
                    list.add(asteroids[i]);
                }
            }
        }
        list.addAll(stack);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int left = 0, n = popped.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < popped.length; i++) {
            while (!stack.isEmpty() && left < n && stack.peek().equals(popped[left])) {
                stack.pop();
                left++;
            }
            stack.push(pushed[i]);
        }
        while (!stack.isEmpty() && left < n && stack.peek().equals(popped[left])) {
            stack.pop();
            left++;
        }
        if (stack.isEmpty() && left == n) return true;
        else return false;
    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        int n = prices.length;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                res[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            res[index] = prices[index];
        }
        return res;
    }

    private Integer maxLUP = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfsLUP(root, root.val);
        return maxLUP;
    }

    private int dfsLUP(TreeNode root, int val) {
        if (root == null) return 0;
        int left = dfsLUP(root.left, root.val);
        int right = dfsLUP(root.right, root.val);
        maxLUP = Math.max(maxLUP, left + right);
        if (root.val == val) return Math.max(left, right) + 1;
        return 0;
    }

    public int subsetXORSum(int[] nums) {
        int res = 0, n = nums.length, length = 1 << n;
        for (int i = 0; i < length; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) >= 1) {
                    tmp ^= nums[j];
                }
            }
            res += tmp;
        }
        return res;
    }

    public int findLongestChain1(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findLongestChain2(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int[] lisNum = new int[n];
        int cntIndex = 0;
        lisNum[cntIndex++] = pairs[0][1];
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = pairs[i][1];
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] >= pairs[i][0]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lisNum[left] = Math.min(lisNum[left], pairs[i][1]);
            }
            max = Math.max(max, cntIndex);
        }
        return max;
    }

    public int findLongestChain(int[][] pairs) {
        int res = 0, max = Integer.MIN_VALUE;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int[] pair : pairs) {
            if (pair[0] > max) {
                max = pair[1];
                res++;
            }
        }
        return res;
    }

    private Map<String, TreeNode> memoFDLS = new HashMap<>();
    private Set<TreeNode> setFDLS = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfsFDLS(root);
        return new ArrayList<>(setFDLS);
    }

    private String dfsFDLS(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        String left = dfsFDLS(root.left);
        sb.append(left + ")(");
        String right = dfsFDLS(root.right);
        sb.append(right + ")");
        if (memoFDLS.containsKey(sb.toString())) {
            setFDLS.add(memoFDLS.get(sb.toString()));
        } else {
            memoFDLS.put(sb.toString(), root);
        }
        return sb.toString();
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }


}
