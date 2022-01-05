package cn.underdog.MainClass;

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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
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
        mainClass.modifyString("???");
//        System.out.println((int) 'a');
//        System.out.println((int) 'z');
    }

    public boolean validTicTacToe(String[] board) {
        // 判断对角线
        StringBuilder sb = new StringBuilder();
        sb.append(board[0].charAt(0));
        sb.append(board[1].charAt(1));
        sb.append(board[2].charAt(2));
        String s1 = sb.toString();
        if (s1.equals("XXX") || s1.equals("OOO"))
            return false;
        sb = new StringBuilder();
        sb.append(board[0].charAt(2));
        sb.append(board[1].charAt(1));
        sb.append(board[2].charAt(0));
        String s2 = sb.toString();
        if (s2.equals("XXX") || s2.equals("OOO"))
            return false;
        // 每一行
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("XXX") || board[i].equals("OOO"))
                return false;
        }
        // 每一列
        for (int i = 0; i < 3; i++) {
            String s = board[0].charAt(i) + "" + board[1].charAt(i) + "" + board[2].charAt(i);
            if (s.equals("XXX") || s.equals("OOO"))
                return false;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i].charAt(j) == 'X')
                    num1++;
                else if (board[i].charAt(j) == 'O')
                    num2++;
            }
        }
        if (num1 == 1 && num2 == 0)
            return true;
        if (num1 == num2)
            return true;
        else
            return false;

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
                if (s.charAt(j) == '1')
                    res++;
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
        if (numBottles < numExchange)
            return numBottles;
        if (numBottles == numExchange)
            return numBottles + 1;
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
                    if (i > 0 && board[i - 1][j] == 'X')
                        continue;
                    if (j > 0 && board[i][j - 1] == 'X')
                        continue;

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
        if (" ".equals(b) || b.equals(null))
            return 0;
        // 首先判断b中是否存在a中不存在的Chartacter
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();
        for (int i = 0; i < a.length(); i++)
            setA.add(a.charAt(i));
        for (int i = 0; i < b.length(); i++)
            setB.add(b.charAt(i));
        Iterator<Character> iterator = setB.iterator();
        while (iterator.hasNext()) {
            if (!setA.contains(iterator.next()))
                return -1;
        }
        // 接着每次拼接a并且res++；用indexOf检测是否存在
        // 跳出循环的条件为res执行了三次并且当前累加的长度大于b长度的三倍，因为是字串，所以拼接三次一定可以找出字串。
        StringBuilder sb = new StringBuilder(a);
        int bLength = b.length();
        int res = 1;
        while (true) {
            String s = sb.toString();
            if (res > 3 && s.length() > bLength * 3)
                return -1;
            if (s.indexOf(b) != -1)
                return res;
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
            if (orDefault > 0)
                map.put(i + days[i], orDefault);
            // 今天能否吃苹果
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(i + 1);
            // 不能直接返回
            if (entry == null)
                continue;
            res++;
            Integer integer = entry.getKey();
            Integer value = map.get(integer);
            // 今天吃的
            // 如果剩下一个直接移除
            if (value <= 1)
                map.remove(integer);
                // 如果大于则更新
            else
                map.put(integer, --value);
        }
        while (true) {
            i++;
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(i);
            if (entry == null)
                break;
            res++;
            Integer value = entry.getValue();
            if (value == 1)
                map.remove(entry.getKey());
            else
                map.put(entry.getKey(), --value);
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
                if (ages[j] <= 0.5 * ages[i] + 7)
                    break;
                if (ages[j] > ages[i])
                    break;
                if (ages[j] > 100 && ages[i] < 100)
                    break;
                if (ages[i] == ages[j])
                    res += 2;
                else
                    res++;
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
            if (age < 15)
                continue;
            while (ages[left] <= 0.5 * age + 7)
                ++left;
            while (right + 1 < ages.length && ages[right + 1] < age)
                ++right;
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
        if (length != total)
            return new int[0][];
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
            if (k % 2 == 0)
                a1 += step;
                // 反向
            else {
                // 反向如果当前元素时奇数则删除，否则不动
                if (cnt % 2 == 1)
                    a1 += step;
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
        if (num == 1)
            return false;
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        int sum = 1;
        for (int i = 2; i * i < num; i++) {
            if (integers.contains(i))
                continue;
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
        if (hand.length % groupSize != 0)
            return false;

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
                if (!contains)
                    return false;
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
                    if ((char) head == 'c')
                        sb.setCharAt(0, 'b');
                    else if ((char) head == 'z')
                        sb.setCharAt(0, 'a');
                    else
                        sb.setCharAt(0, 'c');
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
                    if ((char) head == 'a')
                        sb.setCharAt(sb.length() - 1, 'b');
                    else if ((char) head == 'z')
                        sb.setCharAt(sb.length() - 1, 'a');
                    else
                        sb.setCharAt(sb.length() - 1, 'a');
                }
            }
        }
        for (int i = 1; i < sb.length() - 1; i++) {
            if (sb.charAt(i) != '?')
                continue;
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


}
