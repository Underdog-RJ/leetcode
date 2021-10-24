package cn.underdog.MainClass;


import java.util.*;

public class day_05 {
    public static void main(String[] args) {
//        findAnagrams("abab","ab");
       /* List<Integer> anagrams = findAnagrams("baa", "aa");
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }*/
        numSubarrayProductLessThanK(new int[]{10, 10, 10, 10, 10, 10}, 19);
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

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > nums[i]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                list.add(temp);
                index = i;
            } else {
                break;
            }
        }
        int[] res = new int[index + 1];
        System.arraycopy(nums, 0, res, 0, index + 1);
        // 当前窗口大小
        for (int j = 2; j <= res.length; j++) {
            boolean flag = false;
            // 遍历当前窗口的Nums数值
            for (int i = 0; i < res.length - j + 1; i++) {
                int sum = 1;
                List<Integer> temp = new ArrayList<>();
                for (int w = i; w < i + j && w < res.length; w++) {
                    sum *= res[w];
                    temp.add(res[w]);
                }
                if (sum < 0) {
                    break;
                }
                if (sum < k) {
                    flag = true;
                    list.add(temp);
                }
            }
            if (!flag)
                break;
        }
        return list.size();
    }


}
