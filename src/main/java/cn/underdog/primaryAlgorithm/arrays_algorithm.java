package cn.underdog.primaryAlgorithm;

import cn.underdog.entity.TreeNode;

import java.util.*;

public class arrays_algorithm {
    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(Integer.MIN_VALUE);
//        TreeNode treeNode11 = new TreeNode(4);
//        TreeNode treeNode12 = new TreeNode(6);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode21 = new TreeNode(7);
//        treeNode1.left = treeNode11;
//        treeNode1.right = treeNode12;
//        treeNode12.left = treeNode2;
//        treeNode12.right = treeNode21;


        isValidSudoku(new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
//        romanToInt("III");
      /*  int iv = romanToInt("LVIII");
        System.out.println(iv);*/
//        boolean validBST = isValidBST(treeNode1);
//        System.out.println(validBST);
//        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
//
//        boolean anagram = isAnagram("rat", "car");
//        System.out.println(anagram);

//        int reverse = reverse(123);
//        System.out.println(reverse);

//        int leetcode = firstUniqChar("leetcode");
//        System.out.println(leetcode);
//        isValidSudoku(new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
//                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
//                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
//                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
//                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
//                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
//                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
//                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
//                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
//        });

//        int i = strStr("hello", "ll");
//        int i = strStr("aaaaa", "bba");
//        int i = strStr("mississippi", "issip");
//        int i = strStr("aaa", "aa");
//        System.out.println(i);

//        String babad = longestPalindrome("bb");
//        String babad = longestPalindrome("eabcb");
//        String babad = longestPalindrome("cbbd");
//        String babad = longestPalindrome("ccd");
//        String babad = longestPalindrome("ccc");
//        String babad = longestPalindrome("aacabdkacaa");
//        String babad = longestPalindrome("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");

//        System.out.println(babad);
//        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
//        System.out.println(palindrome);
        /*int[] intersect = intersect(new int[]{2,1}, new int[]{1,1});
        for (int i : intersect) {
            System.out.println(i);
        }*/

        /*int[] ints = plusOne(new int[]{9,9});
        for (int i : ints) {
            System.out.println(i);
        }*/

//        moveZeroes(new int[]{0,1,0,3,12});
        /*int[] ints = twoSum(new int[]{-10, -1, -18, -19}, -19);
        for (int anInt : ints) {
            System.out.println(anInt);
        }*/
//        removeDuplicates(new int[]{0,0,1, 1,1,1,1, 2,2, 3, 3,4});
//        removeDuplicates(new int[]{0, 0});
//        removeDuplicates(new int[]{1, 1, 2});
//        singleNumber(new int[]{2,2,1,1,3});
//        intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
//        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
//        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
//        System.out.println(countPrimes(999983));
//        System.out.println(countPrimes(5000000));
//        System.out.println(hammingDistance(3, 1));
//        System.out.println(hammingDistance(4, 1));
        hammingWeight(00000000000000000000000000001011);

    }


