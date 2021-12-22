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

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.*;

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
        mainClass.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba");
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

}
