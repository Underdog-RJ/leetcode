package cn.underdog.hashtable;


import cn.underdog.MainClass.ListNode;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
//        containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
//        canConstruct("aa", "ab");
//        System.out.println(isIsomorphic("badc", "baba"));
//        System.out.println(buddyStrings("ab", "ba"));
//        System.out.println(buddyStrings("aa", "aa"));
//        System.out.println(buddyStrings("ab", "ab"));
//        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
//        System.out.println(buddyStrings("abcd",     "badc"));
//        System.out.println(buddyStrings("abab",     "abab"));
//        System.out.println(buddyStrings("abcd",     "abcd"));
//        System.out.println(buddyStrings("abcabc", "abcabc"));
//        System.out.println(buddyStrings("abab", "baba"));
//        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog cat cat finsh"));
//        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog dog dog dog"));
        //letterCombinations("23");
//        findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
//        findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"});

       /* List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak("leetcode", list));*/
      /*  List<String> list = new ArrayList<>();
        list.add("go");
        list.add("goal");
        list.add("goals");
        list.add("special");
        System.out.println(wordBreak("goalspecial", list));*/
//        findErrorNums(new int[]{1, 2, 2, 4});
//        commonChars(new String[]{"bella","label","roller"});
//        commonChars(new String[]{"cool", "lock", "cook"});
//        longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
//        System.out.println(fourSumCount(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1}));
//        System.out.println(intToRoman(1994));
//        longestWord(new String[]{"a", "banana", "appl", "ap", "apply", "apple"});
//        System.out.println(longestWord(new String[]{"a", "ba", "ban", "b", "banana", "appl", "ap", "apply", "apple"}));
//        System.out.println(longestWord(new String[]{"a"}));
        System.out.println(frequencySort("tree"));

    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,2,3]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int majorityElement(int[] nums) {
        int length = nums.length / 2;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            integerMap.put(nums[i], integerMap.getOrDefault(nums[i], 0) + 1);

        int res = -1;
        Set<Map.Entry<Integer, Integer>> entries = integerMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > length) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
       /* Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            if (entry.getValue().size() >= 2) {
                List<Integer> value = entry.getValue();
                for (int i = 0; i < value.size() - 1; i++) {
                    if (Math.abs(value.get(i) - value.get(i + 1)) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;*/
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // 如果当前滑动窗口包含当前的数字则直接返回true
            if (set.contains(nums[i])) return true;
            // 添加当前元素
            set.add(nums[i]);
            // 如果窗口大小大于k窗口向前移动一个位置
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++)
            ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        for (int i = 0; i < magazine.length(); i++)
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);

        Set<Map.Entry<Character, Integer>> entries = ransomMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer valueR = entry.getValue();
            Integer valueM = magazineMap.getOrDefault(key, 0);
            if (valueR > valueM)
                return false;
        }
        return true;
    }

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * <p>
     * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     * <p>
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/isomorphic-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        // k为s的Character v为t的Character
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 如果不包含
            if (!map.containsKey(s.charAt(i))) {
                // 但是包含t的值，直接返回false
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
        }
        return true;
    }

  /*  public static boolean buddyStrings(String s, String goal) {
        // k为s的Character v为t的Character
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), goal.charAt(i));
        Set<Map.Entry<Character, Character>> entries = map.entrySet();
        int count = 0;
        if(s.length()!=goal.length())
            return false;
        if (map.size() == 1)
            return true;
        if (s.equals(goal) && s.length() > 2)
            return map.size() == s.length() ? false : true;
        for (Map.Entry<Character, Character> entry : entries) {
            Character sKey = entry.getKey();
            Character sValue = entry.getValue();
            if (sKey == sValue)
                continue;
            if (map.containsKey(sValue)) {
                Character gValue = map.get(sValue);
                if (sKey != gValue)
                    return false;
                else
                    count++;
            } else {
                return false;
            }
        }
        return count == 2 ? true : false;
    }*/

    public static boolean buddyStrings(String s, String goal) {
        // 如果长度不相等，直接返回false
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            Set<Character> characters = new HashSet<>();
            for (int i = 0; i < s.length(); i++)
                characters.add(s.charAt(i));
            if (characters.size() == s.length())
                return false;
            else
                return true;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    int u = s.indexOf(goal.charAt(i));
                    if (u == -1)
                        return false;
                    StringBuilder sb = new StringBuilder(s);
                    sb.setCharAt(i, goal.charAt(i));
                    sb.setCharAt(u, s.charAt(i));
                    String temp = sb.toString();
                    if (temp.equals(goal))
                        return true;
                }
            }
        }
        return false;

    }

    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * <p>
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     * <p>
     * 示例1:
     * <p>
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {

        String[] tempStrs = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        if (pattern.length() != tempStrs.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(tempStrs[i]))
                    return false;
                map.put(pattern.charAt(i), tempStrs[i]);
            } else {
                String temp = map.get(pattern.charAt(i));
                if (!temp.equals(tempStrs[i]))
                    return false;
            }
        }
        return true;
    }

    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * <p>
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * <p>
     * 请找出在 t 中被添加的字母。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     * 示例 2：
     * <p>
     * 输入：s = "", t = "y"
     * 输出："y"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-difference
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        for (int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        Set<Map.Entry<Character, Integer>> entries = tMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            if (!sMap.containsKey(key)) {
                return key;
            } else {
                Integer tValue = entry.getValue();
                Integer sValue = sMap.get(key);
                if (!tValue.equals(sValue))
                    return key;
            }
        }
        return ' ';
    }

    static Map<Integer, List<String>> map = new HashMap() {
        {
            put(2, new ArrayList() {{
                add("a");
                add("b");
                add("c");
            }});
            put(3, new ArrayList() {{
                add("d");
                add("e");
                add("f");
            }});
            put(4, new ArrayList() {{
                add("g");
                add("h");
                add("i");
            }});
            put(5, new ArrayList() {{
                add("j");
                add("k");
                add("l");
            }});
            put(6, new ArrayList() {{
                add("m");
                add("n");
                add("o");
            }});
            put(7, new ArrayList() {{
                add("p");
                add("q");
                add("r");
                add("s");
            }});
            put(8, new ArrayList() {{
                add("t");
                add("u");
                add("v");
            }});
            put(9, new ArrayList() {{
                add("w");
                add("x");
                add("y");
                add("z");
            }});
        }
    };

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0)
            return ans;
        List<List<String>> tempAns = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            tempAns.add(map.get(Integer.parseInt(digits.charAt(i) + "")));
        }
        if (digits.length() == 1)
            return tempAns.get(0);
        if (digits.length() == 2) {
            List<String> list1 = tempAns.get(0);
            List<String> list2 = tempAns.get(1);
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    ans.add(list1.get(i) + "" + list2.get(j));
                }
            }
        }
        if (digits.length() == 3) {
            List<String> list1 = tempAns.get(0);
            List<String> list2 = tempAns.get(1);
            List<String> list3 = tempAns.get(2);
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    for (int u = 0; u < list3.size(); u++) {
                        ans.add(list1.get(i) + list2.get(j) + list3.get(u));
                    }
                }
            }
        }
        if (digits.length() == 4) {
            List<String> list1 = tempAns.get(0);
            List<String> list2 = tempAns.get(1);
            List<String> list3 = tempAns.get(2);
            List<String> list4 = tempAns.get(3);
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    for (int u = 0; u < list3.size(); u++) {
                        for (int t = 0; t < list4.size(); t++) {
                            ans.add(list1.get(i) + list2.get(j) + list3.get(u) + list4.get(t));
                        }
                    }
                }
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] help = new int[nums.length + 1];
        for (int num : nums) {
            help[num] = 1;
        }
        for (int i = 1; i < help.length; i++) {
            if (help[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        Map<String, List<Integer>> temp = new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            if (map2.containsKey(key)) {
                Integer integer = map2.get(key);
                List<Integer> tempList = new ArrayList<>();
                tempList.add(entry.getValue());
                tempList.add(integer);
                temp.put(key, tempList);
            }
        }
        List<String> resTemp = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Set<Map.Entry<String, List<Integer>>> entries1 = temp.entrySet();
        for (Map.Entry<String, List<Integer>> stringListEntry : entries1) {
            List<Integer> value = stringListEntry.getValue();
            Integer collect = value.stream().collect(Collectors.summingInt(item -> item.intValue()));
            if (collect < min) {
                resTemp.clear();
                resTemp.add(stringListEntry.getKey());
                min = collect;
            } else if (collect == min) {
                resTemp.add(stringListEntry.getKey());
            }
        }
        String[] ans = new String[resTemp.size()];
        for (int i = 0; i < resTemp.size(); i++) {
            ans[i] = resTemp.get(i);
        }
        return ans;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (flag[j] && wordDict.contains(s.substring(j, i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[length];
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> list = new HashSet<>();
        int sum = 0;
        int sumL = 0;
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if (list.contains(nums[i - 1]))
                res[0] = nums[i - 1];
            else {
                list.add(nums[i - 1]);
                sumL += nums[i - 1];
            }
            sum += i;
        }
        res[1] = sum - sumL;
        return res;
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer integer : row) {
            int temp = matrix[integer].length;
            for (int i = 0; i < temp; i++) {
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : col) {
            int length = matrix.length;
            for (int i = 0; i < length; i++) {
                matrix[i][integer] = 0;
            }
        }

    }

    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> resMap = new HashMap<>();
        String word = words[0];
        for (int i = 0; i < word.length(); i++)
            resMap.put(word.charAt(i), resMap.getOrDefault(word.charAt(i), 0) + 1);
        for (int i = 1; i < words.length; i++) {
            String currentStr = words[i];
            Map<Character, Integer> currentMap = new HashMap<>();
            Map<Character, Integer> tempRes = new HashMap<>();
            for (int j = 0; j < currentStr.length(); j++)
                currentMap.put(currentStr.charAt(j), currentMap.getOrDefault(currentStr.charAt(j), 0) + 1);
            Set<Map.Entry<Character, Integer>> entries = resMap.entrySet();
            for (Map.Entry<Character, Integer> entry : entries) {
                Character key = entry.getKey();
                if (currentMap.containsKey(key))
                    tempRes.put(key, Math.min(currentMap.get(key), entry.getValue()));
            }
            resMap.clear();
            resMap = tempRes;

        }
        Set<Map.Entry<Character, Integer>> entries = resMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            for (Integer i = 0; i < value; i++)
                res.add(key + "");
        }
        return res;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        int max = 1;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int last = Integer.MIN_VALUE;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (last + 1 != next) {
                if (res > max)
                    max = res;
                res = 1;
                last = next;
            } else {
                last = next;
                res++;
            }
        }
        if (res > max)
            max = res;
        return max;
    }

    public int repeatedNTimes(int[] nums) {
        int length1 = nums.length;
        int length2 = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == length2) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    public ListNode detectCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            if (list.contains(head))
                return head;
            list.add(head);
            head = head.next;
        }
        return null;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length(); i++)
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0) + 1);
        int res = 0;
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            characters.add(jewels.charAt(i));
        }
        Iterator<Character> iterator = characters.iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            if (map.containsKey(next)) {
                res += map.get(next);
            }
        }
        return res;
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        for (int u : nums3) {
            for (int t : nums4) {
                if (map.containsKey(-(u + t))) {
                    res += map.get(-(u + t));
                }
            }
        }
        return res;
    }

    /**
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: num = 3
     * 输出: "III"
     * 示例 2:
     * <p>
     * 输入: num = 4
     * 输出: "IV"
     * 示例 3:
     * <p>
     * 输入: num = 9
     * 输出: "IX"
     * 示例 4:
     * <p>
     * 输入: num = 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     * <p>
     * 输入: num = 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900 && num < 1000) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500 && num < 900) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400 && num < 500) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100 && num < 400) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90 && num < 100) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50 && num < 90) {
                sb.append("L");
                num -= 50;
            } else if (num >= 40 && num < 50) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10 && num < 40) {
                sb.append("X");
                num -= 10;
            } else if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5 && num < 9) {
                sb.append("V");
                num -= 5;
            } else if (num == 4) {
                sb.append("IV");
                num -= 4;
            } else {
                sb.append("I");
                num -= 1;
            }
        }
        return sb.toString();
    }

    /**
     * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
     * <p>
     * 若无答案，则返回空字符串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * words = ["w","wo","wor","worl", "world"]
     * 输出："world"
     * 解释：
     * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
     * 示例 2：
     * <p>
     * 输入：
     * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
     * 输出："apple"
     * 解释：
     * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        Set<String> set = new TreeSet<>();
        for (String word : words) {
            if (word.length() == 1) {
                if (res.length() < word.length())
                    res = word;
                set.add(word);
            } else {
                int len = word.length() - 1;
                if (set.contains(word.substring(0, len))) {
                    if (res.length() < word.length())
                        res = word;
                    set.add(word);
                }
            }
        }
        return res;
    }

    /**
     * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aaabb", k = 3
     * 输出：3
     * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
     * 示例 2：
     * <p>
     * 输入：s = "ababbc", k = 2
     * 输出：5
     * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {

        return 0;
    }

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * "tree"
     * <p>
     * 输出:
     * "eert"
     * <p>
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * 示例 2:
     * <p>
     * 输入:
     * "cccaaa"
     * <p>
     * 输出:
     * "cccaaa"
     * <p>
     * 解释:
     * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
     * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
     * 示例 3:
     * <p>
     * 输入:
     * "Aabb"
     * <p>
     * 输出:
     * "bbAa"
     * <p>
     * 解释:
     * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
     * 注意'A'和'a'被认为是两种不同的字符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Integer, List<Character>> integerCharacterMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            List<Character> orDefault = integerCharacterMap.getOrDefault(characterIntegerEntry.getValue(), new ArrayList<>());
            orDefault.add(characterIntegerEntry.getKey());
            integerCharacterMap.put(characterIntegerEntry.getValue(), orDefault);
        }
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Integer, List<Character>>> entries = integerCharacterMap.entrySet();
        for (Map.Entry<Integer, List<Character>> entry : entries) {
            for (Character character : entry.getValue()) {
                for (Integer i = 0; i < entry.getKey(); i++) {
                    sb.append(character);
                }
            }
        }
        return sb.toString();

    }

}