    public static int removeDuplicates(int[] nums) {

        /*TreeSet<Integer> treeSet= new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        int length = treeSet.size();
        for (int i = 0; i < nums.length; i++) {
            nums[i]= treeSet.pollFirst();
            if (treeSet.size() == 0 || treeSet == null) {
                break;
            }
        }
        return length;*/


        /*for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]>nums[i+1])
                break;
            while (nums[i] == nums[i + 1]) {
                boolean flag = false;
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
                if (!flag)
                    break;
            }
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if(nums[i]>=nums[i+1])
                break;
        }*/

        /**
         * 双指针问题:
         *      如果nums[left]==nums[right]right指针向右移动
         *      如果nums[left]！=nums[right]left,right指针都向右移东
         */
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left])
                nums[++left] = nums[right];
        }
        return ++left;

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        int[] ints = Arrays.stream(nums1).filter(num1 -> Arrays.stream(nums2).anyMatch(num2 -> num1 == num2)).toArray();
        Set<Integer> set = new HashSet<>();
        for (int anInt : ints) {
            set.add(anInt);
        }
        List<Integer> list = new ArrayList<>(set);
        int[] ans = new int[set.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int w = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j])
                j++;
            else if (nums1[i] < nums2[j])
                i++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }

        }
        int[] res = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }
        return res;


    }


    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * <p>
     *  
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int jinwei = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1 && digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                int tempCount = digits[i] + jinwei;
                if (tempCount > 9 && i != 0) {
                    digits[i] = tempCount - 10;
                } else if (tempCount > 9 && i == 0) {
                    int[] res1 = new int[digits.length + 1];
                    res1[0] = 1;
                    return res1;
                } else {
                    digits[i] = tempCount;
                    return digits;
                }
            }
        }
        return digits;
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。\
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
       /* int left = 0;
        int right = nums.length-1;
        int lleft = Integer.MIN_VALUE;
        int lright = Integer.MAX_VALUE;
        int[] nums1 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i]=nums[i];
        }
        Arrays.sort(nums);

        while (left != right) {
            if(lleft==left&&lright==right){
               return nums;
            }else {
                lleft=left;
                lright=right;
                int mid = left + (right-left +1)/2;
                if (nums[left] + nums[right] > target) {
                    right = mid;
                }else if(nums[left] + nums[right] < target)
                {
                    left=mid;
                }else {
                    break;
                }
            }
        }
        int numX= nums[left];
        int numY= nums[right];

        int[] res =new int[2];
        int w = 0;
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]==numX||nums1[i]==numY)
                res[w++]=i;
            if (w == 2) {
                break;
            }
        }*/
        List list = new ArrayList();


        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (integers.contains(num))
                return true;
            else
                integers.add(num);
        }
        return false;
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 输入: [2,2,1]
     * 输出: 1
     * <p>
     * <p>
     * 使用异或运算，将所有值进行异或
     * 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
     * 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了  (异或运算满足交换律)
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        /*HashMap<Integer,Integer> map =new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                Integer integer = map.get(num);
                map.put(num,integer+1);
            }else {
                map.put(num,1);
            }
        }
        int num = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if(entry.getValue()==1){
                num = entry.getKey();
            }
        }*/

        int reduce = 0;
        for (int num : nums) {
            reduce = reduce ^ num;
        }
        return reduce;
    }


    /**
     * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * <p>
     * 注意：
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     *  
     * 输入：board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * 输出：true
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2f9gg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {


        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1)
                        return false;
                }
            }
        }
        return true;
    }


    public static boolean isPalindrome(String s) {
        String result = s.toLowerCase();
        int left = 0;
        int right = result.length() - 1;
        while (left < right) {
            if (Character.isLetterOrDigit(result.charAt(left)) && Character.isLetterOrDigit(result.charAt(right))) {
                if (Objects.equals(result.charAt(left), result.charAt(right))) {
                    left++;
                    right--;
                    continue;
                } else
                    return false;
            }
            if (!Character.isLetterOrDigit(result.charAt(left))) {
                left++;
            }
            if (!Character.isLetterOrDigit(result.charAt(right))) {
                right--;
            }
        }
        return true;
    }

    /**
     * 实现 strStr() 函数。
     * <p>
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     * <p>
     *  
     * <p>
     * 说明：
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
     * <p>
     * <p>
     * haystack.indexOf(needle); 检索字符串2在字符串1中的位置，如果存在返回下表，不存在返回-1
     *  
     * 输入：haystack = "hello", needle = "ll"
     * 输出：2
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param haystack
     * @param needle
     * @return
     */
    // TODO 未做完。
   /* public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 1)
            return haystack.equals(needle) ? 0 : -1;
        int left = 0;
        int right = haystack.length() - 1;
        while (left < right) {
            if (!Objects.equals(haystack.charAt(left), needle.charAt(0))) {
                left++;
            }
            if (!Objects.equals(haystack.charAt(right), needle.charAt(needle.length() - 1))) {
                right--;
            }
            if (Objects.equals(haystack.charAt(left), needle.charAt(0)) && Objects.equals(haystack.charAt(right), needle.charAt(needle.length() - 1))) {
                String temp = haystack.substring(left, right + 1);
                if (temp.equals(needle)) {
                    return left;
                } else {
                    if(needle.equals(haystack.charAt(left)+""))
                        return left;

                    left++;
                    right--;
                }
            }
        }
        if(left<=right){
            String temp = haystack.substring(left, right + 1);
            if (temp.equals(needle)) {
                return left;
            } else {
                return -1;
            }
        }

        return -1;
    }*/
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int hLength = haystack.length();
        int nLength = needle.length();


        for (int i = 0; i < hLength; ) {
            int res = i;
            boolean flag = false;
            for (int j = 0; j < nLength && i < hLength; ) {
                if (Objects.equals(needle.charAt(j), haystack.charAt(i))) {
                    if (flag == false) {
                        res = i;
                        flag = true;
                    }
                    if (j == nLength - 1)
                        return res;
                    else {
                        ++i;
                        ++j;
                    }
                } else {
                    i = res + 1;
                    j = 0;
                    res++;
                    flag = false;
                }
            }
        }
        return -1;
    }

    public static boolean validPalindromic(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {

        if (s.length() == 2)
            return s.charAt(0) == s.charAt(1) ? s : s.charAt(0) + "";
        if (s.length() < 2)
            return s;

        String res = "";
        int max = Integer.MIN_VALUE;
        int length = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                boolean flag = validPalindromic(substring, 0, substring.length() - 1);
                if (flag) {
                    length = j - i;
                    if (length > max) {
                        res = s.substring(i, j + 1);
                        max = length;
                    }
                }
            }
        }
        if (res.equals("")) {
            return s.charAt(0) + "";
        }
        return res;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10)
                return 0;
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return s.indexOf(entry.getKey());
            }
        }
        return -1;
    }

    public static boolean isAnagram(String s, String t) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        TreeMap<Character, Integer> map2 = new TreeMap<>();
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        return map.equals(map2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[n + m];
        int w = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                res[w++] = nums2[j++];
            } else {
                res[w++] = nums1[i++];
            }
        }
        while (i < m) {
            res[w++] = nums1[i++];
        }
        while (j < n) {
            res[w++] = nums2[j++];
        }
        System.arraycopy(res, 0, nums1, 0, n + m);
    }

    static Long Max_Value = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;
        boolean l = isValidBST(root.left);
        if (root.val > Max_Value) {
            Max_Value = (long) root.val;
        } else {
            return false;
        }
        boolean r = isValidBST(root.right);
        return l && r;
    }


    public static boolean isValidBSTList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }

    public static void InOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            InOrder(treeNode.left, list);
            list.add(treeNode.val);
            InOrder(treeNode.right, list);
        }
    }

    public static int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ) {
            int current = 0;
            if (s.charAt(i) == 'I') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'V') {
                        current = 4;
                        i = i + 2;
                    } else if (s.charAt(i + 1) == 'X') {
                        current = 9;
                        i = i + 2;
                    } else {
                        current = 1;
                        i++;
                    }
                } else {
                    current = 1;
                    i++;
                }
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'L') {
                        current = 40;
                        i = i + 2;
                    } else if (s.charAt(i + 1) == 'C') {
                        current = 90;
                        i = i + 2;
                    } else {
                        current = 10;
                        i++;
                    }
                } else {
                    current = 10;
                    i++;
                }
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length()) {
                    if (s.charAt(i + 1) == 'D') {
                        current = 400;
                        i = i + 2;
                    } else if (s.charAt(i + 1) == 'M') {
                        current = 900;
                        i = i + 2;
                    } else {
                        current = 100;
                        i++;
                    }
                } else {
                    current = 100;
                    i++;
                }
            } else if (s.charAt(i) == 'V') {
                current = 5;
                i = i + 1;
            } else if (s.charAt(i) == 'L') {
                current = 50;
                i = i + 1;
            } else if (s.charAt(i) == 'D') {
                current = 500;
                i = i + 1;
            } else if (s.charAt(i) == 'M') {
                current = 1000;
                i = i + 1;
            }
            res += current;
        }
        return res;
    }

    public static void rotate(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[j][matrix[i].length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(res[i], 0, matrix[i], 0, res.length);
        }
    }

    public static String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int i = 0;
        OUT:
        for (; i < str.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != str.charAt(i)) {
                    break OUT;
                }
            }
        }
        return str.substring(0, i);
    }

/*    public static int countPrimes(int n) {
        int res = 0;
        if (n <= 2)
            return res;
        for (int i = 2; i < n; i++) {
            int temp = (int) Math.sqrt(i);
            boolean flag = false;
            for (int j = 2; j <= temp; j++) {
                if (i % j == 0) {
                    flag = true;
                }
            }
            if (!flag) {
                res++;
            }
        }
        return res;
    }*/

    /**
     * 先申请和n相等大小的数组，
     * 当n==2时，把 能整除2的数全部置为true
     * 当n==3时，把 能整除3的数全部置为true
     * ...
     * 在如果当前为true 则表明不是素数，否则为素数。
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int res = 0;
        if (n <= 2)
            return res;
        boolean[] flags = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (flags[i]) continue;
            res++;
            for (int u = i + i; u < n; u += i) {
                if (u % i == 0) flags[u] = true;
            }
        }
        return res;
    }

    public static int hammingDistance(int x, int y) {
        int res = 0;
        String strX = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
        String strY = String.format("%32s", Integer.toBinaryString(y)).replace(" ", "0");
        for (int i = 0; i < 32; i++) {
            if (strX.charAt(i) != strY.charAt(i))
                res++;
        }
        return res;

    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;

    }


}
