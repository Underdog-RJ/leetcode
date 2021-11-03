package cn.underdog.mediumAlgorithm;


import java.util.*;

public class day_05 {
    public static void main(String[] args) {
//        findAnagrams("abab","ab");
       /* List<Integer> anagrams = findAnagrams("baa", "aa");
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }*/
//        numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 18);
//        numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
//        minSubArrayLen(7, (new int[]{2, 3, 1, 2, 4, 3}));
        boolean happy = isHappy(19);
        System.out.println(happy);
    }

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *  示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
   /* public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length())
            return list;
        int sLength = s.length();
        int pLength = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pLength; i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < sLength; i++) {
            int window = i + pLength;
            if (window <= sLength) {
                String substring = s.substring(i, window);
                Map<Character, Integer> tempMap = new HashMap<>();
                for (int j = 0; j < substring.length(); j++) {
                    tempMap.put(substring.charAt(j), tempMap.getOrDefault(substring.charAt(j), 0) + 1);
                }
                if (tempMap.equals(map)) {
                    list.add(i);
                }
            } else
                break;
        }
        return list;
    }*/
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n)
            return list;
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];

        for (int i = 0; i < n; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCnt, sCnt)) {
            list.add(0);
        }
        for (int i = n; i < m; i++) {
            sCnt[s.charAt(i - n) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if (Arrays.equals(pCnt, sCnt)) {
                list.add(i - n + 1);
            }
        }

        return list;
    }

    /**
     * 双指针
     * right表示当前数组中的位置，
     * currentNum 表示当前乘积
     * 如果当前乘积大于等于k则需要左指针移动到等级小于K位置
     * ans= right-left +1  代表有几个数的乘积小于k
     *
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int currentNum = 1;
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            currentNum *= nums[right];
            while (currentNum >= k) currentNum /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * <p>
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int ans = Integer.MAX_VALUE;
        int currentNum = 0;

        for (int right = 0; right < nums.length; right++) {
            currentNum += nums[right];
            while (currentNum >= target) {
                int temp = right - left + 1;
                if (ans > temp) {
                    ans = temp;
                }
                currentNum -= nums[left++];
            }
        }

        return Objects.equals(ans, Integer.MAX_VALUE) ? 0 : ans;
    }

    static List<Integer> sum = new ArrayList<>();
    public static boolean isHappy(int n) {
        if (n == 1)
            return true;
        if (sum.contains(n))
            return false;
        String str = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res += Math.pow(Integer.parseInt(str.charAt(i) + ""), 2);
        }
        sum.add(n);
        return isHappy(res);
    }




}
