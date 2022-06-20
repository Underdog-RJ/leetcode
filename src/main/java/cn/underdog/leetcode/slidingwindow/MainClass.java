package cn.underdog.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * @author underdog_rj
 * @date2022/3/2914:37
 */
public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.maxConsecutiveAnswers("TTFTTFTT", 1);
//        mainClass.maxConsecutiveAnswers("TTFF", 2);
//        mainClass.minWindow("ADOBECODEBANC", "ABC");
//        mainClass.findAnagrams("cbaebabacd", "abc");
        mainClass.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }


    /**
     * 原始思路：用前缀和 后缀和，统计每个位置的前面和后面的连续情况，发现，需要改变前缀和后缀数组，思路错误
     * 遇到先后都会变的情况，不能一开始两种情况都考虑，这样一定会照顾不周，每个情况应单独考虑
     * 如本题中，我们可以考虑，枚举每一个右端点的情况，统计当前区间内另外一个数量记为sum，
     * 如果当前区间内的sum<=k右端点继续向右移动，
     * 如果sum>k则表明当前区间不满足要求了，左指针向右移动
     * <p>
     * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
     * <p>
     * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
     * <p>
     * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
     * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：answerKey = "TTFF", k = 2
     * 输出：4
     * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
     * 总共有四个连续的 'T' 。
     * 示例 2：
     * <p>
     * 输入：answerKey = "TFFT", k = 1
     * 输出：3
     * 解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
     * 或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
     * 两种情况下，都有三个连续的 'F' 。
     * 示例 3：
     * <p>
     * 输入：answerKey = "TTFTTFTT", k = 1
     * 输出：5
     * 解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
     * 或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
     * 两种情况下，都有五个连续的 'T' 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveAnswers(answerKey, k, 'T'), maxConsecutiveAnswers(answerKey, k, 'F'));
    }

    public int maxConsecutiveAnswers(String answerKey, int k, Character ch) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while (right < answerKey.length()) {
            // 每次把left转移到最合适的位置
            if (ch != answerKey.charAt(right)) {
                sum++;
                while (sum > k) {
                    if (ch != answerKey.charAt(left++))
                        sum--;
                }
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }

    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：[1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        return longestOnes(nums, k, 1);
    }

    public int longestOnes(int[] nums, int k, int ch) {

        int left = 0;
        int right = 0;
        int max = 0;
        int length = nums.length;
        int sum = 0;
        while (right < length) {
            if (nums[right] != ch) {
                sum++;
                while (sum > k) {
                    if (nums[left++] != ch)
                        sum--;
                }

            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     *  
     * <p>
     * 注意：
     * <p>
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3:
     * <p>
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0, start = 0;
        int length = s.length();
        int resLength = Integer.MAX_VALUE;
        while (right < length) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(needs.get(c)))
                    valid++;
            }
            // 判断左窗口是否需要收缩
            while (valid == needs.size()) {
                // 在这里更新最小覆盖字串
                if (right - left < resLength) {
                    start = left;
                    resLength = right - left;
                }
                char cntLeft = s.charAt(left);
                left++;
                if (needs.containsKey(cntLeft)) {
                    if (needs.get(cntLeft).equals(windows.get(cntLeft))) {
                        valid--;
                    }
                    windows.put(cntLeft, windows.getOrDefault(cntLeft, 0) - 1);
                }
            }
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(start, start + resLength);
    }

    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * <p>
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                if (right - left == s1.length())
                    return true;
                char cnt = s2.charAt(left);
                left++;
                if (needs.containsKey(cnt)) {
                    if (needs.get(cnt).equals(windows.get(cnt))) {
                        valid--;
                    }
                    windows.put(cnt, windows.getOrDefault(cnt, 0) - 1);
                }
            }
        }
        return false;

    }

    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                if (right - left == p.length()) {
                    list.add(left);
                }
                char cnt = s.charAt(left);
                left++;
                if (needs.containsKey(cnt)) {
                    if (needs.get(cnt).equals(windows.get(cnt))) {
                        valid--;
                    }
                    windows.put(cnt, windows.getOrDefault(cnt, 0) - 1);
                }
            }
        }
        return list;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        if (s.equals(""))
            return 0;
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否需要收缩
            while (window.get(c) > 1) {
                char cnt = s.charAt(left);
                left++;
                window.put(cnt, window.getOrDefault(cnt, 0) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }


    /**
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * <p>
     * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * <p>
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 105
     * s 仅由大写英文字母组成
     * 0 <= k <= s.length
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        return 0;
    }


    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            cnt += nums[right];
            right++;
            while (cnt >= target) {
                min = Math.min(min, right - left);
                cnt -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}